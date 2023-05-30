package com.transaction.employehealthdata.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "employe_health_date")
public class Healthdetails {
    @Id()
    @Column(name="ins_id")
    int insurenceId;
    @Column(name="ins_provider")
    String insurenceProvider;
    @Column(name = "ins_amount")
    String insurenceCoveramount;


}
