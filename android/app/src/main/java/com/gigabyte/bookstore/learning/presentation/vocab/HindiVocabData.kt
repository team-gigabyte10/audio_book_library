package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object HindiVocabData {
    private val chunk1 = listOf(
        VocabItem(
            id = "hi_vocab_1",
            category = VocabCategory.FAMILY,
            singularTarget = "पिता",
            singularBnPron = "পিতা",
            pluralTarget = "पिता",
            pluralBnPron = "পিতা",
            bnMeaning = "বাবা / পিতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_2",
            category = VocabCategory.FAMILY,
            singularTarget = "माता",
            singularBnPron = "মাতা",
            pluralTarget = "माताएं",
            pluralBnPron = "মাতাএঁ",
            bnMeaning = "মা / মাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_3",
            category = VocabCategory.FAMILY,
            singularTarget = "बेटा",
            singularBnPron = "বেটা",
            pluralTarget = "बेटे",
            pluralBnPron = "বেটে",
            bnMeaning = "ছেলে / পুত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_4",
            category = VocabCategory.FAMILY,
            singularTarget = "बेटी",
            singularBnPron = "বেটি",
            pluralTarget = "बेटियां",
            pluralBnPron = "বেটিয়াঁ",
            bnMeaning = "মেয়ে / কন্যা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_5",
            category = VocabCategory.FAMILY,
            singularTarget = "भाई",
            singularBnPron = "ভাই",
            pluralTarget = "भाई",
            pluralBnPron = "ভাই",
            bnMeaning = "ভাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_6",
            category = VocabCategory.FAMILY,
            singularTarget = "बहन",
            singularBnPron = "বহন",
            pluralTarget = "बहनें",
            pluralBnPron = "বহনেঁ",
            bnMeaning = "বোন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_7",
            category = VocabCategory.FAMILY,
            singularTarget = "दादा",
            singularBnPron = "দাদা",
            pluralTarget = "दादा",
            pluralBnPron = "দাদা",
            bnMeaning = "দাদা / নানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_8",
            category = VocabCategory.FAMILY,
            singularTarget = "दादी",
            singularBnPron = "দাদি",
            pluralTarget = "दादियां",
            pluralBnPron = "দাদিয়াঁ",
            bnMeaning = "দাদি / নানি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_9",
            category = VocabCategory.FAMILY,
            singularTarget = "पोता",
            singularBnPron = "পোতা",
            pluralTarget = "पोते",
            pluralBnPron = "পোতে",
            bnMeaning = "নাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_10",
            category = VocabCategory.FAMILY,
            singularTarget = "पोती",
            singularBnPron = "পোতি",
            pluralTarget = "पोतियां",
            pluralBnPron = "পোতিয়াঁ",
            bnMeaning = "নাতনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_11",
            category = VocabCategory.FAMILY,
            singularTarget = "चाचा",
            singularBnPron = "চাচা",
            pluralTarget = "चाचा",
            pluralBnPron = "চাচা",
            bnMeaning = "চাচা / মামা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_12",
            category = VocabCategory.FAMILY,
            singularTarget = "चाची",
            singularBnPron = "চাচি",
            pluralTarget = "चाचियां",
            pluralBnPron = "চাচিয়াঁ",
            bnMeaning = "চাচি / খালা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_13",
            category = VocabCategory.FAMILY,
            singularTarget = "भतीजा",
            singularBnPron = "ভতিজা",
            pluralTarget = "भतीजे",
            pluralBnPron = "ভতিজে",
            bnMeaning = "ভাতিজা / ভাগ্নে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_14",
            category = VocabCategory.FAMILY,
            singularTarget = "भतीजी",
            singularBnPron = "ভতিজি",
            pluralTarget = "भतीजियां",
            pluralBnPron = "ভতিজিয়াঁ",
            bnMeaning = "ভাতিজি / ভাগ্নি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_15",
            category = VocabCategory.FAMILY,
            singularTarget = "चचेरा भाई",
            singularBnPron = "চচেরা ভাই",
            pluralTarget = "चचेरे भाई",
            pluralBnPron = "চচেরে ভাই",
            bnMeaning = "চাচাতো ভাই/বোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_16",
            category = VocabCategory.FAMILY,
            singularTarget = "पति",
            singularBnPron = "পতি",
            pluralTarget = "पति",
            pluralBnPron = "পতি",
            bnMeaning = "স্বামী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_17",
            category = VocabCategory.FAMILY,
            singularTarget = "पत्नी",
            singularBnPron = "পত্নী",
            pluralTarget = "पत्नियां",
            pluralBnPron = "পত্নীয়াঁ",
            bnMeaning = "স্ত্রী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_18",
            category = VocabCategory.FAMILY,
            singularTarget = "बच्चा",
            singularBnPron = "বাচ্চা",
            pluralTarget = "बच्चे",
            pluralBnPron = "বাচ্চে",
            bnMeaning = "সন্তান / শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_19",
            category = VocabCategory.FAMILY,
            singularTarget = "शिशु",
            singularBnPron = "শিশু",
            pluralTarget = "शिशु",
            pluralBnPron = "শিশু",
            bnMeaning = "নবজাতক শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_20",
            category = VocabCategory.FAMILY,
            singularTarget = "अभिभावक",
            singularBnPron = "অভিভাবক",
            pluralTarget = "अभिभावक",
            pluralBnPron = "অভিভাবক",
            bnMeaning = "বাবা-মা (অভিভাবক)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_21",
            category = VocabCategory.FAMILY,
            singularTarget = "लड़का",
            singularBnPron = "লড়কা",
            pluralTarget = "लड़के",
            pluralBnPron = "লড়কে",
            bnMeaning = "ছেলে / বালক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_22",
            category = VocabCategory.FAMILY,
            singularTarget = "लड़की",
            singularBnPron = "লড়কী",
            pluralTarget = "लड़कियां",
            pluralBnPron = "লড়কিয়াঁ",
            bnMeaning = "মেয়ে / বালিকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_23",
            category = VocabCategory.FAMILY,
            singularTarget = "पुरुष",
            singularBnPron = "পুরুষ",
            pluralTarget = "पुरुष",
            pluralBnPron = "পুরুষ",
            bnMeaning = "পুরুষ / ব্যক্তি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_24",
            category = VocabCategory.FAMILY,
            singularTarget = "महिला",
            singularBnPron = "মহিলা",
            pluralTarget = "महिलाएं",
            pluralBnPron = "মহিলাএঁ",
            bnMeaning = "নারী / মহিলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_25",
            category = VocabCategory.FAMILY,
            singularTarget = "दोस्त",
            singularBnPron = "দোস্ত",
            pluralTarget = "दोस्त",
            pluralBnPron = "দোস্ত",
            bnMeaning = "বন্ধু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_26",
            category = VocabCategory.FAMILY,
            singularTarget = "पड़ोसी",
            singularBnPron = "পড়োসি",
            pluralTarget = "पड़ोसी",
            pluralBnPron = "পড়োসি",
            bnMeaning = "প্রতিবেশী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_27",
            category = VocabCategory.FAMILY,
            singularTarget = "अतिथि",
            singularBnPron = "অতিথি",
            pluralTarget = "अतिथि",
            pluralBnPron = "অতিথি",
            bnMeaning = "অতিথি / মেহমান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_28",
            category = VocabCategory.FAMILY,
            singularTarget = "सहकर्मी",
            singularBnPron = "সহকর্মী",
            pluralTarget = "सहकर्मी",
            pluralBnPron = "সহকর্মী",
            bnMeaning = "সহকর্মী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_29",
            category = VocabCategory.FAMILY,
            singularTarget = "सहपाठी",
            singularBnPron = "সহপাঠী",
            pluralTarget = "सहपाठी",
            pluralBnPron = "সহপাঠী",
            bnMeaning = "সহপাঠী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_30",
            category = VocabCategory.FAMILY,
            singularTarget = "शिक्षक",
            singularBnPron = "শিক্ষক",
            pluralTarget = "शिक्षक",
            pluralBnPron = "শিক্ষক",
            bnMeaning = "শিক্ষক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_31",
            category = VocabCategory.FAMILY,
            singularTarget = "छात्र",
            singularBnPron = "ছাত্র",
            pluralTarget = "छात्र",
            pluralBnPron = "ছাত্র",
            bnMeaning = "ছাত্র / শিক্ষার্থী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_32",
            category = VocabCategory.FAMILY,
            singularTarget = "परिवार",
            singularBnPron = "পরিবার",
            pluralTarget = "परिवार",
            pluralBnPron = "পরিবার",
            bnMeaning = "পরিবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_33",
            category = VocabCategory.FAMILY,
            singularTarget = "रिश्तेदार",
            singularBnPron = "রিশ্তেদার",
            pluralTarget = "रिश्तेदार",
            pluralBnPron = "রিশ্তেদার",
            bnMeaning = "আত্মীয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_34",
            category = VocabCategory.FAMILY,
            singularTarget = "मानव",
            singularBnPron = "মানব",
            pluralTarget = "मानव",
            pluralBnPron = "মানব",
            bnMeaning = "মানুষ / জাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_35",
            category = VocabCategory.FAMILY,
            singularTarget = "दूल्हा",
            singularBnPron = "দুলহা",
            pluralTarget = "दूल्हे",
            pluralBnPron = "দুলহে",
            bnMeaning = "বর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_36",
            category = VocabCategory.FAMILY,
            singularTarget = "दुल्हन",
            singularBnPron = "দুলহন",
            pluralTarget = "दुल्हनें",
            pluralBnPron = "দুলহনেঁ",
            bnMeaning = "কনে / নববধূ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_37",
            category = VocabCategory.FAMILY,
            singularTarget = "जुड़वां",
            singularBnPron = "জুড়ওয়াঁ",
            pluralTarget = "जुड़वां",
            pluralBnPron = "জুড়ওয়াঁ",
            bnMeaning = "যমজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_38",
            category = VocabCategory.FAMILY,
            singularTarget = "नागरिक",
            singularBnPron = "নাগরিক",
            pluralTarget = "नागरिक",
            pluralBnPron = "নাগরিক",
            bnMeaning = "নাগরিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_39",
            category = VocabCategory.FAMILY,
            singularTarget = "व्यक्ति",
            singularBnPron = "ব্যক্তি",
            pluralTarget = "लोग",
            pluralBnPron = "লোগ",
            bnMeaning = "ব্যক্তি / লোক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_40",
            category = VocabCategory.FAMILY,
            singularTarget = "समूह",
            singularBnPron = "সমূহ",
            pluralTarget = "समूह",
            pluralBnPron = "সমূহ",
            bnMeaning = "দল / জনগোষ্ঠী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_41",
            category = VocabCategory.FAMILY,
            singularTarget = "युवा",
            singularBnPron = "যুবা",
            pluralTarget = "युवा",
            pluralBnPron = "যুবা",
            bnMeaning = "যুবক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_42",
            category = VocabCategory.FAMILY,
            singularTarget = "बुजुर्ग",
            singularBnPron = "বুজুর্গ",
            pluralTarget = "बुजुर्ग",
            pluralBnPron = "বুজুর্গ",
            bnMeaning = "বয়োবৃদ্ধ / প্রবীণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_43",
            category = VocabCategory.FAMILY,
            singularTarget = "बच्ची",
            singularBnPron = "বাচ্চি",
            pluralTarget = "बच्चियां",
            pluralBnPron = "বাচ্চিয়াঁ",
            bnMeaning = "মেয়ে শিশু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_44",
            category = VocabCategory.FAMILY,
            singularTarget = "बच्चा",
            singularBnPron = "বাচ্চা",
            pluralTarget = "बच्चे",
            pluralBnPron = "বাচ্চে",
            bnMeaning = "ছেলে শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_45",
            category = VocabCategory.FAMILY,
            singularTarget = "प्रबंधक",
            singularBnPron = "প্রবন্ধক",
            pluralTarget = "प्रबंधक",
            pluralBnPron = "প্রবন্ধক",
            bnMeaning = "ম্যানেজার / পরিচালক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_46",
            category = VocabCategory.FAMILY,
            singularTarget = "मालिक",
            singularBnPron = "মালিক",
            pluralTarget = "मालिक",
            pluralBnPron = "মালিক",
            bnMeaning = "মালিক / কর্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_47",
            category = VocabCategory.FAMILY,
            singularTarget = "नेता",
            singularBnPron = "নেতা",
            pluralTarget = "नेता",
            pluralBnPron = "নেতা",
            bnMeaning = "নেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_48",
            category = VocabCategory.FAMILY,
            singularTarget = "दुश्मन",
            singularBnPron = "দুশমন",
            pluralTarget = "दुश्मन",
            pluralBnPron = "দুশমন",
            bnMeaning = "শত্রু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_49",
            category = VocabCategory.FAMILY,
            singularTarget = "दंपति",
            singularBnPron = "দম্পতি",
            pluralTarget = "दंपति",
            pluralBnPron = "দম্পতি",
            bnMeaning = "দম্পতি / জোড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_50",
            category = VocabCategory.FAMILY,
            singularTarget = "सदस्य",
            singularBnPron = "সদস্য",
            pluralTarget = "सदस्य",
            pluralBnPron = "সদস্য",
            bnMeaning = "দলপতি / সদস্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_51",
            category = VocabCategory.BODY,
            singularTarget = "सिर",
            singularBnPron = "সির",
            pluralTarget = "सिर",
            pluralBnPron = "সির",
            bnMeaning = "মাথা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_52",
            category = VocabCategory.BODY,
            singularTarget = "बाल",
            singularBnPron = "বাল",
            pluralTarget = "बाल",
            pluralBnPron = "বাল",
            bnMeaning = "চুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_53",
            category = VocabCategory.BODY,
            singularTarget = "चेहरा",
            singularBnPron = "চেহেরা",
            pluralTarget = "चेहरे",
            pluralBnPron = "চেহেরে",
            bnMeaning = "মুখমণ্ডল / চেহারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_54",
            category = VocabCategory.BODY,
            singularTarget = "माथा",
            singularBnPron = "মাথা",
            pluralTarget = "माथे",
            pluralBnPron = "মাথে",
            bnMeaning = "কপাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_55",
            category = VocabCategory.BODY,
            singularTarget = "आँख",
            singularBnPron = "আঁখ",
            pluralTarget = "आँखें",
            pluralBnPron = "আঁখেঁ",
            bnMeaning = "চোখ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_56",
            category = VocabCategory.BODY,
            singularTarget = "भौंह",
            singularBnPron = "ভৌঁহ",
            pluralTarget = "भौंहें",
            pluralBnPron = "ভৌঁহেঁ",
            bnMeaning = "ভ্রু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_57",
            category = VocabCategory.BODY,
            singularTarget = "पलक",
            singularBnPron = "পলক",
            pluralTarget = "पलकें",
            pluralBnPron = "পলকেঁ",
            bnMeaning = "চোখের পাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_58",
            category = VocabCategory.BODY,
            singularTarget = "कान",
            singularBnPron = "কান",
            pluralTarget = "कान",
            pluralBnPron = "কান",
            bnMeaning = "কান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_59",
            category = VocabCategory.BODY,
            singularTarget = "नाक",
            singularBnPron = "নাক",
            pluralTarget = "नाक",
            pluralBnPron = "নাক",
            bnMeaning = "নাক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_60",
            category = VocabCategory.BODY,
            singularTarget = "नथुना",
            singularBnPron = "নথুনা",
            pluralTarget = "नथुने",
            pluralBnPron = "নথুনে",
            bnMeaning = "নাকের ছিদ্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_61",
            category = VocabCategory.BODY,
            singularTarget = "मुँह",
            singularBnPron = "মুঁহ",
            pluralTarget = "मुँह",
            pluralBnPron = "মুঁহ",
            bnMeaning = "মুখ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_62",
            category = VocabCategory.BODY,
            singularTarget = "होंठ",
            singularBnPron = "হোন্ঠ",
            pluralTarget = "होंठ",
            pluralBnPron = "হোন্ঠ",
            bnMeaning = "ঠোঁট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_63",
            category = VocabCategory.BODY,
            singularTarget = "दाँत",
            singularBnPron = "দাঁত",
            pluralTarget = "दाँत",
            pluralBnPron = "দাঁত",
            bnMeaning = "দাঁত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_64",
            category = VocabCategory.BODY,
            singularTarget = "जीभ",
            singularBnPron = "জীভ",
            pluralTarget = "जीभें",
            pluralBnPron = "জীভেঁ",
            bnMeaning = "জিভ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_65",
            category = VocabCategory.BODY,
            singularTarget = "ठोड़ी",
            singularBnPron = "ঠোড়ি",
            pluralTarget = "ठोड़ियां",
            pluralBnPron = "ঠোড়িয়াঁ",
            bnMeaning = "চিবুক / থুতনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_66",
            category = VocabCategory.BODY,
            singularTarget = "गाल",
            singularBnPron = "গাল",
            pluralTarget = "गाल",
            pluralBnPron = "গাল",
            bnMeaning = "গাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_67",
            category = VocabCategory.BODY,
            singularTarget = "दाढ़ी",
            singularBnPron = "দাড়ি",
            pluralTarget = "दाढ़ियां",
            pluralBnPron = "দাড়িয়াঁ",
            bnMeaning = "দাড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_68",
            category = VocabCategory.BODY,
            singularTarget = "मूंछ",
            singularBnPron = "মুঁছ",
            pluralTarget = "मूंछें",
            pluralBnPron = "মুঁছেঁ",
            bnMeaning = "গোঁফ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_69",
            category = VocabCategory.BODY,
            singularTarget = "गर्दन",
            singularBnPron = "গর্দন",
            pluralTarget = "गर्दनें",
            pluralBnPron = "গর্দনেঁ",
            bnMeaning = "ঘাড় / গলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_70",
            category = VocabCategory.BODY,
            singularTarget = "गला",
            singularBnPron = "গলা",
            pluralTarget = "गले",
            pluralBnPron = "গলে",
            bnMeaning = "গলা (অভ্যন্তরীণ)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_71",
            category = VocabCategory.BODY,
            singularTarget = "कंधा",
            singularBnPron = "কন্ধা",
            pluralTarget = "कंधे",
            pluralBnPron = "কন্ধে",
            bnMeaning = "কাঁধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_72",
            category = VocabCategory.BODY,
            singularTarget = "छाती",
            singularBnPron = "ছাতি",
            pluralTarget = "छातियां",
            pluralBnPron = "ছাতিয়াঁ",
            bnMeaning = "বুক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_73",
            category = VocabCategory.BODY,
            singularTarget = "पीठ",
            singularBnPron = "পীঠ",
            pluralTarget = "पीठ",
            pluralBnPron = "পীঠ",
            bnMeaning = "পিঠ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_74",
            category = VocabCategory.BODY,
            singularTarget = "बाँह",
            singularBnPron = "বাঁহ",
            pluralTarget = "बाँहें",
            pluralBnPron = "বাঁহেঁ",
            bnMeaning = "হাত (বাহু)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_75",
            category = VocabCategory.BODY,
            singularTarget = "कोहनी",
            singularBnPron = "কোহনি",
            pluralTarget = "कोहनियां",
            pluralBnPron = "কোহনিয়াঁ",
            bnMeaning = "কনুই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_76",
            category = VocabCategory.BODY,
            singularTarget = "कलाई",
            singularBnPron = "কলাই",
            pluralTarget = "कलाइयां",
            pluralBnPron = "কলাইয়াঁ",
            bnMeaning = "কবজি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_77",
            category = VocabCategory.BODY,
            singularTarget = "हाथ",
            singularBnPron = "হাথ",
            pluralTarget = "हाथ",
            pluralBnPron = "হাথ",
            bnMeaning = "হাত (পাঞ্জা)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_78",
            category = VocabCategory.BODY,
            singularTarget = "हथेली",
            singularBnPron = "হথেলি",
            pluralTarget = "हथेलियां",
            pluralBnPron = "হথেলিয়াঁ",
            bnMeaning = "হাতের তালু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_79",
            category = VocabCategory.BODY,
            singularTarget = "अंगुली",
            singularBnPron = "অঙ্গুলি",
            pluralTarget = "अंगुलियां",
            pluralBnPron = "অঙ্গুলিয়াঁ",
            bnMeaning = "আঙুল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_80",
            category = VocabCategory.BODY,
            singularTarget = "अंगूठा",
            singularBnPron = "অঙ্গুঠা",
            pluralTarget = "अंगूठे",
            pluralBnPron = "অঙ্গুঠে",
            bnMeaning = "বুড়ো আঙুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_81",
            category = VocabCategory.BODY,
            singularTarget = "नाखून",
            singularBnPron = "নাখুন",
            pluralTarget = "नाखून",
            pluralBnPron = "নাখুন",
            bnMeaning = "নখ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_82",
            category = VocabCategory.BODY,
            singularTarget = "पेट",
            singularBnPron = "পেট",
            pluralTarget = "पेट",
            pluralBnPron = "পেট",
            bnMeaning = "পেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_83",
            category = VocabCategory.BODY,
            singularTarget = "नाभि",
            singularBnPron = "নাভি",
            pluralTarget = "नाभियां",
            pluralBnPron = "নাভিয়াঁ",
            bnMeaning = "নাভি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_84",
            category = VocabCategory.BODY,
            singularTarget = "कमर",
            singularBnPron = "কমর",
            pluralTarget = "कमर",
            pluralBnPron = "কমর",
            bnMeaning = "কোমর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_85",
            category = VocabCategory.BODY,
            singularTarget = "टांग",
            singularBnPron = "টাং",
            pluralTarget = "टांगें",
            pluralBnPron = "টাঙেঁ",
            bnMeaning = "পা (সমগ্র পা)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_86",
            category = VocabCategory.BODY,
            singularTarget = "जांघ",
            singularBnPron = "জাংঘ",
            pluralTarget = "जांघें",
            pluralBnPron = "জাংঘেঁ",
            bnMeaning = "উরু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_87",
            category = VocabCategory.BODY,
            singularTarget = "घुटने",
            singularBnPron = "ঘুটনা",
            pluralTarget = "घुटने",
            pluralBnPron = "ঘুটনে",
            bnMeaning = "হাঁটু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_88",
            category = VocabCategory.BODY,
            singularTarget = "टखना",
            singularBnPron = "টখনা",
            pluralTarget = "टखने",
            pluralBnPron = "টখনে",
            bnMeaning = "গোড়ালি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_89",
            category = VocabCategory.BODY,
            singularTarget = "पैर",
            singularBnPron = "পৈর",
            pluralTarget = "पैर",
            pluralBnPron = "পৈর",
            bnMeaning = "পায়ের পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_90",
            category = VocabCategory.BODY,
            singularTarget = "पैर की अंगुली",
            singularBnPron = "পৈর কী অঙ্গুলি",
            pluralTarget = "पैर की अंगुलियां",
            pluralBnPron = "পৈর কী অঙ্গুলিয়াঁ",
            bnMeaning = "পায়ের আঙুল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_91",
            category = VocabCategory.BODY,
            singularTarget = "त्वचा",
            singularBnPron = "ত্বচা",
            pluralTarget = "त्वचा",
            pluralBnPron = "ত্বচা",
            bnMeaning = "চামড়া / ত্বক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_92",
            category = VocabCategory.BODY,
            singularTarget = "हड्डी",
            singularBnPron = "হাড্ডি",
            pluralTarget = "हड्डियां",
            pluralBnPron = "হাড্ডিয়াঁ",
            bnMeaning = "হাড়",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_93",
            category = VocabCategory.BODY,
            singularTarget = "मांसपेशी",
            singularBnPron = "মাংসপেশি",
            pluralTarget = "मांसपेशियां",
            pluralBnPron = "মাংসপেশিয়াঁ",
            bnMeaning = "মাংসপেশি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_94",
            category = VocabCategory.BODY,
            singularTarget = "खून",
            singularBnPron = "খুন",
            pluralTarget = "खून",
            pluralBnPron = "খুন",
            bnMeaning = "রক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_95",
            category = VocabCategory.BODY,
            singularTarget = "दिल",
            singularBnPron = "দিল",
            pluralTarget = "दिल",
            pluralBnPron = "দিল",
            bnMeaning = "হৃদপিণ্ড / মন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_96",
            category = VocabCategory.BODY,
            singularTarget = "दिमाग",
            singularBnPron = "দিমাগ",
            pluralTarget = "दिमाग",
            pluralBnPron = "দিমাগ",
            bnMeaning = "মস্তিষ্ক / মগজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_97",
            category = VocabCategory.BODY,
            singularTarget = "फेफड़ा",
            singularBnPron = "ফেফড়া",
            pluralTarget = "फेफड़े",
            pluralBnPron = "ফেফড়ে",
            bnMeaning = "ফুসফুস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_98",
            category = VocabCategory.BODY,
            singularTarget = "आमाशय",
            singularBnPron = "আমাশয়",
            pluralTarget = "आमाशय",
            pluralBnPron = "আমাশয়",
            bnMeaning = "পাকস্থলী / পেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_99",
            category = VocabCategory.BODY,
            singularTarget = "जिगर",
            singularBnPron = "জিগর",
            pluralTarget = "जिगर",
            pluralBnPron = "জিগর",
            bnMeaning = "যকৃৎ / কলিজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_100",
            category = VocabCategory.BODY,
            singularTarget = "आवाज",
            singularBnPron = "আওয়াজ",
            pluralTarget = "आवाजें",
            pluralBnPron = "আওয়াজেঁ",
            bnMeaning = "কণ্ঠস্বর",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk2 = listOf(
        VocabItem(
            id = "hi_vocab_101",
            category = VocabCategory.FOOD,
            singularTarget = "चावल",
            singularBnPron = "চাওয়াল",
            pluralTarget = "चावल",
            pluralBnPron = "চাওয়াল",
            bnMeaning = "ভাত / চাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_102",
            category = VocabCategory.FOOD,
            singularTarget = "रोटी",
            singularBnPron = "রোটি",
            pluralTarget = "रोटियां",
            pluralBnPron = "রোটিয়াঁ",
            bnMeaning = "রুটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_103",
            category = VocabCategory.FOOD,
            singularTarget = "पानी",
            singularBnPron = "পানি",
            pluralTarget = "पानी",
            pluralBnPron = "পানি",
            bnMeaning = "পানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_104",
            category = VocabCategory.FOOD,
            singularTarget = "दूध",
            singularBnPron = "দুধ",
            pluralTarget = "दूध",
            pluralBnPron = "দুধ",
            bnMeaning = "দুধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_105",
            category = VocabCategory.FOOD,
            singularTarget = "चाय",
            singularBnPron = "চায়",
            pluralTarget = "चाय",
            pluralBnPron = "চায়",
            bnMeaning = "চা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_106",
            category = VocabCategory.FOOD,
            singularTarget = "कॉफ़ी",
            singularBnPron = "কফি",
            pluralTarget = "कॉफ़ी",
            pluralBnPron = "কফি",
            bnMeaning = "কফি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_107",
            category = VocabCategory.FOOD,
            singularTarget = "चीनी",
            singularBnPron = "চিনি",
            pluralTarget = "चीनी",
            pluralBnPron = "চিনি",
            bnMeaning = "চিনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_108",
            category = VocabCategory.FOOD,
            singularTarget = "नमक",
            singularBnPron = "নমক",
            pluralTarget = "नमक",
            pluralBnPron = "নমক",
            bnMeaning = "লবণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_109",
            category = VocabCategory.FOOD,
            singularTarget = "तेल",
            singularBnPron = "তেল",
            pluralTarget = "तेल",
            pluralBnPron = "তেল",
            bnMeaning = "তেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_110",
            category = VocabCategory.FOOD,
            singularTarget = "मक्खन",
            singularBnPron = "মাখন",
            pluralTarget = "मक्खन",
            pluralBnPron = "মাখন",
            bnMeaning = "মাখন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_111",
            category = VocabCategory.FOOD,
            singularTarget = "अंडा",
            singularBnPron = "অন্ডা",
            pluralTarget = "अंडे",
            pluralBnPron = "অন্ডে",
            bnMeaning = "ডিম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_112",
            category = VocabCategory.FOOD,
            singularTarget = "मांस",
            singularBnPron = "মাংস",
            pluralTarget = "मांस",
            pluralBnPron = "মাংস",
            bnMeaning = "মাংস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_113",
            category = VocabCategory.FOOD,
            singularTarget = "मुर्गी का मांस",
            singularBnPron = "মুরগী কা মাংস",
            pluralTarget = "मुर्गी का मांस",
            pluralBnPron = "মুরগী কা মাংস",
            bnMeaning = "মুরগির মাংস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_114",
            category = VocabCategory.FOOD,
            singularTarget = "गाय का मांस",
            singularBnPron = "গায়ে কা মাংস",
            pluralTarget = "गाय का मांस",
            pluralBnPron = "গায়ে কা মাংস",
            bnMeaning = "গরুর মাংস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_115",
            category = VocabCategory.FOOD,
            singularTarget = "मछली",
            singularBnPron = "মাছলি",
            pluralTarget = "मछलियां",
            pluralBnPron = "মাছলিয়াঁ",
            bnMeaning = "মাছ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_116",
            category = VocabCategory.FOOD,
            singularTarget = "सूप",
            singularBnPron = "সুপ",
            pluralTarget = "सूप",
            pluralBnPron = "সুপ",
            bnMeaning = "স্যুপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_117",
            category = VocabCategory.FOOD,
            singularTarget = "पनीर",
            singularBnPron = "পনির",
            pluralTarget = "पनीर",
            pluralBnPron = "পনির",
            bnMeaning = "পনির / চিজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_118",
            category = VocabCategory.FOOD,
            singularTarget = "शहद",
            singularBnPron = "শহদ",
            pluralTarget = "शहद",
            pluralBnPron = "শহদ",
            bnMeaning = "মধু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_119",
            category = VocabCategory.FOOD,
            singularTarget = "आटा",
            singularBnPron = "আটা",
            pluralTarget = "आटा",
            pluralBnPron = "আটা",
            bnMeaning = "ময়দা / আটা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_120",
            category = VocabCategory.FOOD,
            singularTarget = "दही",
            singularBnPron = "দহি",
            pluralTarget = "दही",
            pluralBnPron = "দহি",
            bnMeaning = "দই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_121",
            category = VocabCategory.FOOD,
            singularTarget = "रस",
            singularBnPron = "রস",
            pluralTarget = "रस",
            pluralBnPron = "রস",
            bnMeaning = "রস / জুস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_122",
            category = VocabCategory.FOOD,
            singularTarget = "बर्फ",
            singularBnPron = "বর্ফ",
            pluralTarget = "बर्फ",
            pluralBnPron = "বর্ফ",
            bnMeaning = "বরফ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_123",
            category = VocabCategory.FOOD,
            singularTarget = "केक",
            singularBnPron = "কেক",
            pluralTarget = "केक",
            pluralBnPron = "কেক",
            bnMeaning = "কেক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_124",
            category = VocabCategory.FOOD,
            singularTarget = "बिस्कुट",
            singularBnPron = "বিস্কুট",
            pluralTarget = "बिस्कुट",
            pluralBnPron = "বিস্কুট",
            bnMeaning = "বিস্কুট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_125",
            category = VocabCategory.FOOD,
            singularTarget = "मिठाई",
            singularBnPron = "মিঠাই",
            pluralTarget = "मिठाइयां",
            pluralBnPron = "মিঠাইয়াঁ",
            bnMeaning = "মিষ্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_126",
            category = VocabCategory.FOOD,
            singularTarget = "चॉकलेट",
            singularBnPron = "চকলেট",
            pluralTarget = "चॉकलेट",
            pluralBnPron = "চকলেট",
            bnMeaning = "চকলেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_127",
            category = VocabCategory.FOOD,
            singularTarget = "मसाला",
            singularBnPron = "মসালা",
            pluralTarget = "मसाले",
            pluralBnPron = "মসালে",
            bnMeaning = "মসলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_128",
            category = VocabCategory.FOOD,
            singularTarget = "काली मिर्च",
            singularBnPron = "কালী মির্চ",
            pluralTarget = "काली मिर्च",
            pluralBnPron = "কালী মির্চ",
            bnMeaning = "গোলমরিচ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_129",
            category = VocabCategory.FOOD,
            singularTarget = "मिर्च",
            singularBnPron = "মির্চ",
            pluralTarget = "मिर्चें",
            pluralBnPron = "মির্চেঁ",
            bnMeaning = "মরিচ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_130",
            category = VocabCategory.FOOD,
            singularTarget = "हल्दी",
            singularBnPron = "হলদি",
            pluralTarget = "हल्दी",
            pluralBnPron = "হলদি",
            bnMeaning = "হলুদ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_131",
            category = VocabCategory.FOOD,
            singularTarget = "अदरक",
            singularBnPron = "আদরেক",
            pluralTarget = "अदरक",
            pluralBnPron = "আদরেক",
            bnMeaning = "আদা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_132",
            category = VocabCategory.FOOD,
            singularTarget = "लहसुन",
            singularBnPron = "লহসুন",
            pluralTarget = "लहसुन",
            pluralBnPron = "লহসুন",
            bnMeaning = "রসুন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_133",
            category = VocabCategory.FOOD,
            singularTarget = "प्याज",
            singularBnPron = "পিয়াজ",
            pluralTarget = "प्याज",
            pluralBnPron = "পিয়াজ",
            bnMeaning = "পেঁয়াজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_134",
            category = VocabCategory.FOOD,
            singularTarget = "दाल",
            singularBnPron = "দাল",
            pluralTarget = "दालें",
            pluralBnPron = "দালেঁ",
            bnMeaning = "ডাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_135",
            category = VocabCategory.FOOD,
            singularTarget = "सब्जी",
            singularBnPron = "সবজি",
            pluralTarget = "सब्जियां",
            pluralBnPron = "সবজিয়াঁ",
            bnMeaning = "তরকারি / কারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_136",
            category = VocabCategory.FOOD,
            singularTarget = "नूडल्स",
            singularBnPron = "নুডলস",
            pluralTarget = "नूडल्स",
            pluralBnPron = "নুডলস",
            bnMeaning = "নুডলস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_137",
            category = VocabCategory.FOOD,
            singularTarget = "बर्गर",
            singularBnPron = "বার্গার",
            pluralTarget = "बर्गर",
            pluralBnPron = "বার্গার",
            bnMeaning = "বার্গার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_138",
            category = VocabCategory.FOOD,
            singularTarget = "सलाद",
            singularBnPron = "সলাদ",
            pluralTarget = "सलाद",
            pluralBnPron = "সলাদ",
            bnMeaning = "স্যালাড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_139",
            category = VocabCategory.FOOD,
            singularTarget = "चटनी",
            singularBnPron = "চটনি",
            pluralTarget = "चटनियां",
            pluralBnPron = "চটনিয়াঁ",
            bnMeaning = "সস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_140",
            category = VocabCategory.FOOD,
            singularTarget = "सिरका",
            singularBnPron = "সিরকা",
            pluralTarget = "सिरके",
            pluralBnPron = "সিরকে",
            bnMeaning = "সিরকা / ভিনেগার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_141",
            category = VocabCategory.FOOD,
            singularTarget = "बादाम",
            singularBnPron = "বাদাম",
            pluralTarget = "बादाम",
            pluralBnPron = "বাদাম",
            bnMeaning = "বাদাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_142",
            category = VocabCategory.FOOD,
            singularTarget = "सैंडविच",
            singularBnPron = "স্যান্ডউইচ",
            pluralTarget = "सैंडविच",
            pluralBnPron = "স্যান্ডউইচ",
            bnMeaning = "স্যান্ডউইচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_143",
            category = VocabCategory.FOOD,
            singularTarget = "अचार",
            singularBnPron = "আচার",
            pluralTarget = "अचार",
            pluralBnPron = "আচার",
            bnMeaning = "আচার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_144",
            category = VocabCategory.FOOD,
            singularTarget = "नाश्ता",
            singularBnPron = "নাস্তা",
            pluralTarget = "नाश्ते",
            pluralBnPron = "নাস্তে",
            bnMeaning = "জলখাবার / নাস্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_145",
            category = VocabCategory.FOOD,
            singularTarget = "नाश्ता",
            singularBnPron = "নাস্তা",
            pluralTarget = "नाश्ते",
            pluralBnPron = "নাস্তে",
            bnMeaning = "সকালের নাস্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_146",
            category = VocabCategory.FOOD,
            singularTarget = "दोपहर का भोजन",
            singularBnPron = "দোপহর কা ভোজন",
            pluralTarget = "दोपहर का भोजन",
            pluralBnPron = "দোপহর কা ভোজন",
            bnMeaning = "দুপুরের খাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_147",
            category = VocabCategory.FOOD,
            singularTarget = "रात का खाना",
            singularBnPron = "রাত কা খানা",
            pluralTarget = "रात का खाना",
            pluralBnPron = "রাত কা খানা",
            bnMeaning = "রাতের খাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_148",
            category = VocabCategory.FOOD,
            singularTarget = "भोजन",
            singularBnPron = "ভোজন",
            pluralTarget = "भोजन",
            pluralBnPron = "ভোজন",
            bnMeaning = "ভোজ / খাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_149",
            category = VocabCategory.FOOD,
            singularTarget = "प्यास",
            singularBnPron = "পিয়াস",
            pluralTarget = "प्यास",
            pluralBnPron = "পিয়াস",
            bnMeaning = "পিপাসা / তৃষ্ণা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_150",
            category = VocabCategory.FOOD,
            singularTarget = "भूख",
            singularBnPron = "ভুখ",
            pluralTarget = "भूख",
            pluralBnPron = "ভুখ",
            bnMeaning = "ক্ষুধা / ক্ষুধা পাওয়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_151",
            category = VocabCategory.FRUITS,
            singularTarget = "आम",
            singularBnPron = "আম",
            pluralTarget = "आम",
            pluralBnPron = "আম",
            bnMeaning = "আম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_152",
            category = VocabCategory.FRUITS,
            singularTarget = "सेब",
            singularBnPron = "সেব",
            pluralTarget = "सेब",
            pluralBnPron = "সেব",
            bnMeaning = "আপেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_153",
            category = VocabCategory.FRUITS,
            singularTarget = "केला",
            singularBnPron = "কেলা",
            pluralTarget = "केले",
            pluralBnPron = "কেলে",
            bnMeaning = "কলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_154",
            category = VocabCategory.FRUITS,
            singularTarget = "संतरा",
            singularBnPron = "সন্তরা",
            pluralTarget = "संतरे",
            pluralBnPron = "সতরে",
            bnMeaning = "কমলালেবু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_155",
            category = VocabCategory.FRUITS,
            singularTarget = "अंगूर",
            singularBnPron = "অঙ্গুর",
            pluralTarget = "अंगूर",
            pluralBnPron = "অঙ্গুর",
            bnMeaning = "আঙুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_156",
            category = VocabCategory.FRUITS,
            singularTarget = "नींबू",
            singularBnPron = "নীম্বু",
            pluralTarget = "नींबू",
            pluralBnPron = "নীম্বু",
            bnMeaning = "লেবু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_157",
            category = VocabCategory.FRUITS,
            singularTarget = "तरबूज",
            singularBnPron = "তরবুজ",
            pluralTarget = "तरबूज",
            pluralBnPron = "তরবুজ",
            bnMeaning = "তরমুজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_158",
            category = VocabCategory.FRUITS,
            singularTarget = "पपीता",
            singularBnPron = "পপিতা",
            pluralTarget = "पपीते",
            pluralBnPron = "পপিতে",
            bnMeaning = "পেঁপে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_159",
            category = VocabCategory.FRUITS,
            singularTarget = "अनानास",
            singularBnPron = "আনারস",
            pluralTarget = "अनानास",
            pluralBnPron = "আনারস",
            bnMeaning = "আনারস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_160",
            category = VocabCategory.FRUITS,
            singularTarget = "अमरूद",
            singularBnPron = "আমরুদ",
            pluralTarget = "अमरूद",
            pluralBnPron = "আমরুদ",
            bnMeaning = "পেয়ারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_161",
            category = VocabCategory.FRUITS,
            singularTarget = "अनार",
            singularBnPron = "আনার",
            pluralTarget = "अनार",
            pluralBnPron = "আনার",
            bnMeaning = "ডালিম / বেদানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_162",
            category = VocabCategory.FRUITS,
            singularTarget = "नारियल",
            singularBnPron = "নারিয়াল",
            pluralTarget = "नारियल",
            pluralBnPron = "নারিয়াল",
            bnMeaning = "নারকেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_163",
            category = VocabCategory.FRUITS,
            singularTarget = "खजूर",
            singularBnPron = "খজুর",
            pluralTarget = "खजूर",
            pluralBnPron = "খজুর",
            bnMeaning = "খেজুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_164",
            category = VocabCategory.FRUITS,
            singularTarget = "स्ट्रॉबेरी",
            singularBnPron = "স্ট্রবেরি",
            pluralTarget = "स्ट्रॉबेरी",
            pluralBnPron = "স্ট্রবেরি",
            bnMeaning = "স্ট্রবেরি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_165",
            category = VocabCategory.FRUITS,
            singularTarget = "चेरी",
            singularBnPron = "চেরি",
            pluralTarget = "चेरी",
            pluralBnPron = "চেরি",
            bnMeaning = "চেরি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_166",
            category = VocabCategory.FRUITS,
            singularTarget = "आलू",
            singularBnPron = "আলু",
            pluralTarget = "आलू",
            pluralBnPron = "আলু",
            bnMeaning = "আলু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_167",
            category = VocabCategory.FRUITS,
            singularTarget = "टमाटर",
            singularBnPron = "টমাটর",
            pluralTarget = "टमाटर",
            pluralBnPron = "টমাটর",
            bnMeaning = "টমেটো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_168",
            category = VocabCategory.FRUITS,
            singularTarget = "गाजर",
            singularBnPron = "গাজর",
            pluralTarget = "गाजर",
            pluralBnPron = "গাজর",
            bnMeaning = "গাজর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_169",
            category = VocabCategory.FRUITS,
            singularTarget = "मूली",
            singularBnPron = "মূলী",
            pluralTarget = "मूलियां",
            pluralBnPron = "মূলিয়াঁ",
            bnMeaning = "মুলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_170",
            category = VocabCategory.FRUITS,
            singularTarget = "पत्ता गोभी",
            singularBnPron = "পত্তা গোভী",
            pluralTarget = "पत्ता गोभी",
            pluralBnPron = "পত্তা গোভী",
            bnMeaning = "বাঁধাকপি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_171",
            category = VocabCategory.FRUITS,
            singularTarget = "फूलगोभी",
            singularBnPron = "ফুলগোভী",
            pluralTarget = "फूलगोभी",
            pluralBnPron = "ফুলগোভী",
            bnMeaning = "ফুলকপি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_172",
            category = VocabCategory.FRUITS,
            singularTarget = "पालक",
            singularBnPron = "পালক",
            pluralTarget = "पालक",
            pluralBnPron = "পালক",
            bnMeaning = "পালংশাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_173",
            category = VocabCategory.FRUITS,
            singularTarget = "खीरा",
            singularBnPron = "খীড়া",
            pluralTarget = "खीरे",
            pluralBnPron = "খীড়ে",
            bnMeaning = "শসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_174",
            category = VocabCategory.FRUITS,
            singularTarget = "कद्दू",
            singularBnPron = "কদ্দু",
            pluralTarget = "कद्दू",
            pluralBnPron = "কদ্দু",
            bnMeaning = "মিষ্টিকুমড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_175",
            category = VocabCategory.FRUITS,
            singularTarget = "बैंगन",
            singularBnPron = "বেগন",
            pluralTarget = "बैंगन",
            pluralBnPron = "বেগন",
            bnMeaning = "বেগুন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_176",
            category = VocabCategory.FRUITS,
            singularTarget = "मटर",
            singularBnPron = "মটর",
            pluralTarget = "मटर",
            pluralBnPron = "মটর",
            bnMeaning = "মটরশুঁটি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_177",
            category = VocabCategory.FRUITS,
            singularTarget = "भिंडी",
            singularBnPron = "ভিন্ডি",
            pluralTarget = "भिंडी",
            pluralBnPron = "ভিন্ডি",
            bnMeaning = "ঢ্যাঁড়শ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_178",
            category = VocabCategory.FRUITS,
            singularTarget = "मशरूम",
            singularBnPron = "মাশরুম",
            pluralTarget = "मशरूम",
            pluralBnPron = "মাশরুম",
            bnMeaning = "মাশরুম / ব্যাঙের ছাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_179",
            category = VocabCategory.FRUITS,
            singularTarget = "मक्का",
            singularBnPron = "মাক্কা",
            pluralTarget = "मक्के",
            pluralBnPron = "মাক্কে",
            bnMeaning = "ভূট্টা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_180",
            category = VocabCategory.FRUITS,
            singularTarget = "पुदीना",
            singularBnPron = "পুদিনা",
            pluralTarget = "पुदीना",
            pluralBnPron = "পুদিনা",
            bnMeaning = "পুদিনা পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_181",
            category = VocabCategory.FRUITS,
            singularTarget = "धनिया",
            singularBnPron = "ধনিয়া",
            pluralTarget = "धनिया",
            pluralBnPron = "ধনিয়া",
            bnMeaning = "ধনিয়া পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_182",
            category = VocabCategory.FRUITS,
            singularTarget = "सलाद पत्ता",
            singularBnPron = "সলাদ পত্তা",
            pluralTarget = "सलाद पत्ते",
            pluralBnPron = "সলাদ পত্তে",
            bnMeaning = "লেটুস পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_183",
            category = VocabCategory.FRUITS,
            singularTarget = "चुकंदर",
            singularBnPron = "চুকন্দর",
            pluralTarget = "चुकंदर",
            pluralBnPron = "চুকন্দর",
            bnMeaning = "বিট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_184",
            category = VocabCategory.FRUITS,
            singularTarget = "शिमला मिर्च",
            singularBnPron = "শিমলা মির্চ",
            pluralTarget = "शिमला मिर्च",
            pluralBnPron = "শিমলা মির্চ",
            bnMeaning = "ক্যাপসিকাম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_185",
            category = VocabCategory.FRUITS,
            singularTarget = "लौकी",
            singularBnPron = "লৌকি",
            pluralTarget = "लौकियां",
            pluralBnPron = "লৌকিয়াঁ",
            bnMeaning = "লাউ / কদু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_186",
            category = VocabCategory.FRUITS,
            singularTarget = "करेला",
            singularBnPron = "করেলা",
            pluralTarget = "करेले",
            pluralBnPron = "করেলে",
            bnMeaning = "করলা / উচ্ছে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_187",
            category = VocabCategory.FRUITS,
            singularTarget = "कटहल",
            singularBnPron = "কটহল",
            pluralTarget = "कटहल",
            pluralBnPron = "কটহল",
            bnMeaning = "কাঁঠাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_188",
            category = VocabCategory.FRUITS,
            singularTarget = "लीची",
            singularBnPron = "লীচি",
            pluralTarget = "लीचियां",
            pluralBnPron = "লীচিয়াঁ",
            bnMeaning = "লিচু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_189",
            category = VocabCategory.FRUITS,
            singularTarget = "जैतून",
            singularBnPron = "জৈতুন",
            pluralTarget = "जैतून",
            pluralBnPron = "জৈতুন",
            bnMeaning = "জলপাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_190",
            category = VocabCategory.FRUITS,
            singularTarget = "अंजीर",
            singularBnPron = "অঞ্জীর",
            pluralTarget = "अंजीर",
            pluralBnPron = "অঞ্জীর",
            bnMeaning = "ডুমুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_191",
            category = VocabCategory.FRUITS,
            singularTarget = "नाशपाती",
            singularBnPron = "নাশপাতি",
            pluralTarget = "नाशपाती",
            pluralBnPron = "নাশপাতি",
            bnMeaning = "নাশপাতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_192",
            category = VocabCategory.FRUITS,
            singularTarget = "आड़ू",
            singularBnPron = "আড়ু",
            pluralTarget = "आड़ू",
            pluralBnPron = "আড়ু",
            bnMeaning = "পীচ ফল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_193",
            category = VocabCategory.FRUITS,
            singularTarget = "आलूबुखारा",
            singularBnPron = "আলুবুখারা",
            pluralTarget = "आलूबुखारे",
            pluralBnPron = "আলুবুখারে",
            bnMeaning = "আলুবোখারা / প্লাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_194",
            category = VocabCategory.FRUITS,
            singularTarget = "शलजम",
            singularBnPron = "শলজম",
            pluralTarget = "शलजम",
            pluralBnPron = "শলজম",
            bnMeaning = "শালগম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_195",
            category = VocabCategory.FRUITS,
            singularTarget = "शकरकंद",
            singularBnPron = "শকরকন্দ",
            pluralTarget = "शकरकंद",
            pluralBnPron = "শকরকন্দ",
            bnMeaning = "মিষ্টি আলু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_196",
            category = VocabCategory.FRUITS,
            singularTarget = "सोयाबीन",
            singularBnPron = "সোয়াবিন",
            pluralTarget = "सोयाबीन",
            pluralBnPron = "সোয়াবিন",
            bnMeaning = "সয়াবিন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_197",
            category = VocabCategory.FRUITS,
            singularTarget = "सब्जी",
            singularBnPron = "সবজি",
            pluralTarget = "सब्जियां",
            pluralBnPron = "সবজিয়াঁ",
            bnMeaning = "সবজি (সাধারণ)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_198",
            category = VocabCategory.FRUITS,
            singularTarget = "फल",
            singularBnPron = "ফল",
            pluralTarget = "फल",
            pluralBnPron = "ফল",
            bnMeaning = "ফল (সাধারণ)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_199",
            category = VocabCategory.FRUITS,
            singularTarget = "पौधा",
            singularBnPron = "পৌধা",
            pluralTarget = "पौधे",
            pluralBnPron = "পৌধে",
            bnMeaning = "গাছ / কাণ্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_200",
            category = VocabCategory.FRUITS,
            singularTarget = "बीज",
            singularBnPron = "বীজ",
            pluralTarget = "बीज",
            pluralBnPron = "বীজ",
            bnMeaning = "বীজ",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk3 = listOf(
        VocabItem(
            id = "hi_vocab_201",
            category = VocabCategory.HOME,
            singularTarget = "घर",
            singularBnPron = "ঘর",
            pluralTarget = "घर",
            pluralBnPron = "ঘর",
            bnMeaning = "বাড়ি / ঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_202",
            category = VocabCategory.HOME,
            singularTarget = "कमरा",
            singularBnPron = "কমরা",
            pluralTarget = "कमरे",
            pluralBnPron = "কমরে",
            bnMeaning = "কক্ষ / রুম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_203",
            category = VocabCategory.HOME,
            singularTarget = "दरवाजा",
            singularBnPron = "দরওয়াজা",
            pluralTarget = "दरवाजे",
            pluralBnPron = "দরওয়াজে",
            bnMeaning = "দরজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_204",
            category = VocabCategory.HOME,
            singularTarget = "खिड़की",
            singularBnPron = "খিড়কি",
            pluralTarget = "खिड़कियां",
            pluralBnPron = "খিড়কিয়াঁ",
            bnMeaning = "জানালা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_205",
            category = VocabCategory.HOME,
            singularTarget = "दीवार",
            singularBnPron = "দীওয়ার",
            pluralTarget = "दीवारें",
            pluralBnPron = "দীওয়ারেঁ",
            bnMeaning = "দেয়াল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_206",
            category = VocabCategory.HOME,
            singularTarget = "फर्श",
            singularBnPron = "ফর্শ",
            pluralTarget = "फर्श",
            pluralBnPron = "ফর্শ",
            bnMeaning = "মেঝে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_207",
            category = VocabCategory.HOME,
            singularTarget = "छत",
            singularBnPron = "ছত",
            pluralTarget = "छतें",
            pluralBnPron = "ছতেঁ",
            bnMeaning = "ছাদ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_208",
            category = VocabCategory.HOME,
            singularTarget = "भीतरी छत",
            singularBnPron = "ভিতরি ছত",
            pluralTarget = "भीतरी छतें",
            pluralBnPron = "ভিতরি ছতেঁ",
            bnMeaning = "সিলিং (ঘরের ভেতর ছাদ)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_209",
            category = VocabCategory.HOME,
            singularTarget = "शयनकक्ष",
            singularBnPron = "শয়নকক্ষ",
            pluralTarget = "शयनकक्ष",
            pluralBnPron = "শয়নকক্ষ",
            bnMeaning = "শোবার ঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_210",
            category = VocabCategory.HOME,
            singularTarget = "स्नानघर",
            singularBnPron = "স্নানঘর",
            pluralTarget = "स्नानघर",
            pluralBnPron = "স্নানঘর",
            bnMeaning = "গোসলখানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_211",
            category = VocabCategory.HOME,
            singularTarget = "रसोईघर",
            singularBnPron = "রসোইঘর",
            pluralTarget = "रसोईघर",
            pluralBnPron = "রসোইঘর",
            bnMeaning = "রান্নাঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_212",
            category = VocabCategory.HOME,
            singularTarget = "भोजन कक्ष",
            singularBnPron = "ভোজন কক্ষ",
            pluralTarget = "भोजन कक्ष",
            pluralBnPron = "ভোজন কক্ষ",
            bnMeaning = "খাবার ঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_213",
            category = VocabCategory.HOME,
            singularTarget = "बैठक",
            singularBnPron = "বৈঠক",
            pluralTarget = "बैठकें",
            pluralBnPron = "বৈঠকেঁ",
            bnMeaning = "বসার ঘর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_214",
            category = VocabCategory.HOME,
            singularTarget = "बालकनी",
            singularBnPron = "ব্যালকনি",
            pluralTarget = "बालकनियां",
            pluralBnPron = "ব্যালকনিয়াঁ",
            bnMeaning = "বারান্দা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_215",
            category = VocabCategory.HOME,
            singularTarget = "बगीचा",
            singularBnPron = "বগীচা",
            pluralTarget = "बगीचे",
            pluralBnPron = "বগীচে",
            bnMeaning = "বাগান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_216",
            category = VocabCategory.HOME,
            singularTarget = "फाटक",
            singularBnPron = "ফাটক",
            pluralTarget = "फाटक",
            pluralBnPron = "ফাটক",
            bnMeaning = "গেট / ফটক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_217",
            category = VocabCategory.HOME,
            singularTarget = "सीढ़ी",
            singularBnPron = "সীঢ়ি",
            pluralTarget = "सीढ़ियां",
            pluralBnPron = "সীঢ়িয়াঁ",
            bnMeaning = "সিঁড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_218",
            category = VocabCategory.HOME,
            singularTarget = "लिफ्ट",
            singularBnPron = "লিফট",
            pluralTarget = "लिफ्ट",
            pluralBnPron = "লিফট",
            bnMeaning = "লিফট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_219",
            category = VocabCategory.HOME,
            singularTarget = "बिस्तर",
            singularBnPron = "বিস্তর",
            pluralTarget = "बिस्तर",
            pluralBnPron = "বিস্তর",
            bnMeaning = "বিছানা / খাট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_220",
            category = VocabCategory.HOME,
            singularTarget = "तकिया",
            singularBnPron = "তকিয়া",
            pluralTarget = "तकिए",
            pluralBnPron = "তকিয়ে",
            bnMeaning = "বালিশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_221",
            category = VocabCategory.HOME,
            singularTarget = "कंबल",
            singularBnPron = "কম্বল",
            pluralTarget = "कंबल",
            pluralBnPron = "কম্বল",
            bnMeaning = "কম্বল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_222",
            category = VocabCategory.HOME,
            singularTarget = "गद्दा",
            singularBnPron = "গদ্দা",
            pluralTarget = "गद्दे",
            pluralBnPron = "গদ্দে",
            bnMeaning = "গদি / তোশক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_223",
            category = VocabCategory.HOME,
            singularTarget = "चादर",
            singularBnPron = "চাদর",
            pluralTarget = "चादरें",
            pluralBnPron = "চাদরেঁ",
            bnMeaning = "চাদর (বিছানার)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_224",
            category = VocabCategory.HOME,
            singularTarget = "मेज",
            singularBnPron = "মেজ",
            pluralTarget = "मेजें",
            pluralBnPron = "মেজেঁ",
            bnMeaning = "টেবিল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_225",
            category = VocabCategory.HOME,
            singularTarget = "कुर्सी",
            singularBnPron = "কুর্সি",
            pluralTarget = "कुर्सियां",
            pluralBnPron = "কুর্সিয়াঁ",
            bnMeaning = "চেয়ার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_226",
            category = VocabCategory.HOME,
            singularTarget = "सोफ़ा",
            singularBnPron = "সোফা",
            pluralTarget = "सोफ़े",
            pluralBnPron = "সোফে",
            bnMeaning = "সোফা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_227",
            category = VocabCategory.HOME,
            singularTarget = "डेस्क",
            singularBnPron = "ডেস্ক",
            pluralTarget = "डेस्क",
            pluralBnPron = "ডেস্ক",
            bnMeaning = "পড়ার টেবিল / ডেস্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_228",
            category = VocabCategory.HOME,
            singularTarget = "अलमारी",
            singularBnPron = "আলমারি",
            pluralTarget = "अलमारियां",
            pluralBnPron = "আলমারিয়াঁ",
            bnMeaning = "আলমারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_229",
            category = VocabCategory.HOME,
            singularTarget = "दराज",
            singularBnPron = "দরাজ",
            pluralTarget = "दराजें",
            pluralBnPron = "দরাজেঁ",
            bnMeaning = "ড্রয়ার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_230",
            category = VocabCategory.HOME,
            singularTarget = "अलमारी का ताक",
            singularBnPron = "তাক",
            pluralTarget = "ताक",
            pluralBnPron = "তাক",
            bnMeaning = "তাক / শেলফ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_231",
            category = VocabCategory.HOME,
            singularTarget = "आईना",
            singularBnPron = "আইনা",
            pluralTarget = "आईने",
            pluralBnPron = "আইনে",
            bnMeaning = "আয়না",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_232",
            category = VocabCategory.HOME,
            singularTarget = "दीपक / लैंप",
            singularBnPron = "ল্যাম্প",
            pluralTarget = "लैंप",
            pluralBnPron = "ল্যাম্প",
            bnMeaning = "বাতি / ল্যাম্প",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_233",
            category = VocabCategory.HOME,
            singularTarget = "प्रकाश",
            singularBnPron = "প্রকাশ",
            pluralTarget = "प्रकाश",
            pluralBnPron = "প্রকাশ",
            bnMeaning = "আলো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_234",
            category = VocabCategory.HOME,
            singularTarget = "पंखा",
            singularBnPron = "পংখা",
            pluralTarget = "पंखा",
            pluralBnPron = "পংখে",
            bnMeaning = "পাখা / ফ্যান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_235",
            category = VocabCategory.HOME,
            singularTarget = "घड़ी",
            singularBnPron = "ঘড়ি",
            pluralTarget = "घड़ियां",
            pluralBnPron = "ঘড়িয়াঁ",
            bnMeaning = "ঘড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_236",
            category = VocabCategory.HOME,
            singularTarget = "टेलीविज़न",
            singularBnPron = "টেলিভিজন",
            pluralTarget = "टेलीविज़न",
            pluralBnPron = "টেলিভিজন",
            bnMeaning = "টেলিভিশন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_237",
            category = VocabCategory.HOME,
            singularTarget = "पर्दा",
            singularBnPron = "পর্দা",
            pluralTarget = "पर्दे",
            pluralBnPron = "পর্দে",
            bnMeaning = "পর্দা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_238",
            category = VocabCategory.HOME,
            singularTarget = "कालीन",
            singularBnPron = "কালীন",
            pluralTarget = "कालीन",
            pluralBnPron = "কালীন",
            bnMeaning = "কার্পেট / গালিচা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_239",
            category = VocabCategory.HOME,
            singularTarget = "ताला",
            singularBnPron = "তালা",
            pluralTarget = "ताले",
            pluralBnPron = "তালে",
            bnMeaning = "তালা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_240",
            category = VocabCategory.HOME,
            singularTarget = "चाबी",
            singularBnPron = "চাবি",
            pluralTarget = "चाबियां",
            pluralBnPron = "চাবিয়াঁ",
            bnMeaning = "চাবি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_241",
            category = VocabCategory.HOME,
            singularTarget = "घंटी",
            singularBnPron = "ঘণ্টি",
            pluralTarget = "घंटियां",
            pluralBnPron = "ঘন্টিয়াঁ",
            bnMeaning = "ঘণ্টি / বেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_242",
            category = VocabCategory.HOME,
            singularTarget = "चित्र",
            singularBnPron = "চিত্র",
            pluralTarget = "चित्र",
            pluralBnPron = "চিত্র",
            bnMeaning = "ছবি / চিত্রকর্ম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_243",
            category = VocabCategory.HOME,
            singularTarget = "फूलदान",
            singularBnPron = "ফুলদান",
            pluralTarget = "फूलदान",
            pluralBnPron = "ফুলদান",
            bnMeaning = "ফুলদানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_244",
            category = VocabCategory.HOME,
            singularTarget = "झाड़ू",
            singularBnPron = "ঝাড়ু",
            pluralTarget = "झाड़ू",
            pluralBnPron = "ঝাড়ু",
            bnMeaning = "ঝাঁটা / ঝাড়ু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_245",
            category = VocabCategory.HOME,
            singularTarget = "कूड़ेदान",
            singularBnPron = "কুড়েদান",
            pluralTarget = "कूड़ेदान",
            pluralBnPron = "কুড়েদান",
            bnMeaning = "ময়লার ঝুড়ি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_246",
            category = VocabCategory.HOME,
            singularTarget = "नल",
            singularBnPron = "নল",
            pluralTarget = "नल",
            pluralBnPron = "নল",
            bnMeaning = "পানির কল / ট্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_247",
            category = VocabCategory.HOME,
            singularTarget = "पाइप",
            singularBnPron = "পাইপ",
            pluralTarget = "पाइप",
            pluralBnPron = "পাইপ",
            bnMeaning = "নল / পাইপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_248",
            category = VocabCategory.HOME,
            singularTarget = "बाड़",
            singularBnPron = "বাড়",
            pluralTarget = "बाड़",
            pluralBnPron = "বাড়",
            bnMeaning = "বেড়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_249",
            category = VocabCategory.HOME,
            singularTarget = "छाया",
            singularBnPron = "ছায়া",
            pluralTarget = "छाया",
            pluralBnPron = "ছায়া",
            bnMeaning = "ছায়া / শেড",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_250",
            category = VocabCategory.HOME,
            singularTarget = "दहलीज",
            singularBnPron = "দহলীজ",
            pluralTarget = "दहलीजें",
            pluralBnPron = "দহলীজেঁ",
            bnMeaning = "চৌকাঠ / সীমানা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_251",
            category = VocabCategory.CLOTHES,
            singularTarget = "कमीज़",
            singularBnPron = "কমিজ",
            pluralTarget = "कमीज़ें",
            pluralBnPron = "কমিজেঁ",
            bnMeaning = "শার্ট / জামা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_252",
            category = VocabCategory.CLOTHES,
            singularTarget = "टी-शर्ट",
            singularBnPron = "টি-শার্ট",
            pluralTarget = "टी-शर्ट",
            pluralBnPron = "টি-শার্ট",
            bnMeaning = "টি-শার্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_253",
            category = VocabCategory.CLOTHES,
            singularTarget = "पतलून",
            singularBnPron = "পতলুন",
            pluralTarget = "पतलूनें",
            pluralBnPron = "পতলুনেঁ",
            bnMeaning = "প্যান্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_254",
            category = VocabCategory.CLOTHES,
            singularTarget = "जींस",
            singularBnPron = "জিন্স",
            pluralTarget = "जींस",
            pluralBnPron = "জিন্স",
            bnMeaning = "জিন্স প্যান্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_255",
            category = VocabCategory.CLOTHES,
            singularTarget = "नेकर",
            singularBnPron = "নেকার",
            pluralTarget = "नेकर",
            pluralBnPron = "নেকার",
            bnMeaning = "হাফ প্যান্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_256",
            category = VocabCategory.CLOTHES,
            singularTarget = "पोशाक",
            singularBnPron = "পোশাক",
            pluralTarget = "पोशाकें",
            pluralBnPron = "পোশাকেঁ",
            bnMeaning = "পোশাক / জামা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_257",
            category = VocabCategory.CLOTHES,
            singularTarget = "स्कर्ट",
            singularBnPron = "স্কার্ট",
            pluralTarget = "स्कर्ट",
            pluralBnPron = "স্কার্ট",
            bnMeaning = "স্কার্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_258",
            category = VocabCategory.CLOTHES,
            singularTarget = "जैकेट",
            singularBnPron = "জ্যাকেট",
            pluralTarget = "जैकेट",
            pluralBnPron = "জ্যাকেট",
            bnMeaning = "জ্যাকেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_259",
            category = VocabCategory.CLOTHES,
            singularTarget = "कोट",
            singularBnPron = "কোট",
            pluralTarget = "कोट",
            pluralBnPron = "কোট",
            bnMeaning = "কোট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_260",
            category = VocabCategory.CLOTHES,
            singularTarget = "स्वेटर",
            singularBnPron = "সোয়েটার",
            pluralTarget = "स्वेटर",
            pluralBnPron = "সোয়েটার",
            bnMeaning = "সোয়েটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_261",
            category = VocabCategory.CLOTHES,
            singularTarget = "सूट",
            singularBnPron = "স্যুট",
            pluralTarget = "सूट",
            pluralBnPron = "স্যুট",
            bnMeaning = "স্যুট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_262",
            category = VocabCategory.CLOTHES,
            singularTarget = "टाई",
            singularBnPron = "টাই",
            pluralTarget = "टाई",
            pluralBnPron = "টাই",
            bnMeaning = "টাই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_263",
            category = VocabCategory.CLOTHES,
            singularTarget = "दुपट्टा / मफलर",
            singularBnPron = "দুপাট্টা",
            pluralTarget = "दुपट्टे",
            pluralBnPron = "দুপাট্টে",
            bnMeaning = "মাফলার / স্কার্ফ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_264",
            category = VocabCategory.CLOTHES,
            singularTarget = "दस्ताना",
            singularBnPron = "দস্তানা",
            pluralTarget = "दस्ताने",
            pluralBnPron = "দস্তানে",
            bnMeaning = "দস্তানা / গ্লাভস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_265",
            category = VocabCategory.CLOTHES,
            singularTarget = "मोज़ा",
            singularBnPron = "মোজা",
            pluralTarget = "मोज़े",
            pluralBnPron = "মোজে",
            bnMeaning = "মোজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_266",
            category = VocabCategory.CLOTHES,
            singularTarget = "जूता",
            singularBnPron = "জুতা",
            pluralTarget = "जूते",
            pluralBnPron = "জুতে",
            bnMeaning = "জুতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_267",
            category = VocabCategory.CLOTHES,
            singularTarget = "बूट",
            singularBnPron = "বুট",
            pluralTarget = "बूट",
            pluralBnPron = "বুট",
            bnMeaning = "বুট জুতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_268",
            category = VocabCategory.CLOTHES,
            singularTarget = "चप्पल",
            singularBnPron = "চপ্পল",
            pluralTarget = "चप्पलें",
            pluralBnPron = "চপ্পলেঁ",
            bnMeaning = "চটি / স্লিপার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_269",
            category = VocabCategory.CLOTHES,
            singularTarget = "सैंडल",
            singularBnPron = "স্যান্ডেল",
            pluralTarget = "सैंडल",
            pluralBnPron = "স্যান্ডেল",
            bnMeaning = "স্যান্ডেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_270",
            category = VocabCategory.CLOTHES,
            singularTarget = "टोपी",
            singularBnPron = "টোপি",
            pluralTarget = "टोपियां",
            pluralBnPron = "টোপিয়াঁ",
            bnMeaning = "টুপি (হ্যাট)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_271",
            category = VocabCategory.CLOTHES,
            singularTarget = "कैप",
            singularBnPron = "ক্যাপ",
            pluralTarget = "कैप",
            pluralBnPron = "ক্যাপ",
            bnMeaning = "ক্যাপ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_272",
            category = VocabCategory.CLOTHES,
            singularTarget = "पेटी / बेल्ट",
            singularBnPron = "বেল্ট",
            pluralTarget = "पेटियां",
            pluralBnPron = "বেল্ট",
            bnMeaning = "বেল্ট / কোমরবন্ধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_273",
            category = VocabCategory.CLOTHES,
            singularTarget = "अंगूठी",
            singularBnPron = "অঙ্গুঠী",
            pluralTarget = "अंगूठियां",
            pluralBnPron = "অঙ্গুঠিয়াঁ",
            bnMeaning = "আংটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_274",
            category = VocabCategory.CLOTHES,
            singularTarget = "हार",
            singularBnPron = "হার",
            pluralTarget = "हार",
            pluralBnPron = "হার",
            bnMeaning = "গলার হার / নেকলেস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_275",
            category = VocabCategory.CLOTHES,
            singularTarget = "कंगन",
            singularBnPron = "কঙ্গন",
            pluralTarget = "कंगन",
            pluralBnPron = "কঙ্গন",
            bnMeaning = "ব্রেসলেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_276",
            category = VocabCategory.CLOTHES,
            singularTarget = "कलाई घड़ी",
            singularBnPron = "ঘড়ি",
            pluralTarget = "कलाई घड़ियां",
            pluralBnPron = "ঘড়িয়াঁ",
            bnMeaning = "হাতঘড়ি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_277",
            category = VocabCategory.CLOTHES,
            singularTarget = "छाता",
            singularBnPron = "ছাতা",
            pluralTarget = "छाते",
            pluralBnPron = "ছাতে",
            bnMeaning = "ছাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_278",
            category = VocabCategory.CLOTHES,
            singularTarget = "चश्मा",
            singularBnPron = "চশমা",
            pluralTarget = "चश्मे",
            pluralBnPron = "চশমে",
            bnMeaning = "চশমা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_279",
            category = VocabCategory.CLOTHES,
            singularTarget = "धूप का चश्मा",
            singularBnPron = "চশমা",
            pluralTarget = "धूप के चश्मे",
            pluralBnPron = "চশমে",
            bnMeaning = "রোদচশমা / সানগ্লাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_280",
            category = VocabCategory.CLOTHES,
            singularTarget = "बटुआ",
            singularBnPron = "বটুয়া",
            pluralTarget = "बटुए",
            pluralBnPron = "বটুয়ে",
            bnMeaning = "মানিব্যাগ / ওয়ালেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_281",
            category = VocabCategory.CLOTHES,
            singularTarget = "पर्स",
            singularBnPron = "পার্স",
            pluralTarget = "पर्स",
            pluralBnPron = "পার্স",
            bnMeaning = "হাতব্যাগ / পার্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_282",
            category = VocabCategory.CLOTHES,
            singularTarget = "बस्ता / बैग",
            singularBnPron = "বস্তা",
            pluralTarget = "बस्ते",
            pluralBnPron = "বস্তে",
            bnMeaning = "পিঠের ব্যাগ / ব্যাকপ্যাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_283",
            category = VocabCategory.CLOTHES,
            singularTarget = "बटन",
            singularBnPron = "বাটন",
            pluralTarget = "बटन",
            pluralBnPron = "বাটন",
            bnMeaning = "বোতাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_284",
            category = VocabCategory.CLOTHES,
            singularTarget = "ज़िप",
            singularBnPron = "জিপ",
            pluralTarget = "ज़िप",
            pluralBnPron = "জিপ",
            bnMeaning = "চেইন / জিপার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_285",
            category = VocabCategory.CLOTHES,
            singularTarget = "जेब",
            singularBnPron = "জেব",
            pluralTarget = "जेबें",
            pluralBnPron = "জেবেঁ",
            bnMeaning = "পকেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_286",
            category = VocabCategory.CLOTHES,
            singularTarget = "कॉलर",
            singularBnPron = "কলার",
            pluralTarget = "कॉलर",
            pluralBnPron = "কলার",
            bnMeaning = "কলার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_287",
            category = VocabCategory.CLOTHES,
            singularTarget = "आस्तीन",
            singularBnPron = "আস্তিন",
            pluralTarget = "आस्तीनें",
            pluralBnPron = "আস্তিনেঁ",
            bnMeaning = "হাতা (জামা)",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_288",
            category = VocabCategory.CLOTHES,
            singularTarget = "वर्दी",
            singularBnPron = "ওয়ার্দি",
            pluralTarget = "वर्दियां",
            pluralBnPron = "ওয়ার্দিয়াঁ",
            bnMeaning = "ইউনিফর্ম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_289",
            category = VocabCategory.CLOTHES,
            singularTarget = "पायजामा",
            singularBnPron = "পায়জামা",
            pluralTarget = "पायजामे",
            pluralBnPron = "পায়জামে",
            bnMeaning = "পায়জামা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_290",
            category = VocabCategory.CLOTHES,
            singularTarget = "अंडरवियर",
            singularBnPron = "আন্ডারওয়্যার",
            pluralTarget = "अंडरवियर",
            pluralBnPron = "আন্ডারওয়্যার",
            bnMeaning = "অন্তর্বাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_291",
            category = VocabCategory.CLOTHES,
            singularTarget = "बरसाती",
            singularBnPron = "বরসাতি",
            pluralTarget = "बरसातियां",
            pluralBnPron = "বরসাতিয়াঁ",
            bnMeaning = "বৃষ্টির কোট / রেইনকোট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_292",
            category = VocabCategory.CLOTHES,
            singularTarget = "बंडी / वास्कट",
            singularBnPron = "বান্ডি",
            pluralTarget = "बंडियां",
            pluralBnPron = "বান্ডিয়াঁ",
            bnMeaning = "কটি / ভেস্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_293",
            category = VocabCategory.CLOTHES,
            singularTarget = "तैराकी की पोशाक",
            singularBnPron = "সুইমসুট",
            pluralTarget = "पोशाकें",
            pluralBnPron = "সুইমসুট",
            bnMeaning = "সাঁতারের পোশাক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_294",
            category = VocabCategory.CLOTHES,
            singularTarget = "शॉल",
            singularBnPron = "শাল",
            pluralTarget = "शॉल",
            pluralBnPron = "শাল",
            bnMeaning = "শাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_295",
            category = VocabCategory.CLOTHES,
            singularTarget = "दुपट्टा",
            singularBnPron = "দুপাট্টা",
            pluralTarget = "दुपट्टे",
            pluralBnPron = "দুপাট্টে",
            bnMeaning = "ওড়না",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_296",
            category = VocabCategory.CLOTHES,
            singularTarget = "धागा",
            singularBnPron = "ধাগা",
            pluralTarget = "धागे",
            pluralBnPron = "ধাগে",
            bnMeaning = "সুতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_297",
            category = VocabCategory.CLOTHES,
            singularTarget = "सुई",
            singularBnPron = "সুই",
            pluralTarget = "सुइयां",
            pluralBnPron = "সুইয়াঁ",
            bnMeaning = "সুই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_298",
            category = VocabCategory.CLOTHES,
            singularTarget = "कपड़ा",
            singularBnPron = "কাপড়া",
            pluralTarget = "कपड़े",
            pluralBnPron = "কাপড়ে",
            bnMeaning = "কাপড় / বস্ত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_299",
            category = VocabCategory.CLOTHES,
            singularTarget = "रेशम",
            singularBnPron = "রেশম",
            pluralTarget = "रेशम",
            pluralBnPron = "রেশম",
            bnMeaning = "রেশম / সিল্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_300",
            category = VocabCategory.CLOTHES,
            singularTarget = "कपास / सूती",
            singularBnPron = "কপাস",
            pluralTarget = "कपास",
            pluralBnPron = "কপাস",
            bnMeaning = "তুলা / সুতি",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk4 = listOf(
        VocabItem(
            id = "hi_vocab_301",
            category = VocabCategory.PLACES,
            singularTarget = "शहर",
            singularBnPron = "শহর",
            pluralTarget = "शहर",
            pluralBnPron = "শহর",
            bnMeaning = "শহর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_302",
            category = VocabCategory.PLACES,
            singularTarget = "गांव",
            singularBnPron = "গাঁব",
            pluralTarget = "गांव",
            pluralBnPron = "গাঁব",
            bnMeaning = "গ্রাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_303",
            category = VocabCategory.PLACES,
            singularTarget = "देश",
            singularBnPron = "দেশ",
            pluralTarget = "देश",
            pluralBnPron = "দেশ",
            bnMeaning = "দেশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_304",
            category = VocabCategory.PLACES,
            singularTarget = "कस्बा",
            singularBnPron = "কসবা",
            pluralTarget = "कस्बे",
            pluralBnPron = "কসবে",
            bnMeaning = "ছোট শহর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_305",
            category = VocabCategory.PLACES,
            singularTarget = "सड़क",
            singularBnPron = "সড়ক",
            pluralTarget = "सड़कें",
            pluralBnPron = "সড়কেঁ",
            bnMeaning = "রাস্তা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_306",
            category = VocabCategory.PLACES,
            singularTarget = "पुल",
            singularBnPron = "পুল",
            pluralTarget = "पुल",
            pluralBnPron = "পুল",
            bnMeaning = "সেতু / ব্রিজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_307",
            category = VocabCategory.PLACES,
            singularTarget = "नदी",
            singularBnPron = "নদী",
            pluralTarget = "नदियां",
            pluralBnPron = "নদীয়াঁ",
            bnMeaning = "নদী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_308",
            category = VocabCategory.PLACES,
            singularTarget = "पार्क",
            singularBnPron = "পার্ক",
            pluralTarget = "पार्क",
            pluralBnPron = "পার্ক",
            bnMeaning = "উদ্যান / পার্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_309",
            category = VocabCategory.PLACES,
            singularTarget = "बगीचा",
            singularBnPron = "বাগিচা",
            pluralTarget = "बगीचे",
            pluralBnPron = "বাগিচে",
            bnMeaning = "বাগান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_310",
            category = VocabCategory.PLACES,
            singularTarget = "बाज़ार",
            singularBnPron = "বাজার",
            pluralTarget = "बाज़ार",
            pluralBnPron = "বাজার",
            bnMeaning = "বাজার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_311",
            category = VocabCategory.PLACES,
            singularTarget = "दुकान",
            singularBnPron = "দোকান",
            pluralTarget = "दुकानें",
            pluralBnPron = "দোকানেঁ",
            bnMeaning = "দোকান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_312",
            category = VocabCategory.PLACES,
            singularTarget = "सुपरमार्केट",
            singularBnPron = "সুপারমার্কেট",
            pluralTarget = "सुपरमार्केट",
            pluralBnPron = "সুপারমার্কেট",
            bnMeaning = "সুপারমার্কেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_313",
            category = VocabCategory.PLACES,
            singularTarget = "बैंक",
            singularBnPron = "ব্যাংক",
            pluralTarget = "बैंक",
            pluralBnPron = "ব্যাংক",
            bnMeaning = "ব্যাংক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_314",
            category = VocabCategory.PLACES,
            singularTarget = "अस्पताल",
            singularBnPron = "হাসপাতাল",
            pluralTarget = "अस्पताल",
            pluralBnPron = "হাসপাতাল",
            bnMeaning = "হাসপাতাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_315",
            category = VocabCategory.PLACES,
            singularTarget = "दवाखाना",
            singularBnPron = "দাওয়াখানা",
            pluralTarget = "दवाखाने",
            pluralBnPron = "দাওয়াখানে",
            bnMeaning = "ঔষধের দোকান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_316",
            category = VocabCategory.PLACES,
            singularTarget = "विद्यालय / स्कूल",
            singularBnPron = "স্কুল",
            pluralTarget = "स्कूल",
            pluralBnPron = "স্কুল",
            bnMeaning = "বিদ্যালয় / স্কুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_317",
            category = VocabCategory.PLACES,
            singularTarget = "कॉलेज",
            singularBnPron = "কলেজ",
            pluralTarget = "कॉलेज",
            pluralBnPron = "কলেজ",
            bnMeaning = "কলেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_318",
            category = VocabCategory.PLACES,
            singularTarget = "विश्वविद्यालय",
            singularBnPron = "বিশ্ববিদ্যালয়",
            pluralTarget = "विश्वविद्यालय",
            pluralBnPron = "বিশ্ববিদ্যালয়",
            bnMeaning = "বিশ্ববিদ্যালয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_319",
            category = VocabCategory.PLACES,
            singularTarget = "पुस्तकालय",
            singularBnPron = "পুস্তকালয়",
            pluralTarget = "पुस्तकालय",
            pluralBnPron = "পুস্তকালয়",
            bnMeaning = "গ্রন্থাগার / লাইব্রেরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_320",
            category = VocabCategory.PLACES,
            singularTarget = "संग्रहालय",
            singularBnPron = "সংগ্রাহালয়",
            pluralTarget = "संग्रहालय",
            pluralBnPron = "সংগ্রাহালয়",
            bnMeaning = "জাদুঘর / মিউজিয়াম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_321",
            category = VocabCategory.PLACES,
            singularTarget = "होटल",
            singularBnPron = "হোটেল",
            pluralTarget = "होटल",
            pluralBnPron = "হোটেল",
            bnMeaning = "হোটেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_322",
            category = VocabCategory.PLACES,
            singularTarget = "रेस्तरां",
            singularBnPron = "রেস্তোরাঁ",
            pluralTarget = "रेस्तरां",
            pluralBnPron = "রেস্তোরাঁ",
            bnMeaning = "রেস্তোরাঁ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_323",
            category = VocabCategory.PLACES,
            singularTarget = "कैफ़े",
            singularBnPron = "ক্যাফে",
            pluralTarget = "कैफ़े",
            pluralBnPron = "ক্যাফে",
            bnMeaning = "ক্যাফে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_324",
            category = VocabCategory.PLACES,
            singularTarget = "हवाई अड्डा",
            singularBnPron = "হাওয়াই আড্ডা",
            pluralTarget = "हवाई अड्डे",
            pluralBnPron = "হাওয়াই আড্ডে",
            bnMeaning = "বিমানবন্দর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_325",
            category = VocabCategory.PLACES,
            singularTarget = "रेलवे स्टेशन",
            singularBnPron = "রেলওয়ে স্টেশন",
            pluralTarget = "रेलवे स्टेशन",
            pluralBnPron = "রেলওয়ে স্টেশন",
            bnMeaning = "রেলওয়ে স্টেশন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_326",
            category = VocabCategory.PLACES,
            singularTarget = "बस अड्डा",
            singularBnPron = "বাস আড্ডা",
            pluralTarget = "बस अड्डे",
            pluralBnPron = "বাস আড্ডে",
            bnMeaning = "বাস স্টপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_327",
            category = VocabCategory.PLACES,
            singularTarget = "बंदरगाह",
            singularBnPron = "বন্দরগাহ",
            pluralTarget = "बंदरगाह",
            pluralBnPron = "বন্দরগাহ",
            bnMeaning = "বন্দর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_328",
            category = VocabCategory.PLACES,
            singularTarget = "थाना",
            singularBnPron = "থানা",
            pluralTarget = "थाने",
            pluralBnPron = "থানে",
            bnMeaning = "পুলিশ স্টেশন / থানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_329",
            category = VocabCategory.PLACES,
            singularTarget = "डाकघर",
            singularBnPron = "ডাকঘর",
            pluralTarget = "डाकघर",
            pluralBnPron = "ডাকঘর",
            bnMeaning = "ডাকঘর / পোস্ট অফিস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_330",
            category = VocabCategory.PLACES,
            singularTarget = "सिनेमाघर",
            singularBnPron = "সিনেমাঘর",
            pluralTarget = "सिनेमाघर",
            pluralBnPron = "সিনেমাঘর",
            bnMeaning = "প্রেক্ষাগৃহ / সিনেমা হল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_331",
            category = VocabCategory.PLACES,
            singularTarget = "स्टेडियम",
            singularBnPron = "স্টেডিয়াম",
            pluralTarget = "स्टेडियम",
            pluralBnPron = "স্টেডিয়াম",
            bnMeaning = "স্টেডিয়াম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_332",
            category = VocabCategory.PLACES,
            singularTarget = "जिम",
            singularBnPron = "জিম",
            pluralTarget = "जिम",
            pluralBnPron = "জিম",
            bnMeaning = "ব্যায়ামাগার / জিম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_333",
            category = VocabCategory.PLACES,
            singularTarget = "मस्जिद",
            singularBnPron = "মসজিদ",
            pluralTarget = "मस्जिदें",
            pluralBnPron = "মসজিদেঁ",
            bnMeaning = "মসজিদ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_334",
            category = VocabCategory.PLACES,
            singularTarget = "मंदिर",
            singularBnPron = "মন্দির",
            pluralTarget = "मंदिर",
            pluralBnPron = "মন্দির",
            bnMeaning = "মন্দির",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_335",
            category = VocabCategory.PLACES,
            singularTarget = "गिरजाघर",
            singularBnPron = "গিরজাঘর",
            pluralTarget = "गिरजाघर",
            pluralBnPron = "গিরজাঘর",
            bnMeaning = "গির্জা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_336",
            category = VocabCategory.PLACES,
            singularTarget = "दूतावास",
            singularBnPron = "দূতাবাস",
            pluralTarget = "दूतावास",
            pluralBnPron = "দূতাবাস",
            bnMeaning = "দূতাবাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_337",
            category = VocabCategory.PLACES,
            singularTarget = "कार्यालय / दफ़्तर",
            singularBnPron = "দফতর",
            pluralTarget = "कार्यालय",
            pluralBnPron = "দফতর",
            bnMeaning = "কার্যালয় / অফিস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_338",
            category = VocabCategory.PLACES,
            singularTarget = "कारखाना",
            singularBnPron = "কারখানা",
            pluralTarget = "कारखाने",
            pluralBnPron = "কারখানে",
            bnMeaning = "কারখানা / ফ্যাক্টরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_339",
            category = VocabCategory.PLACES,
            singularTarget = "इमारत",
            singularBnPron = "ইমারত",
            pluralTarget = "इमारतें",
            pluralBnPron = "ইমারতেঁ",
            bnMeaning = "দালান / ভবন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_340",
            category = VocabCategory.PLACES,
            singularTarget = "मीनार",
            singularBnPron = "মিনার",
            pluralTarget = "मीनारें",
            pluralBnPron = "মিনারেঁ",
            bnMeaning = "মিনার / টাওয়ার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_341",
            category = VocabCategory.PLACES,
            singularTarget = "महल",
            singularBnPron = "মহল",
            pluralTarget = "महल",
            pluralBnPron = "মহল",
            bnMeaning = "প্রাসাদ / রাজপ্রাসাদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_342",
            category = VocabCategory.PLACES,
            singularTarget = "किला",
            singularBnPron = "কিলা",
            pluralTarget = "किले",
            pluralBnPron = "কিলে",
            bnMeaning = "দুর্গ / কেল্লা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_343",
            category = VocabCategory.PLACES,
            singularTarget = "चौक",
            singularBnPron = "চক",
            pluralTarget = "चौक",
            pluralBnPron = "চক",
            bnMeaning = "চত্বর / প্লাজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_344",
            category = VocabCategory.PLACES,
            singularTarget = "चिड़ियाघर",
            singularBnPron = "চিড়িয়াঘর",
            pluralTarget = "चिड़ियाघर",
            pluralBnPron = "চিড়িয়াঘর",
            bnMeaning = "চিড়িয়াখানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_345",
            category = VocabCategory.PLACES,
            singularTarget = "समुद्र तट",
            singularBnPron = "সমুদ্র তট",
            pluralTarget = "समुद्र तट",
            pluralBnPron = "সমুদ্র তট",
            bnMeaning = "সমুদ্র সৈকত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_346",
            category = VocabCategory.PLACES,
            singularTarget = "झील",
            singularBnPron = "ঝিল",
            pluralTarget = "झीलें",
            pluralBnPron = "ঝিলেঁ",
            bnMeaning = "হ্রদ / লেক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_347",
            category = VocabCategory.PLACES,
            singularTarget = "पहाड़",
            singularBnPron = "পাহাড়",
            pluralTarget = "पहाड़",
            pluralBnPron = "পাহাড়",
            bnMeaning = "পর্বত / পাহাড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_348",
            category = VocabCategory.PLACES,
            singularTarget = "द्वीप",
            singularBnPron = "দ্বীপ",
            pluralTarget = "द्वीप",
            pluralBnPron = "দ্বীপ",
            bnMeaning = "দ্বীপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_349",
            category = VocabCategory.PLACES,
            singularTarget = "जंगल",
            singularBnPron = "জঙ্গল",
            pluralTarget = "जंगल",
            pluralBnPron = "জঙ্গল",
            bnMeaning = "বন / জঙ্গল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_350",
            category = VocabCategory.PLACES,
            singularTarget = "रेगिस्तान",
            singularBnPron = "রেগিস্ তান",
            pluralTarget = "रेगिस्तान",
            pluralBnPron = "রেগিস্ তান",
            bnMeaning = "মরুভূমি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_351",
            category = VocabCategory.TRAVEL,
            singularTarget = "ट्रेन / रेलगाड़ी",
            singularBnPron = "ট্রেন",
            pluralTarget = "ट्रेनें",
            pluralBnPron = "ট্রেনেঁ",
            bnMeaning = "রেলগাড়ি / ট্রেন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_352",
            category = VocabCategory.TRAVEL,
            singularTarget = "बस",
            singularBnPron = "বাস",
            pluralTarget = "बसें",
            pluralBnPron = "বাসেঁ",
            bnMeaning = "বাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_353",
            category = VocabCategory.TRAVEL,
            singularTarget = "कार / गाड़ी",
            singularBnPron = "গাড়ি",
            pluralTarget = "गाड़ियां",
            pluralBnPron = "গাড়িয়াঁ",
            bnMeaning = "গাড়ি / কার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_354",
            category = VocabCategory.TRAVEL,
            singularTarget = "साइकिल",
            singularBnPron = "সাইকেল",
            pluralTarget = "साइकिलें",
            pluralBnPron = "সাইকেলেঁ",
            bnMeaning = "সাইকেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_355",
            category = VocabCategory.TRAVEL,
            singularTarget = "मोटरसाइकिल",
            singularBnPron = "মোটরসাইকেল",
            pluralTarget = "मोटरसाइकिलें",
            pluralBnPron = "মোটরসাইকেলেঁ",
            bnMeaning = "মোটরসাইকেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_356",
            category = VocabCategory.TRAVEL,
            singularTarget = "हवाई जहाज़",
            singularBnPron = "হাওয়াই জাহাজ",
            pluralTarget = "हवाई जहाज़",
            pluralBnPron = "হাওয়াই জাহাজ",
            bnMeaning = "উড়োজাহাজ / বিমান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_357",
            category = VocabCategory.TRAVEL,
            singularTarget = "नाव",
            singularBnPron = "নাও",
            pluralTarget = "नावें",
            pluralBnPron = "নাওয়েঁ",
            bnMeaning = "নৌকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_358",
            category = VocabCategory.TRAVEL,
            singularTarget = "जहाज़",
            singularBnPron = "জাহাজ",
            pluralTarget = "जहाज़",
            pluralBnPron = "জাহাজ",
            bnMeaning = "জাহাজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_359",
            category = VocabCategory.TRAVEL,
            singularTarget = "हेलिकॉप्टर",
            singularBnPron = "হেলিকপ্টার",
            pluralTarget = "हेलिकॉप्टर",
            pluralBnPron = "হেলিকপ্টার",
            bnMeaning = "হেলিকপ্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_360",
            category = VocabCategory.TRAVEL,
            singularTarget = "टैक्सी",
            singularBnPron = "ট্যাক্সি",
            pluralTarget = "टैक्सियां",
            pluralBnPron = "ট্যাক্সিয়াঁ",
            bnMeaning = "ট্যাক্সি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_361",
            category = VocabCategory.TRAVEL,
            singularTarget = "मेट्रो",
            singularBnPron = "মেট্রো",
            pluralTarget = "मेट्रो",
            pluralBnPron = "মেট্রো",
            bnMeaning = "মেট্রোরেল / পাতালরেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_362",
            category = VocabCategory.TRAVEL,
            singularTarget = "टिकट",
            singularBnPron = "টিকেট",
            pluralTarget = "टिकट",
            pluralBnPron = "টিকেট",
            bnMeaning = "টিকেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_363",
            category = VocabCategory.TRAVEL,
            singularTarget = "पासपोर्ट",
            singularBnPron = "পাসপোর্ট",
            pluralTarget = "पासपोर्ट",
            pluralBnPron = "পাসপোর্ট",
            bnMeaning = "পাসপোর্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_364",
            category = VocabCategory.TRAVEL,
            singularTarget = "वीज़ा",
            singularBnPron = "ভিসা",
            pluralTarget = "वीज़ा",
            pluralBnPron = "ভিসা",
            bnMeaning = "ভিসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_365",
            category = VocabCategory.TRAVEL,
            singularTarget = "सामान",
            singularBnPron = "সামান",
            pluralTarget = "सामान",
            pluralBnPron = "সামান",
            bnMeaning = "মালামাল / লাগেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_366",
            category = VocabCategory.TRAVEL,
            singularTarget = "सूटकेस",
            singularBnPron = "স্যুটকেস",
            pluralTarget = "सूटकेस",
            pluralBnPron = "স্যুটকেস",
            bnMeaning = "স্যুটকেস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_367",
            category = VocabCategory.TRAVEL,
            singularTarget = "नक्शा",
            singularBnPron = "নকশা",
            pluralTarget = "नक्शे",
            pluralBnPron = "নকশে",
            bnMeaning = "মানচিত্র / ম্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_368",
            category = VocabCategory.TRAVEL,
            singularTarget = "यात्रा",
            singularBnPron = "যাত্রা",
            pluralTarget = "यात्राएं",
            pluralBnPron = "যাত্রাএঁ",
            bnMeaning = "ভ্রমণ / যাত্রা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_369",
            category = VocabCategory.TRAVEL,
            singularTarget = "पर्यटक",
            singularBnPron = "পর্যটক",
            pluralTarget = "पर्यटक",
            pluralBnPron = "পর্যটক",
            bnMeaning = "ট্যুরিস্ট / পর্যটক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_370",
            category = VocabCategory.TRAVEL,
            singularTarget = "मार्गदर्शक",
            singularBnPron = "মার্গদর্শক",
            pluralTarget = "मार्गदर्शक",
            pluralBnPron = "মার্গদর্শক",
            bnMeaning = "গাইড / পথপ্রদর্শক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_371",
            category = VocabCategory.TRAVEL,
            singularTarget = "प्लेटफ़ॉर्म",
            singularBnPron = "প্ল্যাটফর্ম",
            pluralTarget = "प्लेटफ़ॉर्म",
            pluralBnPron = "প্ল্যাটফর্ম",
            bnMeaning = "প্ল্যাটফর্ম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_372",
            category = VocabCategory.TRAVEL,
            singularTarget = "उड़ान",
            singularBnPron = "উড়ান",
            pluralTarget = "उड़ानें",
            pluralBnPron = "উড়ানেঁ",
            bnMeaning = "বিমান ফ্লাইট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_373",
            category = VocabCategory.TRAVEL,
            singularTarget = "यात्री",
            singularBnPron = "যাত্রী",
            pluralTarget = "यात्री",
            pluralBnPron = "যাত্রী",
            bnMeaning = "যাত্রী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_374",
            category = VocabCategory.TRAVEL,
            singularTarget = "चालक",
            singularBnPron = "চালক",
            pluralTarget = "चालक",
            pluralBnPron = "চালক",
            bnMeaning = "চালক / ড্রাইভার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_375",
            category = VocabCategory.TRAVEL,
            singularTarget = "पायलट",
            singularBnPron = "পাইলট",
            pluralTarget = "पायलट",
            pluralBnPron = "পাইলট",
            bnMeaning = "বিমানচালক / পাইলট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_376",
            category = VocabCategory.TRAVEL,
            singularTarget = "राजमार्ग",
            singularBnPron = "রাজমার্গ",
            pluralTarget = "राजमार्ग",
            pluralBnPron = "রাজমার্গ",
            bnMeaning = "মহাসড়ক / হাইওয়ে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_377",
            category = VocabCategory.TRAVEL,
            singularTarget = "यातायात",
            singularBnPron = "যাতায়াত",
            pluralTarget = "यातायात",
            pluralBnPron = "যাতায়াত",
            bnMeaning = "ট্রাফিক / যানজট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_378",
            category = VocabCategory.TRAVEL,
            singularTarget = "ट्रैफिक लाइट",
            singularBnPron = "ট্রাফিক লাইট",
            pluralTarget = "ट्रैफिक लाइट",
            pluralBnPron = "ট্রাফিক লাইট",
            bnMeaning = "ট্রাফিক লাইট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_379",
            category = VocabCategory.TRAVEL,
            singularTarget = "ईंधन / पेट्रोल",
            singularBnPron = "পেট্রোল",
            pluralTarget = "ईंधन",
            pluralBnPron = "পেট্রোল",
            bnMeaning = "জ্বালানি / পেট্রল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_380",
            category = VocabCategory.TRAVEL,
            singularTarget = "पहिया",
            singularBnPron = "পাহিয়া",
            pluralTarget = "पहिए",
            pluralBnPron = "পাহিয়ে",
            bnMeaning = "চাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_381",
            category = VocabCategory.TRAVEL,
            singularTarget = "सीट",
            singularBnPron = "সিট",
            pluralTarget = "सीटें",
            pluralBnPron = "সিটেঁ",
            bnMeaning = "আসন / সিট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_382",
            category = VocabCategory.TRAVEL,
            singularTarget = "सीट बेल्ट",
            singularBnPron = "সিটবেল্ট",
            pluralTarget = "सीट बेल्ट",
            pluralBnPron = "সিটবেল্ট",
            bnMeaning = "সিটবেল্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_383",
            category = VocabCategory.TRAVEL,
            singularTarget = "दिशा",
            singularBnPron = "দিশা",
            pluralTarget = "दिशाएं",
            pluralBnPron = "দিশাএঁ",
            bnMeaning = "দিক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_384",
            category = VocabCategory.TRAVEL,
            singularTarget = "उत्तर",
            singularBnPron = "উত্তর",
            pluralTarget = "उत्तर",
            pluralBnPron = "উত্তর",
            bnMeaning = "উত্তর দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_385",
            category = VocabCategory.TRAVEL,
            singularTarget = "दक्षिण",
            singularBnPron = "দক্ষিণ",
            pluralTarget = "दक्षिण",
            pluralBnPron = "দক্ষিণ",
            bnMeaning = "দক্ষিণ দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_386",
            category = VocabCategory.TRAVEL,
            singularTarget = "पूर्व",
            singularBnPron = "পূর্ব",
            pluralTarget = "पूर्व",
            pluralBnPron = "পূর্ব",
            bnMeaning = "পূর্ব দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_387",
            category = VocabCategory.TRAVEL,
            singularTarget = "पश्चिम",
            singularBnPron = "পশ্চিম",
            pluralTarget = "पश्चिम",
            pluralBnPron = "পশ্চিম",
            bnMeaning = "পশ্চিম দিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_388",
            category = VocabCategory.TRAVEL,
            singularTarget = "बाएं",
            singularBnPron = "বায়েঁ",
            pluralTarget = "बाएं",
            pluralBnPron = "বায়েঁ",
            bnMeaning = "বামে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_389",
            category = VocabCategory.TRAVEL,
            singularTarget = "दाएं",
            singularBnPron = "দায়েঁ",
            pluralTarget = "दाएं",
            pluralBnPron = "দায়েঁ",
            bnMeaning = "ডানে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_390",
            category = VocabCategory.TRAVEL,
            singularTarget = "सीधा",
            singularBnPron = "সীধা",
            pluralTarget = "सीधा",
            pluralBnPron = "সীধা",
            bnMeaning = "সোজা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_391",
            category = VocabCategory.TRAVEL,
            singularTarget = "दूरी",
            singularBnPron = "দূরী",
            pluralTarget = "दूरियां",
            pluralBnPron = "দূরিয়াঁ",
            bnMeaning = "দূরত্ব",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_392",
            category = VocabCategory.TRAVEL,
            singularTarget = "किलोमीटर",
            singularBnPron = "কিলোমিটার",
            pluralTarget = "किलोमीटर",
            pluralBnPron = "কিলোমিটার",
            bnMeaning = "কিলোমিটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_393",
            category = VocabCategory.TRAVEL,
            singularTarget = "गति / रफ़्तार",
            singularBnPron = "গতি",
            pluralTarget = "गति",
            pluralBnPron = "গতি",
            bnMeaning = "গতি / স্পিড",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_394",
            category = VocabCategory.TRAVEL,
            singularTarget = "देरी",
            singularBnPron = "দেরী",
            pluralTarget = "देरी",
            pluralBnPron = "দেরী",
            bnMeaning = "দেরি / বিলম্ব",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_395",
            category = VocabCategory.TRAVEL,
            singularTarget = "आगमन",
            singularBnPron = "আগমন",
            pluralTarget = "आगमन",
            pluralBnPron = "আগমন",
            bnMeaning = "পৌঁছানো / আগমন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_396",
            category = VocabCategory.TRAVEL,
            singularTarget = "प्रस्थान",
            singularBnPron = "প্রস্থান",
            pluralTarget = "प्रस्थान",
            pluralBnPron = "প্রস্থান",
            bnMeaning = "প্রস্থান / রওয়ানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_397",
            category = VocabCategory.TRAVEL,
            singularTarget = "समय सारणी",
            singularBnPron = "সময় সারণী",
            pluralTarget = "सारणियां",
            pluralBnPron = "সময় সারণী",
            bnMeaning = "ভ্রমণসূচি / শিডিউল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_398",
            category = VocabCategory.TRAVEL,
            singularTarget = "सीमा",
            singularBnPron = "সীমা",
            pluralTarget = "सीमाएं",
            pluralBnPron = "সীমাএঁ",
            bnMeaning = "সীমান্ত / বর্ডার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_399",
            category = VocabCategory.TRAVEL,
            singularTarget = "किराया",
            singularBnPron = "কিরায়া",
            pluralTarget = "किराए",
            pluralBnPron = "কিরায়ে",
            bnMeaning = "ভাড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_400",
            category = VocabCategory.TRAVEL,
            singularTarget = "मंज़िल",
            singularBnPron = "মনজিল",
            pluralTarget = "मंज़िलें",
            pluralBnPron = "মনজিলেঁ",
            bnMeaning = "গন্তব্য",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk5 = listOf(
        VocabItem(
            id = "hi_vocab_401",
            category = VocabCategory.EDUCATION,
            singularTarget = "किताब",
            singularBnPron = "কিতাব",
            pluralTarget = "किताबें",
            pluralBnPron = "কিতাবেঁ",
            bnMeaning = "বই",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_402",
            category = VocabCategory.EDUCATION,
            singularTarget = "कॉपी / नोटबुक",
            singularBnPron = "কপি",
            pluralTarget = "कॉपियां",
            pluralBnPron = "কপিয়াঁ",
            bnMeaning = "খাতা / নোটবুক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_403",
            category = VocabCategory.EDUCATION,
            singularTarget = "कलम",
            singularBnPron = "কলম",
            pluralTarget = "कलमें",
            pluralBnPron = "কলমেঁ",
            bnMeaning = "কলম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_404",
            category = VocabCategory.EDUCATION,
            singularTarget = "पेंसिल",
            singularBnPron = "পেন্সিল",
            pluralTarget = "पेंसिलें",
            pluralBnPron = "পেনসিলেঁ",
            bnMeaning = "পেন্সিল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_405",
            category = VocabCategory.EDUCATION,
            singularTarget = "रबड़",
            singularBnPron = "রবার",
            pluralTarget = "रबड़",
            pluralBnPron = "রবার",
            bnMeaning = "ইরেজার / রাবার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_406",
            category = VocabCategory.EDUCATION,
            singularTarget = "शार्पनर",
            singularBnPron = "শার্পনার",
            pluralTarget = "शार्पनर",
            pluralBnPron = "শার্পনার",
            bnMeaning = "শার্পনার / কাটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_407",
            category = VocabCategory.EDUCATION,
            singularTarget = "फुटा / पैमाना",
            singularBnPron = "ফুটা",
            pluralTarget = "फुटे",
            pluralBnPron = "ফুটে",
            bnMeaning = "স্কেল / রুলার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_408",
            category = VocabCategory.EDUCATION,
            singularTarget = "बस्ता",
            singularBnPron = "বস্তা",
            pluralTarget = "बस्ते",
            pluralBnPron = "বস্তে",
            bnMeaning = "স্কুল ব্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_409",
            category = VocabCategory.EDUCATION,
            singularTarget = "श्यामपट्ट / बोर्ड",
            singularBnPron = "বোর্ড",
            pluralTarget = "बोर्ड",
            pluralBnPron = "বোর্ড",
            bnMeaning = "বোর্ড / ব্ল্যাকবোর্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_410",
            category = VocabCategory.EDUCATION,
            singularTarget = "चाक",
            singularBnPron = "চক",
            pluralTarget = "चाक",
            pluralBnPron = "চক",
            bnMeaning = "চক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_411",
            category = VocabCategory.EDUCATION,
            singularTarget = "मार्कर",
            singularBnPron = "মার্কার",
            pluralTarget = "मार्कर",
            pluralBnPron = "মার্কার",
            bnMeaning = "মার্কার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_412",
            category = VocabCategory.EDUCATION,
            singularTarget = "काग़ज़",
            singularBnPron = "কাগজ",
            pluralTarget = "काग़ज़ात",
            pluralBnPron = "কাগজাত",
            bnMeaning = "কাগজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_413",
            category = VocabCategory.EDUCATION,
            singularTarget = "पृष्ठ / पन्ना",
            singularBnPron = "পান্না",
            pluralTarget = "पन्ने",
            pluralBnPron = "পান্নে",
            bnMeaning = "পৃষ্ঠা / পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_414",
            category = VocabCategory.EDUCATION,
            singularTarget = "प्रश्न / सवाल",
            singularBnPron = "সোয়াল",
            pluralTarget = "सवाल",
            pluralBnPron = "সোয়াল",
            bnMeaning = "প্রশ্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_415",
            category = VocabCategory.EDUCATION,
            singularTarget = "उत्तर / जवाब",
            singularBnPron = "জবাব",
            pluralTarget = "जवाब",
            pluralBnPron = "জবাব",
            bnMeaning = "উত্তর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_416",
            category = VocabCategory.EDUCATION,
            singularTarget = "परीक्षा / इम्तिहान",
            singularBnPron = "পরীক্ষা",
            pluralTarget = "परीक्षाएं",
            pluralBnPron = "পরীক্ষাএঁ",
            bnMeaning = "পরীক্ষা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_417",
            category = VocabCategory.EDUCATION,
            singularTarget = "परिणाम / नतीजा",
            singularBnPron = "নতিজা",
            pluralTarget = "नतीजे",
            pluralBnPron = "নতিজে",
            bnMeaning = "ফলাফল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_418",
            category = VocabCategory.EDUCATION,
            singularTarget = "अंक / ग्रेड",
            singularBnPron = "অংক",
            pluralTarget = "अंक",
            pluralBnPron = "অংক",
            bnMeaning = "নম্বর / গ্রেড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_419",
            category = VocabCategory.EDUCATION,
            singularTarget = "गृहकार्य",
            singularBnPron = "গৃহকার্য",
            pluralTarget = "गृहकार्य",
            pluralBnPron = "গৃহকার্য",
            bnMeaning = "বাড়ির কাজ / হোমওয়ার্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_420",
            category = VocabCategory.EDUCATION,
            singularTarget = "पाठ",
            singularBnPron = "পাঠ",
            pluralTarget = "पाठ",
            pluralBnPron = "পাঠ",
            bnMeaning = "পাঠ / অধ্যায়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_421",
            category = VocabCategory.EDUCATION,
            singularTarget = "विषय",
            singularBnPron = "বিষয়",
            pluralTarget = "विषय",
            pluralBnPron = "বিষয়",
            bnMeaning = "বিষয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_422",
            category = VocabCategory.EDUCATION,
            singularTarget = "गणित",
            singularBnPron = "গণিত",
            pluralTarget = "गणित",
            pluralBnPron = "গণিত",
            bnMeaning = "গণিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_423",
            category = VocabCategory.EDUCATION,
            singularTarget = "विज्ञान",
            singularBnPron = "বিজ্ঞান",
            pluralTarget = "विज्ञान",
            pluralBnPron = "বিজ্ঞান",
            bnMeaning = "বিজ্ঞান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_424",
            category = VocabCategory.EDUCATION,
            singularTarget = "इतिहास",
            singularBnPron = "ইতিহাস",
            pluralTarget = "इतिहास",
            pluralBnPron = "ইতিহাস",
            bnMeaning = "ইতিহাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_425",
            category = VocabCategory.EDUCATION,
            singularTarget = "भूगोल",
            singularBnPron = "ভূগোল",
            pluralTarget = "भूगोल",
            pluralBnPron = "ভূগোল",
            bnMeaning = "ভূগোল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_426",
            category = VocabCategory.EDUCATION,
            singularTarget = "भाषा",
            singularBnPron = "ভাষা",
            pluralTarget = "भाषाएं",
            pluralBnPron = "ভাষাএঁ",
            bnMeaning = "ভাষা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_427",
            category = VocabCategory.EDUCATION,
            singularTarget = "साहित्य",
            singularBnPron = "সাহিত্য",
            pluralTarget = "साहित्य",
            pluralBnPron = "সাহিত্য",
            bnMeaning = "সাহিত্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_428",
            category = VocabCategory.EDUCATION,
            singularTarget = "कला",
            singularBnPron = "কলা",
            pluralTarget = "कलाएं",
            pluralBnPron = "কলাএঁ",
            bnMeaning = "শিল্পকলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_429",
            category = VocabCategory.EDUCATION,
            singularTarget = "संगीत",
            singularBnPron = "সঙ্গীত",
            pluralTarget = "संगीत",
            pluralBnPron = "সঙ্গীত",
            bnMeaning = "সঙ্গীত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_430",
            category = VocabCategory.EDUCATION,
            singularTarget = "कक्षा",
            singularBnPron = "কক্ষ্যা",
            pluralTarget = "कक्षाएं",
            pluralBnPron = "কক্ষ্যাএঁ",
            bnMeaning = "শ্রেণিকক্ষ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_431",
            category = VocabCategory.EDUCATION,
            singularTarget = "कक्षा / वर्ग",
            singularBnPron = "ক্লাস",
            pluralTarget = "कक्षाएं",
            pluralBnPron = "ক্লাসেস",
            bnMeaning = "শ্রেণি / ক্লাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_432",
            category = VocabCategory.EDUCATION,
            singularTarget = "प्रोफ़ेसर",
            singularBnPron = "প্রফেসর",
            pluralTarget = "प्रोफ़ेसर",
            pluralBnPron = "প্রফেসর",
            bnMeaning = "অধ্যাপক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_433",
            category = VocabCategory.EDUCATION,
            singularTarget = "प्राचार्य",
            singularBnPron = "প্রাশ্চর্য",
            pluralTarget = "प्राचार्य",
            pluralBnPron = "প্রাশ্চর্য",
            bnMeaning = "প্রধান শিক্ষক / অধ্যক্ষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_434",
            category = VocabCategory.EDUCATION,
            singularTarget = "उपाधि / डिग्री",
            singularBnPron = "ডিগ্রি",
            pluralTarget = "उपाधियां",
            pluralBnPron = "ডিগ্রিয়াঁ",
            bnMeaning = "ডিগ্রি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_435",
            category = VocabCategory.EDUCATION,
            singularTarget = "प्रमाणपत्र",
            singularBnPron = "প্রমাণপত্র",
            pluralTarget = "प्रमाणपत्र",
            pluralBnPron = "প্রমাণপত্র",
            bnMeaning = "সনদপত্র / ডিপ্লোমা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_436",
            category = VocabCategory.EDUCATION,
            singularTarget = "ज्ञान",
            singularBnPron = "জ্ঞান",
            pluralTarget = "ज्ञान",
            pluralBnPron = "জ্ঞান",
            bnMeaning = "জ্ঞান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_437",
            category = VocabCategory.EDUCATION,
            singularTarget = "अध्ययन / पढ़ाई",
            singularBnPron = "পড়াশোনা",
            pluralTarget = "पढ़ाई",
            pluralBnPron = "পড়াশোনা",
            bnMeaning = "পড়াশোনা / অধ্যয়ন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_438",
            category = VocabCategory.EDUCATION,
            singularTarget = "व्याख्यान",
            singularBnPron = "বক্তৃতা",
            pluralTarget = "व्याख्यान",
            pluralBnPron = "বক্তৃতা",
            bnMeaning = "বক্তৃতা / লেকচার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_439",
            category = VocabCategory.EDUCATION,
            singularTarget = "समस्या",
            singularBnPron = "সমস্যা",
            pluralTarget = "समस्याएं",
            pluralBnPron = "সমস্যাএঁ",
            bnMeaning = "সমস্যা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_440",
            category = VocabCategory.EDUCATION,
            singularTarget = "समाधान / हल",
            singularBnPron = "সমাধান",
            pluralTarget = "हल",
            pluralBnPron = "সমাধান",
            bnMeaning = "সমাধান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_441",
            category = VocabCategory.EDUCATION,
            singularTarget = "शब्दकोश",
            singularBnPron = "শব্দকোষ",
            pluralTarget = "शब्दकोश",
            pluralBnPron = "শব্দকোষ",
            bnMeaning = "অভিধান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_442",
            category = VocabCategory.EDUCATION,
            singularTarget = "छुट्टी",
            singularBnPron = "ছুট্টি",
            pluralTarget = "छुट्टियां",
            pluralBnPron = "ছুট্টিয়াঁ",
            bnMeaning = "ছুটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_443",
            category = VocabCategory.EDUCATION,
            singularTarget = "शब्द",
            singularBnPron = "শব্দ",
            pluralTarget = "शब्द",
            pluralBnPron = "শব্দ",
            bnMeaning = "শব্দ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_444",
            category = VocabCategory.EDUCATION,
            singularTarget = "वाक्य",
            singularBnPron = "বাক্য",
            pluralTarget = "वाक्य",
            pluralBnPron = "বাক্য",
            bnMeaning = "বাক্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_445",
            category = VocabCategory.EDUCATION,
            singularTarget = "अर्थ / मतलब",
            singularBnPron = "অর্থ",
            pluralTarget = "अर्थ",
            pluralBnPron = "অর্থ",
            bnMeaning = "অর্থ / মানে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_446",
            category = VocabCategory.EDUCATION,
            singularTarget = "वर्णमाला",
            singularBnPron = "বর্ণমালা",
            pluralTarget = "वर्णमाला",
            pluralBnPron = "বর্ণমালা",
            bnMeaning = "বর্ণমালা / অক্ষর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_447",
            category = VocabCategory.EDUCATION,
            singularTarget = "व्याकरण",
            singularBnPron = "ব্যাকরণ",
            pluralTarget = "व्याकरण",
            pluralBnPron = "ব্যাকরণ",
            bnMeaning = "ব্যাকরণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_448",
            category = VocabCategory.EDUCATION,
            singularTarget = "उच्चारण",
            singularBnPron = "উচ্চারণ",
            pluralTarget = "उच्चारण",
            pluralBnPron = "উচ্চারণ",
            bnMeaning = "উচ্চারণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_449",
            category = VocabCategory.EDUCATION,
            singularTarget = "अभ्यास",
            singularBnPron = "অভ্যাস",
            pluralTarget = "अभ्यास",
            pluralBnPron = "অভ্যাস",
            bnMeaning = "অনুশীলন / চর্চা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_450",
            category = VocabCategory.EDUCATION,
            singularTarget = "गलती",
            singularBnPron = "গলতি",
            pluralTarget = "गलतियां",
            pluralBnPron = "গলতিয়াঁ",
            bnMeaning = "ভুল / ত্রুটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_451",
            category = VocabCategory.WORK,
            singularTarget = "नौकरी",
            singularBnPron = "নকরি",
            pluralTarget = "नौकरियां",
            pluralBnPron = "নকরিয়াঁ",
            bnMeaning = "চাকরি / পেশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_452",
            category = VocabCategory.WORK,
            singularTarget = "कार्यस्थल",
            singularBnPron = "কার্যস্থল",
            pluralTarget = "कार्यस्थल",
            pluralBnPron = "কার্যস্থল",
            bnMeaning = "কাজের জায়গা / কর্মস্থল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_453",
            category = VocabCategory.WORK,
            singularTarget = "मालिक / बॉस",
            singularBnPron = "বস",
            pluralTarget = "बॉस",
            pluralBnPron = "বস",
            bnMeaning = "মালিক / বস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_454",
            category = VocabCategory.WORK,
            singularTarget = "कर्मचारी",
            singularBnPron = "কর্মচারী",
            pluralTarget = "कर्मचारी",
            pluralBnPron = "কর্মচারী",
            bnMeaning = "কর্মচারী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_455",
            category = VocabCategory.WORK,
            singularTarget = "मज़दूर",
            singularBnPron = "মজদুর",
            pluralTarget = "मज़दूर",
            pluralBnPron = "মজদুর",
            bnMeaning = "শ্রমিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_456",
            category = VocabCategory.WORK,
            singularTarget = "वेतन / तनख्वाह",
            singularBnPron = "তনখা",
            pluralTarget = "वेतन",
            pluralBnPron = "তনখা",
            bnMeaning = "বেতন / পারিশ্রমিক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_457",
            category = VocabCategory.WORK,
            singularTarget = "साक्षात्कार",
            singularBnPron = "সাক্ষাৎকার",
            pluralTarget = "साक्षात्कार",
            pluralBnPron = "সাক্ষাৎকার",
            bnMeaning = "মৌখিক পরীক্ষা / সাক্ষাৎকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_458",
            category = VocabCategory.WORK,
            singularTarget = "बैठक / मीटिंग",
            singularBnPron = "বৈঠক",
            pluralTarget = "बैठकें",
            pluralBnPron = "বৈঠকেঁ",
            bnMeaning = "বৈঠক / সভা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_459",
            category = VocabCategory.WORK,
            singularTarget = "अनुबंध / अनुबंध",
            singularBnPron = "চুক্তি",
            pluralTarget = "अनुबंध",
            pluralBnPron = "চুক্তি",
            bnMeaning = "চুক্তিপত্র / চুক্তি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_460",
            category = VocabCategory.WORK,
            singularTarget = "परियोजना",
            singularBnPron = "পরियोजना",
            pluralTarget = "परियोजनाएं",
            pluralBnPron = "পরियोजनाএঁ",
            bnMeaning = "প্রকল্প / প্রজেক্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_461",
            category = VocabCategory.WORK,
            singularTarget = "रिपोर्ट",
            singularBnPron = "রিপোর্ট",
            pluralTarget = "रिपोर्टें",
            pluralBnPron = "রিপোর্টেঁ",
            bnMeaning = "প্রতিবেদন / রিপোর্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_462",
            category = VocabCategory.WORK,
            singularTarget = "व्यापार / धंधा",
            singularBnPron = "ব্যাপার",
            pluralTarget = "व्यापार",
            pluralBnPron = "ব্যাপার",
            bnMeaning = "ব্যবসা / বাণিজ্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_463",
            category = VocabCategory.WORK,
            singularTarget = "कंपनी",
            singularBnPron = "কোম্পানি",
            pluralTarget = "कंपनियां",
            pluralBnPron = "কোম্পানিয়াঁ",
            bnMeaning = "কোম্পানি / প্রতিষ্ঠান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_464",
            category = VocabCategory.WORK,
            singularTarget = "ग्राहक",
            singularBnPron = "গ্রাহক",
            pluralTarget = "ग्राहक",
            pluralBnPron = "গ্রাহক",
            bnMeaning = "গ্রাহক / খরিদ্দার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_465",
            category = VocabCategory.WORK,
            singularTarget = "सेवा",
            singularBnPron = "সেবা",
            pluralTarget = "सेवाएं",
            pluralBnPron = "সেবাএঁ",
            bnMeaning = "সেবা / সার্ভিস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_466",
            category = VocabCategory.WORK,
            singularTarget = "कार्य / काम",
            singularBnPron = "কাম",
            pluralTarget = "काम",
            pluralBnPron = "কাম",
            bnMeaning = "কাজ / কার্যভার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_467",
            category = VocabCategory.WORK,
            singularTarget = "कर्तव्य / फ़र्ज़",
            singularBnPron = "কর্তব্য",
            pluralTarget = "कर्तव्य",
            pluralBnPron = "কর্তব্য",
            bnMeaning = "দায়িত্ব / কর্তব্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_468",
            category = VocabCategory.WORK,
            singularTarget = "पारी / शिफ्ट",
            singularBnPron = "শিফট",
            pluralTarget = "पारियां",
            pluralBnPron = "শিফট",
            bnMeaning = "পালা / শিফট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_469",
            category = VocabCategory.WORK,
            singularTarget = "बोनस",
            singularBnPron = "বোনাস",
            pluralTarget = "बोनस",
            pluralBnPron = "বোনাস",
            bnMeaning = "বোনাস / অতিরিক্ত ভাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_470",
            category = VocabCategory.WORK,
            singularTarget = "पदोन्नति / तरक्की",
            singularBnPron = "তরক্কী",
            pluralTarget = "तरक्की",
            pluralBnPron = "তরক্কী",
            bnMeaning = "পদোন্নতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_471",
            category = VocabCategory.WORK,
            singularTarget = "करियर",
            singularBnPron = "ক্যারিয়ার",
            pluralTarget = "करियर",
            pluralBnPron = "ক্যারিয়ার",
            bnMeaning = "পেশাজীবন / ক্যারিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_472",
            category = VocabCategory.WORK,
            singularTarget = "इस्तीफ़ा",
            singularBnPron = "ইস্তফা",
            pluralTarget = "इस्तीफ़े",
            pluralBnPron = "ইস্তফে",
            bnMeaning = "পদত্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_473",
            category = VocabCategory.WORK,
            singularTarget = "सेवानिवृत्ति",
            singularBnPron = "অবসর",
            pluralTarget = "सेवानिवृत्ति",
            pluralBnPron = "অবসর",
            bnMeaning = "অবসর গ্রহণ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_474",
            category = VocabCategory.WORK,
            singularTarget = "हड़ताल",
            singularBnPron = "হরতাল",
            pluralTarget = "हड़तालें",
            pluralBnPron = "হরতালেঁ",
            bnMeaning = "ধর্মঘট / স্ট্রাইক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_475",
            category = VocabCategory.WORK,
            singularTarget = "सफलता / कामयाबी",
            singularBnPron = "কামিয়াবি",
            pluralTarget = "सफलताएं",
            pluralBnPron = "কামিয়াবি",
            bnMeaning = "সাফল্য",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_476",
            category = VocabCategory.WORK,
            singularTarget = "चिकित्सक / डॉक्टर",
            singularBnPron = "ডাক্তার",
            pluralTarget = "डॉक्टर",
            pluralBnPron = "ডাক্তার",
            bnMeaning = "চিকিৎসক / ডাক্তার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_477",
            category = VocabCategory.WORK,
            singularTarget = "नर्स",
            singularBnPron = "নার্স",
            pluralTarget = "नर्सें",
            pluralBnPron = "নার্সেঁ",
            bnMeaning = "সেবিকা / নার্স",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_478",
            category = VocabCategory.WORK,
            singularTarget = "अभियंता / इंजीनियर",
            singularBnPron = "ইঞ্জিনিয়ার",
            pluralTarget = "इंजीनियर",
            pluralBnPron = "ইঞ্জিনিয়ার",
            bnMeaning = "প্রকৌশলী / ইঞ্জিনিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_479",
            category = VocabCategory.WORK,
            singularTarget = "वकील",
            singularBnPron = "উকিল",
            pluralTarget = "वकील",
            pluralBnPron = "উকিল",
            bnMeaning = "আইনজীবী / উকিল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_480",
            category = VocabCategory.WORK,
            singularTarget = "पुलिस अधिकारी",
            singularBnPron = "পুলিশ অফিসার",
            pluralTarget = "अधिकारी",
            pluralBnPron = "পুলিশ অফিসার",
            bnMeaning = "পুলিশ কর্মকর্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_481",
            category = VocabCategory.WORK,
            singularTarget = "दमकलकर्मी",
            singularBnPron = "দমকলকর্মী",
            pluralTarget = "दमकलकर्मी",
            pluralBnPron = "দমকলকর্মী",
            bnMeaning = "দমকলকর্মী / ফায়ারফাইটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_482",
            category = VocabCategory.WORK,
            singularTarget = "किसान",
            singularBnPron = "কিসান",
            pluralTarget = "किसान",
            pluralBnPron = "কিসান",
            bnMeaning = "কৃষক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_483",
            category = VocabCategory.WORK,
            singularTarget = "बढ़ई",
            singularBnPron = "বারহাই",
            pluralTarget = "बढ़ई",
            pluralBnPron = "বারহাই",
            bnMeaning = "কাঠমিস্ত্রি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_484",
            category = VocabCategory.WORK,
            singularTarget = "बिजली मिस्त्री",
            singularBnPron = "মিস্ত্রি",
            pluralTarget = "मिस्त्री",
            pluralBnPron = "মিস্ত্রি",
            bnMeaning = "বিদ্যুৎমিস্ত্রি / ইলেক্ট্রিশিয়ান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_485",
            category = VocabCategory.WORK,
            singularTarget = "नलकार / प्लम्बर",
            singularBnPron = "প্লাম্বার",
            pluralTarget = "प्लम्बर",
            pluralBnPron = "প্লাম্বার",
            bnMeaning = "প্লাম্বার / নলমিস্ত্রি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_486",
            category = VocabCategory.WORK,
            singularTarget = "दर्ज़ी",
            singularBnPron = "দর্জি",
            pluralTarget = "दर्ज़ी",
            pluralBnPron = "দর্জি",
            bnMeaning = "দর্জি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_487",
            category = VocabCategory.WORK,
            singularTarget = "नाई",
            singularBnPron = "নাপিত",
            pluralTarget = "नाई",
            pluralBnPron = "নাপিত",
            bnMeaning = "নাপিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_488",
            category = VocabCategory.WORK,
            singularTarget = "रसोइया / शेफ़",
            singularBnPron = "রসুইয়া",
            pluralTarget = "रसोइये",
            pluralBnPron = "রসুইয়ে",
            bnMeaning = "বাবুর্চি / শেফ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_489",
            category = VocabCategory.WORK,
            singularTarget = "वेटर",
            singularBnPron = "ওয়েটার",
            pluralTarget = "वेटर",
            pluralBnPron = "ওয়েটার",
            bnMeaning = "ওয়েটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_490",
            category = VocabCategory.WORK,
            singularTarget = "वेट्रेस",
            singularBnPron = "ওয়েট্রেস",
            pluralTarget = "वेट्रेस",
            pluralBnPron = "ওয়েট্রেস",
            bnMeaning = "ওয়েট্রেস / পরিচারিকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_491",
            category = VocabCategory.WORK,
            singularTarget = "सैनिक / सिपाही",
            singularBnPron = "সৈনিক",
            pluralTarget = "सैनिक",
            pluralBnPron = "সৈনিক",
            bnMeaning = "সৈনিক / সেনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_492",
            category = VocabCategory.WORK,
            singularTarget = "कलाकार",
            singularBnPron = "শিল্পী",
            pluralTarget = "कलाकार",
            pluralBnPron = "শিল্পী",
            bnMeaning = "শিল্পী / আর্টিস্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_493",
            category = VocabCategory.WORK,
            singularTarget = "लेखक",
            singularBnPron = "লেখক",
            pluralTarget = "लेखक",
            pluralBnPron = "লেখক",
            bnMeaning = "লেখক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_494",
            category = VocabCategory.WORK,
            singularTarget = "वैज्ञानिक",
            singularBnPron = "বিজ্ঞানী",
            pluralTarget = "वैज्ञानिक",
            pluralBnPron = "বিজ্ঞানী",
            bnMeaning = "বিজ্ঞানী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_495",
            category = VocabCategory.WORK,
            singularTarget = "पत्रकार",
            singularBnPron = "সাংবাদিক",
            pluralTarget = "पत्रकार",
            pluralBnPron = "সাংবাদিক",
            bnMeaning = "সাংবাদিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_496",
            category = VocabCategory.WORK,
            singularTarget = "वास्तुकार",
            singularBnPron = "বাস্তুকার",
            pluralTarget = "वास्तुकार",
            pluralBnPron = "বাস্তুকার",
            bnMeaning = "স্থপতি / আর্কিটেক্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_497",
            category = VocabCategory.WORK,
            singularTarget = "छायाकार / फोटोग्राफर",
            singularBnPron = "ফটোগ্রাফার",
            pluralTarget = "फोटोग्राफर",
            pluralBnPron = "ফটোগ্রাফার",
            bnMeaning = "ফটোগ্রাফার / আলোকচিত্রী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_498",
            category = VocabCategory.WORK,
            singularTarget = "संगीतकार",
            singularBnPron = "সঙ্গীতকার",
            pluralTarget = "संगीतकार",
            pluralBnPron = "সঙ্গীতকার",
            bnMeaning = "সুরকার / সঙ্গীতজ্ঞ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_499",
            category = VocabCategory.WORK,
            singularTarget = "अभिनेता",
            singularBnPron = "অভিনেতা",
            pluralTarget = "अभिनेता",
            pluralBnPron = "অভিনেতা",
            bnMeaning = "অভিনেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_500",
            category = VocabCategory.WORK,
            singularTarget = "अभिनेत्री",
            singularBnPron = "অভিনেত্রী",
            pluralTarget = "अभिनेत्रियां",
            pluralBnPron = "অভিনেত্রীয়াঁ",
            bnMeaning = "অভিনেত্রী",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk6 = listOf(
        VocabItem(
            id = "hi_vocab_501",
            category = VocabCategory.NATURE,
            singularTarget = "पेड़",
            singularBnPron = "পেড়",
            pluralTarget = "पेड़",
            pluralBnPron = "পেড়",
            bnMeaning = "গাছ / বৃক্ষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_502",
            category = VocabCategory.NATURE,
            singularTarget = "पौधा",
            singularBnPron = "পৌধা",
            pluralTarget = "पौधे",
            pluralBnPron = "পৌধে",
            bnMeaning = "উদ্ভিদ / চারাগাছ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_503",
            category = VocabCategory.NATURE,
            singularTarget = "फूल",
            singularBnPron = "ফুল",
            pluralTarget = "फूल",
            pluralBnPron = "ফুল",
            bnMeaning = "ফুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_504",
            category = VocabCategory.NATURE,
            singularTarget = "पत्ता",
            singularBnPron = "পত্তা",
            pluralTarget = "पत्ते",
            pluralBnPron = "পত্তে",
            bnMeaning = "পাতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_505",
            category = VocabCategory.NATURE,
            singularTarget = "जड़",
            singularBnPron = "জড়",
            pluralTarget = "जड़ें",
            pluralBnPron = "জড়েঁ",
            bnMeaning = "শিকড় / মূল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_506",
            category = VocabCategory.NATURE,
            singularTarget = "डाल / शाखा",
            singularBnPron = "ডালি",
            pluralTarget = "डालियां",
            pluralBnPron = "ডালিয়াঁ",
            bnMeaning = "শাখা / ডাল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_507",
            category = VocabCategory.NATURE,
            singularTarget = "बीज",
            singularBnPron = "বীজ",
            pluralTarget = "बीज",
            pluralBnPron = "বীজ",
            bnMeaning = "বীজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_508",
            category = VocabCategory.NATURE,
            singularTarget = "पहाड़ी",
            singularBnPron = "পাহাড়ী",
            pluralTarget = "पहाड़ियां",
            pluralBnPron = "পাহাড়িয়াঁ",
            bnMeaning = "পাহাড় / টিলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_509",
            category = VocabCategory.NATURE,
            singularTarget = "समुद्र / सागर",
            singularBnPron = "সমুদ্র",
            pluralTarget = "समुद्र",
            pluralBnPron = "সমুদ্র",
            bnMeaning = "সমুদ্র / সাগর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_510",
            category = VocabCategory.NATURE,
            singularTarget = "लहर",
            singularBnPron = "লহর",
            pluralTarget = "लहरें",
            pluralBnPron = "লহরেঁ",
            bnMeaning = "ঢেউ / তরঙ্গ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_511",
            category = VocabCategory.NATURE,
            singularTarget = "आसमान / आकाश",
            singularBnPron = "আসমান",
            pluralTarget = "आसमान",
            pluralBnPron = "আসমান",
            bnMeaning = "আকাশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_512",
            category = VocabCategory.NATURE,
            singularTarget = "बादल",
            singularBnPron = "বাদল",
            pluralTarget = "बादल",
            pluralBnPron = "বাদল",
            bnMeaning = "মেঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_513",
            category = VocabCategory.NATURE,
            singularTarget = "बारिश",
            singularBnPron = "বারিশ",
            pluralTarget = "बारिशें",
            pluralBnPron = "বারিশেঁ",
            bnMeaning = "বৃষ্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_514",
            category = VocabCategory.NATURE,
            singularTarget = "बर्फ़ / हिम",
            singularBnPron = "বরফ",
            pluralTarget = "बर्फ़",
            pluralBnPron = "বরফ",
            bnMeaning = "তুষার / বরফ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_515",
            category = VocabCategory.NATURE,
            singularTarget = "हवा / वायु",
            singularBnPron = "হাওয়া",
            pluralTarget = "हवाएं",
            pluralBnPron = "হাওয়াএঁ",
            bnMeaning = "বাতাস / বায়ু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_516",
            category = VocabCategory.NATURE,
            singularTarget = "तूफ़ान",
            singularBnPron = "তুফান",
            pluralTarget = "तूफ़ान",
            pluralBnPron = "তুফান",
            bnMeaning = "ঝড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_517",
            category = VocabCategory.NATURE,
            singularTarget = "सूरज / सूर्य",
            singularBnPron = "সুরজ",
            pluralTarget = "सूरज",
            pluralBnPron = "সুরজ",
            bnMeaning = "সূর্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_518",
            category = VocabCategory.NATURE,
            singularTarget = "चाँद / चन्द्रमा",
            singularBnPron = "চাঁদ",
            pluralTarget = "चाँद",
            pluralBnPron = "চাঁদ",
            bnMeaning = "চাঁদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_519",
            category = VocabCategory.NATURE,
            singularTarget = "तारा",
            singularBnPron = "তারা",
            pluralTarget = "तारे",
            pluralBnPron = "তারে",
            bnMeaning = "তারা / নক্ষত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_520",
            category = VocabCategory.NATURE,
            singularTarget = "मिट्टी",
            singularBnPron = "মিট্টি",
            pluralTarget = "मिट्टी",
            pluralBnPron = "মিট্টি",
            bnMeaning = "মাটি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_521",
            category = VocabCategory.NATURE,
            singularTarget = "पत्थर",
            singularBnPron = "পাথর",
            pluralTarget = "पत्थर",
            pluralBnPron = "পাথর",
            bnMeaning = "পাথর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_522",
            category = VocabCategory.NATURE,
            singularTarget = "रेत / बालू",
            singularBnPron = "রেত",
            pluralTarget = "रेत",
            pluralBnPron = "রেত",
            bnMeaning = "বালু / বালি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_523",
            category = VocabCategory.NATURE,
            singularTarget = "घास",
            singularBnPron = "ঘাস",
            pluralTarget = "घास",
            pluralBnPron = "ঘাস",
            bnMeaning = "ঘাস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_524",
            category = VocabCategory.NATURE,
            singularTarget = "आग",
            singularBnPron = "আগ",
            pluralTarget = "आग",
            pluralBnPron = "আগ",
            bnMeaning = "আগুন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_525",
            category = VocabCategory.NATURE,
            singularTarget = "पानी / जल",
            singularBnPron = "পানি",
            pluralTarget = "पानी",
            pluralBnPron = "পানি",
            bnMeaning = "জল / পানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_526",
            category = VocabCategory.NATURE,
            singularTarget = "हवा",
            singularBnPron = "হাওয়া",
            pluralTarget = "हवा",
            pluralBnPron = "হাওয়া",
            bnMeaning = "বাতাস / আবহাওয়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_527",
            category = VocabCategory.NATURE,
            singularTarget = "मौसम",
            singularBnPron = "মৌসম",
            pluralTarget = "मौसम",
            pluralBnPron = "মৌসম",
            bnMeaning = "আবহাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_528",
            category = VocabCategory.NATURE,
            singularTarget = "तापमान",
            singularBnPron = "তাপমান",
            pluralTarget = "तापमान",
            pluralBnPron = "তাপমান",
            bnMeaning = "তাপমাত্রা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_529",
            category = VocabCategory.NATURE,
            singularTarget = "गर्मी",
            singularBnPron = "গরমী",
            pluralTarget = "गर्मी",
            pluralBnPron = "গরমী",
            bnMeaning = "গরম / তাপ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_530",
            category = VocabCategory.NATURE,
            singularTarget = "सर्दी / ठंड",
            singularBnPron = "ঠান্ড",
            pluralTarget = "ठंड",
            pluralBnPron = "ঠান্ড",
            bnMeaning = "ঠান্ডা / শীত",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_531",
            category = VocabCategory.NATURE,
            singularTarget = "बर्फ़",
            singularBnPron = "বরফ",
            pluralTarget = "बर्फ़",
            pluralBnPron = "বরফ",
            bnMeaning = "বরফ খণ্ড / আইস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_532",
            category = VocabCategory.NATURE,
            singularTarget = "गर्ज / गड़गड़ाहट",
            singularBnPron = "গর্জন",
            pluralTarget = "गर्ज",
            pluralBnPron = "গর্জন",
            bnMeaning = "বজ্রপাত / মেঘের গর্জন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_533",
            category = VocabCategory.NATURE,
            singularTarget = "बिजली",
            singularBnPron = "বিজলী",
            pluralTarget = "बिजली",
            pluralBnPron = "বিজলী",
            bnMeaning = "বিদ্যুৎ চমক / বিজলী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_534",
            category = VocabCategory.NATURE,
            singularTarget = "इंद्रधनुष",
            singularBnPron = "ইন্দ্রধনুষ",
            pluralTarget = "इंद्रधनुष",
            pluralBnPron = "ইন্দ্রধনুষ",
            bnMeaning = "রংধনু / রামধনু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_535",
            category = VocabCategory.NATURE,
            singularTarget = "कोहरा",
            singularBnPron = "কোহরা",
            pluralTarget = "कोहरा",
            pluralBnPron = "কোহরা",
            bnMeaning = "কুয়াশা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_536",
            category = VocabCategory.NATURE,
            singularTarget = "धुआँ",
            singularBnPron = "ধূয়াঁ",
            pluralTarget = "धुआँ",
            pluralBnPron = "ধূয়াঁ",
            bnMeaning = "ধোঁয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_537",
            category = VocabCategory.NATURE,
            singularTarget = "गुफ़ा",
            singularBnPron = "গুফা",
            pluralTarget = "गुफ़ाएं",
            pluralBnPron = "গুফাএঁ",
            bnMeaning = "গুহা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_538",
            category = VocabCategory.NATURE,
            singularTarget = "खेत / मैदान",
            singularBnPron = "খেত",
            pluralTarget = "खेत",
            pluralBnPron = "খেত",
            bnMeaning = "মাঠ / প্রান্তর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_539",
            category = VocabCategory.NATURE,
            singularTarget = "घाटी",
            singularBnPron = "ঘাটী",
            pluralTarget = "घाटियां",
            pluralBnPron = "ঘাটীয়াঁ",
            bnMeaning = "উপত্যকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_540",
            category = VocabCategory.NATURE,
            singularTarget = "वसंत",
            singularBnPron = "বসন্ত",
            pluralTarget = "वसंत",
            pluralBnPron = "বসন্ত",
            bnMeaning = "বসন্তকাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_541",
            category = VocabCategory.NATURE,
            singularTarget = "गर्मी का मौसम",
            singularBnPron = "গরমী",
            pluralTarget = "मौसम",
            pluralBnPron = "গরমী",
            bnMeaning = "গ্রীষ্মকাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_542",
            category = VocabCategory.NATURE,
            singularTarget = "पतझड़ / शरद",
            singularBnPron = "শরদ",
            pluralTarget = "शरद",
            pluralBnPron = "শরদ",
            bnMeaning = "শরৎকাল / হেমন্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_543",
            category = VocabCategory.NATURE,
            singularTarget = "सर्दी का मौसम",
            singularBnPron = "সর্দী",
            pluralTarget = "मौसम",
            pluralBnPron = "সর্দী",
            bnMeaning = "শীতকাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_544",
            category = VocabCategory.NATURE,
            singularTarget = "पृथ्वी / धरती",
            singularBnPron = "পৃথিবী",
            pluralTarget = "धरती",
            pluralBnPron = "পৃথিবী",
            bnMeaning = "পৃথিবী / ধরা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_545",
            category = VocabCategory.NATURE,
            singularTarget = "सूर्योदय",
            singularBnPron = "সূর্যোদয়",
            pluralTarget = "सूर्योदय",
            pluralBnPron = "সূর্যোদয়",
            bnMeaning = "সূর্যোদয় / ভোর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_546",
            category = VocabCategory.NATURE,
            singularTarget = "सूर्यास्त",
            singularBnPron = "সূর্যাস্ত",
            pluralTarget = "सूर्यास्त",
            pluralBnPron = "সূর্যাস্ত",
            bnMeaning = "সূর্যাস্ত / গোধূলি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_547",
            category = VocabCategory.NATURE,
            singularTarget = "झरना",
            singularBnPron = "ঝরনা",
            pluralTarget = "झरने",
            pluralBnPron = "ঝরনে",
            bnMeaning = "জলপ্রপাত / ঝরনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_548",
            category = VocabCategory.NATURE,
            singularTarget = "सोता / स्रोत",
            singularBnPron = "উৎস",
            pluralTarget = "स्रोत",
            pluralBnPron = "উৎস",
            bnMeaning = "ঝর্ণা / উৎস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_549",
            category = VocabCategory.NATURE,
            singularTarget = "पर्यावरण",
            singularBnPron = "পরিবেশ",
            pluralTarget = "पर्यावरण",
            pluralBnPron = "পরিবেশ",
            bnMeaning = "পরিবেশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_550",
            category = VocabCategory.NATURE,
            singularTarget = "प्रकृति",
            singularBnPron = "প্রকৃতি",
            pluralTarget = "प्रकृति",
            pluralBnPron = "প্রকৃতি",
            bnMeaning = "প্রকৃতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_551",
            category = VocabCategory.ANIMALS,
            singularTarget = "कुत्ता",
            singularBnPron = "কুত্তা",
            pluralTarget = "कुत्ते",
            pluralBnPron = "কুত্তে",
            bnMeaning = "কুকুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_552",
            category = VocabCategory.ANIMALS,
            singularTarget = "बिल्ली",
            singularBnPron = "বিল্লী",
            pluralTarget = "बिल्लियां",
            pluralBnPron = "বিল্লিয়াঁ",
            bnMeaning = "বিড়াল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_553",
            category = VocabCategory.ANIMALS,
            singularTarget = "गाय",
            singularBnPron = "গায়",
            pluralTarget = "गायें",
            pluralBnPron = "গায়েঁ",
            bnMeaning = "গরু / গাভী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_554",
            category = VocabCategory.ANIMALS,
            singularTarget = "बैल / साँड़",
            singularBnPron = "বলদ",
            pluralTarget = "बैल",
            pluralBnPron = "বলদ",
            bnMeaning = "ষাঁড় / বলদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_555",
            category = VocabCategory.ANIMALS,
            singularTarget = "भैंस",
            singularBnPron = "ভৈঁস",
            pluralTarget = "भैंसें",
            pluralBnPron = "ভৈঁসেঁ",
            bnMeaning = "মহিষ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_556",
            category = VocabCategory.ANIMALS,
            singularTarget = "बकरी",
            singularBnPron = "বকরী",
            pluralTarget = "बकरियां",
            pluralBnPron = "বকরিয়াঁ",
            bnMeaning = "ছাগল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_557",
            category = VocabCategory.ANIMALS,
            singularTarget = "भेड़",
            singularBnPron = "ভেড়",
            pluralTarget = "भेड़ें",
            pluralBnPron = "ভেড়েঁ",
            bnMeaning = "ভেড়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_558",
            category = VocabCategory.ANIMALS,
            singularTarget = "घोड़ा",
            singularBnPron = "ঘোড়া",
            pluralTarget = "घोड़े",
            pluralBnPron = "ঘোড়ে",
            bnMeaning = "ঘোড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_559",
            category = VocabCategory.ANIMALS,
            singularTarget = "गधा",
            singularBnPron = "গাধা",
            pluralTarget = "गधे",
            pluralBnPron = "গাধে",
            bnMeaning = "গাধা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_560",
            category = VocabCategory.ANIMALS,
            singularTarget = "ऊँट",
            singularBnPron = "উট",
            pluralTarget = "ऊँट",
            pluralBnPron = "উট",
            bnMeaning = "উট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_561",
            category = VocabCategory.ANIMALS,
            singularTarget = "हाथी",
            singularBnPron = "হাতী",
            pluralTarget = "हाथी",
            pluralBnPron = "হাতী",
            bnMeaning = "হাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_562",
            category = VocabCategory.ANIMALS,
            singularTarget = "शेर / सिंह",
            singularBnPron = "শের",
            pluralTarget = "शेर",
            pluralBnPron = "শের",
            bnMeaning = "সিংহ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_563",
            category = VocabCategory.ANIMALS,
            singularTarget = "बाघ",
            singularBnPron = "বাঘ",
            pluralTarget = "बाघ",
            pluralBnPron = "বাঘ",
            bnMeaning = "বাঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_564",
            category = VocabCategory.ANIMALS,
            singularTarget = "तेंदुआ",
            singularBnPron = "তেন্দুয়া",
            pluralTarget = "तेंदुए",
            pluralBnPron = "তেন্দুয়ে",
            bnMeaning = "চিতাবাঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_565",
            category = VocabCategory.ANIMALS,
            singularTarget = "भालू",
            singularBnPron = "ভালু",
            pluralTarget = "भालू",
            pluralBnPron = "ভালু",
            bnMeaning = "ভাল্লুক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_566",
            category = VocabCategory.ANIMALS,
            singularTarget = "भेड़िया",
            singularBnPron = "ভেড়িয়া",
            pluralTarget = "भेड़िए",
            pluralBnPron = "ভেড়িয়ে",
            bnMeaning = "নেকড়ে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_567",
            category = VocabCategory.ANIMALS,
            singularTarget = "लोमड़ी",
            singularBnPron = "লোমড়ী",
            pluralTarget = "लोमड़ियां",
            pluralBnPron = "লোমড়িয়াঁ",
            bnMeaning = "শেয়াল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_568",
            category = VocabCategory.ANIMALS,
            singularTarget = "हिरण",
            singularBnPron = "হিরণ",
            pluralTarget = "हिरण",
            pluralBnPron = "হিরণ",
            bnMeaning = "হরিণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_569",
            category = VocabCategory.ANIMALS,
            singularTarget = "बंदर",
            singularBnPron = "বান্দর",
            pluralTarget = "बंदर",
            pluralBnPron = "বান্দর",
            bnMeaning = "বানর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_570",
            category = VocabCategory.ANIMALS,
            singularTarget = "खरगोश",
            singularBnPron = "খরগোশ",
            pluralTarget = "खरगोश",
            pluralBnPron = "খরগোশ",
            bnMeaning = "খরগোশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_571",
            category = VocabCategory.ANIMALS,
            singularTarget = "चूहा",
            singularBnPron = "চুহা",
            pluralTarget = "चूहे",
            pluralBnPron = "চুহে",
            bnMeaning = "ইঁদুর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_572",
            category = VocabCategory.ANIMALS,
            singularTarget = "साँप",
            singularBnPron = "সাপ",
            pluralTarget = "साँप",
            pluralBnPron = "সাপ",
            bnMeaning = "সাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_573",
            category = VocabCategory.ANIMALS,
            singularTarget = "मेंढक",
            singularBnPron = "মেণ্ডক",
            pluralTarget = "मेंढक",
            pluralBnPron = "মেণ্ডক",
            bnMeaning = "ব্যাঙ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_574",
            category = VocabCategory.ANIMALS,
            singularTarget = "कछुआ",
            singularBnPron = "কছুয়া",
            pluralTarget = "कछुए",
            pluralBnPron = "কছুয়ে",
            bnMeaning = "কচ্ছপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_575",
            category = VocabCategory.ANIMALS,
            singularTarget = "मगरमच्छ",
            singularBnPron = "মগরমচ্ছ",
            pluralTarget = "मगरमच्छ",
            pluralBnPron = "মগরমচ্ছ",
            bnMeaning = "কুমির",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_576",
            category = VocabCategory.ANIMALS,
            singularTarget = "मछली",
            singularBnPron = "মাছলী",
            pluralTarget = "मछलियां",
            pluralBnPron = "মাছলিয়াঁ",
            bnMeaning = "মাছ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_577",
            category = VocabCategory.ANIMALS,
            singularTarget = "शार्क",
            singularBnPron = "শার্ক",
            pluralTarget = "शार्क",
            pluralBnPron = "শার্ক",
            bnMeaning = "হাঙর",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_578",
            category = VocabCategory.ANIMALS,
            singularTarget = "व्हेल",
            singularBnPron = "হোয়েল",
            pluralTarget = "व्हेल",
            pluralBnPron = "হোয়েল",
            bnMeaning = "তিমি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_579",
            category = VocabCategory.ANIMALS,
            singularTarget = "डॉल्फ़िन",
            singularBnPron = "ডলফিন",
            pluralTarget = "डॉल्फ़िन",
            pluralBnPron = "ডলফিন",
            bnMeaning = "ডলফিন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_580",
            category = VocabCategory.ANIMALS,
            singularTarget = "पक्षी / चिड़िया",
            singularBnPron = "পাখি",
            pluralTarget = "पक्षी",
            pluralBnPron = "পাখি",
            bnMeaning = "পাখি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_581",
            category = VocabCategory.ANIMALS,
            singularTarget = "कौआ",
            singularBnPron = "কাউয়া",
            pluralTarget = "कौए",
            pluralBnPron = "কাউয়ে",
            bnMeaning = "কাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_582",
            category = VocabCategory.ANIMALS,
            singularTarget = "गौरैया",
            singularBnPron = "গৌরাইয়া",
            pluralTarget = "गौरैया",
            pluralBnPron = "গৌরাইয়া",
            bnMeaning = "চড়ুই পাখি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_583",
            category = VocabCategory.ANIMALS,
            singularTarget = "कबूतर",
            singularBnPron = "কবুতর",
            pluralTarget = "कबूतर",
            pluralBnPron = "কবুতর",
            bnMeaning = "কবুতর / পায়রা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_584",
            category = VocabCategory.ANIMALS,
            singularTarget = "चील / गरुड़",
            singularBnPron = "চিল",
            pluralTarget = "चील",
            pluralBnPron = "চিল",
            bnMeaning = "ঈগল পাখি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_585",
            category = VocabCategory.ANIMALS,
            singularTarget = "तोता",
            singularBnPron = "তোতা",
            pluralTarget = "तोते",
            pluralBnPron = "তোতে",
            bnMeaning = "তোতাপাখি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_586",
            category = VocabCategory.ANIMALS,
            singularTarget = "मोर",
            singularBnPron = "মোর",
            pluralTarget = "मोर",
            pluralBnPron = "মোর",
            bnMeaning = "ময়ূর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_587",
            category = VocabCategory.ANIMALS,
            singularTarget = "उल्लू",
            singularBnPron = "উল্লু",
            pluralTarget = "उल्लू",
            pluralBnPron = "উল্লু",
            bnMeaning = "পেঁচা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_588",
            category = VocabCategory.ANIMALS,
            singularTarget = "बत्तख",
            singularBnPron = "বাত্তখ",
            pluralTarget = "बत्तखें",
            pluralBnPron = "বাত্তখেঁ",
            bnMeaning = "হাঁস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_589",
            category = VocabCategory.ANIMALS,
            singularTarget = "हंस",
            singularBnPron = "হংস",
            pluralTarget = "हंस",
            pluralBnPron = "হংস",
            bnMeaning = "রাজহাঁস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_590",
            category = VocabCategory.ANIMALS,
            singularTarget = "मुर्गी",
            singularBnPron = "মুরগী",
            pluralTarget = "मुर्गियां",
            pluralBnPron = "মুরগীয়াঁ",
            bnMeaning = "মুরগি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_591",
            category = VocabCategory.ANIMALS,
            singularTarget = "मुर्गा",
            singularBnPron = "মুরগা",
            pluralTarget = "मुर्गे",
            pluralBnPron = "মুরগে",
            bnMeaning = "মোরগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_592",
            category = VocabCategory.ANIMALS,
            singularTarget = "चमगादड़",
            singularBnPron = "চমগাদড়",
            pluralTarget = "चमगादड़",
            pluralBnPron = "চমগাদড়",
            bnMeaning = "বাদুড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_593",
            category = VocabCategory.ANIMALS,
            singularTarget = "मधुमक्खी",
            singularBnPron = "মধুমক্ষী",
            pluralTarget = "मधुमक्खियां",
            pluralBnPron = "মধুমক্ষীয়াঁ",
            bnMeaning = "মৌমাছি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_594",
            category = VocabCategory.ANIMALS,
            singularTarget = "तितली",
            singularBnPron = "তিতলী",
            pluralTarget = "तितलियां",
            pluralBnPron = "তিতলীয়াঁ",
            bnMeaning = "প্রজাপতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_595",
            category = VocabCategory.ANIMALS,
            singularTarget = "मच्छर",
            singularBnPron = "মাচ্ছর",
            pluralTarget = "मच्छर",
            pluralBnPron = "মাচ্ছর",
            bnMeaning = "মশা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_596",
            category = VocabCategory.ANIMALS,
            singularTarget = "मक्खी",
            singularBnPron = "মাখী",
            pluralTarget = "मक्खियां",
            pluralBnPron = "মাখীয়াঁ",
            bnMeaning = "মাছি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_597",
            category = VocabCategory.ANIMALS,
            singularTarget = "चींटी",
            singularBnPron = "চিঁটি",
            pluralTarget = "चींटियां",
            pluralBnPron = "চিঁটিয়াঁ",
            bnMeaning = "পিপঁড়া",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_598",
            category = VocabCategory.ANIMALS,
            singularTarget = "मकड़ी",
            singularBnPron = "মকড়ী",
            pluralTarget = "मकड़ियां",
            pluralBnPron = "মকড়ীয়াঁ",
            bnMeaning = "মাকড়সা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_599",
            category = VocabCategory.ANIMALS,
            singularTarget = "बिच्छू",
            singularBnPron = "বিচ্ছু",
            pluralTarget = "बिच्छू",
            pluralBnPron = "বিচ্ছু",
            bnMeaning = "বিচ্ছু / কাঁকড়াবিছা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_600",
            category = VocabCategory.ANIMALS,
            singularTarget = "केंचुआ",
            singularBnPron = "কেঁচূয়া",
            pluralTarget = "केंचुए",
            pluralBnPron = "কেঁচূয়ে",
            bnMeaning = "কেঁচো / কৃমি",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk7 = listOf(
        VocabItem(
            id = "hi_vocab_601",
            category = VocabCategory.ACTIONS,
            singularTarget = "खाना",
            singularBnPron = "খানা",
            pluralTarget = "खाना",
            pluralBnPron = "খানা",
            bnMeaning = "খাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_602",
            category = VocabCategory.ACTIONS,
            singularTarget = "पीना",
            singularBnPron = "পীনা",
            pluralTarget = "पीना",
            pluralBnPron = "পীনা",
            bnMeaning = "পান করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_603",
            category = VocabCategory.ACTIONS,
            singularTarget = "सोना",
            singularBnPron = "সোনা",
            pluralTarget = "सोना",
            pluralBnPron = "সোনা",
            bnMeaning = "ঘুমানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_604",
            category = VocabCategory.ACTIONS,
            singularTarget = "जागना",
            singularBnPron = "জাগনা",
            pluralTarget = "जागना",
            pluralBnPron = "জাগনা",
            bnMeaning = "জেগে ওঠা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_605",
            category = VocabCategory.ACTIONS,
            singularTarget = "चलना / टहलना",
            singularBnPron = "চলনা",
            pluralTarget = "चलना",
            pluralBnPron = "চলনা",
            bnMeaning = "হাঁটা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_606",
            category = VocabCategory.ACTIONS,
            singularTarget = "दौड़ना",
            singularBnPron = "দৌড়না",
            pluralTarget = "दौड़ना",
            pluralBnPron = "দৌড়না",
            bnMeaning = "দৌড়ানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_607",
            category = VocabCategory.ACTIONS,
            singularTarget = "कूदना",
            singularBnPron = "কূদনা",
            pluralTarget = "कूदना",
            pluralBnPron = "কূদনা",
            bnMeaning = "লাফানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_608",
            category = VocabCategory.ACTIONS,
            singularTarget = "बैठना",
            singularBnPron = "বৈতনা",
            pluralTarget = "बैठना",
            pluralBnPron = "বৈতনা",
            bnMeaning = "বসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_609",
            category = VocabCategory.ACTIONS,
            singularTarget = "खड़े होना",
            singularBnPron = "খড়ে হোনা",
            pluralTarget = "खड़े होना",
            pluralBnPron = "খড়ে হোনা",
            bnMeaning = "দাঁড়ানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_610",
            category = VocabCategory.ACTIONS,
            singularTarget = "बोलना",
            singularBnPron = "বোলনা",
            pluralTarget = "बोलना",
            pluralBnPron = "বোলনা",
            bnMeaning = "কথা বলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_611",
            category = VocabCategory.ACTIONS,
            singularTarget = "कहना",
            singularBnPron = "কহনা",
            pluralTarget = "कहना",
            pluralBnPron = "কহনা",
            bnMeaning = "বলা / জানানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_612",
            category = VocabCategory.ACTIONS,
            singularTarget = "सुनना",
            singularBnPron = "সুননা",
            pluralTarget = "सुनना",
            pluralBnPron = "সুননা",
            bnMeaning = "শোনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_613",
            category = VocabCategory.ACTIONS,
            singularTarget = "देखना",
            singularBnPron = "দেখনা",
            pluralTarget = "देखना",
            pluralBnPron = "দেখনা",
            bnMeaning = "দেখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_614",
            category = VocabCategory.ACTIONS,
            singularTarget = "पढ़ना",
            singularBnPron = "পড়না",
            pluralTarget = "पढ़ना",
            pluralBnPron = "পড়না",
            bnMeaning = "পড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_615",
            category = VocabCategory.ACTIONS,
            singularTarget = "लिखना",
            singularBnPron = "লিখনা",
            pluralTarget = "लिखना",
            pluralBnPron = "লিখনা",
            bnMeaning = "লেখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_616",
            category = VocabCategory.ACTIONS,
            singularTarget = "सीखना",
            singularBnPron = "সীখনা",
            pluralTarget = "सीखना",
            pluralBnPron = "সীখনা",
            bnMeaning = "শেখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_617",
            category = VocabCategory.ACTIONS,
            singularTarget = "सिखाना / पढ़ाना",
            singularBnPron = "সিখানা",
            pluralTarget = "सिखाना",
            pluralBnPron = "সিখানা",
            bnMeaning = "শেখানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_618",
            category = VocabCategory.ACTIONS,
            singularTarget = "खरीदना",
            singularBnPron = "খরীদনা",
            pluralTarget = "खरीदना",
            pluralBnPron = "খরীদনা",
            bnMeaning = "কেনা / ক্রয় করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_619",
            category = VocabCategory.ACTIONS,
            singularTarget = "बेचना",
            singularBnPron = "বেচনা",
            pluralTarget = "बेचना",
            pluralBnPron = "বেচনা",
            bnMeaning = "বিক্রি করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_620",
            category = VocabCategory.ACTIONS,
            singularTarget = "देना",
            singularBnPron = "দেনা",
            pluralTarget = "देना",
            pluralBnPron = "দেনা",
            bnMeaning = "দেওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_621",
            category = VocabCategory.ACTIONS,
            singularTarget = "लेना",
            singularBnPron = "লেনা",
            pluralTarget = "लेना",
            pluralBnPron = "লেনা",
            bnMeaning = "নেওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_622",
            category = VocabCategory.ACTIONS,
            singularTarget = "खोलना",
            singularBnPron = "খোলনা",
            pluralTarget = "खोलना",
            pluralBnPron = "খোলনা",
            bnMeaning = "খোলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_623",
            category = VocabCategory.ACTIONS,
            singularTarget = "बंद करना",
            singularBnPron = "বন্দ করনা",
            pluralTarget = "बंद करना",
            pluralBnPron = "বন্দ করনা",
            bnMeaning = "বন্ধ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_624",
            category = VocabCategory.ACTIONS,
            singularTarget = "शुरू करना",
            singularBnPron = "শুরু করনা",
            pluralTarget = "शुरू करना",
            pluralBnPron = "শুরু করনা",
            bnMeaning = "শুরু করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_625",
            category = VocabCategory.ACTIONS,
            singularTarget = "ख़त्म करना",
            singularBnPron = "খতম করনা",
            pluralTarget = "ख़त्म करना",
            pluralBnPron = "খতম করনা",
            bnMeaning = "শেষ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_626",
            category = VocabCategory.ACTIONS,
            singularTarget = "आना",
            singularBnPron = "আনা",
            pluralTarget = "आना",
            pluralBnPron = "আনা",
            bnMeaning = "আসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_627",
            category = VocabCategory.ACTIONS,
            singularTarget = "जाना",
            singularBnPron = "জানা",
            pluralTarget = "जाना",
            pluralBnPron = "জানা",
            bnMeaning = "যাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_628",
            category = VocabCategory.ACTIONS,
            singularTarget = "लौटना",
            singularBnPron = "লৌটনা",
            pluralTarget = "लौटना",
            pluralBnPron = "লৌটনা",
            bnMeaning = "ফিরে আসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_629",
            category = VocabCategory.ACTIONS,
            singularTarget = "इंतज़ार करना",
            singularBnPron = "ইন্তজার করনা",
            pluralTarget = "इंतज़ार करना",
            pluralBnPron = "ইন্তজার করনা",
            bnMeaning = "অপেক্ষা করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_630",
            category = VocabCategory.ACTIONS,
            singularTarget = "मदद करना",
            singularBnPron = "মদদ করনা",
            pluralTarget = "मदद करना",
            pluralBnPron = "মদদ করনা",
            bnMeaning = "সাহায্য করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_631",
            category = VocabCategory.ACTIONS,
            singularTarget = "काम करना",
            singularBnPron = "কাম করনা",
            pluralTarget = "काम करना",
            pluralBnPron = "কাম করনা",
            bnMeaning = "কাজ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_632",
            category = VocabCategory.ACTIONS,
            singularTarget = "खेलना",
            singularBnPron = "খেলনা",
            pluralTarget = "खेलना",
            pluralBnPron = "খেলনা",
            bnMeaning = "খেলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_633",
            category = VocabCategory.ACTIONS,
            singularTarget = "गाना",
            singularBnPron = "গানা",
            pluralTarget = "गाना",
            pluralBnPron = "গানা",
            bnMeaning = "গান গাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_634",
            category = VocabCategory.ACTIONS,
            singularTarget = "नाचना",
            singularBnPron = "নাচনা",
            pluralTarget = "नाचना",
            pluralBnPron = "নাচনা",
            bnMeaning = "নাচা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_635",
            category = VocabCategory.ACTIONS,
            singularTarget = "हँसना",
            singularBnPron = "হঁসনা",
            pluralTarget = "हँसना",
            pluralBnPron = "হঁসনা",
            bnMeaning = "হাসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_636",
            category = VocabCategory.ACTIONS,
            singularTarget = "रोना",
            singularBnPron = "রোনা",
            pluralTarget = "रोना",
            pluralBnPron = "রোনা",
            bnMeaning = "কাঁদা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_637",
            category = VocabCategory.ACTIONS,
            singularTarget = "सोचना",
            singularBnPron = "সোচনা",
            pluralTarget = "सोचना",
            pluralBnPron = "সোচনা",
            bnMeaning = "চিন্তা করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_638",
            category = VocabCategory.ACTIONS,
            singularTarget = "समझना",
            singularBnPron = "সমঝনা",
            pluralTarget = "समझना",
            pluralBnPron = "সমঝনা",
            bnMeaning = "বুঝতে পারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_639",
            category = VocabCategory.ACTIONS,
            singularTarget = "याद रखना",
            singularBnPron = "ইয়াদ রখনা",
            pluralTarget = "याद रखना",
            pluralBnPron = "ইয়াদ রখনা",
            bnMeaning = "মনে রাখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_640",
            category = VocabCategory.ACTIONS,
            singularTarget = "भूलना",
            singularBnPron = "ভুলনা",
            pluralTarget = "भूलना",
            pluralBnPron = "ভুলনা",
            bnMeaning = "ভুলে যাওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_641",
            category = VocabCategory.ACTIONS,
            singularTarget = "पकाना",
            singularBnPron = "পকানা",
            pluralTarget = "पकाना",
            pluralBnPron = "পকানা",
            bnMeaning = "রান্না করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_642",
            category = VocabCategory.ACTIONS,
            singularTarget = "धोना",
            singularBnPron = "ধোনা",
            pluralTarget = "धोना",
            pluralBnPron = "ধোনা",
            bnMeaning = "ধোয়া / পরিষ্কার করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_643",
            category = VocabCategory.ACTIONS,
            singularTarget = "साफ़ करना",
            singularBnPron = "সাফ করনা",
            pluralTarget = "साफ़ करना",
            pluralBnPron = "সাফ করনা",
            bnMeaning = "পরিষ্কার করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_644",
            category = VocabCategory.ACTIONS,
            singularTarget = "काटना",
            singularBnPron = "কাটনা",
            pluralTarget = "काटना",
            pluralBnPron = "কাটনা",
            bnMeaning = "কাটা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_645",
            category = VocabCategory.ACTIONS,
            singularTarget = "रखना",
            singularBnPron = "রখনা",
            pluralTarget = "रखना",
            pluralBnPron = "রখনা",
            bnMeaning = "রাখা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_646",
            category = VocabCategory.ACTIONS,
            singularTarget = "लाना",
            singularBnPron = "লানা",
            pluralTarget = "लाना",
            pluralBnPron = "লানা",
            bnMeaning = "আনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_647",
            category = VocabCategory.ACTIONS,
            singularTarget = "भेजना",
            singularBnPron = "ভেজনা",
            pluralTarget = "भेजना",
            pluralBnPron = "ভেজনা",
            bnMeaning = "পাঠানো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_648",
            category = VocabCategory.ACTIONS,
            singularTarget = "बुलाना / पुकारना",
            singularBnPron = "বুलाना",
            pluralTarget = "बुलाना",
            pluralBnPron = "বুलाना",
            bnMeaning = "ডাকা / কল করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_649",
            category = VocabCategory.ACTIONS,
            singularTarget = "पूछना",
            singularBnPron = "পুছনা",
            pluralTarget = "पूछना",
            pluralBnPron = "পুছনা",
            bnMeaning = "জিজ্ঞাসা করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_650",
            category = VocabCategory.ACTIONS,
            singularTarget = "रहना",
            singularBnPron = "রহনা",
            pluralTarget = "रहना",
            pluralBnPron = "রহনা",
            bnMeaning = "বাস করা / থাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_651",
            category = VocabCategory.EMOTIONS,
            singularTarget = "खुशी / आनंद",
            singularBnPron = "খুশী",
            pluralTarget = "खुशी",
            pluralBnPron = "খুশী",
            bnMeaning = "আনন্দ / সুখ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_652",
            category = VocabCategory.EMOTIONS,
            singularTarget = "दुःख / उदासी",
            singularBnPron = "দুখ",
            pluralTarget = "दुःख",
            pluralBnPron = "দুখ",
            bnMeaning = "দুঃখ / কষ্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_653",
            category = VocabCategory.EMOTIONS,
            singularTarget = "गुस्सा / क्रोध",
            singularBnPron = "গুসসা",
            pluralTarget = "गुस्सा",
            pluralBnPron = "গুসসা",
            bnMeaning = "রাগ / ক্রোধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_654",
            category = VocabCategory.EMOTIONS,
            singularTarget = "डर / भय",
            singularBnPron = "ডর",
            pluralTarget = "डर",
            pluralBnPron = "ডর",
            bnMeaning = "ভয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_655",
            category = VocabCategory.EMOTIONS,
            singularTarget = "प्यार / प्रेम",
            singularBnPron = "প্যার",
            pluralTarget = "प्यार",
            pluralBnPron = "প্যার",
            bnMeaning = "ভালোবাসা / প্রেম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_656",
            category = VocabCategory.EMOTIONS,
            singularTarget = "नफ़रत / घृणा",
            singularBnPron = "নফরত",
            pluralTarget = "नफ़रत",
            pluralBnPron = "নফরত",
            bnMeaning = "ঘৃণা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_657",
            category = VocabCategory.EMOTIONS,
            singularTarget = "उम्मीद / आशा",
            singularBnPron = "উম্মিদ",
            pluralTarget = "उम्मीदें",
            pluralBnPron = "উম্মিদেঁ",
            bnMeaning = "আশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_658",
            category = VocabCategory.EMOTIONS,
            singularTarget = "शांति / अमन",
            singularBnPron = "শান্তি",
            pluralTarget = "शांति",
            pluralBnPron = "শান্তি",
            bnMeaning = "শান্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_659",
            category = VocabCategory.EMOTIONS,
            singularTarget = "आश्चर्य / हैरानी",
            singularBnPron = "হায়রানী",
            pluralTarget = "हैरानी",
            pluralBnPron = "হায়রানী",
            bnMeaning = "আশ্চর্য / বিস্ময়",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_660",
            category = VocabCategory.EMOTIONS,
            singularTarget = "भरोसा / विश्वास",
            singularBnPron = "ভরসা",
            pluralTarget = "भरोसा",
            pluralBnPron = "ভরসা",
            bnMeaning = "বিশ্বাস / ভরসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_661",
            category = VocabCategory.EMOTIONS,
            singularTarget = "हिम्मत / साहस",
            singularBnPron = "হিম্মত",
            pluralTarget = "हिम्मत",
            pluralBnPron = "হিম্মত",
            bnMeaning = "সাহস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_662",
            category = VocabCategory.EMOTIONS,
            singularTarget = "गर्व / घमंड",
            singularBnPron = "গর্ব",
            pluralTarget = "गर्व",
            pluralBnPron = "গর্ব",
            bnMeaning = "গর্ব / অহংকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_663",
            category = VocabCategory.EMOTIONS,
            singularTarget = "शर्म / लज्जा",
            singularBnPron = "শর্ম",
            pluralTarget = "शर्म",
            pluralBnPron = "শর্ম",
            bnMeaning = "লজ্জা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_664",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ईर्ष्या / जलन",
            singularBnPron = "জলন",
            pluralTarget = "जलन",
            pluralBnPron = "জলন",
            bnMeaning = "ঈর্ষা / হিংসা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_665",
            category = VocabCategory.EMOTIONS,
            singularTarget = "चिंता / फ़िक्र",
            singularBnPron = "চিন্তা",
            pluralTarget = "चिंताएं",
            pluralBnPron = "চিন্তা",
            bnMeaning = "উদ্বেগ / চিন্তা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_666",
            category = VocabCategory.EMOTIONS,
            singularTarget = "राहत / सुकून",
            singularBnPron = "রাহত",
            pluralTarget = "राहत",
            pluralBnPron = "রাহত",
            bnMeaning = "স্বস্তি / প্রশান্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_667",
            category = VocabCategory.EMOTIONS,
            singularTarget = "उत्तेजना / जोश",
            singularBnPron = "জশ",
            pluralTarget = "जोश",
            pluralBnPron = "জশ",
            bnMeaning = "উত্তেজনা / রোমাঞ্চ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_668",
            category = VocabCategory.EMOTIONS,
            singularTarget = "उबाऊपन / बोरियत",
            singularBnPron = "বোরিয়াত",
            pluralTarget = "बोरियत",
            pluralBnPron = "বোরিয়াত",
            bnMeaning = "একঘেয়েমি / বিরক্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_669",
            category = VocabCategory.EMOTIONS,
            singularTarget = "भ्रम / उलझन",
            singularBnPron = "উলঝন",
            pluralTarget = "उलझन",
            pluralBnPron = "উলঝন",
            bnMeaning = "বিভ্রান্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_670",
            category = VocabCategory.EMOTIONS,
            singularTarget = "निराशा / मायूसी",
            singularBnPron = "মায়ুসী",
            pluralTarget = "मायूसी",
            pluralBnPron = "মায়ুসী",
            bnMeaning = "হতাশা / নিরাশা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_671",
            category = VocabCategory.EMOTIONS,
            singularTarget = "कृतज्ञता / आभार",
            singularBnPron = "আভার",
            pluralTarget = "आभार",
            pluralBnPron = "আভার",
            bnMeaning = "কৃতজ্ঞতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_672",
            category = VocabCategory.EMOTIONS,
            singularTarget = "पछतावा / अफ़सोस",
            singularBnPron = "পছতাওয়া",
            pluralTarget = "पछतावा",
            pluralBnPron = "পছতাওয়া",
            bnMeaning = "অনুতাপ / আফসোস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_673",
            category = VocabCategory.EMOTIONS,
            singularTarget = "अकेलापन",
            singularBnPron = "অকেলাপন",
            pluralTarget = "अकेलापन",
            pluralBnPron = "অকেলাপন",
            bnMeaning = "একাকীত্ব",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_674",
            category = VocabCategory.EMOTIONS,
            singularTarget = "सहानुभूति / दया",
            singularBnPron = "দয়া",
            pluralTarget = "दया",
            pluralBnPron = "দয়া",
            bnMeaning = "দয়া / সহানুভূতি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_675",
            category = VocabCategory.EMOTIONS,
            singularTarget = "धैर्य / सब्र",
            singularBnPron = "সবর",
            pluralTarget = "सब्र",
            pluralBnPron = "সবর",
            bnMeaning = "ধৈর্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_676",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ईमानदारी / सच्चाई",
            singularBnPron = "ঈমানদারী",
            pluralTarget = "ईमानदारी",
            pluralBnPron = "ঈমানদারী",
            bnMeaning = "সততা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_677",
            category = VocabCategory.EMOTIONS,
            singularTarget = "जिज्ञासा / उत्सुकता",
            singularBnPron = "উৎসুকতা",
            pluralTarget = "उत्सुकता",
            pluralBnPron = "উৎসুকতা",
            bnMeaning = "কৌতূহল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_678",
            category = VocabCategory.EMOTIONS,
            singularTarget = "आदर / सम्मान",
            singularBnPron = "সম্মান",
            pluralTarget = "सम्मान",
            pluralBnPron = "সম্মান",
            bnMeaning = "শ্রদ্ধা / সম্মান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_679",
            category = VocabCategory.EMOTIONS,
            singularTarget = "आत्मविश्वास",
            singularBnPron = "আত্মবিশ্বাস",
            pluralTarget = "आत्मविश्वास",
            pluralBnPron = "আত্মবিশ্বাস",
            bnMeaning = "আত্মবিশ্বাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_680",
            category = VocabCategory.EMOTIONS,
            singularTarget = "संदेह / शक",
            singularBnPron = "শক",
            pluralTarget = "शक",
            pluralBnPron = "শক",
            bnMeaning = "সন্দেহ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_681",
            category = VocabCategory.EMOTIONS,
            singularTarget = "खुश",
            singularBnPron = "খুশ",
            pluralTarget = "खुश",
            pluralBnPron = "খুশ",
            bnMeaning = "সুখী / আনন্দিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_682",
            category = VocabCategory.EMOTIONS,
            singularTarget = "उदास / दुखी",
            singularBnPron = "উদাস",
            pluralTarget = "उदास",
            pluralBnPron = "উদাস",
            bnMeaning = "দুঃখী / বিষণ্ণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_683",
            category = VocabCategory.EMOTIONS,
            singularTarget = "गुस्सा / क्रोधित",
            singularBnPron = "নারাজ",
            pluralTarget = "नाराज़",
            pluralBnPron = "নারাজ",
            bnMeaning = "রাগান্বিত / ক্ষুব্ধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_684",
            category = VocabCategory.EMOTIONS,
            singularTarget = "डरा हुआ",
            singularBnPron = "ডরা হুয়া",
            pluralTarget = "डरे हुए",
            pluralBnPron = "ডরে হুয়ে",
            bnMeaning = "ভীত / শঙ্কিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_685",
            category = VocabCategory.EMOTIONS,
            singularTarget = "आशावादी",
            singularBnPron = "আশাবাদী",
            pluralTarget = "आशावादी",
            pluralBnPron = "আশাবাদী",
            bnMeaning = "আশাবাদী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_686",
            category = VocabCategory.EMOTIONS,
            singularTarget = "शांत",
            singularBnPron = "শান্ত",
            pluralTarget = "शांत",
            pluralBnPron = "শান্ত",
            bnMeaning = "শান্ত / নীরব",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_687",
            category = VocabCategory.EMOTIONS,
            singularTarget = "गर्वित",
            singularBnPron = "গর্বিত",
            pluralTarget = "गर्वित",
            pluralBnPron = "গর্বিত",
            bnMeaning = "গর্বিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_688",
            category = VocabCategory.EMOTIONS,
            singularTarget = "शर्मिंदा",
            singularBnPron = "শর্মিন্দা",
            pluralTarget = "शर्मिंदा",
            pluralBnPron = "শর্মিন্দা",
            bnMeaning = "লজ্জিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_689",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ईर्ष्यालु / जलने वाला",
            singularBnPron = "ঈর্ষালু",
            pluralTarget = "ईर्ष्यालु",
            pluralBnPron = "ঈর্ষালু",
            bnMeaning = "ঈর্ষান্বিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_690",
            category = VocabCategory.EMOTIONS,
            singularTarget = "चिंतित",
            singularBnPron = "চিন্তিত",
            pluralTarget = "चिंतित",
            pluralBnPron = "চিন্তিত",
            bnMeaning = "চিন্তিত / উদ্বিগ্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_691",
            category = VocabCategory.EMOTIONS,
            singularTarget = "उत्साहित",
            singularBnPron = "উৎসাহিত",
            pluralTarget = "उत्साहित",
            pluralBnPron = "উৎসাহিত",
            bnMeaning = "উত্তেজিত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_692",
            category = VocabCategory.EMOTIONS,
            singularTarget = "थका हुआ",
            singularBnPron = "থকা হুয়া",
            pluralTarget = "थके हुए",
            pluralBnPron = "থকে হুয়ে",
            bnMeaning = "ক্লান্ত / পরিশ্রান্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_693",
            category = VocabCategory.EMOTIONS,
            singularTarget = "अकेला",
            singularBnPron = "অকেলা",
            pluralTarget = "अकेले",
            pluralBnPron = "অকেলে",
            bnMeaning = "নিঃসঙ্গ / একাকী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_694",
            category = VocabCategory.EMOTIONS,
            singularTarget = "आभारी",
            singularBnPron = "আভারী",
            pluralTarget = "आभारी",
            pluralBnPron = "আভারী",
            bnMeaning = "কৃতজ্ঞ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_695",
            category = VocabCategory.EMOTIONS,
            singularTarget = "बहादुर / साहसी",
            singularBnPron = "বাহাদুর",
            pluralTarget = "बहादुर",
            pluralBnPron = "বাহাদুর",
            bnMeaning = "সাহসী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_696",
            category = VocabCategory.EMOTIONS,
            singularTarget = "ईमानदार",
            singularBnPron = "ঈমানদার",
            pluralTarget = "ईमानदार",
            pluralBnPron = "ঈমানদার",
            bnMeaning = "সৎ / নিষ্ঠাবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_697",
            category = VocabCategory.EMOTIONS,
            singularTarget = "धैर्यवान / सब्र वाला",
            singularBnPron = "ধৈর্যবান",
            pluralTarget = "धैर्यवान",
            pluralBnPron = "ধৈর্যবান",
            bnMeaning = "ধৈর্যশীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_698",
            category = VocabCategory.EMOTIONS,
            singularTarget = "बेचैन",
            singularBnPron = "বেচেন",
            pluralTarget = "बेचैन",
            pluralBnPron = "বেচেন",
            bnMeaning = "উদ্বিগ্ন / অস্থির",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_699",
            category = VocabCategory.EMOTIONS,
            singularTarget = "हैरान / चकित",
            singularBnPron = "হায়রান",
            pluralTarget = "हैरान",
            pluralBnPron = "হায়রান",
            bnMeaning = "বিস্মিত / অবাক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_700",
            category = VocabCategory.EMOTIONS,
            singularTarget = "आत्मविश्वासी",
            singularBnPron = "আত্মবিশ্বাসী",
            pluralTarget = "आत्मविश्वासी",
            pluralBnPron = "আত্মবিশ্বাসী",
            bnMeaning = "আত্মবিশ্বাসী",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk8 = listOf(
        VocabItem(
            id = "hi_vocab_701",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "अच्छा",
            singularBnPron = "আচ্ছা",
            pluralTarget = "अच्छे",
            pluralBnPron = "আচ্ছা",
            bnMeaning = "ভালো / উত্তম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_702",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "बुरा / ख़राब",
            singularBnPron = "বুরা",
            pluralTarget = "बुरे",
            pluralBnPron = "বুরা",
            bnMeaning = "খারাপ / মন্দ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_703",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "बड़ा",
            singularBnPron = "বড়া",
            pluralTarget = "बड़े",
            pluralBnPron = "বড়া",
            bnMeaning = "বড়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_704",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "छोटा",
            singularBnPron = "ছোটা",
            pluralTarget = "छोटे",
            pluralBnPron = "ছোটা",
            bnMeaning = "ছোট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_705",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "लंबा",
            singularBnPron = "লম্বা",
            pluralTarget = "लंबे",
            pluralBnPron = "লম্বা",
            bnMeaning = "লম্বা / দীর্ঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_706",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "छोटा / नाटा",
            singularBnPron = "ছোটা",
            pluralTarget = "छोटे",
            pluralBnPron = "ছোটা",
            bnMeaning = "খাটো / ছোট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_707",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ऊँचा",
            singularBnPron = "উঁচা",
            pluralTarget = "ऊँचे",
            pluralBnPron = "উঁচা",
            bnMeaning = "উঁচু / লম্বা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_708",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "मोटा",
            singularBnPron = "মোটা",
            pluralTarget = "मोटे",
            pluralBnPron = "মোটা",
            bnMeaning = "মোটা / স্থূল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_709",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "पतला",
            singularBnPron = "পতলা",
            pluralTarget = "पतले",
            pluralBnPron = "পতলা",
            bnMeaning = "পাতলা / চিকন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_710",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "तेज़",
            singularBnPron = "তেজ",
            pluralTarget = "तेज़",
            pluralBnPron = "তেজ",
            bnMeaning = "দ্রুত / তেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_711",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "धीमा",
            singularBnPron = "ধীমা",
            pluralTarget = "धीमे",
            pluralBnPron = "ধীমা",
            bnMeaning = "ধীর / আস্তে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_712",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "भारी",
            singularBnPron = "ভারী",
            pluralTarget = "भारी",
            pluralBnPron = "ভারী",
            bnMeaning = "ভারী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_713",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "हल्का",
            singularBnPron = "হালকা",
            pluralTarget = "हल्के",
            pluralBnPron = "হালকা",
            bnMeaning = "হালকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_714",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "सख्त / कठोर",
            singularBnPron = "সখত",
            pluralTarget = "सख्त",
            pluralBnPron = "সখত",
            bnMeaning = "কঠিন / শক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_715",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "नरम / कोमल",
            singularBnPron = "নরম",
            pluralTarget = "नरम",
            pluralBnPron = "নরম",
            bnMeaning = "নরম / কোমল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_716",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "गर्म",
            singularBnPron = "গরম",
            pluralTarget = "गर्म",
            pluralBnPron = "গরম",
            bnMeaning = "গরম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_717",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ठंडा",
            singularBnPron = "ঠান্ডা",
            pluralTarget = "ठंडे",
            pluralBnPron = "ঠান্ডা",
            bnMeaning = "ঠান্ডা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_718",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "गुनगुना / गर्म",
            singularBnPron = "গুনগুনা",
            pluralTarget = "गर्म",
            pluralBnPron = "গুনগুনা",
            bnMeaning = "উষ্ণ / নাতিশীতোষ্ণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_719",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "शीतल / ठंडा",
            singularBnPron = "শীতল",
            pluralTarget = "शीतल",
            pluralBnPron = "শীতল",
            bnMeaning = "শীতল / স্নিগ্ধ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_720",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "साफ़ / स्वच्छ",
            singularBnPron = "সাফ",
            pluralTarget = "साफ़",
            pluralBnPron = "সাফ",
            bnMeaning = "পরিষ্কার / পরিচ্ছন্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_721",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "गंदा",
            singularBnPron = "গন্দা",
            pluralTarget = "गंदे",
            pluralBnPron = "গন্দা",
            bnMeaning = "নোংরা / অপবিত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_722",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "नया",
            singularBnPron = "নয়া",
            pluralTarget = "नए",
            pluralBnPron = "নয়া",
            bnMeaning = "নতুন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_723",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "पुराना",
            singularBnPron = "পুরানা",
            pluralTarget = "पुराने",
            pluralBnPron = "পুরানা",
            bnMeaning = "পুরাতন / পুরনো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_724",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "जवान / युवा",
            singularBnPron = "জওয়ান",
            pluralTarget = "जवान",
            pluralBnPron = "জওয়ান",
            bnMeaning = "তরুণ / যুবা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_725",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "सुंदर / खूबसूरत",
            singularBnPron = "সুন্দর",
            pluralTarget = "सुंदर",
            pluralBnPron = "সুন্দর",
            bnMeaning = "সুন্দর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_726",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "बदसूरत",
            singularBnPron = "বদসুরত",
            pluralTarget = "बदसूरत",
            pluralBnPron = "বদসুরত",
            bnMeaning = "কুৎসিত / বিশ্রী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_727",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "अमीर / धनी",
            singularBnPron = "আমীর",
            pluralTarget = "अमीर",
            pluralBnPron = "আমীর",
            bnMeaning = "ধনী / বিত্তবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_728",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ग़रीब",
            singularBnPron = "গরীব",
            pluralTarget = "ग़रीब",
            pluralBnPron = "গরীব",
            bnMeaning = "গরিব / দরিদ্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_729",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "मज़बूत / बलवान",
            singularBnPron = "মজবুত",
            pluralTarget = "मज़बूत",
            pluralBnPron = "মজবুত",
            bnMeaning = "শক্তিশালী / বলবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_730",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "कमज़ोर",
            singularBnPron = "কমজোর",
            pluralTarget = "कमज़ोर",
            pluralBnPron = "কমজোর",
            bnMeaning = "দুর্বল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_731",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "मीठा",
            singularBnPron = "মীঠা",
            pluralTarget = "मीठे",
            pluralBnPron = "মীঠা",
            bnMeaning = "মিষ্টি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_732",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "खट्टा",
            singularBnPron = "খাট্টা",
            pluralTarget = "खट्टे",
            pluralBnPron = "খাট্টা",
            bnMeaning = "টক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_733",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "कड़वा",
            singularBnPron = "কড়ওয়া",
            pluralTarget = "कड़वे",
            pluralBnPron = "কড়ওয়া",
            bnMeaning = "তিতা / তিক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_734",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "नमकीन",
            singularBnPron = "নমকীন",
            pluralTarget = "नमकीन",
            pluralBnPron = "নমকীন",
            bnMeaning = "নোনতা / লবণাক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_735",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "तीखा / मसालेदार",
            singularBnPron = "তীখা",
            pluralTarget = "तीखा",
            pluralBnPron = "তীখা",
            bnMeaning = "ঝাল / মসলাযুক্ত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_736",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "आसान / सरल",
            singularBnPron = "আসান",
            pluralTarget = "आसान",
            pluralBnPron = "আসান",
            bnMeaning = "সহজ / সরল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_737",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "कठिन / मुश्किल",
            singularBnPron = "মুশকিল",
            pluralTarget = "मुश्किल",
            pluralBnPron = "মুশকিল",
            bnMeaning = "কঠিন / জটিল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_738",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "महंगा",
            singularBnPron = "মহঙ্গা",
            pluralTarget = "महंगे",
            pluralBnPron = "মহঙ্গা",
            bnMeaning = "দামি / মূল্যবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_739",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "सस्ता",
            singularBnPron = "সস্তা",
            pluralTarget = "सस्ते",
            pluralBnPron = "সস্তা",
            bnMeaning = "সস্তা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_740",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "सुरक्षित",
            singularBnPron = "সুরক্ষিত",
            pluralTarget = "सुरक्षित",
            pluralBnPron = "সুরক্ষিত",
            bnMeaning = "নিরাপদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_741",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "ख़तरनाक",
            singularBnPron = "খতরনাক",
            pluralTarget = "ख़तरनाक",
            pluralBnPron = "খতরনাক",
            bnMeaning = "বিপজ্জনক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_742",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "चमकीला / उज्ज्वल",
            singularBnPron = "চমকীলা",
            pluralTarget = "चमकीला",
            pluralBnPron = "চমকীলা",
            bnMeaning = "উজ্জ্বল / ফর্সা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_743",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "अंधेरा",
            singularBnPron = "আঁধেরা",
            pluralTarget = "अंधेरा",
            pluralBnPron = "আঁধেরা",
            bnMeaning = "অন্ধকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_744",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "सूखा",
            singularBnPron = "সূখা",
            pluralTarget = "सूखे",
            pluralBnPron = "সূখা",
            bnMeaning = "শুকনো / শুষ্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_745",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "गीला",
            singularBnPron = "গীলা",
            pluralTarget = "गीले",
            pluralBnPron = "গীলা",
            bnMeaning = "ভেজা / আর্দ্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_746",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "भरा हुआ / पूरा",
            singularBnPron = "ভরা হুয়া",
            pluralTarget = "भरा हुआ",
            pluralBnPron = "ভরা হুয়া",
            bnMeaning = "পূর্ণ / ভরা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_747",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "खाली",
            singularBnPron = "খালী",
            pluralTarget = "खाली",
            pluralBnPron = "খালী",
            bnMeaning = "খালি / শূন্য",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_748",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "सच्चा / सही",
            singularBnPron = "সচ্চা",
            pluralTarget = "सच्चा",
            pluralBnPron = "সচ্চা",
            bnMeaning = "সত্য / সঠিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_749",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "झूठा / गलत",
            singularBnPron = "ঝুঠা",
            pluralTarget = "झूठा",
            pluralBnPron = "ঝুঠা",
            bnMeaning = "মিথ্যা / ভুল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_750",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "महत्वपूर्ण / ज़रूरी",
            singularBnPron = "জরুরী",
            pluralTarget = "ज़रूरी",
            pluralBnPron = "জরুরী",
            bnMeaning = "গুরুত্বপূর্ণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_751",
            category = VocabCategory.COLORS,
            singularTarget = "लाल",
            singularBnPron = "লাল",
            pluralTarget = "लाल",
            pluralBnPron = "লাল",
            bnMeaning = "লাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_752",
            category = VocabCategory.COLORS,
            singularTarget = "नीला",
            singularBnPron = "নীলা",
            pluralTarget = "नीले",
            pluralBnPron = "নীলে",
            bnMeaning = "নীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_753",
            category = VocabCategory.COLORS,
            singularTarget = "हरा",
            singularBnPron = "হরা",
            pluralTarget = "हरे",
            pluralBnPron = "হরে",
            bnMeaning = "সবুজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_754",
            category = VocabCategory.COLORS,
            singularTarget = "पीला",
            singularBnPron = "পীলা",
            pluralTarget = "पीले",
            pluralBnPron = "পীলে",
            bnMeaning = "হলুদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_755",
            category = VocabCategory.COLORS,
            singularTarget = "काला",
            singularBnPron = "কালা",
            pluralTarget = "काले",
            pluralBnPron = "কালে",
            bnMeaning = "কালো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_756",
            category = VocabCategory.COLORS,
            singularTarget = "सफ़ेद",
            singularBnPron = "সফেদ",
            pluralTarget = "सफ़ेद",
            pluralBnPron = "সফেদ",
            bnMeaning = "সাদা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_757",
            category = VocabCategory.COLORS,
            singularTarget = "नारंगी",
            singularBnPron = "নারঙ্গী",
            pluralTarget = "नारंगी",
            pluralBnPron = "নারঙ্গী",
            bnMeaning = "কমলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_758",
            category = VocabCategory.COLORS,
            singularTarget = "गुलाबी",
            singularBnPron = "গুলাবী",
            pluralTarget = "गुलाबी",
            pluralBnPron = "গুলাবী",
            bnMeaning = "গোলাপি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_759",
            category = VocabCategory.COLORS,
            singularTarget = "बैंगनी",
            singularBnPron = "বেগুনী",
            pluralTarget = "बैंगनी",
            pluralBnPron = "বেগুনী",
            bnMeaning = "বেগুনী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_760",
            category = VocabCategory.COLORS,
            singularTarget = "भूरा",
            singularBnPron = "ভূরা",
            pluralTarget = "भूरे",
            pluralBnPron = "ভূরে",
            bnMeaning = "বাদামী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_761",
            category = VocabCategory.COLORS,
            singularTarget = "स्लेटी / धूसर",
            singularBnPron = "স্লেটি",
            pluralTarget = "स्लेटी",
            pluralBnPron = "স্লেটি",
            bnMeaning = "ধূসর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_762",
            category = VocabCategory.COLORS,
            singularTarget = "सुनहरा",
            singularBnPron = "সুনহরা",
            pluralTarget = "सुनहरे",
            pluralBnPron = "সুনহরে",
            bnMeaning = "সোনালী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_763",
            category = VocabCategory.COLORS,
            singularTarget = "चाँदी जैसा / रुपहला",
            singularBnPron = "রূপহলা",
            pluralTarget = "रुपहला",
            pluralBnPron = "রূপহলা",
            bnMeaning = "রুপালী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_764",
            category = VocabCategory.COLORS,
            singularTarget = "आसमानी",
            singularBnPron = "আসমানী",
            pluralTarget = "आसमानी",
            pluralBnPron = "আসমানী",
            bnMeaning = "আকাশি নীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_765",
            category = VocabCategory.COLORS,
            singularTarget = "गहरा नीला",
            singularBnPron = "গহরা নীলা",
            pluralTarget = "गहरे नीले",
            pluralBnPron = "গহরে নীলে",
            bnMeaning = "গাঢ় নীল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_766",
            category = VocabCategory.COLORS,
            singularTarget = "रंग",
            singularBnPron = "রং",
            pluralTarget = "रंग",
            pluralBnPron = "রং",
            bnMeaning = "রং",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_767",
            category = VocabCategory.COLORS,
            singularTarget = "वृत्त / गोला",
            singularBnPron = "গোলা",
            pluralTarget = "गोले",
            pluralBnPron = "গোলে",
            bnMeaning = "বৃত্ত / গোলক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_768",
            category = VocabCategory.COLORS,
            singularTarget = "वर्ग / चौकोर",
            singularBnPron = "চকোর",
            pluralTarget = "चौकोर",
            pluralBnPron = "চকোর",
            bnMeaning = "বর্গক্ষেত্র / চৌকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_769",
            category = VocabCategory.COLORS,
            singularTarget = "त्रिभुज",
            singularBnPron = "ত্রিভুজ",
            pluralTarget = "त्रिभुज",
            pluralBnPron = "ত্রিভুজ",
            bnMeaning = "ত্রিভুজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_770",
            category = VocabCategory.COLORS,
            singularTarget = "आयत",
            singularBnPron = "আয়ত",
            pluralTarget = "आयत",
            pluralBnPron = "আয়ত",
            bnMeaning = "আয়তক্ষেত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_771",
            category = VocabCategory.COLORS,
            singularTarget = "अंडाकार",
            singularBnPron = "আন্ডাকার",
            pluralTarget = "अंडाकार",
            pluralBnPron = "আন্ডাকার",
            bnMeaning = "ডিম্বাকৃতি / ওভাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_772",
            category = VocabCategory.COLORS,
            singularTarget = "तारे का आकार",
            singularBnPron = "তারা আকার",
            pluralTarget = "आकार",
            pluralBnPron = "তারা আকার",
            bnMeaning = "তারা আকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_773",
            category = VocabCategory.COLORS,
            singularTarget = "दिल का आकार",
            singularBnPron = "দিল আকার",
            pluralTarget = "आकार",
            pluralBnPron = "দিল আকার",
            bnMeaning = "হৃদয় আকার / হার্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_774",
            category = VocabCategory.COLORS,
            singularTarget = "हीरे का आकार",
            singularBnPron = "হীরে আকার",
            pluralTarget = "आकार",
            pluralBnPron = "হীরে আকার",
            bnMeaning = "হীরক আকার / ডায়মন্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_775",
            category = VocabCategory.COLORS,
            singularTarget = "घन",
            singularBnPron = "ঘন",
            pluralTarget = "घन",
            pluralBnPron = "ঘন",
            bnMeaning = "ঘনক / কিউব",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_776",
            category = VocabCategory.COLORS,
            singularTarget = "गोला",
            singularBnPron = "গোলা",
            pluralTarget = "गोले",
            pluralBnPron = "গোলে",
            bnMeaning = "গোলক / স্ফিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_777",
            category = VocabCategory.COLORS,
            singularTarget = "बेलन",
            singularBnPron = "বেলন",
            pluralTarget = "बेलन",
            pluralBnPron = "বেলন",
            bnMeaning = "নলাকার / সিলিন্ডার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_778",
            category = VocabCategory.COLORS,
            singularTarget = "पिरामिड",
            singularBnPron = "পিরামিড",
            pluralTarget = "पिरामिड",
            pluralBnPron = "পিরামিড",
            bnMeaning = "পিরামিড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_779",
            category = VocabCategory.COLORS,
            singularTarget = "रेखा / लकीर",
            singularBnPron = "রেখা",
            pluralTarget = "रेखाएं",
            pluralBnPron = "রেখাএঁ",
            bnMeaning = "রেখা / লাইন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_780",
            category = VocabCategory.COLORS,
            singularTarget = "बिंदु / नुक्ता",
            singularBnPron = "বিন্দু",
            pluralTarget = "बिंदु",
            pluralBnPron = "বিন্দু",
            bnMeaning = "বিন্দু / ডট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_781",
            category = VocabCategory.COLORS,
            singularTarget = "कोना",
            singularBnPron = "কোনা",
            pluralTarget = "कोने",
            pluralBnPron = "কোনে",
            bnMeaning = "কোণ / কর্নার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_782",
            category = VocabCategory.COLORS,
            singularTarget = "केंद्र / बीच",
            singularBnPron = "কেন্দ্র",
            pluralTarget = "केंद्र",
            pluralBnPron = "কেন্দ্র",
            bnMeaning = "কেন্দ্র / মধ্যবিন্দু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_783",
            category = VocabCategory.COLORS,
            singularTarget = "किनारा",
            singularBnPron = "কিনারা",
            pluralTarget = "किनारे",
            pluralBnPron = "কিনারে",
            bnMeaning = "ধার / কিনারা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_784",
            category = VocabCategory.COLORS,
            singularTarget = "सीमा / किनारा",
            singularBnPron = "সীমা",
            pluralTarget = "सीमाएं",
            pluralBnPron = "সীমাএঁ",
            bnMeaning = "সীমানা / বর্ডার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_785",
            category = VocabCategory.COLORS,
            singularTarget = "धारी",
            singularBnPron = "ধারী",
            pluralTarget = "धारियां",
            pluralBnPron = "ধারিয়াঁ",
            bnMeaning = "ডোরা / দাগ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_786",
            category = VocabCategory.COLORS,
            singularTarget = "क्षैतिज",
            singularBnPron = "ক্ষিতিজ",
            pluralTarget = "क्षैतिज",
            pluralBnPron = "ক্ষিতিজ",
            bnMeaning = "আনুভূমিক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_787",
            category = VocabCategory.COLORS,
            singularTarget = "लंबवत / सीधा",
            singularBnPron = "লম্ববত",
            pluralTarget = "लंबवत",
            pluralBnPron = "লম্ববত",
            bnMeaning = "উলম্ব / খাড়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_788",
            category = VocabCategory.COLORS,
            singularTarget = "तिरछा",
            singularBnPron = "তিরছা",
            pluralTarget = "तिरछे",
            pluralBnPron = "তিরছে",
            bnMeaning = "তির্যক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_789",
            category = VocabCategory.COLORS,
            singularTarget = "आकार / रूप",
            singularBnPron = "আকার",
            pluralTarget = "आकार",
            pluralBnPron = "আকার",
            bnMeaning = "আকার / আকৃতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_790",
            category = VocabCategory.COLORS,
            singularTarget = "नाप / आकार",
            singularBnPron = "মাপ",
            pluralTarget = "नाप",
            pluralBnPron = "মাপ",
            bnMeaning = "মাপ / সাইজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_791",
            category = VocabCategory.COLORS,
            singularTarget = "पैटर्न / नमूना",
            singularBnPron = "নমুনা",
            pluralTarget = "नमूने",
            pluralBnPron = "নমুনে",
            bnMeaning = "নকশা / প্যাটার্ন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_792",
            category = VocabCategory.COLORS,
            singularTarget = "कोण",
            singularBnPron = "কোণ",
            pluralTarget = "कोण",
            pluralBnPron = "কোণ",
            bnMeaning = "কোণ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_793",
            category = VocabCategory.COLORS,
            singularTarget = "चमक",
            singularBnPron = "চমক",
            pluralTarget = "चमक",
            pluralBnPron = "চমক",
            bnMeaning = "উজ্জ্বলতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_794",
            category = VocabCategory.COLORS,
            singularTarget = "पारदर्शी",
            singularBnPron = "পারদর্শী",
            pluralTarget = "पारदर्शी",
            pluralBnPron = "পারদর্শী",
            bnMeaning = "স্বচ্ছ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_795",
            category = VocabCategory.COLORS,
            singularTarget = "अपारदर्शी",
            singularBnPron = "অপারদর্শী",
            pluralTarget = "अपारदर्शी",
            pluralBnPron = "অপারদর্শী",
            bnMeaning = "অস্বচ্ছ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_796",
            category = VocabCategory.COLORS,
            singularTarget = "गहरा",
            singularBnPron = "গহরা",
            pluralTarget = "गहरे",
            pluralBnPron = "গহরে",
            bnMeaning = "গভীর / গাঢ়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_797",
            category = VocabCategory.COLORS,
            singularTarget = "हल्का / फीका",
            singularBnPron = "হালকা",
            pluralTarget = "हल्के",
            pluralBnPron = "হালকা",
            bnMeaning = "হালকা / ফিকে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_798",
            category = VocabCategory.COLORS,
            singularTarget = "चमकदार",
            singularBnPron = "চমকদার",
            pluralTarget = "चमकदार",
            pluralBnPron = "চমকদার",
            bnMeaning = "চকচকে / উজ্জ্বল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_799",
            category = VocabCategory.COLORS,
            singularTarget = "रंगीन",
            singularBnPron = "রঙ্গীন",
            pluralTarget = "रंगीन",
            pluralBnPron = "রঙ্গীন",
            bnMeaning = "রঙিন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_800",
            category = VocabCategory.COLORS,
            singularTarget = "बेरंग",
            singularBnPron = "বেরং",
            pluralTarget = "बेरंग",
            pluralBnPron = "বেরং",
            bnMeaning = "রংহীন / বর্ণহীন",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk9 = listOf(
        VocabItem(
            id = "hi_vocab_801",
            category = VocabCategory.KITCHEN,
            singularTarget = "रसोईघर",
            singularBnPron = "রসোইঘর",
            pluralTarget = "रसोईघर",
            pluralBnPron = "রসোইঘর",
            bnMeaning = "রান্নাঘর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_802",
            category = VocabCategory.KITCHEN,
            singularTarget = "चूल्हा",
            singularBnPron = "চুলহা",
            pluralTarget = "चूल्हे",
            pluralBnPron = "চুলহে",
            bnMeaning = "চুলা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_803",
            category = VocabCategory.KITCHEN,
            singularTarget = "ओवन",
            singularBnPron = "ওভেন",
            pluralTarget = "ओवन",
            pluralBnPron = "ওভেন",
            bnMeaning = "ওভেন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_804",
            category = VocabCategory.KITCHEN,
            singularTarget = "फ्रिज",
            singularBnPron = "ফ্রিজ",
            pluralTarget = "फ्रिज",
            pluralBnPron = "ফ্রিজ",
            bnMeaning = "রেফ্রিজারেটর / ফ্রিজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_805",
            category = VocabCategory.KITCHEN,
            singularTarget = "माइक्रोवेव",
            singularBnPron = "মাইক্রোওয়েভ",
            pluralTarget = "माइक्रोवेव",
            pluralBnPron = "মাইক্রোওয়েভ",
            bnMeaning = "মাইক্রোওয়েভ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_806",
            category = VocabCategory.KITCHEN,
            singularTarget = "ब्लेंडर / मिक्सी",
            singularBnPron = "মিক্সি",
            pluralTarget = "मिक्सी",
            pluralBnPron = "মিক্সি",
            bnMeaning = "ব্লেন্ডার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_807",
            category = VocabCategory.KITCHEN,
            singularTarget = "केतली",
            singularBnPron = "কেতলী",
            pluralTarget = "केतलियां",
            pluralBnPron = "কেতলীয়াঁ",
            bnMeaning = "কেটলি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_808",
            category = VocabCategory.KITCHEN,
            singularTarget = "पतीला / बर्तन",
            singularBnPron = "পতীলা",
            pluralTarget = "पतीले",
            pluralBnPron = "পতীলে",
            bnMeaning = "রান্নার পাত্র / পাতিল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_809",
            category = VocabCategory.KITCHEN,
            singularTarget = "कड़ाही / पैन",
            singularBnPron = "কড়াই",
            pluralTarget = "कड़ाहियां",
            pluralBnPron = "কড়াই",
            bnMeaning = "কড়াই / ফ্রাইপ্যান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_810",
            category = VocabCategory.KITCHEN,
            singularTarget = "प्रेशर कुकर",
            singularBnPron = "প্রেশার কুকার",
            pluralTarget = "प्रेशर कुकर",
            pluralBnPron = "প্রেশার কুকার",
            bnMeaning = "প্রেশার কুকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_811",
            category = VocabCategory.KITCHEN,
            singularTarget = "चाकू",
            singularBnPron = "চাকু",
            pluralTarget = "चाकू",
            pluralBnPron = "চাকু",
            bnMeaning = "ছুরি / চাকু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_812",
            category = VocabCategory.KITCHEN,
            singularTarget = "चम्मच",
            singularBnPron = "চামচ",
            pluralTarget = "चम्मच",
            pluralBnPron = "চামচ",
            bnMeaning = "চামচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_813",
            category = VocabCategory.KITCHEN,
            singularTarget = "काँटा",
            singularBnPron = "কাঁটা",
            pluralTarget = "काँटे",
            pluralBnPron = "কাঁটে",
            bnMeaning = "কাঁটা চামচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_814",
            category = VocabCategory.KITCHEN,
            singularTarget = "छोटा चम्मच",
            singularBnPron = "ছোটা চামচ",
            pluralTarget = "चम्मच",
            pluralBnPron = "ছোটা চামচ",
            bnMeaning = "চা চামচ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_815",
            category = VocabCategory.KITCHEN,
            singularTarget = "चॉपस्टिक",
            singularBnPron = "চপস্টিক",
            pluralTarget = "चॉपस्टिक",
            pluralBnPron = "চপস্টিক",
            bnMeaning = "চপস্টিক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_816",
            category = VocabCategory.KITCHEN,
            singularTarget = "थाली / प्लेट",
            singularBnPron = "থালী",
            pluralTarget = "थालियां",
            pluralBnPron = "থালীয়াঁ",
            bnMeaning = "থালা / প্লেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_817",
            category = VocabCategory.KITCHEN,
            singularTarget = "कटोरा",
            singularBnPron = "কটোরা",
            pluralTarget = "कटोरे",
            pluralBnPron = "কটোরে",
            bnMeaning = "বাটি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_818",
            category = VocabCategory.KITCHEN,
            singularTarget = "कप / प्याला",
            singularBnPron = "কাপ",
            pluralTarget = "कप",
            pluralBnPron = "কাপ",
            bnMeaning = "কাপ / পেয়ালা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_819",
            category = VocabCategory.KITCHEN,
            singularTarget = "गिलास",
            singularBnPron = "গিলাস",
            pluralTarget = "गिलास",
            pluralBnPron = "গিলাস",
            bnMeaning = "কাচের গ্লাস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_820",
            category = VocabCategory.KITCHEN,
            singularTarget = "मग",
            singularBnPron = "মগ",
            pluralTarget = "मग",
            pluralBnPron = "মগ",
            bnMeaning = "মগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_821",
            category = VocabCategory.KITCHEN,
            singularTarget = "बोतल",
            singularBnPron = "বোতল",
            pluralTarget = "बोतलें",
            pluralBnPron = "বোতলেঁ",
            bnMeaning = "বোতল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_822",
            category = VocabCategory.KITCHEN,
            singularTarget = "जग",
            singularBnPron = "জগ",
            pluralTarget = "जग",
            pluralBnPron = "জগ",
            bnMeaning = "জগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_823",
            category = VocabCategory.KITCHEN,
            singularTarget = "ट्रे",
            singularBnPron = "ট্রে",
            pluralTarget = "ट्रे",
            pluralBnPron = "ট্রে",
            bnMeaning = "ট্রে",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_824",
            category = VocabCategory.KITCHEN,
            singularTarget = "ढक्कन",
            singularBnPron = "ঢাক্কন",
            pluralTarget = "ढक्कन",
            pluralBnPron = "ঢাক্কন",
            bnMeaning = "ঢাকনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_825",
            category = VocabCategory.KITCHEN,
            singularTarget = "छीलने वाला चाकू",
            singularBnPron = "চাকু",
            pluralTarget = "चाकू",
            pluralBnPron = "চাকু",
            bnMeaning = "খোসা ছাড়ানোর ছুরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_826",
            category = VocabCategory.KITCHEN,
            singularTarget = "कद्दूकस",
            singularBnPron = "কদ্দুকস",
            pluralTarget = "कद्दूकस",
            pluralBnPron = "কদ্দুকস",
            bnMeaning = "গ্রেটার / ঝাঁঝরি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_827",
            category = VocabCategory.KITCHEN,
            singularTarget = "मथनी / फेंटनी",
            singularBnPron = "মথনীত",
            pluralTarget = "मथनी",
            pluralBnPron = "মথনী",
            bnMeaning = "ডালঘুটনি / হুইস্ক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_828",
            category = VocabCategory.KITCHEN,
            singularTarget = "बेलन",
            singularBnPron = "বেলন",
            pluralTarget = "बेलन",
            pluralBnPron = "বেলন",
            bnMeaning = "বেলন (রুটি বেলার)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_829",
            category = VocabCategory.KITCHEN,
            singularTarget = "छलनी",
            singularBnPron = "ছলনী",
            pluralTarget = "छलनियां",
            pluralBnPron = "ছলনীয়াঁ",
            bnMeaning = "ছাঁকনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_830",
            category = VocabCategory.KITCHEN,
            singularTarget = "कटिंग बोर्ड",
            singularBnPron = "কাটিং বোর্ড",
            pluralTarget = "कटिंग बोर्ड",
            pluralBnPron = "কাটিং বোর্ড",
            bnMeaning = "চপিং বোর্ড / কাটার বোর্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_831",
            category = VocabCategory.KITCHEN,
            singularTarget = "एप्रन",
            singularBnPron = "অ্যাপ্রন",
            pluralTarget = "एप्रन",
            pluralBnPron = "অ্যাপ্রন",
            bnMeaning = "অ্যাপ্রন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_832",
            category = VocabCategory.KITCHEN,
            singularTarget = "रसोई का तौलिया",
            singularBnPron = "তৌলিয়া",
            pluralTarget = "तौलिये",
            pluralBnPron = "তৌলিয়ে",
            bnMeaning = "থালাবাসন মোছার তোয়ালে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_833",
            category = VocabCategory.KITCHEN,
            singularTarget = "स्पंज",
            singularBnPron = "স্পঞ্জ",
            pluralTarget = "स्पंज",
            pluralBnPron = "স্পঞ্জ",
            bnMeaning = "স্পঞ্জ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_834",
            category = VocabCategory.KITCHEN,
            singularTarget = "बर्तन धोने का साबुन",
            singularBnPron = "সাবুন",
            pluralTarget = "साबुन",
            pluralBnPron = "সাবুন",
            bnMeaning = "থালাবাসন ধোয়ার সাবান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_835",
            category = VocabCategory.KITCHEN,
            singularTarget = "सिंक",
            singularBnPron = "সিঙ্ক",
            pluralTarget = "सिंक",
            pluralBnPron = "সিঙ্ক",
            bnMeaning = "সিঙ্ক / বেসিন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_836",
            category = VocabCategory.KITCHEN,
            singularTarget = "नल",
            singularBnPron = "নল",
            pluralTarget = "नल",
            pluralBnPron = "নল",
            bnMeaning = "কল / ট্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_837",
            category = VocabCategory.KITCHEN,
            singularTarget = "माचिस",
            singularBnPron = "মাচিস",
            pluralTarget = "माचिस",
            pluralBnPron = "মাচিস",
            bnMeaning = "দেশলাই / ম্যাচ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_838",
            category = VocabCategory.KITCHEN,
            singularTarget = "लाइटर",
            singularBnPron = "লাইটার",
            pluralTarget = "लाइटर",
            pluralBnPron = "লাইটার",
            bnMeaning = "লাইটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_839",
            category = VocabCategory.KITCHEN,
            singularTarget = "नमकदानी",
            singularBnPron = "নমকদানী",
            pluralTarget = "नमकदानियां",
            pluralBnPron = "নমকদানী",
            bnMeaning = "লবণদানি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_840",
            category = VocabCategory.KITCHEN,
            singularTarget = "काली मिर्च दानी",
            singularBnPron = "দানী",
            pluralTarget = "दानी",
            pluralBnPron = "দানী",
            bnMeaning = "গোলমরিচের দানি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_841",
            category = VocabCategory.KITCHEN,
            singularTarget = "मसाले का डिब्बा",
            singularBnPron = "মসলা ডিব্বা",
            pluralTarget = "डिब्बे",
            pluralBnPron = "মসলা ডিব্বে",
            bnMeaning = "মসলার বৈয়াম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_842",
            category = VocabCategory.KITCHEN,
            singularTarget = "तेल की बोतल",
            singularBnPron = "তেল কি বোতল",
            pluralTarget = "बोतलें",
            pluralBnPron = "বোতলেঁ",
            bnMeaning = "তেলের বোতল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_843",
            category = VocabCategory.KITCHEN,
            singularTarget = "टिफ़िन डिब्बा",
            singularBnPron = "টিফিন",
            pluralTarget = "डिब्बे",
            pluralBnPron = "টিফিন",
            bnMeaning = "টিফিন বক্স / লাঞ্চ বক্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_844",
            category = VocabCategory.KITCHEN,
            singularTarget = "थर्मस",
            singularBnPron = "থার্মাস",
            pluralTarget = "थर्मस",
            pluralBnPron = "থার্মাস",
            bnMeaning = "থার্মাস / ফ্লাস্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_845",
            category = VocabCategory.KITCHEN,
            singularTarget = "स्ट्रॉ / नली",
            singularBnPron = "স্ট্র",
            pluralTarget = "नलियां",
            pluralBnPron = "স্ট্র",
            bnMeaning = "স্ট্র / নালী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_846",
            category = VocabCategory.KITCHEN,
            singularTarget = "नेपकिन",
            singularBnPron = "ন্যাপকিন",
            pluralTarget = "नेपकिन",
            pluralBnPron = "ন্যাপকিন",
            bnMeaning = "ন্যাপকিন / টিস্যু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_847",
            category = VocabCategory.KITCHEN,
            singularTarget = "तसली / परात",
            singularBnPron = "তসলা",
            pluralTarget = "परातें",
            pluralBnPron = "তসলে",
            bnMeaning = "গামলা / তশতরী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_848",
            category = VocabCategory.KITCHEN,
            singularTarget = "कैन ओपनर",
            singularBnPron = "ক্যান ওপেনার",
            pluralTarget = "ओपनर",
            pluralBnPron = "ক্যান ওপেনার",
            bnMeaning = "ক্যান ওপেনার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_849",
            category = VocabCategory.KITCHEN,
            singularTarget = "पलटा / खुरपी",
            singularBnPron = "পলটা",
            pluralTarget = "पलटे",
            pluralBnPron = "পলটে",
            bnMeaning = "কর্ণধার / করাতল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_850",
            category = VocabCategory.KITCHEN,
            singularTarget = "कीप",
            singularBnPron = "কীপ",
            pluralTarget = "कीप",
            pluralBnPron = "কীপ",
            bnMeaning = "ফানেল / চোঙা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_851",
            category = VocabCategory.SHOPPING,
            singularTarget = "खरीदारी",
            singularBnPron = "খরীদারী",
            pluralTarget = "खरीदारी",
            pluralBnPron = "খরীদারী",
            bnMeaning = "কেনাকাটা / শপিং",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_852",
            category = VocabCategory.SHOPPING,
            singularTarget = "दुकानदार",
            singularBnPron = "দোকানদার",
            pluralTarget = "दुकानदार",
            pluralBnPron = "দোকানদার",
            bnMeaning = "দোকানদার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_853",
            category = VocabCategory.SHOPPING,
            singularTarget = "शॉपिंग मॉल",
            singularBnPron = "শপিং মল",
            pluralTarget = "मॉल",
            pluralBnPron = "শপিং মল",
            bnMeaning = "শপিং মল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_854",
            category = VocabCategory.SHOPPING,
            singularTarget = "पैसा / धन",
            singularBnPron = "পয়সা",
            pluralTarget = "पैसे",
            pluralBnPron = "পয়সে",
            bnMeaning = "টাকা / অর্থ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_855",
            category = VocabCategory.SHOPPING,
            singularTarget = "सिक्का",
            singularBnPron = "সিল্কা",
            pluralTarget = "सिक्के",
            pluralBnPron = "সিল্কে",
            bnMeaning = "মুদ্রা / কয়েন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_856",
            category = VocabCategory.SHOPPING,
            singularTarget = "नोट",
            singularBnPron = "নোট",
            pluralTarget = "नोट",
            pluralBnPron = "নোট",
            bnMeaning = "নোট / কাগজের টাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_857",
            category = VocabCategory.SHOPPING,
            singularTarget = "दाम / कीमत",
            singularBnPron = "কীমত",
            pluralTarget = "कीमतें",
            pluralBnPron = "কীমতেঁ",
            bnMeaning = "মূল্য / দাম",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_858",
            category = VocabCategory.SHOPPING,
            singularTarget = "लागत / खर्च",
            singularBnPron = "খরচ",
            pluralTarget = "खर्च",
            pluralBnPron = "খরচ",
            bnMeaning = "খরচ / ব্যয়",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_859",
            category = VocabCategory.SHOPPING,
            singularTarget = "छूट",
            singularBnPron = "ছুট",
            pluralTarget = "छूट",
            pluralBnPron = "ছুট",
            bnMeaning = "মূল্যছাড় / ডিসকাউন্ট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_860",
            category = VocabCategory.SHOPPING,
            singularTarget = "बिक्री / सेल",
            singularBnPron = "বিক্রি",
            pluralTarget = "बिक्री",
            pluralBnPron = "বিক্রি",
            bnMeaning = "বিক্রি / সেল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_861",
            category = VocabCategory.SHOPPING,
            singularTarget = "रसीद",
            singularBnPron = "রসীদ",
            pluralTarget = "रसीदें",
            pluralBnPron = "রসীদেঁ",
            bnMeaning = "রশিদ / রিসিট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_862",
            category = VocabCategory.SHOPPING,
            singularTarget = "बिल",
            singularBnPron = "বিল",
            pluralTarget = "बिल",
            pluralBnPron = "বিল",
            bnMeaning = "বিল / চালান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_863",
            category = VocabCategory.SHOPPING,
            singularTarget = "कैशियर / खजांची",
            singularBnPron = "ক্যাশিয়ার",
            pluralTarget = "कैशियर",
            pluralBnPron = "ক্যাশিয়ার",
            bnMeaning = "ক্যাশিয়ার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_864",
            category = VocabCategory.SHOPPING,
            singularTarget = "थैला / बैग",
            singularBnPron = "থৈলা",
            pluralTarget = "थैले",
            pluralBnPron = "থৈলে",
            bnMeaning = "বাজারের থলে / ব্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_865",
            category = VocabCategory.SHOPPING,
            singularTarget = "ट्रॉली",
            singularBnPron = "ট্রলি",
            pluralTarget = "ट्रॉलियां",
            pluralBnPron = "ট্রলি",
            bnMeaning = "শপিং ট্রলি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_866",
            category = VocabCategory.SHOPPING,
            singularTarget = "टोकरी",
            singularBnPron = "টোকরী",
            pluralTarget = "टोकरियां",
            pluralBnPron = "টোকরীয়াঁ",
            bnMeaning = "ঝুড়ি / বাস্কেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_867",
            category = VocabCategory.SHOPPING,
            singularTarget = "भुगतान",
            singularBnPron = "ভুগতান",
            pluralTarget = "भुगतान",
            pluralBnPron = "ভুগতান",
            bnMeaning = "পরিশোধ / পেমেন্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_868",
            category = VocabCategory.SHOPPING,
            singularTarget = "क्रेडिट कार्ड",
            singularBnPron = "ক্রেডিট কার্ড",
            pluralTarget = "क्रेडिट कार्ड",
            pluralBnPron = "ক্রেডিট কার্ড",
            bnMeaning = "ক্রেডিট কার্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_869",
            category = VocabCategory.SHOPPING,
            singularTarget = "छुट्टे पैसे / खुले",
            singularBnPron = "ছুট্টে",
            pluralTarget = "खुले",
            pluralBnPron = "ছুট্টে",
            bnMeaning = "খুচরা টাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_870",
            category = VocabCategory.SHOPPING,
            singularTarget = "कर्ज़ / ऋण",
            singularBnPron = "কর্জ",
            pluralTarget = "कर्ज़",
            pluralBnPron = "কর্জ",
            bnMeaning = "ঋণ / ধার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_871",
            category = VocabCategory.SHOPPING,
            singularTarget = "कर / टैक्स",
            singularBnPron = "ট্যাক্স",
            pluralTarget = "कर",
            pluralBnPron = "ট্যাক্স",
            bnMeaning = "কর / ট্যাক্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_872",
            category = VocabCategory.SHOPPING,
            singularTarget = "मोलभाव",
            singularBnPron = "মোলভাব",
            pluralTarget = "मोलभाव",
            pluralBnPron = "মোলভাব",
            bnMeaning = "দরদাম / দরকষাকষি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_873",
            category = VocabCategory.SHOPPING,
            singularTarget = "गुणवत्ता / क्वालिटी",
            singularBnPron = "গুণবত্তা",
            pluralTarget = "गुणवत्ता",
            pluralBnPron = "গুণবত্তা",
            bnMeaning = "গুণমান / মান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_874",
            category = VocabCategory.SHOPPING,
            singularTarget = "मात्रा / परिमाण",
            singularBnPron = "মাত্রা",
            pluralTarget = "मात्रा",
            pluralBnPron = "মাত্রা",
            bnMeaning = "পরিমাণ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_875",
            category = VocabCategory.SHOPPING,
            singularTarget = "ब्रांड",
            singularBnPron = "ব্র্যান্ড",
            pluralTarget = "ब्रांड",
            pluralBnPron = "ব্র্যান্ড",
            bnMeaning = "ব্র্যান্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_876",
            category = VocabCategory.SHOPPING,
            singularTarget = "वारंटी",
            singularBnPron = "ওয়ারেন্টি",
            pluralTarget = "वारंटी",
            pluralBnPron = "ওয়ারেন্টি",
            bnMeaning = "ওয়ারেন্টি / গ্যারান্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_877",
            category = VocabCategory.SHOPPING,
            singularTarget = "वापसी / बदलना",
            singularBnPron = "ওয়াপসী",
            pluralTarget = "वापसी",
            pluralBnPron = "ওয়াপসী",
            bnMeaning = "ফেরত / বদল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_878",
            category = VocabCategory.SHOPPING,
            singularTarget = "कैश काउंटर",
            singularBnPron = "ক্যাশ কাউন্টার",
            pluralTarget = "काउंटर",
            pluralBnPron = "ক্যাশ কাউন্টার",
            bnMeaning = "ক্যাশ কাউন্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_879",
            category = VocabCategory.SHOPPING,
            singularTarget = "ऑनलाइन शॉपिंग",
            singularBnPron = "অনলাইন শপিং",
            pluralTarget = "शॉपिंग",
            pluralBnPron = "অনলাইন শপিং",
            bnMeaning = "অনলাইন কেনাকাটা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_880",
            category = VocabCategory.SHOPPING,
            singularTarget = "डिलीवरी / सुपुर्दगी",
            singularBnPron = "ডেলিভারি",
            pluralTarget = "डिलीवरी",
            pluralBnPron = "ডেলিভারি",
            bnMeaning = "হোম ডেলিভারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_881",
            category = VocabCategory.SHOPPING,
            singularTarget = "पार्सल / पैकेट",
            singularBnPron = "পার্সেল",
            pluralTarget = "पार्सल",
            pluralBnPron = "পার্সেল",
            bnMeaning = "প্যাকেট / পার্সেল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_882",
            category = VocabCategory.SHOPPING,
            singularTarget = "ऑर्डर / आदेश",
            singularBnPron = "অর্ডার",
            pluralTarget = "ऑर्डर",
            pluralBnPron = "অর্ডার",
            bnMeaning = "অর্ডার / ফরমাশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_883",
            category = VocabCategory.SHOPPING,
            singularTarget = "दाम का टैग",
            singularBnPron = "দামের ট্যাগ",
            pluralTarget = "टैग",
            pluralBnPron = "দামের ট্যাগ",
            bnMeaning = "মূল্যতালিকা / দামের ট্যাগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_884",
            category = VocabCategory.SHOPPING,
            singularTarget = "मुद्रा",
            singularBnPron = "মুদ্রা",
            pluralTarget = "मुद्राएं",
            pluralBnPron = "মুদ্রাএঁ",
            bnMeaning = "মুদ্রা / কারেন্সি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_885",
            category = VocabCategory.SHOPPING,
            singularTarget = "डॉलर",
            singularBnPron = "ডলার",
            pluralTarget = "डॉलर",
            pluralBnPron = "ডলার",
            bnMeaning = "ডলার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_886",
            category = VocabCategory.SHOPPING,
            singularTarget = "यूरो",
            singularBnPron = "ইউরো",
            pluralTarget = "यूरो",
            pluralBnPron = "ইউরো",
            bnMeaning = "ইউরো",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_887",
            category = VocabCategory.SHOPPING,
            singularTarget = "रुपया",
            singularBnPron = "রুপিয়া",
            pluralTarget = "रुपये",
            pluralBnPron = "রুপিয়ে",
            bnMeaning = "রুপি / টাকা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_888",
            category = VocabCategory.SHOPPING,
            singularTarget = "येन",
            singularBnPron = "ইয়েন",
            pluralTarget = "येन",
            pluralBnPron = "ইয়েন",
            bnMeaning = "ইয়েন (জাপানি মুদ্রা)",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_889",
            category = VocabCategory.SHOPPING,
            singularTarget = "नकद",
            singularBnPron = "নগদ",
            pluralTarget = "नकद",
            pluralBnPron = "নগদ",
            bnMeaning = "নগদ টাকা / ক্যাশ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_890",
            category = VocabCategory.SHOPPING,
            singularTarget = "उधार / साख",
            singularBnPron = "উধার",
            pluralTarget = "उधार",
            pluralBnPron = "উধার",
            bnMeaning = "ক্রেডিট / বাকি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_891",
            category = VocabCategory.SHOPPING,
            singularTarget = "बचत",
            singularBnPron = "বচত",
            pluralTarget = "बचत",
            pluralBnPron = "বচত",
            bnMeaning = "সঞ্চয় / সেভিংস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_892",
            category = VocabCategory.SHOPPING,
            singularTarget = "मुनाफ़ा / लाभ",
            singularBnPron = "মুনাফা",
            pluralTarget = "मुनाफ़ा",
            pluralBnPron = "মুনাফা",
            bnMeaning = "লাভ / মুনাফা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_893",
            category = VocabCategory.SHOPPING,
            singularTarget = "नुकसान / हानि",
            singularBnPron = "নুকসান",
            pluralTarget = "नुकसान",
            pluralBnPron = "নুকসান",
            bnMeaning = "ক্ষতি / লোকসান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_894",
            category = VocabCategory.SHOPPING,
            singularTarget = "विज्ञापन",
            singularBnPron = "বিজ্ঞাপন",
            pluralTarget = "विज्ञापन",
            pluralBnPron = "বিজ্ঞাপন",
            bnMeaning = "বিজ্ঞাপন / অ্যাড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_895",
            category = VocabCategory.SHOPPING,
            singularTarget = "नमूना",
            singularBnPron = "নমুনা",
            pluralTarget = "नमूने",
            pluralBnPron = "নমুনে",
            bnMeaning = "নমুনা / স্যাম্পল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_896",
            category = VocabCategory.SHOPPING,
            singularTarget = "स्टॉक / गोदाम",
            singularBnPron = "স্টক",
            pluralTarget = "स्टॉक",
            pluralBnPron = "স্টক",
            bnMeaning = "স্টক / মজুত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_897",
            category = VocabCategory.SHOPPING,
            singularTarget = "विक्रेता / बेचने वाला",
            singularBnPron = "বিক্রেতা",
            pluralTarget = "विक्रेता",
            pluralBnPron = "বিক্রেতা",
            bnMeaning = "বিক্রেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_898",
            category = VocabCategory.SHOPPING,
            singularTarget = "खरीदार",
            singularBnPron = "খরীদার",
            pluralTarget = "खरीदार",
            pluralBnPron = "খরীদার",
            bnMeaning = "ক্রেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_899",
            category = VocabCategory.SHOPPING,
            singularTarget = "आयात",
            singularBnPron = "আমদানি",
            pluralTarget = "आयात",
            pluralBnPron = "আমদানি",
            bnMeaning = "আমদানি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_900",
            category = VocabCategory.SHOPPING,
            singularTarget = "निर्यात",
            singularBnPron = "রপ্তানি",
            pluralTarget = "निर्यात",
            pluralBnPron = "রপ্তানি",
            bnMeaning = "রপ্তানি",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    private val chunk10 = listOf(
        VocabItem(
            id = "hi_vocab_901",
            category = VocabCategory.TECH,
            singularTarget = "कंप्यूटर",
            singularBnPron = "কম্পিউটার",
            pluralTarget = "कंप्यूटर",
            pluralBnPron = "কম্পিউটার",
            bnMeaning = "কম্পিউটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_902",
            category = VocabCategory.TECH,
            singularTarget = "लैपटॉप",
            singularBnPron = "ল্যাপটপ",
            pluralTarget = "लैपटॉप",
            pluralBnPron = "ল্যাপটপ",
            bnMeaning = "ল্যাপটপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_903",
            category = VocabCategory.TECH,
            singularTarget = "मोबाइल / स्मार्टफोन",
            singularBnPron = "মোবাইল",
            pluralTarget = "मोबाइल",
            pluralBnPron = "মোবাইল",
            bnMeaning = "মোবাইল ফোন / স্মার্টফোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_904",
            category = VocabCategory.TECH,
            singularTarget = "टैबलेट",
            singularBnPron = "ট্যাবলেট",
            pluralTarget = "टैबलेट",
            pluralBnPron = "ট্যাবলেট",
            bnMeaning = "ট্যাবলেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_905",
            category = VocabCategory.TECH,
            singularTarget = "स्क्रीन / पर्दा",
            singularBnPron = "স্ক্রিন",
            pluralTarget = "स्क्रीन",
            pluralBnPron = "স্ক্রিন",
            bnMeaning = "পর্দা / স্ক্রিন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_906",
            category = VocabCategory.TECH,
            singularTarget = "कीबोर्ड",
            singularBnPron = "কীবোর্ড",
            pluralTarget = "कीबोर्ड",
            pluralBnPron = "কীবোর্ড",
            bnMeaning = "কীবোর্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_907",
            category = VocabCategory.TECH,
            singularTarget = "माउस",
            singularBnPron = "মাউস",
            pluralTarget = "माउस",
            pluralBnPron = "মাউস",
            bnMeaning = "মাউস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_908",
            category = VocabCategory.TECH,
            singularTarget = "प्रिंटर",
            singularBnPron = "প্রিন্টার",
            pluralTarget = "प्रिंटर",
            pluralBnPron = "প্রিন্টার",
            bnMeaning = "প্রিন্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_909",
            category = VocabCategory.TECH,
            singularTarget = "कैमरा",
            singularBnPron = "ক্যামেরা",
            pluralTarget = "कैमरे",
            pluralBnPron = "ক্যামেরা",
            bnMeaning = "ক্যামেরা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_910",
            category = VocabCategory.TECH,
            singularTarget = "स्पीकर",
            singularBnPron = "স্পিকার",
            pluralTarget = "स्पीकर",
            pluralBnPron = "স্পিকার",
            bnMeaning = "লাউডস্পিকার / স্পিকার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_911",
            category = VocabCategory.TECH,
            singularTarget = "हेडफ़ोन",
            singularBnPron = "হেডফোন",
            pluralTarget = "हेडफ़ोन",
            pluralBnPron = "হেডফোন",
            bnMeaning = "হেডফোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_912",
            category = VocabCategory.TECH,
            singularTarget = "माइक्रोफ़ोन",
            singularBnPron = "মাইক্রোফোন",
            pluralTarget = "माइक्रोफ़ोन",
            pluralBnPron = "মাইক্রোফোন",
            bnMeaning = "মাইক্রোফোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_913",
            category = VocabCategory.TECH,
            singularTarget = "चार्जर",
            singularBnPron = "চার্জার",
            pluralTarget = "चार्जर",
            pluralBnPron = "চার্জার",
            bnMeaning = "চার্জার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_914",
            category = VocabCategory.TECH,
            singularTarget = "केबल / तार",
            singularBnPron = "তার",
            pluralTarget = "तारें",
            pluralBnPron = "তার",
            bnMeaning = "তার / কেবল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_915",
            category = VocabCategory.TECH,
            singularTarget = "बैटरी",
            singularBnPron = "ব্যাটারি",
            pluralTarget = "बैटरियां",
            pluralBnPron = "ব্যাটারিয়াঁ",
            bnMeaning = "ব্যাটারি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_916",
            category = VocabCategory.TECH,
            singularTarget = "पावर बैंक",
            singularBnPron = "পাওয়ার ব্যাংক",
            pluralTarget = "पावर बैंक",
            pluralBnPron = "পাওয়ার ব্যাংক",
            bnMeaning = "পাওয়ার ব্যাংক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_917",
            category = VocabCategory.TECH,
            singularTarget = "पेन ड्राइव",
            singularBnPron = "পেন ড্রাইভ",
            pluralTarget = "पेन ड्राइव",
            pluralBnPron = "পেন ড্রাইভ",
            bnMeaning = "পেনড্রাইভ / ইউএসবি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_918",
            category = VocabCategory.TECH,
            singularTarget = "हार्ड ड्राइव",
            singularBnPron = "হার্ড ড্রাইভ",
            pluralTarget = "हार्ड ड्राइव",
            pluralBnPron = "হার্ড ড্রাইভ",
            bnMeaning = "হার্ডডিস্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_919",
            category = VocabCategory.TECH,
            singularTarget = "वाई-फ़ाई",
            singularBnPron = "ওয়াইফাই",
            pluralTarget = "वाई-फ़ाई",
            pluralBnPron = "ওয়াইফাই",
            bnMeaning = "ওয়াইফাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_920",
            category = VocabCategory.TECH,
            singularTarget = "इंटरनेट",
            singularBnPron = "ইন্টারনেট",
            pluralTarget = "इंटरनेट",
            pluralBnPron = "ইন্টারনেট",
            bnMeaning = "ইন্টারনেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_921",
            category = VocabCategory.TECH,
            singularTarget = "नेटवर्क",
            singularBnPron = "নেটওয়ার্ক",
            pluralTarget = "नेटवर्क",
            pluralBnPron = "নেটওয়ার্ক",
            bnMeaning = "নেটওয়ার্ক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_922",
            category = VocabCategory.TECH,
            singularTarget = "वेबसाइट",
            singularBnPron = "ওয়েবসাইট",
            pluralTarget = "वेबसाइटें",
            pluralBnPron = "ওয়েবসাইটেঁ",
            bnMeaning = "ওয়েবসাইট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_923",
            category = VocabCategory.TECH,
            singularTarget = "ईमेल",
            singularBnPron = "ইমেইল",
            pluralTarget = "ईमेल",
            pluralBnPron = "ইমেইল",
            bnMeaning = "ইমেইল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_924",
            category = VocabCategory.TECH,
            singularTarget = "संदेश / मैसेज",
            singularBnPron = "সন্দেশ",
            pluralTarget = "संदेश",
            pluralBnPron = "সন্দেশ",
            bnMeaning = "বার্তা / মেসেজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_925",
            category = VocabCategory.TECH,
            singularTarget = "फ़ोन कॉल",
            singularBnPron = "ফোন কল",
            pluralTarget = "कॉल",
            pluralBnPron = "ফোন কল",
            bnMeaning = "ফোন কল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_926",
            category = VocabCategory.TECH,
            singularTarget = "पासवर्ड",
            singularBnPron = "পাসওয়ার্ড",
            pluralTarget = "पासवर्ड",
            pluralBnPron = "পাসওয়ার্ড",
            bnMeaning = "পাসওয়ার্ড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_927",
            category = VocabCategory.TECH,
            singularTarget = "यूज़रनेम",
            singularBnPron = "ইউজারনেম",
            pluralTarget = "यूज़रनेम",
            pluralBnPron = "ইউজারনেম",
            bnMeaning = "ব্যবহারকারীর নাম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_928",
            category = VocabCategory.TECH,
            singularTarget = "खाता / अकाउंट",
            singularBnPron = "খাতা",
            pluralTarget = "खाते",
            pluralBnPron = "খাতে",
            bnMeaning = "হিসাব / অ্যাকাউন্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_929",
            category = VocabCategory.TECH,
            singularTarget = "ऐप",
            singularBnPron = "অ্যাপ",
            pluralTarget = "ऐप",
            pluralBnPron = "অ্যাপ",
            bnMeaning = "অ্যাপ্লিকেশন / অ্যাপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_930",
            category = VocabCategory.TECH,
            singularTarget = "सॉफ्टवेयर",
            singularBnPron = "সফটওয়্যার",
            pluralTarget = "सॉफ्टवेयर",
            pluralBnPron = "সফটওয়্যার",
            bnMeaning = "সফটওয়্যার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_931",
            category = VocabCategory.TECH,
            singularTarget = "फ़ाइल",
            singularBnPron = "ফাইল",
            pluralTarget = "फ़ाइलें",
            pluralBnPron = "ফাইলেঁ",
            bnMeaning = "নথি / ফাইল",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_932",
            category = VocabCategory.TECH,
            singularTarget = "फ़ोल्डर",
            singularBnPron = "ফোল্ডার",
            pluralTarget = "फ़ोल्डर",
            pluralBnPron = "ফোল্ডার",
            bnMeaning = "ফোল্ডার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_933",
            category = VocabCategory.TECH,
            singularTarget = "दस्तावेज़",
            singularBnPron = "দস্তাবেজ",
            pluralTarget = "दस्तावेज़",
            pluralBnPron = "দস্তাবেজ",
            bnMeaning = "দলিল / ডকুমেন্ট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_934",
            category = VocabCategory.TECH,
            singularTarget = "तस्वीर / चित्र",
            singularBnPron = "তসবীর",
            pluralTarget = "तस्वीरें",
            pluralBnPron = "তসবীরেঁ",
            bnMeaning = "ছবি / ইমেজ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_935",
            category = VocabCategory.TECH,
            singularTarget = "वीडियो",
            singularBnPron = "ভিডিও",
            pluralTarget = "वीडियो",
            pluralBnPron = "ভিডিও",
            bnMeaning = "ভিডিও",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_936",
            category = VocabCategory.TECH,
            singularTarget = "ऑडियो / ध्वनि",
            singularBnPron = "অডিও",
            pluralTarget = "ऑडियो",
            pluralBnPron = "অডিও",
            bnMeaning = "অডিও / শব্দ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_937",
            category = VocabCategory.TECH,
            singularTarget = "लिंक",
            singularBnPron = "লিংক",
            pluralTarget = "लिंक",
            pluralBnPron = "লিংক",
            bnMeaning = "সংযোগ / লিংক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_938",
            category = VocabCategory.TECH,
            singularTarget = "सोशल मीडिया",
            singularBnPron = "সোশ্যাল মিডিয়া",
            pluralTarget = "सोशल मीडिया",
            pluralBnPron = "সোশ্যাল মিডিয়া",
            bnMeaning = "সামাজিক যোগাযোগ মাধ্যম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_939",
            category = VocabCategory.TECH,
            singularTarget = "डाउनलोड",
            singularBnPron = "ডাউনলোড",
            pluralTarget = "डाउनलोड",
            pluralBnPron = "ডাউনলোড",
            bnMeaning = "ডাউনলোড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_940",
            category = VocabCategory.TECH,
            singularTarget = "अपलोड",
            singularBnPron = "আপলোড",
            pluralTarget = "अपलोड",
            pluralBnPron = "আপলোড",
            bnMeaning = "আপলোড",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_941",
            category = VocabCategory.TECH,
            singularTarget = "खोज / सर्च",
            singularBnPron = "খোজ",
            pluralTarget = "खोज",
            pluralBnPron = "খোজ",
            bnMeaning = "অনুসন্ধান / সার্চ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_942",
            category = VocabCategory.TECH,
            singularTarget = "क्लिक",
            singularBnPron = "ক্লিক",
            pluralTarget = "क्लिक",
            pluralBnPron = "ক্লিক",
            bnMeaning = "ক্লিক করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_943",
            category = VocabCategory.TECH,
            singularTarget = "सहेजना / सेव करना",
            singularBnPron = "সেভ",
            pluralTarget = "सेव",
            pluralBnPron = "সেভ",
            bnMeaning = "সংরক্ষণ / সেভ করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_944",
            category = VocabCategory.TECH,
            singularTarget = "हटाना / डिलीट करना",
            singularBnPron = "ডিলিট",
            pluralTarget = "डिलीट",
            pluralBnPron = "ডিলিট",
            bnMeaning = "মুছে ফেলা / ডিলিট করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_945",
            category = VocabCategory.TECH,
            singularTarget = "इंस्टॉल करना",
            singularBnPron = "ইনস্টল",
            pluralTarget = "इंस्टॉल",
            pluralBnPron = "ইনস্টল",
            bnMeaning = "ইনস্টল করা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_946",
            category = VocabCategory.TECH,
            singularTarget = "अपडेट",
            singularBnPron = "আপডেট",
            pluralTarget = "अपडेट",
            pluralBnPron = "আপডেট",
            bnMeaning = "হালনাগাদ / আপডেট",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_947",
            category = VocabCategory.TECH,
            singularTarget = "सूचना / नोटिफिकेशन",
            singularBnPron = "সূচনা",
            pluralTarget = "सूचनाएं",
            pluralBnPron = "সূচনাএঁ",
            bnMeaning = "বিজ্ঞপ্তি / নোটিফিকেশন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_948",
            category = VocabCategory.TECH,
            singularTarget = "सेटिंग्स",
            singularBnPron = "সেটিংস",
            pluralTarget = "सेटिंग्स",
            pluralBnPron = "সেটিংস",
            bnMeaning = "সেটিংস",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_949",
            category = VocabCategory.TECH,
            singularTarget = "डिजिटल",
            singularBnPron = "ডিজিটাল",
            pluralTarget = "डिजिटल",
            pluralBnPron = "ডিজিটাল",
            bnMeaning = "ডিজিটাল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_950",
            category = VocabCategory.TECH,
            singularTarget = "प्रौद्योगिकी / तकनीक",
            singularBnPron = "তকনীক",
            pluralTarget = "तकनीक",
            pluralBnPron = "তকনীক",
            bnMeaning = "প্রযুক্তি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_951",
            category = VocabCategory.EMERGENCY,
            singularTarget = "आपातकाल / इमरजेंसी",
            singularBnPron = "আপাতকাল",
            pluralTarget = "आपातकाल",
            pluralBnPron = "আপাতকাল",
            bnMeaning = "জরুরি অবস্থা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_952",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ख़तरा",
            singularBnPron = "খতরা",
            pluralTarget = "ख़तरे",
            pluralBnPron = "খতরে",
            bnMeaning = "বিপদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_953",
            category = VocabCategory.EMERGENCY,
            singularTarget = "मदद / बचाओ",
            singularBnPron = "মদদ",
            pluralTarget = "मदद",
            pluralBnPron = "মদদ",
            bnMeaning = "সাহায্য / বাঁচাও",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_954",
            category = VocabCategory.EMERGENCY,
            singularTarget = "पुलिस",
            singularBnPron = "পুলিশ",
            pluralTarget = "पुलिस",
            pluralBnPron = "পুলিশ",
            bnMeaning = "পুলিশ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_955",
            category = VocabCategory.EMERGENCY,
            singularTarget = "एम्बुलेंस",
            singularBnPron = "অ্যাম্বুলেন্স",
            pluralTarget = "एम्बुलेंस",
            pluralBnPron = "অ্যাম্বুলেন্স",
            bnMeaning = "অ্যাম্বুলেন্স",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_956",
            category = VocabCategory.EMERGENCY,
            singularTarget = "दमकल दल",
            singularBnPron = "দমকল দল",
            pluralTarget = "दमकल दल",
            pluralBnPron = "দমকল দল",
            bnMeaning = "দমকল বাহিনী / ফায়ার সার্ভিস",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_957",
            category = VocabCategory.EMERGENCY,
            singularTarget = "प्राथमिक उपचार",
            singularBnPron = "প্রাথমিক উপচার",
            pluralTarget = "उपचार",
            pluralBnPron = "প্রাথমিক উপচার",
            bnMeaning = "প্রাথমিক চিকিৎসা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_958",
            category = VocabCategory.EMERGENCY,
            singularTarget = "फ़र्स्ट एड किट",
            singularBnPron = "ফার্স্ট এইড কিট",
            pluralTarget = "किट",
            pluralBnPron = "ফার্স্ট এইড কিট",
            bnMeaning = "প্রাথমিক চিকিৎসার বাক্স",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_959",
            category = VocabCategory.EMERGENCY,
            singularTarget = "पट्टी / बैंडेज",
            singularBnPron = "পট্টি",
            pluralTarget = "पट्टियां",
            pluralBnPron = "পট্টিয়াঁ",
            bnMeaning = "ব্যান্ডেজ / পট্টি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_960",
            category = VocabCategory.EMERGENCY,
            singularTarget = "दवा / औषधि",
            singularBnPron = "দাওয়া",
            pluralTarget = "दवाएं",
            pluralBnPron = "দাওয়াএঁ",
            bnMeaning = "ঔষধ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_961",
            category = VocabCategory.EMERGENCY,
            singularTarget = "दर्द निवारक",
            singularBnPron = "দর্দ নিবারক",
            pluralTarget = "दर्द निवारक",
            pluralBnPron = "দর্দ নিবারক",
            bnMeaning = "ব্যথানাশক",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_962",
            category = VocabCategory.EMERGENCY,
            singularTarget = "इंजेक्शन / सुई",
            singularBnPron = "ইনজেকশন",
            pluralTarget = "इंजेक्शन",
            pluralBnPron = "ইনজেকশন",
            bnMeaning = "ইনজেকশন / সুঁই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_963",
            category = VocabCategory.EMERGENCY,
            singularTarget = "थर्मामीटर",
            singularBnPron = "থার্মোমিটার",
            pluralTarget = "थर्मामीटर",
            pluralBnPron = "থার্মোমিটার",
            bnMeaning = "থার্মোমিটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_964",
            category = VocabCategory.EMERGENCY,
            singularTarget = "मरीज़ / रोगी",
            singularBnPron = "মরীজ",
            pluralTarget = "मरीज़",
            pluralBnPron = "মরীজ",
            bnMeaning = "রোগী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_965",
            category = VocabCategory.EMERGENCY,
            singularTarget = "बीमारी / रोग",
            singularBnPron = "বীমারী",
            pluralTarget = "बीमारियां",
            pluralBnPron = "বীমারীয়াঁ",
            bnMeaning = "রোগ / ব্যাধি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_966",
            category = VocabCategory.EMERGENCY,
            singularTarget = "दर्द / पीड़ा",
            singularBnPron = "দর্দ",
            pluralTarget = "दर्द",
            pluralBnPron = "দর্দ",
            bnMeaning = "ব্যথা / বেদনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_967",
            category = VocabCategory.EMERGENCY,
            singularTarget = "बुख़ार",
            singularBnPron = "বুখার",
            pluralTarget = "बुख़ार",
            pluralBnPron = "বুখার",
            bnMeaning = "জ্বর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_968",
            category = VocabCategory.EMERGENCY,
            singularTarget = "खाँसी",
            singularBnPron = "খাঁসী",
            pluralTarget = "खाँसी",
            pluralBnPron = "খাঁসী",
            bnMeaning = "কাশি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_969",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ज़ुकाम / फ़्लू",
            singularBnPron = "জুকাম",
            pluralTarget = "ज़ुकाम",
            pluralBnPron = "জুকাম",
            bnMeaning = "সর্দি / ফ্লু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_970",
            category = VocabCategory.EMERGENCY,
            singularTarget = "सिरदर्द",
            singularBnPron = "সিরদর্দ",
            pluralTarget = "सिरदर्द",
            pluralBnPron = "সিরদর্দ",
            bnMeaning = "মাথাব্যথা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_971",
            category = VocabCategory.EMERGENCY,
            singularTarget = "पेट दर्द",
            singularBnPron = "পেট দর্দ",
            pluralTarget = "पेट दर्द",
            pluralBnPron = "পেট দর্দ",
            bnMeaning = "পেটব্যথা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_972",
            category = VocabCategory.EMERGENCY,
            singularTarget = "घाव / ज़ख़्म",
            singularBnPron = "ঘাব",
            pluralTarget = "घाव",
            pluralBnPron = "ঘাব",
            bnMeaning = "ক্ষত / ঘা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_973",
            category = VocabCategory.EMERGENCY,
            singularTarget = "जलना",
            singularBnPron = "জলনা",
            pluralTarget = "जलना",
            pluralBnPron = "জলনা",
            bnMeaning = "পোড়া / দগ্ধ হওয়া",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_974",
            category = VocabCategory.EMERGENCY,
            singularTarget = "खून बहना",
            singularBnPron = "খুন বহনা",
            pluralTarget = "खून बहना",
            pluralBnPron = "খুন বহনা",
            bnMeaning = "রক্তপাত",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_975",
            category = VocabCategory.EMERGENCY,
            singularTarget = "हड्डी टूटना",
            singularBnPron = "হড্ডী টুটনা",
            pluralTarget = "हड्डी टूटना",
            pluralBnPron = "হড্ডী টুটনা",
            bnMeaning = "হাড়ভাঙা / ফ্র্যাকচার",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_976",
            category = VocabCategory.EMERGENCY,
            singularTarget = "एलर्जी",
            singularBnPron = "অ্যালার্জি",
            pluralTarget = "एलर्जी",
            pluralBnPron = "অ্যালার্জি",
            bnMeaning = "অ্যালার্জি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_977",
            category = VocabCategory.EMERGENCY,
            singularTarget = "ज़हर / विष",
            singularBnPron = "জহর",
            pluralTarget = "ज़हर",
            pluralBnPron = "জহর",
            bnMeaning = "বিষ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_978",
            category = VocabCategory.EMERGENCY,
            singularTarget = "दुर्घटना / हादसा",
            singularBnPron = "হাদসা",
            pluralTarget = "हादसे",
            pluralBnPron = "হাদসে",
            bnMeaning = "দুর্ঘটনা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_979",
            category = VocabCategory.EMERGENCY,
            singularTarget = "आग लगना",
            singularBnPron = "আগ লাগনা",
            pluralTarget = "आग",
            pluralBnPron = "আগ লাগনা",
            bnMeaning = "অগ্নিকাণ্ড",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_980",
            category = VocabCategory.EMERGENCY,
            singularTarget = "बाढ़",
            singularBnPron = "বাঢ়",
            pluralTarget = "बाढ़",
            pluralBnPron = "বাঢ়",
            bnMeaning = "বন্যা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_981",
            category = VocabCategory.EMERGENCY,
            singularTarget = "भूकंप",
            singularBnPron = "ভূকম্প",
            pluralTarget = "भूकंप",
            pluralBnPron = "ভূকম্প",
            bnMeaning = "ভূমিকম্প",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_982",
            category = VocabCategory.EMERGENCY,
            singularTarget = "चक्रवात / तूफ़ान",
            singularBnPron = "চক্রবাত",
            pluralTarget = "चक्रवात",
            pluralBnPron = "চক্রবাত",
            bnMeaning = "ঘূর্ণিঝড় / সাইক্লোন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_983",
            category = VocabCategory.EMERGENCY,
            singularTarget = "आपातकालीन निकास",
            singularBnPron = "আপাতকালীন নিকাস",
            pluralTarget = "निकास",
            pluralBnPron = "আপাতকালীন নিকাস",
            bnMeaning = "জরুরি প্রস্থান",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_984",
            category = VocabCategory.EMERGENCY,
            singularTarget = "अग्निशामक यंत्र",
            singularBnPron = "অগ্নিশামক যন্ত্র",
            pluralTarget = "यंत्र",
            pluralBnPron = "অগ্নিশামক যন্ত্র",
            bnMeaning = "অগ্নিনির্বাপক যন্ত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_985",
            category = VocabCategory.EMERGENCY,
            singularTarget = "चेतावनी",
            singularBnPron = "চেতাবনী",
            pluralTarget = "चेतावनी",
            pluralBnPron = "চেতাবনী",
            bnMeaning = "সতর্কবার্তা / ওয়ার্নিং",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_986",
            category = VocabCategory.EMERGENCY,
            singularTarget = "अलार्म / ख़तरे की घंटी",
            singularBnPron = "অ্যালার্ম",
            pluralTarget = "अलार्म",
            pluralBnPron = "অ্যালার্ম",
            bnMeaning = "বিপদ সংকেত / অ্যালার্ম",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_987",
            category = VocabCategory.EMERGENCY,
            singularTarget = "साइरन",
            singularBnPron = "সাইরেন",
            pluralTarget = "साइरन",
            pluralBnPron = "সাইরেন",
            bnMeaning = "সাইরেন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_988",
            category = VocabCategory.EMERGENCY,
            singularTarget = "सुरक्षा गार्ड",
            singularBnPron = "সুরক্ষা গার্ড",
            pluralTarget = "गार्ड",
            pluralBnPron = "সুরক্ষা গার্ড",
            bnMeaning = "নিরাপত্তারক্ষী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_989",
            category = VocabCategory.EMERGENCY,
            singularTarget = "सुरक्षा",
            singularBnPron = "সুরক্ষা",
            pluralTarget = "सुरक्षा",
            pluralBnPron = "সুরক্ষা",
            bnMeaning = "নিরাপত্তা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_990",
            category = VocabCategory.EMERGENCY,
            singularTarget = "लाइफ जैकेट",
            singularBnPron = "লাইফ জ্যাকেট",
            pluralTarget = "जैकेट",
            pluralBnPron = "লাইফ জ্যাকেট",
            bnMeaning = "লাইফ জ্যাকেট",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_991",
            category = VocabCategory.EMERGENCY,
            singularTarget = "बचाव दल",
            singularBnPron = "বাঁচাও দল",
            pluralTarget = "दल",
            pluralBnPron = "বাঁচাও দল",
            bnMeaning = "উদ্ধারকারী দল",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_992",
            category = VocabCategory.EMERGENCY,
            singularTarget = "आश्रय स्थल / शरण",
            singularBnPron = "আশ্রয়",
            pluralTarget = "शरण",
            pluralBnPron = "আশ্রয়",
            bnMeaning = "আশ্রয়স্থল / শেল্টার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_993",
            category = VocabCategory.EMERGENCY,
            singularTarget = "बीमा",
            singularBnPron = "বীমা",
            pluralTarget = "बीमा",
            pluralBnPron = "বীমা",
            bnMeaning = "বীমা / ইন্স্যুরেন্স",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_994",
            category = VocabCategory.EMERGENCY,
            singularTarget = "आपातकालीन नंबर",
            singularBnPron = "আপাতকালীন নম্বর",
            pluralTarget = "नंबर",
            pluralBnPron = "আপাতকালীন নম্বর",
            bnMeaning = "জরুরি নম্বর / হটলাইন",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_995",
            category = VocabCategory.EMERGENCY,
            singularTarget = "लापता / खोया हुआ",
            singularBnPron = "লাপাতা",
            pluralTarget = "लापता",
            pluralBnPron = "লাপাতা",
            bnMeaning = "হারিয়ে যাওয়া / নিখোঁজ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_996",
            category = VocabCategory.EMERGENCY,
            singularTarget = "शव / लाश",
            singularBnPron = "লাশ",
            pluralTarget = "शव",
            pluralBnPron = "লাশ",
            bnMeaning = "মৃতদেহ / লাশ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_997",
            category = VocabCategory.EMERGENCY,
            singularTarget = "जीवित व्यक्ति",
            singularBnPron = "জীবিত",
            pluralTarget = "व्यक्ति",
            pluralBnPron = "জীবিত",
            bnMeaning = "জীবিত / সারভাইভার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_998",
            category = VocabCategory.EMERGENCY,
            singularTarget = "मलबा",
            singularBnPron = "মলবা",
            pluralTarget = "मलबा",
            pluralBnPron = "মলবা",
            bnMeaning = "ধ্বংসাবশেষ / ধ্বংসস্তূপ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "hi_vocab_999",
            category = VocabCategory.EMERGENCY,
            singularTarget = "निकासी",
            singularBnPron = "নিকাসী",
            pluralTarget = "निकासी",
            pluralBnPron = "নিকাসী",
            bnMeaning = "নিরাপদ প্রস্থান",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "hi_vocab_1000",
            category = VocabCategory.EMERGENCY,
            singularTarget = "आपात संदेश / एसओएस",
            singularBnPron = "এসওএস",
            pluralTarget = "संदेश",
            pluralBnPron = "এসওএস",
            bnMeaning = "জরুরি সংকেত / এসওএস",
            gender = GrammaticalGender.MASCULINE
        ),
    )

    val config = VocabLanguageConfig(
        langCode = "hi",
        speechLang = SpeechLang.HI,
        titleBn = "হিন্দি শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি প্রয়োজনীয় হিন্দি শব্দ (একবচন, বহুবচন ও লিঙ্গ সহ)",
        nativeTitle = "हिन्दी शब्दकोश",
        accentColorHex = 0xFFD84315,
        items = chunk1 + chunk2 + chunk3 + chunk4 + chunk5 + chunk6 + chunk7 + chunk8 + chunk9 + chunk10
    )
}
