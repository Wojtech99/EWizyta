package com.example.ewizyta.doctor;

import java.util.ArrayList;
import java.util.List;

public enum Specialization {
    ALLERGOLOGY("Alergologia"),
    ANAESTHESIOLOGY_AND_INTENSIVE_CARE("Anestezjologia i intensywna terapia"),
    ANGIOLOGY("Angiologia"),
    AUDIOLOGY_AND_PHONIATRICS("Audiologia i foniatria"),
    BALNEOLOGY_AND_PHYSICAL_MEDICINE("Balneologia i medycyna fizykalna"),
    CHILDRENS_SURGERY("Chirurgia dziecięca"),
    THORACIC_SURGERY("Chirurgia klatki piersiowej"),
    VASCULAR_SURGERY("Chirurgia naczyniowa"),
    GENERAL_SURGERY("Chirurgia ogólna"),
    ONCOLOGICAL_SURGERY("Chirurgia onkologiczna"),
    PLASTIC_SURGERY("Chirurgia plastyczna"),
    MAXILLOFACIAL_SURGERY("Chirurgia szczękowo-twarzowa"),
    LUNG_DISEASES("Choroby płuc"),
    CHILDRENS_LUNG_DISEASES("Choroby płuc dzieci"),
    DISEASES_INTERNAL_MEDICINE("Choroby wewnętrzne"),
    INFECTIOUS_DISEASES("Choroby zakaźne"),
    DERMATOLOGY_AND_VENEREOLOGY("Dermatologia i wenerologia"),
    DIABETOLOGY("Diabetologia"),
    LABORATORY_DIAGNOSTICS("Diagnostyka laboratoryjna"),
    ENDOCRINOLOGY("Endokrynologia"),
    GYNECOLOGICAL_ENDOCRINOLOGY_AND_REPRODUCTION("Endokrynologia ginekologiczna i rozrodczość"),
    PEDIATRIC_ENDOCRINOLOGY_AND_DIABETOLOGY("Endokrynologia i diabetologia dziecięca"),
    EPIDEMIOLOGY("Epidemiologia"),
    CLINICAL_PHARMACOLOGY("Farmakologia kliniczna"),
    GASTROENTEROLOGY("Gastroenterologia"),
    PEDIATRIC_GASTROENTEROLOGY("Gastroenterologia dziecięca"),
    CLINICAL_GENETICS("Genetyka kliniczna"),
    GERIATRICS("Geriatria"),
    ONCOLOGICAL_GYNECOLOGY("Ginekologia onkologiczna"),
    HEMATOLOGY("Hematologia"),
    CLINICAL_HYPERTENSIOLOGY("Immunologia kliniczna"),
    INTENSIVE_CARE("Intensywna terapia"),
    CARDIAC_SURGERY("Kardiochirurgia"),
    CARDIOLOGY("Kardiologia"),
    PEDIATRIC_CARDIOLOGY("Kardiologia dziecięca"),
    AVIATION_MEDICINE("Medycyna lotnicza"),
    MARINE_AND_TROPICAL_MEDICINE("Medycyna morska i tropikalna"),
    OCCUPATIONAL_MEDICINE("Medycyna pracy"),
    EMERGENCY_MEDICINE("Medycyna ratunkowa"),
    FAMILY_MEDICINE("Medycyna rodzinna"),
    FORENSIC_MEDICINE("Medycyna sądowa"),
    SPORTS_MEDICINE("Medycyna sportowa"),
    MEDICAL_MICROBIOLOGY("Mikrobiologia lekarska"),
    NEPHROLOGY("Nefrologia"),
    PEDIATRIC_NEPHROLOGY("Nefrologia dziecięca"),
    NEONATAL_NEUROLOGY("Neonatologia"),
    NEUROSURGERY("Neurochirurgia"),
    NEUROLOGY("Neurologia"),
    PEDIATRIC_NEUROLOGY("Neurologia dziecięca"),
    NEUROPATHOLOGY("Neuropatologia"),
    OPHTHALMOLOGY("Okulistyka"),
    PEDIATRIC_ONCOLOGY_AND_HEMATOLOGY("Onkologia i hematologia dziecięca"),
    CLINICAL_ONCOLOGY("Onkologia kliniczna"),
    ORTHOPEDICS_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_SYSTEM("Ortopedia i traumatologia narządu ruchu"),
    OTORHINOLARYNGOLOGY("Otorynolaryngologia"),
    PEDIATRIC_OTORHINOLARYNGOLOGY("Otorynolaryngologia dziecięca"),
    PATHOMORPHOLOGY("Patomorfologia"),
    PAEDIATRICS("Pediatria"),
    METABOLIC_PEDIATRICS("Pediatria metaboliczna"),
    PERINATOLOGY("Perinatologia"),
    OBSTETRICS_AND_GYNECOLOGY("Położnictwo i ginekologia"),
    PSYCHIATRY("Psychiatria"),
    CHILD_AND_PSYCHIATRY_YOUTH("Psychiatria dzieci i młodzieży"),
    RADIOLOGY_AND_DIAGNOSTIC_IMAGING("Radiologia i diagnostyka obrazowa"),
    ONCOLOGICAL_RADIOTHERAPY("Radioterapia onkologiczna"),
    MEDICAL_REHABILITATION("Rehabilitacja medyczna"),
    RHEUMATOLOGY("Reumatologia"),
    SEXOLOGY("Seksuologia"),
    CLINICAL_TOXICOLOGY("Toksykologia kliniczna"),
    CLINICAL_TRANSFUSION_MEDICINE("Transfuzjologia kliniczna"),
    CLINICAL_TRANSPLANTOLOGY("Transplantologia kliniczna"),
    UROLOGY("Urologia"),
    PEDIATRIC_UROLOGY("Urologia dziecięca"),
    PUBLIC_HEALTH("Zdrowie publiczne");

    private final String description;

    Specialization(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public static List<String> getSpecializationsDescription() {
        List<String> descriptionList = new ArrayList<>();

        for (Specialization specialization : Specialization.values()) {
            descriptionList.add(specialization.getDescription());
        }

        return descriptionList;
    }

    public static Specialization getSpecializationByDescription(String description) {
        for (Specialization specialization : Specialization.values()) {
            if (specialization.description.equals(description)) {
                return specialization;
            }
        }

        return null;
    }
}
