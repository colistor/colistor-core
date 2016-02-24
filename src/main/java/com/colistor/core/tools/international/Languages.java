/*Colistor, collections and lists organizer
*Copyright (C) 2016  Colistor (Joel Favre)
*
*This program is free software: you can redistribute it and/or modify
*it under the terms of the GNU Affero General Public License as published
*by the Free Software Foundation, either version 3 of the License, or
*(at your option) any later version.
*
*This program is distributed in the hope that it will be useful,
*but WITHOUT ANY WARRANTY; without even the implied warranty of
*MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*GNU Affero General Public License for more details.
*
*You should have received a copy of the GNU Affero General Public License
*along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.colistor.core.tools.international;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class Languages.
 */
public class Languages {

    /**
     * The languages.
     */
    private Map<String, String> languages;

    /**
     * Instantiates a new languages.
     */
    public Languages() {
        languages = new TreeMap<String, String>(new ValueComparator());
        languages.put("ab", "аҧсуа бызшәа, аҧсшәа (Abkhaz)");
        languages.put("aa", "Afaraf (Afar)");
        languages.put("af", "Afrikaans (Afrikaans)");
        languages.put("ak", "Akan (Akan)");
        languages.put("sq", "Shqip (Albanian)");
        languages.put("am", "አማርኛ (Amharic)");
        languages.put("ar", "العربية (Arabic)");
        languages.put("an", "aragonés (Aragonese)");
        languages.put("hy", "Հայերեն (Armenian)");
        languages.put("as", "অসমীয়া (Assamese)");
        languages.put("av", "авар мацӀ, магӀарул мацӀ (Avaric)");
        languages.put("ae", "avesta (Avestan)");
        languages.put("ay", "aymar aru (Aymara)");
        languages.put("az", "azərbaycan dili (Azerbaijani)");
        languages.put("bm", "bamanankan (Bambara)");
        languages.put("ba", "башҡорт теле (Bashkir)");
        languages.put("eu", "euskara, euskera (Basque)");
        languages.put("be", "беларуская мова (Belarusian)");
        languages.put("bn", "বাংলা (Bengali, Bangla)");
        languages.put("bh", "भोजपुरी (Bihari)");
        languages.put("bi", "Bislama (Bislama)");
        languages.put("bs", "bosanski jezik (Bosnian)");
        languages.put("br", "brezhoneg (Breton)");
        languages.put("bg", "български език (Bulgarian)");
        languages.put("my", "ဗမာစာ (Burmese)");
        languages.put("ca", "català, valencià (Catalan, Valencian)");
        languages.put("ch", "Chamoru (Chamorro)");
        languages.put("ce", "нохчийн мотт (Chechen)");
        languages.put("ny", "chiCheŵa, chinyanja (Chichewa, Chewa, Nyanja)");
        languages.put("zh", "中文 (Zhōngwén), 汉语, 漢語 (Chinese)");
        languages.put("cv", "чӑваш чӗлхи (Chuvash)");
        languages.put("kw", "Kernewek (Cornish)");
        languages.put("co", "corsu, lingua corsa (Corsican)");
        languages.put("cr", "ᓀᐦᐃᔭᐍᐏᐣ (Cree)");
        languages.put("hr", "hrvatski jezik (Croatian)");
        languages.put("cs", "čeština, český jazyk (Czech)");
        languages.put("da", "dansk (Danish)");
        languages.put("dv", "ދިވެހި (Divehi, Dhivehi, Maldivian)");
        languages.put("nl", "Nederlands, Vlaams (Dutch)");
        languages.put("dz", "རྫོང་ཁ (Dzongkha)");
        languages.put("en", "English (English)");
        languages.put("eo", "Esperanto (Esperanto)");
        languages.put("et", "eesti, eesti keel (Estonian)");
        languages.put("ee", "Eʋegbe (Ewe)");
        languages.put("fo", "føroyskt (Faroese)");
        languages.put("fj", "vosa Vakaviti (Fijian)");
        languages.put("fi", "suomi, suomen kieli (Finnish)");
        languages.put("fr", "français, langue française (French)");
        languages.put("ff",
                "Fulfulde, Pulaar, Pular (Fula, Fulah, Pulaar, Pular)");
        languages.put("gl", "galego (Galician)");
        languages.put("ka", "ქართული (Georgian)");
        languages.put("de", "Deutsch (German)");
        languages.put("el", "ελληνικά (Greek (modern))");
        languages.put("gn", "Avañe'ẽ (Guaraní)");
        languages.put("gu", "ગુજરાતી (Gujarati)");
        languages.put("ht", "Kreyòl ayisyen (Haitian, Haitian Creole)");
        languages.put("ha", "(Hausa) هَوُسَ (Hausa)");
        languages.put("he", "עברית (Hebrew (modern))");
        languages.put("hz", "Otjiherero (Herero)");
        languages.put("hi", "हिन्दी, हिंदी (Hindi)");
        languages.put("ho", "Hiri Motu (Hiri Motu)");
        languages.put("hu", "magyar (Hungarian)");
        languages.put("ia", "Interlingua (Interlingua)");
        languages.put("id", "Bahasa Indonesia (Indonesian)");
        /*
		 * languages .put("ie",
		 * "Originally called Occidental; then Interlingue after WWII (Interlingue)"
		 * );
		 */
        languages.put("ga", "Gaeilge (Irish)");
        languages.put("ig", "Asụsụ Igbo (Igbo)");
        languages.put("ik", "Iñupiaq, Iñupiatun (Inupiaq)");
        languages.put("io", "Ido (Ido)");
        languages.put("is", "Íslenska (Icelandic)");
        languages.put("it", "italiano (Italian)");
        languages.put("iu", "ᐃᓄᒃᑎᑐᑦ (Inuktitut)");
        languages.put("ja", "日本語 (にほんご) (Japanese)");
        languages.put("jv", "basa Jawa (Javanese)");
        languages.put("kl",
                "kalaallisut, kalaallit oqaasii (Kalaallisut, Greenlandic)");
        languages.put("kn", "ಕನ್ನಡ (Kannada)");
        languages.put("kr", "Kanuri (Kanuri)");
        languages.put("ks", "कश्मीरी, كشميري‎ (Kashmiri)");
        languages.put("kk", "қазақ тілі (Kazakh)");
        languages.put("km", "ខ្មែរ, ខេមរភាសា, ភាសាខ្មែរ (Khmer)");
        languages.put("ki", "Gĩkũyũ (Kikuyu, Gikuyu)");
        languages.put("rw", "Ikinyarwanda (Kinyarwanda)");
        languages.put("ky", "Кыргызча, Кыргыз тили (Kyrgyz)");
        languages.put("kv", "коми кыв (Komi)");
        languages.put("kg", "Kikongo (Kongo)");
        languages.put("ko", "한국어, 조선어 (Korean)");
        languages.put("ku", "Kurdî, كوردی‎ (Kurdish)");
        languages.put("kj", "Kuanyama (Kwanyama, Kuanyama)");
        languages.put("la", "latine, lingua latina (Latin)");
        languages.put("lb", "Lëtzebuergesch (Luxembourgish, Letzeburgesch)");
        languages.put("lg", "Luganda (Ganda)");
        languages.put("li", "Limburgs (Limburgish, Limburgan, Limburger)");
        languages.put("ln", "Lingála (Lingala)");
        languages.put("lo", "ພາສາລາວ (Lao)");
        languages.put("lt", "lietuvių kalba (Lithuanian)");
        languages.put("lu", "Tshiluba (Luba-Katanga)");
        languages.put("lv", "latviešu valoda (Latvian)");
        languages.put("gv", "Gaelg, Gailck (Manx)");
        languages.put("mk", "македонски јазик (Macedonian)");
        languages.put("mg", "fiteny malagasy (Malagasy)");
        languages.put("ms", "bahasa Melayu, بهاس ملايو‎ (Malay)");
        languages.put("ml", "മലയാളം (Malayalam)");
        languages.put("mt", "Malti (Maltese)");
        languages.put("mi", "te reo Māori (Māori)");
        languages.put("mr", "मराठी (Marathi (Marāṭhī))");
        languages.put("mh", "Kajin M̧ajeļ (Marshallese)");
        languages.put("mn", "монгол (Mongolian)");
        languages.put("na", "Ekakairũ Naoero (Nauru)");
        languages.put("nv", "Diné bizaad, Dinékʼehǰí (Navajo, Navaho)");
        languages.put("nd", "isiNdebele (Northern Ndebele)");
        languages.put("ne", "नेपाली (Nepali)");
        languages.put("ng", "Owambo (Ndonga)");
        languages.put("nb", "Norsk bokmål (Norwegian Bokmål)");
        languages.put("nn", "Norsk nynorsk (Norwegian Nynorsk)");
        languages.put("no", "Norsk (Norwegian)");
        languages.put("ii", "ꆈꌠ꒿ Nuosuhxop (Nuosu)");
        languages.put("nr", "isiNdebele (Southern Ndebele)");
        languages.put("oc", "occitan, lenga d'òc (Occitan)");
        languages.put("oj", "ᐊᓂᔑᓈᐯᒧᐎᓐ (Ojibwe, Ojibwa)");
		/*
		 * languages .put("cu",
		 * "ѩзыкъ словѣньскъ (Old Church Slavonic, Church Slavonic, Old Bulgarian)"
		 * );
		 */
        languages.put("om", "Afaan Oromoo (Oromo)");
        languages.put("or", "ଓଡ଼ିଆ (Oriya)");
        languages.put("os", "ирон æвзаг (Ossetian, Ossetic)");
        languages.put("pa", "ਪੰਜਾਬੀ, پنجابی‎ (Panjabi, Punjabi)");
        languages.put("pi", "पाऴि (Pāli)");
        languages.put("fa", "فارسی (Persian (Farsi))");
        languages.put("pl", "język polski, polszczyzna (Polish)");
        languages.put("ps", "پښتو (Pashto, Pushto)");
        languages.put("pt", "português (Portuguese)");
        languages.put("qu", "Runa Simi, Kichwa (Quechua)");
        languages.put("rm", "rumantsch grischun (Romansh)");
        languages.put("rn", "Ikirundi (Kirundi)");
        languages.put("ro", "limba română (Romanian)");
        languages.put("ru", "русский язык (Russian)");
        languages.put("sa", "संस्कृतम् (Sanskrit (Saṁskṛta))");
        languages.put("sc", "sardu (Sardinian)");
        languages.put("sd", "सिन्धी, سنڌي، سندھی‎ (Sindhi)");
        languages.put("se", "Davvisámegiella (Northern Sami)");
        languages.put("sm", "gagana fa'a Samoa (Samoan)");
        languages.put("sg", "yângâ tî sängö (Sango)");
        languages.put("sr", "српски језик (Serbian)");
        languages.put("gd", "Gàidhlig (Scottish Gaelic, Gaelic)");
        languages.put("sn", "chiShona (Shona)");
        languages.put("si", "සිංහල (Sinhala, Sinhalese)");
        languages.put("sk", "slovenčina, slovenský jazyk (Slovak)");
        languages.put("sl", "slovenski jezik, slovenščina (Slovene)");
        languages.put("so", "Soomaaliga, af Soomaali (Somali)");
        languages.put("st", "Sesotho (Southern Sotho)");
        languages.put("es", "español, castellano (Spanish, Castilian)");
        languages.put("su", "Basa Sunda (Sundanese)");
        languages.put("sw", "Kiswahili (Swahili)");
        languages.put("ss", "SiSwati (Swati)");
        languages.put("sv", "Svenska (Swedish)");
        languages.put("ta", "தமிழ் (Tamil)");
        languages.put("te", "తెలుగు (Telugu)");
        languages.put("tg", "тоҷикӣ, toğikī, تاجیکی‎ (Tajik)");
        languages.put("th", "ไทย (Thai)");
        languages.put("ti", "ትግርኛ (Tigrinya)");
        languages.put("bo", "བོད་ཡིག (Tibetan Standard, Tibetan, Central)");
        languages.put("tk", "Türkmen, Түркмен (Turkmen)");
        languages.put("tl", "Wikang Tagalog, ᜏᜒᜃᜅ᜔ ᜆᜄᜎᜓᜄ᜔ (Tagalog)");
        languages.put("tn", "Setswana (Tswana)");
        languages.put("to", "faka Tonga (Tonga (Tonga Islands))");
        languages.put("tr", "Türkçe (Turkish)");
        languages.put("ts", "Xitsonga (Tsonga)");
        languages.put("tt", "татар теле, tatar tele (Tatar)");
        languages.put("tw", "Twi (Twi)");
        languages.put("ty", "Reo Tahiti (Tahitian)");
        languages.put("ug", "Uyƣurqə, ئۇيغۇرچە‎ (Uyghur, Uighur)");
        languages.put("uk", "українська мова (Ukrainian)");
        languages.put("ur", "اردو (Urdu)");
        languages.put("uz", "O‘zbek, Ўзбек, أۇزبېك‎ (Uzbek)");
        languages.put("ve", "Tshivenḓa (Venda)");
        languages.put("vi", "Tiếng Việt (Vietnamese)");
        languages.put("vo", "Volapük (Volapük)");
        languages.put("wa", "walon (Walloon)");
        languages.put("cy", "Cymraeg (Welsh)");
        languages.put("wo", "Wollof (Wolof)");
        languages.put("fy", "Frysk (Western Frisian)");
        languages.put("xh", "isiXhosa (Xhosa)");
        languages.put("yi", "ייִדיש (Yiddish)");
        languages.put("yo", "Yorùbá (Yoruba)");
        languages.put("za", "Saɯ cueŋƅ, Saw cuengh (Zhuang, Chuang)");
        languages.put("zu", "isiZulu (Zulu)");
    }

    /**
     * Gets the languages.
     *
     * @return the languages
     */
    public Map<String, String> getLanguages() {
        return languages;
    }

    /**
     * The Class ValueComparator.
     */
    class ValueComparator implements Comparator<String> {

        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(String a, String b) {
            return a.compareToIgnoreCase(b);
        }
    }

}
