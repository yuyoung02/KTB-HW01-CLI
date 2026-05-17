import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Boss extends PartTime  {

    // 최대 직원 수
    int maxMem = 10;

    Scanner sc = new Scanner(System.in);

    // 직원 추가 메소드
    void addMem(){

        System.out.println("============= 직원 추가 메뉴 =============");
        System.out.print("추가할 직원의 이름을 입력하세요: ");

        String memName = sc.next();


        System.out.print("이름: " + memName + "\n맞습니까? (Y | N): ");
        String ans = sc.next();

        switch (ans) {
            case "y":
            case "Y":{
                if(members.contains(memName)){
                    System.out.println("이미 존재하는 직원입니다.");
                    Main.startBossMenu();
                } else {
                    if(members.size() < this.maxMem){
                        members.add(memName);
                        List<String> works = new ArrayList<>();
                        super.todoList.put(memName,works);
                        System.out.println("저장 되었습니다!");
                        System.out.println("=======================================");
                    } else {
                        System.out.println("더이상 직원을 추가할 수 없습니다. 삭제를 먼저 진행하십시오.");
                    }
                    Main.MainMenu();
                }
                break;
            }
            case "n":
            case "N":{
                System.out.println("처음으로 돌아갑니다.");
                Main.startBossMenu();
                break;
            }
            default:{
                System.out.println("다시 선택하세요.");
                Main.MainMenu();
                break;
            }

        }

    }

    // 직원 삭제 메소드
    void deleteMem(){
        System.out.println("============= 직원 삭제 메뉴 =============");
        System.out.print("삭제할 직원의 이름을 입력하세요: ");

        String memName = sc.next();

        System.out.print("이름: " + memName + "\n맞습니까? (Y | N): ");
        String ans = sc.next();

        switch (ans) {
            case "y":
            case "Y":{
                if(members.contains(memName)){
                    // 모든 기록 삭제
                    super.members.remove(memName);
                    super.todoList.remove(memName);
                    super.startWorkTime.remove(memName);

                    System.out.println("삭제되었습니다.");
                    System.out.println("=======================================");
                    Main.MainMenu();
                } else {
                    System.out.println("해당 직원이 없습니다.");
                    Main.startBossMenu();
                }

                break;
            }
            case "n":
            case "N":{
                System.out.println("처음으로 돌아갑니다.");
                Main.startBossMenu();
                break;
            }
            default:{
                System.out.println("다시 선택하세요.");
                Main.MainMenu();
                break;
            }

        }

    }

    // 할 일 할당 메소드
    void assignWork(){

        super.searchMem();

        System.out.print("할 일을 할당할 직원 이름을 입력하세요 → ");

        String assignName = sc.next();

        if(super.members.contains(assignName)){
            System.out.println("1. TIL 작성하기\n2. 과제하기\n3. ZEP 접속하기\n4. 멘토링 진행하기");
            System.out.print("할당 할 일의 번호을 고르세요 → ");

            int todoNum = sc.nextInt();
            System.out.println("=======================================");

            switch (todoNum){
                case 1:{
                    super.todoList.get(assignName).add("TIL 작성하기");
                    Main.MainMenu();
                    break;
                }
                case 2:{
                    super.todoList.get(assignName).add("과제하기");
                    Main.MainMenu();
                    break;
                }
                case 3:{
                    super.todoList.get(assignName).add("ZEP 접속하기");
                    Main.MainMenu();
                    break;
                }
                case 4:{
                    super.todoList.get(assignName).add("멘토링 진행하기");
                    Main.MainMenu();
                    break;
                }
                default:{
                    System.out.println("잘못 고르셨습니다.");
                    Main.startBossMenu();
                    break;
                }
            }
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");
            Main.startBossMenu();
        }


    }
}
