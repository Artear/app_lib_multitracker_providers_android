package com.artear.multitracker.providers.comscore


interface ComscoreCredentials {

    val publisherId: String
    val publisherSecret: String
    val applicationName: String
    val persistentLabel: String
}