package com.job.entity

import com.jobs.part_time.entity.CityEntity
import jakarta.annotation.Generated
import jakarta.persistence.*


@Entity
@Table(name = "card")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    var population: Int = 0,
    //@OneToMany(mappedBy = "country",fetch = FetchType.EAGER)
     @OneToMany(mappedBy = "country")
    var cities: List<CityEntity> = emptyList(),
)