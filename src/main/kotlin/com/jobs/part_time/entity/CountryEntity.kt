package com.job.entity

import jakarta.annotation.Generated
import jakarta.persistence.*


@Entity
@Table(name = "card")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    var owner: Int,
    var cardTitle: String,
    var cardDescription: String,
    var cardDate: String,
    var cardType: String,
    var isVerified: Boolean = false,
)