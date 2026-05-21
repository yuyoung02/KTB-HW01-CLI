import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 직원들 정보 관련 클래스
class MemberInfo {

    // 직원 목록
    protected List<String> members = new ArrayList<>();

    // 매니저 목록
    protected List<String> managers = new ArrayList<>();

    // 출근 기록
    protected HashMap<String, String> startWorkTime = new HashMap<>();

    // 할 일
    protected HashMap<String, List<String>> todoList = new HashMap<>();

}
