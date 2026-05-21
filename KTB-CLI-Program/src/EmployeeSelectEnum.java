public enum EmployeeSelectEnum {
    EXIT(0,"종료"),
    PARTTIME(1,"직원"),
    MANAGER(2, "매니저"),
    ADMIN(3, "관리자");

    public int employNum;

    public String employName;

    EmployeeSelectEnum(int employNum, String employName){
        this.employNum = employNum;
        this.employName = employName;
    }


    public static EmployeeSelectEnum getEmployValue(int num){
        for (EmployeeSelectEnum employeeSelectEnum : values()){
            if (employeeSelectEnum.employNum == num){
                return employeeSelectEnum;
            }
        }

        return null;
    }
}
