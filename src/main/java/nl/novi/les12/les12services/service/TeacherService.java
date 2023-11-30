package nl.novi.les12.les12services.service;

import nl.novi.les12.les12services.dto.TeacherDto;
import nl.novi.les12.les12services.model.Teacher;
import nl.novi.les12.les12services.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository repos;

    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.firstName);
        teacher.setLastName(teacherDto.lastName);
        teacher.setDob(teacherDto.dob);
        repos.save(teacher);
        teacherDto.id = teacher.getId();

        return teacherDto;
    }
}
