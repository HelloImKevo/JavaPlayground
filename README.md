# Java Playground
Playground for basic Java utilities.

# Apache NetBeans IDE 11.3 Setup
How this project was started:  
* Click New Project.  
* Select 'Java with Maven'.  
* Specify the Project Name, base java package, and other required fields.  
* Specify the `src` directory as the home for 'Source Packages'.  

Code was developed using Java Version 1.8  

## Git Workflow References

Useful git commands for quickly traversing repos:  
```
# Display your git configuration
git config --list
git config --global -l

# Display all remote branches
git branch --remote

# Concise view of git history
git log --oneline

# Visual graph of git history
git log --oneline --graph --all --decorate --abbrev-commit

# See how many lines of code you've changed
git diff --shortstat

# Pushing from a local repository to GitHub hosted remote
git remote add origin git@github.com:USERNAME/REPO-NAME.git

# Clone your fork to your local machine
git clone git@github.com:USERNAME/FORKED-PROJECT.git

# Creating a new remote branch
git checkout master
git pull
git checkout -b pr-new-feature
git push -u origin pr-new-feature

# Remove a git ignored file that is being tracked
git rm -r --cached .
git add .

# Stash your local changes
git add .
git stash save "Implement a new whizbang feature"
git stash apply stash@{1}

# Preview your stashed changes
git stash list
git stash show -p stash@{1}

# Un-commit and stage changes from most recent commit
git reset --soft HEAD~1
```

## GitHub Standard Fork & Pull Request Workflow  
* Github pull request reviews documentation: https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/about-pull-request-reviews  
* Useful link about project forks: https://gist.github.com/Chaser324/ce0505fbed06b947d962  
* Great YouTube video tutorial "Creating a Simple Github Pull Request" by Jake Vanderplas: https://www.youtube.com/watch?v=rgbCcBNZcdQ  

```
# List all remote pull requests
git ls-remote origin 'pull/*/head'

# Fetch a specific pull request into a local branch and with a custom name
git fetch origin pull/50/head:pr-new-feature

# Fetch a pull request from a fork repo and patch it as a local branch
git fetch git@github.com:username/ForkedPaymentApp.git refs/pull/50/head:pr-forked-feature
```
