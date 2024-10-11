package com.job.entity

import jakarta.annotation.Generated
import jakarta.persistence.*


@Entity
@Table(name = "card")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val owner: Int,
    val cardTitle: String,
    val cardDescription: String,
    val cardDate: String,
    val cardType: String,
    val isVerified: Boolean = false,
)