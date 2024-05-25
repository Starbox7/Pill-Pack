package com.demoserver.demoserver.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "warning")
public class WarningModel {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String uuid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prescription_uuid", nullable = false)
  private PrescriptionModel prescription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "target_medicine_uuid", nullable = false)
  private MedicineModel targetMedicine;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warning_medicine_uuid", nullable = true)
  private MedicineModel warningMedicine;

  @Column(name = "warning_medicine_description", nullable = true, length = 255)
  private String warningMedicineDescription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warning_patient_uuid", nullable = true)
  private PatientModel warningPatient;

  @Column(name = "warning_patient_description", nullable = true, length = 255)
  private String warningPatientDescription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warning_disease_uuid", nullable = true)
  private DiseaseModel warningDisease;

  @Column(name = "warning_disease_description", nullable = true, length = 255)
  private String warningDiseaseDescription;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime created;

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime updated;
}
