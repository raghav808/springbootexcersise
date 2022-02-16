start java -jar D:\STS\workspaces\HCL_Tasks\springexercise\API_Gateway\CompanyEmployeeEurekaService\target\CompanyEmployeeEurekaService-0.0.1-SNAPSHOT.jar
timeout 3
start java -jar -Dserver.port=7771 D:\STS\workspaces\HCL_Tasks\springexercise\API_Gateway\CompanyEmployeeGateway\target\CompanyEmployeeGateway-0.0.1-SNAPSHOT.jar
timeout 3
start java -jar -Dserver.port=7772 D:\STS\workspaces\HCL_Tasks\springexercise\API_Gateway\CompanyService\target\CompanyService-0.0.1-SNAPSHOT.jar
timeout 3
start java -jar -Dserver.port=7773 D:\STS\workspaces\HCL_Tasks\springexercise\API_Gateway\CompanyService\target\CompanyService-0.0.1-SNAPSHOT.jar
timeout 3
start java -jar -Dserver.port=7774 D:\STS\workspaces\HCL_Tasks\springexercise\API_Gateway\EmployeeService\target\EmployeeService-0.0.1-SNAPSHOT.jar
timeout 3
start java -jar -Dserver.port=7775 D:\STS\workspaces\HCL_Tasks\springexercise\API_Gateway\EmployeeService\target\EmployeeService-0.0.1-SNAPSHOT.jar