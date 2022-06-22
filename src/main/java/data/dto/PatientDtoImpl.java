//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data.dto;

public class PatientDtoImpl implements PatientDto{
    private String firstName;
    private String lastName;
    private String patientId;
    private String doctorId;

    //konstruktør
   /* public PatientDtoImpl(String firstName, String lastName, String patientId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientId = patientId;
    */

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
    this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
    this.lastName = lastName;
    }

    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public void setPatientId(String patientId) {
    this.patientId = patientId;
    }


    @Override
    public String getDoctorId() { return doctorId;}

    @Override
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}


