# [Class] FileChangeDetector
* * *
## 1. Code Review
> 데이터 전달 방식 오류


## 2. Navigation
* [Source Code](#3-source-code)
* [getInstance()](#5-getinstance)
* [FileChangeDetector()](#6-filechangedetector)
* [addOpenVirtualFile(VirtualFile virtualFile)](#7-addopenvirtualfilevirtualfile-virtualfile)
* [checkCommit(VirtualFile virtualFile)](#8-checkcommitvirtualfile-virtualfile)
* [checkFileSize(VirtualFile file)](#9-checkfilesizevirtualfile-file)
* [getChangeFileList(Project project)](#10-getchangefilelistproject-project)
* [gitCommit(AnActionEvent e)](#11-gitcommitanactionevent-e)
* [vcsConnect(AnActionEvent e)](#12-vcsconnectanactionevent-e)
* [fileCloseNotification(Project project, String filePath)](#13-fileclosenotificationproject-project-string-filepath)
* [showNotification(Project project, long size, String filePath)](#14-shownotificationproject-project-long-size-string-filepath)
* [vcsNotification(Project project)](#15-vcsnotificationproject-project)
* [printMap()](#16-printmap)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 파일 변경을 감지하고 사용자에게 커밋을 추천하는 역할을 하는 클래스입니다. 코드는 주어진 파일의 크기를 저장하고, 파일의 변경을 검사하여 알림을 보여줍니다. 사용자는 해당 알림을 통해 커밋을 할 수 있습니다.
//
//다음은 코드 검토를 통해 개선할 수 있는 점들입니다:
//- 주석이 부족하며 코드의 목적과 동작 방식을 충분히 설명하지 않습니다.
//- 코드의 가독성을 높이기 위해 메서드와 변수의 네이밍을 개선해야 합니다.
//- 중복된 System.out.println 구문들을 제거해야 합니다.
//- 메서드들의 가독성을 개선하기 위해 작은 기능 단위로 분리해야 합니다.
public final class FileChangeDetector {

    public static final String NOTIFICATION_GROUP_ID = "com.mobilesuit.clientplugin.alert.commitRecommand";
    private static Map<String, Long> fileLength = new HashMap<>(); // 선택 된적 있는(열려있을 뿐만아니라 보거나,수정한 파일) 파일의 길이를 저장
    private static Map<String, Integer> isNotification = new HashMap<>(); // 특정 파일에 대해 알림을 다시 보내도 되는지 확인하는 목록
    private static int fileChangeSize = 700;
    //private static Map<String,Integer> NoVcsProject = new HashMap<>();

    private static FileChangeDetector instance = new FileChangeDetector();
    public static FileChangeDetector getInstance(){
        return instance;
    }
    private FileChangeDetector(){
    }
    public void addOpenVirtualFile(VirtualFile virtualFile){ // map에 사이즈를 등록

        String filePath = virtualFile.getPath();
        System.out.println("seleced file getPath : " + virtualFile.getPath());
        System.out.println("seleced file getName : " + virtualFile.getName());

        fileLength.put(filePath, virtualFile.getLength()); //사이즈를 등록
    }
    public void checkCommit(VirtualFile virtualFile){

        Project project = ProjectUtil.guessProjectForFile(virtualFile);
        List<VirtualFile>changedFileList =  getChangeFileList(project); //리스트 받아와서 지금 닫히는 파일이 이 리스트 상에 있을때만 알림을 보내준다.
        if(changedFileList.size() == 0){
            System.out.println("null");
            return; //알림을 주지 않는다.
        }
        System.out.println("changedFileList size : "+changedFileList.size());
        changedFileList.forEach((file) ->{
            if(file.getPath().equals(virtualFile.getPath())){
//                System.out.println("name : " + file.getPath());
//                System.out.println("vir : " + virtualFile.getPath());
                fileCloseNotification(project,virtualFile.getPath());
                return;
            }
        });
        fileLength.remove(virtualFile.getPath());
    }
    public void checkFileSize(VirtualFile file){

        //파일을 연후 일정량 이상의 변경이 생기면 알림을 준다.
        //중간에 커밋이 발생하면 ...여튼 맵의 용량을 기준으로 알림을 준다.
        String filePath = file.getPath();
        if(fileLength.get(file.getPath()) == null) {
            return;
        }
        Project project = ProjectUtil.guessProjectForFile(file);
        if (fileLength.get(filePath) + fileChangeSize <= file.getLength() || fileLength.get(filePath) - fileChangeSize >= file.getLength()) {
            System.out.println(fileLength.get(filePath) + " " + file.getLength());
            showNotification(project, file.getLength(), filePath);

        }
    }
    public List<VirtualFile> getChangeFileList( Project project){ //커밋되어야할 파일리스트 반환
        List<VirtualFile> virtualFileList = new ArrayList<>();
        if(project ==null){return virtualFileList;}

        ProjectLevelVcsManager vcsManager = ProjectLevelVcsManager.getInstance(project);
        ChangeListManager changeListManager = ChangeListManager.getInstance(project);

        if (vcsManager.hasActiveVcss()) {
            List<LocalChangeList> localChange = changeListManager.getChangeLists();
            LocalChangeList changeList = localChange.get(0);
            for (Change change : changeList.getChanges()) {
                virtualFileList.add(change.getVirtualFile());
            }
        } else {
            System.out.println("사용중인 VCS가 없습니다.");
            //System.out.println("No active VCS configured in the project.");
            System.out.println(project.getBasePath());
            vcsNotification(project);
            //알림을 보낸후 yes하면 등록하는 페이지로 연결
            //no more message하면 해당 프로젝트에 대해 더이상 알림을 주지 않는다.
        }
        return virtualFileList;
    }
    public static void gitCommit(AnActionEvent e){ // 사용자가 커밋할수있도록한다.
        Project project = e.getProject();
        if (project != null) {
            e.getActionManager().getAction("Git.Commit.Stage").actionPerformed(e);
        }
    }
    public static void vcsConnect(AnActionEvent e){
        Project project = e.getProject();
        if (project != null ){//&& NoVcsProject.get(project.getBasePath())==null) {
            e.getActionManager().getAction("Vcs.QuickListPopupAction").actionPerformed(e);
        }
    }
    public static void fileCloseNotification(Project project,String filePath) {
        String title = "Commit Recommandation";
        String content = "커밋 하시겠습니까 ?\n" + filePath;
        Notification notification = new Notification(FileChangeDetector.NOTIFICATION_GROUP_ID,title, content, NotificationType.INFORMATION);

        // "Yes" action
        notification.addAction(new NotificationAction("Commit") {
            @Override
            public void actionPerformed(AnActionEvent e, Notification notification) {
                gitCommit(e); // commit
                notification.expire();
            }
        });
        // "No" action
        notification.addAction(new NotificationAction("Next") {
            @Override
            public void actionPerformed(AnActionEvent e, Notification notification) {
                notification.expire();
            }
        });
        Notifications.Bus.notify(notification, project);
    }
    public static void showNotification(Project project, long size,String filePath) {

        String title = "Commit Recommandation";
        String content = "커밋 하시겠습니까 ?\n" + filePath;

        Notification notification = new Notification(FileChangeDetector.NOTIFICATION_GROUP_ID, title, content, NotificationType.INFORMATION);

        // "Yes" action
        notification.addAction(new NotificationAction("Commit") {
            @Override
            public void actionPerformed(AnActionEvent e, Notification notification) {
                gitCommit(e); // commit
                notification.expire();
            }
        });
        // "No" action
        notification.addAction(new NotificationAction("Next") {
            @Override
            public void actionPerformed(AnActionEvent e, Notification notification) {
                notification.expire();
            }
        });
        fileLength.replace(filePath, size); // 일단 업데이트해, 알림창을 무시했어도 계속알림을 받을수있도록
        Notifications.Bus.notify(notification, project);
    }
    public static void vcsNotification(Project project) {

        String title = "Vcs Setting";
        String content = "Vcs가 설정 되어있지 않습니다. \n 설정하시겠습니까?";

        Notification notification = new Notification(FileChangeDetector.NOTIFICATION_GROUP_ID, title, content, NotificationType.INFORMATION);
        // "Yes" action
        notification.addAction(new NotificationAction("Yes") {
            @Override
            public void actionPerformed(AnActionEvent e, Notification notification) {
                vcsConnect(e);
                notification.expire();
            }
        });
        // "No" action
        notification.addAction(new NotificationAction("Next") {
            @Override
            public void actionPerformed(AnActionEvent e, Notification notification) {
                //NoVcsProject.put(e.getProject().getBasePath(),1);
                notification.expire();
            }
        });
        Notifications.Bus.notify(notification, project);
    }


    public void printMap(){
        System.out.println("print Map : ");
        fileLength.forEach((filePath, length) -> {
            System.out.println(filePath + " : " + length);
        });
        System.out.println();
    }
}

 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
@Service
public final class FileChangeDetector {

    public static final String NOTIFICATION_GROUP_ID = "com.mobilesuit.clientplugin.alert.commitRecommend";
    private static Map<String, Long> fileLength = new HashMap<>();
    private static Map<String, Integer> isNotification = new HashMap<>();
    private static int fileChangeSize = 700;

    private static FileChangeDetector instance = new FileChangeDetector();

    public static FileChangeDetector getInstance(){
        return instance;
    }
  
    private FileChangeDetector(){
    }
  
    public void addOpenVirtualFile(VirtualFile virtualFile){
        String filePath = virtualFile.getPath();
        fileLength.put(filePath, virtualFile.getLength());
    }
  
    public void checkCommit(VirtualFile virtualFile){
        // 커밋되어야 하는 파일 목록 받아와서 현재 닫히는 파일이 목록에 있는지 확인
        // 목록이 비어 있다면 알림을 보내지 않음
        // 파일 닫는 알림을 보낸 후, 해당 파일의 정보를 제거
    }
  
    public void checkFileSize(VirtualFile file){
        // 파일이 열린 후에 일정 크기 이상의 변경이 생기면 알림을 보냄
        // 알림을 보내기 전에 파일의 크기를 업데이트
    }
  
    public List<VirtualFile> getChangeFileList(Project project){
        // 커밋되어야 할 파일 목록 반환
        // 현재 프로젝트에 사용중인 버전 관리 시스템(VCS)이 없는 경우에도 처리
    }
  
    public static void gitCommit(AnActionEvent e){
        // 사용자가 커밋할 수 있도록 함
    }
  
    public static void vcsConnect(AnActionEvent e){
        // VCS 설정 페이지로 연결
    }
  
    public static void fileCloseNotification(Project project, String filePath){
        // 파일 닫음 알림을 보냄
        // 알림의 'Yes' 액션은 커밋을 수행하고 알림을 닫음
        // 알림의 'No' 액션은 알림을 닫음
    }
  
    public static void showNotification(Project project, long size, String filePath){
        // 커밋 추천 알림을 보냄
        // 알림의 'Yes' 액션은 커밋을 수행하고 알림을 닫음
        // 알림의 'No' 액션은 알림을 닫음
        // 알림을 무시해도 계속 알림을 받을 수 있도록 파일 정보를 업데이트
    }
  
    public static void vcsNotification(Project project){
        // VCS 설정이 되어 있지 않을 때 알림을 보냄
        // 알림의 'Yes' 액션은 VCS 설정 페이지로 연결
        // 알림의 'No' 액션은 알림을 닫음
    }

    public void printMap(){
        // 파일 크기 맵 출력 (디버깅용)
    }
}
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`String`|`NOTIFICATION_GROUP_ID`
2 |`Map<String, Long>`|`fileLength`
3 |`Map<String, Integer>`|`isNotification`
4 |`int`|`fileChangeSize`
5 |`FileChangeDetector`|`instance`


## 5. getInstance()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 6. FileChangeDetector()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 7. addOpenVirtualFile(VirtualFile virtualFile)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`VirtualFile`|`virtualFile`

## 8. checkCommit(VirtualFile virtualFile)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`VirtualFile`|`virtualFile`

## 9. checkFileSize(VirtualFile file)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`VirtualFile`|`file`

## 10. getChangeFileList(Project project)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`Project`|`project`

## 11. gitCommit(AnActionEvent e)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`AnActionEvent`|`e`

## 12. vcsConnect(AnActionEvent e)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`AnActionEvent`|`e`

## 13. fileCloseNotification(Project project, String filePath)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`Project`|`project`
2 |`String`|`filePath`

## 14. showNotification(Project project, long size, String filePath)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`Project`|`project`
2 |`long`|`size`
3 |`String`|`filePath`

## 15. vcsNotification(Project project)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`Project`|`project`

## 16. printMap()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

* * *
