public class GitDashboard {

    public static void main(String[] args) {
        GitCommandRunner runner = new GitCommandRunner();

        // is Git repository
        String isGitRepo = runner.run("git rev-parse --is-inside-work-tree");


        if (isGitRepo.equals("true")) {

            System.out.println("--- My Git Dashboard ---");

            String currentBranch = runner.run("git branch --show-current");
            System.out.println("\uD83C\uDF35 Current Branch: " + currentBranch);
            System.out.println();
            System.out.println("🔨 Recent Commits:");
            String recentCommits = runner.run("git log -n 5 --oneline");
            System.out.println(recentCommits);


        } else {

            System.out.println("Error: This is not a Git repository.");
        }
    }
}