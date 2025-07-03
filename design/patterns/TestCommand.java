package design.patterns;

public class TestCommand {
    public static void main(String[] args) {
        AdminCommandExecutor adminCommandExecutor = new AdminCommandExecutor();
        Command restartCommand = new RestartCommand(new VmService(), "121");
        Command logOffCommand = new LogOffCommand(new SessionService(), "user1");
        adminCommandExecutor.submit(restartCommand);
        adminCommandExecutor.submit(logOffCommand);
    }
}

class AdminCommandExecutor{
    void submit(Command command){
        command.execute();
    }
}
interface Command {
    void execute();
}

class RestartCommand implements Command {
    private VmService vmService;
    private String vmId;

    public RestartCommand(VmService vmService, String vmId) {
        this.vmService = vmService;
        this.vmId = vmId;
    }

    @Override
    public void execute() {
        vmService.restartVm(vmId);
    }
}

class LogOffCommand implements Command {
    private SessionService sessionService;
    private String userId;

    public LogOffCommand(SessionService sessionService, String userId) {
        this.sessionService = sessionService;
        this.userId = userId;
    }

    @Override
    public void execute() {
        sessionService.logOffSession(userId);
    }
}

class VmService {
    void restartVm(String vmId) {
        System.out.println("Restarting Vm: " + vmId);
    }
}

class SessionService {
    void logOffSession(String userId) {
        System.out.println("Logging off user");
    }
}
