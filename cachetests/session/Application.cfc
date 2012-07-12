component{
    this.name = "sessiontest";
    this.sessionManagement = true;
    this.sessionStorage = "membaseCache";
    this.sessionTimeout = createTimeSpan(0,0,0,30);
    this.sessionCluster = true;
}