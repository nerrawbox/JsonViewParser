package com.dev.nerrawbox.jsonviewparser.model.dataManager

interface IDataManager {

    interface IMovie {
        var title: String
        var director: String
        var description: String
        var producer: String
        var releaseDate: String
        var rtScore: String
    }

    interface IPeople {
        var name: String
        var gender: String
        var age: String
        var eyeColor: String
        var hairColor: String
    }
}