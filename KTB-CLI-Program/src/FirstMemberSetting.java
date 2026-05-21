import java.util.ArrayList;
import java.util.List;

class FirstMemberSetting {

    private final MemberInfo memberInfo;

    FirstMemberSetting(MemberInfo memberInfo){
        this.memberInfo = memberInfo;
    }

    private final String[] firstMembers
            = {"keryn","vinny","sellina","huey","jun","justin"};

    private final String[] firstManagers
            = {"kevin","doyi"};

    void setting(){
        for (String member : firstMembers){
            memberInfo.members.add(member);
        }

        for (String manager : firstManagers){
            memberInfo.managers.add(manager);
        }

        setTodo();
    }

    // 할 일 초기 세팅
    void setTodo(){
        for (String memName : memberInfo.members){
            List<String> works = new ArrayList<>();
            memberInfo.todoList.put(memName,works);
        }
        for (String memName : memberInfo.managers){
            List<String> works = new ArrayList<>();
            memberInfo.todoList.put(memName,works);
        }
    }

}
