package com.example.allthingsf1

class Util {

    companion object {

        @JvmStatic
        fun getCountryFlagLink(country: String): String {
            return when (country) {
                CountryCodes.ARGENTINA.country -> createLink(FlagCodes.ARGENTINA.code)
                CountryCodes.AUSTRALIA.country -> createLink(FlagCodes.AUSTRALIA.code)
                CountryCodes.AUSTRIA.country -> createLink(FlagCodes.AUSTRIA.code)
                CountryCodes.AZERBAIJAN.country -> createLink(FlagCodes.AZERBAIJAN.code)
                CountryCodes.BAHRAIN.country -> createLink(FlagCodes.BAHRAIN.code)
                CountryCodes.BELGIUM.country -> createLink(FlagCodes.BELGIUM.code)
                CountryCodes.BRAZIL.country -> createLink(FlagCodes.BRAZIL.code)
                CountryCodes.CANADA.country -> createLink(FlagCodes.CANADA.code)
                CountryCodes.CHINA.country -> createLink(FlagCodes.CHINA.code)
                CountryCodes.FRANCE.country -> createLink(FlagCodes.FRANCE.code)
                CountryCodes.GERMANY.country -> createLink(FlagCodes.GERMANY.code)
                CountryCodes.HUNGARY.country -> createLink(FlagCodes.HUNGARY.code)
                CountryCodes.INDIA.country -> createLink(FlagCodes.INDIA.code)
                CountryCodes.ITALY.country -> createLink(FlagCodes.ITALY.code)
                CountryCodes.JAPAN.country -> createLink(FlagCodes.JAPAN.code)
                CountryCodes.MALAYSIA.country -> createLink(FlagCodes.MALAYSIA.code)
                CountryCodes.MEXICO.country -> createLink(FlagCodes.MEXICO.code)
                CountryCodes.MONACO.country -> createLink(FlagCodes.MONACO.code)
                CountryCodes.MOROCCO.country -> createLink(FlagCodes.MOROCCO.code)
                CountryCodes.NETHERLANDS.country -> createLink(FlagCodes.NETHERLANDS.code)
                CountryCodes.PORTUGAL.country -> createLink(FlagCodes.PORTUGAL.code)
                CountryCodes.RUSSIA.country -> createLink(FlagCodes.RUSSIA.code)
                CountryCodes.SINGAPORE.country -> createLink(FlagCodes.SINGAPORE.code)
                CountryCodes.SOUTH_AFRICA.country -> createLink(FlagCodes.SOUTH_AFRICA.code)
                CountryCodes.KOREA.country -> createLink(FlagCodes.KOREA.code)
                CountryCodes.SPAIN.country -> createLink(FlagCodes.SPAIN.code)
                CountryCodes.SWEDEN.country -> createLink(FlagCodes.SWEDEN.code)
                CountryCodes.SWITZERLAND.country -> createLink(FlagCodes.SWITZERLAND.code)
                CountryCodes.TURKEY.country -> createLink(FlagCodes.TURKEY.code)
                CountryCodes.UAE.country -> createLink(FlagCodes.UAE.code)
                CountryCodes.UK.country -> createLink(FlagCodes.UK.code)
                CountryCodes.USA.country -> createLink(FlagCodes.USA.code)
                else -> ""
            }
        }

        @JvmStatic
        fun getMonthCode(month: Int): String {
            return when (month) {
                1 -> "Jan"
                2 -> "Feb"
                3 -> "Mar"
                4 -> "Apr"
                5 -> "May"
                6 -> "Jun"
                7 -> "Jul"
                8 -> "Aug"
                9 -> "Sep"
                10 -> "Oct"
                11 -> "Nov"
                12 -> "Dec"
                else -> ""
            }
        }

        @JvmStatic
        fun createLink(code: String): String {
            return "https://www.countryflags.io/$code/shiny/64.png"
        }

        @JvmStatic
        fun getModifiedDate(date: String): String {
            val splitString = date.split("-")
            val month = getMonthCode(splitString[1].toInt())
            return "${splitString[2]} $month"
        }

    }

}
