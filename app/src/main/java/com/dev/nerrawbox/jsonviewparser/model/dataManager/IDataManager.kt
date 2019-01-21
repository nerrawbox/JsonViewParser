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

    interface IDataClassManager {
        fun getDetail1() : String = ""
        fun getDetail2() : String = ""
        fun getDetail3() : String = ""
        fun getDetail4() : String = ""
        fun getDetail5() : String = ""
        fun getDetail6() : String = ""
    }
}