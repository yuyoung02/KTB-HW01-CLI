import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main  {
    static Scanner sc = new Scanner(System.in);

    static Boss memberManage = new Boss();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 초기 세팅
        memberManage.members.add("kevin");
        memberManage.members.add("keryn");
        memberManage.members.add("vinny");
        memberManage.members.add("sellina");
        memberManage.members.add("huey");
        memberManage.members.add("jun");
        memberManage.members.add("justin");

        memberManage.setTodo();


        starter();

        MainMenu();

    }


    // 이름 입력
    static String name(){
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();

        return name;
    }

    // 오늘 날짜 출력
    static String today(){

        // 현재 날짜 구하기
        LocalDate dateNow = LocalDate.now();

        // 포맷
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formatedDate = dateNow.format(formattedDate);

        return formatedDate;
    }

    static void starter(){
        Member memberManage = new Member();
        System.out.println("========== 직원 근무 관리 시스템 ==========");
        System.out.println("오늘은 " + today() + " 입니다.");
        System.out.println("======================================");
    }

    // 메인 메뉴 메소드
    static int MainMenu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1. 출근 등록");
        System.out.println("2. 퇴근 등록");
        System.out.println("3. 직원 조회");
        System.out.println("4. 할 일 조회");
        System.out.println("5. 관리자 메뉴");
        System.out.println("6. 종료");


        System.out.print("이동할 메뉴를 선택하세요 → ");

        int selectedMainMenu = sc.nextInt();

        switch (selectedMainMenu){
            case 1:{
                System.out.println("============= 출근 등록 메뉴 =============");
                String name = name();

                memberManage.goToWork(name);
                System.out.println("=======================================");
                selectedMainMenu = MainMenu();
                break;

            }
            case 2:{
                System.out.println("============= 퇴근 등록 메뉴 =============");
                String name = name();

                memberManage.goToHome(name);
                System.out.println("=======================================");
                selectedMainMenu = MainMenu();
                break;
            }
            case 3:{
                memberManage.searchMem();
                selectedMainMenu = MainMenu();
                break;
            }
            case 4:{
                memberManage.todo();
                break;
            }
            case 5:{
                startBossMenu();
                break;

            }
            case 6:{
                System.out.println("=========== 시스템을 종료합니다 ===========");
                break;
            }
            default: {
                System.out.println("다시 선택하십시오.");
                selectedMainMenu = MainMenu();
            }
        }

        return selectedMainMenu;
    }

    // 관리자 메뉴 시작 메소드
    static void startBossMenu(){
        System.out.println("============== 관리자 메뉴 ==============");
        System.out.print("1. 직원 추가\n2. 직원 삭제\n3. 할 일 할당\n4. 뒤로 가기\n이동할 메뉴를 선택하세요 → ");

        int menu = sc.nextInt();

        switch (menu){
            case 1:{
                memberManage.addMem();
                break;
            }
            case 2:{
                memberManage.deleteMem();
                break;
            }
            case 3:{
                memberManage.assignWork();
                break;
            }
            case 4:{
                System.out.println("=======================================");
                Main.MainMenu();;
                break;
            }
            default:{
                System.out.println("다시 선택하세요.");
                Main.MainMenu();
                break;
            }
        }
    }

}
