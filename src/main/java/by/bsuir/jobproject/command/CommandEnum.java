package by.bsuir.jobproject.command;

import by.bsuir.jobproject.command.impl.*;
import by.bsuir.jobproject.command.impl.employer.*;
import by.bsuir.jobproject.command.impl.jobseeker.*;
import by.bsuir.jobproject.command.impl.resume.*;
import by.bsuir.jobproject.command.impl.user.*;
import by.bsuir.jobproject.command.impl.vacancy.*;

/**
 * Created by AR on 29.04.2017.
 */
public enum CommandEnum {

    TO_LOGIN {
        {
            this.command = new ToLoginCommand();
        }
    },
    TO_REGISTER {
        {
            this.command = new ToRegisterCommand();
        }
    },

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    VIEW_USERS {
        {
            this.command = new UserListCommand();
        }
    },
    CREATE_USER {
        {
            this.command = new CreateUserCommand();
        }
    },
    UPDATE_USER {
        {
            this.command = new UpdateUserCommand();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }
    },
    TO_CREATE_USER {
        {
            this.command = new ToCreateUserCommand();
        }
    },
    TO_UPDATE_USER {
        {
            this.command = new ToUpdateUserCommand();
        }
    },

    VIEW_VACANCIES {
        {
            this.command = new VacancyListCommand();
        }
    },
    TO_CREATE_VACANCY {
        {
            this.command = new ToCreateVacancyCommand();
        }
    },
    TO_UPDATE_VACANCY {
        {
            this.command = new ToUpdateVacancyCommand();
        }
    },
    CREATE_VACANCY {
        {
            this.command = new CreateVacancyCommand();
        }
    },
    UPDATE_VACANCY {
        {
            this.command = new UpdateVacancyCommand();
        }
    },
    DELETE_VACANCY {
        {
            this.command = new DeleteVacancyCommand();
        }
    },


    VIEW_RESUMES {
        {
            this.command = new ResumeListCommand();
        }
    },
    CREATE_RESUME {
        {
            this.command = new CreateResumeCommand();
        }
    },
    UPDATE_RESUME {
        {
            this.command = new UpdateResumeCommand();
        }
    },
    DELETE_RESUME {
        {
            this.command = new DeleteResumeCommand();
        }
    },
    TO_CREATE_RESUME {
        {
            this.command = new ToCreateResumeCommand();
        }
    },
    TO_UPDATE_RESUME {
        {
            this.command = new ToUpdateResumeCommand();
        }
    },

    VIEW_JOBSEEKERS {
        {
            this.command = new JobseekerListCommand();
        }
    },
    CREATE_JOBSEEKER {
        {
            this.command = new CreateJobseekerCommand();
        }
    },
    UPDATE_JOBSEEKER {
        {
            this.command = new UpdateJobseekerCommand();
        }
    },
    DELETE_JOBSEEKER {
        {
            this.command = new DeleteJobseekerCommand();
        }
    },
    TO_CREATE_JOBSEEKER {
        {
            this.command = new ToCreateJobseekerCommand();
        }
    },
    TO_UPDATE_JOBSEEKER {
        {
            this.command = new ToUpdateJobseekerCommand();
        }
    }, VIEW_EMPLOYERS {
        {
            this.command = new EmployerListCommand();
        }
    },
    CREATE_EMPLOYER {
        {
            this.command = new CreateEmployerCommand();
        }
    },
    UPDATE_EMPLOYER {
        {
            this.command = new UpdateEmployerCommand();
        }
    },
    DELETE_EMPLOYER {
        {
            this.command = new DeleteEmployerCommand();
        }
    },
    TO_CREATE_EMPLOYER {
        {
            this.command = new ToCreateEmployerCommand();
        }
    },
    TO_UPDATE_EMPLOYER {
        {
            this.command = new ToUpdateEmployerCommand();
        }
    },
    CREATE_DOCUMENT {
        {
            this.command = new CreateDocument();
        }
    };

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }

}
