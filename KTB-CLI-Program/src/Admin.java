import java.util.ArrayList;
import java.util.List;

public class Admin extends Manager{

    // 최대 직원 수
    static final int maxMem = 15;

    Admin(MemberInfo memberInfo) {
        super(memberInfo);
    }


    @Override
    // 할 일 할당 메소드
    void assignWork(){

        allMemSearch();

        System.out.print("할 일을 할당할 직원 이름을 입력하세요 → ");

        String assignName = super.sc.next();

        if(memberInfo.managers.contains(assignName) || memberInfo.members.contains(assignName)){

            for (TodoEnum todoEnum : TodoEnum.values()){
                System.out.println(todoEnum.menuNum +". " + todoEnum.menuName);
            };

            System.out.println("=======================================");
            System.out.print("할당 할 일의 번호을 고르세요 → ");

            String todo = super.sc.next();

            int todoNum;

            try {
                todoNum = Integer.parseInt(todo);
                TodoEnum todoName = TodoEnum.getTodo(todoNum);

                if(todoName == null){
                    System.out.println("잘못 고르셨습니다.");
                    System.out.println("=======================================");
                }else {
                    switch (todoName){
                        case WRITE_TIL, HW, CONNECT_ZEP, MENTORING: {
                            memberInfo.todoList.get(assignName).add(todoName.getMenuName());
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요. 처음으로 돌아갑니다.");
                System.out.println("=======================================");
            }
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");
            System.out.println("=======================================");
        }

        System.out.println("=======================================");


    }

    // 직원 추가 메소드
    void addMem(){

        System.out.println("============= 직원 추가 메뉴 =============");
        System.out.print("추가할 직원의 이름을 입력하세요: ");

        String memName = super.sc.next();


        System.out.print("이름: " + memName + "\n맞습니까? (Y | N): ");
        String ans = super.sc.next();

        switch (ans) {
            case "y":
            case "Y":{
                if(memberInfo.members.contains(memName) || memberInfo.managers.contains(memName)){
                    System.out.println("이미 존재하는 직원입니다.");
                    Main.startBossMenu();
                } else {
                    System.out.println("1. "+ EmployeeSelectEnum.MANAGER.employName);
                    System.out.println("2. "+ EmployeeSelectEnum.PARTTIME.employName);
                    System.out.print("추가할 형태의 숫자를 선택하세요: ");
                    int employNum = super.sc.nextInt();
                    int currentMem = memberInfo.managers.size() + memberInfo.members.size();
                    switch (employNum){
                        case 1:{
                            if(currentMem < this.maxMem){
                                memberInfo.managers.add(memName);
                                List<String> works = new ArrayList<>();
                                memberInfo.todoList.put(memName,works);
                                System.out.println("저장 되었습니다!");
                                System.out.println("=======================================");
                            } else {
                                System.out.println("더이상 직원을 추가할 수 없습니다. 삭제를 먼저 진행하십시오.");
                            }
                            break;
                        }
                        case 2:{
                            if(currentMem < this.maxMem){
                                memberInfo.members.add(memName);
                                List<String> works = new ArrayList<>();
                                memberInfo.todoList.put(memName,works);
                                System.out.println("저장 되었습니다!");
                                System.out.println("=======================================");
                            } else {
                                System.out.println("더이상 직원을 추가할 수 없습니다. 삭제를 먼저 진행하십시오.");
                            }
                        }
                    }

                }
                break;
            }
            case "n":
            case "N":{
                System.out.println("처음으로 돌아갑니다.");

                break;
            }
            default:{
                System.out.println("다시 선택하세요.");
                break;
            }

        }

    }

    // 직원 삭제 메소드
    void deleteMem(){
        System.out.println("============= 직원 삭제 메뉴 =============");
        System.out.print("삭제할 직원의 이름을 입력하세요: ");

        String memName = super.sc.next();

        System.out.print("이름: " + memName + "\n맞습니까? (Y | N): ");
        String ans = super.sc.next();

        switch (ans) {
            case "y":
            case "Y":{
                if(memberInfo.members.contains(memName)){
                    // 모든 기록 삭제
                    memberInfo.members.remove(memName);
                    memberInfo.todoList.remove(memName);
                    memberInfo.startWorkTime.remove(memName);

                    System.out.println("일반 직원 "+ memName + "님이 삭제되었습니다.");
                    System.out.println("=======================================");
                } else if(memberInfo.managers.contains(memName)){
                    // 모든 기록 삭제
                    memberInfo.managers.remove(memName);
                    memberInfo.todoList.remove(memName);
                    memberInfo.startWorkTime.remove(memName);

                    System.out.println("매니저 "+ memName + "님이 삭제되었습니다.");
                    System.out.println("=======================================");
                } else {
                    System.out.println("해당 직원이 없습니다.");
                    System.out.println("=======================================");
                }

                break;
            }
            case "n":
            case "N":{
                System.out.println("처음으로 돌아갑니다.");
                System.out.println("=======================================");
                break;
            }
            default:{
                System.out.println("다시 선택하세요.");
                System.out.println("=======================================");
                break;
            }

        }

    }


}
