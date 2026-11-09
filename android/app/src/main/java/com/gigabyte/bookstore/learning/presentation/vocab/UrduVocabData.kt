package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object UrduVocabData {
    private val chunk1 = listOf(
        VocabItem(
            id = "ur_vocab_1",
            category = VocabCategory.FAMILY,
            singularTarget = "والد",
            singularBnPron = "ওয়ালিদ",
            pluralTarget = "والد",
            pluralBnPron = "ওয়ালিদ",
            bnMeaning = "বাবা / পিতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_2",
            category = VocabCategory.FAMILY,
            singularTarget = "والدہ",
            singularBnPron = "ওয়ালিদা",
            pluralTarget = "والدائیں",
            pluralBnPron = "ওয়ালিদায়াঁ",
            bnMeaning = "মা / মাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_3",
            category = VocabCategory.FAMILY,
            singularTarget = "بیٹا",
            singularBnPron = "বেটা",
            pluralTarget = "بیٹے",
            pluralBnPron = "বেটে",
            bnMeaning = "ছেলে / পুত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_4",
            category = VocabCategory.FAMILY,
            singularTarget = "بیٹی",
            singularBnPron = "বেটি",
            pluralTarget = "میٹیاں",
            pluralBnPron = "বেটিয়াঁ",
            bnMeaning = "মেয়ে / কন্যা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_5",
            category = VocabCategory.FAMILY,
            singularTarget = "بھائی",
            singularBnPron = "ভাই",
            pluralTarget = "بھائی",
            pluralBnPron = "ভাই",
            bnMeaning = "ভাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_6",
            category = VocabCategory.FAMILY,
            singularTarget = "بہن",
            singularBnPron = "বহেন",
            pluralTarget = "بہنیں",
            pluralBnPron = "বহেনেঁ",
            bnMeaning = "বোন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_7",
            category = VocabCategory.FAMILY,
            singularTarget = "دادا",
            singularBnPron = "দাদা",
            pluralTarget = "دادا",
            pluralBnPron = "দাদা",
            bnMeaning = "দাদা / নানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_8",
            category = VocabCategory.FAMILY,
            singularTarget = "دادی",
            singularBnPron = "দাদি",
            pluralTarget = "دادیاں",
            pluralBnPron = "দাদিয়াঁ",
            bnMeaning = "দাদি / নানি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_9",
            category = VocabCategory.FAMILY,
            singularTarget = "پوتا",
            singularBnPron = "পোতা",
            pluralTarget = "پوتے",
            pluralBnPron = "পোতে",
            bnMeaning = "নাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_10",
            category = VocabCategory.FAMILY,
            singularTarget = "پوتی",
            singularBnPron = "পোতি",
            pluralTarget = "پوتیاں",
            pluralBnPron = "পোতিয়াঁ",
            bnMeaning = "নাতনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_11",
            category = VocabCategory.FAMILY,
            singularTarget = "چچا",
            singularBnPron = "চাচা",
            pluralTarget = "چچا",
            pluralBnPron = "চাচা",
            bnMeaning = "চাচা / মামা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_12",
            category = VocabCategory.FAMILY,
            singularTarget = "چچی",
            singularBnPron = "চাচি",
            pluralTarget = "چچیاں",
            pluralBnPron = "চাচিয়াঁ",
            bnMeaning = "চাচি / খালা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_13",
            category = VocabCategory.FAMILY,
            singularTarget = "بھتیجا",
            singularBnPron = "ভতিজা",
            pluralTarget = "بھتیجے",
            pluralBnPron = "ভতিজে",
            bnMeaning = "ভাতিজা / ভাগ্নে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_14",
            category = VocabCategory.FAMILY,
            singularTarget = "بھتیجی",
            singularBnPron = "ভতিজি",
            pluralTarget = "بھتیجیاں",
            pluralBnPron = "ভতিজিয়াঁ",
            bnMeaning = "ভাতিজি / ভাগ্নি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_15",
            category = VocabCategory.FAMILY,
            singularTarget = "چچا زاد بھائی",
            singularBnPron = "চচাযাদ ভাই",
            pluralTarget = "چچا زاد بھائی",
            pluralBnPron = "চচাযাদ ভাই",
            bnMeaning = "চাচাতো ভাই/বোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_16",
            category = VocabCategory.FAMILY,
            singularTarget = "شوہر",
            singularBnPron = "শওহর",
            pluralTarget = "شوہر",
            pluralBnPron = "শওহর",
            bnMeaning = "স্বামী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_17",
            category = VocabCategory.FAMILY,
            singularTarget = "بیوی",
            singularBnPron = "বিবি",
            pluralTarget = "بیویاں",
            pluralBnPron = "বিবিয়াঁ",
            bnMeaning = "স্ত্রী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_18",
            category = VocabCategory.FAMILY,
            singularTarget = "بچہ",
            singularBnPron = "বাচ্চা",
            pluralTarget = "بچے",
            pluralBnPron = "বাচ্চে",
            bnMeaning = "সন্তান / শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_19",
            category = VocabCategory.FAMILY,
            singularTarget = "شیر خوار",
            singularBnPron = "শীর খোয়ার",
            pluralTarget = "شیر خوار",
            pluralBnPron = "শীর খোয়ার",
            bnMeaning = "নবজাতক শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_20",
            category = VocabCategory.FAMILY,
            singularTarget = "والدین",
            singularBnPron = "ওয়ালিদাইন",
            pluralTarget = "والدین",
            pluralBnPron = "ওয়ালিদাইন",
            bnMeaning = "বাবা-মা (অভিভাবক)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_21",
            category = VocabCategory.FAMILY,
            singularTarget = "لڑکا",
            singularBnPron = "লড়কা",
            pluralTarget = "لڑکے",
            pluralBnPron = "লড়কে",
            bnMeaning = "ছেলে / বালক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_22",
            category = VocabCategory.FAMILY,
            singularTarget = "لड़की",
            singularBnPron = "লড়কী",
            pluralTarget = "لڑکیاں",
            pluralBnPron = "লড়কিয়াঁ",
            bnMeaning = "মেয়ে / বালিকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_23",
            category = VocabCategory.FAMILY,
            singularTarget = "مرد",
            singularBnPron = "মর্দ",
            pluralTarget = "مرد",
            pluralBnPron = "মর্দ",
            bnMeaning = "পুরুষ / ব্যক্তি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_24",
            category = VocabCategory.FAMILY,
            singularTarget = "عورت",
            singularBnPron = "আওরত",
            pluralTarget = "عورتیں",
            pluralBnPron = "আওরতেঁ",
            bnMeaning = "নারী / মহিলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_25",
            category = VocabCategory.FAMILY,
            singularTarget = "دوست",
            singularBnPron = "দোস্ত",
            pluralTarget = "دوست",
            pluralBnPron = "দোস্ত",
            bnMeaning = "বন্ধু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_26",
            category = VocabCategory.FAMILY,
            singularTarget = "پڑوسی",
            singularBnPron = "পড়োসি",
            pluralTarget = "پڑوسی",
            pluralBnPron = "পড়োসি",
            bnMeaning = "প্রতিবেশী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_27",
            category = VocabCategory.FAMILY,
            singularTarget = "مہمان",
            singularBnPron = "মেহমান",
            pluralTarget = "مہمان",
            pluralBnPron = "মেহমান",
            bnMeaning = "অতিথি / মেহমান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_28",
            category = VocabCategory.FAMILY,
            singularTarget = "ساتھی",
            singularBnPron = "সাথী",
            pluralTarget = "ساتھی",
            pluralBnPron = "সাথী",
            bnMeaning = "সহকর্মী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_29",
            category = VocabCategory.FAMILY,
            singularTarget = "ہم جماعت",
            singularBnPron = "হম জামায়াত",
            pluralTarget = "ہم جماعت",
            pluralBnPron = "হম জামায়াত",
            bnMeaning = "সহপাঠী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_30",
            category = VocabCategory.FAMILY,
            singularTarget = "استاد",
            singularBnPron = "উস্তাদ",
            pluralTarget = "اساتذہ",
            pluralBnPron = "অসাতেজাহ",
            bnMeaning = "শিক্ষক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_31",
            category = VocabCategory.FAMILY,
            singularTarget = "طالب علم",
            singularBnPron = "তালিব এ এলম",
            pluralTarget = "طلباء",
            pluralBnPron = "তুলাবা",
            bnMeaning = "ছাত্র / শিক্ষার্থী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_32",
            category = VocabCategory.FAMILY,
            singularTarget = "خاندان",
            singularBnPron = "খানদান",
            pluralTarget = "خاندان",
            pluralBnPron = "খানদান",
            bnMeaning = "পরিবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_33",
            category = VocabCategory.FAMILY,
            singularTarget = "رشتہ دار",
            singularBnPron = "রিশ্তেদার",
            pluralTarget = "رشتہ دار",
            pluralBnPron = "রিশ্তেদার",
            bnMeaning = "আত্মীয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_34",
            category = VocabCategory.FAMILY,
            singularTarget = "انسان",
            singularBnPron = "ইনসান",
            pluralTarget = "انسان",
            pluralBnPron = "ইনসান",
            bnMeaning = "মানুষ / জাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_35",
            category = VocabCategory.FAMILY,
            singularTarget = "دلہا",
            singularBnPron = "দুলহা",
            pluralTarget = "دولہے",
            pluralBnPron = "দুলহে",
            bnMeaning = "বর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_36",
            category = VocabCategory.FAMILY,
            singularTarget = "دلہن",
            singularBnPron = "দুলহন",
            pluralTarget = "دلہنیں",
            pluralBnPron = "দুলহনেঁ",
            bnMeaning = "কনে / নববধূ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_37",
            category = VocabCategory.FAMILY,
            singularTarget = "جڑواں",
            singularBnPron = "জুড়ওয়াঁ",
            pluralTarget = "جڑواں",
            pluralBnPron = "জুড়ওয়াঁ",
            bnMeaning = "যমজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_38",
            category = VocabCategory.FAMILY,
            singularTarget = "شہری",
            singularBnPron = "শহরী",
            pluralTarget = "شہری",
            pluralBnPron = "শহরী",
            bnMeaning = "নাগরিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_39",
            category = VocabCategory.FAMILY,
            singularTarget = "شخص",
            singularBnPron = "শখস",
            pluralTarget = "اشخاص",
            pluralBnPron = "আশখাস",
            bnMeaning = "ব্যক্তি / লোক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_40",
            category = VocabCategory.FAMILY,
            singularTarget = "گروہ",
            singularBnPron = "গিরোহ",
            pluralTarget = "گروہ",
            pluralBnPron = "গিরোহ",
            bnMeaning = "দল / জনগোষ্ঠী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_41",
            category = VocabCategory.FAMILY,
            singularTarget = "نوجوان",
            singularBnPron = "নওজোয়ান",
            pluralTarget = "نوجوان",
            pluralBnPron = "নওজোয়ান",
            bnMeaning = "যুবক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_42",
            category = VocabCategory.FAMILY,
            singularTarget = "بزرگ",
            singularBnPron = "বুজুর্গ",
            pluralTarget = "بزرگ",
            pluralBnPron = "বুজুর্গ",
            bnMeaning = "বয়োবৃদ্ধ / প্রবীণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_43",
            category = VocabCategory.FAMILY,
            singularTarget = "بچی",
            singularBnPron = "বাচ্চি",
            pluralTarget = "بچیاں",
            pluralBnPron = "বাচ্চিয়াঁ",
            bnMeaning = "মেয়ে শিশু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_44",
            category = VocabCategory.FAMILY,
            singularTarget = "بچہ",
            singularBnPron = "বাচ্চা",
            pluralTarget = "بچے",
            pluralBnPron = "বাচ্চে",
            bnMeaning = "ছেলে শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_45",
            category = VocabCategory.FAMILY,
            singularTarget = "منیجر",
            singularBnPron = "ম্যানেজার",
            pluralTarget = "منیجر",
            pluralBnPron = "ম্যানেজার",
            bnMeaning = "ম্যানেজার / পরিচালক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_46",
            category = VocabCategory.FAMILY,
            singularTarget = "مالک",
            singularBnPron = "মালিক",
            pluralTarget = "مالکان",
            pluralBnPron = "মালিকান",
            bnMeaning = "মালিক / কর্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_47",
            category = VocabCategory.FAMILY,
            singularTarget = "رہنما",
            singularBnPron = "রহনুমাহ",
            pluralTarget = "رہنما",
            pluralBnPron = "রহনুমাহ",
            bnMeaning = "নেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_48",
            category = VocabCategory.FAMILY,
            singularTarget = "دشمن",
            singularBnPron = "দুশমন",
            pluralTarget = "دشمن",
            pluralBnPron = "দুশমন",
            bnMeaning = "শত্রু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_49",
            category = VocabCategory.FAMILY,
            singularTarget = "جوڑا",
            singularBnPron = "জোড়া",
            pluralTarget = "جوڑے",
            pluralBnPron = "জোড়ে",
            bnMeaning = "দম্পতি / জোড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_50",
            category = VocabCategory.FAMILY,
            singularTarget = "رکن",
            singularBnPron = "রুকন",
            pluralTarget = "ارکان",
            pluralBnPron = "আরকান",
            bnMeaning = "দলপতি / সদস্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_51",
            category = VocabCategory.BODY,
            singularTarget = "سر",
            singularBnPron = "সর",
            pluralTarget = "سر",
            pluralBnPron = "সর",
            bnMeaning = "মাথা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_52",
            category = VocabCategory.BODY,
            singularTarget = "بال",
            singularBnPron = "বাল",
            pluralTarget = "بال",
            pluralBnPron = "বাল",
            bnMeaning = "চুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_53",
            category = VocabCategory.BODY,
            singularTarget = "چہرہ",
            singularBnPron = "চেহেরা",
            pluralTarget = "چہرے",
            pluralBnPron = "চেহেরে",
            bnMeaning = "মুখমণ্ডল / চেহারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_54",
            category = VocabCategory.BODY,
            singularTarget = "پیشانی",
            singularBnPron = "পেশানি",
            pluralTarget = "پیشانیاں",
            pluralBnPron = "পেশানিয়াঁ",
            bnMeaning = "কপাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_55",
            category = VocabCategory.BODY,
            singularTarget = "آنکھ",
            singularBnPron = "আঁখ",
            pluralTarget = "آنکھیں",
            pluralBnPron = "আঁখেঁ",
            bnMeaning = "চোখ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_56",
            category = VocabCategory.BODY,
            singularTarget = "ابرو",
            singularBnPron = "আবরু",
            pluralTarget = "ابروئیں",
            pluralBnPron = "আবরুয়েঁ",
            bnMeaning = "ভ্রু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_57",
            category = VocabCategory.BODY,
            singularTarget = "پلک",
            singularBnPron = "পলক",
            pluralTarget = "پلکیں",
            pluralBnPron = "পলকেঁ",
            bnMeaning = "চোখের পাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_58",
            category = VocabCategory.BODY,
            singularTarget = "کان",
            singularBnPron = "কান",
            pluralTarget = "کان",
            pluralBnPron = "কান",
            bnMeaning = "কান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_59",
            category = VocabCategory.BODY,
            singularTarget = "ناک",
            singularBnPron = "নাক",
            pluralTarget = "ناک",
            pluralBnPron = "নাক",
            bnMeaning = "নাক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_60",
            category = VocabCategory.BODY,
            singularTarget = "نتھنا",
            singularBnPron = "নথনা",
            pluralTarget = "نتھنے",
            pluralBnPron = "নথনে",
            bnMeaning = "নাকের ছিদ্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_61",
            category = VocabCategory.BODY,
            singularTarget = "منہ",
            singularBnPron = "মুঁহ",
            pluralTarget = "منہ",
            pluralBnPron = "মুঁহ",
            bnMeaning = "মুখ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_62",
            category = VocabCategory.BODY,
            singularTarget = "ہونٹ",
            singularBnPron = "হোন্ট",
            pluralTarget = "ہونٹ",
            pluralBnPron = "হোন্ট",
            bnMeaning = "ঠোঁট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_63",
            category = VocabCategory.BODY,
            singularTarget = "دانت",
            singularBnPron = "দাঁত",
            pluralTarget = "دانت",
            pluralBnPron = "দাঁত",
            bnMeaning = "দাঁত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_64",
            category = VocabCategory.BODY,
            singularTarget = "زبان",
            singularBnPron = "জবান",
            pluralTarget = "زبانیں",
            pluralBnPron = "জবানেঁ",
            bnMeaning = "জিভ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_65",
            category = VocabCategory.BODY,
            singularTarget = "ٹھوڑی",
            singularBnPron = "ঠোড়ি",
            pluralTarget = "ٹھوڑیاں",
            pluralBnPron = "ঠোড়িয়াঁ",
            bnMeaning = "চিবুক / থুতনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_66",
            category = VocabCategory.BODY,
            singularTarget = "گال",
            singularBnPron = "গাল",
            pluralTarget = "گال",
            pluralBnPron = "গাল",
            bnMeaning = "গাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_67",
            category = VocabCategory.BODY,
            singularTarget = "داڑھی",
            singularBnPron = "দাড়ি",
            pluralTarget = "داڑھیاں",
            pluralBnPron = "দাড়িয়াঁ",
            bnMeaning = "দাড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_68",
            category = VocabCategory.BODY,
            singularTarget = "مونچھ",
            singularBnPron = "মুঁছ",
            pluralTarget = "مونچھیں",
            pluralBnPron = "মুঁছেঁ",
            bnMeaning = "গোঁফ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_69",
            category = VocabCategory.BODY,
            singularTarget = "گردن",
            singularBnPron = "গর্দন",
            pluralTarget = "گردنیں",
            pluralBnPron = "গর্দনেঁ",
            bnMeaning = "ঘাড় / গলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_70",
            category = VocabCategory.BODY,
            singularTarget = "گلا",
            singularBnPron = "গলা",
            pluralTarget = "گلے",
            pluralBnPron = "গলে",
            bnMeaning = "গলা (অভ্যন্তরীণ)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_71",
            category = VocabCategory.BODY,
            singularTarget = "کندھا",
            singularBnPron = "কন্ধা",
            pluralTarget = "کندھے",
            pluralBnPron = "কন্ধে",
            bnMeaning = "কাঁধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_72",
            category = VocabCategory.BODY,
            singularTarget = "سینہ",
            singularBnPron = "সীনা",
            pluralTarget = "سینے",
            pluralBnPron = "সীনে",
            bnMeaning = "বুক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_73",
            category = VocabCategory.BODY,
            singularTarget = "پیٹھ",
            singularBnPron = "পীঠ",
            pluralTarget = "پیٹھ",
            pluralBnPron = "পীঠ",
            bnMeaning = "পিঠ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_74",
            category = VocabCategory.BODY,
            singularTarget = "بازو",
            singularBnPron = "বাজু",
            pluralTarget = "بازو",
            pluralBnPron = "বাজু",
            bnMeaning = "হাত (বাহু)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_75",
            category = VocabCategory.BODY,
            singularTarget = "کہنی",
            singularBnPron = "কোহনি",
            pluralTarget = "کہنیاں",
            pluralBnPron = "কোহনিয়াঁ",
            bnMeaning = "কনুই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_76",
            category = VocabCategory.BODY,
            singularTarget = "کلائی",
            singularBnPron = "কলাই",
            pluralTarget = "کلائیاں",
            pluralBnPron = "কলাইয়াঁ",
            bnMeaning = "কবজি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_77",
            category = VocabCategory.BODY,
            singularTarget = "ہاتھ",
            singularBnPron = "হাথ",
            pluralTarget = "ہاتھ",
            pluralBnPron = "হাথ",
            bnMeaning = "হাত (পাঞ্জা)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_78",
            category = VocabCategory.BODY,
            singularTarget = "ہتھیلی",
            singularBnPron = "হথেলি",
            pluralTarget = "ہتھیلیاں",
            pluralBnPron = "হথেলিয়াঁ",
            bnMeaning = "হাতের তালু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_79",
            category = VocabCategory.BODY,
            singularTarget = "انگلی",
            singularBnPron = "উঙ্গলি",
            pluralTarget = "انگلیاں",
            pluralBnPron = "উঙ্গলিয়াঁ",
            bnMeaning = "আঙুল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_80",
            category = VocabCategory.BODY,
            singularTarget = "انگوٹھا",
            singularBnPron = "অঙ্গুঠা",
            pluralTarget = "انگوٹھے",
            pluralBnPron = "অঙ্গুঠে",
            bnMeaning = "বুড়ো আঙুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_81",
            category = VocabCategory.BODY,
            singularTarget = "ناخن",
            singularBnPron = "নাখুন",
            pluralTarget = "ناخن",
            pluralBnPron = "নাখুন",
            bnMeaning = "নখ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_82",
            category = VocabCategory.BODY,
            singularTarget = "پیٹ",
            singularBnPron = "পেট",
            pluralTarget = "پیٹ",
            pluralBnPron = "পেট",
            bnMeaning = "পেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_83",
            category = VocabCategory.BODY,
            singularTarget = "ناف",
            singularBnPron = "নাফ",
            pluralTarget = "نافیں",
            pluralBnPron = "নাফেঁ",
            bnMeaning = "নাভি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_84",
            category = VocabCategory.BODY,
            singularTarget = "کمر",
            singularBnPron = "কমর",
            pluralTarget = "کمر",
            pluralBnPron = "কমর",
            bnMeaning = "কোমর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_85",
            category = VocabCategory.BODY,
            singularTarget = "ٹانگ",
            singularBnPron = "টাং",
            pluralTarget = "ٹانگیں",
            pluralBnPron = "টাঙেঁ",
            bnMeaning = "পা (সমগ্র পা)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_86",
            category = VocabCategory.BODY,
            singularTarget = "ران",
            singularBnPron = "রান",
            pluralTarget = "رانیں",
            pluralBnPron = "রানেঁ",
            bnMeaning = "উরু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_87",
            category = VocabCategory.BODY,
            singularTarget = "گھٹنا",
            singularBnPron = "ঘুটনা",
            pluralTarget = "گھٹنے",
            pluralBnPron = "ঘুটনে",
            bnMeaning = "হাঁটু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_88",
            category = VocabCategory.BODY,
            singularTarget = "ٹخنہ",
            singularBnPron = "টখনা",
            pluralTarget = "ٹخنے",
            pluralBnPron = "টখনে",
            bnMeaning = "গোড়ালি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_89",
            category = VocabCategory.BODY,
            singularTarget = "پاؤں",
            singularBnPron = "পাওঁ",
            pluralTarget = "پاؤں",
            pluralBnPron = "পাওঁ",
            bnMeaning = "পায়ের পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_90",
            category = VocabCategory.BODY,
            singularTarget = "پاؤں کی انگلی",
            singularBnPron = "পাওঁ কী উঙ্গলি",
            pluralTarget = "پاؤں کی انگلیاں",
            pluralBnPron = "পাওঁ কী উঙ্গলিয়াঁ",
            bnMeaning = "পায়ের আঙুল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_91",
            category = VocabCategory.BODY,
            singularTarget = "جلد",
            singularBnPron = "জিল্দ",
            pluralTarget = "جلدیں",
            pluralBnPron = "জিল্দেঁ",
            bnMeaning = "চামড়া / ত্বক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_92",
            category = VocabCategory.BODY,
            singularTarget = "ہڈی",
            singularBnPron = "হাড্ডি",
            pluralTarget = "ہڈیاں",
            pluralBnPron = "হাড্ডিয়াঁ",
            bnMeaning = "হাড়",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_93",
            category = VocabCategory.BODY,
            singularTarget = "پٹھے",
            singularBnPron = "পাট্ঠে",
            pluralTarget = "پٹھے",
            pluralBnPron = "পাট্ঠে",
            bnMeaning = "মাংসপেশি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_94",
            category = VocabCategory.BODY,
            singularTarget = "خون",
            singularBnPron = "খুন",
            pluralTarget = "خون",
            pluralBnPron = "খুন",
            bnMeaning = "রক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_95",
            category = VocabCategory.BODY,
            singularTarget = "دل",
            singularBnPron = "দিল",
            pluralTarget = "دل",
            pluralBnPron = "দিল",
            bnMeaning = "হৃদপিণ্ড / মন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_96",
            category = VocabCategory.BODY,
            singularTarget = "دماغ",
            singularBnPron = "দিমাগ",
            pluralTarget = "دماغ",
            pluralBnPron = "দিমাগ",
            bnMeaning = "মস্তিষ্ক / মগজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_97",
            category = VocabCategory.BODY,
            singularTarget = "پھیپھڑا",
            singularBnPron = "ফেফড়া",
            pluralTarget = "پھیپھڑے",
            pluralBnPron = "ফেফড়ে",
            bnMeaning = "ফুসফুস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_98",
            category = VocabCategory.BODY,
            singularTarget = "معدہ",
            singularBnPron = "মেদা",
            pluralTarget = "معدے",
            pluralBnPron = "মেদে",
            bnMeaning = "পাকস্থলী / পেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_99",
            category = VocabCategory.BODY,
            singularTarget = "جگر",
            singularBnPron = "জিগর",
            pluralTarget = "جگر",
            pluralBnPron = "জিগর",
            bnMeaning = "যকৃৎ / কলিজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_100",
            category = VocabCategory.BODY,
            singularTarget = "آواز",
            singularBnPron = "আওয়াজ",
            pluralTarget = "آوازیں",
            pluralBnPron = "আওয়াজেঁ",
            bnMeaning = "কণ্ঠস্বর",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk2 = listOf(
        VocabItem(
            id = "ur_vocab_101",
            category = VocabCategory.FOOD,
            singularTarget = "چاول",
            singularBnPron = "চাওয়াল",
            pluralTarget = "چاول",
            pluralBnPron = "চাওয়াল",
            bnMeaning = "ভাত / চাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_102",
            category = VocabCategory.FOOD,
            singularTarget = "روٹی",
            singularBnPron = "রোটি",
            pluralTarget = "روٹیاں",
            pluralBnPron = "রোটিয়াঁ",
            bnMeaning = "রুটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_103",
            category = VocabCategory.FOOD,
            singularTarget = "پانی",
            singularBnPron = "পানি",
            pluralTarget = "پانی",
            pluralBnPron = "পানি",
            bnMeaning = "পানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_104",
            category = VocabCategory.FOOD,
            singularTarget = "دودھ",
            singularBnPron = "দুধ",
            pluralTarget = "دودھ",
            pluralBnPron = "দুধ",
            bnMeaning = "দুধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_105",
            category = VocabCategory.FOOD,
            singularTarget = "چائے",
            singularBnPron = "চায়",
            pluralTarget = "چائے",
            pluralBnPron = "চায়",
            bnMeaning = "চা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_106",
            category = VocabCategory.FOOD,
            singularTarget = "کافی",
            singularBnPron = "কফি",
            pluralTarget = "کافی",
            pluralBnPron = "কফি",
            bnMeaning = "কফি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_107",
            category = VocabCategory.FOOD,
            singularTarget = "چینی",
            singularBnPron = "চিনি",
            pluralTarget = "چینی",
            pluralBnPron = "চিনি",
            bnMeaning = "চিনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_108",
            category = VocabCategory.FOOD,
            singularTarget = "نمک",
            singularBnPron = "নমক",
            pluralTarget = "نمک",
            pluralBnPron = "নমক",
            bnMeaning = "লবণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_109",
            category = VocabCategory.FOOD,
            singularTarget = "تیل",
            singularBnPron = "তেল",
            pluralTarget = "تیل",
            pluralBnPron = "তেল",
            bnMeaning = "তেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_110",
            category = VocabCategory.FOOD,
            singularTarget = "مکھن",
            singularBnPron = "মাখন",
            pluralTarget = "مکھن",
            pluralBnPron = "মাখন",
            bnMeaning = "মাখন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_111",
            category = VocabCategory.FOOD,
            singularTarget = "انڈا",
            singularBnPron = "অন্ডা",
            pluralTarget = "انڈے",
            pluralBnPron = "অন্ডে",
            bnMeaning = "ডিম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_112",
            category = VocabCategory.FOOD,
            singularTarget = "گوشت",
            singularBnPron = "গোশত",
            pluralTarget = "گوشت",
            pluralBnPron = "গোশত",
            bnMeaning = "মাংস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_113",
            category = VocabCategory.FOOD,
            singularTarget = "مرغی کا گوشت",
            singularBnPron = "মুরগী কা গোশত",
            pluralTarget = "مرغی کا گوشت",
            pluralBnPron = "মুরগী কা গোশত",
            bnMeaning = "মুরগির মাংস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_114",
            category = VocabCategory.FOOD,
            singularTarget = "گائے کا گوشت",
            singularBnPron = "গায়ে কা গোশত",
            pluralTarget = "گائے کا گوشت",
            pluralBnPron = "গায়ে কা গোশত",
            bnMeaning = "গরুর মাংস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_115",
            category = VocabCategory.FOOD,
            singularTarget = "مچھلی",
            singularBnPron = "মাছলি",
            pluralTarget = "مچھلیاں",
            pluralBnPron = "মাছলিয়াঁ",
            bnMeaning = "মাছ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_116",
            category = VocabCategory.FOOD,
            singularTarget = "سوپ",
            singularBnPron = "সুপ",
            pluralTarget = "سوپ",
            pluralBnPron = "সুপ",
            bnMeaning = "স্যুপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_117",
            category = VocabCategory.FOOD,
            singularTarget = "پنیر",
            singularBnPron = "পনির",
            pluralTarget = "پنیر",
            pluralBnPron = "পনির",
            bnMeaning = "পনির / চিজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_118",
            category = VocabCategory.FOOD,
            singularTarget = "شہد",
            singularBnPron = "শহদ",
            pluralTarget = "شہد",
            pluralBnPron = "শহদ",
            bnMeaning = "মধু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_119",
            category = VocabCategory.FOOD,
            singularTarget = "آٹا",
            singularBnPron = "আটা",
            pluralTarget = "آٹا",
            pluralBnPron = "আটা",
            bnMeaning = "ময়দা / আটা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_120",
            category = VocabCategory.FOOD,
            singularTarget = "دہی",
            singularBnPron = "দহি",
            pluralTarget = "دہی",
            pluralBnPron = "দহি",
            bnMeaning = "দই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_121",
            category = VocabCategory.FOOD,
            singularTarget = "رس",
            singularBnPron = "রস",
            pluralTarget = "رس",
            pluralBnPron = "রস",
            bnMeaning = "রস / জুস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_122",
            category = VocabCategory.FOOD,
            singularTarget = "برف",
            singularBnPron = "বর্ফ",
            pluralTarget = "برف",
            pluralBnPron = "বর্ফ",
            bnMeaning = "বরফ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_123",
            category = VocabCategory.FOOD,
            singularTarget = "کیک",
            singularBnPron = "কেক",
            pluralTarget = "کیک",
            pluralBnPron = "কেক",
            bnMeaning = "কেক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_124",
            category = VocabCategory.FOOD,
            singularTarget = "بسکٹ",
            singularBnPron = "বিস্কুট",
            pluralTarget = "بسکٹ",
            pluralBnPron = "বিস্কুট",
            bnMeaning = "বিস্কুট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_125",
            category = VocabCategory.FOOD,
            singularTarget = "مٹھائی",
            singularBnPron = "মিঠাই",
            pluralTarget = "مٹھائیاں",
            pluralBnPron = "মিঠাইয়াঁ",
            bnMeaning = "মিষ্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_126",
            category = VocabCategory.FOOD,
            singularTarget = "چاکلیٹ",
            singularBnPron = "চকলেট",
            pluralTarget = "چاکلیٹ",
            pluralBnPron = "চকলেট",
            bnMeaning = "চকলেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_127",
            category = VocabCategory.FOOD,
            singularTarget = "مصالحہ",
            singularBnPron = "মসালা",
            pluralTarget = "مصالحے",
            pluralBnPron = "মসালে",
            bnMeaning = "মসলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_128",
            category = VocabCategory.FOOD,
            singularTarget = "کالی مرچ",
            singularBnPron = "কালী মির্চ",
            pluralTarget = "کالی مرچ",
            pluralBnPron = "কালী মির্চ",
            bnMeaning = "গোলমরিচ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_129",
            category = VocabCategory.FOOD,
            singularTarget = "مرچ",
            singularBnPron = "মির্চ",
            pluralTarget = "مرچیں",
            pluralBnPron = "মির্চেঁ",
            bnMeaning = "মরিচ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_130",
            category = VocabCategory.FOOD,
            singularTarget = "ہلدی",
            singularBnPron = "হলদি",
            pluralTarget = "ہلدی",
            pluralBnPron = "হলদি",
            bnMeaning = "হলুদ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_131",
            category = VocabCategory.FOOD,
            singularTarget = "ادرک",
            singularBnPron = "আদরেক",
            pluralTarget = "ادرک",
            pluralBnPron = "আদরেক",
            bnMeaning = "আদা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_132",
            category = VocabCategory.FOOD,
            singularTarget = "لہسن",
            singularBnPron = "লহসুন",
            pluralTarget = "لہسن",
            pluralBnPron = "লহসুন",
            bnMeaning = "রসুন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_133",
            category = VocabCategory.FOOD,
            singularTarget = "پیاز",
            singularBnPron = "পিয়াজ",
            pluralTarget = "پیاز",
            pluralBnPron = "পিয়াজ",
            bnMeaning = "পেঁয়াজ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_134",
            category = VocabCategory.FOOD,
            singularTarget = "دال",
            singularBnPron = "দাল",
            pluralTarget = "دالیں",
            pluralBnPron = "দালেঁ",
            bnMeaning = "ডাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_135",
            category = VocabCategory.FOOD,
            singularTarget = "سالن",
            singularBnPron = "সালন",
            pluralTarget = "سالن",
            pluralBnPron = "সালন",
            bnMeaning = "তরকারি / কারি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_136",
            category = VocabCategory.FOOD,
            singularTarget = "نوڈلز",
            singularBnPron = "নুডলস",
            pluralTarget = "نوڈلز",
            pluralBnPron = "নুডলস",
            bnMeaning = "নুডলস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_137",
            category = VocabCategory.FOOD,
            singularTarget = "برگر",
            singularBnPron = "বার্গার",
            pluralTarget = "برگر",
            pluralBnPron = "বার্গার",
            bnMeaning = "বার্গার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_138",
            category = VocabCategory.FOOD,
            singularTarget = "سلاد",
            singularBnPron = "সলাদ",
            pluralTarget = "سلاد",
            pluralBnPron = "সলাদ",
            bnMeaning = "স্যালাড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_139",
            category = VocabCategory.FOOD,
            singularTarget = "چٹنی",
            singularBnPron = "চটনি",
            pluralTarget = "چٹنیاں",
            pluralBnPron = "চটনিয়াঁ",
            bnMeaning = "সস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_140",
            category = VocabCategory.FOOD,
            singularTarget = "سرکہ",
            singularBnPron = "সিরকা",
            pluralTarget = "سرکہ",
            pluralBnPron = "সিরকা",
            bnMeaning = "সিরকা / ভিনেগার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_141",
            category = VocabCategory.FOOD,
            singularTarget = "بادام",
            singularBnPron = "বাদাম",
            pluralTarget = "بادام",
            pluralBnPron = "বাদাম",
            bnMeaning = "বাদাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_142",
            category = VocabCategory.FOOD,
            singularTarget = "سینڈوچ",
            singularBnPron = "স্যান্ডউইচ",
            pluralTarget = "سینڈوچ",
            pluralBnPron = "স্যান্ডউইচ",
            bnMeaning = "স্যান্ডউইচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_143",
            category = VocabCategory.FOOD,
            singularTarget = "اچار",
            singularBnPron = "আচার",
            pluralTarget = "اچار",
            pluralBnPron = "আচার",
            bnMeaning = "আচার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_144",
            category = VocabCategory.FOOD,
            singularTarget = "ناشتہ",
            singularBnPron = "নাস্তা",
            pluralTarget = "ناشتے",
            pluralBnPron = "নাস্তে",
            bnMeaning = "জলখাবার / নাস্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_145",
            category = VocabCategory.FOOD,
            singularTarget = "ناشتہ",
            singularBnPron = "নাস্তা",
            pluralTarget = "ناشتے",
            pluralBnPron = "নাস্তে",
            bnMeaning = "সকালের নাস্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_146",
            category = VocabCategory.FOOD,
            singularTarget = "دوپہر کا کھانا",
            singularBnPron = "দোপহর কা খানা",
            pluralTarget = "دوپہر کا کھانا",
            pluralBnPron = "দোপহর কা খানা",
            bnMeaning = "দুপুরের খাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_147",
            category = VocabCategory.FOOD,
            singularTarget = "رات کا کھانا",
            singularBnPron = "রাত কা খানা",
            pluralTarget = "رات کا کھانا",
            pluralBnPron = "রাত কা খানা",
            bnMeaning = "রাতের খাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_148",
            category = VocabCategory.FOOD,
            singularTarget = "کھانا",
            singularBnPron = "খানা",
            pluralTarget = "کھانے",
            pluralBnPron = "খানে",
            bnMeaning = "ভোজ / খাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_149",
            category = VocabCategory.FOOD,
            singularTarget = "پیاس",
            singularBnPron = "পিয়াস",
            pluralTarget = "پیاس",
            pluralBnPron = "পিয়াস",
            bnMeaning = "পিপাসা / তৃষ্ণা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_150",
            category = VocabCategory.FOOD,
            singularTarget = "بھوک",
            singularBnPron = "ভুখ",
            pluralTarget = "بھوک",
            pluralBnPron = "ভুখ",
            bnMeaning = "ক্ষুধা / ক্ষুধা পাওয়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_151",
            category = VocabCategory.FRUITS,
            singularTarget = "آم",
            singularBnPron = "আম",
            pluralTarget = "آم",
            pluralBnPron = "আম",
            bnMeaning = "আম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_152",
            category = VocabCategory.FRUITS,
            singularTarget = "سیب",
            singularBnPron = "সেব",
            pluralTarget = "سیب",
            pluralBnPron = "সেব",
            bnMeaning = "আপেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_153",
            category = VocabCategory.FRUITS,
            singularTarget = "کیلا",
            singularBnPron = "কেলা",
            pluralTarget = "کیلے",
            pluralBnPron = "কেলে",
            bnMeaning = "কলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_154",
            category = VocabCategory.FRUITS,
            singularTarget = "مالٹا",
            singularBnPron = "মাল্টা",
            pluralTarget = "مالٹے",
            pluralBnPron = "মাল্টে",
            bnMeaning = "কমলালেবু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_155",
            category = VocabCategory.FRUITS,
            singularTarget = "انگور",
            singularBnPron = "অঙ্গুর",
            pluralTarget = "انگور",
            pluralBnPron = "অঙ্গুর",
            bnMeaning = "আঙুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_156",
            category = VocabCategory.FRUITS,
            singularTarget = "لیموں",
            singularBnPron = "লীমুঁ",
            pluralTarget = "لیموں",
            pluralBnPron = "লীমুঁ",
            bnMeaning = "লেবু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_157",
            category = VocabCategory.FRUITS,
            singularTarget = "تربوز",
            singularBnPron = "তরবুজ",
            pluralTarget = "تربوز",
            pluralBnPron = "তরবুজ",
            bnMeaning = "তরমুজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_158",
            category = VocabCategory.FRUITS,
            singularTarget = "پپیتا",
            singularBnPron = "পপিতা",
            pluralTarget = "پپیتے",
            pluralBnPron = "পপিতে",
            bnMeaning = "পেঁপে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_159",
            category = VocabCategory.FRUITS,
            singularTarget = "انناس",
            singularBnPron = "অনন্নাস",
            pluralTarget = "انناس",
            pluralBnPron = "অনন্নাস",
            bnMeaning = "আনারস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_160",
            category = VocabCategory.FRUITS,
            singularTarget = "امرود",
            singularBnPron = "আমরুদ",
            pluralTarget = "امرود",
            pluralBnPron = "আমরুদ",
            bnMeaning = "পেয়ারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_161",
            category = VocabCategory.FRUITS,
            singularTarget = "انار",
            singularBnPron = "আনার",
            pluralTarget = "انار",
            pluralBnPron = "আনার",
            bnMeaning = "ডালিম / বেদানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_162",
            category = VocabCategory.FRUITS,
            singularTarget = "ناریل",
            singularBnPron = "নারিয়েল",
            pluralTarget = "ناریل",
            pluralBnPron = "নারিয়েল",
            bnMeaning = "নারকেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_163",
            category = VocabCategory.FRUITS,
            singularTarget = "کھجور",
            singularBnPron = "খজুর",
            pluralTarget = "کھجوریں",
            pluralBnPron = "খজুরেঁ",
            bnMeaning = "খেজুর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_164",
            category = VocabCategory.FRUITS,
            singularTarget = "سٹرابیری",
            singularBnPron = "স্ট্রবেরি",
            pluralTarget = "سٹرابیری",
            pluralBnPron = "স্ট্রবেরি",
            bnMeaning = "স্ট্রবেরি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_165",
            category = VocabCategory.FRUITS,
            singularTarget = "چیری",
            singularBnPron = "চেরি",
            pluralTarget = "چیری",
            pluralBnPron = "চেরি",
            bnMeaning = "চেরি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_166",
            category = VocabCategory.FRUITS,
            singularTarget = "آلو",
            singularBnPron = "আলু",
            pluralTarget = "آلو",
            pluralBnPron = "আলু",
            bnMeaning = "আলু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_167",
            category = VocabCategory.FRUITS,
            singularTarget = "ٹماٹر",
            singularBnPron = "টমাটর",
            pluralTarget = "ٹماٹر",
            pluralBnPron = "টমাটর",
            bnMeaning = "টমেটো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_168",
            category = VocabCategory.FRUITS,
            singularTarget = "گاجر",
            singularBnPron = "গাজর",
            pluralTarget = "گاجریں",
            pluralBnPron = "গাজরেঁ",
            bnMeaning = "গাজর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_169",
            category = VocabCategory.FRUITS,
            singularTarget = "مولی",
            singularBnPron = "মুলী",
            pluralTarget = "مولیاں",
            pluralBnPron = "মুলিয়াঁ",
            bnMeaning = "মুলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_170",
            category = VocabCategory.FRUITS,
            singularTarget = "بند گوبھی",
            singularBnPron = "বন্দ গোভী",
            pluralTarget = "بند گوبھی",
            pluralBnPron = "বন্দ গোভী",
            bnMeaning = "বাঁধাকপি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_171",
            category = VocabCategory.FRUITS,
            singularTarget = "پھول گوبھی",
            singularBnPron = "ফুল গোভী",
            pluralTarget = "پھول گوبھی",
            pluralBnPron = "ফুল গোভী",
            bnMeaning = "ফুলকপি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_172",
            category = VocabCategory.FRUITS,
            singularTarget = "پالک",
            singularBnPron = "পালক",
            pluralTarget = "پالک",
            pluralBnPron = "পালক",
            bnMeaning = "পালংশাক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_173",
            category = VocabCategory.FRUITS,
            singularTarget = "کھیرا",
            singularBnPron = "খীড়া",
            pluralTarget = "کھیرے",
            pluralBnPron = "খীড়ে",
            bnMeaning = "শসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_174",
            category = VocabCategory.FRUITS,
            singularTarget = "کدو",
            singularBnPron = "কদ্দু",
            pluralTarget = "کدو",
            pluralBnPron = "কদ্দু",
            bnMeaning = "মিষ্টিকুমড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_175",
            category = VocabCategory.FRUITS,
            singularTarget = "بینگن",
            singularBnPron = "বেগন",
            pluralTarget = "بینگن",
            pluralBnPron = "বেগন",
            bnMeaning = "বেগুন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_176",
            category = VocabCategory.FRUITS,
            singularTarget = "مٹر",
            singularBnPron = "মটর",
            pluralTarget = "مٹر",
            pluralBnPron = "মটর",
            bnMeaning = "মটরশুঁটি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_177",
            category = VocabCategory.FRUITS,
            singularTarget = "بھنڈی",
            singularBnPron = "ভিন্ডি",
            pluralTarget = "بھنڈیاں",
            pluralBnPron = "ভিন্ডিয়াঁ",
            bnMeaning = "ঢ্যাঁড়শ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_178",
            category = VocabCategory.FRUITS,
            singularTarget = "کھمبی",
            singularBnPron = "খুম্বি",
            pluralTarget = "کھمبیاں",
            pluralBnPron = "খুম্বিয়াঁ",
            bnMeaning = "মাশরুম / ব্যাঙের ছাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_179",
            category = VocabCategory.FRUITS,
            singularTarget = "مکئی",
            singularBnPron = "মকই",
            pluralTarget = "مکئی",
            pluralBnPron = "মকই",
            bnMeaning = "ভূট্টা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_180",
            category = VocabCategory.FRUITS,
            singularTarget = "پودینہ",
            singularBnPron = "পুদিনা",
            pluralTarget = "پودینہ",
            pluralBnPron = "পুদিনা",
            bnMeaning = "পুদিনা পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_181",
            category = VocabCategory.FRUITS,
            singularTarget = "دھنیا",
            singularBnPron = "ধনিয়া",
            pluralTarget = "دھنیا",
            pluralBnPron = "ধনিয়া",
            bnMeaning = "ধনিয়া পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_182",
            category = VocabCategory.FRUITS,
            singularTarget = "سلاد پتہ",
            singularBnPron = "সলাদ পত্তা",
            pluralTarget = "سلاد پتے",
            pluralBnPron = "সলাদ পত্তে",
            bnMeaning = "লেটুস পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_183",
            category = VocabCategory.FRUITS,
            singularTarget = "چقندر",
            singularBnPron = "চুকন্দর",
            pluralTarget = "چقندر",
            pluralBnPron = "চুকন্দর",
            bnMeaning = "বিট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_184",
            category = VocabCategory.FRUITS,
            singularTarget = "شملہ مرچ",
            singularBnPron = "শিমলা মির্চ",
            pluralTarget = "شملہ مرچ",
            pluralBnPron = "শিমলা মির্চ",
            bnMeaning = "ক্যাপসিকাম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_185",
            category = VocabCategory.FRUITS,
            singularTarget = "لوکی",
            singularBnPron = "লৌকি",
            pluralTarget = "لوکیاں",
            pluralBnPron = "লৌকিয়াঁ",
            bnMeaning = "লাউ / কদু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_186",
            category = VocabCategory.FRUITS,
            singularTarget = "کریلا",
            singularBnPron = "করেলা",
            pluralTarget = "کریلے",
            pluralBnPron = "করেলে",
            bnMeaning = "করলা / উচ্ছে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_187",
            category = VocabCategory.FRUITS,
            singularTarget = "کٹہل",
            singularBnPron = "কটহল",
            pluralTarget = "کٹہل",
            pluralBnPron = "কটহল",
            bnMeaning = "কাঁঠাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_188",
            category = VocabCategory.FRUITS,
            singularTarget = "لیچی",
            singularBnPron = "লীচি",
            pluralTarget = "لیچیاں",
            pluralBnPron = "লীচিয়াঁ",
            bnMeaning = "লিচু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_189",
            category = VocabCategory.FRUITS,
            singularTarget = "زیتون",
            singularBnPron = "জৈতুন",
            pluralTarget = "زیتون",
            pluralBnPron = "জৈতুন",
            bnMeaning = "জলপাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_190",
            category = VocabCategory.FRUITS,
            singularTarget = "انجیر",
            singularBnPron = "অঞ্জীর",
            pluralTarget = "انجیر",
            pluralBnPron = "অঞ্জীর",
            bnMeaning = "ডুমুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_191",
            category = VocabCategory.FRUITS,
            singularTarget = "ناشپاتی",
            singularBnPron = "নাশপাতি",
            pluralTarget = "ناشپاتیاں",
            pluralBnPron = "নাশপাতিয়াঁ",
            bnMeaning = "নাশপাতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_192",
            category = VocabCategory.FRUITS,
            singularTarget = "آڑو",
            singularBnPron = "আড়ু",
            pluralTarget = "آڑو",
            pluralBnPron = "আড়ু",
            bnMeaning = "পীচ ফল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_193",
            category = VocabCategory.FRUITS,
            singularTarget = "آلو بخارا",
            singularBnPron = "আলু বুখারা",
            pluralTarget = "آلو بخارے",
            pluralBnPron = "আলু বুখারে",
            bnMeaning = "আলুবোখারা / প্লাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_194",
            category = VocabCategory.FRUITS,
            singularTarget = "شلجم",
            singularBnPron = "শলজম",
            pluralTarget = "شلجم",
            pluralBnPron = "শলজম",
            bnMeaning = "শালগম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_195",
            category = VocabCategory.FRUITS,
            singularTarget = "شکر قندی",
            singularBnPron = "শকর কন্দী",
            pluralTarget = "شکر قندیاں",
            pluralBnPron = "শকর কন্দীয়াঁ",
            bnMeaning = "মিষ্টি আলু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_196",
            category = VocabCategory.FRUITS,
            singularTarget = "سویا بین",
            singularBnPron = "সোয়াবিন",
            pluralTarget = "سویا بین",
            pluralBnPron = "সোয়াবিন",
            bnMeaning = "সয়াবিন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_197",
            category = VocabCategory.FRUITS,
            singularTarget = "سبزی",
            singularBnPron = "সবজি",
            pluralTarget = "سبزیاں",
            pluralBnPron = "সবজিয়াঁ",
            bnMeaning = "সবজি (সাধারণ)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_198",
            category = VocabCategory.FRUITS,
            singularTarget = "پھل",
            singularBnPron = "ফল",
            pluralTarget = "پھل",
            pluralBnPron = "ফল",
            bnMeaning = "ফল (সাধারণ)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_199",
            category = VocabCategory.FRUITS,
            singularTarget = "پودا",
            singularBnPron = "পওদা",
            pluralTarget = "پودے",
            pluralBnPron = "পওদে",
            bnMeaning = "গাছ / কাণ্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_200",
            category = VocabCategory.FRUITS,
            singularTarget = "بیج",
            singularBnPron = "বীজ",
            pluralTarget = "بیج",
            pluralBnPron = "বীজ",
            bnMeaning = "বীজ",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk3 = listOf(
        VocabItem(
            id = "ur_vocab_201",
            category = VocabCategory.HOME,
            singularTarget = "گھر",
            singularBnPron = "ঘর",
            pluralTarget = "گھر",
            pluralBnPron = "ঘর",
            bnMeaning = "বাড়ি / ঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_202",
            category = VocabCategory.HOME,
            singularTarget = "کمرہ",
            singularBnPron = "কমরা",
            pluralTarget = "کمرے",
            pluralBnPron = "কমরে",
            bnMeaning = "কক্ষ / রুম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_203",
            category = VocabCategory.HOME,
            singularTarget = "دروازہ",
            singularBnPron = "দরওয়াজা",
            pluralTarget = "دروازے",
            pluralBnPron = "দরওয়াজে",
            bnMeaning = "দরজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_204",
            category = VocabCategory.HOME,
            singularTarget = "کھڑکی",
            singularBnPron = "খিড়কি",
            pluralTarget = "کھڑکیاں",
            pluralBnPron = "খিড়কিয়াঁ",
            bnMeaning = "জানালা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_205",
            category = VocabCategory.HOME,
            singularTarget = "دیوار",
            singularBnPron = "দীওয়ার",
            pluralTarget = "دیواریں",
            pluralBnPron = "দীওয়ারেঁ",
            bnMeaning = "দেয়াল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_206",
            category = VocabCategory.HOME,
            singularTarget = "فرش",
            singularBnPron = "ফর্শ",
            pluralTarget = "فرش",
            pluralBnPron = "ফর্শ",
            bnMeaning = "মেঝে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_207",
            category = VocabCategory.HOME,
            singularTarget = "چھت",
            singularBnPron = "ছত",
            pluralTarget = "چھتیں",
            pluralBnPron = "ছতেঁ",
            bnMeaning = "ছাদ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_208",
            category = VocabCategory.HOME,
            singularTarget = "سیلنگ",
            singularBnPron = "সিলিং",
            pluralTarget = "سیلنگ",
            pluralBnPron = "সিলিং",
            bnMeaning = "সিলিং (ঘরের ভেতর ছাদ)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_209",
            category = VocabCategory.HOME,
            singularTarget = "سونے کا کمرہ",
            singularBnPron = "সোনে কা কমরা",
            pluralTarget = "سونے کے کمرے",
            pluralBnPron = "সোনে কে কমরে",
            bnMeaning = "শোবার ঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_210",
            category = VocabCategory.HOME,
            singularTarget = "غسل خانہ",
            singularBnPron = "গুসল খানা",
            pluralTarget = "غسل خانے",
            pluralBnPron = "গুসল খানে",
            bnMeaning = "গোসলখানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_211",
            category = VocabCategory.HOME,
            singularTarget = "باورچی خانہ",
            singularBnPron = "বাওয়ারচি খানা",
            pluralTarget = "باورچی خانے",
            pluralBnPron = "বাওয়ারচি খানে",
            bnMeaning = "রান্নাঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_212",
            category = VocabCategory.HOME,
            singularTarget = "کھانے کا کمرہ",
            singularBnPron = "খানে কা কমরা",
            pluralTarget = "کھانے کے کمرے",
            pluralBnPron = "খানে কে কমরে",
            bnMeaning = "খাবার ঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_213",
            category = VocabCategory.HOME,
            singularTarget = "نشست گاہ",
            singularBnPron = "নিশাস্ত গাহ",
            pluralTarget = "نشست گاہیں",
            pluralBnPron = "নিশাস্ত গাহেঁ",
            bnMeaning = "বসার ঘর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_214",
            category = VocabCategory.HOME,
            singularTarget = "بالکونی",
            singularBnPron = "ব্যালকনি",
            pluralTarget = "بالکونیاں",
            pluralBnPron = "ব্যালকনিয়াঁ",
            bnMeaning = "বারান্দা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_215",
            category = VocabCategory.HOME,
            singularTarget = "باغ",
            singularBnPron = "বাগ",
            pluralTarget = "باغات",
            pluralBnPron = "বাঘাত",
            bnMeaning = "বাগান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_216",
            category = VocabCategory.HOME,
            singularTarget = "پھاٹک",
            singularBnPron = "ফাটক",
            pluralTarget = "پھاٹک",
            pluralBnPron = "ফাটক",
            bnMeaning = "গেট / ফটক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_217",
            category = VocabCategory.HOME,
            singularTarget = "سیڑھی",
            singularBnPron = "সীঢ়ি",
            pluralTarget = "سیڑھیاں",
            pluralBnPron = "সীঢ়িয়াঁ",
            bnMeaning = "সিঁড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_218",
            category = VocabCategory.HOME,
            singularTarget = "لفٹ",
            singularBnPron = "লিফট",
            pluralTarget = "لفٹیں",
            pluralBnPron = "লিফটেঁ",
            bnMeaning = "লিফট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_219",
            category = VocabCategory.HOME,
            singularTarget = "بستر",
            singularBnPron = "বিস্তর",
            pluralTarget = "بستر",
            pluralBnPron = "বিস্তর",
            bnMeaning = "বিছানা / খাট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_220",
            category = VocabCategory.HOME,
            singularTarget = "تکیہ",
            singularBnPron = "তকিয়া",
            pluralTarget = "تکیے",
            pluralBnPron = "তকিয়ে",
            bnMeaning = "বালিশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_221",
            category = VocabCategory.HOME,
            singularTarget = "کمبل",
            singularBnPron = "কম্বল",
            pluralTarget = "کمبل",
            pluralBnPron = "কম্বল",
            bnMeaning = "কম্বল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_222",
            category = VocabCategory.HOME,
            singularTarget = "گدا",
            singularBnPron = "গদ্দা",
            pluralTarget = "گدے",
            pluralBnPron = "গদ্দে",
            bnMeaning = "গদি / তোশক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_223",
            category = VocabCategory.HOME,
            singularTarget = "چادر",
            singularBnPron = "চাদর",
            pluralTarget = "چادریں",
            pluralBnPron = "চাদরেঁ",
            bnMeaning = "চাদর (বিছানার)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_224",
            category = VocabCategory.HOME,
            singularTarget = "میز",
            singularBnPron = "মেজ",
            pluralTarget = "میزیں",
            pluralBnPron = "মেজেঁ",
            bnMeaning = "টেবিল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_225",
            category = VocabCategory.HOME,
            singularTarget = "کرسی",
            singularBnPron = "কুর্সি",
            pluralTarget = "کرسیاں",
            pluralBnPron = "কুর্সিয়াঁ",
            bnMeaning = "চেয়ার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_226",
            category = VocabCategory.HOME,
            singularTarget = "صوفہ",
            singularBnPron = "সোফা",
            pluralTarget = "صوفے",
            pluralBnPron = "সোফে",
            bnMeaning = "সোফা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_227",
            category = VocabCategory.HOME,
            singularTarget = "ڈیسک",
            singularBnPron = "ডেস্ক",
            pluralTarget = "ڈیسک",
            pluralBnPron = "ডেস্ক",
            bnMeaning = "পড়ার টেবিল / ডেস্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_228",
            category = VocabCategory.HOME,
            singularTarget = "الماری",
            singularBnPron = "আলমারি",
            pluralTarget = "الماریاں",
            pluralBnPron = "আলমারিয়াঁ",
            bnMeaning = "আলমারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_229",
            category = VocabCategory.HOME,
            singularTarget = "دراز",
            singularBnPron = "দরাজ",
            pluralTarget = "درازیں",
            pluralBnPron = "দরাজেঁ",
            bnMeaning = "ড্রয়ার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_230",
            category = VocabCategory.HOME,
            singularTarget = "طاق",
            singularBnPron = "তাক",
            pluralTarget = "طاق",
            pluralBnPron = "তাক",
            bnMeaning = "তাক / শেলফ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_231",
            category = VocabCategory.HOME,
            singularTarget = "آئینہ",
            singularBnPron = "আইনা",
            pluralTarget = "آئینے",
            pluralBnPron = "আইনে",
            bnMeaning = "আয়না",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_232",
            category = VocabCategory.HOME,
            singularTarget = "چراغ / لیمپ",
            singularBnPron = "চিরাগ",
            pluralTarget = "چراغ",
            pluralBnPron = "চিরাগ",
            bnMeaning = "বাতি / ল্যাম্প",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_233",
            category = VocabCategory.HOME,
            singularTarget = "روشنی",
            singularBnPron = "রওশনি",
            pluralTarget = "روشنی",
            pluralBnPron = "রওশনি",
            bnMeaning = "আলো",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_234",
            category = VocabCategory.HOME,
            singularTarget = "پنکھا",
            singularBnPron = "পংখা",
            pluralTarget = "پنکھے",
            pluralBnPron = "পংখে",
            bnMeaning = "পাখা / ফ্যান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_235",
            category = VocabCategory.HOME,
            singularTarget = "گھڑی",
            singularBnPron = "ঘড়ি",
            pluralTarget = "گھڑیاں",
            pluralBnPron = "ঘড়িয়াঁ",
            bnMeaning = "ঘড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_236",
            category = VocabCategory.HOME,
            singularTarget = "ٹیلی ویژن",
            singularBnPron = "টেলিভিজন",
            pluralTarget = "ٹیلی ویژن",
            pluralBnPron = "টেলিভিজন",
            bnMeaning = "টেলিভিশন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_237",
            category = VocabCategory.HOME,
            singularTarget = "پردہ",
            singularBnPron = "পর্দা",
            pluralTarget = "پردے",
            pluralBnPron = "পর্দে",
            bnMeaning = "পর্দা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_238",
            category = VocabCategory.HOME,
            singularTarget = "قالین",
            singularBnPron = "কালীন",
            pluralTarget = "قالین",
            pluralBnPron = "কালীন",
            bnMeaning = "কার্পেট / গালিচা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_239",
            category = VocabCategory.HOME,
            singularTarget = "تالا",
            singularBnPron = "তালা",
            pluralTarget = "تالے",
            pluralBnPron = "তালে",
            bnMeaning = "তালা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_240",
            category = VocabCategory.HOME,
            singularTarget = "چابی",
            singularBnPron = "চাবি",
            pluralTarget = "چابیاں",
            pluralBnPron = "চাবিয়াঁ",
            bnMeaning = "চাবি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_241",
            category = VocabCategory.HOME,
            singularTarget = "گھنٹی",
            singularBnPron = "ঘণ্টি",
            pluralTarget = "گھنٹیاں",
            pluralBnPron = "ঘন্টিয়াঁ",
            bnMeaning = "ঘণ্টি / বেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_242",
            category = VocabCategory.HOME,
            singularTarget = "تصویر",
            singularBnPron = "তসবীর",
            pluralTarget = "تصاویر",
            pluralBnPron = "তসাবীর",
            bnMeaning = "ছবি / চিত্রকর্ম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_243",
            category = VocabCategory.HOME,
            singularTarget = "گلدان",
            singularBnPron = "গুলদান",
            pluralTarget = "گلدان",
            pluralBnPron = "গুলদান",
            bnMeaning = "ফুলদানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_244",
            category = VocabCategory.HOME,
            singularTarget = "جھاڑو",
            singularBnPron = "ঝাড়ু",
            pluralTarget = "جھاڑو",
            pluralBnPron = "ঝাড়ু",
            bnMeaning = "ঝাঁটা / ঝাড়ু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_245",
            category = VocabCategory.HOME,
            singularTarget = "کوڑے دان",
            singularBnPron = "কুড়েদান",
            pluralTarget = "کوڑے دان",
            pluralBnPron = "কুড়েদান",
            bnMeaning = "ময়লার ঝুড়ি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_246",
            category = VocabCategory.HOME,
            singularTarget = "نلکا",
            singularBnPron = "নলকা",
            pluralTarget = "نلکے",
            pluralBnPron = "নলকে",
            bnMeaning = "পানির কল / ট্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_247",
            category = VocabCategory.HOME,
            singularTarget = "پائپ",
            singularBnPron = "পাইপ",
            pluralTarget = "پائپ",
            pluralBnPron = "পাইপ",
            bnMeaning = "নল / পাইপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_248",
            category = VocabCategory.HOME,
            singularTarget = "باڑ",
            singularBnPron = "বাড়",
            pluralTarget = "باڑیں",
            pluralBnPron = "বাড়েঁ",
            bnMeaning = "বেড়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_249",
            category = VocabCategory.HOME,
            singularTarget = "سایہ",
            singularBnPron = "সায়া",
            pluralTarget = "سائے",
            pluralBnPron = "সায়ে",
            bnMeaning = "ছায়া / শেড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_250",
            category = VocabCategory.HOME,
            singularTarget = "دہلیز",
            singularBnPron = "দহলীজ",
            pluralTarget = "دہلیزیں",
            pluralBnPron = "দহলীজেঁ",
            bnMeaning = "চৌকাঠ / সীমানা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_251",
            category = VocabCategory.CLOTHES,
            singularTarget = "قمیض",
            singularBnPron = "কমিজ",
            pluralTarget = "قمیضیں",
            pluralBnPron = "কমিজেঁ",
            bnMeaning = "শার্ট / জামা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_252",
            category = VocabCategory.CLOTHES,
            singularTarget = "ٹی شرٹ",
            singularBnPron = "টি শার্ট",
            pluralTarget = "ٹی شرٹس",
            pluralBnPron = "টি শার্টস",
            bnMeaning = "টি-শার্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_253",
            category = VocabCategory.CLOTHES,
            singularTarget = "پتلون",
            singularBnPron = "পতলুন",
            pluralTarget = "پتلونیں",
            pluralBnPron = "পতলুনেঁ",
            bnMeaning = "প্যান্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_254",
            category = VocabCategory.CLOTHES,
            singularTarget = "جینز",
            singularBnPron = "জিন্স",
            pluralTarget = "جینز",
            pluralBnPron = "জিন্স",
            bnMeaning = "জিন্স প্যান্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_255",
            category = VocabCategory.CLOTHES,
            singularTarget = "شارٹس",
            singularBnPron = "শর্টস",
            pluralTarget = "شارٹس",
            pluralBnPron = "শর্টস",
            bnMeaning = "হাফ প্যান্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_256",
            category = VocabCategory.CLOTHES,
            singularTarget = "لباس",
            singularBnPron = "লেবাস",
            pluralTarget = "لباس",
            pluralBnPron = "লেবাস",
            bnMeaning = "পোশাক / জামা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_257",
            category = VocabCategory.CLOTHES,
            singularTarget = "اسکرٹ",
            singularBnPron = "স্কার্ট",
            pluralTarget = "اسکرٹ",
            pluralBnPron = "স্কার্ট",
            bnMeaning = "স্কার্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_258",
            category = VocabCategory.CLOTHES,
            singularTarget = "جیکٹ",
            singularBnPron = "জ্যাকেট",
            pluralTarget = "جیکٹیں",
            pluralBnPron = "জ্যাকেটেঁ",
            bnMeaning = "জ্যাকেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_259",
            category = VocabCategory.CLOTHES,
            singularTarget = "کوٹ",
            singularBnPron = "কোট",
            pluralTarget = "کوٹ",
            pluralBnPron = "কোট",
            bnMeaning = "কোট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_260",
            category = VocabCategory.CLOTHES,
            singularTarget = "سویٹر",
            singularBnPron = "সোয়েটার",
            pluralTarget = "سویٹر",
            pluralBnPron = "সোয়েটার",
            bnMeaning = "সোয়েটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_261",
            category = VocabCategory.CLOTHES,
            singularTarget = "سوٹ",
            singularBnPron = "স্যুট",
            pluralTarget = "سوٹ",
            pluralBnPron = "স্যুট",
            bnMeaning = "স্যুট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_262",
            category = VocabCategory.CLOTHES,
            singularTarget = "ٹائی",
            singularBnPron = "টাই",
            pluralTarget = "ٹائیاں",
            pluralBnPron = "টাইয়াঁ",
            bnMeaning = "টাই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_263",
            category = VocabCategory.CLOTHES,
            singularTarget = "مفلر / دوپٹہ",
            singularBnPron = "মাফলার",
            pluralTarget = "مفلر",
            pluralBnPron = "মাফলার",
            bnMeaning = "মাফলার / স্কার্ফ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_264",
            category = VocabCategory.CLOTHES,
            singularTarget = "دستانہ",
            singularBnPron = "দস্তানা",
            pluralTarget = "دستانے",
            pluralBnPron = "দস্তানে",
            bnMeaning = "দস্তানা / গ্লাভস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_265",
            category = VocabCategory.CLOTHES,
            singularTarget = "موزہ",
            singularBnPron = "মোজা",
            pluralTarget = "موزے",
            pluralBnPron = "মোজে",
            bnMeaning = "মোজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_266",
            category = VocabCategory.CLOTHES,
            singularTarget = "جوتا",
            singularBnPron = "জুতা",
            pluralTarget = "جوتے",
            pluralBnPron = "জুতে",
            bnMeaning = "জুতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_267",
            category = VocabCategory.CLOTHES,
            singularTarget = "بوٹ",
            singularBnPron = "বুট",
            pluralTarget = "بوٹ",
            pluralBnPron = "বুট",
            bnMeaning = "বুট জুতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_268",
            category = VocabCategory.CLOTHES,
            singularTarget = "چپل",
            singularBnPron = "চপ্পল",
            pluralTarget = "چپلیں",
            pluralBnPron = "চপ্পলেঁ",
            bnMeaning = "চটি / স্লিপার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_269",
            category = VocabCategory.CLOTHES,
            singularTarget = "سینڈل",
            singularBnPron = "স্যান্ডেল",
            pluralTarget = "سینڈل",
            pluralBnPron = "স্যান্ডেল",
            bnMeaning = "স্যান্ডেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_270",
            category = VocabCategory.CLOTHES,
            singularTarget = "ٹوپی",
            singularBnPron = "টোপি",
            pluralTarget = "ٹپیاں",
            pluralBnPron = "টোপিয়াঁ",
            bnMeaning = "টুপি (হ্যাট)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_271",
            category = VocabCategory.CLOTHES,
            singularTarget = "کیپ",
            singularBnPron = "ক্যাপ",
            pluralTarget = "کیپ",
            pluralBnPron = "ক্যাপ",
            bnMeaning = "ক্যাপ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_272",
            category = VocabCategory.CLOTHES,
            singularTarget = "بیلٹ / پیٹی",
            singularBnPron = "বেল্ট",
            pluralTarget = "بیلٹیں",
            pluralBnPron = "বেল্টেঁ",
            bnMeaning = "বেল্ট / কোমরবন্ধ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_273",
            category = VocabCategory.CLOTHES,
            singularTarget = "انگوٹھی",
            singularBnPron = "অঙ্গুঠী",
            pluralTarget = "انگوٹھیاں",
            pluralBnPron = "অঙ্গুঠিয়াঁ",
            bnMeaning = "আংটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_274",
            category = VocabCategory.CLOTHES,
            singularTarget = "ہار",
            singularBnPron = "হার",
            pluralTarget = "ہار",
            pluralBnPron = "হার",
            bnMeaning = "গলার হার / নেকলেস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_275",
            category = VocabCategory.CLOTHES,
            singularTarget = "کنگن",
            singularBnPron = "কঙ্গন",
            pluralTarget = "کنگن",
            pluralBnPron = "কঙ্গন",
            bnMeaning = "ব্রেসলেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_276",
            category = VocabCategory.CLOTHES,
            singularTarget = "کلائی گھڑی",
            singularBnPron = "ঘড়ি",
            pluralTarget = "کلائی گھڑیاں",
            pluralBnPron = "ঘড়িয়াঁ",
            bnMeaning = "হাতঘড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_277",
            category = VocabCategory.CLOTHES,
            singularTarget = "چھتری",
            singularBnPron = "ছত্রী",
            pluralTarget = "چھتریاں",
            pluralBnPron = "ছত্রিয়াঁ",
            bnMeaning = "ছাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_278",
            category = VocabCategory.CLOTHES,
            singularTarget = "چشمہ",
            singularBnPron = "চশমা",
            pluralTarget = "چشمے",
            pluralBnPron = "চশমে",
            bnMeaning = "চশমা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_279",
            category = VocabCategory.CLOTHES,
            singularTarget = "دھوپ کا چشمہ",
            singularBnPron = "চশমা",
            pluralTarget = "دھوپ کے چشمے",
            pluralBnPron = "চশমে",
            bnMeaning = "রোদচশমা / সানগ্লাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_280",
            category = VocabCategory.CLOTHES,
            singularTarget = "بٹوہ",
            singularBnPron = "বটুয়া",
            pluralTarget = "بٹوے",
            pluralBnPron = "বটুয়ে",
            bnMeaning = "মানিব্যাগ / ওয়ালেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_281",
            category = VocabCategory.CLOTHES,
            singularTarget = "پرس",
            singularBnPron = "পার্স",
            pluralTarget = "پرس",
            pluralBnPron = "পার্স",
            bnMeaning = "হাতব্যাগ / পার্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_282",
            category = VocabCategory.CLOTHES,
            singularTarget = "بستہ",
            singularBnPron = "বস্তা",
            pluralTarget = "بستے",
            pluralBnPron = "বস্তে",
            bnMeaning = "পিঠের ব্যাগ / ব্যাকপ্যাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_283",
            category = VocabCategory.CLOTHES,
            singularTarget = "بٹن",
            singularBnPron = "বাটন",
            pluralTarget = "بٹن",
            pluralBnPron = "বাটন",
            bnMeaning = "বোতাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_284",
            category = VocabCategory.CLOTHES,
            singularTarget = "زپ",
            singularBnPron = "জিপ",
            pluralTarget = "زپ",
            pluralBnPron = "জিপ",
            bnMeaning = "চেইন / জিপার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_285",
            category = VocabCategory.CLOTHES,
            singularTarget = "جیب",
            singularBnPron = "জেব",
            pluralTarget = "جیبیں",
            pluralBnPron = "জেবেঁ",
            bnMeaning = "পকেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_286",
            category = VocabCategory.CLOTHES,
            singularTarget = "کالر",
            singularBnPron = "কলার",
            pluralTarget = "کالر",
            pluralBnPron = "কলার",
            bnMeaning = "কলার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_287",
            category = VocabCategory.CLOTHES,
            singularTarget = "آستین",
            singularBnPron = "আস্তিন",
            pluralTarget = "آستینیں",
            pluralBnPron = "আস্তিনেঁ",
            bnMeaning = "হাতা (জামা)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_288",
            category = VocabCategory.CLOTHES,
            singularTarget = "وردی",
            singularBnPron = "ওয়ার্দি",
            pluralTarget = "وردیاں",
            pluralBnPron = "ওয়ার্দিয়াঁ",
            bnMeaning = "ইউনিফর্ম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_289",
            category = VocabCategory.CLOTHES,
            singularTarget = "پاجامہ",
            singularBnPron = "পায়জামা",
            pluralTarget = "پاجامے",
            pluralBnPron = "পায়জামে",
            bnMeaning = "পায়জামা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_290",
            category = VocabCategory.CLOTHES,
            singularTarget = "زیر جامہ",
            singularBnPron = "জের জামা",
            pluralTarget = "زیر جامہ",
            pluralBnPron = "জের জামা",
            bnMeaning = "অন্তর্বাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_291",
            category = VocabCategory.CLOTHES,
            singularTarget = "برساتی",
            singularBnPron = "বরসাতি",
            pluralTarget = "برساتیاں",
            pluralBnPron = "বরসাতিয়াঁ",
            bnMeaning = "বৃষ্টির কোট / রেইনকোট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_292",
            category = VocabCategory.CLOTHES,
            singularTarget = "واسکوٹ",
            singularBnPron = "ওয়াসকোট",
            pluralTarget = "واسکوٹیں",
            pluralBnPron = "ওয়াসকোটেঁ",
            bnMeaning = "কটি / ভেস্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_293",
            category = VocabCategory.CLOTHES,
            singularTarget = "تیراکی کا لباس",
            singularBnPron = "লেবাস",
            pluralTarget = "لباس",
            pluralBnPron = "লেবাস",
            bnMeaning = "সাঁতারের পোশাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_294",
            category = VocabCategory.CLOTHES,
            singularTarget = "شال",
            singularBnPron = "শাল",
            pluralTarget = "شالیں",
            pluralBnPron = "শালেঁ",
            bnMeaning = "শাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_295",
            category = VocabCategory.CLOTHES,
            singularTarget = "دوپٹہ",
            singularBnPron = "দুপাট্টা",
            pluralTarget = "دوپٹے",
            pluralBnPron = "দুপাট্টে",
            bnMeaning = "ওড়না",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_296",
            category = VocabCategory.CLOTHES,
            singularTarget = "دھاگہ",
            singularBnPron = "ধাগা",
            pluralTarget = "دھاگے",
            pluralBnPron = "ধাগে",
            bnMeaning = "সুতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_297",
            category = VocabCategory.CLOTHES,
            singularTarget = "سوئی",
            singularBnPron = "সুই",
            pluralTarget = "سوئیاں",
            pluralBnPron = "সুইয়াঁ",
            bnMeaning = "সুই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_298",
            category = VocabCategory.CLOTHES,
            singularTarget = "کپڑا",
            singularBnPron = "কাপড়া",
            pluralTarget = "کپڑے",
            pluralBnPron = "কাপড়ে",
            bnMeaning = "কাপড় / বস্ত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_299",
            category = VocabCategory.CLOTHES,
            singularTarget = "ریشم",
            singularBnPron = "রেশম",
            pluralTarget = "ریشم",
            pluralBnPron = "রেশম",
            bnMeaning = "রেশম / সিল্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_300",
            category = VocabCategory.CLOTHES,
            singularTarget = "کپاس / سوت",
            singularBnPron = "কপাস",
            pluralTarget = "کپاس",
            pluralBnPron = "কপাস",
            bnMeaning = "তুলা / সুতি",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk4 = listOf(
        VocabItem(
            id = "ur_vocab_301",
            category = VocabCategory.PLACES,
            singularTarget = "شہر",
            singularBnPron = "শহর",
            pluralTarget = "شہر",
            pluralBnPron = "শহর",
            bnMeaning = "শহর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_302",
            category = VocabCategory.PLACES,
            singularTarget = "گاؤں",
            singularBnPron = "গাঁও",
            pluralTarget = "گاؤں",
            pluralBnPron = "গাঁও",
            bnMeaning = "গ্রাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_303",
            category = VocabCategory.PLACES,
            singularTarget = "ملک",
            singularBnPron = "মুলক",
            pluralTarget = "ممالک",
            pluralBnPron = "মামালিক",
            bnMeaning = "দেশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_304",
            category = VocabCategory.PLACES,
            singularTarget = "قصبہ",
            singularBnPron = "কসবা",
            pluralTarget = "قصبے",
            pluralBnPron = "কসবে",
            bnMeaning = "ছোট শহর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_305",
            category = VocabCategory.PLACES,
            singularTarget = "سڑک",
            singularBnPron = "সড়ক",
            pluralTarget = "سڑکیں",
            pluralBnPron = "সড়কেঁ",
            bnMeaning = "রাস্তা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_306",
            category = VocabCategory.PLACES,
            singularTarget = "پل",
            singularBnPron = "পুল",
            pluralTarget = "پل",
            pluralBnPron = "পুল",
            bnMeaning = "সেতু / ব্রিজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_307",
            category = VocabCategory.PLACES,
            singularTarget = "دریا",
            singularBnPron = "দরিয়া",
            pluralTarget = "دریا",
            pluralBnPron = "দরিয়া",
            bnMeaning = "নদী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_308",
            category = VocabCategory.PLACES,
            singularTarget = "پارک",
            singularBnPron = "পার্ক",
            pluralTarget = "پارک",
            pluralBnPron = "পার্ক",
            bnMeaning = "উদ্যান / পার্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_309",
            category = VocabCategory.PLACES,
            singularTarget = "باغ",
            singularBnPron = "বাগ",
            pluralTarget = "باغات",
            pluralBnPron = "বাঘাত",
            bnMeaning = "বাগান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_310",
            category = VocabCategory.PLACES,
            singularTarget = "بازار",
            singularBnPron = "বাজার",
            pluralTarget = "بازار",
            pluralBnPron = "বাজার",
            bnMeaning = "বাজার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_311",
            category = VocabCategory.PLACES,
            singularTarget = "دکان",
            singularBnPron = "দোকান",
            pluralTarget = "دکانیں",
            pluralBnPron = "দোকানেঁ",
            bnMeaning = "দোকান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_312",
            category = VocabCategory.PLACES,
            singularTarget = "سپر مارکیٹ",
            singularBnPron = "সুপারমার্কেট",
            pluralTarget = "سپر مارکیٹ",
            pluralBnPron = "সুপারমার্কেট",
            bnMeaning = "সুপারমার্কেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_313",
            category = VocabCategory.PLACES,
            singularTarget = "بینک",
            singularBnPron = "ব্যাংক",
            pluralTarget = "بینک",
            pluralBnPron = "ব্যাংক",
            bnMeaning = "ব্যাংক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_314",
            category = VocabCategory.PLACES,
            singularTarget = "ہسپتال",
            singularBnPron = "হাসপাতাল",
            pluralTarget = "ہسپتال",
            pluralBnPron = "হাসপাতাল",
            bnMeaning = "হাসপাতাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_315",
            category = VocabCategory.PLACES,
            singularTarget = "دواخانہ",
            singularBnPron = "দাওয়াখানা",
            pluralTarget = "دواخانے",
            pluralBnPron = "দাওয়াখানে",
            bnMeaning = "ঔষধের দোকান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_316",
            category = VocabCategory.PLACES,
            singularTarget = "اسکول / مدرسہ",
            singularBnPron = "স্কুল",
            pluralTarget = "اسکول",
            pluralBnPron = "স্কুল",
            bnMeaning = "বিদ্যালয় / স্কুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_317",
            category = VocabCategory.PLACES,
            singularTarget = "کالج",
            singularBnPron = "কলেজ",
            pluralTarget = "کالج",
            pluralBnPron = "কলেজ",
            bnMeaning = "কলেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_318",
            category = VocabCategory.PLACES,
            singularTarget = "جامعہ",
            singularBnPron = "জামিয়া",
            pluralTarget = "جامعات",
            pluralBnPron = "জামিয়াত",
            bnMeaning = "বিশ্ববিদ্যালয়",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_319",
            category = VocabCategory.PLACES,
            singularTarget = "کتب خانہ",
            singularBnPron = "কুতুব খানা",
            pluralTarget = "کتب خانے",
            pluralBnPron = "কুতুব খানে",
            bnMeaning = "গ্রন্থাগার / লাইব্রেরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_320",
            category = VocabCategory.PLACES,
            singularTarget = "عجائب گھر",
            singularBnPron = "আজায়েব ঘর",
            pluralTarget = "عجائب گھر",
            pluralBnPron = "আজায়েব ঘর",
            bnMeaning = "জাদুঘর / মিউজিয়াম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_321",
            category = VocabCategory.PLACES,
            singularTarget = "ہوٹل",
            singularBnPron = "হোটেল",
            pluralTarget = "ہوٹل",
            pluralBnPron = "হোটেল",
            bnMeaning = "হোটেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_322",
            category = VocabCategory.PLACES,
            singularTarget = "ریستوران",
            singularBnPron = "রেস্তোরাঁ",
            pluralTarget = "ریستوران",
            pluralBnPron = "রেস্তোরাঁ",
            bnMeaning = "রেস্তোরাঁ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_323",
            category = VocabCategory.PLACES,
            singularTarget = "کیفے",
            singularBnPron = "ক্যাফে",
            pluralTarget = "کیفے",
            pluralBnPron = "ক্যাফে",
            bnMeaning = "ক্যাফে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_324",
            category = VocabCategory.PLACES,
            singularTarget = "ہوائی اڈہ",
            singularBnPron = "হাওয়াই আড্ডা",
            pluralTarget = "ہوائی اڈے",
            pluralBnPron = "হাওয়াই আড্ডে",
            bnMeaning = "বিমানবন্দর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_325",
            category = VocabCategory.PLACES,
            singularTarget = "ریلوے اسٹیشن",
            singularBnPron = "রেলওয়ে স্টেশন",
            pluralTarget = "ریلوے اسٹیشن",
            pluralBnPron = "রেলওয়ে স্টেশন",
            bnMeaning = "রেলওয়ে স্টেশন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_326",
            category = VocabCategory.PLACES,
            singularTarget = "بس اسٹاپ",
            singularBnPron = "বাস স্টপ",
            pluralTarget = "بس اسٹاپ",
            pluralBnPron = "বাস স্টপ",
            bnMeaning = "বাস স্টপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_327",
            category = VocabCategory.PLACES,
            singularTarget = "بندرگاہ",
            singularBnPron = "বন্দরগাহ",
            pluralTarget = "بندرگاہیں",
            pluralBnPron = "বন্দরগাহেঁ",
            bnMeaning = "বন্দর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_328",
            category = VocabCategory.PLACES,
            singularTarget = "تھانہ",
            singularBnPron = "থানা",
            pluralTarget = "تھانے",
            pluralBnPron = "থানে",
            bnMeaning = "পুলিশ স্টেশন / থানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_329",
            category = VocabCategory.PLACES,
            singularTarget = "ڈاک خانہ",
            singularBnPron = "ডাক খানা",
            pluralTarget = "ڈاک خانے",
            pluralBnPron = "ডাক খানে",
            bnMeaning = "ডাকঘর / পোস্ট অফিস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_330",
            category = VocabCategory.PLACES,
            singularTarget = "سینما گھر",
            singularBnPron = "সিনেমা ঘর",
            pluralTarget = "سینما گھر",
            pluralBnPron = "সিনেমা ঘর",
            bnMeaning = "প্রেক্ষাগৃহ / সিনেমা হল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_331",
            category = VocabCategory.PLACES,
            singularTarget = "اسٹیڈیم",
            singularBnPron = "স্টেডিয়াম",
            pluralTarget = "اسٹیڈیم",
            pluralBnPron = "স্টেডিয়াম",
            bnMeaning = "স্টেডিয়াম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_332",
            category = VocabCategory.PLACES,
            singularTarget = "جم",
            singularBnPron = "জিম",
            pluralTarget = "جم",
            pluralBnPron = "জিম",
            bnMeaning = "ব্যায়ামাগার / জিম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_333",
            category = VocabCategory.PLACES,
            singularTarget = "مسجد",
            singularBnPron = "মসজিদ",
            pluralTarget = "مساجد",
            pluralBnPron = "মাসাজিদ",
            bnMeaning = "মসজিদ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_334",
            category = VocabCategory.PLACES,
            singularTarget = "مندر",
            singularBnPron = "মন্দির",
            pluralTarget = "مندر",
            pluralBnPron = "মন্দির",
            bnMeaning = "মন্দির",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_335",
            category = VocabCategory.PLACES,
            singularTarget = "گرجا گھر",
            singularBnPron = "গিরজা ঘর",
            pluralTarget = "گرجا گھر",
            pluralBnPron = "গিরজা ঘর",
            bnMeaning = "গির্জা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_336",
            category = VocabCategory.PLACES,
            singularTarget = "سفارت خانہ",
            singularBnPron = "সিফারাত খানা",
            pluralTarget = "سفارت خانے",
            pluralBnPron = "সিফারাত খানে",
            bnMeaning = "দূতাবাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_337",
            category = VocabCategory.PLACES,
            singularTarget = "دفتر",
            singularBnPron = "দফতর",
            pluralTarget = "دفاتر",
            pluralBnPron = "দফাতের",
            bnMeaning = "কার্যালয় / অফিস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_338",
            category = VocabCategory.PLACES,
            singularTarget = "کارخانہ",
            singularBnPron = "কারখানা",
            pluralTarget = "کارخانے",
            pluralBnPron = "কারখানে",
            bnMeaning = "কারখানা / ফ্যাক্টরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_339",
            category = VocabCategory.PLACES,
            singularTarget = "عمارت",
            singularBnPron = "ইমারত",
            pluralTarget = "عمارات",
            pluralBnPron = "ইমারাত",
            bnMeaning = "দালান / ভবন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_340",
            category = VocabCategory.PLACES,
            singularTarget = "مینار",
            singularBnPron = "মিনার",
            pluralTarget = "میناریں",
            pluralBnPron = "মিনারেঁ",
            bnMeaning = "মিনার / টাওয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_341",
            category = VocabCategory.PLACES,
            singularTarget = "محل",
            singularBnPron = "মহল",
            pluralTarget = "محلات",
            pluralBnPron = "মহলাত",
            bnMeaning = "প্রাসাদ / রাজপ্রাসাদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_342",
            category = VocabCategory.PLACES,
            singularTarget = "قلعہ",
            singularBnPron = "কিলা",
            pluralTarget = "قلعے",
            pluralBnPron = "কিলে",
            bnMeaning = "দুর্গ / কেল্লা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_343",
            category = VocabCategory.PLACES,
            singularTarget = "چوک",
            singularBnPron = "চক",
            pluralTarget = "چوک",
            pluralBnPron = "চক",
            bnMeaning = "চত্বর / প্লাজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_344",
            category = VocabCategory.PLACES,
            singularTarget = "چڑیا گھر",
            singularBnPron = "চিড়িয়া ঘর",
            pluralTarget = "چڑیا گھر",
            pluralBnPron = "চিড়িয়া ঘর",
            bnMeaning = "চিড়িয়াখানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_345",
            category = VocabCategory.PLACES,
            singularTarget = "ساحل",
            singularBnPron = "সাহিল",
            pluralTarget = "سواحل",
            pluralBnPron = "সাওয়াহিল",
            bnMeaning = "সমুদ্র সৈকত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_346",
            category = VocabCategory.PLACES,
            singularTarget = "جھیل",
            singularBnPron = "ঝিল",
            pluralTarget = "جھیلیں",
            pluralBnPron = "ঝিলেঁ",
            bnMeaning = "হ্রদ / লেক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_347",
            category = VocabCategory.PLACES,
            singularTarget = "پہاڑ",
            singularBnPron = "পাহাড়",
            pluralTarget = "پہاڑ",
            pluralBnPron = "পাহাড়",
            bnMeaning = "পর্বত / পাহাড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_348",
            category = VocabCategory.PLACES,
            singularTarget = "جزیرہ",
            singularBnPron = "জাজিরা",
            pluralTarget = "جزائر",
            pluralBnPron = "জাজায়ের",
            bnMeaning = "দ্বীপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_349",
            category = VocabCategory.PLACES,
            singularTarget = "جنگل",
            singularBnPron = "জঙ্গল",
            pluralTarget = "جنگلات",
            pluralBnPron = "জঙ্গলাত",
            bnMeaning = "বন / জঙ্গল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_350",
            category = VocabCategory.PLACES,
            singularTarget = "ریگستان",
            singularBnPron = "রেগিস্ তান",
            pluralTarget = "ریگستان",
            pluralBnPron = "রেগিস্ তান",
            bnMeaning = "মরুভূমি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_351",
            category = VocabCategory.TRAVEL,
            singularTarget = "ریل گاڑی",
            singularBnPron = "রেল গাড়ি",
            pluralTarget = "ریل گاڑیاں",
            pluralBnPron = "রেল গাড়িয়াঁ",
            bnMeaning = "রেলগাড়ি / ট্রেন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_352",
            category = VocabCategory.TRAVEL,
            singularTarget = "بس",
            singularBnPron = "বাস",
            pluralTarget = "بسیں",
            pluralBnPron = "বাসেঁ",
            bnMeaning = "বাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_353",
            category = VocabCategory.TRAVEL,
            singularTarget = "گاڑی / کار",
            singularBnPron = "গাড়ি",
            pluralTarget = "گاڑیاں",
            pluralBnPron = "গাড়িয়াঁ",
            bnMeaning = "গাড়ি / কার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_354",
            category = VocabCategory.TRAVEL,
            singularTarget = "سائیکل",
            singularBnPron = "সাইকেল",
            pluralTarget = "سائیکلیں",
            pluralBnPron = "সাইকেলেঁ",
            bnMeaning = "সাইকেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_355",
            category = VocabCategory.TRAVEL,
            singularTarget = "موٹر سائیکل",
            singularBnPron = "মোটরসাইকেল",
            pluralTarget = "موٹر سائیکلیں",
            pluralBnPron = "মোটরসাইকেলেঁ",
            bnMeaning = "মোটরসাইকেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_356",
            category = VocabCategory.TRAVEL,
            singularTarget = "ہوائی جہاز",
            singularBnPron = "হাওয়াই জাহাজ",
            pluralTarget = "ہوائی جہاز",
            pluralBnPron = "হাওয়াই জাহাজ",
            bnMeaning = "উড়োজাহাজ / বিমান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_357",
            category = VocabCategory.TRAVEL,
            singularTarget = "کشتی",
            singularBnPron = "কিশতি",
            pluralTarget = "Reference",
            pluralBnPron = "কিশতিয়াঁ",
            bnMeaning = "নৌকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_358",
            category = VocabCategory.TRAVEL,
            singularTarget = "بحری جہاز",
            singularBnPron = "বহরী জাহাজ",
            pluralTarget = "بحری جہاز",
            pluralBnPron = "বহরী জাহাজ",
            bnMeaning = "জাহাজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_359",
            category = VocabCategory.TRAVEL,
            singularTarget = "ہیلی کاپٹر",
            singularBnPron = "হেলিকপ্টার",
            pluralTarget = "ہیلی کاپٹر",
            pluralBnPron = "হেলিকপ্টার",
            bnMeaning = "হেলিকপ্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_360",
            category = VocabCategory.TRAVEL,
            singularTarget = "ٹیکسی",
            singularBnPron = "ট্যাক্সি",
            pluralTarget = "ٹیکسیاں",
            pluralBnPron = "ট্যাক্সিয়াঁ",
            bnMeaning = "ট্যাক্সি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_361",
            category = VocabCategory.TRAVEL,
            singularTarget = "میٹرو",
            singularBnPron = "মেট্রো",
            pluralTarget = "میٹرو",
            pluralBnPron = "মেট্রো",
            bnMeaning = "মেট্রোরেল / পাতালরেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_362",
            category = VocabCategory.TRAVEL,
            singularTarget = "ٹکٹ",
            singularBnPron = "টিকেট",
            pluralTarget = "ٹکٹیں",
            pluralBnPron = "টিকেটেঁ",
            bnMeaning = "টিকেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_363",
            category = VocabCategory.TRAVEL,
            singularTarget = "پاسپورٹ",
            singularBnPron = "পাসপোর্ট",
            pluralTarget = "پاسپورٹ",
            pluralBnPron = "পাসপোর্ট",
            bnMeaning = "পাসপোর্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_364",
            category = VocabCategory.TRAVEL,
            singularTarget = "ویزا",
            singularBnPron = "ভিসা",
            pluralTarget = "ویزا",
            pluralBnPron = "ভিসা",
            bnMeaning = "ভিসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_365",
            category = VocabCategory.TRAVEL,
            singularTarget = "سامان",
            singularBnPron = "সামান",
            pluralTarget = "سامان",
            pluralBnPron = "সামান",
            bnMeaning = "মালামাল / লাগেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_366",
            category = VocabCategory.TRAVEL,
            singularTarget = "سوٹ کیس",
            singularBnPron = "স্যুটকেস",
            pluralTarget = "سوٹ کیس",
            pluralBnPron = "স্যুটকেস",
            bnMeaning = "স্যুটকেস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_367",
            category = VocabCategory.TRAVEL,
            singularTarget = "نقشہ",
            singularBnPron = "নকশা",
            pluralTarget = "نقشے",
            pluralBnPron = "নকশে",
            bnMeaning = "মানচিত্র / ম্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_368",
            category = VocabCategory.TRAVEL,
            singularTarget = "سفر",
            singularBnPron = "সফর",
            pluralTarget = "اسفار",
            pluralBnPron = "আসফার",
            bnMeaning = "ভ্রমণ / যাত্রা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_369",
            category = VocabCategory.TRAVEL,
            singularTarget = "سیاح",
            singularBnPron = "সায়্যাহ",
            pluralTarget = "سیاح",
            pluralBnPron = "সায়্যাহ",
            bnMeaning = "ট্যুরিস্ট / পর্যটক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_370",
            category = VocabCategory.TRAVEL,
            singularTarget = "رہنما / گائیڈ",
            singularBnPron = "রহনুমাহ",
            pluralTarget = "رہنما",
            pluralBnPron = "রহনুমাহ",
            bnMeaning = "গাইড / পথপ্রদর্শক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_371",
            category = VocabCategory.TRAVEL,
            singularTarget = "پلیٹ فارم",
            singularBnPron = "প্ল্যাটফর্ম",
            pluralTarget = "پلیٹ فارم",
            pluralBnPron = "প্ল্যাটফর্ম",
            bnMeaning = "প্ল্যাটফর্ম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_372",
            category = VocabCategory.TRAVEL,
            singularTarget = "پرواز",
            singularBnPron = "পরওয়াজ",
            pluralTarget = "پروازیں",
            pluralBnPron = "পরওয়াজেঁ",
            bnMeaning = "বিমান ফ্লাইট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_373",
            category = VocabCategory.TRAVEL,
            singularTarget = "مسافر",
            singularBnPron = "মুসাফির",
            pluralTarget = "مسافر",
            pluralBnPron = "মুসাফির",
            bnMeaning = "যাত্রী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_374",
            category = VocabCategory.TRAVEL,
            singularTarget = "ڈرائیور",
            singularBnPron = "ড্রাইভার",
            pluralTarget = "ڈرائیور",
            pluralBnPron = "ড্রাইভার",
            bnMeaning = "চালক / ড্রাইভার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_375",
            category = VocabCategory.TRAVEL,
            singularTarget = "پائلٹ",
            singularBnPron = "পাইলট",
            pluralTarget = "پائلٹ",
            pluralBnPron = "পাইলট",
            bnMeaning = "বিমানচালক / পাইলট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_376",
            category = VocabCategory.TRAVEL,
            singularTarget = "شاہراہ",
            singularBnPron = "শাহরাহ",
            pluralTarget = "شاہراہیں",
            pluralBnPron = "শাহরাহেঁ",
            bnMeaning = "মহাসড়ক / হাইওয়ে",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_377",
            category = VocabCategory.TRAVEL,
            singularTarget = "ٹریفک",
            singularBnPron = "ট্রাফিক",
            pluralTarget = "ٹریفک",
            pluralBnPron = "ট্রাফিক",
            bnMeaning = "ট্রাফিক / যানজট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_378",
            category = VocabCategory.TRAVEL,
            singularTarget = "ٹریفک سگنل",
            singularBnPron = "ট্রাফিক সিগন্যাল",
            pluralTarget = "ٹریفک سگنلز",
            pluralBnPron = "ট্রাফিক সিগন্যালস",
            bnMeaning = "ট্রাফিক লাইট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_379",
            category = VocabCategory.TRAVEL,
            singularTarget = "پٹرول / ایندھن",
            singularBnPron = "পেট্রোল",
            pluralTarget = "ایندھن",
            pluralBnPron = "পেট্রোল",
            bnMeaning = "জ্বালানি / পেট্রল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_380",
            category = VocabCategory.TRAVEL,
            singularTarget = "پہیہ",
            singularBnPron = "পাহিয়া",
            pluralTarget = "پہیے",
            pluralBnPron = "পাহিয়ে",
            bnMeaning = "চাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_381",
            category = VocabCategory.TRAVEL,
            singularTarget = "نشست / سیٹ",
            singularBnPron = "নিশস্ত",
            pluralTarget = "نشستیں",
            pluralBnPron = "নিশস্তেঁ",
            bnMeaning = "আসন / সিট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_382",
            category = VocabCategory.TRAVEL,
            singularTarget = "سیٹ بیلٹ",
            singularBnPron = "সিটবেল্ট",
            pluralTarget = "سیٹ بیلٹ",
            pluralBnPron = "সিটবেল্ট",
            bnMeaning = "সিটবেল্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_383",
            category = VocabCategory.TRAVEL,
            singularTarget = "سمت",
            singularBnPron = "সিমত",
            pluralTarget = "سمتیں",
            pluralBnPron = "সিমতেঁ",
            bnMeaning = "দিক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_384",
            category = VocabCategory.TRAVEL,
            singularTarget = "شمال",
            singularBnPron = "শিমাল",
            pluralTarget = "شمال",
            pluralBnPron = "শিমাল",
            bnMeaning = "উত্তর দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_385",
            category = VocabCategory.TRAVEL,
            singularTarget = "جنوب",
            singularBnPron = "জুনুব",
            pluralTarget = "جنوب",
            pluralBnPron = "জুনুব",
            bnMeaning = "দক্ষিণ দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_386",
            category = VocabCategory.TRAVEL,
            singularTarget = "مشرق",
            singularBnPron = "মাশরিক",
            pluralTarget = "مشرق",
            pluralBnPron = "মাশরিক",
            bnMeaning = "পূর্ব দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_387",
            category = VocabCategory.TRAVEL,
            singularTarget = "مغرب",
            singularBnPron = "মাগরিব",
            pluralTarget = "مغرب",
            pluralBnPron = "মাগরিব",
            bnMeaning = "পশ্চিম দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_388",
            category = VocabCategory.TRAVEL,
            singularTarget = "بائیں",
            singularBnPron = "বায়েঁ",
            pluralTarget = "بائیں",
            pluralBnPron = "বায়েঁ",
            bnMeaning = "বামে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_389",
            category = VocabCategory.TRAVEL,
            singularTarget = "دائیں",
            singularBnPron = "দায়েঁ",
            pluralTarget = "دائیں",
            pluralBnPron = "দায়েঁ",
            bnMeaning = "ডানে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_390",
            category = VocabCategory.TRAVEL,
            singularTarget = "سیدھا",
            singularBnPron = "সীধা",
            pluralTarget = "سیدھا",
            pluralBnPron = "সীধা",
            bnMeaning = "সোজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_391",
            category = VocabCategory.TRAVEL,
            singularTarget = "فاصلہ",
            singularBnPron = "ফাসিলা",
            pluralTarget = "فاصلے",
            pluralBnPron = "ফাসিলে",
            bnMeaning = "দূরত্ব",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_392",
            category = VocabCategory.TRAVEL,
            singularTarget = "کلومیٹر",
            singularBnPron = "কিলোমিটার",
            pluralTarget = "کلومیٹر",
            pluralBnPron = "কিলোমিটার",
            bnMeaning = "কিলোমিটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_393",
            category = VocabCategory.TRAVEL,
            singularTarget = "رفتار",
            singularBnPron = "রফতার",
            pluralTarget = "رفتاریں",
            pluralBnPron = "রফতারেঁ",
            bnMeaning = "গতি / স্পিড",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_394",
            category = VocabCategory.TRAVEL,
            singularTarget = "تاخیر",
            singularBnPron = "তাখীর",
            pluralTarget = "تاخیر",
            pluralBnPron = "তাখীর",
            bnMeaning = "দেরি / বিলম্ব",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_395",
            category = VocabCategory.TRAVEL,
            singularTarget = "آمد",
            singularBnPron = "আমদ",
            pluralTarget = "آمد",
            pluralBnPron = "আমদ",
            bnMeaning = "পৌঁছানো / আগমন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_396",
            category = VocabCategory.TRAVEL,
            singularTarget = "روانگی",
            singularBnPron = "রওয়ানগি",
            pluralTarget = "روانگی",
            pluralBnPron = "রওয়ানগি",
            bnMeaning = "প্রস্থান / রওয়ানা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_397",
            category = VocabCategory.TRAVEL,
            singularTarget = "اوقات نامہ",
            singularBnPron = "অওকাত নামা",
            pluralTarget = "اوقات نامے",
            pluralBnPron = "অওকাত নামে",
            bnMeaning = "ভ্রমণসূচি / শিডিউল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_398",
            category = VocabCategory.TRAVEL,
            singularTarget = "سرحد",
            singularBnPron = "সরহদ",
            pluralTarget = "سرحدیں",
            pluralBnPron = "সরহদেঁ",
            bnMeaning = "সীমান্ত / বর্ডার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_399",
            category = VocabCategory.TRAVEL,
            singularTarget = "کرایہ",
            singularBnPron = "কিরায়া",
            pluralTarget = "کرائے",
            pluralBnPron = "কিরায়ে",
            bnMeaning = "ভাড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_400",
            category = VocabCategory.TRAVEL,
            singularTarget = "منزل",
            singularBnPron = "মনজিল",
            pluralTarget = "منازل",
            pluralBnPron = "মানাজিল",
            bnMeaning = "গন্তব্য",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk5 = listOf(
        VocabItem(
            id = "ur_vocab_401",
            category = VocabCategory.EDUCATION,
            singularTarget = "کتاب",
            singularBnPron = "কিতাব",
            pluralTarget = "کتب",
            pluralBnPron = "কুতুব",
            bnMeaning = "বই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_402",
            category = VocabCategory.EDUCATION,
            singularTarget = "کاپی",
            singularBnPron = "কপি",
            pluralTarget = "کاپیاں",
            pluralBnPron = "কপিয়াঁ",
            bnMeaning = "খাতা / নোটবুক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_403",
            category = VocabCategory.EDUCATION,
            singularTarget = "قلم",
            singularBnPron = "কলম",
            pluralTarget = "اقلام",
            pluralBnPron = "আকলাম",
            bnMeaning = "কলম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_404",
            category = VocabCategory.EDUCATION,
            singularTarget = "پنسل",
            singularBnPron = "পেন্সিল",
            pluralTarget = "پنسلیں",
            pluralBnPron = "পেনসিলেঁ",
            bnMeaning = "পেন্সিল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_405",
            category = VocabCategory.EDUCATION,
            singularTarget = "ربر",
            singularBnPron = "রবার",
            pluralTarget = "ربر",
            pluralBnPron = "রবার",
            bnMeaning = "ইরেজার / রাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_406",
            category = VocabCategory.EDUCATION,
            singularTarget = "شارپنر",
            singularBnPron = "শার্পনার",
            pluralTarget = "شارپنر",
            pluralBnPron = "শার্পনার",
            bnMeaning = "শার্পনার / কাটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_407",
            category = VocabCategory.EDUCATION,
            singularTarget = "پیمانہ",
            singularBnPron = "পয়মানা",
            pluralTarget = "پیمانے",
            pluralBnPron = "পয়মানে",
            bnMeaning = "স্কেল / রুলার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_408",
            category = VocabCategory.EDUCATION,
            singularTarget = "بستہ",
            singularBnPron = "বস্তা",
            pluralTarget = "بستے",
            pluralBnPron = "বস্তে",
            bnMeaning = "স্কুল ব্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_409",
            category = VocabCategory.EDUCATION,
            singularTarget = "تختہ سیاہ",
            singularBnPron = "তখতা সিয়া",
            pluralTarget = "تختے",
            pluralBnPron = "তখতে",
            bnMeaning = "বোর্ড / ব্ল্যাকবোর্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_410",
            category = VocabCategory.EDUCATION,
            singularTarget = "چاک",
            singularBnPron = "চক",
            pluralTarget = "چاک",
            pluralBnPron = "চক",
            bnMeaning = "চক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_411",
            category = VocabCategory.EDUCATION,
            singularTarget = "مارکر",
            singularBnPron = "মার্কার",
            pluralTarget = "مارکر",
            pluralBnPron = "মার্কার",
            bnMeaning = "মার্কার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_412",
            category = VocabCategory.EDUCATION,
            singularTarget = "کاغذ",
            singularBnPron = "কাগজ",
            pluralTarget = "کاغذات",
            pluralBnPron = "কাগজাত",
            bnMeaning = "কাগজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_413",
            category = VocabCategory.EDUCATION,
            singularTarget = "صفحہ",
            singularBnPron = "সাফহা",
            pluralTarget = "صفحات",
            pluralBnPron = "সাফহাত",
            bnMeaning = "পৃষ্ঠা / পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_414",
            category = VocabCategory.EDUCATION,
            singularTarget = "سوال",
            singularBnPron = "সোয়াল",
            pluralTarget = "سوالات",
            pluralBnPron = "সোয়ালাত",
            bnMeaning = "প্রশ্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_415",
            category = VocabCategory.EDUCATION,
            singularTarget = "جواب",
            singularBnPron = "জবাব",
            pluralTarget = "جوابات",
            pluralBnPron = "জবাবাত",
            bnMeaning = "উত্তর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_416",
            category = VocabCategory.EDUCATION,
            singularTarget = "امتحان",
            singularBnPron = "ইমতিহান",
            pluralTarget = "امتحانات",
            pluralBnPron = "ইমতিহানাত",
            bnMeaning = "পরীক্ষা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_417",
            category = VocabCategory.EDUCATION,
            singularTarget = "نتیجہ",
            singularBnPron = "নতিজা",
            pluralTarget = "نتائج",
            pluralBnPron = "নাতায়েজ",
            bnMeaning = "ফলাফল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_418",
            category = VocabCategory.EDUCATION,
            singularTarget = "نمبر / گریڈ",
            singularBnPron = "নম্বর",
            pluralTarget = "نمبرز",
            pluralBnPron = "নম্বরস",
            bnMeaning = "নম্বর / গ্রেড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_419",
            category = VocabCategory.EDUCATION,
            singularTarget = "گھر کا کام",
            singularBnPron = "ঘর কা কাম",
            pluralTarget = "کام",
            pluralBnPron = "ঘর কা কাম",
            bnMeaning = "বাড়ির কাজ / হোমওয়ার্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_420",
            category = VocabCategory.EDUCATION,
            singularTarget = "سبق",
            singularBnPron = "সবক",
            pluralTarget = "اسباق",
            pluralBnPron = "আসবাক",
            bnMeaning = "পাঠ / অধ্যায়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_421",
            category = VocabCategory.EDUCATION,
            singularTarget = "مضمون",
            singularBnPron = "মাজমুন",
            pluralTarget = "مضامین",
            pluralBnPron = "মাজামিন",
            bnMeaning = "বিষয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_422",
            category = VocabCategory.EDUCATION,
            singularTarget = "ریاضی",
            singularBnPron = "রিয়াজি",
            pluralTarget = "ریاضی",
            pluralBnPron = "রিয়াজি",
            bnMeaning = "গণিত",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_423",
            category = VocabCategory.EDUCATION,
            singularTarget = "سائنس",
            singularBnPron = "সাইন্স",
            pluralTarget = "سائنس",
            pluralBnPron = "সাইন্স",
            bnMeaning = "বিজ্ঞান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_424",
            category = VocabCategory.EDUCATION,
            singularTarget = "تاریخ",
            singularBnPron = "তারিখ",
            pluralTarget = "تواریخ",
            pluralBnPron = "তাওয়ারিখ",
            bnMeaning = "ইতিহাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_425",
            category = VocabCategory.EDUCATION,
            singularTarget = "جغرافیہ",
            singularBnPron = "জোগরাফিয়া",
            pluralTarget = "جغرافیہ",
            pluralBnPron = "জোগরাফিয়া",
            bnMeaning = "ভূগোল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_426",
            category = VocabCategory.EDUCATION,
            singularTarget = "زبان",
            singularBnPron = "জবান",
            pluralTarget = "زبانیں",
            pluralBnPron = "জবানেঁ",
            bnMeaning = "ভাষা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_427",
            category = VocabCategory.EDUCATION,
            singularTarget = "ادب",
            singularBnPron = "আদব",
            pluralTarget = "ادب",
            pluralBnPron = "আদব",
            bnMeaning = "সাহিত্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_428",
            category = VocabCategory.EDUCATION,
            singularTarget = "فن",
            singularBnPron = "ফন",
            pluralTarget = "فنون",
            pluralBnPron = "ফুনুন",
            bnMeaning = "শিল্পকলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_429",
            category = VocabCategory.EDUCATION,
            singularTarget = "موسیقی",
            singularBnPron = "মৌসিকি",
            pluralTarget = "موسیقی",
            pluralBnPron = "মৌসিকি",
            bnMeaning = "সঙ্গীত",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_430",
            category = VocabCategory.EDUCATION,
            singularTarget = "کلاس روم",
            singularBnPron = "ক্লাসরুম",
            pluralTarget = "کلاس رومز",
            pluralBnPron = "ক্লাসরুমস",
            bnMeaning = "শ্রেণিকক্ষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_431",
            category = VocabCategory.EDUCATION,
            singularTarget = "جماعت",
            singularBnPron = "জামায়াত",
            pluralTarget = "جماعتیں",
            pluralBnPron = "জামায়াতেঁ",
            bnMeaning = "শ্রেণি / ক্লাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_432",
            category = VocabCategory.EDUCATION,
            singularTarget = "پروفیسر",
            singularBnPron = "প্রফেসর",
            pluralTarget = "پروفیسرز",
            pluralBnPron = "প্রফেসর",
            bnMeaning = "অধ্যাপক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_433",
            category = VocabCategory.EDUCATION,
            singularTarget = "پرنسپل",
            singularBnPron = "প্রিন্সিপাল",
            pluralTarget = "پرنسپلز",
            pluralBnPron = "প্রিন্সিপাল",
            bnMeaning = "প্রধান শিক্ষক / অধ্যক্ষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_434",
            category = VocabCategory.EDUCATION,
            singularTarget = "ڈگری",
            singularBnPron = "ডিগ্রি",
            pluralTarget = "ڈگریاں",
            pluralBnPron = "ডিগ্রিয়াঁ",
            bnMeaning = "ডিগ্রি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_435",
            category = VocabCategory.EDUCATION,
            singularTarget = "سند",
            singularBnPron = "সনদ",
            pluralTarget = "اسناد",
            pluralBnPron = "আসনাদ",
            bnMeaning = "সনদপত্র / ডিপ্লোমা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_436",
            category = VocabCategory.EDUCATION,
            singularTarget = "علم",
            singularBnPron = "এলম",
            pluralTarget = "علوم",
            pluralBnPron = "উলুম",
            bnMeaning = "জ্ঞান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_437",
            category = VocabCategory.EDUCATION,
            singularTarget = "مطالعہ",
            singularBnPron = "মুতালাআ",
            pluralTarget = "مطالعہ",
            pluralBnPron = "মুতালাআ",
            bnMeaning = "পড়াশোনা / অধ্যয়ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_438",
            category = VocabCategory.EDUCATION,
            singularTarget = "لیکچر",
            singularBnPron = "লেকচার",
            pluralTarget = "لیکچرز",
            pluralBnPron = "লেকচার",
            bnMeaning = "বক্তৃতা / লেকচার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_439",
            category = VocabCategory.EDUCATION,
            singularTarget = "مسئلہ",
            singularBnPron = "মাসয়ালা",
            pluralTarget = "مسائل",
            pluralBnPron = "মাসায়েল",
            bnMeaning = "সমস্যা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_440",
            category = VocabCategory.EDUCATION,
            singularTarget = "حل",
            singularBnPron = "হল",
            pluralTarget = "حلول",
            pluralBnPron = "হুলুল",
            bnMeaning = "সমাধান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_441",
            category = VocabCategory.EDUCATION,
            singularTarget = "لغت",
            singularBnPron = "লুগাত",
            pluralTarget = "لغات",
            pluralBnPron = "লুগাত",
            bnMeaning = "অভিধান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_442",
            category = VocabCategory.EDUCATION,
            singularTarget = "چھٹی",
            singularBnPron = "ছুট্টি",
            pluralTarget = "چھٹیاں",
            pluralBnPron = "ছুট্টিয়াঁ",
            bnMeaning = "ছুটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_443",
            category = VocabCategory.EDUCATION,
            singularTarget = "لفظ",
            singularBnPron = "লফজ",
            pluralTarget = "الفاظ",
            pluralBnPron = "আলফাজ",
            bnMeaning = "শব্দ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_444",
            category = VocabCategory.EDUCATION,
            singularTarget = "جملہ",
            singularBnPron = "জুমলা",
            pluralTarget = "جملے",
            pluralBnPron = "জুমলে",
            bnMeaning = "বাক্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_445",
            category = VocabCategory.EDUCATION,
            singularTarget = "معنی",
            singularBnPron = "মা'নে",
            pluralTarget = "معانی",
            pluralBnPron = "মা'আনি",
            bnMeaning = "অর্থ / মানে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_446",
            category = VocabCategory.EDUCATION,
            singularTarget = "حروف تہجی",
            singularBnPron = "হুরুফ এ তাহাজ্জি",
            pluralTarget = "حروف",
            pluralBnPron = "হুরুফ",
            bnMeaning = "বর্ণমালা / অক্ষর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_447",
            category = VocabCategory.EDUCATION,
            singularTarget = "قواعد",
            singularBnPron = "কাওয়ায়েদ",
            pluralTarget = "قواعد",
            pluralBnPron = "কাওয়ায়েদ",
            bnMeaning = "ব্যাকরণ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_448",
            category = VocabCategory.EDUCATION,
            singularTarget = "تلفظ",
            singularBnPron = "তালাফফুজ",
            pluralTarget = "تلفظ",
            pluralBnPron = "তালাফফুজ",
            bnMeaning = "উচ্চারণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_449",
            category = VocabCategory.EDUCATION,
            singularTarget = "مشق",
            singularBnPron = "মাশক",
            pluralTarget = "مشقیں",
            pluralBnPron = "মাশকেঁ",
            bnMeaning = "অনুশীলন / চর্চা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_450",
            category = VocabCategory.EDUCATION,
            singularTarget = "غلطی",
            singularBnPron = "গলতি",
            pluralTarget = "غلطیاں",
            pluralBnPron = "গলতিয়াঁ",
            bnMeaning = "ভুল / ত্রুটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_451",
            category = VocabCategory.WORK,
            singularTarget = "نوکری",
            singularBnPron = "নকরি",
            pluralTarget = "نوکریاں",
            pluralBnPron = "নকরিয়াঁ",
            bnMeaning = "চাকরি / পেশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_452",
            category = VocabCategory.WORK,
            singularTarget = "کام کی جگہ",
            singularBnPron = "কাম কি জাগাহ",
            pluralTarget = "جگہیں",
            pluralBnPron = "জাগাহেঁ",
            bnMeaning = "কাজের জায়গা / কর্মস্থল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_453",
            category = VocabCategory.WORK,
            singularTarget = "باس / افسر",
            singularBnPron = "বস",
            pluralTarget = "افسران",
            pluralBnPron = "আফসারান",
            bnMeaning = "মালিক / বস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_454",
            category = VocabCategory.WORK,
            singularTarget = "ملازم",
            singularBnPron = "মুলাযিম",
            pluralTarget = "ملازمین",
            pluralBnPron = "মুলাযিমিন",
            bnMeaning = "কর্মচারী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_455",
            category = VocabCategory.WORK,
            singularTarget = "مزدور",
            singularBnPron = "মজদুর",
            pluralTarget = "مزدور",
            pluralBnPron = "মজদুর",
            bnMeaning = "শ্রমিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_456",
            category = VocabCategory.WORK,
            singularTarget = "تنخواہ",
            singularBnPron = "তনখা",
            pluralTarget = "تنخواہیں",
            pluralBnPron = "তনখাহেঁ",
            bnMeaning = "বেতন / পারিশ্রমিক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_457",
            category = VocabCategory.WORK,
            singularTarget = "انٹرویو",
            singularBnPron = "ইন্টারভিউ",
            pluralTarget = "انٹرویوز",
            pluralBnPron = "ইন্টারভিউস",
            bnMeaning = "মৌখিক পরীক্ষা / সাক্ষাৎকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_458",
            category = VocabCategory.WORK,
            singularTarget = "اجلاس / میٹنگ",
            singularBnPron = "ইজলাস",
            pluralTarget = "اجلاس",
            pluralBnPron = "ইজলাস",
            bnMeaning = "বৈঠক / সভা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_459",
            category = VocabCategory.WORK,
            singularTarget = "معاہدہ",
            singularBnPron = "মুয়াহিদা",
            pluralTarget = "معاہدات",
            pluralBnPron = "মুয়াহিদাত",
            bnMeaning = "চুক্তিপত্র / চুক্তি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_460",
            category = VocabCategory.WORK,
            singularTarget = "منصوبہ",
            singularBnPron = "মানসুবা",
            pluralTarget = "منصوبے",
            pluralBnPron = "মানসুবে",
            bnMeaning = "প্রকল্প / প্রজেক্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_461",
            category = VocabCategory.WORK,
            singularTarget = "رپورٹ",
            singularBnPron = "রিপোর্ট",
            pluralTarget = "رپورٹیں",
            pluralBnPron = "রিপোর্টেঁ",
            bnMeaning = "প্রতিবেদন / রিপোর্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_462",
            category = VocabCategory.WORK,
            singularTarget = "کاروبار",
            singularBnPron = "কারবার",
            pluralTarget = "کاروبار",
            pluralBnPron = "কারবার",
            bnMeaning = "ব্যবসা / বাণিজ্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_463",
            category = VocabCategory.WORK,
            singularTarget = "کمپنی",
            singularBnPron = "কোম্পানি",
            pluralTarget = "کمپنیاں",
            pluralBnPron = "কোম্পানিয়াঁ",
            bnMeaning = "কোম্পানি / প্রতিষ্ঠান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_464",
            category = VocabCategory.WORK,
            singularTarget = "گاہک",
            singularBnPron = "গাহাক",
            pluralTarget = "گاہک",
            pluralBnPron = "গাহাক",
            bnMeaning = "গ্রাহক / খরিদ্দার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_465",
            category = VocabCategory.WORK,
            singularTarget = "خدمت",
            singularBnPron = "খিদমত",
            pluralTarget = "خدمات",
            pluralBnPron = "খিদমাত",
            bnMeaning = "সেবা / সার্ভিস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_466",
            category = VocabCategory.WORK,
            singularTarget = "کام / فریضہ",
            singularBnPron = "কাম",
            pluralTarget = "فرائض",
            pluralBnPron = "কাম",
            bnMeaning = "কাজ / কার্যভার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_467",
            category = VocabCategory.WORK,
            singularTarget = "فرض",
            singularBnPron = "ফরজ",
            pluralTarget = "فرائض",
            pluralBnPron = "ফারায়েজ",
            bnMeaning = "দায়িত্ব / কর্তব্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_468",
            category = VocabCategory.WORK,
            singularTarget = "ڈیوٹی کی باری",
            singularBnPron = "বারি",
            pluralTarget = "باریاں",
            pluralBnPron = "বারিয়াঁ",
            bnMeaning = "পালা / শিফট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_469",
            category = VocabCategory.WORK,
            singularTarget = "بونس",
            singularBnPron = "বোনাস",
            pluralTarget = "بونس",
            pluralBnPron = "বোনাস",
            bnMeaning = "বোনাস / অতিরিক্ত ভাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_470",
            category = VocabCategory.WORK,
            singularTarget = "ترقی",
            singularBnPron = "তরক্কী",
            pluralTarget = "ترقیاں",
            pluralBnPron = "তরক্কিয়াঁ",
            bnMeaning = "পদোন্নতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_471",
            category = VocabCategory.WORK,
            singularTarget = "کیریئر",
            singularBnPron = "ক্যারিয়ার",
            pluralTarget = "کیریئر",
            pluralBnPron = "ক্যারিয়ার",
            bnMeaning = "পেশাজীবন / ক্যারিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_472",
            category = VocabCategory.WORK,
            singularTarget = "استعفیٰ",
            singularBnPron = "ইস্তিফা",
            pluralTarget = "استعفے",
            pluralBnPron = "ইস্তিফে",
            bnMeaning = "পদত্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_473",
            category = VocabCategory.WORK,
            singularTarget = "ریٹائرمنٹ",
            singularBnPron = "রিটায়ারমেন্ট",
            pluralTarget = "ریٹائرمنٹ",
            pluralBnPron = "রিটায়ারমেন্ট",
            bnMeaning = "অবসর গ্রহণ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_474",
            category = VocabCategory.WORK,
            singularTarget = "ہڑتال",
            singularBnPron = "হরতাল",
            pluralTarget = "ہڑتالیں",
            pluralBnPron = "হরতালেঁ",
            bnMeaning = "ধর্মঘট / স্ট্রাইক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_475",
            category = VocabCategory.WORK,
            singularTarget = "کامیابی",
            singularBnPron = "কামিয়াবি",
            pluralTarget = "کامیابیاں",
            pluralBnPron = "কামিয়াবিয়াঁ",
            bnMeaning = "সাফল্য",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_476",
            category = VocabCategory.WORK,
            singularTarget = "ڈاکٹر",
            singularBnPron = "ডাক্তার",
            pluralTarget = "ڈاکٹرز",
            pluralBnPron = "ডাক্তার",
            bnMeaning = "চিকিৎসক / ডাক্তার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_477",
            category = VocabCategory.WORK,
            singularTarget = "نرس",
            singularBnPron = "নার্স",
            pluralTarget = "نرسیں",
            pluralBnPron = "নার্সেঁ",
            bnMeaning = "সেবিকা / নার্স",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_478",
            category = VocabCategory.WORK,
            singularTarget = "انجینئر",
            singularBnPron = "ইঞ্জিনিয়ার",
            pluralTarget = "انجینئرز",
            pluralBnPron = "ইঞ্জিনিয়ার",
            bnMeaning = "প্রকৌশলী / ইঞ্জিনিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_479",
            category = VocabCategory.WORK,
            singularTarget = "وکیل",
            singularBnPron = "উকিল",
            pluralTarget = "وکلاء",
            pluralBnPron = "ভুকোলা",
            bnMeaning = "আইনজীবী / উকিল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_480",
            category = VocabCategory.WORK,
            singularTarget = "پولیس اہلکار",
            singularBnPron = "পুলিশ আহলকার",
            pluralTarget = "اہلکار",
            pluralBnPron = "আহলকার",
            bnMeaning = "পুলিশ কর্মকর্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_481",
            category = VocabCategory.WORK,
            singularTarget = "فائر فائٹر",
            singularBnPron = "ফায়ার ফাইটার",
            pluralTarget = "فائر فائٹرز",
            pluralBnPron = "ফায়ার ফাইটার্স",
            bnMeaning = "দমকলকর্মী / ফায়ারফাইটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_482",
            category = VocabCategory.WORK,
            singularTarget = "کسان",
            singularBnPron = "কিসান",
            pluralTarget = "کسان",
            pluralBnPron = "কিসান",
            bnMeaning = "কৃষক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_483",
            category = VocabCategory.WORK,
            singularTarget = "بڑھئی",
            singularBnPron = "বারহাই",
            pluralTarget = "بڑھئی",
            pluralBnPron = "বারহাই",
            bnMeaning = "কাঠমিস্ত্রি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_484",
            category = VocabCategory.WORK,
            singularTarget = "الیکٹریشن",
            singularBnPron = "ইলেকট্রিশিয়ান",
            pluralTarget = "الیکٹریشن",
            pluralBnPron = "ইলেকট্রিশিয়ান",
            bnMeaning = "বিদ্যুৎমিস্ত্রি / ইলেক্ট্রিশিয়ান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_485",
            category = VocabCategory.WORK,
            singularTarget = "پلمبر",
            singularBnPron = "প্লাম্বার",
            pluralTarget = "پلمبر",
            pluralBnPron = "প্লাম্বার",
            bnMeaning = "প্লাম্বার / নলমিস্ত্রি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_486",
            category = VocabCategory.WORK,
            singularTarget = "درزی",
            singularBnPron = "দর্জি",
            pluralTarget = "درزی",
            pluralBnPron = "দর্জি",
            bnMeaning = "দর্জি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_487",
            category = VocabCategory.WORK,
            singularTarget = "حجام / نائی",
            singularBnPron = "হাজ্জাম",
            pluralTarget = "حجام",
            pluralBnPron = "হাজ্জাম",
            bnMeaning = "নাপিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_488",
            category = VocabCategory.WORK,
            singularTarget = "باورچی",
            singularBnPron = "বাওয়ারচি",
            pluralTarget = "باورچی",
            pluralBnPron = "বাওয়ারচি",
            bnMeaning = "বাবুর্চি / শেফ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_489",
            category = VocabCategory.WORK,
            singularTarget = "بیرا / ویٹر",
            singularBnPron = "বেয়ারা",
            pluralTarget = "بیرے",
            pluralBnPron = "বেয়ারে",
            bnMeaning = "ওয়েটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_490",
            category = VocabCategory.WORK,
            singularTarget = "خادمہ / ویٹریس",
            singularBnPron = "খাদিমা",
            pluralTarget = "خادمائیں",
            pluralBnPron = "খাদিমায়েঁ",
            bnMeaning = "ওয়েট্রেস / পরিচারিকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_491",
            category = VocabCategory.WORK,
            singularTarget = "سپاہی / فوجی",
            singularBnPron = "ফৌজি",
            pluralTarget = "فوجی",
            pluralBnPron = "ফৌজি",
            bnMeaning = "সৈনিক / সেনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_492",
            category = VocabCategory.WORK,
            singularTarget = "فنکار",
            singularBnPron = "ফনকার",
            pluralTarget = "فنکار",
            pluralBnPron = "ফনকার",
            bnMeaning = "শিল্পী / আর্টিস্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_493",
            category = VocabCategory.WORK,
            singularTarget = "مصنف / ادیب",
            singularBnPron = "মুসান্নিফ",
            pluralTarget = "مصنفین",
            pluralBnPron = "মুসান্নিফিন",
            bnMeaning = "লেখক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_494",
            category = VocabCategory.WORK,
            singularTarget = "سائنس دان",
            singularBnPron = "সাইন্সদান",
            pluralTarget = "سائنس دان",
            pluralBnPron = "সাইন্সদান",
            bnMeaning = "বিজ্ঞানী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_495",
            category = VocabCategory.WORK,
            singularTarget = "صحافی",
            singularBnPron = "সাহাফি",
            pluralTarget = "صحافی",
            pluralBnPron = "সাহাফি",
            bnMeaning = "সাংবাদিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_496",
            category = VocabCategory.WORK,
            singularTarget = "ماہر تعمیرات",
            singularBnPron = "মাহেরে তামিরাত",
            pluralTarget = "ماہرین",
            pluralBnPron = "মাহিরিন",
            bnMeaning = "স্থপতি / আর্কিটেক্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_497",
            category = VocabCategory.WORK,
            singularTarget = "عکاس / فوٹوگرافر",
            singularBnPron = "আক্কাস",
            pluralTarget = "عکاس",
            pluralBnPron = "আক্কাস",
            bnMeaning = "ফটোগ্রাফার / আলোকচিত্রী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_498",
            category = VocabCategory.WORK,
            singularTarget = "موسیقار",
            singularBnPron = "মৌসিকার",
            pluralTarget = "موسیقار",
            pluralBnPron = "মৌসিকার",
            bnMeaning = "সুরকার / সঙ্গীতজ্ঞ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_499",
            category = VocabCategory.WORK,
            singularTarget = "اداکار",
            singularBnPron = "আদাকার",
            pluralTarget = "اداکار",
            pluralBnPron = "আদাকার",
            bnMeaning = "অভিনেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_500",
            category = VocabCategory.WORK,
            singularTarget = "اداکارہ",
            singularBnPron = "আদাকারা",
            pluralTarget = "اداکارائیں",
            pluralBnPron = "আদাকারায়েঁ",
            bnMeaning = "অভিনেত্রী",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk6 = listOf(
        VocabItem(
            id = "ur_vocab_501",
            category = VocabCategory.NATURE,
            singularTarget = "درخت",
            singularBnPron = "দরাখত",
            pluralTarget = "درخت",
            pluralBnPron = "দরাখত",
            bnMeaning = "গাছ / বৃক্ষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_502",
            category = VocabCategory.NATURE,
            singularTarget = "پودا",
            singularBnPron = "পউদা",
            pluralTarget = "پودے",
            pluralBnPron = "পউদে",
            bnMeaning = "উদ্ভিদ / চারাগাছ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_503",
            category = VocabCategory.NATURE,
            singularTarget = "پھول",
            singularBnPron = "ফুল",
            pluralTarget = "پھول",
            pluralBnPron = "ফুল",
            bnMeaning = "ফুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_504",
            category = VocabCategory.NATURE,
            singularTarget = "پتہ",
            singularBnPron = "পত্তা",
            pluralTarget = "پتے",
            pluralBnPron = "পত্তে",
            bnMeaning = "পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_505",
            category = VocabCategory.NATURE,
            singularTarget = "جڑ",
            singularBnPron = "জড়",
            pluralTarget = "جڑیں",
            pluralBnPron = "জড়েঁ",
            bnMeaning = "শিকড় / মূল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_506",
            category = VocabCategory.NATURE,
            singularTarget = "شاخ",
            singularBnPron = "শাখ",
            pluralTarget = "شاخیں",
            pluralBnPron = "শাখেঁ",
            bnMeaning = "শাখা / ডাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_507",
            category = VocabCategory.NATURE,
            singularTarget = "بیج",
            singularBnPron = "বীজ",
            pluralTarget = "بیج",
            pluralBnPron = "বীজ",
            bnMeaning = "বীজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_508",
            category = VocabCategory.NATURE,
            singularTarget = "پہاڑی",
            singularBnPron = "পাহাড়ী",
            pluralTarget = "پہاڑیاں",
            pluralBnPron = "পাহাড়িয়াঁ",
            bnMeaning = "পাহাড় / টিলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_509",
            category = VocabCategory.NATURE,
            singularTarget = "سمندر",
            singularBnPron = "সমুন্দর",
            pluralTarget = "سمندر",
            pluralBnPron = "সমুন্দর",
            bnMeaning = "সমুদ্র / সাগর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_510",
            category = VocabCategory.NATURE,
            singularTarget = "لہر",
            singularBnPron = "লহর",
            pluralTarget = "لہریں",
            pluralBnPron = "লহরেঁ",
            bnMeaning = "ঢেউ / তরঙ্গ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_511",
            category = VocabCategory.NATURE,
            singularTarget = "آسمان",
            singularBnPron = "আসমান",
            pluralTarget = "آسمان",
            pluralBnPron = "আসমান",
            bnMeaning = "আকাশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_512",
            category = VocabCategory.NATURE,
            singularTarget = "بادل",
            singularBnPron = "বাদল",
            pluralTarget = "بادل",
            pluralBnPron = "বাদল",
            bnMeaning = "মেঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_513",
            category = VocabCategory.NATURE,
            singularTarget = "بارش",
            singularBnPron = "বারিশ",
            pluralTarget = "بارشیں",
            pluralBnPron = "বারিশেঁ",
            bnMeaning = "বৃষ্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_514",
            category = VocabCategory.NATURE,
            singularTarget = "برف",
            singularBnPron = "বরফ",
            pluralTarget = "برف",
            pluralBnPron = "বরফ",
            bnMeaning = "তুষার / বরফ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_515",
            category = VocabCategory.NATURE,
            singularTarget = "ہوا",
            singularBnPron = "হাওয়া",
            pluralTarget = "ہوائیں",
            pluralBnPron = "হাওয়াএঁ",
            bnMeaning = "বাতাস / বায়ু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_516",
            category = VocabCategory.NATURE,
            singularTarget = "طوفان",
            singularBnPron = "তুফান",
            pluralTarget = "طوفان",
            pluralBnPron = "তুফান",
            bnMeaning = "ঝড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_517",
            category = VocabCategory.NATURE,
            singularTarget = "سورج",
            singularBnPron = "সুরজ",
            pluralTarget = "سورج",
            pluralBnPron = "সুরজ",
            bnMeaning = "সূর্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_518",
            category = VocabCategory.NATURE,
            singularTarget = "چاند",
            singularBnPron = "চাঁদ",
            pluralTarget = "چاند",
            pluralBnPron = "চাঁদ",
            bnMeaning = "চাঁদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_519",
            category = VocabCategory.NATURE,
            singularTarget = "تارا / ستارہ",
            singularBnPron = "সিতারা",
            pluralTarget = "ستارے",
            pluralBnPron = "সিতারে",
            bnMeaning = "তারা / নক্ষত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_520",
            category = VocabCategory.NATURE,
            singularTarget = "مٹی",
            singularBnPron = "মিট্টি",
            pluralTarget = "مٹی",
            pluralBnPron = "মিট্টি",
            bnMeaning = "মাটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_521",
            category = VocabCategory.NATURE,
            singularTarget = "پتھر",
            singularBnPron = "পাথর",
            pluralTarget = "پتھر",
            pluralBnPron = "পাথর",
            bnMeaning = "পাথর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_522",
            category = VocabCategory.NATURE,
            singularTarget = "ریت",
            singularBnPron = "রেত",
            pluralTarget = "ریت",
            pluralBnPron = "রেত",
            bnMeaning = "বালু / বালি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_523",
            category = VocabCategory.NATURE,
            singularTarget = "گھاس",
            singularBnPron = "ঘাস",
            pluralTarget = "گھاس",
            pluralBnPron = "ঘাস",
            bnMeaning = "ঘাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_524",
            category = VocabCategory.NATURE,
            singularTarget = "آگ",
            singularBnPron = "আগ",
            pluralTarget = "آگ",
            pluralBnPron = "আগ",
            bnMeaning = "আগুন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_525",
            category = VocabCategory.NATURE,
            singularTarget = "پانی",
            singularBnPron = "পানি",
            pluralTarget = "پانی",
            pluralBnPron = "পানি",
            bnMeaning = "জল / পানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_526",
            category = VocabCategory.NATURE,
            singularTarget = "ہوا",
            singularBnPron = "হাওয়া",
            pluralTarget = "ہوا",
            pluralBnPron = "হাওয়া",
            bnMeaning = "বাতাস / আবহাওয়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_527",
            category = VocabCategory.NATURE,
            singularTarget = "موسم",
            singularBnPron = "মৌসম",
            pluralTarget = "موسم",
            pluralBnPron = "মৌসম",
            bnMeaning = "আবহাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_528",
            category = VocabCategory.NATURE,
            singularTarget = "درجہ حرارت",
            singularBnPron = "দারজাহ হারারাত",
            pluralTarget = "درجہ حرارت",
            pluralBnPron = "দারজাহ হারারাত",
            bnMeaning = "তাপমাত্রা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_529",
            category = VocabCategory.NATURE,
            singularTarget = "گرمی",
            singularBnPron = "গরমী",
            pluralTarget = "گرمی",
            pluralBnPron = "গরমী",
            bnMeaning = "গরম / তাপ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_530",
            category = VocabCategory.NATURE,
            singularTarget = "سردی / ٹھنڈ",
            singularBnPron = "ঠান্ড",
            pluralTarget = "ٹھنڈ",
            pluralBnPron = "ঠান্ড",
            bnMeaning = "ঠান্ডা / শীত",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_531",
            category = VocabCategory.NATURE,
            singularTarget = "برف",
            singularBnPron = "বরফ",
            pluralTarget = "برف",
            pluralBnPron = "বরফ",
            bnMeaning = "বরফ খণ্ড / আইস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_532",
            category = VocabCategory.NATURE,
            singularTarget = "گرج",
            singularBnPron = "গর্জ",
            pluralTarget = "گرج",
            pluralBnPron = "গর্জ",
            bnMeaning = "বজ্রপাত / মেঘের গর্জন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_533",
            category = VocabCategory.NATURE,
            singularTarget = "بجلی",
            singularBnPron = "বিজলী",
            pluralTarget = "بجلی",
            pluralBnPron = "বিজলী",
            bnMeaning = "বিদ্যুৎ চমক / বিজলী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_534",
            category = VocabCategory.NATURE,
            singularTarget = "قوس قزح",
            singularBnPron = "কওসে কুজাহ",
            pluralTarget = "قوس قزح",
            pluralBnPron = "কওসে কুজাহ",
            bnMeaning = "রংধনু / রামধনু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_535",
            category = VocabCategory.NATURE,
            singularTarget = "کہر / دھند",
            singularBnPron = "ধুন্দ",
            pluralTarget = "دھند",
            pluralBnPron = "ধুন্দ",
            bnMeaning = "কুয়াশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_536",
            category = VocabCategory.NATURE,
            singularTarget = "دھواں",
            singularBnPron = "ধূয়াঁ",
            pluralTarget = "دھواں",
            pluralBnPron = "ধূয়াঁ",
            bnMeaning = "ধোঁয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_537",
            category = VocabCategory.NATURE,
            singularTarget = "غار",
            singularBnPron = "গার",
            pluralTarget = "غاریں",
            pluralBnPron = "গারেঁ",
            bnMeaning = "গুহা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_538",
            category = VocabCategory.NATURE,
            singularTarget = "کھیت / میدان",
            singularBnPron = "খেত",
            pluralTarget = "کھیت",
            pluralBnPron = "খেত",
            bnMeaning = "মাঠ / প্রান্তর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_539",
            category = VocabCategory.NATURE,
            singularTarget = "وادی",
            singularBnPron = "ওয়াদী",
            pluralTarget = "وادیاں",
            pluralBnPron = "ওয়াদীয়াঁ",
            bnMeaning = "উপত্যকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_540",
            category = VocabCategory.NATURE,
            singularTarget = "بہار",
            singularBnPron = "বাহার",
            pluralTarget = "بہار",
            pluralBnPron = "বাহার",
            bnMeaning = "বসন্তকাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_541",
            category = VocabCategory.NATURE,
            singularTarget = "گرما",
            singularBnPron = "গরমা",
            pluralTarget = "گرما",
            pluralBnPron = "গরমা",
            bnMeaning = "গ্রীষ্মকাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_542",
            category = VocabCategory.NATURE,
            singularTarget = "خزاں",
            singularBnPron = "খিজাঁ",
            pluralTarget = "خزاں",
            pluralBnPron = "খিজাঁ",
            bnMeaning = "শরৎকাল / হেমন্ত",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_543",
            category = VocabCategory.NATURE,
            singularTarget = "سرما",
            singularBnPron = "সরমা",
            pluralTarget = "سرما",
            pluralBnPron = "সরমা",
            bnMeaning = "শীতকাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_544",
            category = VocabCategory.NATURE,
            singularTarget = "زمین",
            singularBnPron = "জমীন",
            pluralTarget = "زمین",
            pluralBnPron = "জমীন",
            bnMeaning = "পৃথিবী / ধরা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_545",
            category = VocabCategory.NATURE,
            singularTarget = "طلوع آفتاب",
            singularBnPron = "তুলু এ আফতাব",
            pluralTarget = "طلوع",
            pluralBnPron = "তুলু",
            bnMeaning = "সূর্যোদয় / ভোর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_546",
            category = VocabCategory.NATURE,
            singularTarget = "غروب آفتاب",
            singularBnPron = "গুরুব এ আফতাব",
            pluralTarget = "غروب",
            pluralBnPron = "গুরুব",
            bnMeaning = "সূর্যাস্ত / গোধূলি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_547",
            category = VocabCategory.NATURE,
            singularTarget = "آبشار",
            singularBnPron = "আবশার",
            pluralTarget = "آبشاریں",
            pluralBnPron = "আবশারেঁ",
            bnMeaning = "জলপ্রপাত / ঝরনা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_548",
            category = VocabCategory.NATURE,
            singularTarget = "چشمہ",
            singularBnPron = "চশমা",
            pluralTarget = "چشمے",
            pluralBnPron = "চশমে",
            bnMeaning = "ঝর্ণা / উৎস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_549",
            category = VocabCategory.NATURE,
            singularTarget = "ماحول",
            singularBnPron = "মাহল",
            pluralTarget = "ماحول",
            pluralBnPron = "মাহল",
            bnMeaning = "পরিবেশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_550",
            category = VocabCategory.NATURE,
            singularTarget = "قدرت",
            singularBnPron = "কুদরত",
            pluralTarget = "قدرت",
            pluralBnPron = "কুদরত",
            bnMeaning = "প্রকৃতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_551",
            category = VocabCategory.ANIMALS,
            singularTarget = "کتا",
            singularBnPron = "কুত্তা",
            pluralTarget = "کتے",
            pluralBnPron = "কুত্তে",
            bnMeaning = "কুকুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_552",
            category = VocabCategory.ANIMALS,
            singularTarget = "بلی",
            singularBnPron = "বিল্লী",
            pluralTarget = "بلیاں",
            pluralBnPron = "বিল্লিয়াঁ",
            bnMeaning = "বিড়াল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_553",
            category = VocabCategory.ANIMALS,
            singularTarget = "گائے",
            singularBnPron = "গায়",
            pluralTarget = "گائیں",
            pluralBnPron = "গায়েঁ",
            bnMeaning = "গরু / গাভী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_554",
            category = VocabCategory.ANIMALS,
            singularTarget = "بیل / سانڈ",
            singularBnPron = "বলদ",
            pluralTarget = "بیل",
            pluralBnPron = "বলদ",
            bnMeaning = "ষাঁড় / বলদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_555",
            category = VocabCategory.ANIMALS,
            singularTarget = "بھینس",
            singularBnPron = "ভৈঁস",
            pluralTarget = "بھینسیں",
            pluralBnPron = "ভৈঁসেঁ",
            bnMeaning = "মহিষ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_556",
            category = VocabCategory.ANIMALS,
            singularTarget = "بکری",
            singularBnPron = "বকরী",
            pluralTarget = "بکریاں",
            pluralBnPron = "বকরিয়াঁ",
            bnMeaning = "ছাগল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_557",
            category = VocabCategory.ANIMALS,
            singularTarget = "بھیڑ",
            singularBnPron = "ভেড়",
            pluralTarget = "بھیڑیں",
            pluralBnPron = "ভেড়েঁ",
            bnMeaning = "ভেড়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_558",
            category = VocabCategory.ANIMALS,
            singularTarget = "گھوڑا",
            singularBnPron = "ঘোড়া",
            pluralTarget = "گھوڑے",
            pluralBnPron = "ঘোড়ে",
            bnMeaning = "ঘোড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_559",
            category = VocabCategory.ANIMALS,
            singularTarget = "گدھا",
            singularBnPron = "গাধা",
            pluralTarget = "گدھے",
            pluralBnPron = "গাধে",
            bnMeaning = "গাধা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_560",
            category = VocabCategory.ANIMALS,
            singularTarget = "اونٹ",
            singularBnPron = "উট",
            pluralTarget = "اونٹ",
            pluralBnPron = "উট",
            bnMeaning = "উট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_561",
            category = VocabCategory.ANIMALS,
            singularTarget = "ہاتھی",
            singularBnPron = "হাতী",
            pluralTarget = "ہاتھی",
            pluralBnPron = "হাতী",
            bnMeaning = "হাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_562",
            category = VocabCategory.ANIMALS,
            singularTarget = "شیر",
            singularBnPron = "শের",
            pluralTarget = "شیر",
            pluralBnPron = "শের",
            bnMeaning = "সিংহ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_563",
            category = VocabCategory.ANIMALS,
            singularTarget = "چیتا / شیر",
            singularBnPron = "চিতা",
            pluralTarget = "چیتے",
            pluralBnPron = "চিতা",
            bnMeaning = "বাঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_564",
            category = VocabCategory.ANIMALS,
            singularTarget = "تیندوا",
            singularBnPron = "তেন্দুয়া",
            pluralTarget = "تیندُوے",
            pluralBnPron = "তেন্দুয়ে",
            bnMeaning = "চিতাবাঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_565",
            category = VocabCategory.ANIMALS,
            singularTarget = "ریچھ",
            singularBnPron = "রীচ",
            pluralTarget = "ریچھ",
            pluralBnPron = "রীচ",
            bnMeaning = "ভাল্লুক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_566",
            category = VocabCategory.ANIMALS,
            singularTarget = "بھیڑیا",
            singularBnPron = "ভেড়িয়া",
            pluralTarget = "بھیڑیے",
            pluralBnPron = "ভেড়িয়ে",
            bnMeaning = "নেকড়ে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_567",
            category = VocabCategory.ANIMALS,
            singularTarget = "لومڑی",
            singularBnPron = "লোমড়ী",
            pluralTarget = "لومڑیاں",
            pluralBnPron = "লোমড়িয়াঁ",
            bnMeaning = "শেয়াল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_568",
            category = VocabCategory.ANIMALS,
            singularTarget = "ہرن",
            singularBnPron = "হিরণ",
            pluralTarget = "ہرن",
            pluralBnPron = "হিরণ",
            bnMeaning = "হরিণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_569",
            category = VocabCategory.ANIMALS,
            singularTarget = "بندر",
            singularBnPron = "বান্দর",
            pluralTarget = "بندر",
            pluralBnPron = "বান্দর",
            bnMeaning = "বানর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_570",
            category = VocabCategory.ANIMALS,
            singularTarget = "خرگوش",
            singularBnPron = "খরগোশ",
            pluralTarget = "خرگوش",
            pluralBnPron = "খরগোশ",
            bnMeaning = "খরগোশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_571",
            category = VocabCategory.ANIMALS,
            singularTarget = "چوہا",
            singularBnPron = "চুহা",
            pluralTarget = "چوہے",
            pluralBnPron = "চুহে",
            bnMeaning = "ইঁদুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_572",
            category = VocabCategory.ANIMALS,
            singularTarget = "سانپ",
            singularBnPron = "সাপ",
            pluralTarget = "سانپ",
            pluralBnPron = "সাপ",
            bnMeaning = "সাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_573",
            category = VocabCategory.ANIMALS,
            singularTarget = "مینڈک",
            singularBnPron = "মেণ্ডক",
            pluralTarget = "مینڈک",
            pluralBnPron = "মেণ্ডক",
            bnMeaning = "ব্যাঙ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_574",
            category = VocabCategory.ANIMALS,
            singularTarget = "کچھوا",
            singularBnPron = "কছুয়া",
            pluralTarget = "کچھوے",
            pluralBnPron = "কছুয়ে",
            bnMeaning = "কচ্ছপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_575",
            category = VocabCategory.ANIMALS,
            singularTarget = "مگرمچھ",
            singularBnPron = "মগরমচ্ছ",
            pluralTarget = "مگرمچھ",
            pluralBnPron = "মগরমচ্ছ",
            bnMeaning = "কুমির",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_576",
            category = VocabCategory.ANIMALS,
            singularTarget = "مچھلی",
            singularBnPron = "মাছলী",
            pluralTarget = "مچھلیاں",
            pluralBnPron = "মাছলিয়াঁ",
            bnMeaning = "মাছ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_577",
            category = VocabCategory.ANIMALS,
            singularTarget = "شارک",
            singularBnPron = "শার্ক",
            pluralTarget = "شارک",
            pluralBnPron = "শার্ক",
            bnMeaning = "হাঙর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_578",
            category = VocabCategory.ANIMALS,
            singularTarget = "وہیل",
            singularBnPron = "হোয়েল",
            pluralTarget = "وہیل",
            pluralBnPron = "হোয়েল",
            bnMeaning = "তিমি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_579",
            category = VocabCategory.ANIMALS,
            singularTarget = "ڈولفن",
            singularBnPron = "ডলফিন",
            pluralTarget = "ڈولفن",
            pluralBnPron = "ডলফিন",
            bnMeaning = "ডলফিন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_580",
            category = VocabCategory.ANIMALS,
            singularTarget = "پرندہ",
            singularBnPron = "পারিন্দা",
            pluralTarget = "پرندے",
            pluralBnPron = "পারিন্দে",
            bnMeaning = "পাখি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_581",
            category = VocabCategory.ANIMALS,
            singularTarget = "کوا",
            singularBnPron = "কাউয়া",
            pluralTarget = "کوے",
            pluralBnPron = "কাউয়ে",
            bnMeaning = "কাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_582",
            category = VocabCategory.ANIMALS,
            singularTarget = "چڑیا",
            singularBnPron = "চিড়িয়া",
            pluralTarget = "چڑیاں",
            pluralBnPron = "চিড়িয়াঁ",
            bnMeaning = "চড়ুই পাখি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_583",
            category = VocabCategory.ANIMALS,
            singularTarget = "کبوتر",
            singularBnPron = "কবুতর",
            pluralTarget = "کبوتر",
            pluralBnPron = "কবুতর",
            bnMeaning = "কবুতর / পায়রা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_584",
            category = VocabCategory.ANIMALS,
            singularTarget = "عقاب",
            singularBnPron = "উকাব",
            pluralTarget = "عقاب",
            pluralBnPron = "উকাব",
            bnMeaning = "ঈগল পাখি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_585",
            category = VocabCategory.ANIMALS,
            singularTarget = "طوطا",
            singularBnPron = "তোতা",
            pluralTarget = "طوطے",
            pluralBnPron = "তোতে",
            bnMeaning = "তোতাপাখি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_586",
            category = VocabCategory.ANIMALS,
            singularTarget = "مور",
            singularBnPron = "মোর",
            pluralTarget = "مور",
            pluralBnPron = "মোর",
            bnMeaning = "ময়ূর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_587",
            category = VocabCategory.ANIMALS,
            singularTarget = "الو",
            singularBnPron = "উল্লু",
            pluralTarget = "الو",
            pluralBnPron = "উল্লু",
            bnMeaning = "পেঁচা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_588",
            category = VocabCategory.ANIMALS,
            singularTarget = "بطخ",
            singularBnPron = "বাত্তখ",
            pluralTarget = "بطخیں",
            pluralBnPron = "বাত্তখেঁ",
            bnMeaning = "হাঁস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_589",
            category = VocabCategory.ANIMALS,
            singularTarget = "ہنس",
            singularBnPron = "হংস",
            pluralTarget = "ہنس",
            pluralBnPron = "হংস",
            bnMeaning = "রাজহাঁস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_590",
            category = VocabCategory.ANIMALS,
            singularTarget = "مرغی",
            singularBnPron = "মুরগী",
            pluralTarget = "مرغیاں",
            pluralBnPron = "মুরগীয়াঁ",
            bnMeaning = "মুরগি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_591",
            category = VocabCategory.ANIMALS,
            singularTarget = "مرغا",
            singularBnPron = "মুরগা",
            pluralTarget = "مرغے",
            pluralBnPron = "মুরগে",
            bnMeaning = "মোরগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_592",
            category = VocabCategory.ANIMALS,
            singularTarget = "چمگادڑ",
            singularBnPron = "চমগাদড়",
            pluralTarget = "چمگادڑ",
            pluralBnPron = "চমগাদড়",
            bnMeaning = "বাদুড়",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_593",
            category = VocabCategory.ANIMALS,
            singularTarget = "شہد کی مکھی",
            singularBnPron = "শহদ কি মাখী",
            pluralTarget = "مکھیاں",
            pluralBnPron = "মাখীয়াঁ",
            bnMeaning = "মৌমাছি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_594",
            category = VocabCategory.ANIMALS,
            singularTarget = "تتلی",
            singularBnPron = "তিতলী",
            pluralTarget = "تتلیاں",
            pluralBnPron = "তিতলীয়াঁ",
            bnMeaning = "প্রজাপতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_595",
            category = VocabCategory.ANIMALS,
            singularTarget = "مچھر",
            singularBnPron = "মাচ্ছর",
            pluralTarget = "مچھر",
            pluralBnPron = "মাচ্ছর",
            bnMeaning = "মশা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_596",
            category = VocabCategory.ANIMALS,
            singularTarget = "مکھی",
            singularBnPron = "মাখী",
            pluralTarget = "مکھیاں",
            pluralBnPron = "মাখীয়াঁ",
            bnMeaning = "মাছি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_597",
            category = VocabCategory.ANIMALS,
            singularTarget = "چیونٹی",
            singularBnPron = "চিউঁটি",
            pluralTarget = "چیونٹیاں",
            pluralBnPron = "চিউঁটিয়াঁ",
            bnMeaning = "পিপঁড়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_598",
            category = VocabCategory.ANIMALS,
            singularTarget = "مکڑی",
            singularBnPron = "মকড়ী",
            pluralTarget = "مکڑیاں",
            pluralBnPron = "মকড়ীয়াঁ",
            bnMeaning = "মাকড়সা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_599",
            category = VocabCategory.ANIMALS,
            singularTarget = "بچھو",
            singularBnPron = "বিচ্ছু",
            pluralTarget = "بچھو",
            pluralBnPron = "বিচ্ছু",
            bnMeaning = "বিচ্ছু / কাঁকড়াবিছা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_600",
            category = VocabCategory.ANIMALS,
            singularTarget = "کینچوا",
            singularBnPron = "কেঁচূয়া",
            pluralTarget = "کینچوے",
            pluralBnPron = "কেঁচূয়ে",
            bnMeaning = "কেঁচো / কৃমি",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk7 = listOf(
        VocabItem(
            id = "ur_vocab_601",
            category = VocabCategory.ACTIONS,
            singularTarget = "کھانا",
            singularBnPron = "খানা",
            pluralTarget = "کھانا",
            pluralBnPron = "খানা",
            bnMeaning = "খাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_602",
            category = VocabCategory.ACTIONS,
            singularTarget = "پینا",
            singularBnPron = "পীনা",
            pluralTarget = "پینا",
            pluralBnPron = "পীনা",
            bnMeaning = "পান করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_603",
            category = VocabCategory.ACTIONS,
            singularTarget = "سونا",
            singularBnPron = "সোনা",
            pluralTarget = "سونا",
            pluralBnPron = "সোনা",
            bnMeaning = "ঘুমানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_604",
            category = VocabCategory.ACTIONS,
            singularTarget = "جاگنا",
            singularBnPron = "জাগনা",
            pluralTarget = "جاگنا",
            pluralBnPron = "জাগনা",
            bnMeaning = "জেগে ওঠা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_605",
            category = VocabCategory.ACTIONS,
            singularTarget = "چلنا",
            singularBnPron = "চলনা",
            pluralTarget = "چلنا",
            pluralBnPron = "চলনা",
            bnMeaning = "হাঁটা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_606",
            category = VocabCategory.ACTIONS,
            singularTarget = "دوڑنا",
            singularBnPron = "দৌড়না",
            pluralTarget = "دوڑنا",
            pluralBnPron = "দৌড়না",
            bnMeaning = "দৌড়ানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_607",
            category = VocabCategory.ACTIONS,
            singularTarget = "کودنا",
            singularBnPron = "কূদনা",
            pluralTarget = "کودنا",
            pluralBnPron = "কূদনা",
            bnMeaning = "লাফানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_608",
            category = VocabCategory.ACTIONS,
            singularTarget = "بیٹھنا",
            singularBnPron = "বৈতনা",
            pluralTarget = "بیٹھنا",
            pluralBnPron = "বৈতনা",
            bnMeaning = "বসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_609",
            category = VocabCategory.ACTIONS,
            singularTarget = "کھڑے ہونا",
            singularBnPron = "খড়ে হোনা",
            pluralTarget = "کھڑے ہونا",
            pluralBnPron = "খড়ে হোনা",
            bnMeaning = "দাঁড়ানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_610",
            category = VocabCategory.ACTIONS,
            singularTarget = "بولنا",
            singularBnPron = "বোলনা",
            pluralTarget = "بولنا",
            pluralBnPron = "বোলনা",
            bnMeaning = "কথা বলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_611",
            category = VocabCategory.ACTIONS,
            singularTarget = "کہنا",
            singularBnPron = "কহনা",
            pluralTarget = "کہنا",
            pluralBnPron = "কহনা",
            bnMeaning = "বলা / জানানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_612",
            category = VocabCategory.ACTIONS,
            singularTarget = "سننا",
            singularBnPron = "সুননা",
            pluralTarget = "سننا",
            pluralBnPron = "সুননা",
            bnMeaning = "শোনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_613",
            category = VocabCategory.ACTIONS,
            singularTarget = "دیکھنا",
            singularBnPron = "দেখনা",
            pluralTarget = "دیکھنا",
            pluralBnPron = "দেখনা",
            bnMeaning = "দেখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_614",
            category = VocabCategory.ACTIONS,
            singularTarget = "پڑھنا",
            singularBnPron = "পড়না",
            pluralTarget = "پڑھنا",
            pluralBnPron = "পড়না",
            bnMeaning = "পড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_615",
            category = VocabCategory.ACTIONS,
            singularTarget = "لکھنا",
            singularBnPron = "লিখনা",
            pluralTarget = "لکھنا",
            pluralBnPron = "লিখনা",
            bnMeaning = "লেখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_616",
            category = VocabCategory.ACTIONS,
            singularTarget = "سیکھنا",
            singularBnPron = "সীখনা",
            pluralTarget = "سیکھنا",
            pluralBnPron = "সীখনা",
            bnMeaning = "শেখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_617",
            category = VocabCategory.ACTIONS,
            singularTarget = "سکھانا",
            singularBnPron = "সিখানা",
            pluralTarget = "سکھانا",
            pluralBnPron = "সিখানা",
            bnMeaning = "শেখানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_618",
            category = VocabCategory.ACTIONS,
            singularTarget = "خریدنا",
            singularBnPron = "খরীদনা",
            pluralTarget = "خریدنا",
            pluralBnPron = "খরীদনা",
            bnMeaning = "কেনা / ক্রয় করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_619",
            category = VocabCategory.ACTIONS,
            singularTarget = "بیچنا",
            singularBnPron = "বেচনা",
            pluralTarget = "بیچنا",
            pluralBnPron = "বেচনা",
            bnMeaning = "বিক্রি করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_620",
            category = VocabCategory.ACTIONS,
            singularTarget = "دینا",
            singularBnPron = "দেনা",
            pluralTarget = "دینا",
            pluralBnPron = "দেনা",
            bnMeaning = "দেওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_621",
            category = VocabCategory.ACTIONS,
            singularTarget = "لینا",
            singularBnPron = "লেনা",
            pluralTarget = "لینا",
            pluralBnPron = "লেনা",
            bnMeaning = "নেওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_622",
            category = VocabCategory.ACTIONS,
            singularTarget = "کھولنا",
            singularBnPron = "খোলনা",
            pluralTarget = "کھولنا",
            pluralBnPron = "খোলনা",
            bnMeaning = "খোলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_623",
            category = VocabCategory.ACTIONS,
            singularTarget = "بند کرنا",
            singularBnPron = "বন্দ করনা",
            pluralTarget = "بند کرنا",
            pluralBnPron = "বন্দ করনা",
            bnMeaning = "বন্ধ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_624",
            category = VocabCategory.ACTIONS,
            singularTarget = "شروع کرنا",
            singularBnPron = "শুরু করনা",
            pluralTarget = "شروع کرنا",
            pluralBnPron = "শুরু করনা",
            bnMeaning = "শুরু করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_625",
            category = VocabCategory.ACTIONS,
            singularTarget = "ختم کرنا",
            singularBnPron = "খতম করনা",
            pluralTarget = "ختم کرنا",
            pluralBnPron = "খতম করনা",
            bnMeaning = "শেষ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_626",
            category = VocabCategory.ACTIONS,
            singularTarget = "آنا",
            singularBnPron = "আনা",
            pluralTarget = "آنا",
            pluralBnPron = "আনা",
            bnMeaning = "আসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_627",
            category = VocabCategory.ACTIONS,
            singularTarget = "جانا",
            singularBnPron = "জানা",
            pluralTarget = "جانا",
            pluralBnPron = "জানা",
            bnMeaning = "যাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_628",
            category = VocabCategory.ACTIONS,
            singularTarget = "واپس آنا",
            singularBnPron = "ওয়াপাস আনা",
            pluralTarget = "واپس آنا",
            pluralBnPron = "ওয়াপাস আনা",
            bnMeaning = "ফিরে আসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_629",
            category = VocabCategory.ACTIONS,
            singularTarget = "انتظار کرنا",
            singularBnPron = "ইন্তজার করনা",
            pluralTarget = "انتظار کرنا",
            pluralBnPron = "ইন্তজার করনা",
            bnMeaning = "অপেক্ষা করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_630",
            category = VocabCategory.ACTIONS,
            singularTarget = "مدد کرنا",
            singularBnPron = "মদদ করনা",
            pluralTarget = "مدد کرنا",
            pluralBnPron = "মদদ করনা",
            bnMeaning = "সাহায্য করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_631",
            category = VocabCategory.ACTIONS,
            singularTarget = "کام کرنا",
            singularBnPron = "কাম করনা",
            pluralTarget = "کام کرنا",
            pluralBnPron = "কাম করনা",
            bnMeaning = "কাজ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_632",
            category = VocabCategory.ACTIONS,
            singularTarget = "کھیلنا",
            singularBnPron = "খেলনা",
            pluralTarget = "کھیلنا",
            pluralBnPron = "খেলনা",
            bnMeaning = "খেলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_633",
            category = VocabCategory.ACTIONS,
            singularTarget = "گانا",
            singularBnPron = "গানা",
            pluralTarget = "گانا",
            pluralBnPron = "গানা",
            bnMeaning = "গান গাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_634",
            category = VocabCategory.ACTIONS,
            singularTarget = "ناچنا",
            singularBnPron = "নাচনা",
            pluralTarget = "ناچنا",
            pluralBnPron = "নাচনা",
            bnMeaning = "নাচা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_635",
            category = VocabCategory.ACTIONS,
            singularTarget = "ہنسنا",
            singularBnPron = "হঁসনা",
            pluralTarget = "ہنسنا",
            pluralBnPron = "হঁসনা",
            bnMeaning = "হাসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_636",
            category = VocabCategory.ACTIONS,
            singularTarget = "رونا",
            singularBnPron = "রোনা",
            pluralTarget = "رونا",
            pluralBnPron = "রোনা",
            bnMeaning = "কাঁদা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_637",
            category = VocabCategory.ACTIONS,
            singularTarget = "سوچنا",
            singularBnPron = "সোচনা",
            pluralTarget = "سوچنا",
            pluralBnPron = "সোচনা",
            bnMeaning = "চিন্তা করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_638",
            category = VocabCategory.ACTIONS,
            singularTarget = "سمجھنا",
            singularBnPron = "সমঝনা",
            pluralTarget = "سمجھنا",
            pluralBnPron = "সমঝনা",
            bnMeaning = "বুঝতে পারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_639",
            category = VocabCategory.ACTIONS,
            singularTarget = "یاد رکھنا",
            singularBnPron = "ইয়াদ রখনা",
            pluralTarget = "یاد رکھنا",
            pluralBnPron = "ইয়াদ রখনা",
            bnMeaning = "মনে রাখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_640",
            category = VocabCategory.ACTIONS,
            singularTarget = "بھولنا",
            singularBnPron = "ভুলনা",
            pluralTarget = "بھولنا",
            pluralBnPron = "ভুলনা",
            bnMeaning = "ভুলে যাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_641",
            category = VocabCategory.ACTIONS,
            singularTarget = "پکانا",
            singularBnPron = "পকানা",
            pluralTarget = "پکانا",
            pluralBnPron = "পকানা",
            bnMeaning = "রান্না করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_642",
            category = VocabCategory.ACTIONS,
            singularTarget = "دھونا",
            singularBnPron = "ধোনা",
            pluralTarget = "دھونا",
            pluralBnPron = "ধোনা",
            bnMeaning = "ধোয়া / পরিষ্কার করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_643",
            category = VocabCategory.ACTIONS,
            singularTarget = "صاف کرنا",
            singularBnPron = "সাফ করনা",
            pluralTarget = "صاف کرنا",
            pluralBnPron = "সাফ করনা",
            bnMeaning = "পরিষ্কার করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_644",
            category = VocabCategory.ACTIONS,
            singularTarget = "کاٹنا",
            singularBnPron = "কাটনা",
            pluralTarget = "کاٹنا",
            pluralBnPron = "কাটনা",
            bnMeaning = "কাটা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_645",
            category = VocabCategory.ACTIONS,
            singularTarget = "رکھنا",
            singularBnPron = "রখনা",
            pluralTarget = "رکھنا",
            pluralBnPron = "রখনা",
            bnMeaning = "রাখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_646",
            category = VocabCategory.ACTIONS,
            singularTarget = "لانا",
            singularBnPron = "লানা",
            pluralTarget = "لانا",
            pluralBnPron = "লানা",
            bnMeaning = "আনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_647",
            category = VocabCategory.ACTIONS,
            singularTarget = "بھیجنا",
            singularBnPron = "ভেজনা",
            pluralTarget = "بھیجنا",
            pluralBnPron = "ভেজনা",
            bnMeaning = "পাঠানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_648",
            category = VocabCategory.ACTIONS,
            singularTarget = "بلانا / پکارنا",
            singularBnPron = "বুलाना",
            pluralTarget = "بلانا",
            pluralBnPron = "বুलाना",
            bnMeaning = "ডাকা / কল করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_649",
            category = VocabCategory.ACTIONS,
            singularTarget = "پوچھنا",
            singularBnPron = "পুছনা",
            pluralTarget = "پوچھنا",
            pluralBnPron = "পুছনা",
            bnMeaning = "জিজ্ঞাসা করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_650",
            category = VocabCategory.ACTIONS,
            singularTarget = "رہنا",
            singularBnPron = "রহনা",
            pluralTarget = "رہنا",
            pluralBnPron = "রহনা",
            bnMeaning = "বাস করা / থাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_651",
            category = VocabCategory.EMOTIONS,
            singularTarget = "خوشی",
            singularBnPron = "খুশী",
            pluralTarget = "خوشیاں",
            pluralBnPron = "খুশীয়াঁ",
            bnMeaning = "আনন্দ / সুখ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_652",
            category = VocabCategory.EMOTIONS,
            singularTarget = "غم / دکھ",
            singularBnPron = "গম",
            pluralTarget = "غم",
            pluralBnPron = "গম",
            bnMeaning = "দুঃখ / কষ্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_653",
            category = VocabCategory.EMOTIONS,
            singularTarget = "غصہ",
            singularBnPron = "গুসসা",
            pluralTarget = "غصہ",
            pluralBnPron = "গুসসা",
            bnMeaning = "রাগ / ক্রোধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_654",
            category = VocabCategory.EMOTIONS,
            singularTarget = "خوف / ڈر",
            singularBnPron = "খউফ",
            pluralTarget = "خوف",
            pluralBnPron = "খউফ",
            bnMeaning = "ভয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_655",
            category = VocabCategory.EMOTIONS,
            singularTarget = "محبت / پیار",
            singularBnPron = "মুহাব্বাত",
            pluralTarget = "محبت",
            pluralBnPron = "মুহাব্বাত",
            bnMeaning = "ভালোবাসা / প্রেম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_656",
            category = VocabCategory.EMOTIONS,
            singularTarget = "نفرت",
            singularBnPron = "নফরত",
            pluralTarget = "نفرت",
            pluralBnPron = "নফরত",
            bnMeaning = "ঘৃণা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_657",
            category = VocabCategory.EMOTIONS,
            singularTarget = "امید",
            singularBnPron = "উম্মিদ",
            pluralTarget = "امیدیں",
            pluralBnPron = "উম্মিদেঁ",
            bnMeaning = "আশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_658",
            category = VocabCategory.EMOTIONS,
            singularTarget = "امن / سکون",
            singularBnPron = "আমান",
            pluralTarget = "امن",
            pluralBnPron = "আমান",
            bnMeaning = "শান্তি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_659",
            category = VocabCategory.EMOTIONS,
            singularTarget = "حیرت / تعجب",
            singularBnPron = "হায়রাত",
            pluralTarget = "حیرت",
            pluralBnPron = "হায়রাত",
            bnMeaning = "আশ্চর্য / বিস্ময়",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_660",
            category = VocabCategory.EMOTIONS,
            singularTarget = "اعتماد / بھروسہ",
            singularBnPron = "ভরসা",
            pluralTarget = "بھروسہ",
            pluralBnPron = "ভরসা",
            bnMeaning = "বিশ্বাস / ভরসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_661",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ہمت / حوصلہ",
            singularBnPron = "হিম্মত",
            pluralTarget = "حوصلہ",
            pluralBnPron = "হিম্মত",
            bnMeaning = "সাহস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_662",
            category = VocabCategory.EMOTIONS,
            singularTarget = "فخر / غرور",
            singularBnPron = "ফাখর",
            pluralTarget = "فخر",
            pluralBnPron = "ফাখর",
            bnMeaning = "গর্ব / অহংকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_663",
            category = VocabCategory.EMOTIONS,
            singularTarget = "شرم",
            singularBnPron = "শর্ম",
            pluralTarget = "شرم",
            pluralBnPron = "শর্ম",
            bnMeaning = "লজ্জা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_664",
            category = VocabCategory.EMOTIONS,
            singularTarget = "حسد / جلن",
            singularBnPron = "হাসাদ",
            pluralTarget = "حسد",
            pluralBnPron = "হাসাদ",
            bnMeaning = "ঈর্ষা / হিংসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_665",
            category = VocabCategory.EMOTIONS,
            singularTarget = "فکر / تشویش",
            singularBnPron = "ফিকির",
            pluralTarget = "فکریں",
            pluralBnPron = "ফিকরেঁ",
            bnMeaning = "উদ্বেগ / চিন্তা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_666",
            category = VocabCategory.EMOTIONS,
            singularTarget = "راحت / سکون",
            singularBnPron = "রাহত",
            pluralTarget = "راحت",
            pluralBnPron = "রাহত",
            bnMeaning = "স্বস্তি / প্রশান্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_667",
            category = VocabCategory.EMOTIONS,
            singularTarget = "جوش / ہیجان",
            singularBnPron = "জশ",
            pluralTarget = "جوش",
            pluralBnPron = "জশ",
            bnMeaning = "উত্তেজনা / রোমাঞ্চ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_668",
            category = VocabCategory.EMOTIONS,
            singularTarget = "بیزاری / اکتاہٹ",
            singularBnPron = "বেজারী",
            pluralTarget = "بیزاری",
            pluralBnPron = "বেজারী",
            bnMeaning = "একঘেয়েমি / বিরক্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_669",
            category = VocabCategory.EMOTIONS,
            singularTarget = "الجھن / انتشار",
            singularBnPron = "উলঝন",
            pluralTarget = "الجھنیں",
            pluralBnPron = "উলঝনেঁ",
            bnMeaning = "বিভ্রান্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_670",
            category = VocabCategory.EMOTIONS,
            singularTarget = "مایوسی / ناامیدی",
            singularBnPron = "মায়ুসী",
            pluralTarget = "مایوسی",
            pluralBnPron = "মায়ুসী",
            bnMeaning = "হতাশা / নিরাশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_671",
            category = VocabCategory.EMOTIONS,
            singularTarget = "شکر گزاری",
            singularBnPron = "শুকরগুজারী",
            pluralTarget = "شکر گزاری",
            pluralBnPron = "শুকরগুজারী",
            bnMeaning = "কৃতজ্ঞতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_672",
            category = VocabCategory.EMOTIONS,
            singularTarget = "افسوس / پچھتاوا",
            singularBnPron = "আফসোস",
            pluralTarget = "افسوس",
            pluralBnPron = "আফসোস",
            bnMeaning = "অনুতাপ / আফসোস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_673",
            category = VocabCategory.EMOTIONS,
            singularTarget = "تنہائی",
            singularBnPron = "তানহায়ী",
            pluralTarget = "تنہائی",
            pluralBnPron = "তানহায়ী",
            bnMeaning = "একাকীত্ব",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_674",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ہمدردی / ترس",
            singularBnPron = "হামদার্দী",
            pluralTarget = "ہمدردی",
            pluralBnPron = "হামদার্দী",
            bnMeaning = "দয়া / সহানুভূতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_675",
            category = VocabCategory.EMOTIONS,
            singularTarget = "صبر / تحمل",
            singularBnPron = "সবর",
            pluralTarget = "صبر",
            pluralBnPron = "সবর",
            bnMeaning = "ধৈর্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_676",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ایمانداری",
            singularBnPron = "ঈমানদারী",
            pluralTarget = "ایمانداری",
            pluralBnPron = "ঈমানদারী",
            bnMeaning = "সততা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_677",
            category = VocabCategory.EMOTIONS,
            singularTarget = "تجسس",
            singularBnPron = "তাজাসসুস",
            pluralTarget = "تجسس",
            pluralBnPron = "তাজাসসুস",
            bnMeaning = "কৌতূহল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_678",
            category = VocabCategory.EMOTIONS,
            singularTarget = "عزت / احترام",
            singularBnPron = "ইজ্জত",
            pluralTarget = "عزت",
            pluralBnPron = "ইজ্জত",
            bnMeaning = "শ্রদ্ধা / সম্মান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_679",
            category = VocabCategory.EMOTIONS,
            singularTarget = "خود اعتمادی",
            singularBnPron = "খোদ এতেমাদী",
            pluralTarget = "خود اعتمادی",
            pluralBnPron = "খোদ এতেমাদী",
            bnMeaning = "আত্মবিশ্বাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_680",
            category = VocabCategory.EMOTIONS,
            singularTarget = "شک / شبہ",
            singularBnPron = "শক",
            pluralTarget = "شک",
            pluralBnPron = "শক",
            bnMeaning = "সন্দেহ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_681",
            category = VocabCategory.EMOTIONS,
            singularTarget = "خوش",
            singularBnPron = "খুশ",
            pluralTarget = "خوش",
            pluralBnPron = "খুশ",
            bnMeaning = "সুখী / আনন্দিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_682",
            category = VocabCategory.EMOTIONS,
            singularTarget = "اداس / غمگین",
            singularBnPron = "উদাস",
            pluralTarget = "اداس",
            pluralBnPron = "উদাস",
            bnMeaning = "দুঃখী / বিষণ্ণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_683",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ناراض / غصہ",
            singularBnPron = "নারাজ",
            pluralTarget = "ناراض",
            pluralBnPron = "নারাজ",
            bnMeaning = "রাগান্বিত / ক্ষুব্ধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_684",
            category = VocabCategory.EMOTIONS,
            singularTarget = "خوفزدہ / ڈرا ہوا",
            singularBnPron = "খউফজাদা",
            pluralTarget = "خوفزدہ",
            pluralBnPron = "খউফজাদা",
            bnMeaning = "ভীত / শঙ্কিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_685",
            category = VocabCategory.EMOTIONS,
            singularTarget = "پرامید",
            singularBnPron = "পুরউম্মিদ",
            pluralTarget = "پرامید",
            pluralBnPron = "পুরউম্মিদ",
            bnMeaning = "আশাবাদী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_686",
            category = VocabCategory.EMOTIONS,
            singularTarget = "پرسکون / پرامن",
            singularBnPron = "পুরসুকুন",
            pluralTarget = "پرسکون",
            pluralBnPron = "পুরসুকুন",
            bnMeaning = "শান্ত / নীরব",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_687",
            category = VocabCategory.EMOTIONS,
            singularTarget = "فخر مند",
            singularBnPron = "ফাখরমন্দ",
            pluralTarget = "فخر مند",
            pluralBnPron = "ফাখরমন্দ",
            bnMeaning = "গর্বিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_688",
            category = VocabCategory.EMOTIONS,
            singularTarget = "شرمندہ",
            singularBnPron = "শর্মিন্দা",
            pluralTarget = "شرمندہ",
            pluralBnPron = "শর্মিন্দা",
            bnMeaning = "লজ্জিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_689",
            category = VocabCategory.EMOTIONS,
            singularTarget = "حاسد",
            singularBnPron = "হাসিদ",
            pluralTarget = "حاسد",
            pluralBnPron = "হাসিদ",
            bnMeaning = "ঈর্ষান্বিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_690",
            category = VocabCategory.EMOTIONS,
            singularTarget = "فکرمند / پریشان",
            singularBnPron = "পরেশান",
            pluralTarget = "پریشان",
            pluralBnPron = "পরেশান",
            bnMeaning = "চিন্তিত / উদ্বিগ্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_691",
            category = VocabCategory.EMOTIONS,
            singularTarget = "پرجوش",
            singularBnPron = "পুরজশ",
            pluralTarget = "پرجوش",
            pluralBnPron = "পুরজশ",
            bnMeaning = "উত্তেজিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_692",
            category = VocabCategory.EMOTIONS,
            singularTarget = "تھکا ہوا",
            singularBnPron = "থকা হুয়া",
            pluralTarget = "تھکے ہوئے",
            pluralBnPron = "থকে হুয়ে",
            bnMeaning = "ক্লান্ত / পরিশ্রান্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_693",
            category = VocabCategory.EMOTIONS,
            singularTarget = "تنہا / اکیلا",
            singularBnPron = "তানহা",
            pluralTarget = "اکیلا",
            pluralBnPron = "তানহা",
            bnMeaning = "নিঃসঙ্গ / একাকী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_694",
            category = VocabCategory.EMOTIONS,
            singularTarget = "شکر گزار",
            singularBnPron = "শুকরগুজার",
            pluralTarget = "شکر گزار",
            pluralBnPron = "শুকরগুজার",
            bnMeaning = "কৃতজ্ঞ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_695",
            category = VocabCategory.EMOTIONS,
            singularTarget = "بہادر",
            singularBnPron = "বাহাদুর",
            pluralTarget = "بہادر",
            pluralBnPron = "বাহাদুর",
            bnMeaning = "সাহসী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_696",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ایماندار",
            singularBnPron = "ঈমানদার",
            pluralTarget = "ایماندار",
            pluralBnPron = "ঈমানদার",
            bnMeaning = "সৎ / নিষ্ঠাবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_697",
            category = VocabCategory.EMOTIONS,
            singularTarget = "صابر / بردبار",
            singularBnPron = "সাবির",
            pluralTarget = "صابر",
            pluralBnPron = "সাবির",
            bnMeaning = "ধৈর্যশীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_698",
            category = VocabCategory.EMOTIONS,
            singularTarget = "بے چین / مضطرب",
            singularBnPron = "বেচেন",
            pluralTarget = "بے چین",
            pluralBnPron = "বেচেন",
            bnMeaning = "উদ্বিগ্ন / অস্থির",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_699",
            category = VocabCategory.EMOTIONS,
            singularTarget = "حیران",
            singularBnPron = "হায়রান",
            pluralTarget = "حیران",
            pluralBnPron = "হায়রান",
            bnMeaning = "বিস্মিত / অবাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_700",
            category = VocabCategory.EMOTIONS,
            singularTarget = "پر اعتماد",
            singularBnPron = "পুর এতেমাদ",
            pluralTarget = "پر اعتماد",
            pluralBnPron = "পুর এতেমাদ",
            bnMeaning = "আত্মবিশ্বাসী",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk8 = listOf(
        VocabItem(
            id = "ur_vocab_701",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "اچھا",
            singularBnPron = "আচ্ছা",
            pluralTarget = "اچھے",
            pluralBnPron = "আচ্ছা",
            bnMeaning = "ভালো / উত্তম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_702",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "برا / خراب",
            singularBnPron = "বুরা",
            pluralTarget = "برے",
            pluralBnPron = "বুরা",
            bnMeaning = "খারাপ / মন্দ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_703",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "بڑا",
            singularBnPron = "বড়া",
            pluralTarget = "بڑے",
            pluralBnPron = "বড়া",
            bnMeaning = "বড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_704",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "چھوٹا",
            singularBnPron = "ছোটা",
            pluralTarget = "چھوٹے",
            pluralBnPron = "ছোটা",
            bnMeaning = "ছোট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_705",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "لمبا",
            singularBnPron = "লম্বা",
            pluralTarget = "لمبے",
            pluralBnPron = "লম্বা",
            bnMeaning = "লম্বা / দীর্ঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_706",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "چھوٹا / ناٹا",
            singularBnPron = "ছোটা",
            pluralTarget = "چھوٹے",
            pluralBnPron = "ছোটা",
            bnMeaning = "খাটো / ছোট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_707",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "اونچا",
            singularBnPron = "উঁচা",
            pluralTarget = "اونچے",
            pluralBnPron = "উঁচা",
            bnMeaning = "উঁচু / লম্বা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_708",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "موٹا",
            singularBnPron = "মোটা",
            pluralTarget = "موٹے",
            pluralBnPron = "মোটা",
            bnMeaning = "মোটা / স্থূল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_709",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "پتلا",
            singularBnPron = "পতলা",
            pluralTarget = "پتلے",
            pluralBnPron = "পতলা",
            bnMeaning = "পাতলা / চিকন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_710",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "تیز",
            singularBnPron = "তেজ",
            pluralTarget = "تیز",
            pluralBnPron = "তেজ",
            bnMeaning = "দ্রুত / তেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_711",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "آہستہ / دھیما",
            singularBnPron = "আহিসতা",
            pluralTarget = "دھیما",
            pluralBnPron = "আহিসতা",
            bnMeaning = "ধীর / আস্তে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_712",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "بھاری",
            singularBnPron = "ভারী",
            pluralTarget = "بھاری",
            pluralBnPron = "ভারী",
            bnMeaning = "ভারী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_713",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ہلکا",
            singularBnPron = "হালকা",
            pluralTarget = "ہلکے",
            pluralBnPron = "হালকা",
            bnMeaning = "হালকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_714",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "سخت",
            singularBnPron = "সখত",
            pluralTarget = "سخت",
            pluralBnPron = "সখত",
            bnMeaning = "কঠিন / শক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_715",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "نرم",
            singularBnPron = "নরম",
            pluralTarget = "نرم",
            pluralBnPron = "নরম",
            bnMeaning = "নরম / কোমল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_716",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "گرم",
            singularBnPron = "গরম",
            pluralTarget = "گرم",
            pluralBnPron = "গরম",
            bnMeaning = "গরম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_717",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ٹھنڈا",
            singularBnPron = "ঠান্ডা",
            pluralTarget = "ٹھنڈے",
            pluralBnPron = "ঠান্ডা",
            bnMeaning = "ঠান্ডা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_718",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "نیم گرم / گرم",
            singularBnPron = "নীম গরম",
            pluralTarget = "گرم",
            pluralBnPron = "নীম গরম",
            bnMeaning = "উষ্ণ / নাতিশীতোষ্ণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_719",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ٹھنڈا / خنک",
            singularBnPron = "খুনুক",
            pluralTarget = "خنک",
            pluralBnPron = "খুনুক",
            bnMeaning = "শীতল / স্নিগ্ধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_720",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "صاف",
            singularBnPron = "সাফ",
            pluralTarget = "صاف",
            pluralBnPron = "সাফ",
            bnMeaning = "পরিষ্কার / পরিচ্ছন্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_721",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "گندا",
            singularBnPron = "গন্দা",
            pluralTarget = "گندے",
            pluralBnPron = "গন্দা",
            bnMeaning = "নোংরা / অপবিত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_722",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "نیا",
            singularBnPron = "নয়া",
            pluralTarget = "نئے",
            pluralBnPron = "নয়া",
            bnMeaning = "নতুন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_723",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "پرانا",
            singularBnPron = "পুরানা",
            pluralTarget = "پرانے",
            pluralBnPron = "পুরানা",
            bnMeaning = "পুরাতন / পুরনো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_724",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "جوان",
            singularBnPron = "জওয়ান",
            pluralTarget = "جوان",
            pluralBnPron = "জওয়ান",
            bnMeaning = "তরুণ / যুবা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_725",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "خوبصورت",
            singularBnPron = "খুবসুরত",
            pluralTarget = "خوبصورت",
            pluralBnPron = "খুবসুরত",
            bnMeaning = "সুন্দর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_726",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "بدصورت",
            singularBnPron = "বদসুরত",
            pluralTarget = "بدصورت",
            pluralBnPron = "বদসুরত",
            bnMeaning = "কুৎসিত / বিশ্রী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_727",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "امیر",
            singularBnPron = "আমীর",
            pluralTarget = "امیر",
            pluralBnPron = "আমীর",
            bnMeaning = "ধনী / বিত্তবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_728",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "غریب",
            singularBnPron = "গরীব",
            pluralTarget = "غریب",
            pluralBnPron = "গরীব",
            bnMeaning = "গরিব / দরিদ্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_729",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "طاقتور / مضبوط",
            singularBnPron = "তাকাতওয়ার",
            pluralTarget = "طاقتور",
            pluralBnPron = "তাকাতওয়ার",
            bnMeaning = "শক্তিশালী / বলবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_730",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "کمزور",
            singularBnPron = "কমজোর",
            pluralTarget = "کمزور",
            pluralBnPron = "কমজোর",
            bnMeaning = "দুর্বল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_731",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "میٹھا",
            singularBnPron = "মীঠা",
            pluralTarget = "میٹھے",
            pluralBnPron = "মীঠা",
            bnMeaning = "মিষ্টি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_732",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "کھٹا",
            singularBnPron = "খাট্টা",
            pluralTarget = "کھٹے",
            pluralBnPron = "খাট্টা",
            bnMeaning = "টক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_733",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "کڑوا",
            singularBnPron = "কড়ওয়া",
            pluralTarget = "کڑوے",
            pluralBnPron = "কড়ওয়া",
            bnMeaning = "তিতা / তিক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_734",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "نمکین",
            singularBnPron = "নমকীন",
            pluralTarget = "نمکین",
            pluralBnPron = "নমকীন",
            bnMeaning = "নোনতা / লবণাক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_735",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "مسالے دار / تیکھا",
            singularBnPron = "তীখা",
            pluralTarget = "تیکھا",
            pluralBnPron = "তীখা",
            bnMeaning = "ঝাল / মসলাযুক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_736",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "آسان",
            singularBnPron = "আসান",
            pluralTarget = "آسان",
            pluralBnPron = "আসান",
            bnMeaning = "সহজ / সরল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_737",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "مشکل / دشوار",
            singularBnPron = "মুশকিল",
            pluralTarget = "مشکل",
            pluralBnPron = "মুশকিল",
            bnMeaning = "কঠিন / জটিল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_738",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "مہنگا",
            singularBnPron = "মহঙ্গা",
            pluralTarget = "مہنگے",
            pluralBnPron = "মহঙ্গা",
            bnMeaning = "দামি / মূল্যবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_739",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "سستا",
            singularBnPron = "সস্তা",
            pluralTarget = "سستے",
            pluralBnPron = "সস্তা",
            bnMeaning = "সস্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_740",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "محفوظ",
            singularBnPron = "মাহফুজ",
            pluralTarget = "محفوظ",
            pluralBnPron = "মাহফুজ",
            bnMeaning = "নিরাপদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_741",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "خطرناک",
            singularBnPron = "খতরনাক",
            pluralTarget = "خطرناک",
            pluralBnPron = "খতরনাক",
            bnMeaning = "বিপজ্জনক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_742",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "روشن / چمکدار",
            singularBnPron = "রওশন",
            pluralTarget = "روشن",
            pluralBnPron = "রওশন",
            bnMeaning = "উজ্জ্বল / ফর্সা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_743",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "تاریک / اندھیرا",
            singularBnPron = "তারীক",
            pluralTarget = "اندھیرا",
            pluralBnPron = "তারীক",
            bnMeaning = "অন্ধকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_744",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "خشک / سوکھا",
            singularBnPron = "খুশক",
            pluralTarget = "خشک",
            pluralBnPron = "খুশক",
            bnMeaning = "শুকনো / শুষ্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_745",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "گیلا",
            singularBnPron = "গীলা",
            pluralTarget = "گیلے",
            pluralBnPron = "গীলা",
            bnMeaning = "ভেজা / আর্দ্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_746",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "بھرا ہوا / مکمل",
            singularBnPron = "ভরা হুয়া",
            pluralTarget = "بھرا ہوا",
            pluralBnPron = "ভরা হুয়া",
            bnMeaning = "পূর্ণ / ভরা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_747",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "خالی",
            singularBnPron = "খালী",
            pluralTarget = "خالی",
            pluralBnPron = "খালী",
            bnMeaning = "খালি / শূন্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_748",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "سچ / درست",
            singularBnPron = "সচ",
            pluralTarget = "سچ",
            pluralBnPron = "সচ",
            bnMeaning = "সত্য / সঠিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_749",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "جھوٹ / غلط",
            singularBnPron = "ঝুট",
            pluralTarget = "جھوٹ",
            pluralBnPron = "ঝুট",
            bnMeaning = "মিথ্যা / ভুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_750",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "اہم / ضروری",
            singularBnPron = "আহম",
            pluralTarget = "اہم",
            pluralBnPron = "আহম",
            bnMeaning = "গুরুত্বপূর্ণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_751",
            category = VocabCategory.COLORS,
            singularTarget = "لال / سرخ",
            singularBnPron = "লাল",
            pluralTarget = "لال",
            pluralBnPron = "লাল",
            bnMeaning = "লাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_752",
            category = VocabCategory.COLORS,
            singularTarget = "نیلا",
            singularBnPron = "নীলা",
            pluralTarget = "نيلے",
            pluralBnPron = "নীলে",
            bnMeaning = "নীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_753",
            category = VocabCategory.COLORS,
            singularTarget = "سبز / ہرا",
            singularBnPron = "সবজ",
            pluralTarget = "سبز",
            pluralBnPron = "সবজ",
            bnMeaning = "সবুজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_754",
            category = VocabCategory.COLORS,
            singularTarget = "پیلا / زرد",
            singularBnPron = "পীলা",
            pluralTarget = "پیلا",
            pluralBnPron = "পীলা",
            bnMeaning = "হলুদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_755",
            category = VocabCategory.COLORS,
            singularTarget = "کالا / سیاہ",
            singularBnPron = "কালা",
            pluralTarget = "کالا",
            pluralBnPron = "কালা",
            bnMeaning = "কালো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_756",
            category = VocabCategory.COLORS,
            singularTarget = "سفید",
            singularBnPron = "সফেদ",
            pluralTarget = "سفید",
            pluralBnPron = "সফেদ",
            bnMeaning = "সাদা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_757",
            category = VocabCategory.COLORS,
            singularTarget = "نارنجی",
            singularBnPron = "নারঞ্জী",
            pluralTarget = "نارنجی",
            pluralBnPron = "নারঞ্জী",
            bnMeaning = "কমলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_758",
            category = VocabCategory.COLORS,
            singularTarget = "گلابی",
            singularBnPron = "গুলাবী",
            pluralTarget = "گلابی",
            pluralBnPron = "গুলাবী",
            bnMeaning = "গোলাপি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_759",
            category = VocabCategory.COLORS,
            singularTarget = "جامنی / بینگنی",
            singularBnPron = "জামনী",
            pluralTarget = "جامنی",
            pluralBnPron = "জামনী",
            bnMeaning = "বেগুনী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_760",
            category = VocabCategory.COLORS,
            singularTarget = "بھورا",
            singularBnPron = "ভূরা",
            pluralTarget = "بھورے",
            pluralBnPron = "ভূরে",
            bnMeaning = "বাদামী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_761",
            category = VocabCategory.COLORS,
            singularTarget = "سرمئی / خاکستری",
            singularBnPron = "সুরমাই",
            pluralTarget = "سرمئی",
            pluralBnPron = "সুরমাই",
            bnMeaning = "ধূসর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_762",
            category = VocabCategory.COLORS,
            singularTarget = "سنہرا",
            singularBnPron = "সুনহরা",
            pluralTarget = "سنہرے",
            pluralBnPron = "সুনহরে",
            bnMeaning = "সোনালী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_763",
            category = VocabCategory.COLORS,
            singularTarget = "چاندی جیسا / روپہلا",
            singularBnPron = "রূপহলা",
            pluralTarget = "روپہلا",
            pluralBnPron = "রূপহলা",
            bnMeaning = "রুপালী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_764",
            category = VocabCategory.COLORS,
            singularTarget = "آسمانی",
            singularBnPron = "আসমানী",
            pluralTarget = "آسمانی",
            pluralBnPron = "আসমানী",
            bnMeaning = "আকাশি নীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_765",
            category = VocabCategory.COLORS,
            singularTarget = "گہرا نیلا",
            singularBnPron = "গহরা নীলা",
            pluralTarget = "گہرے نیلے",
            pluralBnPron = "গহরে নীলে",
            bnMeaning = "গাঢ় নীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_766",
            category = VocabCategory.COLORS,
            singularTarget = "رنگ",
            singularBnPron = "রং",
            pluralTarget = "رنگ",
            pluralBnPron = "রং",
            bnMeaning = "রং",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_767",
            category = VocabCategory.COLORS,
            singularTarget = "دائرہ",
            singularBnPron = "দায়েরা",
            pluralTarget = "دائرے",
            pluralBnPron = "দায়েরি",
            bnMeaning = "বৃত্ত / গোলক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_768",
            category = VocabCategory.COLORS,
            singularTarget = "مربع / چوکور",
            singularBnPron = "মুরাব্বা",
            pluralTarget = "مربع",
            pluralBnPron = "মুরাব্বা",
            bnMeaning = "বর্গক্ষেত্র / চৌকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_769",
            category = VocabCategory.COLORS,
            singularTarget = "مثلث",
            singularBnPron = "মুসাল্লাস",
            pluralTarget = "مثلثات",
            pluralBnPron = "মুসাল্লাসাত",
            bnMeaning = "ত্রিভুজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_770",
            category = VocabCategory.COLORS,
            singularTarget = "مستطیل",
            singularBnPron = "মুসতাতীল",
            pluralTarget = "مستطیل",
            pluralBnPron = "মুসতাতীল",
            bnMeaning = "আয়তক্ষেত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_771",
            category = VocabCategory.COLORS,
            singularTarget = "بیضوی",
            singularBnPron = "বয়জবী",
            pluralTarget = "بیضوی",
            pluralBnPron = "বয়জবী",
            bnMeaning = "ডিম্বাকৃতি / ওভাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_772",
            category = VocabCategory.COLORS,
            singularTarget = "ستارہ نما",
            singularBnPron = "সিতারা নুমা",
            pluralTarget = "ستارہ نما",
            pluralBnPron = "সিতারা নুমা",
            bnMeaning = "তারা আকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_773",
            category = VocabCategory.COLORS,
            singularTarget = "دل کی شکل",
            singularBnPron = "দিল কি শাকল",
            pluralTarget = "شکلیں",
            pluralBnPron = "দিল কি শাকলেঁ",
            bnMeaning = "হৃদয় আকার / হার্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_774",
            category = VocabCategory.COLORS,
            singularTarget = "ہیرا نما شکل",
            singularBnPron = "হীরা নুমা",
            pluralTarget = "شکلیں",
            pluralBnPron = "হীরা নুমা",
            bnMeaning = "হীরক আকার / ডায়মন্ড",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_775",
            category = VocabCategory.COLORS,
            singularTarget = "مکعب",
            singularBnPron = "মুকা'আব",
            pluralTarget = "مکعب",
            pluralBnPron = "মুকা'আব",
            bnMeaning = "ঘনক / কিউব",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_776",
            category = VocabCategory.COLORS,
            singularTarget = "کرہ",
            singularBnPron = "কুরাহ",
            pluralTarget = "کرے",
            pluralBnPron = "কুরে",
            bnMeaning = "গোলক / স্ফিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_777",
            category = VocabCategory.COLORS,
            singularTarget = "اسطوانہ",
            singularBnPron = "উসতুওয়ানা",
            pluralTarget = "اسطوانے",
            pluralBnPron = "উসতুওয়ানে",
            bnMeaning = "নলাকার / সিলিন্ডার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_778",
            category = VocabCategory.COLORS,
            singularTarget = "اہرامی شکل",
            singularBnPron = "আহরাম",
            pluralTarget = "اہرام",
            pluralBnPron = "আহরাম",
            bnMeaning = "পিরামিড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_779",
            category = VocabCategory.COLORS,
            singularTarget = "لکیر / خط",
            singularBnPron = "লাকীর",
            pluralTarget = "خطوط",
            pluralBnPron = "লাকীরেঁ",
            bnMeaning = "রেখা / লাইন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_780",
            category = VocabCategory.COLORS,
            singularTarget = "نقطہ",
            singularBnPron = "নুকতা",
            pluralTarget = "نقاط",
            pluralBnPron = "নুকাতে",
            bnMeaning = "বিন্দু / ডট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_781",
            category = VocabCategory.COLORS,
            singularTarget = "کونا",
            singularBnPron = "কোনা",
            pluralTarget = "کونے",
            pluralBnPron = "কোনে",
            bnMeaning = "কোণ / কর্নার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_782",
            category = VocabCategory.COLORS,
            singularTarget = "مرکز",
            singularBnPron = "মারকাজ",
            pluralTarget = "مراکز",
            pluralBnPron = "মারাকিজ",
            bnMeaning = "কেন্দ্র / মধ্যবিন্দু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_783",
            category = VocabCategory.COLORS,
            singularTarget = "کنارہ",
            singularBnPron = "কিনারা",
            pluralTarget = "کنارے",
            pluralBnPron = "কিনারে",
            bnMeaning = "ধার / কিনারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_784",
            category = VocabCategory.COLORS,
            singularTarget = "سرحد / حد",
            singularBnPron = "হদ",
            pluralTarget = "حدود",
            pluralBnPron = "হুদুদ",
            bnMeaning = "সীমানা / বর্ডার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_785",
            category = VocabCategory.COLORS,
            singularTarget = "دھاری",
            singularBnPron = "ধারী",
            pluralTarget = "دھاریاں",
            pluralBnPron = "ধারিয়াঁ",
            bnMeaning = "ডোরা / দাগ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_786",
            category = VocabCategory.COLORS,
            singularTarget = "افقی",
            singularBnPron = "উফুকি",
            pluralTarget = "افقی",
            pluralBnPron = "উফুকি",
            bnMeaning = "আনুভূমিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_787",
            category = VocabCategory.COLORS,
            singularTarget = "عمودی",
            singularBnPron = "উমূদী",
            pluralTarget = "عمودی",
            pluralBnPron = "উমূদী",
            bnMeaning = "উলম্ব / খাড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_788",
            category = VocabCategory.COLORS,
            singularTarget = "ترچھا",
            singularBnPron = "তিরছা",
            pluralTarget = "ترچھے",
            pluralBnPron = "তিরছে",
            bnMeaning = "তির্যক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_789",
            category = VocabCategory.COLORS,
            singularTarget = "شکل",
            singularBnPron = "শাকল",
            pluralTarget = "اشکال",
            pluralBnPron = "আশাকাল",
            bnMeaning = "আকার / আকৃতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_790",
            category = VocabCategory.COLORS,
            singularTarget = "سائز / ناپ",
            singularBnPron = "সাইজ",
            pluralTarget = "سائز",
            pluralBnPron = "সাইজ",
            bnMeaning = "মাপ / সাইজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_791",
            category = VocabCategory.COLORS,
            singularTarget = "نمونہ / ڈیزائن",
            singularBnPron = "নমুনা",
            pluralTarget = "نمونے",
            pluralBnPron = "নমুনে",
            bnMeaning = "নকশা / প্যাটার্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_792",
            category = VocabCategory.COLORS,
            singularTarget = "زاویہ",
            singularBnPron = "জাবিয়া",
            pluralTarget = "زاویے",
            pluralBnPron = "জাবিয়ে",
            bnMeaning = "কোণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_793",
            category = VocabCategory.COLORS,
            singularTarget = "چمک",
            singularBnPron = "চমক",
            pluralTarget = "چمک",
            pluralBnPron = "চমক",
            bnMeaning = "উজ্জ্বলতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_794",
            category = VocabCategory.COLORS,
            singularTarget = "شفاف",
            singularBnPron = "শাফাফ",
            pluralTarget = "شفاف",
            pluralBnPron = "শাফাফ",
            bnMeaning = "স্বচ্ছ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_795",
            category = VocabCategory.COLORS,
            singularTarget = "غیر شفاف",
            singularBnPron = "গায়েরে শাফাফ",
            pluralTarget = "غیر شفاف",
            pluralBnPron = "গায়েরে শাফাফ",
            bnMeaning = "অস্বচ্ছ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_796",
            category = VocabCategory.COLORS,
            singularTarget = "گہرا",
            singularBnPron = "গহরা",
            pluralTarget = "گہرے",
            pluralBnPron = "গহরে",
            bnMeaning = "গভীর / গাঢ়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_797",
            category = VocabCategory.COLORS,
            singularTarget = "ہلکا / پھیکا",
            singularBnPron = "হালকা",
            pluralTarget = "ہلکے",
            pluralBnPron = "হালকা",
            bnMeaning = "হালকা / ফিকে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_798",
            category = VocabCategory.COLORS,
            singularTarget = "چمکدار",
            singularBnPron = "চমকদার",
            pluralTarget = "چمکدار",
            pluralBnPron = "চমকদার",
            bnMeaning = "চকচকে / উজ্জ্বল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_799",
            category = VocabCategory.COLORS,
            singularTarget = "رنگ برنگا / رنگین",
            singularBnPron = "রঙ্গীন",
            pluralTarget = "رنگین",
            pluralBnPron = "রঙ্গীন",
            bnMeaning = "রঙিন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_800",
            category = VocabCategory.COLORS,
            singularTarget = "بے رنگ",
            singularBnPron = "বেরং",
            pluralTarget = "بے رنگ",
            pluralBnPron = "বেরং",
            bnMeaning = "রংহীন / বর্ণহীন",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk9 = listOf(
        VocabItem(
            id = "ur_vocab_801",
            category = VocabCategory.KITCHEN,
            singularTarget = "باورچی خانہ",
            singularBnPron = "বাওয়ারচি খানা",
            pluralTarget = "باورچی خانے",
            pluralBnPron = "বাওয়ারচি খানে",
            bnMeaning = "রান্নাঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_802",
            category = VocabCategory.KITCHEN,
            singularTarget = "چولہا",
            singularBnPron = "চুলহা",
            pluralTarget = "چولہے",
            pluralBnPron = "চুলহে",
            bnMeaning = "চুলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_803",
            category = VocabCategory.KITCHEN,
            singularTarget = "اوون",
            singularBnPron = "ওভেন",
            pluralTarget = "اوون",
            pluralBnPron = "ওভেন",
            bnMeaning = "ওভেন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_804",
            category = VocabCategory.KITCHEN,
            singularTarget = "فرج",
            singularBnPron = "ফ্রিজ",
            pluralTarget = "فرج",
            pluralBnPron = "ফ্রিজ",
            bnMeaning = "রেফ্রিজারেটর / ফ্রিজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_805",
            category = VocabCategory.KITCHEN,
            singularTarget = "مائیکرو ویو",
            singularBnPron = "মাইক্রোওয়েভ",
            pluralTarget = "مائیکرو ویو",
            pluralBnPron = "মাইক্রোওয়েভ",
            bnMeaning = "মাইক্রোওয়েভ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_806",
            category = VocabCategory.KITCHEN,
            singularTarget = "بلینڈر",
            singularBnPron = "ব্লেন্ডার",
            pluralTarget = "بلینڈر",
            pluralBnPron = "ব্লেন্ডার",
            bnMeaning = "ব্লেন্ডার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_807",
            category = VocabCategory.KITCHEN,
            singularTarget = "کیٹلی",
            singularBnPron = "কেতলী",
            pluralTarget = "کیٹلیاں",
            pluralBnPron = "কেতলীয়াঁ",
            bnMeaning = "কেটলি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_808",
            category = VocabCategory.KITCHEN,
            singularTarget = "پتیلا",
            singularBnPron = "পতীলা",
            pluralTarget = "پتیلے",
            pluralBnPron = "পতীলে",
            bnMeaning = "রান্নার পাত্র / পাতিল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_809",
            category = VocabCategory.KITCHEN,
            singularTarget = "کڑاہی / پین",
            singularBnPron = "কড়াই",
            pluralTarget = "کڑاہیاں",
            pluralBnPron = "কড়াই",
            bnMeaning = "কড়াই / ফ্রাইপ্যান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_810",
            category = VocabCategory.KITCHEN,
            singularTarget = "پریشر ککر",
            singularBnPron = "প্রেশার কুকার",
            pluralTarget = "پریشر ککر",
            pluralBnPron = "প্রেশার কুকার",
            bnMeaning = "প্রেশার কুকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_811",
            category = VocabCategory.KITCHEN,
            singularTarget = "چھری / چاقو",
            singularBnPron = "চুরি",
            pluralTarget = "چھریاں",
            pluralBnPron = "চুরিয়াঁ",
            bnMeaning = "ছুরি / চাকু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_812",
            category = VocabCategory.KITCHEN,
            singularTarget = "چمچ",
            singularBnPron = "চামচ",
            pluralTarget = "چمچ",
            pluralBnPron = "চামচ",
            bnMeaning = "চামচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_813",
            category = VocabCategory.KITCHEN,
            singularTarget = "کانٹا",
            singularBnPron = "কাঁটা",
            pluralTarget = "کانٹے",
            pluralBnPron = "কাঁটে",
            bnMeaning = "কাঁটা চামচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_814",
            category = VocabCategory.KITCHEN,
            singularTarget = "چھوٹا چمچ",
            singularBnPron = "ছোটা চামচ",
            pluralTarget = "چمچ",
            pluralBnPron = "ছোটা চামচ",
            bnMeaning = "চা চামচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_815",
            category = VocabCategory.KITCHEN,
            singularTarget = "چوپ اسٹکس",
            singularBnPron = "চপস্টিক",
            pluralTarget = "چوپ اسٹکس",
            pluralBnPron = "চপস্টিক",
            bnMeaning = "চপস্টিক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_816",
            category = VocabCategory.KITCHEN,
            singularTarget = "پلیٹ / تھالی",
            singularBnPron = "প্লেট",
            pluralTarget = "پلیٹیں",
            pluralBnPron = "প্লেটেঁ",
            bnMeaning = "থালা / প্লেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_817",
            category = VocabCategory.KITCHEN,
            singularTarget = "پیالہ / کٹورا",
            singularBnPron = "পেয়ালা",
            pluralTarget = "پیالے",
            pluralBnPron = "পেয়ালে",
            bnMeaning = "বাটি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_818",
            category = VocabCategory.KITCHEN,
            singularTarget = "پیالی / کپ",
            singularBnPron = "কাপ",
            pluralTarget = "کپ",
            pluralBnPron = "কাপ",
            bnMeaning = "কাপ / পেয়ালা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_819",
            category = VocabCategory.KITCHEN,
            singularTarget = "گلاس",
            singularBnPron = "গিলাস",
            pluralTarget = "گلاس",
            pluralBnPron = "গিলাস",
            bnMeaning = "কাচের গ্লাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_820",
            category = VocabCategory.KITCHEN,
            singularTarget = "مگ",
            singularBnPron = "মগ",
            pluralTarget = "مگ",
            pluralBnPron = "মগ",
            bnMeaning = "মগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_821",
            category = VocabCategory.KITCHEN,
            singularTarget = "بوتل",
            singularBnPron = "বোতল",
            pluralTarget = "بوتلیں",
            pluralBnPron = "বোতলেঁ",
            bnMeaning = "বোতল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_822",
            category = VocabCategory.KITCHEN,
            singularTarget = "جگ",
            singularBnPron = "জগ",
            pluralTarget = "جگ",
            pluralBnPron = "জগ",
            bnMeaning = "জগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_823",
            category = VocabCategory.KITCHEN,
            singularTarget = "ٹرے",
            singularBnPron = "ট্রে",
            pluralTarget = "ٹرے",
            pluralBnPron = "ট্রে",
            bnMeaning = "ট্রে",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_824",
            category = VocabCategory.KITCHEN,
            singularTarget = "ڈھکن",
            singularBnPron = "ঢাক্কন",
            pluralTarget = "ڈھکن",
            pluralBnPron = "ঢাক্কন",
            bnMeaning = "ঢাকনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_825",
            category = VocabCategory.KITCHEN,
            singularTarget = "چھلنی",
            singularBnPron = "ছিলনী",
            pluralTarget = "چھلنیاں",
            pluralBnPron = "ছিলনী",
            bnMeaning = "খোসা ছাড়ানোর ছুরি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_826",
            category = VocabCategory.KITCHEN,
            singularTarget = "کدوکش",
            singularBnPron = "কদ্দুকশ",
            pluralTarget = "کدوکش",
            pluralBnPron = "কদ্দুকশ",
            bnMeaning = "গ্রেটার / ঝাঁঝরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_827",
            category = VocabCategory.KITCHEN,
            singularTarget = "مدھانی",
            singularBnPron = "মাধানী",
            pluralTarget = "مدھانیاں",
            pluralBnPron = "মাধানী",
            bnMeaning = "ডালঘুটনি / হুইস্ক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_828",
            category = VocabCategory.KITCHEN,
            singularTarget = "بیلن",
            singularBnPron = "বেলন",
            pluralTarget = "بیلن",
            pluralBnPron = "বেলন",
            bnMeaning = "বেলন (রুটি বেলার)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_829",
            category = VocabCategory.KITCHEN,
            singularTarget = "چھلنی",
            singularBnPron = "ছলনী",
            pluralTarget = "چھلنیاں",
            pluralBnPron = "ছলনীয়াঁ",
            bnMeaning = "ছাঁকনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_830",
            category = VocabCategory.KITCHEN,
            singularTarget = "چاپنگ بورڈ",
            singularBnPron = "চপিং বোর্ড",
            pluralTarget = "چاپنگ بورڈ",
            pluralBnPron = "চপিং বোর্ড",
            bnMeaning = "চপিং বোর্ড / কাটার বোর্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_831",
            category = VocabCategory.KITCHEN,
            singularTarget = "ایپرن",
            singularBnPron = "অ্যাপ্রন",
            pluralTarget = "ایپرن",
            pluralBnPron = "অ্যাপ্রন",
            bnMeaning = "অ্যাপ্রন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_832",
            category = VocabCategory.KITCHEN,
            singularTarget = "تولیہ",
            singularBnPron = "তৌলিয়া",
            pluralTarget = "تولیے",
            pluralBnPron = "তৌলিয়ে",
            bnMeaning = "থালাবাসন মোছার তোয়ালে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_833",
            category = VocabCategory.KITCHEN,
            singularTarget = "اسپنج",
            singularBnPron = "স্পঞ্জ",
            pluralTarget = "اسپنج",
            pluralBnPron = "স্পঞ্জ",
            bnMeaning = "স্পঞ্জ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_834",
            category = VocabCategory.KITCHEN,
            singularTarget = "برتن دھونے کا صابن",
            singularBnPron = "সাবুন",
            pluralTarget = "صابن",
            pluralBnPron = "সাবুন",
            bnMeaning = "থালাবাসন ধোয়ার সাবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_835",
            category = VocabCategory.KITCHEN,
            singularTarget = "سنک",
            singularBnPron = "সিঙ্ক",
            pluralTarget = "سنک",
            pluralBnPron = "সিঙ্ক",
            bnMeaning = "সিঙ্ক / বেসিন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_836",
            category = VocabCategory.KITCHEN,
            singularTarget = "نلکا",
            singularBnPron = "নলকা",
            pluralTarget = "نلکے",
            pluralBnPron = "নলকে",
            bnMeaning = "কল / ট্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_837",
            category = VocabCategory.KITCHEN,
            singularTarget = "ماچس",
            singularBnPron = "মাচিস",
            pluralTarget = "ماچس",
            pluralBnPron = "মাচিস",
            bnMeaning = "দেশলাই / ম্যাচ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_838",
            category = VocabCategory.KITCHEN,
            singularTarget = "لائٹر",
            singularBnPron = "লাইটার",
            pluralTarget = "لائٹر",
            pluralBnPron = "লাইটার",
            bnMeaning = "লাইটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_839",
            category = VocabCategory.KITCHEN,
            singularTarget = "نمک دان",
            singularBnPron = "নমকদান",
            pluralTarget = "نمک دان",
            pluralBnPron = "নমকদান",
            bnMeaning = "লবণদানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_840",
            category = VocabCategory.KITCHEN,
            singularTarget = "مرچ دان",
            singularBnPron = "মিরচ দান",
            pluralTarget = "مرچ دان",
            pluralBnPron = "মিরচ দান",
            bnMeaning = "গোলমরিচের দানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_841",
            category = VocabCategory.KITCHEN,
            singularTarget = "مصالحہ دان",
            singularBnPron = "মাসালহাদান",
            pluralTarget = "مصالحہ دان",
            pluralBnPron = "মাসালহাদান",
            bnMeaning = "মসলার বৈয়াম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_842",
            category = VocabCategory.KITCHEN,
            singularTarget = "تیل کی بوتل",
            singularBnPron = "তেল কি বোতল",
            pluralTarget = "بوتلیں",
            pluralBnPron = "বোতলেঁ",
            bnMeaning = "তেলের বোতল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_843",
            category = VocabCategory.KITCHEN,
            singularTarget = "لنچ باکس / ٹفن",
            singularBnPron = "টিফিন",
            pluralTarget = "ٹفن",
            pluralBnPron = "টিফিন",
            bnMeaning = "টিফিন বক্স / লাঞ্চ বক্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_844",
            category = VocabCategory.KITCHEN,
            singularTarget = "تھرماس",
            singularBnPron = "থার্মাস",
            pluralTarget = "تھرماس",
            pluralBnPron = "থার্মাস",
            bnMeaning = "থার্মাস / ফ্লাস্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_845",
            category = VocabCategory.KITCHEN,
            singularTarget = "اسٹرا / نلکی",
            singularBnPron = "স্ট্র",
            pluralTarget = "نلکیاں",
            pluralBnPron = "স্ট্র",
            bnMeaning = "স্ট্র / নালী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_846",
            category = VocabCategory.KITCHEN,
            singularTarget = "نیپکن",
            singularBnPron = "ন্যাপকিন",
            pluralTarget = "نیپکن",
            pluralBnPron = "ন্যাপকিন",
            bnMeaning = "ন্যাপকিন / টিস্যু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_847",
            category = VocabCategory.KITCHEN,
            singularTarget = "تھال / لگن",
            singularBnPron = "থাল",
            pluralTarget = "تھال",
            pluralBnPron = "থাল",
            bnMeaning = "গামলা / তশতরী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_848",
            category = VocabCategory.KITCHEN,
            singularTarget = "کین اوپنر",
            singularBnPron = "ক্যান ওপেনার",
            pluralTarget = "اوپنر",
            pluralBnPron = "ক্যান ওপেনার",
            bnMeaning = "ক্যান ওপেনার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_849",
            category = VocabCategory.KITCHEN,
            singularTarget = "چمچہ / پلٹا",
            singularBnPron = "পলটা",
            pluralTarget = "پلٹے",
            pluralBnPron = "পলটে",
            bnMeaning = "কর্ণধার / করাতল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_850",
            category = VocabCategory.KITCHEN,
            singularTarget = "کیف",
            singularBnPron = "কীপ",
            pluralTarget = "کیف",
            pluralBnPron = "কীপ",
            bnMeaning = "ফানেল / চোঙা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_851",
            category = VocabCategory.SHOPPING,
            singularTarget = "خریداری",
            singularBnPron = "খরীদারী",
            pluralTarget = "خریداری",
            pluralBnPron = "খরীদারী",
            bnMeaning = "কেনাকাটা / শপিং",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_852",
            category = VocabCategory.SHOPPING,
            singularTarget = "دکاندار",
            singularBnPron = "দোকানদার",
            pluralTarget = "دکاندار",
            pluralBnPron = "দোকানদার",
            bnMeaning = "দোকানদার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_853",
            category = VocabCategory.SHOPPING,
            singularTarget = "شاپنگ مال",
            singularBnPron = "শপিং মল",
            pluralTarget = "مالز",
            pluralBnPron = "শপিং মল",
            bnMeaning = "শপিং মল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_854",
            category = VocabCategory.SHOPPING,
            singularTarget = "روپیہ / پیسہ",
            singularBnPron = "পয়সা",
            pluralTarget = "پیسے",
            pluralBnPron = "পয়সে",
            bnMeaning = "টাকা / অর্থ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_855",
            category = VocabCategory.SHOPPING,
            singularTarget = "سکہ",
            singularBnPron = "সিল্কা",
            pluralTarget = "سکے",
            pluralBnPron = "সিল্কে",
            bnMeaning = "মুদ্রা / কয়েন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_856",
            category = VocabCategory.SHOPPING,
            singularTarget = "نوٹ",
            singularBnPron = "নোট",
            pluralTarget = "نوٹ",
            pluralBnPron = "নোট",
            bnMeaning = "নোট / কাগজের টাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_857",
            category = VocabCategory.SHOPPING,
            singularTarget = "قیمت / دام",
            singularBnPron = "কীমত",
            pluralTarget = "قیمتیں",
            pluralBnPron = "কীমতেঁ",
            bnMeaning = "মূল্য / দাম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_858",
            category = VocabCategory.SHOPPING,
            singularTarget = "لاگت / خرچ",
            singularBnPron = "খরচ",
            pluralTarget = "اخراجات",
            pluralBnPron = "আখরাজাত",
            bnMeaning = "খরচ / ব্যয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_859",
            category = VocabCategory.SHOPPING,
            singularTarget = "رعایت / چھوٹ",
            singularBnPron = "রিয়ায়েত",
            pluralTarget = "رعایتیں",
            pluralBnPron = "রিয়ায়েতেঁ",
            bnMeaning = "মূল্যছাড় / ডিসকাউন্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_860",
            category = VocabCategory.SHOPPING,
            singularTarget = "فروخت / سیل",
            singularBnPron = "ফুরুখত",
            pluralTarget = "فروخت",
            pluralBnPron = "ফুরুখত",
            bnMeaning = "বিক্রি / সেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_861",
            category = VocabCategory.SHOPPING,
            singularTarget = "رسید",
            singularBnPron = "রসীদ",
            pluralTarget = "رسیدیں",
            pluralBnPron = "রসীদেঁ",
            bnMeaning = "রশিদ / রিসিট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_862",
            category = VocabCategory.SHOPPING,
            singularTarget = "بل",
            singularBnPron = "বিল",
            pluralTarget = "بلات",
            pluralBnPron = "বিলাত",
            bnMeaning = "বিল / চালান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_863",
            category = VocabCategory.SHOPPING,
            singularTarget = "کیشیئر",
            singularBnPron = "ক্যাশিয়ার",
            pluralTarget = "کیشیئر",
            pluralBnPron = "ক্যাশিয়ার",
            bnMeaning = "ক্যাশিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_864",
            category = VocabCategory.SHOPPING,
            singularTarget = "تھیلا",
            singularBnPron = "থৈলা",
            pluralTarget = "تھیلے",
            pluralBnPron = "থৈলে",
            bnMeaning = "বাজারের থলে / ব্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_865",
            category = VocabCategory.SHOPPING,
            singularTarget = "ٹرالی",
            singularBnPron = "ট্রলি",
            pluralTarget = "ٹرالیاں",
            pluralBnPron = "ট্রলি",
            bnMeaning = "শপিং ট্রলি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_866",
            category = VocabCategory.SHOPPING,
            singularTarget = "ٹوکری",
            singularBnPron = "টোকরী",
            pluralTarget = "ٹوکریاں",
            pluralBnPron = "টোকরীয়াঁ",
            bnMeaning = "ঝুড়ি / বাস্কেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_867",
            category = VocabCategory.SHOPPING,
            singularTarget = "ادائیگی",
            singularBnPron = "আদায়িগী",
            pluralTarget = "ادائیگیاں",
            pluralBnPron = "আদায়িগী",
            bnMeaning = "পরিশোধ / পেমেন্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_868",
            category = VocabCategory.SHOPPING,
            singularTarget = "کریڈٹ کارڈ",
            singularBnPron = "ক্রেডিট কার্ড",
            pluralTarget = "کریڈٹ کارڈ",
            pluralBnPron = "ক্রেডিট কার্ড",
            bnMeaning = "ক্রেডিট কার্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_869",
            category = VocabCategory.SHOPPING,
            singularTarget = "کھلے پیسے / ریزگاری",
            singularBnPron = "রেজগারী",
            pluralTarget = "ریزگاری",
            pluralBnPron = "রেজগারী",
            bnMeaning = "খুচরা টাকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_870",
            category = VocabCategory.SHOPPING,
            singularTarget = "قرض",
            singularBnPron = "কর্জ",
            pluralTarget = "قرضے",
            pluralBnPron = "কর্জে",
            bnMeaning = "ঋণ / ধার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_871",
            category = VocabCategory.SHOPPING,
            singularTarget = "ٹیکس",
            singularBnPron = "ট্যাক্স",
            pluralTarget = "ٹیکس",
            pluralBnPron = "ট্যাক্স",
            bnMeaning = "কর / ট্যাক্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_872",
            category = VocabCategory.SHOPPING,
            singularTarget = "سودے بازی / بھاؤ تاؤ",
            singularBnPron = "ভাও তাও",
            pluralTarget = "بھاؤ تاؤ",
            pluralBnPron = "ভাও তাও",
            bnMeaning = "দরদাম / দরকষাকষি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_873",
            category = VocabCategory.SHOPPING,
            singularTarget = "معیار",
            singularBnPron = "মেয়ার",
            pluralTarget = "معیار",
            pluralBnPron = "মেয়ার",
            bnMeaning = "গুণমান / মান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_874",
            category = VocabCategory.SHOPPING,
            singularTarget = "مقدار",
            singularBnPron = "মিকদার",
            pluralTarget = "مقداریں",
            pluralBnPron = "মিকদারেঁ",
            bnMeaning = "পরিমাণ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_875",
            category = VocabCategory.SHOPPING,
            singularTarget = "برانڈ",
            singularBnPron = "ব্র্যান্ড",
            pluralTarget = "برانڈز",
            pluralBnPron = "ব্র্যান্ড",
            bnMeaning = "ব্র্যান্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_876",
            category = VocabCategory.SHOPPING,
            singularTarget = "وارنٹی",
            singularBnPron = "ওয়ারেন্টি",
            pluralTarget = "وارنٹی",
            pluralBnPron = "ওয়ারেন্টি",
            bnMeaning = "ওয়ারেন্টি / গ্যারান্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_877",
            category = VocabCategory.SHOPPING,
            singularTarget = "واپسی / تبادلہ",
            singularBnPron = "ওয়াপসী",
            pluralTarget = "واپسی",
            pluralBnPron = "ওয়াপসী",
            bnMeaning = "ফেরত / বদল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_878",
            category = VocabCategory.SHOPPING,
            singularTarget = "کیش کاؤنٹر",
            singularBnPron = "ক্যাশ কাউন্টার",
            pluralTarget = "کاؤنٹرز",
            pluralBnPron = "ক্যাশ কাউন্টার",
            bnMeaning = "ক্যাশ কাউন্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_879",
            category = VocabCategory.SHOPPING,
            singularTarget = "آن لائن خریداری",
            singularBnPron = "অনলাইন খরীদারী",
            pluralTarget = "آن لائن خریداری",
            pluralBnPron = "অনলাইন খরীদারী",
            bnMeaning = "অনলাইন কেনাকাটা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_880",
            category = VocabCategory.SHOPPING,
            singularTarget = "ڈلیوری",
            singularBnPron = "ডেলিভারি",
            pluralTarget = "ڈلیوری",
            pluralBnPron = "ডেলিভারি",
            bnMeaning = "হোম ডেলিভারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_881",
            category = VocabCategory.SHOPPING,
            singularTarget = "پارسل",
            singularBnPron = "পার্সেল",
            pluralTarget = "پارسل",
            pluralBnPron = "পার্সেল",
            bnMeaning = "প্যাকেট / পার্সেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_882",
            category = VocabCategory.SHOPPING,
            singularTarget = "آرڈر",
            singularBnPron = "অর্ডার",
            pluralTarget = "آرڈرز",
            pluralBnPron = "অর্ডার",
            bnMeaning = "অর্ডার / ফরমাশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_883",
            category = VocabCategory.SHOPPING,
            singularTarget = "قیمت کا ٹیگ",
            singularBnPron = "দামের ট্যাগ",
            pluralTarget = "ٹیگز",
            pluralBnPron = "দামের ট্যাগ",
            bnMeaning = "মূল্যতালিকা / দামের ট্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_884",
            category = VocabCategory.SHOPPING,
            singularTarget = "کرنسی",
            singularBnPron = "কারেন্সি",
            pluralTarget = "کرنسیاں",
            pluralBnPron = "কারেন্সি",
            bnMeaning = "মুদ্রা / কারেন্সি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_885",
            category = VocabCategory.SHOPPING,
            singularTarget = "ڈالر",
            singularBnPron = "ডলার",
            pluralTarget = "ڈالر",
            pluralBnPron = "ডলার",
            bnMeaning = "ডলার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_886",
            category = VocabCategory.SHOPPING,
            singularTarget = "یورو",
            singularBnPron = "ইউরো",
            pluralTarget = "یورو",
            pluralBnPron = "ইউরো",
            bnMeaning = "ইউরো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_887",
            category = VocabCategory.SHOPPING,
            singularTarget = "روپیہ",
            singularBnPron = "রুপিয়া",
            pluralTarget = "روپے",
            pluralBnPron = "রুপিয়ে",
            bnMeaning = "রুপি / টাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_888",
            category = VocabCategory.SHOPPING,
            singularTarget = "ین",
            singularBnPron = "ইয়েন",
            pluralTarget = "ین",
            pluralBnPron = "ইয়েন",
            bnMeaning = "ইয়েন (জাপানি মুদ্রা)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_889",
            category = VocabCategory.SHOPPING,
            singularTarget = "نقد",
            singularBnPron = "নগদ",
            pluralTarget = "نقد",
            pluralBnPron = "নগদ",
            bnMeaning = "নগদ টাকা / ক্যাশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_890",
            category = VocabCategory.SHOPPING,
            singularTarget = "ادھار",
            singularBnPron = "উধার",
            pluralTarget = "ادھار",
            pluralBnPron = "উধার",
            bnMeaning = "ক্রেডিট / বাকি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_891",
            category = VocabCategory.SHOPPING,
            singularTarget = "بچت",
            singularBnPron = "বচত",
            pluralTarget = "بچتیں",
            pluralBnPron = "বচতেঁ",
            bnMeaning = "সঞ্চয় / সেভিংস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_892",
            category = VocabCategory.SHOPPING,
            singularTarget = "منافع / فائدہ",
            singularBnPron = "মুনাফা",
            pluralTarget = "منافع",
            pluralBnPron = "মুনাফা",
            bnMeaning = "লাভ / মুনাফা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_893",
            category = VocabCategory.SHOPPING,
            singularTarget = "نقصان / خسارہ",
            singularBnPron = "নুকসান",
            pluralTarget = "نقصانات",
            pluralBnPron = "নুকসানাত",
            bnMeaning = "ক্ষতি / লোকসান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_894",
            category = VocabCategory.SHOPPING,
            singularTarget = "اشتہار",
            singularBnPron = "ইশতিহার",
            pluralTarget = "اشتہارات",
            pluralBnPron = "ইশতিহারাত",
            bnMeaning = "বিজ্ঞাপন / অ্যাড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_895",
            category = VocabCategory.SHOPPING,
            singularTarget = "نمونہ",
            singularBnPron = "নমুনা",
            pluralTarget = "نمونے",
            pluralBnPron = "নমুনে",
            bnMeaning = "নমুনা / স্যাম্পল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_896",
            category = VocabCategory.SHOPPING,
            singularTarget = "اسٹاک / ذخیرہ",
            singularBnPron = "স্টক",
            pluralTarget = "اسٹاک",
            pluralBnPron = "স্টক",
            bnMeaning = "স্টক / মজুত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_897",
            category = VocabCategory.SHOPPING,
            singularTarget = "بیچنے والا / فروخت کنندہ",
            singularBnPron = "বেচনে ওয়ালা",
            pluralTarget = "فروخت کنندگان",
            pluralBnPron = "বেচনে ওয়ালা",
            bnMeaning = "বিক্রেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_898",
            category = VocabCategory.SHOPPING,
            singularTarget = "خریدار",
            singularBnPron = "খরীদার",
            pluralTarget = "خریدار",
            pluralBnPron = "খরীদার",
            bnMeaning = "ক্রেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_899",
            category = VocabCategory.SHOPPING,
            singularTarget = "درآمد",
            singularBnPron = "দারামদ",
            pluralTarget = "درآمدات",
            pluralBnPron = "দারামদাত",
            bnMeaning = "আমদানি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_900",
            category = VocabCategory.SHOPPING,
            singularTarget = "برآمد",
            singularBnPron = "বারামদ",
            pluralTarget = "برآمدات",
            pluralBnPron = "বারামদাত",
            bnMeaning = "রপ্তানি",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk10 = listOf(
        VocabItem(
            id = "ur_vocab_901",
            category = VocabCategory.TECH,
            singularTarget = "کمپیوٹر",
            singularBnPron = "কম্পিউটার",
            pluralTarget = "کمپیوٹرز",
            pluralBnPron = "কম্পিউটার",
            bnMeaning = "কম্পিউটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_902",
            category = VocabCategory.TECH,
            singularTarget = "لیپ ٹاپ",
            singularBnPron = "ল্যাপটপ",
            pluralTarget = "لیپ ٹاپ",
            pluralBnPron = "ল্যাপটপ",
            bnMeaning = "ল্যাপটপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_903",
            category = VocabCategory.TECH,
            singularTarget = "موبائل فون",
            singularBnPron = "মোবাইল",
            pluralTarget = "موبائل فونز",
            pluralBnPron = "মোবাইল",
            bnMeaning = "মোবাইল ফোন / স্মার্টফোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_904",
            category = VocabCategory.TECH,
            singularTarget = "ٹیبلٹ",
            singularBnPron = "ট্যাবলেট",
            pluralTarget = "ٹیبلٹس",
            pluralBnPron = "ট্যাবলেট",
            bnMeaning = "ট্যাবলেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_905",
            category = VocabCategory.TECH,
            singularTarget = "اسکرین",
            singularBnPron = "স্ক্রিন",
            pluralTarget = "اسکرینز",
            pluralBnPron = "স্ক্রিন",
            bnMeaning = "পর্দা / স্ক্রিন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_906",
            category = VocabCategory.TECH,
            singularTarget = "کی بورڈ",
            singularBnPron = "কীবোর্ড",
            pluralTarget = "کی بورڈ",
            pluralBnPron = "কীবোর্ড",
            bnMeaning = "কীবোর্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_907",
            category = VocabCategory.TECH,
            singularTarget = "ماؤس",
            singularBnPron = "মাউস",
            pluralTarget = "ماؤس",
            pluralBnPron = "মাউস",
            bnMeaning = "মাউস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_908",
            category = VocabCategory.TECH,
            singularTarget = "پرنٹر",
            singularBnPron = "প্রিন্টার",
            pluralTarget = "پرنٹرز",
            pluralBnPron = "প্রিন্টার",
            bnMeaning = "প্রিন্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_909",
            category = VocabCategory.TECH,
            singularTarget = "کیمرہ",
            singularBnPron = "ক্যামেরা",
            pluralTarget = "کیمرے",
            pluralBnPron = "ক্যামেরা",
            bnMeaning = "ক্যামেরা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_910",
            category = VocabCategory.TECH,
            singularTarget = "اسپیکر",
            singularBnPron = "স্পিকার",
            pluralTarget = "اسپیکرز",
            pluralBnPron = "স্পিকার",
            bnMeaning = "লাউডস্পিকার / স্পিকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_911",
            category = VocabCategory.TECH,
            singularTarget = "ہیڈ فونز",
            singularBnPron = "হেডফোন",
            pluralTarget = "ہیڈ فونز",
            pluralBnPron = "হেডফোন",
            bnMeaning = "হেডফোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_912",
            category = VocabCategory.TECH,
            singularTarget = "مائیکرو فون",
            singularBnPron = "মাইক্রোফোন",
            pluralTarget = "مائیکرو فون",
            pluralBnPron = "মাইক্রোফোন",
            bnMeaning = "মাইক্রোফোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_913",
            category = VocabCategory.TECH,
            singularTarget = "چارجر",
            singularBnPron = "চার্জার",
            pluralTarget = "چارجرز",
            pluralBnPron = "চার্জার",
            bnMeaning = "চার্জার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_914",
            category = VocabCategory.TECH,
            singularTarget = "کیبل / تار",
            singularBnPron = "তার",
            pluralTarget = "تاریں",
            pluralBnPron = "তারেঁ",
            bnMeaning = "তার / কেবল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_915",
            category = VocabCategory.TECH,
            singularTarget = "بیٹری",
            singularBnPron = "ব্যাটারি",
            pluralTarget = "بیٹریاں",
            pluralBnPron = "ব্যাটারিয়াঁ",
            bnMeaning = "ব্যাটারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_916",
            category = VocabCategory.TECH,
            singularTarget = "پاور بینک",
            singularBnPron = "পাওয়ার ব্যাংক",
            pluralTarget = "پاور بینک",
            pluralBnPron = "পাওয়ার ব্যাংক",
            bnMeaning = "পাওয়ার ব্যাংক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_917",
            category = VocabCategory.TECH,
            singularTarget = "یو ایس بی / فلیش",
            singularBnPron = "ইউএসবি",
            pluralTarget = "یو ایس بی",
            pluralBnPron = "ইউএসবি",
            bnMeaning = "পেনড্রাইভ / ইউএসবি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_918",
            category = VocabCategory.TECH,
            singularTarget = "ہارڈ ڈسک",
            singularBnPron = "হার্ড ডিস্ক",
            pluralTarget = "ہارڈ ڈسک",
            pluralBnPron = "হার্ড ডিস্ক",
            bnMeaning = "হার্ডডিস্ক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_919",
            category = VocabCategory.TECH,
            singularTarget = "وائی فائی",
            singularBnPron = "ওয়াইফাই",
            pluralTarget = "وائی فائی",
            pluralBnPron = "ওয়াইফাই",
            bnMeaning = "ওয়াইফাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_920",
            category = VocabCategory.TECH,
            singularTarget = "انٹرنیٹ",
            singularBnPron = "ইন্টারনেট",
            pluralTarget = "انٹرنیٹ",
            pluralBnPron = "ইন্টারনেট",
            bnMeaning = "ইন্টারনেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_921",
            category = VocabCategory.TECH,
            singularTarget = "نیٹ ورک",
            singularBnPron = "নেটওয়ার্ক",
            pluralTarget = "نیٹ ورکس",
            pluralBnPron = "নেটওয়ার্ক",
            bnMeaning = "নেটওয়ার্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_922",
            category = VocabCategory.TECH,
            singularTarget = "ویب سائٹ",
            singularBnPron = "ওয়েবসাইট",
            pluralTarget = "ویب سائٹس",
            pluralBnPron = "ওয়েবসাইটেঁ",
            bnMeaning = "ওয়েবসাইট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_923",
            category = VocabCategory.TECH,
            singularTarget = "ای میل",
            singularBnPron = "ইমেইল",
            pluralTarget = "ای میلز",
            pluralBnPron = "ইমেইল",
            bnMeaning = "ইমেইল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_924",
            category = VocabCategory.TECH,
            singularTarget = "پیغام / میسج",
            singularBnPron = "পয়গাম",
            pluralTarget = "پیغامات",
            pluralBnPron = "পয়গামাত",
            bnMeaning = "বার্তা / মেসেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_925",
            category = VocabCategory.TECH,
            singularTarget = "فون کال",
            singularBnPron = "ফোন কল",
            pluralTarget = "کالز",
            pluralBnPron = "ফোন কল",
            bnMeaning = "ফোন কল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_926",
            category = VocabCategory.TECH,
            singularTarget = "پاس ورڈ",
            singularBnPron = "পাসওয়ার্ড",
            pluralTarget = "پاس ورڈز",
            pluralBnPron = "পাসওয়ার্ড",
            bnMeaning = "পাসওয়ার্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_927",
            category = VocabCategory.TECH,
            singularTarget = "صارف کا نام",
            singularBnPron = "ইউজারনেম",
            pluralTarget = "صارفین",
            pluralBnPron = "ইউজারনেম",
            bnMeaning = "ব্যবহারকারীর নাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_928",
            category = VocabCategory.TECH,
            singularTarget = "اکاؤنٹ / کھاتہ",
            singularBnPron = "অ্যাকাউন্ট",
            pluralTarget = "اکاؤنٹس",
            pluralBnPron = "অ্যাকাউন্ট",
            bnMeaning = "হিসাব / অ্যাকাউন্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_929",
            category = VocabCategory.TECH,
            singularTarget = "ایپ",
            singularBnPron = "অ্যাপ",
            pluralTarget = "ایپس",
            pluralBnPron = "অ্যাপ",
            bnMeaning = "অ্যাপ্লিকেশন / অ্যাপ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_930",
            category = VocabCategory.TECH,
            singularTarget = "سافٹ ویئر",
            singularBnPron = "সফটওয়্যার",
            pluralTarget = "سافٹ ویئر",
            pluralBnPron = "সফটওয়্যার",
            bnMeaning = "সফটওয়্যার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_931",
            category = VocabCategory.TECH,
            singularTarget = "فائل",
            singularBnPron = "ফাইল",
            pluralTarget = "فائلیں",
            pluralBnPron = "ফাইলেঁ",
            bnMeaning = "নথি / ফাইল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_932",
            category = VocabCategory.TECH,
            singularTarget = "فولڈر",
            singularBnPron = "ফোল্ডার",
            pluralTarget = "فولڈرز",
            pluralBnPron = "ফোল্ডার",
            bnMeaning = "ফোল্ডার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_933",
            category = VocabCategory.TECH,
            singularTarget = "دستاویز",
            singularBnPron = "দস্তাবেজ",
            pluralTarget = "دستاویزات",
            pluralBnPron = "দস্তাবেজাত",
            bnMeaning = "দলিল / ডকুমেন্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_934",
            category = VocabCategory.TECH,
            singularTarget = "تصویر",
            singularBnPron = "তসবীর",
            pluralTarget = "تصاویر",
            pluralBnPron = "তসাবীর",
            bnMeaning = "ছবি / ইমেজ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_935",
            category = VocabCategory.TECH,
            singularTarget = "ویڈیو",
            singularBnPron = "ভিডিও",
            pluralTarget = "ویڈیوز",
            pluralBnPron = "ভিডিও",
            bnMeaning = "ভিডিও",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_936",
            category = VocabCategory.TECH,
            singularTarget = "آڈیو",
            singularBnPron = "অডিও",
            pluralTarget = "آڈیو",
            pluralBnPron = "অডিও",
            bnMeaning = "অডিও / শব্দ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_937",
            category = VocabCategory.TECH,
            singularTarget = "لنک",
            singularBnPron = "লিংক",
            pluralTarget = "لنکس",
            pluralBnPron = "লিংক",
            bnMeaning = "সংযোগ / লিংক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_938",
            category = VocabCategory.TECH,
            singularTarget = "سوشل میڈیا",
            singularBnPron = "সোশ্যাল মিডিয়া",
            pluralTarget = "سوشل میڈیا",
            pluralBnPron = "সোশ্যাল মিডিয়া",
            bnMeaning = "সামাজিক যোগাযোগ মাধ্যম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_939",
            category = VocabCategory.TECH,
            singularTarget = "ڈاؤن لوڈ",
            singularBnPron = "ডাউনলোড",
            pluralTarget = "ڈاؤن لوڈز",
            pluralBnPron = "ডাউনলোড",
            bnMeaning = "ডাউনলোড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_940",
            category = VocabCategory.TECH,
            singularTarget = "اپ لوڈ",
            singularBnPron = "আপলোড",
            pluralTarget = "اپ لوڈز",
            pluralBnPron = "আপলোড",
            bnMeaning = "আপলোড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_941",
            category = VocabCategory.TECH,
            singularTarget = "تلاش / سرچ",
            singularBnPron = "তালাশ",
            pluralTarget = "تلاش",
            pluralBnPron = "তালাশ",
            bnMeaning = "অনুসন্ধান / সার্চ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_942",
            category = VocabCategory.TECH,
            singularTarget = "کلک",
            singularBnPron = "ক্লিক",
            pluralTarget = "کلکس",
            pluralBnPron = "ক্লিক",
            bnMeaning = "ক্লিক করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_943",
            category = VocabCategory.TECH,
            singularTarget = "محفوظ کرنا / سیو",
            singularBnPron = "সেভ",
            pluralTarget = "سیو",
            pluralBnPron = "সেভ",
            bnMeaning = "সংরক্ষণ / সেভ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_944",
            category = VocabCategory.TECH,
            singularTarget = "حذف کرنا / ڈیلیٹ",
            singularBnPron = "ডিলিট",
            pluralTarget = "ڈیلیٹ",
            pluralBnPron = "ডিলিট",
            bnMeaning = "মুছে ফেলা / ডিলিট করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_945",
            category = VocabCategory.TECH,
            singularTarget = "انسٹال کرنا",
            singularBnPron = "ইনস্টল",
            pluralTarget = "انسٹال",
            pluralBnPron = "ইনস্টল",
            bnMeaning = "ইনস্টল করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_946",
            category = VocabCategory.TECH,
            singularTarget = "اپ ڈیٹ",
            singularBnPron = "আপডেট",
            pluralTarget = "اپ ڈیٹس",
            pluralBnPron = "আপডেট",
            bnMeaning = "হালনাগাদ / আপডেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_947",
            category = VocabCategory.TECH,
            singularTarget = "اطلاع / نوٹیفکیشن",
            singularBnPron = "ইত্তেলা",
            pluralTarget = "اطلاعات",
            pluralBnPron = "ইত্তেলাআত",
            bnMeaning = "বিজ্ঞপ্তি / নোটিফিকেশন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_948",
            category = VocabCategory.TECH,
            singularTarget = "ترتیبات / سیٹنگز",
            singularBnPron = "তারতীবাত",
            pluralTarget = "ترتیبات",
            pluralBnPron = "তারতীবাত",
            bnMeaning = "সেটিংস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_949",
            category = VocabCategory.TECH,
            singularTarget = "ڈیجیٹل",
            singularBnPron = "ডিজিটাল",
            pluralTarget = "ڈیجیٹل",
            pluralBnPron = "ডিজিটাল",
            bnMeaning = "ডিজিটাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_950",
            category = VocabCategory.TECH,
            singularTarget = "ٹیکنالوجی",
            singularBnPron = "টেকনোলজি",
            pluralTarget = "ٹیکنالوجی",
            pluralBnPron = "টেকনোলজি",
            bnMeaning = "প্রযুক্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_951",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ہنگامی حالت",
            singularBnPron = "হাঙ্গামী হালত",
            pluralTarget = "حالات",
            pluralBnPron = "হাঙ্গামী হালাত",
            bnMeaning = "জরুরি অবস্থা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_952",
            category = VocabCategory.EMERGENCY,
            singularTarget = "خطرہ",
            singularBnPron = "খতরা",
            pluralTarget = "خطرات",
            pluralBnPron = "খতরাত",
            bnMeaning = "বিপদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_953",
            category = VocabCategory.EMERGENCY,
            singularTarget = "مدد / بچاؤ",
            singularBnPron = "মদদ",
            pluralTarget = "مدد",
            pluralBnPron = "মদদ",
            bnMeaning = "সাহায্য / বাঁচাও",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_954",
            category = VocabCategory.EMERGENCY,
            singularTarget = "پولیس",
            singularBnPron = "পুলিশ",
            pluralTarget = "پولیس",
            pluralBnPron = "পুলিশ",
            bnMeaning = "পুলিশ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_955",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ایمبولینس",
            singularBnPron = "অ্যাম্বুলেন্স",
            pluralTarget = "ایمبولینس",
            pluralBnPron = "অ্যাম্বুলেন্স",
            bnMeaning = "অ্যাম্বুলেন্স",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_956",
            category = VocabCategory.EMERGENCY,
            singularTarget = "فائر بریگیڈ",
            singularBnPron = "ফায়ার ব্রিগেড",
            pluralTarget = "فائر بریگیڈ",
            pluralBnPron = "ফায়ার ব্রিগেড",
            bnMeaning = "দমকল বাহিনী / ফায়ার সার্ভিস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_957",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ابتدائی طبی امداد",
            singularBnPron = "ইবতেদায়ী তিব্বি ইমদাদ",
            pluralTarget = "طبی امداد",
            pluralBnPron = "ইবতেদায়ী তিব্বি ইমদাদ",
            bnMeaning = "প্রাথমিক চিকিৎসা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_958",
            category = VocabCategory.EMERGENCY,
            singularTarget = "فرسٹ ایڈ کٹ",
            singularBnPron = "ফার্স্ট এইড কিট",
            pluralTarget = "کٹ",
            pluralBnPron = "ফার্স্ট এইড কিট",
            bnMeaning = "প্রাথমিক চিকিৎসার বাক্স",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_959",
            category = VocabCategory.EMERGENCY,
            singularTarget = "پٹی",
            singularBnPron = "পট্টি",
            pluralTarget = "پٹیاں",
            pluralBnPron = "পট্টিয়াঁ",
            bnMeaning = "ব্যান্ডেজ / পট্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_960",
            category = VocabCategory.EMERGENCY,
            singularTarget = "دوا",
            singularBnPron = "দাওয়া",
            pluralTarget = "دوائیں",
            pluralBnPron = "দাওয়াএঁ",
            bnMeaning = "ঔষধ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_961",
            category = VocabCategory.EMERGENCY,
            singularTarget = "درد کش دوا",
            singularBnPron = "দর্দ কুশ দাওয়া",
            pluralTarget = "دوائیں",
            pluralBnPron = "দাওয়াএঁ",
            bnMeaning = "ব্যথানাশক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_962",
            category = VocabCategory.EMERGENCY,
            singularTarget = "انجکشن / ٹیکہ",
            singularBnPron = "টিকা",
            pluralTarget = "ٹیکے",
            pluralBnPron = "টিকে",
            bnMeaning = "ইনজেকশন / সুঁই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_963",
            category = VocabCategory.EMERGENCY,
            singularTarget = "تھرمامیٹر",
            singularBnPron = "থার্মোমিটার",
            pluralTarget = "تھرمامیٹر",
            pluralBnPron = "থার্মোমিটার",
            bnMeaning = "থার্মোমিটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_964",
            category = VocabCategory.EMERGENCY,
            singularTarget = "مریض",
            singularBnPron = "মরীজ",
            pluralTarget = "مریض",
            pluralBnPron = "মরীজ",
            bnMeaning = "রোগী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_965",
            category = VocabCategory.EMERGENCY,
            singularTarget = "بیماری / مرض",
            singularBnPron = "বীমারী",
            pluralTarget = "امراض",
            pluralBnPron = "আমরাজ",
            bnMeaning = "রোগ / ব্যাধি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_966",
            category = VocabCategory.EMERGENCY,
            singularTarget = "درد / تکلیف",
            singularBnPron = "দর্দ",
            pluralTarget = "درد",
            pluralBnPron = "দর্দ",
            bnMeaning = "ব্যথা / বেদনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_967",
            category = VocabCategory.EMERGENCY,
            singularTarget = "بخار",
            singularBnPron = "বুখার",
            pluralTarget = "بخار",
            pluralBnPron = "বুখার",
            bnMeaning = "জ্বর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_968",
            category = VocabCategory.EMERGENCY,
            singularTarget = "کھانسی",
            singularBnPron = "খাঁসী",
            pluralTarget = "کھانسی",
            pluralBnPron = "খাঁসী",
            bnMeaning = "কাশি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_969",
            category = VocabCategory.EMERGENCY,
            singularTarget = "زکام / فلو",
            singularBnPron = "জুকাম",
            pluralTarget = "زکام",
            pluralBnPron = "জুকাম",
            bnMeaning = "সর্দি / ফ্লু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_970",
            category = VocabCategory.EMERGENCY,
            singularTarget = "سر درد",
            singularBnPron = "সর দর্দ",
            pluralTarget = "سر درد",
            pluralBnPron = "সর দর্দ",
            bnMeaning = "মাথাব্যথা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_971",
            category = VocabCategory.EMERGENCY,
            singularTarget = "پیٹ درد",
            singularBnPron = "পেট দর্দ",
            pluralTarget = "پیٹ درد",
            pluralBnPron = "পেট দর্দ",
            bnMeaning = "পেটব্যথা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_972",
            category = VocabCategory.EMERGENCY,
            singularTarget = "زخم / گھاؤ",
            singularBnPron = "জখম",
            pluralTarget = "زخم",
            pluralBnPron = "জখম",
            bnMeaning = "ক্ষত / ঘা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_973",
            category = VocabCategory.EMERGENCY,
            singularTarget = "جلن / جل جانا",
            singularBnPron = "জ্বলন",
            pluralTarget = "جلن",
            pluralBnPron = "জ্বলন",
            bnMeaning = "পোড়া / দগ্ধ হওয়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_974",
            category = VocabCategory.EMERGENCY,
            singularTarget = "خون بہنا",
            singularBnPron = "খুন বহনা",
            pluralTarget = "خون بہنا",
            pluralBnPron = "খুন বহনা",
            bnMeaning = "রক্তপাত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_975",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ہڈی کا ٹوٹنا",
            singularBnPron = "হড্ডী টুটনা",
            pluralTarget = "ہڈی ٹوٹنا",
            pluralBnPron = "হড্ডী টুটনা",
            bnMeaning = "হাড়ভাঙা / ফ্র্যাকচার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_976",
            category = VocabCategory.EMERGENCY,
            singularTarget = "الرجی",
            singularBnPron = "অ্যালার্জি",
            pluralTarget = "الرجی",
            pluralBnPron = "অ্যালার্জি",
            bnMeaning = "অ্যালার্জি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_977",
            category = VocabCategory.EMERGENCY,
            singularTarget = "زہر",
            singularBnPron = "জহর",
            pluralTarget = "زہر",
            pluralBnPron = "জহর",
            bnMeaning = "বিষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_978",
            category = VocabCategory.EMERGENCY,
            singularTarget = "حادثہ",
            singularBnPron = "হাদসা",
            pluralTarget = "حادثات",
            pluralBnPron = "হাদসাত",
            bnMeaning = "দুর্ঘটনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_979",
            category = VocabCategory.EMERGENCY,
            singularTarget = "آگ لگنا",
            singularBnPron = "আতাশজাদগী",
            pluralTarget = "آتشزدگی",
            pluralBnPron = "আতাশজাদগী",
            bnMeaning = "অগ্নিকাণ্ড",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_980",
            category = VocabCategory.EMERGENCY,
            singularTarget = "سیلاب",
            singularBnPron = "সয়লাব",
            pluralTarget = "سیلاب",
            pluralBnPron = "সয়লাব",
            bnMeaning = "বন্যা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_981",
            category = VocabCategory.EMERGENCY,
            singularTarget = "زلزلہ",
            singularBnPron = "জালজালা",
            pluralTarget = "زلزلے",
            pluralBnPron = "জালজালে",
            bnMeaning = "ভূমিকম্প",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_982",
            category = VocabCategory.EMERGENCY,
            singularTarget = "سمندری طوفان",
            singularBnPron = "তুফান",
            pluralTarget = "طوفان",
            pluralBnPron = "তুফান",
            bnMeaning = "ঘূর্ণিঝড় / সাইক্লোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_983",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ہنگامی اخراج",
            singularBnPron = "হাঙ্গামী ইখরাজ",
            pluralTarget = "اخراج",
            pluralBnPron = "হাঙ্গামী ইখরাজ",
            bnMeaning = "জরুরি প্রস্থান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_984",
            category = VocabCategory.EMERGENCY,
            singularTarget = "آگ بجھانے کا آلہ",
            singularBnPron = "আগ বুঝানে কা আলা",
            pluralTarget = "آلات",
            pluralBnPron = "আলাত",
            bnMeaning = "অগ্নিনির্বাপক যন্ত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_985",
            category = VocabCategory.EMERGENCY,
            singularTarget = "انتباہ / وارننگ",
            singularBnPron = "ইনতেবাহ",
            pluralTarget = "انتباہ",
            pluralBnPron = "ইনতেবাহ",
            bnMeaning = "সতর্কবার্তা / ওয়ার্নিং",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_986",
            category = VocabCategory.EMERGENCY,
            singularTarget = "خطرے کا الارم",
            singularBnPron = "খতরে কা অ্যালার্ম",
            pluralTarget = "الارم",
            pluralBnPron = "অ্যালার্ম",
            bnMeaning = "বিপদ সংকেত / অ্যালার্ম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_987",
            category = VocabCategory.EMERGENCY,
            singularTarget = "سائرن",
            singularBnPron = "সাইরেন",
            pluralTarget = "سائرن",
            pluralBnPron = "সাইরেন",
            bnMeaning = "সাইরেন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_988",
            category = VocabCategory.EMERGENCY,
            singularTarget = "سیکیورٹی گارڈ / چوکیدار",
            singularBnPron = "চৌকিদার",
            pluralTarget = "چوکیدار",
            pluralBnPron = "চৌকিদার",
            bnMeaning = "নিরাপত্তারক্ষী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_989",
            category = VocabCategory.EMERGENCY,
            singularTarget = "حفاظت / سلامتی",
            singularBnPron = "হিফাজত",
            pluralTarget = "حفاظت",
            pluralBnPron = "হিফাজত",
            bnMeaning = "নিরাপত্তা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_990",
            category = VocabCategory.EMERGENCY,
            singularTarget = "لائف جیکٹ",
            singularBnPron = "লাইফ জ্যাকেট",
            pluralTarget = "جیکٹیں",
            pluralBnPron = "লাইফ জ্যাকেট",
            bnMeaning = "লাইফ জ্যাকেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_991",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ریسکیو ٹیم",
            singularBnPron = "রেসকিউ টিম",
            pluralTarget = "ٹیمیں",
            pluralBnPron = "রেসকিউ টিম",
            bnMeaning = "উদ্ধারকারী দল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_992",
            category = VocabCategory.EMERGENCY,
            singularTarget = "پناہ گاہ",
            singularBnPron = "পানাহ গাহ",
            pluralTarget = "پناہ گاہیں",
            pluralBnPron = "পানাহ গাহেঁ",
            bnMeaning = "আশ্রয়স্থল / শেল্টার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_993",
            category = VocabCategory.EMERGENCY,
            singularTarget = "انشورنس / بیمہ",
            singularBnPron = "বীমা",
            pluralTarget = "بیمہ",
            pluralBnPron = "বীমা",
            bnMeaning = "বীমা / ইন্স্যুরেন্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_994",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ہنگامی نمبر",
            singularBnPron = "হাঙ্গামী নম্বর",
            pluralTarget = "نمبرز",
            pluralBnPron = "হাঙ্গামী নম্বর",
            bnMeaning = "জরুরি নম্বর / হটলাইন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_995",
            category = VocabCategory.EMERGENCY,
            singularTarget = "لاپتہ / گمشدہ",
            singularBnPron = "লাপাতা",
            pluralTarget = "لاپتہ",
            pluralBnPron = "লাপাতা",
            bnMeaning = "হারিয়ে যাওয়া / নিখোঁজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_996",
            category = VocabCategory.EMERGENCY,
            singularTarget = "لاش / میت",
            singularBnPron = "লাশ",
            pluralTarget = "لاشیں",
            pluralBnPron = "লাশেঁ",
            bnMeaning = "মৃতদেহ / লাশ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "ur_vocab_997",
            category = VocabCategory.EMERGENCY,
            singularTarget = "زندہ بچ جانے والا",
            singularBnPron = "জিন্দা বচ জানে ওয়ালা",
            pluralTarget = "والے",
            pluralBnPron = "বাচনে ওয়ালে",
            bnMeaning = "জীবিত / সারভাইভার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_998",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ملبہ",
            singularBnPron = "মলবা",
            pluralTarget = "ملبہ",
            pluralBnPron = "মলবা",
            bnMeaning = "ধ্বংসাবশেষ / ধ্বংসস্তূপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_999",
            category = VocabCategory.EMERGENCY,
            singularTarget = "انخلاء",
            singularBnPron = "ইনখেলা",
            pluralTarget = "انخلاء",
            pluralBnPron = "ইনখেলা",
            bnMeaning = "নিরাপদ প্রস্থান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "ur_vocab_1000",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ہنگامی پیغام / ایس او ایس",
            singularBnPron = "এসওএস",
            pluralTarget = "پیغام",
            pluralBnPron = "এসওএস",
            bnMeaning = "জরুরি সংকেত / এসওএস",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    val config = VocabLanguageConfig(
        langCode = "ur",
        speechLang = SpeechLang.UR,
        titleBn = "উর্দু শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি প্রয়োজনীয় উর্দু শব্দ (একবচন, বহুবচন ও লিঙ্গ সহ)",
        nativeTitle = "اردو الفاظ کا خزانہ",
        accentColorHex = 0xFF00695C,
        items = chunk1 + chunk2 + chunk3 + chunk4 + chunk5 + chunk6 + chunk7 + chunk8 + chunk9 + chunk10
    )
}
