package com.sageit.hms.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="doctors")
public class Doctor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(nullable=false, unique=true)
        private String email;

        @Column(length=15, nullable=false)
        private String password;

        @Column(length=50, nullable=false, name="first_name")
        private String firstName;

        @Column(length=50, nullable=false, name="last_name")
        private String lastName;

        @Column(length=10, nullable=false, name="telno")
        private String telno;

        @Column(length=150, nullable=false, name="description")
        private String description;

        @ManyToMany
        @JoinTable(
                name="doctor_qualification",
                joinColumns = @JoinColumn(name="doctor_id") ,
                inverseJoinColumns = @JoinColumn(name="qualification_id")
        )
        private Set<Qualification> qualifications=new HashSet<>();

        @ManyToOne
        @JoinColumn(name="doctor_category_id")
        private DoctorCategory doctorCategory;

        public DoctorCategory getDoctorCategory() {
            return doctorCategory;
        }

        public void setDoctorCategory(DoctorCategory doctorCategory) {
            this.doctorCategory = doctorCategory;
        }

        @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
        @JoinColumn(name="vehicle_id",referencedColumnName = "id")
        private Vehicle vehicle;

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        public String getTelno() {
            return telno;
        }

        public void setTelno(String telno) {
            this.telno = telno;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }
        /*
            public void setPassword(String password) {
                this.password = password;
            }
        */

        public void setPassword(String password) {
            this.password = "Abcd1234#";
        }


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Doctor{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }

        public Doctor(){}
        public Doctor(String email, String password, String firstName, String lastName, String telno, String description) {
            this.email = email;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            this.telno = telno;
            this.description = description;
        }

        public Set<Qualification> getQualifications() {
            return qualifications;
        }

        public void setQualifications(Set<Qualification> qualifications) {
            this.qualifications = qualifications;
        }

        public void addQualification(Qualification qualification){
                this.qualifications.add(qualification);
        }

        public void removeQualification(Qualification qualification){
            this.qualifications.remove(qualification);
        }

}
