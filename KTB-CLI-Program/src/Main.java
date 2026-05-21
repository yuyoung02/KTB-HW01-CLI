import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main  {

    static MemberInfo memberInfo = new MemberInfo();

    static Member member = new Member(memberInfo);

    static Manager manager = new Manager(memberInfo);

    static Admin admin = new Admin(memberInfo);

    static FirstMemberSetting firstMemberSetting = new FirstMemberSetting(memberInfo);

    public static void main(String[] args){

        // 초기 세팅
        firstMemberSetting.setting();

        // 시스템 시작
        starter();

        // 메인 메뉴 시작
        EmployMenu();

    }


    // 이름 입력
    static String name(){
        System.out.print("이름을 입력하세요: ");
        String name = admin.sc.next();

        return name;
    }

    // 오늘 날짜 출력
    static String today(){

        // 현재 날짜 구하기
        LocalDate dateNow = LocalDate.now();

        // 포맷
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        return dateNow.format(formattedDate);
    }

    static void starter(){
        System.out.println("========== 직원 근무 관리 시스템 ==========");
        System.out.println("오늘은 " + today() + " 입니다.");
    }

    // 직원 형태 선택 메소드
    static void EmployMenu(){

        while (true){
            System.out.println("=======================================");
            for (EmployeeSelectEnum employeeSelectEnum : EmployeeSelectEnum.values()){
                System.out.println(employeeSelectEnum.employNum + ". " + employeeSelectEnum.employName);
            }

            System.out.print("직원 형태를 선택하세요 → ");

            String selectedMenu= admin.sc.next();

            int selectedEmploy;

            // 숫자아닌 입력처리
            try {
                selectedEmploy = Integer.parseInt(selectedMenu);
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            EmployeeSelectEnum selectEmployMenu = EmployeeSelectEnum.getEmployValue(selectedEmploy);

            // 종료
            if(selectEmployMenu == EmployeeSelectEnum.EXIT){
                System.out.println("=========== 시스템을 종료합니다 ===========");
                break;
            }

            // 잘못된 숫자 입력
            if (selectEmployMenu == null){
                System.out.println("다시 선택하십시오.");
                continue;
            }

            switch (selectEmployMenu){
                case PARTTIME : {
                    MemberMenu(false);
                    break;
                }
                case MANAGER: {
                    MemberMenu(true);
                    break;
                }
                case ADMIN: {
                    startBossMenu();
                    break;
                }
            }



        }
    }
    // 직원 메뉴 메소드
    static void MemberMenu(boolean isManager){

        while (true){
            System.out.println("============== 직원 메뉴 ==============");
            for (MainMenuEnum mainMenu : MainMenuEnum.values()){
                if (!isManager && mainMenu == MainMenuEnum.MANAGER_SPECIAL){
                    continue;
                }
                System.out.println(mainMenu.menuNum + ". " + mainMenu.menuName);
            }

            System.out.print("이동할 메뉴를 선택하세요 → ");

            String selectedMenu= admin.sc.next();

            int selectedNum;

            // 숫자아닌 입력처리
            try {
                selectedNum = Integer.parseInt(selectedMenu);
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            MainMenuEnum selectedMainMenu = MainMenuEnum.menuNum(selectedNum);

            // 뒤로 가기 처리
            if(selectedMainMenu == MainMenuEnum.BACK){
                break;
            }

            // 매니저 아닌데 5번 눌렀을때 처리
            if (!isManager) {
                if (selectedMainMenu == MainMenuEnum.MANAGER_SPECIAL){
                    System.out.println("권한이 없습니다.");
                    continue;
                } else if(selectedMainMenu == MainMenuEnum.START){
                    String name = name();
                    member.goToWork(name);
                    continue;
                } else if (selectedMainMenu == MainMenuEnum.HOME){
                    String name = name();
                    member.goToHome(name);
                    continue;
                } else if (selectedMainMenu == MainMenuEnum.SEARCH){
                    member.searchMem();
                    continue;
                }

            }

            // 잘못된 숫자 입력
            if (selectedMainMenu == null){
                System.out.println("다시 선택하십시오.");
                continue;
            }

            switch (selectedMainMenu){
                case START:{
                    System.out.println("============= 출근 등록 메뉴 =============");
                    String name = name();
                    admin.goToWork(name);
                    break;
                }
                case HOME:{
                    System.out.println("============= 퇴근 등록 메뉴 =============");
                    String name = name();
                    admin.goToHome(name);
                    break;
                }
                case SEARCH:{
                    admin.allMemSearch();
                    break;
                }
                case TODO:{
                    admin.todo();
                    break;
                }
                case MANAGER_SPECIAL:{
                    manager.assignWork();
                    break;
                }

            }

        }

    }


    // 관리자 메뉴
    static void startBossMenu(){

        while (true){
            System.out.println("============== 관리자 메뉴 ==============");
            for(AdminMenuEnum adminMenu : AdminMenuEnum.values()){
                System.out.println(adminMenu.AdminNum + ". " + adminMenu.AdminMenu);
            }

            System.out.print("이동할 메뉴를 선택하세요 → ");

            String menuSelected = admin.sc.next();
            int menu;

            try{
                menu = Integer.parseInt(menuSelected);
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            AdminMenuEnum adminMenu = AdminMenuEnum.menuNum(menu);

            // 뒤로 가기 선택
            if (adminMenu == AdminMenuEnum.BACK){
                break;
            }

            // 잘못된 숫자 선택
            if (adminMenu== null){
                System.out.println("다시 선택하세요.");
                continue;
            }

            switch (adminMenu){
                case ADD_MEMBER : {
                    admin.addMem();
                    break;
                }
                case DELETE_MEMBER: {
                    admin.deleteMem();
                    break;
                }
                case SEARCH_MEMBER: {
                    manager.allMemSearch();
                    break;
                }
                case ASSIGN_WORK: {
                    admin.assignWork();
                    break;
                }

            }
        }


    }

}
