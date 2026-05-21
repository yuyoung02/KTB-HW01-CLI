
// 관리자 메뉴
public enum AdminMenuEnum {
    BACK(0, "뒤로가기"),
    ADD_MEMBER(1,"직원 추가"),
    DELETE_MEMBER(2, "직원 삭제"),
    SEARCH_MEMBER(3,"직원 조회"),
    ASSIGN_WORK(4, "할 일 할당");

    public final int AdminNum;
    public final String AdminMenu;

    private AdminMenuEnum(int AdminNum, String AdminMenu){
        this.AdminNum = AdminNum;
        this.AdminMenu = AdminMenu;
    }


    public static AdminMenuEnum menuNum(int num){
        for(AdminMenuEnum adminMenu : values()){
            if(num == adminMenu.AdminNum){
                return adminMenu;
            }
        }
        return null;
    }


}
