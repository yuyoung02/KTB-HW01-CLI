
// 메인 메뉴
public enum MainMenuEnum {
    BACK(0,"뒤로 가기"),
    START(1,"출근 등록"),
    HOME(2,"퇴근 등록"),
    SEARCH(3,"직원 조회"),
    TODO(4,"할 일 조회"),
    MANAGER_SPECIAL(5, "할 일 할당");

    public final int menuNum;
    public final String menuName;

    private MainMenuEnum(int menuNum, String menuName){
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public static MainMenuEnum menuNum(int num){

        for(MainMenuEnum mainMenu : values()){
            if(mainMenu.menuNum == num){
                return mainMenu;
            }
        }
        return null;
    }

}
