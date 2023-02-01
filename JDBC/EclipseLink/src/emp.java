public class emp {
    private int empNo;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private double sal;
    private double comm;
    private int deptNo;

    
    //constructor default
    public emp() {
    }

    //custom constructor
    public emp(int empNo, String ename, String job, int mgr, String hiredate, double sal, double comm, int deptNo) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }
    //getters and setters
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getMgr() {
        return mgr;
    }
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }
    public String getHiredate() {
        return hiredate;
    }
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public double getComm() {
        return comm;
    }
    public void setComm(double comm) {
        this.comm = comm;
    }
    public int getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
}
