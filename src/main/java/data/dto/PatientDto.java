//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data.dto;

public interface PatientDto {
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getPatientId();
    void setPatientId(String patientId);
    String getDoctorId();
    void setDoctorId(String doctorId);

}
