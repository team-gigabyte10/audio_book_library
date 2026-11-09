package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object EnglishVocabData {
    private val chunk1 = listOf(
        VocabItem(
            id = "en_vocab_1",
            category = VocabCategory.FAMILY,
            singularTarget = "Father",
            singularBnPron = "ফাদার",
            pluralTarget = "Fathers",
            pluralBnPron = "ফাদার্স",
            bnMeaning = "বাবা / পিতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_2",
            category = VocabCategory.FAMILY,
            singularTarget = "Mother",
            singularBnPron = "মাদার",
            pluralTarget = "Mothers",
            pluralBnPron = "মাদার্স",
            bnMeaning = "মা / মাতা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_3",
            category = VocabCategory.FAMILY,
            singularTarget = "Son",
            singularBnPron = "সান",
            pluralTarget = "Sons",
            pluralBnPron = "সানস",
            bnMeaning = "ছেলে / পুত্র",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_4",
            category = VocabCategory.FAMILY,
            singularTarget = "Daughter",
            singularBnPron = "ডটার",
            pluralTarget = "Daughters",
            pluralBnPron = "ডটার্স",
            bnMeaning = "মেয়ে / কন্যা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_5",
            category = VocabCategory.FAMILY,
            singularTarget = "Brother",
            singularBnPron = "ব্রাদার",
            pluralTarget = "Brothers",
            pluralBnPron = "ব্রাদার্স",
            bnMeaning = "ভাই",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_6",
            category = VocabCategory.FAMILY,
            singularTarget = "Sister",
            singularBnPron = "সিস্টার",
            pluralTarget = "Sisters",
            pluralBnPron = "সিস্টার্স",
            bnMeaning = "বোন",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_7",
            category = VocabCategory.FAMILY,
            singularTarget = "Grandfather",
            singularBnPron = "গ্র্যান্ডফাদার",
            pluralTarget = "Grandfathers",
            pluralBnPron = "গ্র্যান্ডফাদার্স",
            bnMeaning = "দাদা / নানা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_8",
            category = VocabCategory.FAMILY,
            singularTarget = "Grandmother",
            singularBnPron = "গ্র্যান্ডমাদার",
            pluralTarget = "Grandmothers",
            pluralBnPron = "গ্র্যান্ডমাদার্স",
            bnMeaning = "দাদি / নানি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_9",
            category = VocabCategory.FAMILY,
            singularTarget = "Grandson",
            singularBnPron = "গ্র্যান্ডসান",
            pluralTarget = "Grandsons",
            pluralBnPron = "গ্র্যান্ডসানস",
            bnMeaning = "নাতি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_10",
            category = VocabCategory.FAMILY,
            singularTarget = "Granddaughter",
            singularBnPron = "গ্র্যান্ডডটার",
            pluralTarget = "Granddaughters",
            pluralBnPron = "গ্র্যান্ডডটার্স",
            bnMeaning = "নাতনি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_11",
            category = VocabCategory.FAMILY,
            singularTarget = "Uncle",
            singularBnPron = "আঙ্কল",
            pluralTarget = "Uncles",
            pluralBnPron = "আঙ্কলস",
            bnMeaning = "চাচা / মামা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_12",
            category = VocabCategory.FAMILY,
            singularTarget = "Aunt",
            singularBnPron = "আন্ট",
            pluralTarget = "Aunts",
            pluralBnPron = "আন্টস",
            bnMeaning = "চাচি / খালা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_13",
            category = VocabCategory.FAMILY,
            singularTarget = "Nephew",
            singularBnPron = "নেফিউ",
            pluralTarget = "Nephews",
            pluralBnPron = "নেফিউস",
            bnMeaning = "ভাতিজা / ভাগ্নে",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_14",
            category = VocabCategory.FAMILY,
            singularTarget = "Niece",
            singularBnPron = "নিস",
            pluralTarget = "Nieces",
            pluralBnPron = "নিসেস",
            bnMeaning = "ভাতিজি / ভাগ্নি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_15",
            category = VocabCategory.FAMILY,
            singularTarget = "Cousin",
            singularBnPron = "কাজিন",
            pluralTarget = "Cousins",
            pluralBnPron = "কাজিনস",
            bnMeaning = "চাচাতো ভাই/বোন",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_16",
            category = VocabCategory.FAMILY,
            singularTarget = "Husband",
            singularBnPron = "হাজব্যান্ড",
            pluralTarget = "Husbands",
            pluralBnPron = "হাজব্যান্ডস",
            bnMeaning = "স্বামী",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_17",
            category = VocabCategory.FAMILY,
            singularTarget = "Wife",
            singularBnPron = "ওয়াইফ",
            pluralTarget = "Wives",
            pluralBnPron = "ওয়াইভস",
            bnMeaning = "স্ত্রী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_18",
            category = VocabCategory.FAMILY,
            singularTarget = "Child",
            singularBnPron = "চাইল্ড",
            pluralTarget = "Children",
            pluralBnPron = "চিলড্রেন",
            bnMeaning = "সন্তান / শিশু",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_19",
            category = VocabCategory.FAMILY,
            singularTarget = "Baby",
            singularBnPron = "বেবি",
            pluralTarget = "Babies",
            pluralBnPron = "বেবিস",
            bnMeaning = "নবজাতক শিশু",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_20",
            category = VocabCategory.FAMILY,
            singularTarget = "Parent",
            singularBnPron = "প্যারেন্ট",
            pluralTarget = "Parents",
            pluralBnPron = "প্যারেন্টস",
            bnMeaning = "বাবা-মা (অভিভাবক)",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_21",
            category = VocabCategory.FAMILY,
            singularTarget = "Boy",
            singularBnPron = "বয়",
            pluralTarget = "Boys",
            pluralBnPron = "বয়েজ",
            bnMeaning = "ছেলে / বালক",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_22",
            category = VocabCategory.FAMILY,
            singularTarget = "Girl",
            singularBnPron = "গার্ল",
            pluralTarget = "Girls",
            pluralBnPron = "গার্লস",
            bnMeaning = "মেয়ে / বালিকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_23",
            category = VocabCategory.FAMILY,
            singularTarget = "Man",
            singularBnPron = "ম্যান",
            pluralTarget = "Men",
            pluralBnPron = "মেন",
            bnMeaning = "পুরুষ / ব্যক্তি",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_24",
            category = VocabCategory.FAMILY,
            singularTarget = "Woman",
            singularBnPron = "ওম্যান",
            pluralTarget = "Women",
            pluralBnPron = "উইমেন",
            bnMeaning = "নারী / মহিলা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_25",
            category = VocabCategory.FAMILY,
            singularTarget = "Friend",
            singularBnPron = "ফ্রেন্ড",
            pluralTarget = "Friends",
            pluralBnPron = "ফ্রেন্ডস",
            bnMeaning = "বন্ধু",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_26",
            category = VocabCategory.FAMILY,
            singularTarget = "Neighbor",
            singularBnPron = "নেইবার",
            pluralTarget = "Neighbors",
            pluralBnPron = "নেইবার্স",
            bnMeaning = "প্রতিবেশী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_27",
            category = VocabCategory.FAMILY,
            singularTarget = "Guest",
            singularBnPron = "গেস্ট",
            pluralTarget = "Guests",
            pluralBnPron = "গেস্টস",
            bnMeaning = "অতিথি / মেহমান",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_28",
            category = VocabCategory.FAMILY,
            singularTarget = "Colleague",
            singularBnPron = "কলিগ",
            pluralTarget = "Colleagues",
            pluralBnPron = "কলিগস",
            bnMeaning = "সহকর্মী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_29",
            category = VocabCategory.FAMILY,
            singularTarget = "Classmate",
            singularBnPron = "ক্লাসমেট",
            pluralTarget = "Classmates",
            pluralBnPron = "ক্লাসমেটস",
            bnMeaning = "সহপাঠী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_30",
            category = VocabCategory.FAMILY,
            singularTarget = "Teacher",
            singularBnPron = "টিচার",
            pluralTarget = "Teachers",
            pluralBnPron = "টিচার্স",
            bnMeaning = "শিক্ষক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_31",
            category = VocabCategory.FAMILY,
            singularTarget = "Student",
            singularBnPron = "স্টুডেন্ট",
            pluralTarget = "Students",
            pluralBnPron = "স্টুডেন্টস",
            bnMeaning = "ছাত্র / শিক্ষার্থী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_32",
            category = VocabCategory.FAMILY,
            singularTarget = "Family",
            singularBnPron = "ফ্যামিলি",
            pluralTarget = "Families",
            pluralBnPron = "ফ্যামিলিস",
            bnMeaning = "পরিবার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_33",
            category = VocabCategory.FAMILY,
            singularTarget = "Relative",
            singularBnPron = "রিলেটিভ",
            pluralTarget = "Relatives",
            pluralBnPron = "রিলেটিভস",
            bnMeaning = "আত্মীয়",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_34",
            category = VocabCategory.FAMILY,
            singularTarget = "Human",
            singularBnPron = "হিউম্যান",
            pluralTarget = "Humans",
            pluralBnPron = "হিউম্যানস",
            bnMeaning = "মানুষ / জাতি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_35",
            category = VocabCategory.FAMILY,
            singularTarget = "Groom",
            singularBnPron = "গ্রুম",
            pluralTarget = "Grooms",
            pluralBnPron = "গ্রুমস",
            bnMeaning = "বর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_36",
            category = VocabCategory.FAMILY,
            singularTarget = "Bride",
            singularBnPron = "ব্রাইড",
            pluralTarget = "Brides",
            pluralBnPron = "ব্রাইডস",
            bnMeaning = "কনে / নববধূ",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_37",
            category = VocabCategory.FAMILY,
            singularTarget = "Twin",
            singularBnPron = "টুইন",
            pluralTarget = "Twins",
            pluralBnPron = "টুইনস",
            bnMeaning = "যমজ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_38",
            category = VocabCategory.FAMILY,
            singularTarget = "Citizen",
            singularBnPron = "সিটিজেন",
            pluralTarget = "Citizens",
            pluralBnPron = "সিটিজেনস",
            bnMeaning = "নাগরিক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_39",
            category = VocabCategory.FAMILY,
            singularTarget = "Person",
            singularBnPron = "পারসন",
            pluralTarget = "People",
            pluralBnPron = "পিপল",
            bnMeaning = "ব্যক্তি / লোক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_40",
            category = VocabCategory.FAMILY,
            singularTarget = "Group",
            singularBnPron = "গ্রুপ",
            pluralTarget = "Groups",
            pluralBnPron = "গ্রুপস",
            bnMeaning = "দল / জনগোষ্ঠী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_41",
            category = VocabCategory.FAMILY,
            singularTarget = "Youth",
            singularBnPron = "ইউথ",
            pluralTarget = "Youths",
            pluralBnPron = "ইউথস",
            bnMeaning = "যুবক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_42",
            category = VocabCategory.FAMILY,
            singularTarget = "Elder",
            singularBnPron = "এল্ডার",
            pluralTarget = "Elders",
            pluralBnPron = "এল্ডার্স",
            bnMeaning = "বয়োবৃদ্ধ / প্রবীণ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_43",
            category = VocabCategory.FAMILY,
            singularTarget = "Baby girl",
            singularBnPron = "বেবি গার্ল",
            pluralTarget = "Baby girls",
            pluralBnPron = "বেবি গার্লস",
            bnMeaning = "মেয়ে শিশু",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_44",
            category = VocabCategory.FAMILY,
            singularTarget = "Baby boy",
            singularBnPron = "বেবি বয়",
            pluralTarget = "Baby boys",
            pluralBnPron = "বেবি বয়েজ",
            bnMeaning = "ছেলে শিশু",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_45",
            category = VocabCategory.FAMILY,
            singularTarget = "Manager",
            singularBnPron = "ম্যানেজার",
            pluralTarget = "Managers",
            pluralBnPron = "ম্যানেজার্স",
            bnMeaning = "ম্যানেজার / পরিচালক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_46",
            category = VocabCategory.FAMILY,
            singularTarget = "Owner",
            singularBnPron = "ওনার",
            pluralTarget = "Owners",
            pluralBnPron = "ওনার্স",
            bnMeaning = "মালিক / কর্তা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_47",
            category = VocabCategory.FAMILY,
            singularTarget = "Leader",
            singularBnPron = "লিডার",
            pluralTarget = "Leaders",
            pluralBnPron = "লিডার্স",
            bnMeaning = "নেতা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_48",
            category = VocabCategory.FAMILY,
            singularTarget = "Enemy",
            singularBnPron = "এনিমি",
            pluralTarget = "Enemies",
            pluralBnPron = "এনিমিস",
            bnMeaning = "শত্রু",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_49",
            category = VocabCategory.FAMILY,
            singularTarget = "Couple",
            singularBnPron = "কাপল",
            pluralTarget = "Couples",
            pluralBnPron = "কাপলস",
            bnMeaning = "দম্পতি / জোড়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_50",
            category = VocabCategory.FAMILY,
            singularTarget = "Member",
            singularBnPron = "মেম্বার",
            pluralTarget = "Members",
            pluralBnPron = "মেম্বার্স",
            bnMeaning = "দলপতি / সদস্য",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_51",
            category = VocabCategory.BODY,
            singularTarget = "Head",
            singularBnPron = "হেড",
            pluralTarget = "Heads",
            pluralBnPron = "হেডস",
            bnMeaning = "মাথা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_52",
            category = VocabCategory.BODY,
            singularTarget = "Hair",
            singularBnPron = "হেয়ার",
            pluralTarget = "Hairs",
            pluralBnPron = "হেয়ার্স",
            bnMeaning = "চুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_53",
            category = VocabCategory.BODY,
            singularTarget = "Face",
            singularBnPron = "ফেস",
            pluralTarget = "Faces",
            pluralBnPron = "ফেসেস",
            bnMeaning = "মুখমণ্ডল / চেহারা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_54",
            category = VocabCategory.BODY,
            singularTarget = "Forehead",
            singularBnPron = "ফোরহেড",
            pluralTarget = "Foreheads",
            pluralBnPron = "ফোরহেডস",
            bnMeaning = "কপাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_55",
            category = VocabCategory.BODY,
            singularTarget = "Eye",
            singularBnPron = "আই",
            pluralTarget = "Eyes",
            pluralBnPron = "আইজ",
            bnMeaning = "চোখ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_56",
            category = VocabCategory.BODY,
            singularTarget = "Eyebrow",
            singularBnPron = "আইব্রো",
            pluralTarget = "Eyebrows",
            pluralBnPron = "আইব্রোস",
            bnMeaning = "ভ্রু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_57",
            category = VocabCategory.BODY,
            singularTarget = "Eyelid",
            singularBnPron = "আইলিড",
            pluralTarget = "Eyelids",
            pluralBnPron = "আইলিডস",
            bnMeaning = "চোখের পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_58",
            category = VocabCategory.BODY,
            singularTarget = "Ear",
            singularBnPron = "ইয়ার",
            pluralTarget = "Ears",
            pluralBnPron = "ইয়ার্স",
            bnMeaning = "কান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_59",
            category = VocabCategory.BODY,
            singularTarget = "Nose",
            singularBnPron = "নোজ",
            pluralTarget = "Noses",
            pluralBnPron = "নোজেস",
            bnMeaning = "নাক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_60",
            category = VocabCategory.BODY,
            singularTarget = "Nostril",
            singularBnPron = "নস্ট্রিল",
            pluralTarget = "Nostrils",
            pluralBnPron = "নস্ট্রিলস",
            bnMeaning = "নাকের ছিদ্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_61",
            category = VocabCategory.BODY,
            singularTarget = "Mouth",
            singularBnPron = "মাউথ",
            pluralTarget = "Mouths",
            pluralBnPron = "মাউথস",
            bnMeaning = "মুখ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_62",
            category = VocabCategory.BODY,
            singularTarget = "Lip",
            singularBnPron = "লিপ",
            pluralTarget = "Lips",
            pluralBnPron = "লিপস",
            bnMeaning = "ঠোঁট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_63",
            category = VocabCategory.BODY,
            singularTarget = "Tooth",
            singularBnPron = "টুথ",
            pluralTarget = "Teeth",
            pluralBnPron = "টিথ",
            bnMeaning = "দাঁত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_64",
            category = VocabCategory.BODY,
            singularTarget = "Tongue",
            singularBnPron = "টাং",
            pluralTarget = "Tongues",
            pluralBnPron = "টাংস",
            bnMeaning = "জিভ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_65",
            category = VocabCategory.BODY,
            singularTarget = "Chin",
            singularBnPron = "চিন",
            pluralTarget = "Chins",
            pluralBnPron = "চিনস",
            bnMeaning = "চিবুক / থুতনি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_66",
            category = VocabCategory.BODY,
            singularTarget = "Cheek",
            singularBnPron = "চিক",
            pluralTarget = "Cheeks",
            pluralBnPron = "চিকস",
            bnMeaning = "গাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_67",
            category = VocabCategory.BODY,
            singularTarget = "Beard",
            singularBnPron = "বিয়ার্ড",
            pluralTarget = "Beards",
            pluralBnPron = "বিয়ার্ডস",
            bnMeaning = "দাড়ি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_68",
            category = VocabCategory.BODY,
            singularTarget = "Mustache",
            singularBnPron = "মুস্তাশ",
            pluralTarget = "Mustaches",
            pluralBnPron = "মুস্তাশেস",
            bnMeaning = "গোঁফ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_69",
            category = VocabCategory.BODY,
            singularTarget = "Neck",
            singularBnPron = "নেক",
            pluralTarget = "Necks",
            pluralBnPron = "নেকস",
            bnMeaning = "ঘাড় / গলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_70",
            category = VocabCategory.BODY,
            singularTarget = "Throat",
            singularBnPron = "থ্রোট",
            pluralTarget = "Throats",
            pluralBnPron = "থ্রোটস",
            bnMeaning = "গলা (অভ্যন্তরীণ)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_71",
            category = VocabCategory.BODY,
            singularTarget = "Shoulder",
            singularBnPron = "শোল্ডার",
            pluralTarget = "Shoulders",
            pluralBnPron = "শোল্ডার্স",
            bnMeaning = "কাঁধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_72",
            category = VocabCategory.BODY,
            singularTarget = "Chest",
            singularBnPron = "চেস্ট",
            pluralTarget = "Chests",
            pluralBnPron = "চেস্টস",
            bnMeaning = "বুক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_73",
            category = VocabCategory.BODY,
            singularTarget = "Back",
            singularBnPron = "ব্যাক",
            pluralTarget = "Backs",
            pluralBnPron = "ব্যাকস",
            bnMeaning = "পিঠ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_74",
            category = VocabCategory.BODY,
            singularTarget = "Arm",
            singularBnPron = "আর্ম",
            pluralTarget = "Arms",
            pluralBnPron = "আর্মস",
            bnMeaning = "হাত (বাহু)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_75",
            category = VocabCategory.BODY,
            singularTarget = "Elbow",
            singularBnPron = "এলবো",
            pluralTarget = "Elbows",
            pluralBnPron = "এলবোস",
            bnMeaning = "কনুই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_76",
            category = VocabCategory.BODY,
            singularTarget = "Wrist",
            singularBnPron = "রিস্ট",
            pluralTarget = "Wrists",
            pluralBnPron = "রিস্টস",
            bnMeaning = "কবজি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_77",
            category = VocabCategory.BODY,
            singularTarget = "Hand",
            singularBnPron = "হ্যান্ড",
            pluralTarget = "Hands",
            pluralBnPron = "হ্যান্ডস",
            bnMeaning = "হাত (পাঞ্জা)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_78",
            category = VocabCategory.BODY,
            singularTarget = "Palm",
            singularBnPron = "পাম",
            pluralTarget = "Palms",
            pluralBnPron = "পামস",
            bnMeaning = "হাতের তালু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_79",
            category = VocabCategory.BODY,
            singularTarget = "Finger",
            singularBnPron = "ফিঙ্গার",
            pluralTarget = "Fingers",
            pluralBnPron = "ফিঙ্গার্স",
            bnMeaning = "আঙুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_80",
            category = VocabCategory.BODY,
            singularTarget = "Thumb",
            singularBnPron = "থাম্ব",
            pluralTarget = "Thumbs",
            pluralBnPron = "থাম্বস",
            bnMeaning = "বুড়ো আঙুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_81",
            category = VocabCategory.BODY,
            singularTarget = "Nail",
            singularBnPron = "নেইল",
            pluralTarget = "Nails",
            pluralBnPron = "নেইলস",
            bnMeaning = "নখ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_82",
            category = VocabCategory.BODY,
            singularTarget = "Belly",
            singularBnPron = "বেলি",
            pluralTarget = "Bellies",
            pluralBnPron = "বেলিস",
            bnMeaning = "পেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_83",
            category = VocabCategory.BODY,
            singularTarget = "Navel",
            singularBnPron = "নেভেল",
            pluralTarget = "Navels",
            pluralBnPron = "নেভেলস",
            bnMeaning = "নাভি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_84",
            category = VocabCategory.BODY,
            singularTarget = "Waist",
            singularBnPron = "ওয়েস্ট",
            pluralTarget = "Waists",
            pluralBnPron = "ওয়েস্টস",
            bnMeaning = "কোমর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_85",
            category = VocabCategory.BODY,
            singularTarget = "Leg",
            singularBnPron = "লেগ",
            pluralTarget = "Legs",
            pluralBnPron = "লেগস",
            bnMeaning = "পা (সমগ্র পা)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_86",
            category = VocabCategory.BODY,
            singularTarget = "Thigh",
            singularBnPron = "থাই",
            pluralTarget = "Thighs",
            pluralBnPron = "থাইস",
            bnMeaning = "উরু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_87",
            category = VocabCategory.BODY,
            singularTarget = "Knee",
            singularBnPron = "নি",
            pluralTarget = "Knees",
            pluralBnPron = "নিস",
            bnMeaning = "হাঁটু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_88",
            category = VocabCategory.BODY,
            singularTarget = "Ankle",
            singularBnPron = "অ্যাঙ্কল",
            pluralTarget = "Ankles",
            pluralBnPron = "অ্যাঙ্কলস",
            bnMeaning = "গোড়ালি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_89",
            category = VocabCategory.BODY,
            singularTarget = "Foot",
            singularBnPron = "ফুট",
            pluralTarget = "Feet",
            pluralBnPron = "ফিট",
            bnMeaning = "পায়ের পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_90",
            category = VocabCategory.BODY,
            singularTarget = "Toe",
            singularBnPron = "টো",
            pluralTarget = "Toes",
            pluralBnPron = "টোস",
            bnMeaning = "পায়ের আঙুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_91",
            category = VocabCategory.BODY,
            singularTarget = "Skin",
            singularBnPron = "স্কিন",
            pluralTarget = "Skins",
            pluralBnPron = "স্কিনস",
            bnMeaning = "চামড়া / ত্বক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_92",
            category = VocabCategory.BODY,
            singularTarget = "Bone",
            singularBnPron = "বোন",
            pluralTarget = "Bones",
            pluralBnPron = "বোনস",
            bnMeaning = "হাড়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_93",
            category = VocabCategory.BODY,
            singularTarget = "Muscle",
            singularBnPron = "মাসল",
            pluralTarget = "Muscles",
            pluralBnPron = "মাসলস",
            bnMeaning = "মাংসপেশি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_94",
            category = VocabCategory.BODY,
            singularTarget = "Blood",
            singularBnPron = "ব্লাড",
            pluralTarget = "Bloods",
            pluralBnPron = "ব্লাডস",
            bnMeaning = "রক্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_95",
            category = VocabCategory.BODY,
            singularTarget = "Heart",
            singularBnPron = "হার্ট",
            pluralTarget = "Hearts",
            pluralBnPron = "হার্টস",
            bnMeaning = "হৃদপিণ্ড / মন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_96",
            category = VocabCategory.BODY,
            singularTarget = "Brain",
            singularBnPron = "ব্রেন",
            pluralTarget = "Brains",
            pluralBnPron = "ব্রেনস",
            bnMeaning = "মস্তিষ্ক / মগজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_97",
            category = VocabCategory.BODY,
            singularTarget = "Lung",
            singularBnPron = "লাং",
            pluralTarget = "Lungs",
            pluralBnPron = "লাংস",
            bnMeaning = "ফুসফুস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_98",
            category = VocabCategory.BODY,
            singularTarget = "Stomach",
            singularBnPron = "স্টমাক",
            pluralTarget = "Stomachs",
            pluralBnPron = "স্টমাকস",
            bnMeaning = "পাকস্থলী / পেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_99",
            category = VocabCategory.BODY,
            singularTarget = "Liver",
            singularBnPron = "লিভার",
            pluralTarget = "Livers",
            pluralBnPron = "লিভার্স",
            bnMeaning = "যকৃৎ / কলিজা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_100",
            category = VocabCategory.BODY,
            singularTarget = "Voice",
            singularBnPron = "ভয়েস",
            pluralTarget = "Voices",
            pluralBnPron = "ভয়েসেস",
            bnMeaning = "কণ্ঠস্বর",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk2 = listOf(
        VocabItem(
            id = "en_vocab_101",
            category = VocabCategory.FOOD,
            singularTarget = "Rice",
            singularBnPron = "রাইস",
            pluralTarget = "Rice",
            pluralBnPron = "রাইস",
            bnMeaning = "ভাত / চাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_102",
            category = VocabCategory.FOOD,
            singularTarget = "Bread",
            singularBnPron = "ব্রেড",
            pluralTarget = "Breads",
            pluralBnPron = "ব্রেডস",
            bnMeaning = "রুটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_103",
            category = VocabCategory.FOOD,
            singularTarget = "Water",
            singularBnPron = "ওয়াটার",
            pluralTarget = "Waters",
            pluralBnPron = "ওয়াটার্স",
            bnMeaning = "পানি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_104",
            category = VocabCategory.FOOD,
            singularTarget = "Milk",
            singularBnPron = "মিল্ক",
            pluralTarget = "Milks",
            pluralBnPron = "মিল্কস",
            bnMeaning = "দুধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_105",
            category = VocabCategory.FOOD,
            singularTarget = "Tea",
            singularBnPron = "টি",
            pluralTarget = "Teas",
            pluralBnPron = "টিস",
            bnMeaning = "চা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_106",
            category = VocabCategory.FOOD,
            singularTarget = "Coffee",
            singularBnPron = "কফি",
            pluralTarget = "Coffees",
            pluralBnPron = "কফিস",
            bnMeaning = "কফি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_107",
            category = VocabCategory.FOOD,
            singularTarget = "Sugar",
            singularBnPron = "সুগার",
            pluralTarget = "Sugars",
            pluralBnPron = "সুগার্স",
            bnMeaning = "চিনি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_108",
            category = VocabCategory.FOOD,
            singularTarget = "Salt",
            singularBnPron = "সল্ট",
            pluralTarget = "Salts",
            pluralBnPron = "সল্টস",
            bnMeaning = "লবণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_109",
            category = VocabCategory.FOOD,
            singularTarget = "Oil",
            singularBnPron = "অয়েল",
            pluralTarget = "Oils",
            pluralBnPron = "অয়েলস",
            bnMeaning = "তেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_110",
            category = VocabCategory.FOOD,
            singularTarget = "Butter",
            singularBnPron = "বাটার",
            pluralTarget = "Butters",
            pluralBnPron = "বাটার্স",
            bnMeaning = "মাখন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_111",
            category = VocabCategory.FOOD,
            singularTarget = "Egg",
            singularBnPron = "এগ",
            pluralTarget = "Eggs",
            pluralBnPron = "এগস",
            bnMeaning = "ডিম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_112",
            category = VocabCategory.FOOD,
            singularTarget = "Meat",
            singularBnPron = "মিট",
            pluralTarget = "Meats",
            pluralBnPron = "মিটস",
            bnMeaning = "মাংস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_113",
            category = VocabCategory.FOOD,
            singularTarget = "Chicken",
            singularBnPron = "চিকেন",
            pluralTarget = "Chickens",
            pluralBnPron = "চিকেনস",
            bnMeaning = "মুরগির মাংস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_114",
            category = VocabCategory.FOOD,
            singularTarget = "Beef",
            singularBnPron = "বিফ",
            pluralTarget = "Beefs",
            pluralBnPron = "বিফস",
            bnMeaning = "গরুর মাংস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_115",
            category = VocabCategory.FOOD,
            singularTarget = "Fish",
            singularBnPron = "ফিশ",
            pluralTarget = "Fish",
            pluralBnPron = "ফিশ",
            bnMeaning = "মাছ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_116",
            category = VocabCategory.FOOD,
            singularTarget = "Soup",
            singularBnPron = "স্যুপ",
            pluralTarget = "Soups",
            pluralBnPron = "স্যুপস",
            bnMeaning = "স্যুপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_117",
            category = VocabCategory.FOOD,
            singularTarget = "Cheese",
            singularBnPron = "চিজ",
            pluralTarget = "Cheeses",
            pluralBnPron = "চিজেস",
            bnMeaning = "পনির / চিজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_118",
            category = VocabCategory.FOOD,
            singularTarget = "Honey",
            singularBnPron = "হানি",
            pluralTarget = "Honeys",
            pluralBnPron = "হানিস",
            bnMeaning = "মধু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_119",
            category = VocabCategory.FOOD,
            singularTarget = "Flour",
            singularBnPron = "ফ্লাওয়ার",
            pluralTarget = "Flours",
            pluralBnPron = "ফ্লাওয়ার্স",
            bnMeaning = "ময়দা / আটা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_120",
            category = VocabCategory.FOOD,
            singularTarget = "Yogurt",
            singularBnPron = "দই",
            pluralTarget = "Yogurts",
            pluralBnPron = "দই",
            bnMeaning = "দই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_121",
            category = VocabCategory.FOOD,
            singularTarget = "Juice",
            singularBnPron = "জুস",
            pluralTarget = "Juices",
            pluralBnPron = "জুসেস",
            bnMeaning = "রস / জুস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_122",
            category = VocabCategory.FOOD,
            singularTarget = "Ice",
            singularBnPron = "আইস",
            pluralTarget = "Ices",
            pluralBnPron = "আইসেস",
            bnMeaning = "বরফ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_123",
            category = VocabCategory.FOOD,
            singularTarget = "Cake",
            singularBnPron = "কেক",
            pluralTarget = "Cakes",
            pluralBnPron = "কেকস",
            bnMeaning = "কেক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_124",
            category = VocabCategory.FOOD,
            singularTarget = "Biscuit",
            singularBnPron = "বিস্কুট",
            pluralTarget = "Biscuits",
            pluralBnPron = "বিস্কুটস",
            bnMeaning = "বিস্কুট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_125",
            category = VocabCategory.FOOD,
            singularTarget = "Sweet",
            singularBnPron = "সুইট",
            pluralTarget = "Sweets",
            pluralBnPron = "সুইটস",
            bnMeaning = "মিষ্টি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_126",
            category = VocabCategory.FOOD,
            singularTarget = "Chocolate",
            singularBnPron = "চকলেট",
            pluralTarget = "Chocolates",
            pluralBnPron = "চকলেটস",
            bnMeaning = "চকলেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_127",
            category = VocabCategory.FOOD,
            singularTarget = "Spice",
            singularBnPron = "স্পাইস",
            pluralTarget = "Spices",
            pluralBnPron = "স্পাইসেস",
            bnMeaning = "মসলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_128",
            category = VocabCategory.FOOD,
            singularTarget = "Black pepper",
            singularBnPron = "ব্ল্যাক পেপার",
            pluralTarget = "Black peppers",
            pluralBnPron = "ব্ল্যাক পেপার্স",
            bnMeaning = "গোলমরিচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_129",
            category = VocabCategory.FOOD,
            singularTarget = "Chili",
            singularBnPron = "চিলি",
            pluralTarget = "Chilies",
            pluralBnPron = "চিলিস",
            bnMeaning = "মরিচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_130",
            category = VocabCategory.FOOD,
            singularTarget = "Turmeric",
            singularBnPron = "টারমারিক",
            pluralTarget = "Turmerics",
            pluralBnPron = "টারমারিকস",
            bnMeaning = "হলুদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_131",
            category = VocabCategory.FOOD,
            singularTarget = "Ginger",
            singularBnPron = "জিঞ্জার",
            pluralTarget = "Gingers",
            pluralBnPron = "জিঞ্জার্স",
            bnMeaning = "আদা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_132",
            category = VocabCategory.FOOD,
            singularTarget = "Garlic",
            singularBnPron = "গার্লিক",
            pluralTarget = "Garlics",
            pluralBnPron = "গার্লিকস",
            bnMeaning = "রসুন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_133",
            category = VocabCategory.FOOD,
            singularTarget = "Onion",
            singularBnPron = "অনিয়ন",
            pluralTarget = "Onions",
            pluralBnPron = "অনিয়নস",
            bnMeaning = "পেঁয়াজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_134",
            category = VocabCategory.FOOD,
            singularTarget = "Lentil",
            singularBnPron = "লেনটিল",
            pluralTarget = "Lentils",
            pluralBnPron = "লেনটিলস",
            bnMeaning = "ডাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_135",
            category = VocabCategory.FOOD,
            singularTarget = "Curry",
            singularBnPron = "কারি",
            pluralTarget = "Curries",
            pluralBnPron = "কারিস",
            bnMeaning = "তরকারি / কারি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_136",
            category = VocabCategory.FOOD,
            singularTarget = "Noodles",
            singularBnPron = "নুডলস",
            pluralTarget = "Noodles",
            pluralBnPron = "নুডলস",
            bnMeaning = "নুডলস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_137",
            category = VocabCategory.FOOD,
            singularTarget = "Burger",
            singularBnPron = "বার্গার",
            pluralTarget = "Burgers",
            pluralBnPron = "বার্গার্স",
            bnMeaning = "বার্গার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_138",
            category = VocabCategory.FOOD,
            singularTarget = "Salad",
            singularBnPron = "স্যালাড",
            pluralTarget = "Salads",
            pluralBnPron = "স্যালাডস",
            bnMeaning = "স্যালাড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_139",
            category = VocabCategory.FOOD,
            singularTarget = "Sauce",
            singularBnPron = "সস",
            pluralTarget = "Sauces",
            pluralBnPron = "সসেস",
            bnMeaning = "সস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_140",
            category = VocabCategory.FOOD,
            singularTarget = "Vinegar",
            singularBnPron = "ভিনেগার",
            pluralTarget = "Vinegars",
            pluralBnPron = "ভিনেগার্স",
            bnMeaning = "সিরকা / ভিনেগার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_141",
            category = VocabCategory.FOOD,
            singularTarget = "Nut",
            singularBnPron = "নাট",
            pluralTarget = "Nuts",
            pluralBnPron = "নাটস",
            bnMeaning = "বাদাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_142",
            category = VocabCategory.FOOD,
            singularTarget = "Sandwich",
            singularBnPron = "স্যান্ডউইচ",
            pluralTarget = "Sandwiches",
            pluralBnPron = "স্যান্ডউইচেস",
            bnMeaning = "স্যান্ডউইচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_143",
            category = VocabCategory.FOOD,
            singularTarget = "Pickle",
            singularBnPron = "পিকল",
            pluralTarget = "Pickles",
            pluralBnPron = "পিকলস",
            bnMeaning = "আচার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_144",
            category = VocabCategory.FOOD,
            singularTarget = "Snack",
            singularBnPron = "স্ন্যাক",
            pluralTarget = "Snacks",
            pluralBnPron = "স্ন্যাকস",
            bnMeaning = "জলখাবার / নাস্তা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_145",
            category = VocabCategory.FOOD,
            singularTarget = "Breakfast",
            singularBnPron = "ব্রেকফাস্ট",
            pluralTarget = "Breakfasts",
            pluralBnPron = "ব্রেকফাস্টস",
            bnMeaning = "সকালের নাস্তা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_146",
            category = VocabCategory.FOOD,
            singularTarget = "Lunch",
            singularBnPron = "লাঞ্চ",
            pluralTarget = "Lunches",
            pluralBnPron = "লাঞ্চেস",
            bnMeaning = "দুপুরের খাবার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_147",
            category = VocabCategory.FOOD,
            singularTarget = "Dinner",
            singularBnPron = "ডিনার",
            pluralTarget = "Dinners",
            pluralBnPron = "ডিনার্স",
            bnMeaning = "রাতের খাবার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_148",
            category = VocabCategory.FOOD,
            singularTarget = "Meal",
            singularBnPron = "মিল",
            pluralTarget = "Meals",
            pluralBnPron = "মিলস",
            bnMeaning = "ভোজ / খাবার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_149",
            category = VocabCategory.FOOD,
            singularTarget = "Thirst",
            singularBnPron = "থার্স্ট",
            pluralTarget = "Thirsts",
            pluralBnPron = "থার্স্টস",
            bnMeaning = "পিপাসা / তৃষ্ণা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_150",
            category = VocabCategory.FOOD,
            singularTarget = "Hunger",
            singularBnPron = "হাঙ্গার",
            pluralTarget = "Hungers",
            pluralBnPron = "হাঙ্গার্স",
            bnMeaning = "ক্ষুধা / ক্ষুধা পাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_151",
            category = VocabCategory.FRUITS,
            singularTarget = "Mango",
            singularBnPron = "ম্যাঙ্গো",
            pluralTarget = "Mangoes",
            pluralBnPron = "ম্যাঙ্গোস",
            bnMeaning = "আম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_152",
            category = VocabCategory.FRUITS,
            singularTarget = "Apple",
            singularBnPron = "অ্যাপেল",
            pluralTarget = "Apples",
            pluralBnPron = "অ্যাপেলস",
            bnMeaning = "আপেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_153",
            category = VocabCategory.FRUITS,
            singularTarget = "Banana",
            singularBnPron = "বানানা",
            pluralTarget = "Bananas",
            pluralBnPron = "বানানাস",
            bnMeaning = "কলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_154",
            category = VocabCategory.FRUITS,
            singularTarget = "Orange",
            singularBnPron = "অরেঞ্জ",
            pluralTarget = "Oranges",
            pluralBnPron = "অরেঞ্জেস",
            bnMeaning = "কমলালেবু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_155",
            category = VocabCategory.FRUITS,
            singularTarget = "Grape",
            singularBnPron = "গ্রেপ",
            pluralTarget = "Grapes",
            pluralBnPron = "গ্রেপস",
            bnMeaning = "আঙুর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_156",
            category = VocabCategory.FRUITS,
            singularTarget = "Lemon",
            singularBnPron = "লেমন",
            pluralTarget = "Lemons",
            pluralBnPron = "লেমনস",
            bnMeaning = "লেবু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_157",
            category = VocabCategory.FRUITS,
            singularTarget = "Watermelon",
            singularBnPron = "ওয়াটারমেলন",
            pluralTarget = "Watermelons",
            pluralBnPron = "ওয়াটারমেলনস",
            bnMeaning = "তরমুজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_158",
            category = VocabCategory.FRUITS,
            singularTarget = "Papaya",
            singularBnPron = "পাপায়া",
            pluralTarget = "Papayas",
            pluralBnPron = "পাপায়াস",
            bnMeaning = "পেঁপে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_159",
            category = VocabCategory.FRUITS,
            singularTarget = "Pineapple",
            singularBnPron = "পাইনঅ্যাপল",
            pluralTarget = "Pineapples",
            pluralBnPron = "পাইনঅ্যাপলস",
            bnMeaning = "আনারস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_160",
            category = VocabCategory.FRUITS,
            singularTarget = "Guava",
            singularBnPron = "গুয়াভা",
            pluralTarget = "Guavas",
            pluralBnPron = "গুয়াভাস",
            bnMeaning = "পেয়ারা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_161",
            category = VocabCategory.FRUITS,
            singularTarget = "Pomegranate",
            singularBnPron = "পোমেগ্রানেট",
            pluralTarget = "Pomegranates",
            pluralBnPron = "পোমেগ্রানেটস",
            bnMeaning = "ডালিম / বেদানা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_162",
            category = VocabCategory.FRUITS,
            singularTarget = "Coconut",
            singularBnPron = "কোকোনাট",
            pluralTarget = "Coconuts",
            pluralBnPron = "কোকোনাটস",
            bnMeaning = "নারকেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_163",
            category = VocabCategory.FRUITS,
            singularTarget = "Date",
            singularBnPron = "ডেট",
            pluralTarget = "Dates",
            pluralBnPron = "ডেটস",
            bnMeaning = "খেজুর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_164",
            category = VocabCategory.FRUITS,
            singularTarget = "Strawberry",
            singularBnPron = "স্ট্রবেরি",
            pluralTarget = "Strawberries",
            pluralBnPron = "স্ট্রবেরিস",
            bnMeaning = "স্ট্রবেরি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_165",
            category = VocabCategory.FRUITS,
            singularTarget = "Cherry",
            singularBnPron = "চেরি",
            pluralTarget = "Cherries",
            pluralBnPron = "চেরিস",
            bnMeaning = "চেরি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_166",
            category = VocabCategory.FRUITS,
            singularTarget = "Potato",
            singularBnPron = "পটেটো",
            pluralTarget = "Potatoes",
            pluralBnPron = "পটেটোস",
            bnMeaning = "আলু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_167",
            category = VocabCategory.FRUITS,
            singularTarget = "Tomato",
            singularBnPron = "টমেটো",
            pluralTarget = "Tomatoes",
            pluralBnPron = "টমেটোস",
            bnMeaning = "টমেটো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_168",
            category = VocabCategory.FRUITS,
            singularTarget = "Carrot",
            singularBnPron = "ক্যারট",
            pluralTarget = "Carrots",
            pluralBnPron = "ক্যারটস",
            bnMeaning = "গাজর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_169",
            category = VocabCategory.FRUITS,
            singularTarget = "Radish",
            singularBnPron = "র‍্যাডিশ",
            pluralTarget = "Radishes",
            pluralBnPron = "র‍্যাডিশেস",
            bnMeaning = "মুলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_170",
            category = VocabCategory.FRUITS,
            singularTarget = "Cabbage",
            singularBnPron = "ক্যাবাজ",
            pluralTarget = "Cabbages",
            pluralBnPron = "ক্যাবাজেসে",
            bnMeaning = "বাঁধাকপি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_171",
            category = VocabCategory.FRUITS,
            singularTarget = "Cauliflower",
            singularBnPron = "কলিফ্লাওয়ার",
            pluralTarget = "Cauliflowers",
            pluralBnPron = "কলিফ্লাওয়ার্স",
            bnMeaning = "ফুলকপি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_172",
            category = VocabCategory.FRUITS,
            singularTarget = "Spinach",
            singularBnPron = "স্পিনাচ",
            pluralTarget = "Spinaches",
            pluralBnPron = "স্পিনাচস",
            bnMeaning = "পালংশাক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_173",
            category = VocabCategory.FRUITS,
            singularTarget = "Cucumber",
            singularBnPron = "কিউকাম্বার",
            pluralTarget = "Cucumbers",
            pluralBnPron = "কিউকাম্বার্স",
            bnMeaning = "শসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_174",
            category = VocabCategory.FRUITS,
            singularTarget = "Pumpkin",
            singularBnPron = "পাম্পকিন",
            pluralTarget = "Pumpkins",
            pluralBnPron = "পাম্পকিনস",
            bnMeaning = "মিষ্টিকুমড়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_175",
            category = VocabCategory.FRUITS,
            singularTarget = "Eggplant",
            singularBnPron = "এগপ্লান্ট",
            pluralTarget = "Eggplants",
            pluralBnPron = "এগপ্লান্টস",
            bnMeaning = "বেগুন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_176",
            category = VocabCategory.FRUITS,
            singularTarget = "Pea",
            singularBnPron = "পী",
            pluralTarget = "Peas",
            pluralBnPron = "পিস",
            bnMeaning = "মটরশুঁটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_177",
            category = VocabCategory.FRUITS,
            singularTarget = "Okra",
            singularBnPron = "ওকরা",
            pluralTarget = "Okras",
            pluralBnPron = "ওকরাস",
            bnMeaning = "ঢ্যাঁড়শ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_178",
            category = VocabCategory.FRUITS,
            singularTarget = "Mushroom",
            singularBnPron = "মাশরুম",
            pluralTarget = "Mushrooms",
            pluralBnPron = "মাশরুমস",
            bnMeaning = "মাশরুম / ব্যাঙের ছাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_179",
            category = VocabCategory.FRUITS,
            singularTarget = "Corn",
            singularBnPron = "কর্ন",
            pluralTarget = "Corns",
            pluralBnPron = "কর্ন্স",
            bnMeaning = "ভূট্টা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_180",
            category = VocabCategory.FRUITS,
            singularTarget = "Mint",
            singularBnPron = "মিন্ট",
            pluralTarget = "Mints",
            pluralBnPron = "মিন্টস",
            bnMeaning = "পুদিনা পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_181",
            category = VocabCategory.FRUITS,
            singularTarget = "Coriander",
            singularBnPron = "করিয়েন্ডার",
            pluralTarget = "Corianders",
            pluralBnPron = "করিয়েন্ডার্স",
            bnMeaning = "ধনিয়া পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_182",
            category = VocabCategory.FRUITS,
            singularTarget = "Lettuce",
            singularBnPron = "লেটুস",
            pluralTarget = "Lettuces",
            pluralBnPron = "লেটুসেস",
            bnMeaning = "লেটুস পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_183",
            category = VocabCategory.FRUITS,
            singularTarget = "Beetroot",
            singularBnPron = "বিটমূল",
            pluralTarget = "Beetroots",
            pluralBnPron = "বিটমূল",
            bnMeaning = "বিট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_184",
            category = VocabCategory.FRUITS,
            singularTarget = "Capsicum",
            singularBnPron = "ক্যাপসিকাম",
            pluralTarget = "Capsicums",
            pluralBnPron = "ক্যাপসিকামস",
            bnMeaning = "ক্যাপসিকাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_185",
            category = VocabCategory.FRUITS,
            singularTarget = "Bottle gourd",
            singularBnPron = "বটল গুর্ড",
            pluralTarget = "Bottle gourds",
            pluralBnPron = "বটল গুর্ডস",
            bnMeaning = "লাউ / কদু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_186",
            category = VocabCategory.FRUITS,
            singularTarget = "Bitter gourd",
            singularBnPron = "বিটার গুর্ড",
            pluralTarget = "Bitter gourds",
            pluralBnPron = "বিটার গুর্ডস",
            bnMeaning = "করলা / উচ্ছে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_187",
            category = VocabCategory.FRUITS,
            singularTarget = "Jackfruit",
            singularBnPron = "জ্যাকফ্রুট",
            pluralTarget = "Jackfruits",
            pluralBnPron = "জ্যাকফ্রুটস",
            bnMeaning = "কাঁঠাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_188",
            category = VocabCategory.FRUITS,
            singularTarget = "Litchi",
            singularBnPron = "লিচু",
            pluralTarget = "Litchis",
            pluralBnPron = "লিচিস",
            bnMeaning = "লিচু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_189",
            category = VocabCategory.FRUITS,
            singularTarget = "Olive",
            singularBnPron = "অলিভ",
            pluralTarget = "Olives",
            pluralBnPron = "অলিভস",
            bnMeaning = "জলপাই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_190",
            category = VocabCategory.FRUITS,
            singularTarget = "Fig",
            singularBnPron = "ফিগ",
            pluralTarget = "Figs",
            pluralBnPron = "ফিগস",
            bnMeaning = "ডুমুর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_191",
            category = VocabCategory.FRUITS,
            singularTarget = "Pear",
            singularBnPron = "পিয়ার",
            pluralTarget = "Pears",
            pluralBnPron = "পিয়ার্স",
            bnMeaning = "নাশপাতি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_192",
            category = VocabCategory.FRUITS,
            singularTarget = "Peach",
            singularBnPron = "পীচ",
            pluralTarget = "Peaches",
            pluralBnPron = "পীচেস",
            bnMeaning = "পীচ ফল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_193",
            category = VocabCategory.FRUITS,
            singularTarget = "Plum",
            singularBnPron = "প্লাম",
            pluralTarget = "Plums",
            pluralBnPron = "প্লামস",
            bnMeaning = "আলুবোখারা / প্লাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_194",
            category = VocabCategory.FRUITS,
            singularTarget = "Turnip",
            singularBnPron = "টার্নিপ",
            pluralTarget = "Turnips",
            pluralBnPron = "টার্নিপস",
            bnMeaning = "শালগম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_195",
            category = VocabCategory.FRUITS,
            singularTarget = "Sweet potato",
            singularBnPron = "সুইট পটেটো",
            pluralTarget = "Sweet potatoes",
            pluralBnPron = "সুইট পটেটোস",
            bnMeaning = "মিষ্টি আলু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_196",
            category = VocabCategory.FRUITS,
            singularTarget = "Soybean",
            singularBnPron = "সয়াবিন",
            pluralTarget = "Soybeans",
            pluralBnPron = "সয়াবিনস",
            bnMeaning = "সয়াবিন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_197",
            category = VocabCategory.FRUITS,
            singularTarget = "Vegetable",
            singularBnPron = "ভেজিটেবল",
            pluralTarget = "Vegetables",
            pluralBnPron = "ভেজিটেবলস",
            bnMeaning = "সবজি (সাধারণ)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_198",
            category = VocabCategory.FRUITS,
            singularTarget = "Fruit",
            singularBnPron = "ফ্রুট",
            pluralTarget = "Fruits",
            pluralBnPron = "ফ্রুটস",
            bnMeaning = "ফল (সাধারণ)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_199",
            category = VocabCategory.FRUITS,
            singularTarget = "Plant",
            singularBnPron = "প্ল্যান্ট",
            pluralTarget = "Plants",
            pluralBnPron = "প্ল্যান্টস",
            bnMeaning = "গাছ / কাণ্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_200",
            category = VocabCategory.FRUITS,
            singularTarget = "Seed",
            singularBnPron = "সিড",
            pluralTarget = "Seeds",
            pluralBnPron = "সিডস",
            bnMeaning = "বীজ",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk3 = listOf(
        VocabItem(
            id = "en_vocab_201",
            category = VocabCategory.HOME,
            singularTarget = "House",
            singularBnPron = "হাউস",
            pluralTarget = "Houses",
            pluralBnPron = "হাউসেস",
            bnMeaning = "বাড়ি / ঘর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_202",
            category = VocabCategory.HOME,
            singularTarget = "Room",
            singularBnPron = "রুম",
            pluralTarget = "Rooms",
            pluralBnPron = "রুমস",
            bnMeaning = "কক্ষ / রুম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_203",
            category = VocabCategory.HOME,
            singularTarget = "Door",
            singularBnPron = "ডোর",
            pluralTarget = "Doors",
            pluralBnPron = "ডোরস",
            bnMeaning = "দরজা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_204",
            category = VocabCategory.HOME,
            singularTarget = "Window",
            singularBnPron = "উইন্ডো",
            pluralTarget = "Windows",
            pluralBnPron = "উইন্ডোস",
            bnMeaning = "জানালা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_205",
            category = VocabCategory.HOME,
            singularTarget = "Wall",
            singularBnPron = "ওয়াল",
            pluralTarget = "Walls",
            pluralBnPron = "ওয়ালস",
            bnMeaning = "দেয়াল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_206",
            category = VocabCategory.HOME,
            singularTarget = "Floor",
            singularBnPron = "ফ্লোর",
            pluralTarget = "Floors",
            pluralBnPron = "ফ্লোরস",
            bnMeaning = "মেঝে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_207",
            category = VocabCategory.HOME,
            singularTarget = "Roof",
            singularBnPron = "রুফ",
            pluralTarget = "Roofs",
            pluralBnPron = "রুফস",
            bnMeaning = "ছাদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_208",
            category = VocabCategory.HOME,
            singularTarget = "Ceiling",
            singularBnPron = "সিলিং",
            pluralTarget = "Ceilings",
            pluralBnPron = "সিলিংস",
            bnMeaning = "সিলিং (ঘরের ভেতর ছাদ)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_209",
            category = VocabCategory.HOME,
            singularTarget = "Bedroom",
            singularBnPron = "বেডরুম",
            pluralTarget = "Bedrooms",
            pluralBnPron = "বেডরুমস",
            bnMeaning = "শোবার ঘর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_210",
            category = VocabCategory.HOME,
            singularTarget = "Bathroom",
            singularBnPron = "বাথরুম",
            pluralTarget = "Bathrooms",
            pluralBnPron = "বাথরুমস",
            bnMeaning = "গোসলখানা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_211",
            category = VocabCategory.HOME,
            singularTarget = "Kitchen",
            singularBnPron = "কিচেন",
            pluralTarget = "Kitchens",
            pluralBnPron = "কিচেনস",
            bnMeaning = "রান্নাঘর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_212",
            category = VocabCategory.HOME,
            singularTarget = "Dining room",
            singularBnPron = "ডাইনিং রুম",
            pluralTarget = "Dining rooms",
            pluralBnPron = "ডাইনিং রুমস",
            bnMeaning = "খাবার ঘর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_213",
            category = VocabCategory.HOME,
            singularTarget = "Living room",
            singularBnPron = "লিভিং রুম",
            pluralTarget = "Living rooms",
            pluralBnPron = "লিভিং রুমস",
            bnMeaning = "বসার ঘর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_214",
            category = VocabCategory.HOME,
            singularTarget = "Balcony",
            singularBnPron = "ব্যালকনি",
            pluralTarget = "Balconies",
            pluralBnPron = "ব্যালকনিস",
            bnMeaning = "বারান্দা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_215",
            category = VocabCategory.HOME,
            singularTarget = "Garden",
            singularBnPron = "গার্ডেন",
            pluralTarget = "Gardens",
            pluralBnPron = "গার্ডেনস",
            bnMeaning = "বাগান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_216",
            category = VocabCategory.HOME,
            singularTarget = "Gate",
            singularBnPron = "গেট",
            pluralTarget = "Gates",
            pluralBnPron = "গেটস",
            bnMeaning = "গেট / ফটক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_217",
            category = VocabCategory.HOME,
            singularTarget = "Stairs",
            singularBnPron = "স্টেয়ার্স",
            pluralTarget = "Stairs",
            pluralBnPron = "স্টেয়ার্স",
            bnMeaning = "সিঁড়ি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_218",
            category = VocabCategory.HOME,
            singularTarget = "Elevator",
            singularBnPron = "এলিভেটর",
            pluralTarget = "Elevators",
            pluralBnPron = "এলিভেটরস",
            bnMeaning = "লিফট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_219",
            category = VocabCategory.HOME,
            singularTarget = "Bed",
            singularBnPron = "বেড",
            pluralTarget = "Beds",
            pluralBnPron = "বেডস",
            bnMeaning = "বিছানা / খাট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_220",
            category = VocabCategory.HOME,
            singularTarget = "Pillow",
            singularBnPron = "পিলো",
            pluralTarget = "Pillows",
            pluralBnPron = "পিলোস",
            bnMeaning = "বালিশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_221",
            category = VocabCategory.HOME,
            singularTarget = "Blanket",
            singularBnPron = "ব্ল্যাঙ্কেট",
            pluralTarget = "Blankets",
            pluralBnPron = "ব্ল্যাঙ্কেটস",
            bnMeaning = "কম্বল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_222",
            category = VocabCategory.HOME,
            singularTarget = "Mattress",
            singularBnPron = "ম্যাট্রেস",
            pluralTarget = "Mattresses",
            pluralBnPron = "ম্যাট্রেসেস",
            bnMeaning = "গদি / তোশক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_223",
            category = VocabCategory.HOME,
            singularTarget = "Bedsheet",
            singularBnPron = "বেডশিট",
            pluralTarget = "Bedsheets",
            pluralBnPron = "বেডশিটস",
            bnMeaning = "চাদর (বিছানার)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_224",
            category = VocabCategory.HOME,
            singularTarget = "Table",
            singularBnPron = "টেবিল",
            pluralTarget = "Tables",
            pluralBnPron = "টেবিলস",
            bnMeaning = "টেবিল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_225",
            category = VocabCategory.HOME,
            singularTarget = "Chair",
            singularBnPron = "চেয়ার",
            pluralTarget = "Chairs",
            pluralBnPron = "চেয়ার্স",
            bnMeaning = "চেয়ার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_226",
            category = VocabCategory.HOME,
            singularTarget = "Sofa",
            singularBnPron = "সোফা",
            pluralTarget = "Sofas",
            pluralBnPron = "সোফাস",
            bnMeaning = "সোফা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_227",
            category = VocabCategory.HOME,
            singularTarget = "Desk",
            singularBnPron = "ডেস্ক",
            pluralTarget = "Desks",
            pluralBnPron = "ডেস্কস",
            bnMeaning = "পড়ার টেবিল / ডেস্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_228",
            category = VocabCategory.HOME,
            singularTarget = "Closet",
            singularBnPron = "ক্লোজেট",
            pluralTarget = "Closets",
            pluralBnPron = "ক্লোজেটস",
            bnMeaning = "আলমারি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_229",
            category = VocabCategory.HOME,
            singularTarget = "Drawer",
            singularBnPron = "ড্রয়ার",
            pluralTarget = "Drawers",
            pluralBnPron = "ড্রয়ার্স",
            bnMeaning = "ড্রয়ার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_230",
            category = VocabCategory.HOME,
            singularTarget = "Shelf",
            singularBnPron = "শেলফ",
            pluralTarget = "Shelves",
            pluralBnPron = "শেলভস",
            bnMeaning = "তাক / শেলফ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_231",
            category = VocabCategory.HOME,
            singularTarget = "Mirror",
            singularBnPron = "মিরর",
            pluralTarget = "Mirrors",
            pluralBnPron = "মিররস",
            bnMeaning = "আয়না",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_232",
            category = VocabCategory.HOME,
            singularTarget = "Lamp",
            singularBnPron = "ল্যাম্প",
            pluralTarget = "Lamps",
            pluralBnPron = "ল্যাম্পস",
            bnMeaning = "বাতি / ল্যাম্প",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_233",
            category = VocabCategory.HOME,
            singularTarget = "Light",
            singularBnPron = "লাইট",
            pluralTarget = "Lights",
            pluralBnPron = "লাইটস",
            bnMeaning = "আলো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_234",
            category = VocabCategory.HOME,
            singularTarget = "Fan",
            singularBnPron = "ফ্যান",
            pluralTarget = "Fans",
            pluralBnPron = "ফ্যানস",
            bnMeaning = "পাখা / ফ্যান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_235",
            category = VocabCategory.HOME,
            singularTarget = "Clock",
            singularBnPron = "ক্লক",
            pluralTarget = "Clocks",
            pluralBnPron = "ক্লকস",
            bnMeaning = "ঘড়ি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_236",
            category = VocabCategory.HOME,
            singularTarget = "Television",
            singularBnPron = "টেলিভিশন",
            pluralTarget = "Televisions",
            pluralBnPron = "টেলিভিশনস",
            bnMeaning = "টেলিভিশন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_237",
            category = VocabCategory.HOME,
            singularTarget = "Curtain",
            singularBnPron = "কার্টেন",
            pluralTarget = "Curtains",
            pluralBnPron = "কার্টেন্স",
            bnMeaning = "পর্দা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_238",
            category = VocabCategory.HOME,
            singularTarget = "Carpet",
            singularBnPron = "কার্পেট",
            pluralTarget = "Carpets",
            pluralBnPron = "কার্পেটস",
            bnMeaning = "কার্পেট / গালিচা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_239",
            category = VocabCategory.HOME,
            singularTarget = "Lock",
            singularBnPron = "লক",
            pluralTarget = "Locks",
            pluralBnPron = "লকস",
            bnMeaning = "তালা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_240",
            category = VocabCategory.HOME,
            singularTarget = "Key",
            singularBnPron = "কি",
            pluralTarget = "Keys",
            pluralBnPron = "কিস",
            bnMeaning = "চাবি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_241",
            category = VocabCategory.HOME,
            singularTarget = "Bell",
            singularBnPron = "বেল",
            pluralTarget = "Bells",
            pluralBnPron = "বেলস",
            bnMeaning = "ঘণ্টি / বেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_242",
            category = VocabCategory.HOME,
            singularTarget = "Painting",
            singularBnPron = "পেইন্টিং",
            pluralTarget = "Paintings",
            pluralBnPron = "পেইন্টিংস",
            bnMeaning = "ছবি / চিত্রকর্ম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_243",
            category = VocabCategory.HOME,
            singularTarget = "Vase",
            singularBnPron = "ভ্যাস",
            pluralTarget = "Vases",
            pluralBnPron = "ভ্যাসেস",
            bnMeaning = "ফুলদানি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_244",
            category = VocabCategory.HOME,
            singularTarget = "Broom",
            singularBnPron = "ব্রুম",
            pluralTarget = "Brooms",
            pluralBnPron = "ব্রুমস",
            bnMeaning = "ঝাঁটা / ঝাড়ু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_245",
            category = VocabCategory.HOME,
            singularTarget = "Dustbin",
            singularBnPron = "ডাস্টবিন",
            pluralTarget = "Dustbins",
            pluralBnPron = "ডাস্টবিনস",
            bnMeaning = "ময়লার ঝুড়ি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_246",
            category = VocabCategory.HOME,
            singularTarget = "Tap",
            singularBnPron = "ট্যাপ",
            pluralTarget = "Taps",
            pluralBnPron = "ট্যাপস",
            bnMeaning = "পানির কল / ট্যাপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_247",
            category = VocabCategory.HOME,
            singularTarget = "Pipe",
            singularBnPron = "পাইপ",
            pluralTarget = "Pipes",
            pluralBnPron = "পাইপস",
            bnMeaning = "নল / পাইপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_248",
            category = VocabCategory.HOME,
            singularTarget = "Fence",
            singularBnPron = "ফেন্স",
            pluralTarget = "Fences",
            pluralBnPron = "ফেন্সেস",
            bnMeaning = "বেড়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_249",
            category = VocabCategory.HOME,
            singularTarget = "Shade",
            singularBnPron = "শেড",
            pluralTarget = "Shades",
            pluralBnPron = "শেডস",
            bnMeaning = "ছায়া / শেড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_250",
            category = VocabCategory.HOME,
            singularTarget = "Threshold",
            singularBnPron = "থ্রেশহোল্ড",
            pluralTarget = "Thresholds",
            pluralBnPron = "থ্রেশহোল্ডস",
            bnMeaning = "চৌকাঠ / সীমানা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_251",
            category = VocabCategory.CLOTHES,
            singularTarget = "Shirt",
            singularBnPron = "শার্ট",
            pluralTarget = "Shirts",
            pluralBnPron = "শার্টস",
            bnMeaning = "শার্ট / জামা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_252",
            category = VocabCategory.CLOTHES,
            singularTarget = "T-shirt",
            singularBnPron = "টি-শার্ট",
            pluralTarget = "T-shirts",
            pluralBnPron = "টি-শার্টস",
            bnMeaning = "টি-শার্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_253",
            category = VocabCategory.CLOTHES,
            singularTarget = "Pants",
            singularBnPron = "প্যান্টস",
            pluralTarget = "Pants",
            pluralBnPron = "প্যান্টস",
            bnMeaning = "প্যান্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_254",
            category = VocabCategory.CLOTHES,
            singularTarget = "Jeans",
            singularBnPron = "জিন্স",
            pluralTarget = "Jeans",
            pluralBnPron = "জিন্স",
            bnMeaning = "জিন্স প্যান্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_255",
            category = VocabCategory.CLOTHES,
            singularTarget = "Shorts",
            singularBnPron = "শর্টস",
            pluralTarget = "Shorts",
            pluralBnPron = "শর্টস",
            bnMeaning = "হাফ প্যান্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_256",
            category = VocabCategory.CLOTHES,
            singularTarget = "Dress",
            singularBnPron = "ড্রেস",
            pluralTarget = "Dresses",
            pluralBnPron = "ড্রেসেস",
            bnMeaning = "পোশাক / জামা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_257",
            category = VocabCategory.CLOTHES,
            singularTarget = "Skirt",
            singularBnPron = "স্কার্ট",
            pluralTarget = "Skirts",
            pluralBnPron = "স্কার্টস",
            bnMeaning = "স্কার্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_258",
            category = VocabCategory.CLOTHES,
            singularTarget = "Jacket",
            singularBnPron = "জ্যাকেট",
            pluralTarget = "Jackets",
            pluralBnPron = "জ্যাকেটস",
            bnMeaning = "জ্যাকেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_259",
            category = VocabCategory.CLOTHES,
            singularTarget = "Coat",
            singularBnPron = "কোট",
            pluralTarget = "Coats",
            pluralBnPron = "কোটস",
            bnMeaning = "কোট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_260",
            category = VocabCategory.CLOTHES,
            singularTarget = "Sweater",
            singularBnPron = "সোয়েটার",
            pluralTarget = "Sweaters",
            pluralBnPron = "সোয়েটার্স",
            bnMeaning = "সোয়েটার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_261",
            category = VocabCategory.CLOTHES,
            singularTarget = "Suit",
            singularBnPron = "স্যুট",
            pluralTarget = "Suits",
            pluralBnPron = "স্যুটস",
            bnMeaning = "স্যুট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_262",
            category = VocabCategory.CLOTHES,
            singularTarget = "Tie",
            singularBnPron = "টাই",
            pluralTarget = "Ties",
            pluralBnPron = "টাইস",
            bnMeaning = "টাই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_263",
            category = VocabCategory.CLOTHES,
            singularTarget = "Scarf",
            singularBnPron = "স্কার্ফ",
            pluralTarget = "Scarves",
            pluralBnPron = "স্কার্ভস",
            bnMeaning = "মাফলার / স্কার্ফ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_264",
            category = VocabCategory.CLOTHES,
            singularTarget = "Glove",
            singularBnPron = "গ্লাভ",
            pluralTarget = "Gloves",
            pluralBnPron = "গ্লাভস",
            bnMeaning = "দস্তানা / গ্লাভস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_265",
            category = VocabCategory.CLOTHES,
            singularTarget = "Sock",
            singularBnPron = "সক",
            pluralTarget = "Socks",
            pluralBnPron = "সকস",
            bnMeaning = "মোজা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_266",
            category = VocabCategory.CLOTHES,
            singularTarget = "Shoe",
            singularBnPron = "শু",
            pluralTarget = "Shoes",
            pluralBnPron = "শুজ",
            bnMeaning = "জুতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_267",
            category = VocabCategory.CLOTHES,
            singularTarget = "Boot",
            singularBnPron = "বুট",
            pluralTarget = "Boots",
            pluralBnPron = "বুটস",
            bnMeaning = "বুট জুতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_268",
            category = VocabCategory.CLOTHES,
            singularTarget = "Slipper",
            singularBnPron = "স্লিপার",
            pluralTarget = "Slippers",
            pluralBnPron = "স্লিপার্স",
            bnMeaning = "চটি / স্লিপার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_269",
            category = VocabCategory.CLOTHES,
            singularTarget = "Sandal",
            singularBnPron = "স্যান্ডাল",
            pluralTarget = "Sandals",
            pluralBnPron = "স্যান্ডালস",
            bnMeaning = "স্যান্ডেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_270",
            category = VocabCategory.CLOTHES,
            singularTarget = "Hat",
            singularBnPron = "হ্যাট",
            pluralTarget = "Hats",
            pluralBnPron = "হ্যাটস",
            bnMeaning = "টুপি (হ্যাট)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_271",
            category = VocabCategory.CLOTHES,
            singularTarget = "Cap",
            singularBnPron = "ক্যাপ",
            pluralTarget = "Caps",
            pluralBnPron = "ক্যাপস",
            bnMeaning = "ক্যাপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_272",
            category = VocabCategory.CLOTHES,
            singularTarget = "Belt",
            singularBnPron = "বেল্ট",
            pluralTarget = "Belts",
            pluralBnPron = "বেল্টস",
            bnMeaning = "বেল্ট / কোমরবন্ধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_273",
            category = VocabCategory.CLOTHES,
            singularTarget = "Ring",
            singularBnPron = "রিং",
            pluralTarget = "Rings",
            pluralBnPron = "রিংস",
            bnMeaning = "আংটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_274",
            category = VocabCategory.CLOTHES,
            singularTarget = "Necklace",
            singularBnPron = "নেকলেস",
            pluralTarget = "Necklaces",
            pluralBnPron = "নেকলেসেস",
            bnMeaning = "গলার হার / নেকলেস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_275",
            category = VocabCategory.CLOTHES,
            singularTarget = "Bracelet",
            singularBnPron = "ব্রেসলেট",
            pluralTarget = "Bracelets",
            pluralBnPron = "ব্রেসলেটস",
            bnMeaning = "ব্রেসলেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_276",
            category = VocabCategory.CLOTHES,
            singularTarget = "Watch",
            singularBnPron = "ওয়াচ",
            pluralTarget = "Watches",
            pluralBnPron = "ওয়াচেস",
            bnMeaning = "হাতঘড়ি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_277",
            category = VocabCategory.CLOTHES,
            singularTarget = "Umbrella",
            singularBnPron = "আমব্রেলা",
            pluralTarget = "Umbrellas",
            pluralBnPron = "আমব্রেলাস",
            bnMeaning = "ছাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_278",
            category = VocabCategory.CLOTHES,
            singularTarget = "Glasses",
            singularBnPron = "গ্লাসেস",
            pluralTarget = "Glasses",
            pluralBnPron = "গ্লাসেস",
            bnMeaning = "চশমা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_279",
            category = VocabCategory.CLOTHES,
            singularTarget = "Sunglasses",
            singularBnPron = "সানগ্লাসেস",
            pluralTarget = "Sunglasses",
            pluralBnPron = "সানগ্লাসেস",
            bnMeaning = "রোদচশমা / সানগ্লাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_280",
            category = VocabCategory.CLOTHES,
            singularTarget = "Wallet",
            singularBnPron = "ওয়ালেট",
            pluralTarget = "Wallets",
            pluralBnPron = "ওয়ালেটস",
            bnMeaning = "মানিব্যাগ / ওয়ালেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_281",
            category = VocabCategory.CLOTHES,
            singularTarget = "Purse",
            singularBnPron = "পার্স",
            pluralTarget = "Purses",
            pluralBnPron = "পার্সেস",
            bnMeaning = "হাতব্যাগ / পার্স",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_282",
            category = VocabCategory.CLOTHES,
            singularTarget = "Backpack",
            singularBnPron = "ব্যাকপ্যাক",
            pluralTarget = "Backpacks",
            pluralBnPron = "ব্যাকপ্যাকস",
            bnMeaning = "পিঠের ব্যাগ / ব্যাকপ্যাক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_283",
            category = VocabCategory.CLOTHES,
            singularTarget = "Button",
            singularBnPron = "বাটন",
            pluralTarget = "Buttons",
            pluralBnPron = "বাটনস",
            bnMeaning = "বোতাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_284",
            category = VocabCategory.CLOTHES,
            singularTarget = "Zipper",
            singularBnPron = "জিপার",
            pluralTarget = "Zippers",
            pluralBnPron = "জিপার্স",
            bnMeaning = "চেইন / জিপার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_285",
            category = VocabCategory.CLOTHES,
            singularTarget = "Pocket",
            singularBnPron = "পকেট",
            pluralTarget = "Pockets",
            pluralBnPron = "পকেটস",
            bnMeaning = "পকেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_286",
            category = VocabCategory.CLOTHES,
            singularTarget = "Collar",
            singularBnPron = "কলার",
            pluralTarget = "Collars",
            pluralBnPron = "কলার্স",
            bnMeaning = "কলার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_287",
            category = VocabCategory.CLOTHES,
            singularTarget = "Sleeve",
            singularBnPron = "স্লিভ",
            pluralTarget = "Sleeves",
            pluralBnPron = "স্লিভস",
            bnMeaning = "হাতা (জামা)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_288",
            category = VocabCategory.CLOTHES,
            singularTarget = "Uniform",
            singularBnPron = "ইউনিফর্ম",
            pluralTarget = "Uniforms",
            pluralBnPron = "ইউনিফর্মস",
            bnMeaning = "ইউনিফর্ম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_289",
            category = VocabCategory.CLOTHES,
            singularTarget = "Pyjamas",
            singularBnPron = "পাজামাস",
            pluralTarget = "Pyjamas",
            pluralBnPron = "পাজামাস",
            bnMeaning = "পায়জামা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_290",
            category = VocabCategory.CLOTHES,
            singularTarget = "Underwear",
            singularBnPron = "আন্ডারওয়্যার",
            pluralTarget = "Underwear",
            pluralBnPron = "আন্ডারওয়্যার",
            bnMeaning = "অন্তর্বাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_291",
            category = VocabCategory.CLOTHES,
            singularTarget = "Raincoat",
            singularBnPron = "রেইনকোট",
            pluralTarget = "Raincoats",
            pluralBnPron = "রেইনকোটস",
            bnMeaning = "বৃষ্টির কোট / রেইনকোট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_292",
            category = VocabCategory.CLOTHES,
            singularTarget = "Vest",
            singularBnPron = "ভেস্ট",
            pluralTarget = "Vests",
            pluralBnPron = "ভেস্টস",
            bnMeaning = "কটি / ভেস্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_293",
            category = VocabCategory.CLOTHES,
            singularTarget = "Swimsuit",
            singularBnPron = "সুইমসুট",
            pluralTarget = "Swimsuits",
            pluralBnPron = "সুইমসুটস",
            bnMeaning = "সাঁতারের পোশাক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_294",
            category = VocabCategory.CLOTHES,
            singularTarget = "Shawl",
            singularBnPron = "শাল",
            pluralTarget = "Shawls",
            pluralBnPron = "শালস",
            bnMeaning = "শাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_295",
            category = VocabCategory.CLOTHES,
            singularTarget = "Veil",
            singularBnPron = "ভেইল",
            pluralTarget = "Veils",
            pluralBnPron = "ভেইলস",
            bnMeaning = "ওড়না",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_296",
            category = VocabCategory.CLOTHES,
            singularTarget = "Thread",
            singularBnPron = "থ্রেড",
            pluralTarget = "Threads",
            pluralBnPron = "থ্রেডস",
            bnMeaning = "সুতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_297",
            category = VocabCategory.CLOTHES,
            singularTarget = "Needle",
            singularBnPron = "নিডল",
            pluralTarget = "Needles",
            pluralBnPron = "নিডলস",
            bnMeaning = "সুই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_298",
            category = VocabCategory.CLOTHES,
            singularTarget = "Cloth",
            singularBnPron = "ক্লথ",
            pluralTarget = "Clothes",
            pluralBnPron = "ক্লোথস",
            bnMeaning = "কাপড় / বস্ত্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_299",
            category = VocabCategory.CLOTHES,
            singularTarget = "Silk",
            singularBnPron = "সিল্ক",
            pluralTarget = "Silks",
            pluralBnPron = "সিল্কস",
            bnMeaning = "রেশম / সিল্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_300",
            category = VocabCategory.CLOTHES,
            singularTarget = "Cotton",
            singularBnPron = "কটন",
            pluralTarget = "Cottons",
            pluralBnPron = "কটনস",
            bnMeaning = "তুলা / সুতি",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk4 = listOf(
        VocabItem(
            id = "en_vocab_301",
            category = VocabCategory.PLACES,
            singularTarget = "City",
            singularBnPron = "সিটি",
            pluralTarget = "Cities",
            pluralBnPron = "সিটিস",
            bnMeaning = "শহর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_302",
            category = VocabCategory.PLACES,
            singularTarget = "Village",
            singularBnPron = "ভিলেজ",
            pluralTarget = "Villages",
            pluralBnPron = "ভিলেজেস",
            bnMeaning = "গ্রাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_303",
            category = VocabCategory.PLACES,
            singularTarget = "Country",
            singularBnPron = "কান্ট্রি",
            pluralTarget = "Countries",
            pluralBnPron = "কান্ট্রিস",
            bnMeaning = "দেশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_304",
            category = VocabCategory.PLACES,
            singularTarget = "Town",
            singularBnPron = "টাউন",
            pluralTarget = "Towns",
            pluralBnPron = "টাউনস",
            bnMeaning = "ছোট শহর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_305",
            category = VocabCategory.PLACES,
            singularTarget = "Road",
            singularBnPron = "রোড",
            pluralTarget = "Roads",
            pluralBnPron = "রোডস",
            bnMeaning = "রাস্তা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_306",
            category = VocabCategory.PLACES,
            singularTarget = "Bridge",
            singularBnPron = "ব্রিজ",
            pluralTarget = "Bridges",
            pluralBnPron = "ব্রিজেস",
            bnMeaning = "সেতু / ব্রিজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_307",
            category = VocabCategory.PLACES,
            singularTarget = "River",
            singularBnPron = "রিভার",
            pluralTarget = "Rivers",
            pluralBnPron = "রিভার্স",
            bnMeaning = "নদী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_308",
            category = VocabCategory.PLACES,
            singularTarget = "Park",
            singularBnPron = "পার্ক",
            pluralTarget = "Parks",
            pluralBnPron = "পার্কস",
            bnMeaning = "উদ্যান / পার্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_309",
            category = VocabCategory.PLACES,
            singularTarget = "Garden",
            singularBnPron = "গার্ডেন",
            pluralTarget = "Gardens",
            pluralBnPron = "গার্ডেনস",
            bnMeaning = "বাগান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_310",
            category = VocabCategory.PLACES,
            singularTarget = "Market",
            singularBnPron = "মার্কেট",
            pluralTarget = "Markets",
            pluralBnPron = "মার্কেটস",
            bnMeaning = "বাজার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_311",
            category = VocabCategory.PLACES,
            singularTarget = "Shop",
            singularBnPron = "শপ",
            pluralTarget = "Shops",
            pluralBnPron = "শপস",
            bnMeaning = "দোকান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_312",
            category = VocabCategory.PLACES,
            singularTarget = "Supermarket",
            singularBnPron = "সুপারমার্কেট",
            pluralTarget = "Supermarkets",
            pluralBnPron = "সুপারমার্কেটস",
            bnMeaning = "সুপারমার্কেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_313",
            category = VocabCategory.PLACES,
            singularTarget = "Bank",
            singularBnPron = "ব্যাংক",
            pluralTarget = "Banks",
            pluralBnPron = "ব্যাংকস",
            bnMeaning = "ব্যাংক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_314",
            category = VocabCategory.PLACES,
            singularTarget = "Hospital",
            singularBnPron = "হসপিটাল",
            pluralTarget = "Hospitals",
            pluralBnPron = "হসপিটালস",
            bnMeaning = "হাসপাতাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_315",
            category = VocabCategory.PLACES,
            singularTarget = "Pharmacy",
            singularBnPron = "ফার্মেসি",
            pluralTarget = "Pharmacies",
            pluralBnPron = "ফার্মেসিস",
            bnMeaning = "ঔষধের দোকান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_316",
            category = VocabCategory.PLACES,
            singularTarget = "School",
            singularBnPron = "স্কুল",
            pluralTarget = "Schools",
            pluralBnPron = "স্কুলস",
            bnMeaning = "বিদ্যালয় / স্কুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_317",
            category = VocabCategory.PLACES,
            singularTarget = "College",
            singularBnPron = "কলেজ",
            pluralTarget = "Colleges",
            pluralBnPron = "কলেজেস",
            bnMeaning = "কলেজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_318",
            category = VocabCategory.PLACES,
            singularTarget = "University",
            singularBnPron = "ইউনিভার্সিটি",
            pluralTarget = "Universities",
            pluralBnPron = "ইউনিভার্সিটিস",
            bnMeaning = "বিশ্ববিদ্যালয়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_319",
            category = VocabCategory.PLACES,
            singularTarget = "Library",
            singularBnPron = "লাইব্রেরি",
            pluralTarget = "Libraries",
            pluralBnPron = "লাইব্রেরিস",
            bnMeaning = "গ্রন্থাগার / লাইব্রেরি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_320",
            category = VocabCategory.PLACES,
            singularTarget = "Museum",
            singularBnPron = "মিউজিয়াম",
            pluralTarget = "Museums",
            pluralBnPron = "মিউজিয়ামস",
            bnMeaning = "জাদুঘর / মিউজিয়াম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_321",
            category = VocabCategory.PLACES,
            singularTarget = "Hotel",
            singularBnPron = "হোটেল",
            pluralTarget = "Hotels",
            pluralBnPron = "হোটেলস",
            bnMeaning = "হোটেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_322",
            category = VocabCategory.PLACES,
            singularTarget = "Restaurant",
            singularBnPron = "রেস্তোরাঁ",
            pluralTarget = "Restaurants",
            pluralBnPron = "রেস্তোরাঁস",
            bnMeaning = "রেস্তোরাঁ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_323",
            category = VocabCategory.PLACES,
            singularTarget = "Cafe",
            singularBnPron = "ক্যাফে",
            pluralTarget = "Cafes",
            pluralBnPron = "ক্যাফেস",
            bnMeaning = "ক্যাফে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_324",
            category = VocabCategory.PLACES,
            singularTarget = "Airport",
            singularBnPron = "এয়ারপোর্ট",
            pluralTarget = "Airports",
            pluralBnPron = "এয়ারপোর্টস",
            bnMeaning = "বিমানবন্দর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_325",
            category = VocabCategory.PLACES,
            singularTarget = "Railway station",
            singularBnPron = "রেলওয়ে স্টেশন",
            pluralTarget = "Railway stations",
            pluralBnPron = "রেলওয়ে স্টেশনস",
            bnMeaning = "রেলওয়ে স্টেশন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_326",
            category = VocabCategory.PLACES,
            singularTarget = "Bus stop",
            singularBnPron = "বাস স্টপ",
            pluralTarget = "Bus stops",
            pluralBnPron = "বাস স্টপস",
            bnMeaning = "বাস স্টপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_327",
            category = VocabCategory.PLACES,
            singularTarget = "Port",
            singularBnPron = "পোর্ট",
            pluralTarget = "Ports",
            pluralBnPron = "পোর্টস",
            bnMeaning = "বন্দর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_328",
            category = VocabCategory.PLACES,
            singularTarget = "Police station",
            singularBnPron = "পুলিশ স্টেশন",
            pluralTarget = "Police stations",
            pluralBnPron = "পুলিশ স্টেশনস",
            bnMeaning = "পুলিশ স্টেশন / থানা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_329",
            category = VocabCategory.PLACES,
            singularTarget = "Post office",
            singularBnPron = "পোস্ট অফিস",
            pluralTarget = "Post offices",
            pluralBnPron = "পোস্ট অফিসেস",
            bnMeaning = "ডাকঘর / পোস্ট অফিস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_330",
            category = VocabCategory.PLACES,
            singularTarget = "Cinema",
            singularBnPron = "সিনেমা",
            pluralTarget = "Cinemas",
            pluralBnPron = "সিনেমাস",
            bnMeaning = "প্রেক্ষাগৃহ / সিনেমা হল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_331",
            category = VocabCategory.PLACES,
            singularTarget = "Stadium",
            singularBnPron = "স্টেডিয়াম",
            pluralTarget = "Stadiums",
            pluralBnPron = "স্টেডিয়ামস",
            bnMeaning = "স্টেডিয়াম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_332",
            category = VocabCategory.PLACES,
            singularTarget = "Gym",
            singularBnPron = "জিম",
            pluralTarget = "Gyms",
            pluralBnPron = "জিমস",
            bnMeaning = "ব্যায়ামাগার / জিম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_333",
            category = VocabCategory.PLACES,
            singularTarget = "Mosque",
            singularBnPron = "মসজিদ",
            pluralTarget = "Mosques",
            pluralBnPron = "মসজিদস",
            bnMeaning = "মসজিদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_334",
            category = VocabCategory.PLACES,
            singularTarget = "Temple",
            singularBnPron = "টেম্পল",
            pluralTarget = "Temples",
            pluralBnPron = "টেম্পলস",
            bnMeaning = "মন্দির",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_335",
            category = VocabCategory.PLACES,
            singularTarget = "Church",
            singularBnPron = "চার্চ",
            pluralTarget = "Churches",
            pluralBnPron = "চার্চেস",
            bnMeaning = "গির্জা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_336",
            category = VocabCategory.PLACES,
            singularTarget = "Embassy",
            singularBnPron = "এমব্যাসি",
            pluralTarget = "Embassies",
            pluralBnPron = "এমব্যাসিস",
            bnMeaning = "দূতাবাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_337",
            category = VocabCategory.PLACES,
            singularTarget = "Office",
            singularBnPron = "অফিস",
            pluralTarget = "Offices",
            pluralBnPron = "অফিসেস",
            bnMeaning = "কার্যালয় / অফিস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_338",
            category = VocabCategory.PLACES,
            singularTarget = "Factory",
            singularBnPron = "ফ্যাক্টরি",
            pluralTarget = "Factories",
            pluralBnPron = "ফ্যাক্টরিস",
            bnMeaning = "কারখানা / ফ্যাক্টরি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_339",
            category = VocabCategory.PLACES,
            singularTarget = "Building",
            singularBnPron = "বিল্ডিং",
            pluralTarget = "Buildings",
            pluralBnPron = "বিল্ডিংস",
            bnMeaning = "দালান / ভবন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_340",
            category = VocabCategory.PLACES,
            singularTarget = "Tower",
            singularBnPron = "টাওয়ার",
            pluralTarget = "Towers",
            pluralBnPron = "টাওয়ার্স",
            bnMeaning = "মিনার / টাওয়ার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_341",
            category = VocabCategory.PLACES,
            singularTarget = "Palace",
            singularBnPron = "প্যালেস",
            pluralTarget = "Palaces",
            pluralBnPron = "প্যালেসেস",
            bnMeaning = "প্রাসাদ / রাজপ্রাসাদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_342",
            category = VocabCategory.PLACES,
            singularTarget = "Castle",
            singularBnPron = "ক্যাসেল",
            pluralTarget = "Castles",
            pluralBnPron = "ক্যাসেলস",
            bnMeaning = "দুর্গ / কেল্লা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_343",
            category = VocabCategory.PLACES,
            singularTarget = "Square",
            singularBnPron = "স্কয়ার",
            pluralTarget = "Squares",
            pluralBnPron = "স্কয়ার্স",
            bnMeaning = "চত্বর / প্লাজা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_344",
            category = VocabCategory.PLACES,
            singularTarget = "Zoo",
            singularBnPron = "জু",
            pluralTarget = "Zoos",
            pluralBnPron = "জুজ",
            bnMeaning = "চিড়িয়াখানা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_345",
            category = VocabCategory.PLACES,
            singularTarget = "Beach",
            singularBnPron = "বীচ",
            pluralTarget = "Beaches",
            pluralBnPron = "বীচেস",
            bnMeaning = "সমুদ্র সৈকত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_346",
            category = VocabCategory.PLACES,
            singularTarget = "Lake",
            singularBnPron = "লেক",
            pluralTarget = "Lakes",
            pluralBnPron = "লেকস",
            bnMeaning = "হ্রদ / লেক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_347",
            category = VocabCategory.PLACES,
            singularTarget = "Mountain",
            singularBnPron = "মাউন্টেন",
            pluralTarget = "Mountains",
            pluralBnPron = "মাউন্টেনস",
            bnMeaning = "পর্বত / পাহাড়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_348",
            category = VocabCategory.PLACES,
            singularTarget = "Island",
            singularBnPron = "আইল্যান্ড",
            pluralTarget = "Islands",
            pluralBnPron = "আইল্যান্ডস",
            bnMeaning = "দ্বীপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_349",
            category = VocabCategory.PLACES,
            singularTarget = "Forest",
            singularBnPron = "ফরেস্ট",
            pluralTarget = "Forests",
            pluralBnPron = "ফরেস্টস",
            bnMeaning = "বন / জঙ্গল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_350",
            category = VocabCategory.PLACES,
            singularTarget = "Desert",
            singularBnPron = "মরুভূমি",
            pluralTarget = "Deserts",
            pluralBnPron = "মরুভূমিস",
            bnMeaning = "মরুভূমি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_351",
            category = VocabCategory.TRAVEL,
            singularTarget = "Train",
            singularBnPron = "ট্রেন",
            pluralTarget = "Trains",
            pluralBnPron = "ট্রেনস",
            bnMeaning = "রেলগাড়ি / ট্রেন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_352",
            category = VocabCategory.TRAVEL,
            singularTarget = "Bus",
            singularBnPron = "বাস",
            pluralTarget = "Buses",
            pluralBnPron = "বাসেস",
            bnMeaning = "বাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_353",
            category = VocabCategory.TRAVEL,
            singularTarget = "Car",
            singularBnPron = "কার",
            pluralTarget = "Cars",
            pluralBnPron = "কার্স",
            bnMeaning = "গাড়ি / কার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_354",
            category = VocabCategory.TRAVEL,
            singularTarget = "Bicycle",
            singularBnPron = "বাইসাইকেল",
            pluralTarget = "Bicycles",
            pluralBnPron = "বাইসাইকেলস",
            bnMeaning = "সাইকেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_355",
            category = VocabCategory.TRAVEL,
            singularTarget = "Motorcycle",
            singularBnPron = "মোটরসাইকেল",
            pluralTarget = "Motorcycles",
            pluralBnPron = "মোটরসাইকেলস",
            bnMeaning = "মোটরসাইকেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_356",
            category = VocabCategory.TRAVEL,
            singularTarget = "Airplane",
            singularBnPron = "এয়ারপ্লেন",
            pluralTarget = "Airplanes",
            pluralBnPron = "এয়ারপ্লেনস",
            bnMeaning = "উড়োজাহাজ / বিমান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_357",
            category = VocabCategory.TRAVEL,
            singularTarget = "Boat",
            singularBnPron = "বোট",
            pluralTarget = "Boats",
            pluralBnPron = "বোটস",
            bnMeaning = "নৌকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_358",
            category = VocabCategory.TRAVEL,
            singularTarget = "Ship",
            singularBnPron = "শিপ",
            pluralTarget = "Ships",
            pluralBnPron = "শিপস",
            bnMeaning = "জাহাজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_359",
            category = VocabCategory.TRAVEL,
            singularTarget = "Helicopter",
            singularBnPron = "হেলিকপ্টার",
            pluralTarget = "Helicopters",
            pluralBnPron = "হেলিকপ্টার্স",
            bnMeaning = "হেলিকপ্টার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_360",
            category = VocabCategory.TRAVEL,
            singularTarget = "Taxi",
            singularBnPron = "ট্যাক্সি",
            pluralTarget = "Taxis",
            pluralBnPron = "ট্যাক্সিস",
            bnMeaning = "ট্যাক্সি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_361",
            category = VocabCategory.TRAVEL,
            singularTarget = "Subway",
            singularBnPron = "সাবওয়ে",
            pluralTarget = "Subways",
            pluralBnPron = "সাবওয়েস",
            bnMeaning = "মেট্রোরেল / পাতালরেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_362",
            category = VocabCategory.TRAVEL,
            singularTarget = "Ticket",
            singularBnPron = "টিকেট",
            pluralTarget = "Tickets",
            pluralBnPron = "টিকেটস",
            bnMeaning = "টিকেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_363",
            category = VocabCategory.TRAVEL,
            singularTarget = "Passport",
            singularBnPron = "পাসপোর্ট",
            pluralTarget = "Passports",
            pluralBnPron = "পাসপোর্টস",
            bnMeaning = "পাসপোর্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_364",
            category = VocabCategory.TRAVEL,
            singularTarget = "Visa",
            singularBnPron = "ভিসা",
            pluralTarget = "Visas",
            pluralBnPron = "ভিসাস",
            bnMeaning = "ভিসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_365",
            category = VocabCategory.TRAVEL,
            singularTarget = "Luggage",
            singularBnPron = "লাগেজ",
            pluralTarget = "Luggage",
            pluralBnPron = "লাগেজ",
            bnMeaning = "মালামাল / লাগেজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_366",
            category = VocabCategory.TRAVEL,
            singularTarget = "Suitcase",
            singularBnPron = "স্যুটকেস",
            pluralTarget = "Suitcases",
            pluralBnPron = "স্যুটকেসেস",
            bnMeaning = "স্যুটকেস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_367",
            category = VocabCategory.TRAVEL,
            singularTarget = "Map",
            singularBnPron = "ম্যাপ",
            pluralTarget = "Maps",
            pluralBnPron = "ম্যাপস",
            bnMeaning = "মানচিত্র / ম্যাপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_368",
            category = VocabCategory.TRAVEL,
            singularTarget = "Trip",
            singularBnPron = "ট্রিপ",
            pluralTarget = "Trips",
            pluralBnPron = "ট্রিপস",
            bnMeaning = "ভ্রমণ / যাত্রা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_369",
            category = VocabCategory.TRAVEL,
            singularTarget = "Tourist",
            singularBnPron = "ট্যুরিস্ট",
            pluralTarget = "Tourists",
            pluralBnPron = "ট্যুরিস্টস",
            bnMeaning = "ট্যুরিস্ট / পর্যটক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_370",
            category = VocabCategory.TRAVEL,
            singularTarget = "Guide",
            singularBnPron = "গাইড",
            pluralTarget = "Guides",
            pluralBnPron = "গাইডস",
            bnMeaning = "গাইড / পথপ্রদর্শক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_371",
            category = VocabCategory.TRAVEL,
            singularTarget = "Platform",
            singularBnPron = "প্ল্যাটফর্ম",
            pluralTarget = "Platforms",
            pluralBnPron = "প্ল্যাটফর্মস",
            bnMeaning = "প্ল্যাটফর্ম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_372",
            category = VocabCategory.TRAVEL,
            singularTarget = "Flight",
            singularBnPron = "ফ্লাইট",
            pluralTarget = "Flights",
            pluralBnPron = "ফ্লাইটস",
            bnMeaning = "বিমান ফ্লাইট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_373",
            category = VocabCategory.TRAVEL,
            singularTarget = "Passenger",
            singularBnPron = "প্যাসেঞ্জার",
            pluralTarget = "Passengers",
            pluralBnPron = "প্যাসেঞ্জার্স",
            bnMeaning = "যাত্রী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_374",
            category = VocabCategory.TRAVEL,
            singularTarget = "Driver",
            singularBnPron = "ড্রাইভার",
            pluralTarget = "Drivers",
            pluralBnPron = "ড্রাইভার্স",
            bnMeaning = "চালক / ড্রাইভার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_375",
            category = VocabCategory.TRAVEL,
            singularTarget = "Pilot",
            singularBnPron = "পাইলট",
            pluralTarget = "Pilots",
            pluralBnPron = "পাইলটস",
            bnMeaning = "বিমানচালক / পাইলট",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_376",
            category = VocabCategory.TRAVEL,
            singularTarget = "Highway",
            singularBnPron = "হাইওয়ে",
            pluralTarget = "Highways",
            pluralBnPron = "হাইওয়েস",
            bnMeaning = "মহাসড়ক / হাইওয়ে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_377",
            category = VocabCategory.TRAVEL,
            singularTarget = "Traffic",
            singularBnPron = "ট্রাফিক",
            pluralTarget = "Traffic",
            pluralBnPron = "ট্রাফিক",
            bnMeaning = "ট্রাফিক / যানজট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_378",
            category = VocabCategory.TRAVEL,
            singularTarget = "Traffic light",
            singularBnPron = "ট্রাফিক লাইট",
            pluralTarget = "Traffic lights",
            pluralBnPron = "ট্রাফিক লাইটস",
            bnMeaning = "ট্রাফিক লাইট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_379",
            category = VocabCategory.TRAVEL,
            singularTarget = "Fuel",
            singularBnPron = "ফুয়েল",
            pluralTarget = "Fuels",
            pluralBnPron = "ফুয়েলস",
            bnMeaning = "জ্বালানি / পেট্রল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_380",
            category = VocabCategory.TRAVEL,
            singularTarget = "Wheel",
            singularBnPron = "হুইল",
            pluralTarget = "Wheels",
            pluralBnPron = "হুইলস",
            bnMeaning = "চাকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_381",
            category = VocabCategory.TRAVEL,
            singularTarget = "Seat",
            singularBnPron = "সিট",
            pluralTarget = "Seats",
            pluralBnPron = "সিটস",
            bnMeaning = "আসন / সিট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_382",
            category = VocabCategory.TRAVEL,
            singularTarget = "Seatbelt",
            singularBnPron = "সিটবেল্ট",
            pluralTarget = "Seatbelts",
            pluralBnPron = "সিটবেল্টস",
            bnMeaning = "সিটবেল্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_383",
            category = VocabCategory.TRAVEL,
            singularTarget = "Direction",
            singularBnPron = "ডিরেকশন",
            pluralTarget = "Directions",
            pluralBnPron = "ডিরেকশনস",
            bnMeaning = "দিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_384",
            category = VocabCategory.TRAVEL,
            singularTarget = "North",
            singularBnPron = "নর্থ",
            pluralTarget = "North",
            pluralBnPron = "নর্থ",
            bnMeaning = "উত্তর দিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_385",
            category = VocabCategory.TRAVEL,
            singularTarget = "South",
            singularBnPron = "সাউথ",
            pluralTarget = "South",
            pluralBnPron = "সাউথ",
            bnMeaning = "দক্ষিণ দিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_386",
            category = VocabCategory.TRAVEL,
            singularTarget = "East",
            singularBnPron = "ইস্ট",
            pluralTarget = "East",
            pluralBnPron = "ইস্ট",
            bnMeaning = "পূর্ব দিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_387",
            category = VocabCategory.TRAVEL,
            singularTarget = "West",
            singularBnPron = "ওয়েস্ট",
            pluralTarget = "West",
            pluralBnPron = "ওয়েস্ট",
            bnMeaning = "পশ্চিম দিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_388",
            category = VocabCategory.TRAVEL,
            singularTarget = "Left",
            singularBnPron = "লেফট",
            pluralTarget = "Left",
            pluralBnPron = "লেফট",
            bnMeaning = "বামে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_389",
            category = VocabCategory.TRAVEL,
            singularTarget = "Right",
            singularBnPron = "রাইট",
            pluralTarget = "Right",
            pluralBnPron = "রাইট",
            bnMeaning = "ডানে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_390",
            category = VocabCategory.TRAVEL,
            singularTarget = "Straight",
            singularBnPron = "স্ট্রেইট",
            pluralTarget = "Straight",
            pluralBnPron = "স্ট্রেইট",
            bnMeaning = "সোজা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_391",
            category = VocabCategory.TRAVEL,
            singularTarget = "Distance",
            singularBnPron = "ডিসট্যান্স",
            pluralTarget = "Distances",
            pluralBnPron = "ডিসট্যান্সেস",
            bnMeaning = "দূরত্ব",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_392",
            category = VocabCategory.TRAVEL,
            singularTarget = "Kilometer",
            singularBnPron = "কিলোমিটার",
            pluralTarget = "Kilometers",
            pluralBnPron = "কিলোমিটার্স",
            bnMeaning = "কিলোমিটার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_393",
            category = VocabCategory.TRAVEL,
            singularTarget = "Speed",
            singularBnPron = "স্পিড",
            pluralTarget = "Speeds",
            pluralBnPron = "স্পিডস",
            bnMeaning = "গতি / স্পিড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_394",
            category = VocabCategory.TRAVEL,
            singularTarget = "Delay",
            singularBnPron = "ডিলে",
            pluralTarget = "Delays",
            pluralBnPron = "ডিলেস",
            bnMeaning = "দেরি / বিলম্ব",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_395",
            category = VocabCategory.TRAVEL,
            singularTarget = "Arrival",
            singularBnPron = "অ্যারাইভাল",
            pluralTarget = "Arrivals",
            pluralBnPron = "অ্যারাইভালস",
            bnMeaning = "পৌঁছানো / আগমন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_396",
            category = VocabCategory.TRAVEL,
            singularTarget = "Departure",
            singularBnPron = "ডিপার্চার",
            pluralTarget = "Departures",
            pluralBnPron = "ডিপার্চার্স",
            bnMeaning = "প্রস্থান / রওয়ানা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_397",
            category = VocabCategory.TRAVEL,
            singularTarget = "Schedule",
            singularBnPron = "শিডিউল",
            pluralTarget = "Schedules",
            pluralBnPron = "শিডিউলস",
            bnMeaning = "ভ্রমণসূচি / শিডিউল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_398",
            category = VocabCategory.TRAVEL,
            singularTarget = "Border",
            singularBnPron = "বর্ডার",
            pluralTarget = "Borders",
            pluralBnPron = "বর্ডার্স",
            bnMeaning = "সীমান্ত / বর্ডার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_399",
            category = VocabCategory.TRAVEL,
            singularTarget = "Fare",
            singularBnPron = "ফেয়ার",
            pluralTarget = "Fares",
            pluralBnPron = "ফেয়ার্স",
            bnMeaning = "ভাড়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_400",
            category = VocabCategory.TRAVEL,
            singularTarget = "Destination",
            singularBnPron = "ডেস্টিনেশন",
            pluralTarget = "Destinations",
            pluralBnPron = "ডেস্টিনেশনস",
            bnMeaning = "গন্তব্য",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk5 = listOf(
        VocabItem(
            id = "en_vocab_401",
            category = VocabCategory.EDUCATION,
            singularTarget = "Book",
            singularBnPron = "বুক",
            pluralTarget = "Books",
            pluralBnPron = "বুকস",
            bnMeaning = "বই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_402",
            category = VocabCategory.EDUCATION,
            singularTarget = "Notebook",
            singularBnPron = "নোটবুক",
            pluralTarget = "Notebooks",
            pluralBnPron = "নোটবুকস",
            bnMeaning = "খাতা / নোটবুক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_403",
            category = VocabCategory.EDUCATION,
            singularTarget = "Pen",
            singularBnPron = "পেন",
            pluralTarget = "Pens",
            pluralBnPron = "পেনস",
            bnMeaning = "কলম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_404",
            category = VocabCategory.EDUCATION,
            singularTarget = "Pencil",
            singularBnPron = "পেন্সিল",
            pluralTarget = "Pencils",
            pluralBnPron = "পেন্সিলস",
            bnMeaning = "পেন্সিল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_405",
            category = VocabCategory.EDUCATION,
            singularTarget = "Eraser",
            singularBnPron = "ইরেজার",
            pluralTarget = "Erasers",
            pluralBnPron = "ইরেজার্স",
            bnMeaning = "ইরেজার / রাবার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_406",
            category = VocabCategory.EDUCATION,
            singularTarget = "Sharpener",
            singularBnPron = "শার্পনার",
            pluralTarget = "Sharpeners",
            pluralBnPron = "শার্পনার্স",
            bnMeaning = "শার্পনার / কাটার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_407",
            category = VocabCategory.EDUCATION,
            singularTarget = "Ruler",
            singularBnPron = "রুলার",
            pluralTarget = "Rulers",
            pluralBnPron = "রুলার্স",
            bnMeaning = "স্কেল / রুলার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_408",
            category = VocabCategory.EDUCATION,
            singularTarget = "Schoolbag",
            singularBnPron = "স্কুলব্যাগ",
            pluralTarget = "Schoolbags",
            pluralBnPron = "স্কুলব্যাগস",
            bnMeaning = "স্কুল ব্যাগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_409",
            category = VocabCategory.EDUCATION,
            singularTarget = "Board",
            singularBnPron = "বোর্ড",
            pluralTarget = "Boards",
            pluralBnPron = "বোর্ডস",
            bnMeaning = "বোর্ড / ব্ল্যাকবোর্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_410",
            category = VocabCategory.EDUCATION,
            singularTarget = "Chalk",
            singularBnPron = "চক",
            pluralTarget = "Chalks",
            pluralBnPron = "চকস",
            bnMeaning = "চক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_411",
            category = VocabCategory.EDUCATION,
            singularTarget = "Marker",
            singularBnPron = "মার্কার",
            pluralTarget = "Markers",
            pluralBnPron = "মার্কার্স",
            bnMeaning = "মার্কার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_412",
            category = VocabCategory.EDUCATION,
            singularTarget = "Paper",
            singularBnPron = "পেপার",
            pluralTarget = "Papers",
            pluralBnPron = "পেপার্স",
            bnMeaning = "কাগজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_413",
            category = VocabCategory.EDUCATION,
            singularTarget = "Page",
            singularBnPron = "পেইজ",
            pluralTarget = "Pages",
            pluralBnPron = "পেইজেস",
            bnMeaning = "পৃষ্ঠা / পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_414",
            category = VocabCategory.EDUCATION,
            singularTarget = "Question",
            singularBnPron = "কোয়েশ্চেন",
            pluralTarget = "Questions",
            pluralBnPron = "কোয়েশ্চেনস",
            bnMeaning = "প্রশ্ন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_415",
            category = VocabCategory.EDUCATION,
            singularTarget = "Answer",
            singularBnPron = "অ্যানসার",
            pluralTarget = "Answers",
            pluralBnPron = "অ্যানসার্স",
            bnMeaning = "উত্তর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_416",
            category = VocabCategory.EDUCATION,
            singularTarget = "Exam",
            singularBnPron = "এক্সাম",
            pluralTarget = "Exams",
            pluralBnPron = "এক্সামস",
            bnMeaning = "পরীক্ষা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_417",
            category = VocabCategory.EDUCATION,
            singularTarget = "Result",
            singularBnPron = "রেজাল্ট",
            pluralTarget = "Results",
            pluralBnPron = "রেজাল্টস",
            bnMeaning = "ফলাফল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_418",
            category = VocabCategory.EDUCATION,
            singularTarget = "Grade",
            singularBnPron = "গ্রেড",
            pluralTarget = "Grades",
            pluralBnPron = "গ্রেডস",
            bnMeaning = "নম্বর / গ্রেড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_419",
            category = VocabCategory.EDUCATION,
            singularTarget = "Homework",
            singularBnPron = "হোমওয়ার্ক",
            pluralTarget = "Homework",
            pluralBnPron = "হোমওয়ার্ক",
            bnMeaning = "বাড়ির কাজ / হোমওয়ার্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_420",
            category = VocabCategory.EDUCATION,
            singularTarget = "Lesson",
            singularBnPron = "লেসন",
            pluralTarget = "Lessons",
            pluralBnPron = "লেসনস",
            bnMeaning = "পাঠ / অধ্যায়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_421",
            category = VocabCategory.EDUCATION,
            singularTarget = "Subject",
            singularBnPron = "সাবজেক্ট",
            pluralTarget = "Subjects",
            pluralBnPron = "সাবজেক্টস",
            bnMeaning = "বিষয়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_422",
            category = VocabCategory.EDUCATION,
            singularTarget = "Mathematics",
            singularBnPron = "ম্যাথমেটিক্স",
            pluralTarget = "Mathematics",
            pluralBnPron = "ম্যাথমেটিক্স",
            bnMeaning = "গণিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_423",
            category = VocabCategory.EDUCATION,
            singularTarget = "Science",
            singularBnPron = "সাইন্স",
            pluralTarget = "Sciences",
            pluralBnPron = "সাইন্সেস",
            bnMeaning = "বিজ্ঞান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_424",
            category = VocabCategory.EDUCATION,
            singularTarget = "History",
            singularBnPron = "হিস্ট্রি",
            pluralTarget = "Histories",
            pluralBnPron = "হিস্ট্রিস",
            bnMeaning = "ইতিহাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_425",
            category = VocabCategory.EDUCATION,
            singularTarget = "Geography",
            singularBnPron = "জিওগ্রাফি",
            pluralTarget = "Geographies",
            pluralBnPron = "জিওগ্রাফিস",
            bnMeaning = "ভূগোল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_426",
            category = VocabCategory.EDUCATION,
            singularTarget = "Language",
            singularBnPron = "ল্যাঙ্গুয়েজ",
            pluralTarget = "Languages",
            pluralBnPron = "ল্যাঙ্গুয়েজেস",
            bnMeaning = "ভাষা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_427",
            category = VocabCategory.EDUCATION,
            singularTarget = "Literature",
            singularBnPron = "লিটারেচার",
            pluralTarget = "Literatures",
            pluralBnPron = "লিটারেচার্স",
            bnMeaning = "সাহিত্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_428",
            category = VocabCategory.EDUCATION,
            singularTarget = "Art",
            singularBnPron = "আর্ট",
            pluralTarget = "Arts",
            pluralBnPron = "আর্টস",
            bnMeaning = "শিল্পকলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_429",
            category = VocabCategory.EDUCATION,
            singularTarget = "Music",
            singularBnPron = "মিউজিক",
            pluralTarget = "Music",
            pluralBnPron = "মিউজিক",
            bnMeaning = "সঙ্গীত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_430",
            category = VocabCategory.EDUCATION,
            singularTarget = "Classroom",
            singularBnPron = "ক্লাসরুম",
            pluralTarget = "Classrooms",
            pluralBnPron = "ক্লাসরুমস",
            bnMeaning = "শ্রেণিকক্ষ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_431",
            category = VocabCategory.EDUCATION,
            singularTarget = "Class",
            singularBnPron = "ক্লাস",
            pluralTarget = "Classes",
            pluralBnPron = "ক্লাসেস",
            bnMeaning = "শ্রেণি / ক্লাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_432",
            category = VocabCategory.EDUCATION,
            singularTarget = "Professor",
            singularBnPron = "প্রফেসর",
            pluralTarget = "Professors",
            pluralBnPron = "প্রফেসর্স",
            bnMeaning = "অধ্যাপক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_433",
            category = VocabCategory.EDUCATION,
            singularTarget = "Principal",
            singularBnPron = "প্রিন্সিপাল",
            pluralTarget = "Principals",
            pluralBnPron = "প্রিন্সিপালস",
            bnMeaning = "প্রধান শিক্ষক / অধ্যক্ষ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_434",
            category = VocabCategory.EDUCATION,
            singularTarget = "Degree",
            singularBnPron = "ডিগ্রি",
            pluralTarget = "Degrees",
            pluralBnPron = "ডিগ্রিস",
            bnMeaning = "ডিগ্রি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_435",
            category = VocabCategory.EDUCATION,
            singularTarget = "Diploma",
            singularBnPron = "ডিপ্লোমা",
            pluralTarget = "Diplomas",
            pluralBnPron = "ডিপ্লোমাস",
            bnMeaning = "সনদপত্র / ডিপ্লোমা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_436",
            category = VocabCategory.EDUCATION,
            singularTarget = "Knowledge",
            singularBnPron = "নলেজ",
            pluralTarget = "Knowledge",
            pluralBnPron = "নলেজ",
            bnMeaning = "জ্ঞান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_437",
            category = VocabCategory.EDUCATION,
            singularTarget = "Study",
            singularBnPron = "স্টাডি",
            pluralTarget = "Studies",
            pluralBnPron = "স্টাডিস",
            bnMeaning = "পড়াশোনা / অধ্যয়ন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_438",
            category = VocabCategory.EDUCATION,
            singularTarget = "Lecture",
            singularBnPron = "লেকচার",
            pluralTarget = "Lectures",
            pluralBnPron = "লেকচার্স",
            bnMeaning = "বক্তৃতা / লেকচার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_439",
            category = VocabCategory.EDUCATION,
            singularTarget = "Problem",
            singularBnPron = "প্রবলেম",
            pluralTarget = "Problems",
            pluralBnPron = "প্রবলেমস",
            bnMeaning = "সমস্যা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_440",
            category = VocabCategory.EDUCATION,
            singularTarget = "Solution",
            singularBnPron = "সল্যুশন",
            pluralTarget = "Solutions",
            pluralBnPron = "সল্যুশনস",
            bnMeaning = "সমাধান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_441",
            category = VocabCategory.EDUCATION,
            singularTarget = "Dictionary",
            singularBnPron = "ডিকশনারি",
            pluralTarget = "Dictionaries",
            pluralBnPron = "ডিকশনারিস",
            bnMeaning = "অভিধান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_442",
            category = VocabCategory.EDUCATION,
            singularTarget = "Vacation",
            singularBnPron = "ভ্যাকেশন",
            pluralTarget = "Vacations",
            pluralBnPron = "ভ্যাকেশনস",
            bnMeaning = "ছুটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_443",
            category = VocabCategory.EDUCATION,
            singularTarget = "Word",
            singularBnPron = "ওয়ার্ড",
            pluralTarget = "Words",
            pluralBnPron = "ওয়ার্ডস",
            bnMeaning = "শব্দ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_444",
            category = VocabCategory.EDUCATION,
            singularTarget = "Sentence",
            singularBnPron = "সেন্টেন্স",
            pluralTarget = "Sentences",
            pluralBnPron = "সেন্টেন্সেস",
            bnMeaning = "বাক্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_445",
            category = VocabCategory.EDUCATION,
            singularTarget = "Meaning",
            singularBnPron = "মিনিং",
            pluralTarget = "Meanings",
            pluralBnPron = "মিনিংস",
            bnMeaning = "অর্থ / মানে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_446",
            category = VocabCategory.EDUCATION,
            singularTarget = "Alphabet",
            singularBnPron = "অ্যালফাবেট",
            pluralTarget = "Alphabets",
            pluralBnPron = "অ্যালফাবেটস",
            bnMeaning = "বর্ণমালা / অক্ষর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_447",
            category = VocabCategory.EDUCATION,
            singularTarget = "Grammar",
            singularBnPron = "গ্রামার",
            pluralTarget = "Grammars",
            pluralBnPron = "গ্রামার্স",
            bnMeaning = "ব্যাকরণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_448",
            category = VocabCategory.EDUCATION,
            singularTarget = "Pronunciation",
            singularBnPron = "প্রোনাউনসিয়েশন",
            pluralTarget = "Pronunciations",
            pluralBnPron = "প্রোনাউনসিয়েশনস",
            bnMeaning = "উচ্চারণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_449",
            category = VocabCategory.EDUCATION,
            singularTarget = "Practice",
            singularBnPron = "প্র্যাকটিস",
            pluralTarget = "Practices",
            pluralBnPron = "প্র্যাকটিসেস",
            bnMeaning = "অনুশীলন / চর্চা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_450",
            category = VocabCategory.EDUCATION,
            singularTarget = "Mistake",
            singularBnPron = "মিসটেক",
            pluralTarget = "Mistakes",
            pluralBnPron = "মিসটেকস",
            bnMeaning = "ভুল / ত্রুটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_451",
            category = VocabCategory.WORK,
            singularTarget = "Job",
            singularBnPron = "জব",
            pluralTarget = "Jobs",
            pluralBnPron = "জবস",
            bnMeaning = "চাকরি / পেশা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_452",
            category = VocabCategory.WORK,
            singularTarget = "Workplace",
            singularBnPron = "ওয়ার্কপ্লেস",
            pluralTarget = "Workplaces",
            pluralBnPron = "ওয়ার্কপ্লেসেস",
            bnMeaning = "কাজের জায়গা / কর্মস্থল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_453",
            category = VocabCategory.WORK,
            singularTarget = "Boss",
            singularBnPron = "বস",
            pluralTarget = "Bosses",
            pluralBnPron = "বসেস",
            bnMeaning = "মালিক / বস",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_454",
            category = VocabCategory.WORK,
            singularTarget = "Employee",
            singularBnPron = "এমপ্লয়ি",
            pluralTarget = "Employees",
            pluralBnPron = "এমপ্লয়িজ",
            bnMeaning = "কর্মচারী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_455",
            category = VocabCategory.WORK,
            singularTarget = "Worker",
            singularBnPron = "ওয়ার্কার",
            pluralTarget = "Workers",
            pluralBnPron = "ওয়ার্কার্স",
            bnMeaning = "শ্রমিক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_456",
            category = VocabCategory.WORK,
            singularTarget = "Salary",
            singularBnPron = "স্যালারি",
            pluralTarget = "Salaries",
            pluralBnPron = "স্যালারিস",
            bnMeaning = "বেতন / পারিশ্রমিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_457",
            category = VocabCategory.WORK,
            singularTarget = "Interview",
            singularBnPron = "ইন্টারভিউ",
            pluralTarget = "Interviews",
            pluralBnPron = "ইন্টারভিউস",
            bnMeaning = "মৌখিক পরীক্ষা / সাক্ষাৎকার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_458",
            category = VocabCategory.WORK,
            singularTarget = "Meeting",
            singularBnPron = "মিটিং",
            pluralTarget = "Meetings",
            pluralBnPron = "মিটিংস",
            bnMeaning = "বৈঠক / সভা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_459",
            category = VocabCategory.WORK,
            singularTarget = "Contract",
            singularBnPron = "কন্ট্রাক্ট",
            pluralTarget = "Contracts",
            pluralBnPron = "কন্ট্রাক্টস",
            bnMeaning = "চুক্তিপত্র / চুক্তি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_460",
            category = VocabCategory.WORK,
            singularTarget = "Project",
            singularBnPron = "প্রজেক্ট",
            pluralTarget = "Projects",
            pluralBnPron = "প্রজেক্টস",
            bnMeaning = "প্রকল্প / প্রজেক্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_461",
            category = VocabCategory.WORK,
            singularTarget = "Report",
            singularBnPron = "রিপোর্ট",
            pluralTarget = "Reports",
            pluralBnPron = "রিপোর্টস",
            bnMeaning = "প্রতিবেদন / রিপোর্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_462",
            category = VocabCategory.WORK,
            singularTarget = "Business",
            singularBnPron = "বিজনেস",
            pluralTarget = "Businesses",
            pluralBnPron = "বিজনেসেস",
            bnMeaning = "ব্যবসা / বাণিজ্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_463",
            category = VocabCategory.WORK,
            singularTarget = "Company",
            singularBnPron = "কোম্পানি",
            pluralTarget = "Companies",
            pluralBnPron = "কোম্পানিস",
            bnMeaning = "কোম্পানি / প্রতিষ্ঠান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_464",
            category = VocabCategory.WORK,
            singularTarget = "Customer",
            singularBnPron = "কাস্টমার",
            pluralTarget = "Customers",
            pluralBnPron = "কাস্টমার্স",
            bnMeaning = "গ্রাহক / খরিদ্দার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_465",
            category = VocabCategory.WORK,
            singularTarget = "Service",
            singularBnPron = "সার্ভিস",
            pluralTarget = "Services",
            pluralBnPron = "সার্ভিসেস",
            bnMeaning = "সেবা / সার্ভিস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_466",
            category = VocabCategory.WORK,
            singularTarget = "Task",
            singularBnPron = "টাস্ক",
            pluralTarget = "Tasks",
            pluralBnPron = "টাস্কস",
            bnMeaning = "কাজ / কার্যভার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_467",
            category = VocabCategory.WORK,
            singularTarget = "Duty",
            singularBnPron = "ডিউটি",
            pluralTarget = "Duties",
            pluralBnPron = "ডিউটিস",
            bnMeaning = "দায়িত্ব / কর্তব্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_468",
            category = VocabCategory.WORK,
            singularTarget = "Shift",
            singularBnPron = "শিফট",
            pluralTarget = "Shifts",
            pluralBnPron = "শিফটস",
            bnMeaning = "পালা / শিফট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_469",
            category = VocabCategory.WORK,
            singularTarget = "Bonus",
            singularBnPron = "বোনাস",
            pluralTarget = "Bonuses",
            pluralBnPron = "বোনাসেস",
            bnMeaning = "বোনাস / অতিরিক্ত ভাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_470",
            category = VocabCategory.WORK,
            singularTarget = "Promotion",
            singularBnPron = "প্রমোশন",
            pluralTarget = "Promotions",
            pluralBnPron = "প্রমোশনস",
            bnMeaning = "পদোন্নতি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_471",
            category = VocabCategory.WORK,
            singularTarget = "Career",
            singularBnPron = "ক্যারিয়ার",
            pluralTarget = "Careers",
            pluralBnPron = "ক্যারিয়ার্স",
            bnMeaning = "পেশাজীবন / ক্যারিয়ার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_472",
            category = VocabCategory.WORK,
            singularTarget = "Resignation",
            singularBnPron = "রেজিগনেশন",
            pluralTarget = "Resignations",
            pluralBnPron = "রেজিগনেশনস",
            bnMeaning = "পদত্যাগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_473",
            category = VocabCategory.WORK,
            singularTarget = "Retirement",
            singularBnPron = "রিটায়ারমেন্ট",
            pluralTarget = "Retirements",
            pluralBnPron = "রিটায়ারমেন্টস",
            bnMeaning = "অবসর গ্রহণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_474",
            category = VocabCategory.WORK,
            singularTarget = "Strike",
            singularBnPron = "স্ট্রাইক",
            pluralTarget = "Strikes",
            pluralBnPron = "স্ট্রাইকস",
            bnMeaning = "ধর্মঘট / স্ট্রাইক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_475",
            category = VocabCategory.WORK,
            singularTarget = "Success",
            singularBnPron = "সাকসেস",
            pluralTarget = "Successes",
            pluralBnPron = "সাকসেসেস",
            bnMeaning = "সাফল্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_476",
            category = VocabCategory.WORK,
            singularTarget = "Doctor",
            singularBnPron = "ডাক্তার",
            pluralTarget = "Doctors",
            pluralBnPron = "ডাক্তার্স",
            bnMeaning = "চিকিৎসক / ডাক্তার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_477",
            category = VocabCategory.WORK,
            singularTarget = "Nurse",
            singularBnPron = "নার্স",
            pluralTarget = "Nurses",
            pluralBnPron = "নার্সেস",
            bnMeaning = "সেবিকা / নার্স",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_478",
            category = VocabCategory.WORK,
            singularTarget = "Engineer",
            singularBnPron = "ইঞ্জিনিয়ার",
            pluralTarget = "Engineers",
            pluralBnPron = "ইঞ্জিনিয়ার্স",
            bnMeaning = "প্রকৌশলী / ইঞ্জিনিয়ার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_479",
            category = VocabCategory.WORK,
            singularTarget = "Lawyer",
            singularBnPron = "লয়ার",
            pluralTarget = "Lawyers",
            pluralBnPron = "লয়ার্স",
            bnMeaning = "আইনজীবী / উকিল",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_480",
            category = VocabCategory.WORK,
            singularTarget = "Police officer",
            singularBnPron = "পুলিশ অফিসার",
            pluralTarget = "Police officers",
            pluralBnPron = "পুলিশ অফিসার্স",
            bnMeaning = "পুলিশ কর্মকর্তা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_481",
            category = VocabCategory.WORK,
            singularTarget = "Firefighter",
            singularBnPron = "ফায়ারফাইটার",
            pluralTarget = "Firefighters",
            pluralBnPron = "ফায়ারফাইটার্স",
            bnMeaning = "দমকলকর্মী / ফায়ারফাইটার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_482",
            category = VocabCategory.WORK,
            singularTarget = "Farmer",
            singularBnPron = "ফার্মার",
            pluralTarget = "Farmers",
            pluralBnPron = "ফার্মার্স",
            bnMeaning = "কৃষক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_483",
            category = VocabCategory.WORK,
            singularTarget = "Carpenter",
            singularBnPron = "কার্পেন্টার",
            pluralTarget = "Carpenters",
            pluralBnPron = "কার্পেন্টার্স",
            bnMeaning = "কাঠমিস্ত্রি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_484",
            category = VocabCategory.WORK,
            singularTarget = "Electrician",
            singularBnPron = "ইলেক্ট্রিশিয়ান",
            pluralTarget = "Electricians",
            pluralBnPron = "ইলেক্ট্রিশিয়ানস",
            bnMeaning = "বিদ্যুৎমিস্ত্রি / ইলেক্ট্রিশিয়ান",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_485",
            category = VocabCategory.WORK,
            singularTarget = "Plumber",
            singularBnPron = "প্লাম্বার",
            pluralTarget = "Plumbers",
            pluralBnPron = "প্লাম্বার্স",
            bnMeaning = "প্লাম্বার / নলমিস্ত্রি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_486",
            category = VocabCategory.WORK,
            singularTarget = "Tailor",
            singularBnPron = "টেইলর",
            pluralTarget = "Tailors",
            pluralBnPron = "টেইলরস",
            bnMeaning = "দর্জি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_487",
            category = VocabCategory.WORK,
            singularTarget = "Barber",
            singularBnPron = "বারবার",
            pluralTarget = "Barbers",
            pluralBnPron = "বারবার্স",
            bnMeaning = "নাপিত",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_488",
            category = VocabCategory.WORK,
            singularTarget = "Chef",
            singularBnPron = "শেফ",
            pluralTarget = "Chefs",
            pluralBnPron = "শেফস",
            bnMeaning = "বাবুর্চি / শেফ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_489",
            category = VocabCategory.WORK,
            singularTarget = "Waiter",
            singularBnPron = "ওয়েটার",
            pluralTarget = "Waiters",
            pluralBnPron = "ওয়েটার্স",
            bnMeaning = "ওয়েটার",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_490",
            category = VocabCategory.WORK,
            singularTarget = "Waitress",
            singularBnPron = "ওয়েট্রেস",
            pluralTarget = "Waitresses",
            pluralBnPron = "ওয়েট্রেসেস",
            bnMeaning = "ওয়েট্রেস / পরিচারিকা",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_491",
            category = VocabCategory.WORK,
            singularTarget = "Soldier",
            singularBnPron = "সোলজার",
            pluralTarget = "Soldiers",
            pluralBnPron = "সোলজার্স",
            bnMeaning = "সৈনিক / সেনা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_492",
            category = VocabCategory.WORK,
            singularTarget = "Artist",
            singularBnPron = "আর্টিস্ট",
            pluralTarget = "Artists",
            pluralBnPron = "আর্টিস্টস",
            bnMeaning = "শিল্পী / আর্টিস্ট",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_493",
            category = VocabCategory.WORK,
            singularTarget = "Writer",
            singularBnPron = "রাইটার",
            pluralTarget = "Writers",
            pluralBnPron = "রাইটার্স",
            bnMeaning = "লেখক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_494",
            category = VocabCategory.WORK,
            singularTarget = "Scientist",
            singularBnPron = "সাইন্টিস্ট",
            pluralTarget = "Scientists",
            pluralBnPron = "সাইন্টিস্টস",
            bnMeaning = "বিজ্ঞানী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_495",
            category = VocabCategory.WORK,
            singularTarget = "Journalist",
            singularBnPron = "জার্নালিস্ট",
            pluralTarget = "Journalists",
            pluralBnPron = "জার্নালিস্টস",
            bnMeaning = "সাংবাদিক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_496",
            category = VocabCategory.WORK,
            singularTarget = "Architect",
            singularBnPron = "আর্কিটেক্ট",
            pluralTarget = "Architects",
            pluralBnPron = "আর্কিটেক্টস",
            bnMeaning = "স্থপতি / আর্কিটেক্ট",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_497",
            category = VocabCategory.WORK,
            singularTarget = "Photographer",
            singularBnPron = "ফটোগ্রাফার",
            pluralTarget = "Photographers",
            pluralBnPron = "ফটোগ্রাফার্স",
            bnMeaning = "ফটোগ্রাফার / আলোকচিত্রী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_498",
            category = VocabCategory.WORK,
            singularTarget = "Musician",
            singularBnPron = "মিউজিশিয়ান",
            pluralTarget = "Musicians",
            pluralBnPron = "মিউজিশিয়ানস",
            bnMeaning = "সুরকার / সঙ্গীতজ্ঞ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_499",
            category = VocabCategory.WORK,
            singularTarget = "Actor",
            singularBnPron = "অ্যাক্টর",
            pluralTarget = "Actors",
            pluralBnPron = "অ্যাক্টর্স",
            bnMeaning = "অভিনেতা",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_500",
            category = VocabCategory.WORK,
            singularTarget = "Actress",
            singularBnPron = "অ্যাক্ট্রেস",
            pluralTarget = "Actresses",
            pluralBnPron = "অ্যাক্ট্রেসেস",
            bnMeaning = "অভিনেত্রী",
            gender = GrammaticalGender.FEMININE
        ),
    )

    private val chunk6 = listOf(
        VocabItem(
            id = "en_vocab_501",
            category = VocabCategory.NATURE,
            singularTarget = "Tree",
            singularBnPron = "ট্রি",
            pluralTarget = "Trees",
            pluralBnPron = "ট্রিস",
            bnMeaning = "গাছ / বৃক্ষ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_502",
            category = VocabCategory.NATURE,
            singularTarget = "Plant",
            singularBnPron = "প্ল্যান্ট",
            pluralTarget = "Plants",
            pluralBnPron = "প্ল্যান্টস",
            bnMeaning = "উদ্ভিদ / চারাগাছ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_503",
            category = VocabCategory.NATURE,
            singularTarget = "Flower",
            singularBnPron = "ফ্লাওয়ার",
            pluralTarget = "Flowers",
            pluralBnPron = "ফ্লাওয়ার্স",
            bnMeaning = "ফুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_504",
            category = VocabCategory.NATURE,
            singularTarget = "Leaf",
            singularBnPron = "লিফ",
            pluralTarget = "Leaves",
            pluralBnPron = "লিভস",
            bnMeaning = "পাতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_505",
            category = VocabCategory.NATURE,
            singularTarget = "Root",
            singularBnPron = "রুট",
            pluralTarget = "Roots",
            pluralBnPron = "রুটস",
            bnMeaning = "শিকড় / মূল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_506",
            category = VocabCategory.NATURE,
            singularTarget = "Branch",
            singularBnPron = "ব্রাঞ্চ",
            pluralTarget = "Branches",
            pluralBnPron = "ব্রাঞ্চেস",
            bnMeaning = "শাখা / ডাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_507",
            category = VocabCategory.NATURE,
            singularTarget = "Seed",
            singularBnPron = "সিড",
            pluralTarget = "Seeds",
            pluralBnPron = "সিডস",
            bnMeaning = "বীজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_508",
            category = VocabCategory.NATURE,
            singularTarget = "Hill",
            singularBnPron = "হিল",
            pluralTarget = "Hills",
            pluralBnPron = "হিলস",
            bnMeaning = "পাহাড় / টিলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_509",
            category = VocabCategory.NATURE,
            singularTarget = "Sea",
            singularBnPron = "সি",
            pluralTarget = "Seas",
            pluralBnPron = "সিস",
            bnMeaning = "সমুদ্র / সাগর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_510",
            category = VocabCategory.NATURE,
            singularTarget = "Wave",
            singularBnPron = "ওয়েভ",
            pluralTarget = "Waves",
            pluralBnPron = "ওয়েভস",
            bnMeaning = "ঢেউ / তরঙ্গ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_511",
            category = VocabCategory.NATURE,
            singularTarget = "Sky",
            singularBnPron = "স্কাই",
            pluralTarget = "Skies",
            pluralBnPron = "স্কাইস",
            bnMeaning = "আকাশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_512",
            category = VocabCategory.NATURE,
            singularTarget = "Cloud",
            singularBnPron = "ক্লাউড",
            pluralTarget = "Clouds",
            pluralBnPron = "ক্লাউডস",
            bnMeaning = "মেঘ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_513",
            category = VocabCategory.NATURE,
            singularTarget = "Rain",
            singularBnPron = "রেইন",
            pluralTarget = "Rains",
            pluralBnPron = "রেইনস",
            bnMeaning = "বৃষ্টি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_514",
            category = VocabCategory.NATURE,
            singularTarget = "Snow",
            singularBnPron = "স্নো",
            pluralTarget = "Snows",
            pluralBnPron = "স্নোস",
            bnMeaning = "তুষার / বরফ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_515",
            category = VocabCategory.NATURE,
            singularTarget = "Wind",
            singularBnPron = "উইন্ড",
            pluralTarget = "Winds",
            pluralBnPron = "উইন্ডস",
            bnMeaning = "বাতাস / বায়ু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_516",
            category = VocabCategory.NATURE,
            singularTarget = "Storm",
            singularBnPron = "ঝড়",
            pluralTarget = "Storms",
            pluralBnPron = "ঝড়স",
            bnMeaning = "ঝড়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_517",
            category = VocabCategory.NATURE,
            singularTarget = "Sun",
            singularBnPron = "সান",
            pluralTarget = "Suns",
            pluralBnPron = "সানস",
            bnMeaning = "সূর্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_518",
            category = VocabCategory.NATURE,
            singularTarget = "Moon",
            singularBnPron = "মুন",
            pluralTarget = "Moons",
            pluralBnPron = "মুনস",
            bnMeaning = "চাঁদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_519",
            category = VocabCategory.NATURE,
            singularTarget = "Star",
            singularBnPron = "স্টার",
            pluralTarget = "Stars",
            pluralBnPron = "স্টার্স",
            bnMeaning = "তারা / নক্ষত্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_520",
            category = VocabCategory.NATURE,
            singularTarget = "Soil",
            singularBnPron = "সয়েল",
            pluralTarget = "Soils",
            pluralBnPron = "সয়েলস",
            bnMeaning = "মাটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_521",
            category = VocabCategory.NATURE,
            singularTarget = "Stone",
            singularBnPron = "স্টোন",
            pluralTarget = "Stones",
            pluralBnPron = "স্টোনস",
            bnMeaning = "পাথর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_522",
            category = VocabCategory.NATURE,
            singularTarget = "Sand",
            singularBnPron = "স্যান্ড",
            pluralTarget = "Sands",
            pluralBnPron = "স্যান্ডস",
            bnMeaning = "বালু / বালি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_523",
            category = VocabCategory.NATURE,
            singularTarget = "Grass",
            singularBnPron = "গ্রাস",
            pluralTarget = "Grasses",
            pluralBnPron = "গ্রাসেস",
            bnMeaning = "ঘাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_524",
            category = VocabCategory.NATURE,
            singularTarget = "Fire",
            singularBnPron = "ফায়ার",
            pluralTarget = "Fires",
            pluralBnPron = "ফায়ার্স",
            bnMeaning = "আগুন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_525",
            category = VocabCategory.NATURE,
            singularTarget = "Water",
            singularBnPron = "ওয়াটার",
            pluralTarget = "Waters",
            pluralBnPron = "ওয়াটার্স",
            bnMeaning = "জল / পানি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_526",
            category = VocabCategory.NATURE,
            singularTarget = "Air",
            singularBnPron = "এয়ার",
            pluralTarget = "Air",
            pluralBnPron = "এয়ার",
            bnMeaning = "বাতাস / আবহাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_527",
            category = VocabCategory.NATURE,
            singularTarget = "Weather",
            singularBnPron = "ওয়েদার",
            pluralTarget = "Weather",
            pluralBnPron = "ওয়েদার",
            bnMeaning = "আবহাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_528",
            category = VocabCategory.NATURE,
            singularTarget = "Temperature",
            singularBnPron = "টেম্পারেচার",
            pluralTarget = "Temperatures",
            pluralBnPron = "টেম্পারেচার্স",
            bnMeaning = "তাপমাত্রা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_529",
            category = VocabCategory.NATURE,
            singularTarget = "Heat",
            singularBnPron = "হিট",
            pluralTarget = "Heats",
            pluralBnPron = "হিটস",
            bnMeaning = "গরম / তাপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_530",
            category = VocabCategory.NATURE,
            singularTarget = "Cold",
            singularBnPron = "কোল্ড",
            pluralTarget = "Colds",
            pluralBnPron = "কোল্ডস",
            bnMeaning = "ঠান্ডা / শীত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_531",
            category = VocabCategory.NATURE,
            singularTarget = "Ice",
            singularBnPron = "আইস",
            pluralTarget = "Ice",
            pluralBnPron = "আইস",
            bnMeaning = "বরফ খণ্ড / আইস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_532",
            category = VocabCategory.NATURE,
            singularTarget = "Thunder",
            singularBnPron = "থান্ডার",
            pluralTarget = "Thunders",
            pluralBnPron = "থান্ডার্স",
            bnMeaning = "বজ্রপাত / মেঘের গর্জন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_533",
            category = VocabCategory.NATURE,
            singularTarget = "Lightning",
            singularBnPron = "লাইটনিং",
            pluralTarget = "Lightnings",
            pluralBnPron = "লাইটনিংস",
            bnMeaning = "বিদ্যুৎ চমক / বিজলী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_534",
            category = VocabCategory.NATURE,
            singularTarget = "Rainbow",
            singularBnPron = "রেইনবো",
            pluralTarget = "Rainbows",
            pluralBnPron = "রেইনবোস",
            bnMeaning = "রংধনু / রামধনু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_535",
            category = VocabCategory.NATURE,
            singularTarget = "Fog",
            singularBnPron = "ফগ",
            pluralTarget = "Fogs",
            pluralBnPron = "ফগস",
            bnMeaning = "কুয়াশা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_536",
            category = VocabCategory.NATURE,
            singularTarget = "Smoke",
            singularBnPron = "স্মোক",
            pluralTarget = "Smokes",
            pluralBnPron = "স্মোকস",
            bnMeaning = "ধোঁয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_537",
            category = VocabCategory.NATURE,
            singularTarget = "Cave",
            singularBnPron = "কেইভ",
            pluralTarget = "Caves",
            pluralBnPron = "কেইভস",
            bnMeaning = "গুহা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_538",
            category = VocabCategory.NATURE,
            singularTarget = "Field",
            singularBnPron = "ফিল্ড",
            pluralTarget = "Fields",
            pluralBnPron = "ফিল্ডস",
            bnMeaning = "মাঠ / প্রান্তর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_539",
            category = VocabCategory.NATURE,
            singularTarget = "Valley",
            singularBnPron = "ভ্যালি",
            pluralTarget = "Valleys",
            pluralBnPron = "ভ্যালিস",
            bnMeaning = "উপত্যকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_540",
            category = VocabCategory.NATURE,
            singularTarget = "Spring",
            singularBnPron = "স্প্রিং",
            pluralTarget = "Springs",
            pluralBnPron = "স্প্রিংস",
            bnMeaning = "বসন্তকাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_541",
            category = VocabCategory.NATURE,
            singularTarget = "Summer",
            singularBnPron = "সামার",
            pluralTarget = "Summers",
            pluralBnPron = "সামার্স",
            bnMeaning = "গ্রীষ্মকাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_542",
            category = VocabCategory.NATURE,
            singularTarget = "Autumn",
            singularBnPron = "অটাম",
            pluralTarget = "Autumns",
            pluralBnPron = "অটামস",
            bnMeaning = "শরৎকাল / হেমন্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_543",
            category = VocabCategory.NATURE,
            singularTarget = "Winter",
            singularBnPron = "উইন্টার",
            pluralTarget = "Winters",
            pluralBnPron = "উইন্টার্স",
            bnMeaning = "শীতকাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_544",
            category = VocabCategory.NATURE,
            singularTarget = "Earth",
            singularBnPron = "আর্থ",
            pluralTarget = "Earth",
            pluralBnPron = "আর্থ",
            bnMeaning = "পৃথিবী / ধরা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_545",
            category = VocabCategory.NATURE,
            singularTarget = "Sunrise",
            singularBnPron = "সানরাইজ",
            pluralTarget = "Sunrises",
            pluralBnPron = "সানরাইজেস",
            bnMeaning = "সূর্যোদয় / ভোর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_546",
            category = VocabCategory.NATURE,
            singularTarget = "Sunset",
            singularBnPron = "সানসেট",
            pluralTarget = "Sunsets",
            pluralBnPron = "সানসেটস",
            bnMeaning = "সূর্যাস্ত / গোধূলি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_547",
            category = VocabCategory.NATURE,
            singularTarget = "Waterfall",
            singularBnPron = "ওয়াটারফল",
            pluralTarget = "Waterfalls",
            pluralBnPron = "ওয়াটারফলস",
            bnMeaning = "জলপ্রপাত / ঝরনা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_548",
            category = VocabCategory.NATURE,
            singularTarget = "Spring / Source",
            singularBnPron = "স্প্রিং",
            pluralTarget = "Springs",
            pluralBnPron = "স্প্রিংস",
            bnMeaning = "ঝর্ণা / উৎস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_549",
            category = VocabCategory.NATURE,
            singularTarget = "Environment",
            singularBnPron = "এনভায়রনমেন্ট",
            pluralTarget = "Environments",
            pluralBnPron = "এনভায়রনমেন্টস",
            bnMeaning = "পরিবেশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_550",
            category = VocabCategory.NATURE,
            singularTarget = "Nature",
            singularBnPron = "নেচার",
            pluralTarget = "Nature",
            pluralBnPron = "নেচার",
            bnMeaning = "প্রকৃতি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_551",
            category = VocabCategory.ANIMALS,
            singularTarget = "Dog",
            singularBnPron = "ডগ",
            pluralTarget = "Dogs",
            pluralBnPron = "ডগস",
            bnMeaning = "কুকুর",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_552",
            category = VocabCategory.ANIMALS,
            singularTarget = "Cat",
            singularBnPron = "ক্যাট",
            pluralTarget = "Cats",
            pluralBnPron = "ক্যাটস",
            bnMeaning = "বিড়াল",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_553",
            category = VocabCategory.ANIMALS,
            singularTarget = "Cow",
            singularBnPron = "কাউ",
            pluralTarget = "Cows",
            pluralBnPron = "কাউস",
            bnMeaning = "গরু / গাভী",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_554",
            category = VocabCategory.ANIMALS,
            singularTarget = "Bull",
            singularBnPron = "বুল",
            pluralTarget = "Bulls",
            pluralBnPron = "বুলস",
            bnMeaning = "ষাঁড় / বলদ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_555",
            category = VocabCategory.ANIMALS,
            singularTarget = "Buffalo",
            singularBnPron = "বাফেলো",
            pluralTarget = "Buffaloes",
            pluralBnPron = "বাফেলোস",
            bnMeaning = "মহিষ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_556",
            category = VocabCategory.ANIMALS,
            singularTarget = "Goat",
            singularBnPron = "গোট",
            pluralTarget = "Goats",
            pluralBnPron = "গোটস",
            bnMeaning = "ছাগল",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_557",
            category = VocabCategory.ANIMALS,
            singularTarget = "Sheep",
            singularBnPron = "শীপ",
            pluralTarget = "Sheep",
            pluralBnPron = "শীপ",
            bnMeaning = "ভেড়া",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_558",
            category = VocabCategory.ANIMALS,
            singularTarget = "Horse",
            singularBnPron = "হর্স",
            pluralTarget = "Horses",
            pluralBnPron = "হর্সেস",
            bnMeaning = "ঘোড়া",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_559",
            category = VocabCategory.ANIMALS,
            singularTarget = "Donkey",
            singularBnPron = "ডাংকি",
            pluralTarget = "Donkeys",
            pluralBnPron = "ডাংকিস",
            bnMeaning = "গাধা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_560",
            category = VocabCategory.ANIMALS,
            singularTarget = "Camel",
            singularBnPron = "ক্যামেল",
            pluralTarget = "Camels",
            pluralBnPron = "ক্যামেলস",
            bnMeaning = "উট",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_561",
            category = VocabCategory.ANIMALS,
            singularTarget = "Elephant",
            singularBnPron = "এলিফ্যান্ট",
            pluralTarget = "Elephants",
            pluralBnPron = "এলিফ্যান্টস",
            bnMeaning = "হাতি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_562",
            category = VocabCategory.ANIMALS,
            singularTarget = "Lion",
            singularBnPron = "লায়ন",
            pluralTarget = "Lions",
            pluralBnPron = "লায়নস",
            bnMeaning = "সিংহ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_563",
            category = VocabCategory.ANIMALS,
            singularTarget = "Tiger",
            singularBnPron = "টাইগার",
            pluralTarget = "Tigers",
            pluralBnPron = "টাইগার্স",
            bnMeaning = "বাঘ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_564",
            category = VocabCategory.ANIMALS,
            singularTarget = "Leopard",
            singularBnPron = "লেপার্ড",
            pluralTarget = "Leopards",
            pluralBnPron = "লেপার্ডস",
            bnMeaning = "চিতাবাঘ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_565",
            category = VocabCategory.ANIMALS,
            singularTarget = "Bear",
            singularBnPron = "বেয়ার",
            pluralTarget = "Bears",
            pluralBnPron = "বেয়ার্স",
            bnMeaning = "ভাল্লুক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_566",
            category = VocabCategory.ANIMALS,
            singularTarget = "Wolf",
            singularBnPron = "উল্ফ",
            pluralTarget = "Wolves",
            pluralBnPron = "উল্ভস",
            bnMeaning = "নেকড়ে",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_567",
            category = VocabCategory.ANIMALS,
            singularTarget = "Fox",
            singularBnPron = "ফক্স",
            pluralTarget = "Foxes",
            pluralBnPron = "ফক্সেস",
            bnMeaning = "শেয়াল",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_568",
            category = VocabCategory.ANIMALS,
            singularTarget = "Deer",
            singularBnPron = "ডিয়ার",
            pluralTarget = "Deer",
            pluralBnPron = "ডিয়ার",
            bnMeaning = "হরিণ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_569",
            category = VocabCategory.ANIMALS,
            singularTarget = "Monkey",
            singularBnPron = "মাংকি",
            pluralTarget = "Monkeys",
            pluralBnPron = "মাংকিস",
            bnMeaning = "বানর",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_570",
            category = VocabCategory.ANIMALS,
            singularTarget = "Rabbit",
            singularBnPron = "র‌্যাবিট",
            pluralTarget = "Rabbits",
            pluralBnPron = "র‌্যাবিটস",
            bnMeaning = "খরগোশ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_571",
            category = VocabCategory.ANIMALS,
            singularTarget = "Rat",
            singularBnPron = "র‌্যাট",
            pluralTarget = "Rats",
            pluralBnPron = "র‌্যাটস",
            bnMeaning = "ইঁদুর",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_572",
            category = VocabCategory.ANIMALS,
            singularTarget = "Snake",
            singularBnPron = "স্নেক",
            pluralTarget = "Snakes",
            pluralBnPron = "স্নেকস",
            bnMeaning = "সাপ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_573",
            category = VocabCategory.ANIMALS,
            singularTarget = "Frog",
            singularBnPron = "ফ্রগ",
            pluralTarget = "Frogs",
            pluralBnPron = "ফ্রগস",
            bnMeaning = "ব্যাঙ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_574",
            category = VocabCategory.ANIMALS,
            singularTarget = "Turtle",
            singularBnPron = "টার্টল",
            pluralTarget = "Turtles",
            pluralBnPron = "টার্টলস",
            bnMeaning = "কচ্ছপ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_575",
            category = VocabCategory.ANIMALS,
            singularTarget = "Crocodile",
            singularBnPron = "ক্রোকোডাইল",
            pluralTarget = "Crocodiles",
            pluralBnPron = "ক্রোকোডাইলস",
            bnMeaning = "কুমির",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_576",
            category = VocabCategory.ANIMALS,
            singularTarget = "Fish",
            singularBnPron = "ফিশ",
            pluralTarget = "Fish",
            pluralBnPron = "ফিশ",
            bnMeaning = "মাছ",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_577",
            category = VocabCategory.ANIMALS,
            singularTarget = "Shark",
            singularBnPron = "শার্ক",
            pluralTarget = "Sharks",
            pluralBnPron = "শার্কস",
            bnMeaning = "হাঙর",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_578",
            category = VocabCategory.ANIMALS,
            singularTarget = "Whale",
            singularBnPron = "হোয়েল",
            pluralTarget = "Whales",
            pluralBnPron = "হোয়েলস",
            bnMeaning = "তিমি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_579",
            category = VocabCategory.ANIMALS,
            singularTarget = "Dolphin",
            singularBnPron = "ডলফিন",
            pluralTarget = "Dolphins",
            pluralBnPron = "ডলফিনস",
            bnMeaning = "ডলফিন",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_580",
            category = VocabCategory.ANIMALS,
            singularTarget = "Bird",
            singularBnPron = "বার্ড",
            pluralTarget = "Birds",
            pluralBnPron = "বার্ডস",
            bnMeaning = "পাখি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_581",
            category = VocabCategory.ANIMALS,
            singularTarget = "Crow",
            singularBnPron = "ক্রো",
            pluralTarget = "Crows",
            pluralBnPron = "ক্রোস",
            bnMeaning = "কাক",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_582",
            category = VocabCategory.ANIMALS,
            singularTarget = "Sparrow",
            singularBnPron = "স্প্যারো",
            pluralTarget = "Sparrows",
            pluralBnPron = "স্প্যারোস",
            bnMeaning = "চড়ুই পাখি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_583",
            category = VocabCategory.ANIMALS,
            singularTarget = "Pigeon",
            singularBnPron = "পিজন",
            pluralTarget = "Pigeons",
            pluralBnPron = "পিজনস",
            bnMeaning = "কবুতর / পায়রা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_584",
            category = VocabCategory.ANIMALS,
            singularTarget = "Eagle",
            singularBnPron = "ঈগল",
            pluralTarget = "Eagles",
            pluralBnPron = "ঈগলস",
            bnMeaning = "ঈগল পাখি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_585",
            category = VocabCategory.ANIMALS,
            singularTarget = "Parrot",
            singularBnPron = "প্যারাট",
            pluralTarget = "Parrots",
            pluralBnPron = "প্যারাটস",
            bnMeaning = "তোতাপাখি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_586",
            category = VocabCategory.ANIMALS,
            singularTarget = "Peacock",
            singularBnPron = "পিকক",
            pluralTarget = "Peacocks",
            pluralBnPron = "পিককস",
            bnMeaning = "ময়ূর",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_587",
            category = VocabCategory.ANIMALS,
            singularTarget = "Owl",
            singularBnPron = "আউল",
            pluralTarget = "Owls",
            pluralBnPron = "আউলস",
            bnMeaning = "পেঁচা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_588",
            category = VocabCategory.ANIMALS,
            singularTarget = "Duck",
            singularBnPron = "ডাক",
            pluralTarget = "Ducks",
            pluralBnPron = "ডাকস",
            bnMeaning = "হাঁস",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_589",
            category = VocabCategory.ANIMALS,
            singularTarget = "Swan",
            singularBnPron = "সোয়ান",
            pluralTarget = "Swans",
            pluralBnPron = "সোয়ানস",
            bnMeaning = "রাজহাঁস",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_590",
            category = VocabCategory.ANIMALS,
            singularTarget = "Hen",
            singularBnPron = "হেন",
            pluralTarget = "Hens",
            pluralBnPron = "হেনস",
            bnMeaning = "মুরগি",
            gender = GrammaticalGender.FEMININE
        ),
        VocabItem(
            id = "en_vocab_591",
            category = VocabCategory.ANIMALS,
            singularTarget = "Rooster",
            singularBnPron = "রুস্টার",
            pluralTarget = "Roosters",
            pluralBnPron = "রুস্টার্স",
            bnMeaning = "মোরগ",
            gender = GrammaticalGender.MASCULINE
        ),
        VocabItem(
            id = "en_vocab_592",
            category = VocabCategory.ANIMALS,
            singularTarget = "Bat",
            singularBnPron = "ব্যাট",
            pluralTarget = "Bats",
            pluralBnPron = "ব্যাটস",
            bnMeaning = "বাদুড়",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_593",
            category = VocabCategory.ANIMALS,
            singularTarget = "Bee",
            singularBnPron = "বি",
            pluralTarget = "Bees",
            pluralBnPron = "বিস",
            bnMeaning = "মৌমাছি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_594",
            category = VocabCategory.ANIMALS,
            singularTarget = "Butterfly",
            singularBnPron = "বাটারফ্লাই",
            pluralTarget = "Butterflies",
            pluralBnPron = "বাটারফ্লাইস",
            bnMeaning = "প্রজাপতি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_595",
            category = VocabCategory.ANIMALS,
            singularTarget = "Mosquito",
            singularBnPron = "মসকিটো",
            pluralTarget = "Mosquitoes",
            pluralBnPron = "মসকিটোস",
            bnMeaning = "মশা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_596",
            category = VocabCategory.ANIMALS,
            singularTarget = "Fly",
            singularBnPron = "ফ্লাই",
            pluralTarget = "Flies",
            pluralBnPron = "ফ্লাইস",
            bnMeaning = "মাছি",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_597",
            category = VocabCategory.ANIMALS,
            singularTarget = "Ant",
            singularBnPron = "অ্যান্ট",
            pluralTarget = "Ants",
            pluralBnPron = "অ্যান্টস",
            bnMeaning = "পিপঁড়া",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_598",
            category = VocabCategory.ANIMALS,
            singularTarget = "Spider",
            singularBnPron = "স্পাইডার",
            pluralTarget = "Spiders",
            pluralBnPron = "স্পাইডার্স",
            bnMeaning = "মাকড়সা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_599",
            category = VocabCategory.ANIMALS,
            singularTarget = "Scorpion",
            singularBnPron = "স্করপিয়ন",
            pluralTarget = "Scorpions",
            pluralBnPron = "স্করপিয়নস",
            bnMeaning = "বিচ্ছু / কাঁকড়াবিছা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_600",
            category = VocabCategory.ANIMALS,
            singularTarget = "Worm",
            singularBnPron = "ওয়ার্ম",
            pluralTarget = "Worms",
            pluralBnPron = "ওয়ার্মস",
            bnMeaning = "কেঁচো / কৃমি",
            gender = GrammaticalGender.COMMON
        ),
    )

    private val chunk7 = listOf(
        VocabItem(
            id = "en_vocab_601",
            category = VocabCategory.ACTIONS,
            singularTarget = "Eat",
            singularBnPron = "ইট",
            pluralTarget = "Eat",
            pluralBnPron = "ইট",
            bnMeaning = "খাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_602",
            category = VocabCategory.ACTIONS,
            singularTarget = "Drink",
            singularBnPron = "ড্রিংক",
            pluralTarget = "Drink",
            pluralBnPron = "ড্রিংক",
            bnMeaning = "পান করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_603",
            category = VocabCategory.ACTIONS,
            singularTarget = "Sleep",
            singularBnPron = "স্লিপ",
            pluralTarget = "Sleep",
            pluralBnPron = "স্লিপ",
            bnMeaning = "ঘুমানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_604",
            category = VocabCategory.ACTIONS,
            singularTarget = "Wake up",
            singularBnPron = "ওয়েক আপ",
            pluralTarget = "Wake up",
            pluralBnPron = "ওয়েক আপ",
            bnMeaning = "জেগে ওঠা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_605",
            category = VocabCategory.ACTIONS,
            singularTarget = "Walk",
            singularBnPron = "ওয়াক",
            pluralTarget = "Walk",
            pluralBnPron = "ওয়াক",
            bnMeaning = "হাঁটা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_606",
            category = VocabCategory.ACTIONS,
            singularTarget = "Run",
            singularBnPron = "রান",
            pluralTarget = "Run",
            pluralBnPron = "রান",
            bnMeaning = "দৌড়ানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_607",
            category = VocabCategory.ACTIONS,
            singularTarget = "Jump",
            singularBnPron = "জাম্প",
            pluralTarget = "Jump",
            pluralBnPron = "জাম্প",
            bnMeaning = "লাফানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_608",
            category = VocabCategory.ACTIONS,
            singularTarget = "Sit",
            singularBnPron = "সিট",
            pluralTarget = "Sit",
            pluralBnPron = "সিট",
            bnMeaning = "বসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_609",
            category = VocabCategory.ACTIONS,
            singularTarget = "Stand",
            singularBnPron = "স্ট্যান্ড",
            pluralTarget = "Stand",
            pluralBnPron = "স্ট্যান্ড",
            bnMeaning = "দাঁড়ানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_610",
            category = VocabCategory.ACTIONS,
            singularTarget = "Speak",
            singularBnPron = "স্পিক",
            pluralTarget = "Speak",
            pluralBnPron = "স্পিক",
            bnMeaning = "কথা বলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_611",
            category = VocabCategory.ACTIONS,
            singularTarget = "Say",
            singularBnPron = "সে",
            pluralTarget = "Say",
            pluralBnPron = "সে",
            bnMeaning = "বলা / জানানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_612",
            category = VocabCategory.ACTIONS,
            singularTarget = "Listen",
            singularBnPron = "লিসেন",
            pluralTarget = "Listen",
            pluralBnPron = "লিসেন",
            bnMeaning = "শোনা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_613",
            category = VocabCategory.ACTIONS,
            singularTarget = "See",
            singularBnPron = "সি",
            pluralTarget = "See",
            pluralBnPron = "সি",
            bnMeaning = "দেখা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_614",
            category = VocabCategory.ACTIONS,
            singularTarget = "Read",
            singularBnPron = "রিড",
            pluralTarget = "Read",
            pluralBnPron = "রিড",
            bnMeaning = "পড়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_615",
            category = VocabCategory.ACTIONS,
            singularTarget = "Write",
            singularBnPron = "রাইট",
            pluralTarget = "Write",
            pluralBnPron = "রাইট",
            bnMeaning = "লেখা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_616",
            category = VocabCategory.ACTIONS,
            singularTarget = "Learn",
            singularBnPron = "লার্ন",
            pluralTarget = "Learn",
            pluralBnPron = "লার্ন",
            bnMeaning = "শেখা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_617",
            category = VocabCategory.ACTIONS,
            singularTarget = "Teach",
            singularBnPron = "টিচ",
            pluralTarget = "Teach",
            pluralBnPron = "টিচ",
            bnMeaning = "শেখানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_618",
            category = VocabCategory.ACTIONS,
            singularTarget = "Buy",
            singularBnPron = "বাই",
            pluralTarget = "Buy",
            pluralBnPron = "বাই",
            bnMeaning = "কেনা / ক্রয় করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_619",
            category = VocabCategory.ACTIONS,
            singularTarget = "Sell",
            singularBnPron = "সেল",
            pluralTarget = "Sell",
            pluralBnPron = "সেল",
            bnMeaning = "বিক্রি করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_620",
            category = VocabCategory.ACTIONS,
            singularTarget = "Give",
            singularBnPron = "গিভ",
            pluralTarget = "Give",
            pluralBnPron = "গিভ",
            bnMeaning = "দেওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_621",
            category = VocabCategory.ACTIONS,
            singularTarget = "Take",
            singularBnPron = "টেক",
            pluralTarget = "Take",
            pluralBnPron = "টেক",
            bnMeaning = "নেওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_622",
            category = VocabCategory.ACTIONS,
            singularTarget = "Open",
            singularBnPron = "ওপেন",
            pluralTarget = "Open",
            pluralBnPron = "ওপেন",
            bnMeaning = "খোলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_623",
            category = VocabCategory.ACTIONS,
            singularTarget = "Close",
            singularBnPron = "ক্লোজ",
            pluralTarget = "Close",
            pluralBnPron = "ক্লোজ",
            bnMeaning = "বন্ধ করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_624",
            category = VocabCategory.ACTIONS,
            singularTarget = "Start",
            singularBnPron = "স্টার্ট",
            pluralTarget = "Start",
            pluralBnPron = "স্টার্ট",
            bnMeaning = "শুরু করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_625",
            category = VocabCategory.ACTIONS,
            singularTarget = "Finish",
            singularBnPron = "ফিনিশ",
            pluralTarget = "Finish",
            pluralBnPron = "ফিনিশ",
            bnMeaning = "শেষ করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_626",
            category = VocabCategory.ACTIONS,
            singularTarget = "Come",
            singularBnPron = "কাম",
            pluralTarget = "Come",
            pluralBnPron = "কাম",
            bnMeaning = "আসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_627",
            category = VocabCategory.ACTIONS,
            singularTarget = "Go",
            singularBnPron = "গো",
            pluralTarget = "Go",
            pluralBnPron = "গো",
            bnMeaning = "যাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_628",
            category = VocabCategory.ACTIONS,
            singularTarget = "Return",
            singularBnPron = "রিটার্ন",
            pluralTarget = "Return",
            pluralBnPron = "রিটার্ন",
            bnMeaning = "ফিরে আসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_629",
            category = VocabCategory.ACTIONS,
            singularTarget = "Wait",
            singularBnPron = "ওয়েট",
            pluralTarget = "Wait",
            pluralBnPron = "ওয়েট",
            bnMeaning = "অপেক্ষা করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_630",
            category = VocabCategory.ACTIONS,
            singularTarget = "Help",
            singularBnPron = "হেল্প",
            pluralTarget = "Help",
            pluralBnPron = "হেল্প",
            bnMeaning = "সাহায্য করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_631",
            category = VocabCategory.ACTIONS,
            singularTarget = "Work",
            singularBnPron = "ওয়ার্ক",
            pluralTarget = "Work",
            pluralBnPron = "ওয়ার্ক",
            bnMeaning = "কাজ করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_632",
            category = VocabCategory.ACTIONS,
            singularTarget = "Play",
            singularBnPron = "প্লে",
            pluralTarget = "Play",
            pluralBnPron = "প্লে",
            bnMeaning = "খেলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_633",
            category = VocabCategory.ACTIONS,
            singularTarget = "Sing",
            singularBnPron = "সিং",
            pluralTarget = "Sing",
            pluralBnPron = "সিং",
            bnMeaning = "গান গাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_634",
            category = VocabCategory.ACTIONS,
            singularTarget = "Dance",
            singularBnPron = "ড্যান্স",
            pluralTarget = "Dance",
            pluralBnPron = "ড্যান্স",
            bnMeaning = "নাচা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_635",
            category = VocabCategory.ACTIONS,
            singularTarget = "Laugh",
            singularBnPron = "লাফ",
            pluralTarget = "Laugh",
            pluralBnPron = "লাফ",
            bnMeaning = "হাসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_636",
            category = VocabCategory.ACTIONS,
            singularTarget = "Cry",
            singularBnPron = "ক্রাই",
            pluralTarget = "Cry",
            pluralBnPron = "ক্রাই",
            bnMeaning = "কাঁদা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_637",
            category = VocabCategory.ACTIONS,
            singularTarget = "Think",
            singularBnPron = "থিংক",
            pluralTarget = "Think",
            pluralBnPron = "থিংক",
            bnMeaning = "চিন্তা করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_638",
            category = VocabCategory.ACTIONS,
            singularTarget = "Understand",
            singularBnPron = "আন্ডারস্ট্যান্ড",
            pluralTarget = "Understand",
            pluralBnPron = "আন্ডারস্ট্যান্ড",
            bnMeaning = "বুঝতে পারা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_639",
            category = VocabCategory.ACTIONS,
            singularTarget = "Remember",
            singularBnPron = "রিমেম্বার",
            pluralTarget = "Remember",
            pluralBnPron = "রিমেম্বার",
            bnMeaning = "মনে রাখা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_640",
            category = VocabCategory.ACTIONS,
            singularTarget = "Forget",
            singularBnPron = "ফরগেট",
            pluralTarget = "Forget",
            pluralBnPron = "ফরগেট",
            bnMeaning = "ভুলে যাওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_641",
            category = VocabCategory.ACTIONS,
            singularTarget = "Cook",
            singularBnPron = "কুক",
            pluralTarget = "Cook",
            pluralBnPron = "কুক",
            bnMeaning = "রান্না করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_642",
            category = VocabCategory.ACTIONS,
            singularTarget = "Wash",
            singularBnPron = "ওয়াশ",
            pluralTarget = "Wash",
            pluralBnPron = "ওয়াশ",
            bnMeaning = "ধোয়া / পরিষ্কার করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_643",
            category = VocabCategory.ACTIONS,
            singularTarget = "Clean",
            singularBnPron = "ক্লিন",
            pluralTarget = "Clean",
            pluralBnPron = "ক্লিন",
            bnMeaning = "পরিষ্কার করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_644",
            category = VocabCategory.ACTIONS,
            singularTarget = "Cut",
            singularBnPron = "কাট",
            pluralTarget = "Cut",
            pluralBnPron = "কাট",
            bnMeaning = "কাটা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_645",
            category = VocabCategory.ACTIONS,
            singularTarget = "Put",
            singularBnPron = "পুট",
            pluralTarget = "Put",
            pluralBnPron = "পুট",
            bnMeaning = "রাখা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_646",
            category = VocabCategory.ACTIONS,
            singularTarget = "Bring",
            singularBnPron = "ব্রিং",
            pluralTarget = "Bring",
            pluralBnPron = "ব্রিং",
            bnMeaning = "আনা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_647",
            category = VocabCategory.ACTIONS,
            singularTarget = "Send",
            singularBnPron = "সেন্ড",
            pluralTarget = "Send",
            pluralBnPron = "সেন্ড",
            bnMeaning = "পাঠানো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_648",
            category = VocabCategory.ACTIONS,
            singularTarget = "Call",
            singularBnPron = "কল",
            pluralTarget = "Call",
            pluralBnPron = "কল",
            bnMeaning = "ডাকা / কল করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_649",
            category = VocabCategory.ACTIONS,
            singularTarget = "Ask",
            singularBnPron = "আস্ক",
            pluralTarget = "Ask",
            pluralBnPron = "আস্ক",
            bnMeaning = "জিজ্ঞাসা করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_650",
            category = VocabCategory.ACTIONS,
            singularTarget = "Live",
            singularBnPron = "লিভ",
            pluralTarget = "Live",
            pluralBnPron = "লিভ",
            bnMeaning = "বাস করা / থাকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_651",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Happiness",
            singularBnPron = "হ্যাপিনেস",
            pluralTarget = "Happiness",
            pluralBnPron = "হ্যাপিনেস",
            bnMeaning = "আনন্দ / সুখ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_652",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Sadness",
            singularBnPron = "স্যাডনেস",
            pluralTarget = "Sadness",
            pluralBnPron = "স্যাডনেস",
            bnMeaning = "দুঃখ / কষ্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_653",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Anger",
            singularBnPron = "অ্যাঙ্গার",
            pluralTarget = "Anger",
            pluralBnPron = "অ্যাঙ্গার",
            bnMeaning = "রাগ / ক্রোধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_654",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Fear",
            singularBnPron = "ফিয়ার",
            pluralTarget = "Fears",
            pluralBnPron = "ফিয়ার্স",
            bnMeaning = "ভয়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_655",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Love",
            singularBnPron = "লাভ",
            pluralTarget = "Loves",
            pluralBnPron = "লাভস",
            bnMeaning = "ভালোবাসা / প্রেম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_656",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Hate",
            singularBnPron = "হেইট",
            pluralTarget = "Hate",
            pluralBnPron = "হেইট",
            bnMeaning = "ঘৃণা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_657",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Hope",
            singularBnPron = "হোপ",
            pluralTarget = "Hopes",
            pluralBnPron = "হোপস",
            bnMeaning = "আশা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_658",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Peace",
            singularBnPron = "পিস",
            pluralTarget = "Peace",
            pluralBnPron = "পিস",
            bnMeaning = "শান্তি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_659",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Surprise",
            singularBnPron = "সারপ্রাইজ",
            pluralTarget = "Surprises",
            pluralBnPron = "সারপ্রাইজেস",
            bnMeaning = "আশ্চর্য / বিস্ময়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_660",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Trust",
            singularBnPron = "ট্রাস্ট",
            pluralTarget = "Trust",
            pluralBnPron = "ট্রাস্ট",
            bnMeaning = "বিশ্বাস / ভরসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_661",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Courage",
            singularBnPron = "কারেজ",
            pluralTarget = "Courage",
            pluralBnPron = "কারেজ",
            bnMeaning = "সাহস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_662",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Pride",
            singularBnPron = "প্রাইড",
            pluralTarget = "Pride",
            pluralBnPron = "প্রাইড",
            bnMeaning = "গর্ব / অহংকার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_663",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Shame",
            singularBnPron = "শেইম",
            pluralTarget = "Shame",
            pluralBnPron = "শেইম",
            bnMeaning = "লজ্জা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_664",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Jealousy",
            singularBnPron = "জেলাসি",
            pluralTarget = "Jealousies",
            pluralBnPron = "জেলাসিস",
            bnMeaning = "ঈর্ষা / হিংসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_665",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Worry",
            singularBnPron = "ওরি",
            pluralTarget = "Worries",
            pluralBnPron = "ওরিস",
            bnMeaning = "উদ্বেগ / চিন্তা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_666",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Relief",
            singularBnPron = "রিলিফ",
            pluralTarget = "Reliefs",
            pluralBnPron = "রিলিফস",
            bnMeaning = "স্বস্তি / প্রশান্তি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_667",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Excitement",
            singularBnPron = "এক্সাইটমেন্ট",
            pluralTarget = "Excitements",
            pluralBnPron = "এক্সাইটমেন্টস",
            bnMeaning = "উত্তেজনা / রোমাঞ্চ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_668",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Boredom",
            singularBnPron = "বোরডম",
            pluralTarget = "Boredom",
            pluralBnPron = "বোরডম",
            bnMeaning = "একঘেয়েমি / বিরক্তি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_669",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Confusion",
            singularBnPron = "কনফিউশন",
            pluralTarget = "Confusions",
            pluralBnPron = "কনফিউশনস",
            bnMeaning = "বিভ্রান্তি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_670",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Disappointment",
            singularBnPron = "ডিসঅ্যাপয়েন্টমেন্ট",
            pluralTarget = "Disappointments",
            pluralBnPron = "ডিসঅ্যাপয়েন্টমেন্টস",
            bnMeaning = "হতাশা / নিরাশা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_671",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Gratitude",
            singularBnPron = "গ্র্যাটিচিউড",
            pluralTarget = "Gratitude",
            pluralBnPron = "গ্র্যাটিচিউড",
            bnMeaning = "কৃতজ্ঞতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_672",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Regret",
            singularBnPron = "রিগ্রেট",
            pluralTarget = "Regrets",
            pluralBnPron = "রিগ্রেটস",
            bnMeaning = "অনুতাপ / আফসোস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_673",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Loneliness",
            singularBnPron = "লোনলিনেস",
            pluralTarget = "Loneliness",
            pluralBnPron = "লোনলিনেস",
            bnMeaning = "একাকীত্ব",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_674",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Compassion",
            singularBnPron = "কম্প্যাশন",
            pluralTarget = "Compassion",
            pluralBnPron = "কম্প্যাশন",
            bnMeaning = "দয়া / সহানুভূতি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_675",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Patience",
            singularBnPron = "পেশেন্স",
            pluralTarget = "Patience",
            pluralBnPron = "পেশেন্স",
            bnMeaning = "ধৈর্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_676",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Honesty",
            singularBnPron = "অনেস্টি",
            pluralTarget = "Honesty",
            pluralBnPron = "অনেস্টি",
            bnMeaning = "সততা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_677",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Curiosity",
            singularBnPron = "কিউরিওসিটি",
            pluralTarget = "Curiosity",
            pluralBnPron = "কিউরিওসিটি",
            bnMeaning = "কৌতূহল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_678",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Respect",
            singularBnPron = "রেসপেক্ট",
            pluralTarget = "Respect",
            pluralBnPron = "রেসপেক্ট",
            bnMeaning = "শ্রদ্ধা / সম্মান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_679",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Confidence",
            singularBnPron = "কনফিডেন্স",
            pluralTarget = "Confidence",
            pluralBnPron = "কনফিডেন্স",
            bnMeaning = "আত্মবিশ্বাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_680",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Doubt",
            singularBnPron = "ডাউট",
            pluralTarget = "Doubts",
            pluralBnPron = "ডাউটস",
            bnMeaning = "সন্দেহ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_681",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Happy",
            singularBnPron = "হ্যাপি",
            pluralTarget = "Happy",
            pluralBnPron = "হ্যাপি",
            bnMeaning = "সুখী / আনন্দিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_682",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Sad",
            singularBnPron = "স্যাড",
            pluralTarget = "Sad",
            pluralBnPron = "স্যাড",
            bnMeaning = "দুঃখী / বিষণ্ণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_683",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Angry",
            singularBnPron = "অ্যাংগ্রি",
            pluralTarget = "Angry",
            pluralBnPron = "অ্যাংগ্রি",
            bnMeaning = "রাগান্বিত / ক্ষুব্ধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_684",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Afraid",
            singularBnPron = "আফ্রেইড",
            pluralTarget = "Afraid",
            pluralBnPron = "আফ্রেইড",
            bnMeaning = "ভীত / শঙ্কিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_685",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Hopeful",
            singularBnPron = "হোপফুল",
            pluralTarget = "Hopeful",
            pluralBnPron = "হোপফুল",
            bnMeaning = "আশাবাদী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_686",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Calm",
            singularBnPron = "কাম",
            pluralTarget = "Calm",
            pluralBnPron = "কাম",
            bnMeaning = "শান্ত / নীরব",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_687",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Proud",
            singularBnPron = "প্রাউড",
            pluralTarget = "Proud",
            pluralBnPron = "প্রাউড",
            bnMeaning = "গর্বিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_688",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Ashamed",
            singularBnPron = "অ্যাশ্মড",
            pluralTarget = "Ashamed",
            pluralBnPron = "অ্যাশ্মড",
            bnMeaning = "লজ্জিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_689",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Jealous",
            singularBnPron = "জেলাস",
            pluralTarget = "Jealous",
            pluralBnPron = "জেলাস",
            bnMeaning = "ঈর্ষান্বিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_690",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Worried",
            singularBnPron = "ওরিড",
            pluralTarget = "Worried",
            pluralBnPron = "ওরিড",
            bnMeaning = "চিন্তিত / উদ্বিগ্ন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_691",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Excited",
            singularBnPron = "এক্সাইটেড",
            pluralTarget = "Excited",
            pluralBnPron = "এক্সাইটেড",
            bnMeaning = "উত্তেজিত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_692",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Tired",
            singularBnPron = "টায়ার্ড",
            pluralTarget = "Tired",
            pluralBnPron = "টায়ার্ড",
            bnMeaning = "ক্লান্ত / পরিশ্রান্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_693",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Lonely",
            singularBnPron = "লোনলি",
            pluralTarget = "Lonely",
            pluralBnPron = "লোনলি",
            bnMeaning = "নিঃসঙ্গ / একাকী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_694",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Grateful",
            singularBnPron = "গ্রেটফুল",
            pluralTarget = "Grateful",
            pluralBnPron = "গ্রেটফুল",
            bnMeaning = "কৃতজ্ঞ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_695",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Brave",
            singularBnPron = "ব্রেইভ",
            pluralTarget = "Brave",
            pluralBnPron = "ব্রেইভ",
            bnMeaning = "সাহসী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_696",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Honest",
            singularBnPron = "অনেস্ট",
            pluralTarget = "Honest",
            pluralBnPron = "অনেস্ট",
            bnMeaning = "সৎ / নিষ্ঠাবান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_697",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Patient",
            singularBnPron = "পেশেন্ট",
            pluralTarget = "Patient",
            pluralBnPron = "পেশেন্ট",
            bnMeaning = "ধৈর্যশীল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_698",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Anxious",
            singularBnPron = "অ্যাংকশাস",
            pluralTarget = "Anxious",
            pluralBnPron = "অ্যাংকশাস",
            bnMeaning = "উদ্বিগ্ন / অস্থির",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_699",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Astonished",
            singularBnPron = "অ্যাস্টনিশড",
            pluralTarget = "Astonished",
            pluralBnPron = "অ্যাস্টনিশড",
            bnMeaning = "বিস্মিত / অবাক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_700",
            category = VocabCategory.EMOTIONS,
            singularTarget = "Confident",
            singularBnPron = "কনফিডেন্ট",
            pluralTarget = "Confident",
            pluralBnPron = "কনফিডেন্ট",
            bnMeaning = "আত্মবিশ্বাসী",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk8 = listOf(
        VocabItem(
            id = "en_vocab_701",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Good",
            singularBnPron = "গুড",
            pluralTarget = "Good",
            pluralBnPron = "গুড",
            bnMeaning = "ভালো / উত্তম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_702",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Bad",
            singularBnPron = "ব্যাড",
            pluralTarget = "Bad",
            pluralBnPron = "ব্যাড",
            bnMeaning = "খারাপ / মন্দ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_703",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Big",
            singularBnPron = "বিগ",
            pluralTarget = "Big",
            pluralBnPron = "বিগ",
            bnMeaning = "বড়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_704",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Small",
            singularBnPron = "স্মল",
            pluralTarget = "Small",
            pluralBnPron = "স্মল",
            bnMeaning = "ছোট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_705",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Long",
            singularBnPron = "লং",
            pluralTarget = "Long",
            pluralBnPron = "লং",
            bnMeaning = "লম্বা / দীর্ঘ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_706",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Short",
            singularBnPron = "শর্ট",
            pluralTarget = "Short",
            pluralBnPron = "শর্ট",
            bnMeaning = "খাটো / ছোট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_707",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Tall",
            singularBnPron = "টল",
            pluralTarget = "Tall",
            pluralBnPron = "টল",
            bnMeaning = "উঁচু / লম্বা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_708",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Fat",
            singularBnPron = "ফ্যাট",
            pluralTarget = "Fat",
            pluralBnPron = "ফ্যাট",
            bnMeaning = "মোটা / স্থূল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_709",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Thin",
            singularBnPron = "থিন",
            pluralTarget = "Thin",
            pluralBnPron = "থিন",
            bnMeaning = "পাতলা / চিকন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_710",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Fast",
            singularBnPron = "ফাস্ট",
            pluralTarget = "Fast",
            pluralBnPron = "ফাস্ট",
            bnMeaning = "দ্রুত / তেজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_711",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Slow",
            singularBnPron = "স্লো",
            pluralTarget = "Slow",
            pluralBnPron = "স্লো",
            bnMeaning = "ধীর / আস্তে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_712",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Heavy",
            singularBnPron = "হেভি",
            pluralTarget = "Heavy",
            pluralBnPron = "হেভি",
            bnMeaning = "ভারী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_713",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Light",
            singularBnPron = "লাইট",
            pluralTarget = "Light",
            pluralBnPron = "লাইট",
            bnMeaning = "হালকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_714",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Hard",
            singularBnPron = "হার্ড",
            pluralTarget = "Hard",
            pluralBnPron = "হার্ড",
            bnMeaning = "কঠিন / শক্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_715",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Soft",
            singularBnPron = "সফট",
            pluralTarget = "Soft",
            pluralBnPron = "সফট",
            bnMeaning = "নরম / কোমল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_716",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Hot",
            singularBnPron = "হট",
            pluralTarget = "Hot",
            pluralBnPron = "হট",
            bnMeaning = "গরম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_717",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Cold",
            singularBnPron = "কোল্ড",
            pluralTarget = "Cold",
            pluralBnPron = "কোল্ড",
            bnMeaning = "ঠান্ডা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_718",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Warm",
            singularBnPron = "ওয়ার্ম",
            pluralTarget = "Warm",
            pluralBnPron = "ওয়ার্ম",
            bnMeaning = "উষ্ণ / নাতিশীতোষ্ণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_719",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Cool",
            singularBnPron = "কুল",
            pluralTarget = "Cool",
            pluralBnPron = "কুল",
            bnMeaning = "শীতল / স্নিগ্ধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_720",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Clean",
            singularBnPron = "ক্লিন",
            pluralTarget = "Clean",
            pluralBnPron = "ক্লিন",
            bnMeaning = "পরিষ্কার / পরিচ্ছন্ন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_721",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Dirty",
            singularBnPron = "ডার্টি",
            pluralTarget = "Dirty",
            pluralBnPron = "ডার্টি",
            bnMeaning = "নোংরা / অপবিত্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_722",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "New",
            singularBnPron = "নিউ",
            pluralTarget = "New",
            pluralBnPron = "নিউ",
            bnMeaning = "নতুন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_723",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Old",
            singularBnPron = "ওল্ড",
            pluralTarget = "Old",
            pluralBnPron = "ওল্ড",
            bnMeaning = "পুরাতন / পুরনো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_724",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Young",
            singularBnPron = "ইয়াং",
            pluralTarget = "Young",
            pluralBnPron = "ইয়াং",
            bnMeaning = "তরুণ / যুবা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_725",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Beautiful",
            singularBnPron = "বিউটিফুল",
            pluralTarget = "Beautiful",
            pluralBnPron = "বিউটিফুল",
            bnMeaning = "সুন্দর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_726",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Ugly",
            singularBnPron = "আগলি",
            pluralTarget = "Ugly",
            pluralBnPron = "আগলি",
            bnMeaning = "কুৎসিত / বিশ্রী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_727",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Rich",
            singularBnPron = "রিচ",
            pluralTarget = "Rich",
            pluralBnPron = "রিচ",
            bnMeaning = "ধনী / বিত্তবান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_728",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Poor",
            singularBnPron = "পুওর",
            pluralTarget = "Poor",
            pluralBnPron = "পুওর",
            bnMeaning = "গরিব / দরিদ্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_729",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Strong",
            singularBnPron = "স্ট্রং",
            pluralTarget = "Strong",
            pluralBnPron = "স্ট্রং",
            bnMeaning = "শক্তিশালী / বলবান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_730",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Weak",
            singularBnPron = "উইক",
            pluralTarget = "Weak",
            pluralBnPron = "উইক",
            bnMeaning = "দুর্বল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_731",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Sweet",
            singularBnPron = "সুইট",
            pluralTarget = "Sweet",
            pluralBnPron = "সুইট",
            bnMeaning = "মিষ্টি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_732",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Sour",
            singularBnPron = "সাওয়ার",
            pluralTarget = "Sour",
            pluralBnPron = "সাওয়ার",
            bnMeaning = "টক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_733",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Bitter",
            singularBnPron = "বিটার",
            pluralTarget = "Bitter",
            pluralBnPron = "বিটার",
            bnMeaning = "তিতা / তিক্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_734",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Salty",
            singularBnPron = "সল্টি",
            pluralTarget = "Salty",
            pluralBnPron = "সল্টি",
            bnMeaning = "নোনতা / লবণাক্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_735",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Spicy",
            singularBnPron = "স্পাইসি",
            pluralTarget = "Spicy",
            pluralBnPron = "স্পাইসি",
            bnMeaning = "ঝাল / মসলাযুক্ত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_736",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Easy",
            singularBnPron = "ইজি",
            pluralTarget = "Easy",
            pluralBnPron = "ইজি",
            bnMeaning = "সহজ / সরল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_737",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Difficult",
            singularBnPron = "ডিফিকাল্ট",
            pluralTarget = "Difficult",
            pluralBnPron = "ডিফিকাল্ট",
            bnMeaning = "কঠিন / জটিল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_738",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Expensive",
            singularBnPron = "এক্সপেনসিভ",
            pluralTarget = "Expensive",
            pluralBnPron = "এক্সপেনসিভ",
            bnMeaning = "দামি / মূল্যবান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_739",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Cheap",
            singularBnPron = "চীফ",
            pluralTarget = "Cheap",
            pluralBnPron = "চীফ",
            bnMeaning = "সস্তা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_740",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Safe",
            singularBnPron = "সেইফ",
            pluralTarget = "Safe",
            pluralBnPron = "সেইফ",
            bnMeaning = "নিরাপদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_741",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Dangerous",
            singularBnPron = "ডেনজারাস",
            pluralTarget = "Dangerous",
            pluralBnPron = "ডেনজারাস",
            bnMeaning = "বিপজ্জনক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_742",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Bright",
            singularBnPron = "ব্রাইট",
            pluralTarget = "Bright",
            pluralBnPron = "ব্রাইট",
            bnMeaning = "উজ্জ্বল / ফর্সা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_743",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Dark",
            singularBnPron = "ডার্ক",
            pluralTarget = "Dark",
            pluralBnPron = "ডার্ক",
            bnMeaning = "অন্ধকার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_744",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Dry",
            singularBnPron = "ড্রাই",
            pluralTarget = "Dry",
            pluralBnPron = "ড্রাই",
            bnMeaning = "শুকনো / শুষ্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_745",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Wet",
            singularBnPron = "ওয়েট",
            pluralTarget = "Wet",
            pluralBnPron = "ওয়েট",
            bnMeaning = "ভেজা / আর্দ্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_746",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Full",
            singularBnPron = "ফুল",
            pluralTarget = "Full",
            pluralBnPron = "ফুল",
            bnMeaning = "পূর্ণ / ভরা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_747",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Empty",
            singularBnPron = "এম্পটি",
            pluralTarget = "Empty",
            pluralBnPron = "এম্পটি",
            bnMeaning = "খালি / শূন্য",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_748",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "True",
            singularBnPron = "ট্রু",
            pluralTarget = "True",
            pluralBnPron = "ট্রু",
            bnMeaning = "সত্য / সঠিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_749",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "False",
            singularBnPron = "ফলস",
            pluralTarget = "False",
            pluralBnPron = "ফলস",
            bnMeaning = "মিথ্যা / ভুল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_750",
            category = VocabCategory.ADJECTIVES,
            singularTarget = "Important",
            singularBnPron = "ইম্পর্ট্যান্ট",
            pluralTarget = "Important",
            pluralBnPron = "ইম্পর্ট্যান্ট",
            bnMeaning = "গুরুত্বপূর্ণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_751",
            category = VocabCategory.COLORS,
            singularTarget = "Red",
            singularBnPron = "রেড",
            pluralTarget = "Red",
            pluralBnPron = "রেড",
            bnMeaning = "লাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_752",
            category = VocabCategory.COLORS,
            singularTarget = "Blue",
            singularBnPron = "ব্লু",
            pluralTarget = "Blue",
            pluralBnPron = "ব্লু",
            bnMeaning = "নীল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_753",
            category = VocabCategory.COLORS,
            singularTarget = "Green",
            singularBnPron = "গ্রিন",
            pluralTarget = "Green",
            pluralBnPron = "গ্রিন",
            bnMeaning = "সবুজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_754",
            category = VocabCategory.COLORS,
            singularTarget = "Yellow",
            singularBnPron = "ইয়োলো",
            pluralTarget = "Yellow",
            pluralBnPron = "ইয়োলো",
            bnMeaning = "হলুদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_755",
            category = VocabCategory.COLORS,
            singularTarget = "Black",
            singularBnPron = "ব্ল্যাক",
            pluralTarget = "Black",
            pluralBnPron = "ব্ল্যাক",
            bnMeaning = "কালো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_756",
            category = VocabCategory.COLORS,
            singularTarget = "White",
            singularBnPron = "হোয়াইট",
            pluralTarget = "White",
            pluralBnPron = "হোয়াইট",
            bnMeaning = "সাদা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_757",
            category = VocabCategory.COLORS,
            singularTarget = "Orange",
            singularBnPron = "অরেঞ্জ",
            pluralTarget = "Orange",
            pluralBnPron = "অরেঞ্জ",
            bnMeaning = "কমলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_758",
            category = VocabCategory.COLORS,
            singularTarget = "Pink",
            singularBnPron = "পিঙ্ক",
            pluralTarget = "Pink",
            pluralBnPron = "পিঙ্ক",
            bnMeaning = "গোলাপি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_759",
            category = VocabCategory.COLORS,
            singularTarget = "Purple",
            singularBnPron = "পার্পল",
            pluralTarget = "Purple",
            pluralBnPron = "পার্পল",
            bnMeaning = "বেগুনী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_760",
            category = VocabCategory.COLORS,
            singularTarget = "Brown",
            singularBnPron = "ব্রাউন",
            pluralTarget = "Brown",
            pluralBnPron = "ব্রাউন",
            bnMeaning = "বাদামী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_761",
            category = VocabCategory.COLORS,
            singularTarget = "Gray",
            singularBnPron = "গ্রে",
            pluralTarget = "Gray",
            pluralBnPron = "গ্রে",
            bnMeaning = "ধূসর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_762",
            category = VocabCategory.COLORS,
            singularTarget = "Gold",
            singularBnPron = "গোল্ড",
            pluralTarget = "Gold",
            pluralBnPron = "গোল্ড",
            bnMeaning = "সোনালী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_763",
            category = VocabCategory.COLORS,
            singularTarget = "Silver",
            singularBnPron = "সিলভার",
            pluralTarget = "Silver",
            pluralBnPron = "সিলভার",
            bnMeaning = "রুপালী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_764",
            category = VocabCategory.COLORS,
            singularTarget = "Sky blue",
            singularBnPron = "স্কাই ব্লু",
            pluralTarget = "Sky blue",
            pluralBnPron = "স্কাই ব্লু",
            bnMeaning = "আকাশি নীল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_765",
            category = VocabCategory.COLORS,
            singularTarget = "Navy blue",
            singularBnPron = "নেভি ব্লু",
            pluralTarget = "Navy blue",
            pluralBnPron = "নেভি ব্লু",
            bnMeaning = "গাঢ় নীল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_766",
            category = VocabCategory.COLORS,
            singularTarget = "Color",
            singularBnPron = "কালার",
            pluralTarget = "Colors",
            pluralBnPron = "কালার্স",
            bnMeaning = "রং",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_767",
            category = VocabCategory.COLORS,
            singularTarget = "Circle",
            singularBnPron = "সার্কেল",
            pluralTarget = "Circles",
            pluralBnPron = "সার্কেলস",
            bnMeaning = "বৃত্ত / গোলক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_768",
            category = VocabCategory.COLORS,
            singularTarget = "Square",
            singularBnPron = "স্কয়ার",
            pluralTarget = "Squares",
            pluralBnPron = "স্কয়ার্স",
            bnMeaning = "বর্গক্ষেত্র / চৌকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_769",
            category = VocabCategory.COLORS,
            singularTarget = "Triangle",
            singularBnPron = "ট্রায়াঙ্গল",
            pluralTarget = "Triangles",
            pluralBnPron = "ট্রায়াঙ্গলস",
            bnMeaning = "ত্রিভুজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_770",
            category = VocabCategory.COLORS,
            singularTarget = "Rectangle",
            singularBnPron = "রেকট্যাঙ্গেল",
            pluralTarget = "Rectangles",
            pluralBnPron = "রেকট্যাঙ্গেলস",
            bnMeaning = "আয়তক্ষেত্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_771",
            category = VocabCategory.COLORS,
            singularTarget = "Oval",
            singularBnPron = "ওভাল",
            pluralTarget = "Ovals",
            pluralBnPron = "ওভালস",
            bnMeaning = "ডিম্বাকৃতি / ওভাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_772",
            category = VocabCategory.COLORS,
            singularTarget = "Star shape",
            singularBnPron = "স্টার শেইপ",
            pluralTarget = "Star shapes",
            pluralBnPron = "স্টার শেইপস",
            bnMeaning = "তারা আকার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_773",
            category = VocabCategory.COLORS,
            singularTarget = "Heart shape",
            singularBnPron = "হার্ট শেইপ",
            pluralTarget = "Heart shapes",
            pluralBnPron = "হার্ট শেইপস",
            bnMeaning = "হৃদয় আকার / হার্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_774",
            category = VocabCategory.COLORS,
            singularTarget = "Diamond shape",
            singularBnPron = "ডায়মন্ড শেইপ",
            pluralTarget = "Diamond shapes",
            pluralBnPron = "ডায়মন্ড শেইপস",
            bnMeaning = "হীরক আকার / ডায়মন্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_775",
            category = VocabCategory.COLORS,
            singularTarget = "Cube",
            singularBnPron = "কিউব",
            pluralTarget = "Cubes",
            pluralBnPron = "কিউবস",
            bnMeaning = "ঘনক / কিউব",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_776",
            category = VocabCategory.COLORS,
            singularTarget = "Sphere",
            singularBnPron = "স্ফিয়ার",
            pluralTarget = "Spheres",
            pluralBnPron = "স্ফিয়ার্স",
            bnMeaning = "গোলক / স্ফিয়ার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_777",
            category = VocabCategory.COLORS,
            singularTarget = "Cylinder",
            singularBnPron = "সিলিন্ডার",
            pluralTarget = "Cylinders",
            pluralBnPron = "সিলিন্ডার্স",
            bnMeaning = "নলাকার / সিলিন্ডার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_778",
            category = VocabCategory.COLORS,
            singularTarget = "Pyramid",
            singularBnPron = "পিরামিড",
            pluralTarget = "Pyramids",
            pluralBnPron = "পিরামিডস",
            bnMeaning = "পিরামিড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_779",
            category = VocabCategory.COLORS,
            singularTarget = "Line",
            singularBnPron = "লাইন",
            pluralTarget = "Lines",
            pluralBnPron = "লাইনস",
            bnMeaning = "রেখা / লাইন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_780",
            category = VocabCategory.COLORS,
            singularTarget = "Dot",
            singularBnPron = "ডট",
            pluralTarget = "Dots",
            pluralBnPron = "ডটস",
            bnMeaning = "বিন্দু / ডট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_781",
            category = VocabCategory.COLORS,
            singularTarget = "Corner",
            singularBnPron = "কোরনার",
            pluralTarget = "Corners",
            pluralBnPron = "কোরনার্স",
            bnMeaning = "কোণ / কর্নার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_782",
            category = VocabCategory.COLORS,
            singularTarget = "Center",
            singularBnPron = "সেন্টার",
            pluralTarget = "Centers",
            pluralBnPron = "সেন্টার্স",
            bnMeaning = "কেন্দ্র / মধ্যবিন্দু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_783",
            category = VocabCategory.COLORS,
            singularTarget = "Edge",
            singularBnPron = "এজ",
            pluralTarget = "Edges",
            pluralBnPron = "এজেস",
            bnMeaning = "ধার / কিনারা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_784",
            category = VocabCategory.COLORS,
            singularTarget = "Border",
            singularBnPron = "বর্ডার",
            pluralTarget = "Borders",
            pluralBnPron = "বর্ডার্স",
            bnMeaning = "সীমানা / বর্ডার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_785",
            category = VocabCategory.COLORS,
            singularTarget = "Stripe",
            singularBnPron = "স্ট্রাইপ",
            pluralTarget = "Stripes",
            pluralBnPron = "স্ট্রাইপস",
            bnMeaning = "ডোরা / দাগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_786",
            category = VocabCategory.COLORS,
            singularTarget = "Horizontal",
            singularBnPron = "হরাইজন্টাল",
            pluralTarget = "Horizontal",
            pluralBnPron = "হরাইজন্টাল",
            bnMeaning = "আনুভূমিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_787",
            category = VocabCategory.COLORS,
            singularTarget = "Vertical",
            singularBnPron = "ভার্টিক্যাল",
            pluralTarget = "Vertical",
            pluralBnPron = "ভার্টিক্যাল",
            bnMeaning = "উলম্ব / খাড়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_788",
            category = VocabCategory.COLORS,
            singularTarget = "Diagonal",
            singularBnPron = "ডায়াগনাল",
            pluralTarget = "Diagonal",
            pluralBnPron = "ডায়াগনাল",
            bnMeaning = "তির্যক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_789",
            category = VocabCategory.COLORS,
            singularTarget = "Shape",
            singularBnPron = "শেইপ",
            pluralTarget = "Shapes",
            pluralBnPron = "শেইপস",
            bnMeaning = "আকার / আকৃতি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_790",
            category = VocabCategory.COLORS,
            singularTarget = "Size",
            singularBnPron = "সাইজ",
            pluralTarget = "Sizes",
            pluralBnPron = "সাইজেস",
            bnMeaning = "মাপ / সাইজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_791",
            category = VocabCategory.COLORS,
            singularTarget = "Pattern",
            singularBnPron = "প্যাটার্ন",
            pluralTarget = "Patterns",
            pluralBnPron = "প্যাটার্নস",
            bnMeaning = "নকশা / প্যাটার্ন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_792",
            category = VocabCategory.COLORS,
            singularTarget = "Angle",
            singularBnPron = "অ্যাঙ্গেল",
            pluralTarget = "Angles",
            pluralBnPron = "অ্যাঙ্গেলস",
            bnMeaning = "কোণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_793",
            category = VocabCategory.COLORS,
            singularTarget = "Brightness",
            singularBnPron = "ব্রাইটনেস",
            pluralTarget = "Brightness",
            pluralBnPron = "ব্রাইটনেস",
            bnMeaning = "উজ্জ্বলতা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_794",
            category = VocabCategory.COLORS,
            singularTarget = "Transparent",
            singularBnPron = "ট্রান্সপারেন্ট",
            pluralTarget = "Transparent",
            pluralBnPron = "ট্রান্সপারেন্ট",
            bnMeaning = "স্বচ্ছ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_795",
            category = VocabCategory.COLORS,
            singularTarget = "Opaque",
            singularBnPron = "ওপেক",
            pluralTarget = "Opaque",
            pluralBnPron = "ওপেক",
            bnMeaning = "অস্বচ্ছ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_796",
            category = VocabCategory.COLORS,
            singularTarget = "Deep / Dark",
            singularBnPron = "ডিপ",
            pluralTarget = "Deep",
            pluralBnPron = "ডিপ",
            bnMeaning = "গভীর / গাঢ়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_797",
            category = VocabCategory.COLORS,
            singularTarget = "Light / Pale",
            singularBnPron = "লাইট",
            pluralTarget = "Light",
            pluralBnPron = "লাইট",
            bnMeaning = "হালকা / ফিকে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_798",
            category = VocabCategory.COLORS,
            singularTarget = "Shiny",
            singularBnPron = "শাইনি",
            pluralTarget = "Shiny",
            pluralBnPron = "শাইনি",
            bnMeaning = "চকচকে / উজ্জ্বল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_799",
            category = VocabCategory.COLORS,
            singularTarget = "Colorful",
            singularBnPron = "কালারফুল",
            pluralTarget = "Colorful",
            pluralBnPron = "কালারফুল",
            bnMeaning = "রঙিন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_800",
            category = VocabCategory.COLORS,
            singularTarget = "Colorless",
            singularBnPron = "কালারলেস",
            pluralTarget = "Colorless",
            pluralBnPron = "কালারলেস",
            bnMeaning = "রংহীন / বর্ণহীন",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk9 = listOf(
        VocabItem(
            id = "en_vocab_801",
            category = VocabCategory.KITCHEN,
            singularTarget = "Kitchen",
            singularBnPron = "কিচেন",
            pluralTarget = "Kitchens",
            pluralBnPron = "কিচেনস",
            bnMeaning = "রান্নাঘর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_802",
            category = VocabCategory.KITCHEN,
            singularTarget = "Stove",
            singularBnPron = "স্টোভ",
            pluralTarget = "Stoves",
            pluralBnPron = "স্টোভস",
            bnMeaning = "চুলা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_803",
            category = VocabCategory.KITCHEN,
            singularTarget = "Oven",
            singularBnPron = "ওভেন",
            pluralTarget = "Ovens",
            pluralBnPron = "ওভেনস",
            bnMeaning = "ওভেন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_804",
            category = VocabCategory.KITCHEN,
            singularTarget = "Refrigerator",
            singularBnPron = "রেফ্রিজারেটর",
            pluralTarget = "Refrigerators",
            pluralBnPron = "রেফ্রিজারেটরস",
            bnMeaning = "রেফ্রিজারেটর / ফ্রিজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_805",
            category = VocabCategory.KITCHEN,
            singularTarget = "Microwave",
            singularBnPron = "মাইক্রোওয়েভ",
            pluralTarget = "Microwaves",
            pluralBnPron = "মাইক্রোওয়েভস",
            bnMeaning = "মাইক্রোওয়েভ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_806",
            category = VocabCategory.KITCHEN,
            singularTarget = "Blender",
            singularBnPron = "ব্লেন্ডার",
            pluralTarget = "Blenders",
            pluralBnPron = "ব্লেন্ডার্স",
            bnMeaning = "ব্লেন্ডার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_807",
            category = VocabCategory.KITCHEN,
            singularTarget = "Kettle",
            singularBnPron = "কেটলি",
            pluralTarget = "Kettles",
            pluralBnPron = "কেটলিস",
            bnMeaning = "কেটলি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_808",
            category = VocabCategory.KITCHEN,
            singularTarget = "Pot",
            singularBnPron = "পট",
            pluralTarget = "Pots",
            pluralBnPron = "পটস",
            bnMeaning = "রান্নার পাত্র / পাতিল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_809",
            category = VocabCategory.KITCHEN,
            singularTarget = "Pan",
            singularBnPron = "প্যান",
            pluralTarget = "Pans",
            pluralBnPron = "প্যানস",
            bnMeaning = "কড়াই / ফ্রাইপ্যান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_810",
            category = VocabCategory.KITCHEN,
            singularTarget = "Pressure cooker",
            singularBnPron = "প্রেশার কুকার",
            pluralTarget = "Pressure cookers",
            pluralBnPron = "প্রেশার কুকার্স",
            bnMeaning = "প্রেশার কুকার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_811",
            category = VocabCategory.KITCHEN,
            singularTarget = "Knife",
            singularBnPron = "নাইফ",
            pluralTarget = "Knives",
            pluralBnPron = "নাইভস",
            bnMeaning = "ছুরি / চাকু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_812",
            category = VocabCategory.KITCHEN,
            singularTarget = "Spoon",
            singularBnPron = "স্পুন",
            pluralTarget = "Spoons",
            pluralBnPron = "স্পুনস",
            bnMeaning = "চামচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_813",
            category = VocabCategory.KITCHEN,
            singularTarget = "Fork",
            singularBnPron = "ফর্ক",
            pluralTarget = "Forks",
            pluralBnPron = "ফর্কস",
            bnMeaning = "কাঁটা চামচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_814",
            category = VocabCategory.KITCHEN,
            singularTarget = "Teaspoon",
            singularBnPron = "টিস্পুন",
            pluralTarget = "Teaspoons",
            pluralBnPron = "টিস্পুনস",
            bnMeaning = "চা চামচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_815",
            category = VocabCategory.KITCHEN,
            singularTarget = "Chopsticks",
            singularBnPron = "চপস্টিকস",
            pluralTarget = "Chopsticks",
            pluralBnPron = "চপস্টিকস",
            bnMeaning = "চপস্টিক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_816",
            category = VocabCategory.KITCHEN,
            singularTarget = "Plate",
            singularBnPron = "প্লেট",
            pluralTarget = "Plates",
            pluralBnPron = "প্লেটস",
            bnMeaning = "থালা / প্লেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_817",
            category = VocabCategory.KITCHEN,
            singularTarget = "Bowl",
            singularBnPron = "বোল",
            pluralTarget = "Bowls",
            pluralBnPron = "বোলস",
            bnMeaning = "বাটি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_818",
            category = VocabCategory.KITCHEN,
            singularTarget = "Cup",
            singularBnPron = "কাপ",
            pluralTarget = "Cups",
            pluralBnPron = "কাপস",
            bnMeaning = "কাপ / পেয়ালা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_819",
            category = VocabCategory.KITCHEN,
            singularTarget = "Glass",
            singularBnPron = "গ্লাস",
            pluralTarget = "Glasses",
            pluralBnPron = "গ্লাসেস",
            bnMeaning = "কাচের গ্লাস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_820",
            category = VocabCategory.KITCHEN,
            singularTarget = "Mug",
            singularBnPron = "মগ",
            pluralTarget = "Mugs",
            pluralBnPron = "মগস",
            bnMeaning = "মগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_821",
            category = VocabCategory.KITCHEN,
            singularTarget = "Bottle",
            singularBnPron = "বোতল",
            pluralTarget = "Bottles",
            pluralBnPron = "বোতলস",
            bnMeaning = "বোতল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_822",
            category = VocabCategory.KITCHEN,
            singularTarget = "Jug",
            singularBnPron = "জগ",
            pluralTarget = "Jugs",
            pluralBnPron = "জগস",
            bnMeaning = "জগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_823",
            category = VocabCategory.KITCHEN,
            singularTarget = "Tray",
            singularBnPron = "ট্রে",
            pluralTarget = "Trays",
            pluralBnPron = "ট্রেস",
            bnMeaning = "ট্রে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_824",
            category = VocabCategory.KITCHEN,
            singularTarget = "Lid",
            singularBnPron = "লিড",
            pluralTarget = "Lids",
            pluralBnPron = "লিডস",
            bnMeaning = "ঢাকনা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_825",
            category = VocabCategory.KITCHEN,
            singularTarget = "Peeler",
            singularBnPron = "পিলার",
            pluralTarget = "Peelers",
            pluralBnPron = "পিলার্স",
            bnMeaning = "খোসা ছাড়ানোর ছুরি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_826",
            category = VocabCategory.KITCHEN,
            singularTarget = "Grater",
            singularBnPron = "গ্রেটার",
            pluralTarget = "Graters",
            pluralBnPron = "গ্রেটার্স",
            bnMeaning = "গ্রেটার / ঝাঁঝরি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_827",
            category = VocabCategory.KITCHEN,
            singularTarget = "Whisk",
            singularBnPron = "হুইস্ক",
            pluralTarget = "Whisks",
            pluralBnPron = "হুইস্কস",
            bnMeaning = "ডালঘুটনি / হুইস্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_828",
            category = VocabCategory.KITCHEN,
            singularTarget = "Rolling pin",
            singularBnPron = "রোলিং পিন",
            pluralTarget = "Rolling pins",
            pluralBnPron = "রোলিং পিনস",
            bnMeaning = "বেলন (রুটি বেলার)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_829",
            category = VocabCategory.KITCHEN,
            singularTarget = "Strainer",
            singularBnPron = "স্ট্রেইনার",
            pluralTarget = "Strainers",
            pluralBnPron = "স্ট্রেইনার্স",
            bnMeaning = "ছাঁকনি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_830",
            category = VocabCategory.KITCHEN,
            singularTarget = "Cutting board",
            singularBnPron = "কাটিং বোর্ড",
            pluralTarget = "Cutting boards",
            pluralBnPron = "কাটিং বোর্ডস",
            bnMeaning = "চপিং বোর্ড / কাটার বোর্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_831",
            category = VocabCategory.KITCHEN,
            singularTarget = "Apron",
            singularBnPron = "অ্যাপ্রন",
            pluralTarget = "Aprons",
            pluralBnPron = "অ্যাপ্রনস",
            bnMeaning = "অ্যাপ্রন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_832",
            category = VocabCategory.KITCHEN,
            singularTarget = "Dishcloth",
            singularBnPron = "ডিশক্লথ",
            pluralTarget = "Dishcloths",
            pluralBnPron = "ডিশক্লথস",
            bnMeaning = "থালাবাসন মোছার তোয়ালে",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_833",
            category = VocabCategory.KITCHEN,
            singularTarget = "Sponge",
            singularBnPron = "স্পঞ্জ",
            pluralTarget = "Sponges",
            pluralBnPron = "স্পঞ্জেস",
            bnMeaning = "স্পঞ্জ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_834",
            category = VocabCategory.KITCHEN,
            singularTarget = "Dish soap",
            singularBnPron = "ডিশ সোপ",
            pluralTarget = "Dish soap",
            pluralBnPron = "ডিশ সোপ",
            bnMeaning = "থালাবাসন ধোয়ার সাবান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_835",
            category = VocabCategory.KITCHEN,
            singularTarget = "Sink",
            singularBnPron = "সিঙ্ক",
            pluralTarget = "Sinks",
            pluralBnPron = "সিঙ্কস",
            bnMeaning = "সিঙ্ক / বেসিন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_836",
            category = VocabCategory.KITCHEN,
            singularTarget = "Faucet",
            singularBnPron = "ফসেট",
            pluralTarget = "Faucets",
            pluralBnPron = "ফসেটস",
            bnMeaning = "কল / ট্যাপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_837",
            category = VocabCategory.KITCHEN,
            singularTarget = "Matchbox",
            singularBnPron = "ম্যাচবক্স",
            pluralTarget = "Matchboxes",
            pluralBnPron = "ম্যাচবক্সেস",
            bnMeaning = "দেশলাই / ম্যাচ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_838",
            category = VocabCategory.KITCHEN,
            singularTarget = "Lighter",
            singularBnPron = "লাইটার",
            pluralTarget = "Lighters",
            pluralBnPron = "লাইটার্স",
            bnMeaning = "লাইটার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_839",
            category = VocabCategory.KITCHEN,
            singularTarget = "Salt shaker",
            singularBnPron = "সল্ট শেকার",
            pluralTarget = "Salt shakers",
            pluralBnPron = "সল্ট শেকার্স",
            bnMeaning = "লবণদানি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_840",
            category = VocabCategory.KITCHEN,
            singularTarget = "Pepper shaker",
            singularBnPron = "পেপার শেকার",
            pluralTarget = "Pepper shakers",
            pluralBnPron = "পেপার শেকার্স",
            bnMeaning = "গোলমরিচের দানি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_841",
            category = VocabCategory.KITCHEN,
            singularTarget = "Spice jar",
            singularBnPron = "স্পাইস জার",
            pluralTarget = "Spice jars",
            pluralBnPron = "স্পাইস জার্স",
            bnMeaning = "মসলার বৈয়াম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_842",
            category = VocabCategory.KITCHEN,
            singularTarget = "Oil bottle",
            singularBnPron = "অয়েল বটল",
            pluralTarget = "Oil bottles",
            pluralBnPron = "অয়েল বটলস",
            bnMeaning = "তেলের বোতল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_843",
            category = VocabCategory.KITCHEN,
            singularTarget = "Lunchbox",
            singularBnPron = "লাঞ্চবক্স",
            pluralTarget = "Lunchboxes",
            pluralBnPron = "লাঞ্চবক্সেস",
            bnMeaning = "টিফিন বক্স / লাঞ্চ বক্স",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_844",
            category = VocabCategory.KITCHEN,
            singularTarget = "Thermos",
            singularBnPron = "থার্মাস",
            pluralTarget = "Thermoses",
            pluralBnPron = "থার্মাসেস",
            bnMeaning = "থার্মাস / ফ্লাস্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_845",
            category = VocabCategory.KITCHEN,
            singularTarget = "Straw",
            singularBnPron = "স্ট্র",
            pluralTarget = "Straws",
            pluralBnPron = "স্ট্রস",
            bnMeaning = "স্ট্র / নালী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_846",
            category = VocabCategory.KITCHEN,
            singularTarget = "Napkin",
            singularBnPron = "ন্যাপকিন",
            pluralTarget = "Napkins",
            pluralBnPron = "ন্যাপকিনস",
            bnMeaning = "ন্যাপকিন / টিস্যু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_847",
            category = VocabCategory.KITCHEN,
            singularTarget = "Basin",
            singularBnPron = "বেসিন",
            pluralTarget = "Basins",
            pluralBnPron = "বেসিনস",
            bnMeaning = "গামলা / তশতরী",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_848",
            category = VocabCategory.KITCHEN,
            singularTarget = "Can opener",
            singularBnPron = "ক্যান ওপেনার",
            pluralTarget = "Can openers",
            pluralBnPron = "ক্যান ওপেনার্স",
            bnMeaning = "ক্যান ওপেনার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_849",
            category = VocabCategory.KITCHEN,
            singularTarget = "Spatula",
            singularBnPron = "স্প্যাচুলা",
            pluralTarget = "Spatulas",
            pluralBnPron = "স্প্যাচুলাস",
            bnMeaning = "কর্ণধার / করাতল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_850",
            category = VocabCategory.KITCHEN,
            singularTarget = "Funnel",
            singularBnPron = "ফানেল",
            pluralTarget = "Funnels",
            pluralBnPron = "ফানেলস",
            bnMeaning = "ফানেল / চোঙা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_851",
            category = VocabCategory.SHOPPING,
            singularTarget = "Shopping",
            singularBnPron = "শপিং",
            pluralTarget = "Shopping",
            pluralBnPron = "শপিং",
            bnMeaning = "কেনাকাটা / শপিং",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_852",
            category = VocabCategory.SHOPPING,
            singularTarget = "Shopkeeper",
            singularBnPron = "শপকিপার",
            pluralTarget = "Shopkeepers",
            pluralBnPron = "শপকিপার্স",
            bnMeaning = "দোকানদার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_853",
            category = VocabCategory.SHOPPING,
            singularTarget = "Shopping mall",
            singularBnPron = "শপিং মল",
            pluralTarget = "Shopping malls",
            pluralBnPron = "শপিং মলস",
            bnMeaning = "শপিং মল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_854",
            category = VocabCategory.SHOPPING,
            singularTarget = "Money",
            singularBnPron = "মানি",
            pluralTarget = "Money",
            pluralBnPron = "মানি",
            bnMeaning = "টাকা / অর্থ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_855",
            category = VocabCategory.SHOPPING,
            singularTarget = "Coin",
            singularBnPron = "কয়েন",
            pluralTarget = "Coins",
            pluralBnPron = "কয়েনস",
            bnMeaning = "মুদ্রা / কয়েন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_856",
            category = VocabCategory.SHOPPING,
            singularTarget = "Banknote",
            singularBnPron = "ব্যাংকনোট",
            pluralTarget = "Banknotes",
            pluralBnPron = "ব্যাংকনোটস",
            bnMeaning = "নোট / কাগজের টাকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_857",
            category = VocabCategory.SHOPPING,
            singularTarget = "Price",
            singularBnPron = "প্রাইস",
            pluralTarget = "Prices",
            pluralBnPron = "প্রাইসেস",
            bnMeaning = "মূল্য / দাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_858",
            category = VocabCategory.SHOPPING,
            singularTarget = "Cost",
            singularBnPron = "কস্ট",
            pluralTarget = "Costs",
            pluralBnPron = "কস্টস",
            bnMeaning = "খরচ / ব্যয়",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_859",
            category = VocabCategory.SHOPPING,
            singularTarget = "Discount",
            singularBnPron = "ডিসকাউন্ট",
            pluralTarget = "Discounts",
            pluralBnPron = "ডিসকাউন্টস",
            bnMeaning = "মূল্যছাড় / ডিসকাউন্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_860",
            category = VocabCategory.SHOPPING,
            singularTarget = "Sale",
            singularBnPron = "সেল",
            pluralTarget = "Sales",
            pluralBnPron = "সেলস",
            bnMeaning = "বিক্রি / সেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_861",
            category = VocabCategory.SHOPPING,
            singularTarget = "Receipt",
            singularBnPron = "রিসিট",
            pluralTarget = "Receipts",
            pluralBnPron = "রিসিটস",
            bnMeaning = "রশিদ / রিসিট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_862",
            category = VocabCategory.SHOPPING,
            singularTarget = "Bill",
            singularBnPron = "বিল",
            pluralTarget = "Bills",
            pluralBnPron = "বিলস",
            bnMeaning = "বিল / চালান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_863",
            category = VocabCategory.SHOPPING,
            singularTarget = "Cashier",
            singularBnPron = "ক্যাশিয়ার",
            pluralTarget = "Cashiers",
            pluralBnPron = "ক্যাশিয়ার্স",
            bnMeaning = "ক্যাশিয়ার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_864",
            category = VocabCategory.SHOPPING,
            singularTarget = "Shopping bag",
            singularBnPron = "শপিং ব্যাগ",
            pluralTarget = "Shopping bags",
            pluralBnPron = "শপিং ব্যাগস",
            bnMeaning = "বাজারের থলে / ব্যাগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_865",
            category = VocabCategory.SHOPPING,
            singularTarget = "Trolley",
            singularBnPron = "ট্রলি",
            pluralTarget = "Trolleys",
            pluralBnPron = "ট্রলিস",
            bnMeaning = "শপিং ট্রলি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_866",
            category = VocabCategory.SHOPPING,
            singularTarget = "Basket",
            singularBnPron = "বাস্কেট",
            pluralTarget = "Baskets",
            pluralBnPron = "বাস্কেটস",
            bnMeaning = "ঝুড়ি / বাস্কেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_867",
            category = VocabCategory.SHOPPING,
            singularTarget = "Payment",
            singularBnPron = "পেমেন্ট",
            pluralTarget = "Payments",
            pluralBnPron = "পেমেন্টস",
            bnMeaning = "পরিশোধ / পেমেন্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_868",
            category = VocabCategory.SHOPPING,
            singularTarget = "Credit card",
            singularBnPron = "ক্রেডিট কার্ড",
            pluralTarget = "Credit cards",
            pluralBnPron = "ক্রেডিট কার্ডস",
            bnMeaning = "ক্রেডিট কার্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_869",
            category = VocabCategory.SHOPPING,
            singularTarget = "Change",
            singularBnPron = "চেইঞ্জ",
            pluralTarget = "Change",
            pluralBnPron = "চেইঞ্জ",
            bnMeaning = "খুচরা টাকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_870",
            category = VocabCategory.SHOPPING,
            singularTarget = "Debt",
            singularBnPron = "ডেট",
            pluralTarget = "Debts",
            pluralBnPron = "ডেটস",
            bnMeaning = "ঋণ / ধার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_871",
            category = VocabCategory.SHOPPING,
            singularTarget = "Tax",
            singularBnPron = "ট্যাক্স",
            pluralTarget = "Taxes",
            pluralBnPron = "ট্যাক্সেস",
            bnMeaning = "কর / ট্যাক্স",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_872",
            category = VocabCategory.SHOPPING,
            singularTarget = "Bargain",
            singularBnPron = "বারগেইন",
            pluralTarget = "Bargains",
            pluralBnPron = "বারগেইন্স",
            bnMeaning = "দরদাম / দরকষাকষি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_873",
            category = VocabCategory.SHOPPING,
            singularTarget = "Quality",
            singularBnPron = "কোয়ালিটি",
            pluralTarget = "Qualities",
            pluralBnPron = "কোয়ালিটিস",
            bnMeaning = "গুণমান / মান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_874",
            category = VocabCategory.SHOPPING,
            singularTarget = "Quantity",
            singularBnPron = "কোয়ান্টিটি",
            pluralTarget = "Quantities",
            pluralBnPron = "কোয়ান্টিটিস",
            bnMeaning = "পরিমাণ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_875",
            category = VocabCategory.SHOPPING,
            singularTarget = "Brand",
            singularBnPron = "ব্র্যান্ড",
            pluralTarget = "Brands",
            pluralBnPron = "ব্র্যান্ডস",
            bnMeaning = "ব্র্যান্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_876",
            category = VocabCategory.SHOPPING,
            singularTarget = "Warranty",
            singularBnPron = "ওয়ারেন্টি",
            pluralTarget = "Warranties",
            pluralBnPron = "ওয়ারেন্টিস",
            bnMeaning = "ওয়ারেন্টি / গ্যারান্টি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_877",
            category = VocabCategory.SHOPPING,
            singularTarget = "Return",
            singularBnPron = "রিটার্ন",
            pluralTarget = "Returns",
            pluralBnPron = "রিটার্নস",
            bnMeaning = "ফেরত / বদল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_878",
            category = VocabCategory.SHOPPING,
            singularTarget = "Cash counter",
            singularBnPron = "ক্যাশ কাউন্টার",
            pluralTarget = "Cash counters",
            pluralBnPron = "ক্যাশ কাউন্টার্স",
            bnMeaning = "ক্যাশ কাউন্টার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_879",
            category = VocabCategory.SHOPPING,
            singularTarget = "Online shopping",
            singularBnPron = "অনলাইন শপিং",
            pluralTarget = "Online shopping",
            pluralBnPron = "অনলাইন শপিং",
            bnMeaning = "অনলাইন কেনাকাটা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_880",
            category = VocabCategory.SHOPPING,
            singularTarget = "Delivery",
            singularBnPron = "ডেলিভারি",
            pluralTarget = "Deliveries",
            pluralBnPron = "ডেলিভারিস",
            bnMeaning = "হোম ডেলিভারি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_881",
            category = VocabCategory.SHOPPING,
            singularTarget = "Parcel",
            singularBnPron = "পার্সেল",
            pluralTarget = "Parcels",
            pluralBnPron = "পার্সেলস",
            bnMeaning = "প্যাকেট / পার্সেল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_882",
            category = VocabCategory.SHOPPING,
            singularTarget = "Order",
            singularBnPron = "অর্ডার",
            pluralTarget = "Orders",
            pluralBnPron = "অর্ডার্স",
            bnMeaning = "অর্ডার / ফরমাশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_883",
            category = VocabCategory.SHOPPING,
            singularTarget = "Price tag",
            singularBnPron = "প্রাইস ট্যাগ",
            pluralTarget = "Price tags",
            pluralBnPron = "প্রাইস ট্যাগস",
            bnMeaning = "মূল্যতালিকা / দামের ট্যাগ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_884",
            category = VocabCategory.SHOPPING,
            singularTarget = "Currency",
            singularBnPron = "কারেন্সি",
            pluralTarget = "Currencies",
            pluralBnPron = "কারেন্সিস",
            bnMeaning = "মুদ্রা / কারেন্সি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_885",
            category = VocabCategory.SHOPPING,
            singularTarget = "Dollar",
            singularBnPron = "ডলার",
            pluralTarget = "Dollars",
            pluralBnPron = "ডলার্স",
            bnMeaning = "ডলার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_886",
            category = VocabCategory.SHOPPING,
            singularTarget = "Euro",
            singularBnPron = "ইউরো",
            pluralTarget = "Euros",
            pluralBnPron = "ইউরোস",
            bnMeaning = "ইউরো",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_887",
            category = VocabCategory.SHOPPING,
            singularTarget = "Rupee",
            singularBnPron = "রুপি",
            pluralTarget = "Rupees",
            pluralBnPron = "রুপিস",
            bnMeaning = "রুপি / টাকা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_888",
            category = VocabCategory.SHOPPING,
            singularTarget = "Yen",
            singularBnPron = "ইয়েন",
            pluralTarget = "Yen",
            pluralBnPron = "ইয়েন",
            bnMeaning = "ইয়েন (জাপানি মুদ্রা)",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_889",
            category = VocabCategory.SHOPPING,
            singularTarget = "Cash",
            singularBnPron = "ক্যাশ",
            pluralTarget = "Cash",
            pluralBnPron = "ক্যাশ",
            bnMeaning = "নগদ টাকা / ক্যাশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_890",
            category = VocabCategory.SHOPPING,
            singularTarget = "Credit",
            singularBnPron = "ক্রেডিট",
            pluralTarget = "Credits",
            pluralBnPron = "ক্রেডিট",
            bnMeaning = "ক্রেডিট / বাকি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_891",
            category = VocabCategory.SHOPPING,
            singularTarget = "Savings",
            singularBnPron = "সেভিংস",
            pluralTarget = "Savings",
            pluralBnPron = "সেভিংস",
            bnMeaning = "সঞ্চয় / সেভিংস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_892",
            category = VocabCategory.SHOPPING,
            singularTarget = "Profit",
            singularBnPron = "প্রফিট",
            pluralTarget = "Profits",
            pluralBnPron = "প্রফিটস",
            bnMeaning = "লাভ / মুনাফা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_893",
            category = VocabCategory.SHOPPING,
            singularTarget = "Loss",
            singularBnPron = "লস",
            pluralTarget = "Losses",
            pluralBnPron = "লসেস",
            bnMeaning = "ক্ষতি / লোকসান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_894",
            category = VocabCategory.SHOPPING,
            singularTarget = "Advertisement",
            singularBnPron = "অ্যাডভারটাইজমেন্ট",
            pluralTarget = "Advertisements",
            pluralBnPron = "অ্যাডভারটাইজমেন্টস",
            bnMeaning = "বিজ্ঞাপন / অ্যাড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_895",
            category = VocabCategory.SHOPPING,
            singularTarget = "Sample",
            singularBnPron = "স্যাম্পল",
            pluralTarget = "Samples",
            pluralBnPron = "স্যাম্পলস",
            bnMeaning = "নমুনা / স্যাম্পল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_896",
            category = VocabCategory.SHOPPING,
            singularTarget = "Stock",
            singularBnPron = "স্টক",
            pluralTarget = "Stocks",
            pluralBnPron = "স্টকস",
            bnMeaning = "স্টক / মজুত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_897",
            category = VocabCategory.SHOPPING,
            singularTarget = "Seller",
            singularBnPron = "সেলার",
            pluralTarget = "Sellers",
            pluralBnPron = "সেলার্স",
            bnMeaning = "বিক্রেতা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_898",
            category = VocabCategory.SHOPPING,
            singularTarget = "Buyer",
            singularBnPron = "বায়ার",
            pluralTarget = "Buyers",
            pluralBnPron = "বায়ার্স",
            bnMeaning = "ক্রেতা",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_899",
            category = VocabCategory.SHOPPING,
            singularTarget = "Import",
            singularBnPron = "ইমপোর্ট",
            pluralTarget = "Imports",
            pluralBnPron = "ইমপোর্টস",
            bnMeaning = "আমদানি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_900",
            category = VocabCategory.SHOPPING,
            singularTarget = "Export",
            singularBnPron = "এক্সপোর্ট",
            pluralTarget = "Exports",
            pluralBnPron = "এক্সপোর্টস",
            bnMeaning = "রপ্তানি",
            gender = GrammaticalGender.NONE
        ),
    )

    private val chunk10 = listOf(
        VocabItem(
            id = "en_vocab_901",
            category = VocabCategory.TECH,
            singularTarget = "Computer",
            singularBnPron = "কম্পিউটার",
            pluralTarget = "Computers",
            pluralBnPron = "কম্পিউটার্স",
            bnMeaning = "কম্পিউটার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_902",
            category = VocabCategory.TECH,
            singularTarget = "Laptop",
            singularBnPron = "ল্যাপটপ",
            pluralTarget = "Laptops",
            pluralBnPron = "ল্যাপটপস",
            bnMeaning = "ল্যাপটপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_903",
            category = VocabCategory.TECH,
            singularTarget = "Smartphone",
            singularBnPron = "স্মার্টফোন",
            pluralTarget = "Smartphones",
            pluralBnPron = "স্মার্টফোনস",
            bnMeaning = "মোবাইল ফোন / স্মার্টফোন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_904",
            category = VocabCategory.TECH,
            singularTarget = "Tablet",
            singularBnPron = "ট্যাবলেট",
            pluralTarget = "Tablets",
            pluralBnPron = "ট্যাবলেটস",
            bnMeaning = "ট্যাবলেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_905",
            category = VocabCategory.TECH,
            singularTarget = "Screen",
            singularBnPron = "স্ক্রিন",
            pluralTarget = "Screens",
            pluralBnPron = "স্ক্রিনস",
            bnMeaning = "পর্দা / স্ক্রিন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_906",
            category = VocabCategory.TECH,
            singularTarget = "Keyboard",
            singularBnPron = "কীবোর্ড",
            pluralTarget = "Keyboards",
            pluralBnPron = "কীবোর্ডস",
            bnMeaning = "কীবোর্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_907",
            category = VocabCategory.TECH,
            singularTarget = "Mouse",
            singularBnPron = "মাউস",
            pluralTarget = "Mice",
            pluralBnPron = "মাইস",
            bnMeaning = "মাউস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_908",
            category = VocabCategory.TECH,
            singularTarget = "Printer",
            singularBnPron = "প্রিন্টার",
            pluralTarget = "Printers",
            pluralBnPron = "প্রিন্টার্স",
            bnMeaning = "প্রিন্টার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_909",
            category = VocabCategory.TECH,
            singularTarget = "Camera",
            singularBnPron = "ক্যামেরা",
            pluralTarget = "Cameras",
            pluralBnPron = "ক্যামেরাস",
            bnMeaning = "ক্যামেরা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_910",
            category = VocabCategory.TECH,
            singularTarget = "Speaker",
            singularBnPron = "স্পিকার",
            pluralTarget = "Speakers",
            pluralBnPron = "স্পিকার্স",
            bnMeaning = "লাউডস্পিকার / স্পিকার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_911",
            category = VocabCategory.TECH,
            singularTarget = "Headphones",
            singularBnPron = "হেডফোনস",
            pluralTarget = "Headphones",
            pluralBnPron = "হেডফোনস",
            bnMeaning = "হেডফোন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_912",
            category = VocabCategory.TECH,
            singularTarget = "Microphone",
            singularBnPron = "মাইক্রোফোন",
            pluralTarget = "Microphones",
            pluralBnPron = "মাইক্রোফোনস",
            bnMeaning = "মাইক্রোফোন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_913",
            category = VocabCategory.TECH,
            singularTarget = "Charger",
            singularBnPron = "চার্জার",
            pluralTarget = "Chargers",
            pluralBnPron = "চার্জার্স",
            bnMeaning = "চার্জার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_914",
            category = VocabCategory.TECH,
            singularTarget = "Cable",
            singularBnPron = "কেবল",
            pluralTarget = "Cables",
            pluralBnPron = "কেবলস",
            bnMeaning = "তার / কেবল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_915",
            category = VocabCategory.TECH,
            singularTarget = "Battery",
            singularBnPron = "ব্যাটারি",
            pluralTarget = "Batteries",
            pluralBnPron = "ব্যাটারিস",
            bnMeaning = "ব্যাটারি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_916",
            category = VocabCategory.TECH,
            singularTarget = "Power bank",
            singularBnPron = "পাওয়ার ব্যাংক",
            pluralTarget = "Power banks",
            pluralBnPron = "পাওয়ার ব্যাংকস",
            bnMeaning = "পাওয়ার ব্যাংক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_917",
            category = VocabCategory.TECH,
            singularTarget = "Flash drive",
            singularBnPron = "ফ্ল্যাশ ড্রাইভ",
            pluralTarget = "Flash drives",
            pluralBnPron = "ফ্ল্যাশ ড্রাইভস",
            bnMeaning = "পেনড্রাইভ / ইউএসবি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_918",
            category = VocabCategory.TECH,
            singularTarget = "Hard drive",
            singularBnPron = "হার্ড ড্রাইভ",
            pluralTarget = "Hard drives",
            pluralBnPron = "হার্ড ড্রাইভস",
            bnMeaning = "হার্ডডিস্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_919",
            category = VocabCategory.TECH,
            singularTarget = "Wi-Fi",
            singularBnPron = "ওয়াইফাই",
            pluralTarget = "Wi-Fi",
            pluralBnPron = "ওয়াইফাই",
            bnMeaning = "ওয়াইফাই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_920",
            category = VocabCategory.TECH,
            singularTarget = "Internet",
            singularBnPron = "ইন্টারনেট",
            pluralTarget = "Internet",
            pluralBnPron = "ইন্টারনেট",
            bnMeaning = "ইন্টারনেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_921",
            category = VocabCategory.TECH,
            singularTarget = "Network",
            singularBnPron = "নেটওয়ার্ক",
            pluralTarget = "Networks",
            pluralBnPron = "নেটওয়ার্কস",
            bnMeaning = "নেটওয়ার্ক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_922",
            category = VocabCategory.TECH,
            singularTarget = "Website",
            singularBnPron = "ওয়েবসাইট",
            pluralTarget = "Websites",
            pluralBnPron = "ওয়েবসাইটস",
            bnMeaning = "ওয়েবসাইট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_923",
            category = VocabCategory.TECH,
            singularTarget = "Email",
            singularBnPron = "ইমেইল",
            pluralTarget = "Emails",
            pluralBnPron = "ইমেইলস",
            bnMeaning = "ইমেইল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_924",
            category = VocabCategory.TECH,
            singularTarget = "Message",
            singularBnPron = "মেসেজ",
            pluralTarget = "Messages",
            pluralBnPron = "মেসেজেস",
            bnMeaning = "বার্তা / মেসেজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_925",
            category = VocabCategory.TECH,
            singularTarget = "Phone call",
            singularBnPron = "ফোন কল",
            pluralTarget = "Phone calls",
            pluralBnPron = "ফোন কলস",
            bnMeaning = "ফোন কল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_926",
            category = VocabCategory.TECH,
            singularTarget = "Password",
            singularBnPron = "পাসওয়ার্ড",
            pluralTarget = "Passwords",
            pluralBnPron = "পাসওয়ার্ডস",
            bnMeaning = "পাসওয়ার্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_927",
            category = VocabCategory.TECH,
            singularTarget = "Username",
            singularBnPron = "ইউজারনেম",
            pluralTarget = "Usernames",
            pluralBnPron = "ইউজারনেমস",
            bnMeaning = "ব্যবহারকারীর নাম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_928",
            category = VocabCategory.TECH,
            singularTarget = "Account",
            singularBnPron = "অ্যাকাউন্ট",
            pluralTarget = "Accounts",
            pluralBnPron = "অ্যাকাউন্টস",
            bnMeaning = "হিসাব / অ্যাকাউন্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_929",
            category = VocabCategory.TECH,
            singularTarget = "App",
            singularBnPron = "অ্যাপ",
            pluralTarget = "Apps",
            pluralBnPron = "অ্যাপস",
            bnMeaning = "অ্যাপ্লিকেশন / অ্যাপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_930",
            category = VocabCategory.TECH,
            singularTarget = "Software",
            singularBnPron = "সফটওয়্যার",
            pluralTarget = "Software",
            pluralBnPron = "সফটওয়্যার",
            bnMeaning = "সফটওয়্যার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_931",
            category = VocabCategory.TECH,
            singularTarget = "File",
            singularBnPron = "ফাইল",
            pluralTarget = "Files",
            pluralBnPron = "ফাইলস",
            bnMeaning = "নথি / ফাইল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_932",
            category = VocabCategory.TECH,
            singularTarget = "Folder",
            singularBnPron = "ফোল্ডার",
            pluralTarget = "Folders",
            pluralBnPron = "ফোল্ডার্স",
            bnMeaning = "ফোল্ডার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_933",
            category = VocabCategory.TECH,
            singularTarget = "Document",
            singularBnPron = "ডকুমেন্ট",
            pluralTarget = "Documents",
            pluralBnPron = "ডকুমেন্টস",
            bnMeaning = "দলিল / ডকুমেন্ট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_934",
            category = VocabCategory.TECH,
            singularTarget = "Image",
            singularBnPron = "ইমেজ",
            pluralTarget = "Images",
            pluralBnPron = "ইমেজেস",
            bnMeaning = "ছবি / ইমেজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_935",
            category = VocabCategory.TECH,
            singularTarget = "Video",
            singularBnPron = "ভিডিও",
            pluralTarget = "Videos",
            pluralBnPron = "ভিডিওস",
            bnMeaning = "ভিডিও",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_936",
            category = VocabCategory.TECH,
            singularTarget = "Audio",
            singularBnPron = "অডিও",
            pluralTarget = "Audios",
            pluralBnPron = "অডিওস",
            bnMeaning = "অডিও / শব্দ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_937",
            category = VocabCategory.TECH,
            singularTarget = "Link",
            singularBnPron = "লিংক",
            pluralTarget = "Links",
            pluralBnPron = "লিংকস",
            bnMeaning = "সংযোগ / লিংক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_938",
            category = VocabCategory.TECH,
            singularTarget = "Social media",
            singularBnPron = "সোশ্যাল মিডিয়া",
            pluralTarget = "Social media",
            pluralBnPron = "সোশ্যাল মিডিয়া",
            bnMeaning = "সামাজিক যোগাযোগ মাধ্যম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_939",
            category = VocabCategory.TECH,
            singularTarget = "Download",
            singularBnPron = "ডাউনলোড",
            pluralTarget = "Downloads",
            pluralBnPron = "ডাউনলোডস",
            bnMeaning = "ডাউনলোড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_940",
            category = VocabCategory.TECH,
            singularTarget = "Upload",
            singularBnPron = "আপলোড",
            pluralTarget = "Uploads",
            pluralBnPron = "আপলোডস",
            bnMeaning = "আপলোড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_941",
            category = VocabCategory.TECH,
            singularTarget = "Search",
            singularBnPron = "সার্চ",
            pluralTarget = "Searches",
            pluralBnPron = "সার্চেস",
            bnMeaning = "অনুসন্ধান / সার্চ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_942",
            category = VocabCategory.TECH,
            singularTarget = "Click",
            singularBnPron = "ক্লিক",
            pluralTarget = "Clicks",
            pluralBnPron = "ক্লিকস",
            bnMeaning = "ক্লিক করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_943",
            category = VocabCategory.TECH,
            singularTarget = "Save",
            singularBnPron = "সেভ",
            pluralTarget = "Saves",
            pluralBnPron = "সেভস",
            bnMeaning = "সংরক্ষণ / সেভ করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_944",
            category = VocabCategory.TECH,
            singularTarget = "Delete",
            singularBnPron = "ডিলিট",
            pluralTarget = "Deletes",
            pluralBnPron = "ডিলিটস",
            bnMeaning = "মুছে ফেলা / ডিলিট করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_945",
            category = VocabCategory.TECH,
            singularTarget = "Install",
            singularBnPron = "ইনস্টল",
            pluralTarget = "Installs",
            pluralBnPron = "ইনস্টলস",
            bnMeaning = "ইনস্টল করা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_946",
            category = VocabCategory.TECH,
            singularTarget = "Update",
            singularBnPron = "আপডেট",
            pluralTarget = "Updates",
            pluralBnPron = "আপডেটস",
            bnMeaning = "হালনাগাদ / আপডেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_947",
            category = VocabCategory.TECH,
            singularTarget = "Notification",
            singularBnPron = "নোটিফিকেশন",
            pluralTarget = "Notifications",
            pluralBnPron = "নোটিফিকেশনস",
            bnMeaning = "বিজ্ঞপ্তি / নোটিফিকেশন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_948",
            category = VocabCategory.TECH,
            singularTarget = "Settings",
            singularBnPron = "সেটিংস",
            pluralTarget = "Settings",
            pluralBnPron = "সেটিংস",
            bnMeaning = "সেটিংস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_949",
            category = VocabCategory.TECH,
            singularTarget = "Digital",
            singularBnPron = "ডিজিটাল",
            pluralTarget = "Digital",
            pluralBnPron = "ডিজিটাল",
            bnMeaning = "ডিজিটাল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_950",
            category = VocabCategory.TECH,
            singularTarget = "Technology",
            singularBnPron = "টেকনোলজি",
            pluralTarget = "Technologies",
            pluralBnPron = "টেকনোলজিস",
            bnMeaning = "প্রযুক্তি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_951",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Emergency",
            singularBnPron = "ইমার্জেন্সি",
            pluralTarget = "Emergencies",
            pluralBnPron = "ইমার্জেন্সিস",
            bnMeaning = "জরুরি অবস্থা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_952",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Danger",
            singularBnPron = "ডেনজার",
            pluralTarget = "Dangers",
            pluralBnPron = "ডেনজার্স",
            bnMeaning = "বিপদ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_953",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Help",
            singularBnPron = "হেল্প",
            pluralTarget = "Help",
            pluralBnPron = "হেল্প",
            bnMeaning = "সাহায্য / বাঁচাও",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_954",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Police",
            singularBnPron = "পুলিশ",
            pluralTarget = "Police",
            pluralBnPron = "পুলিশ",
            bnMeaning = "পুলিশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_955",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Ambulance",
            singularBnPron = "অ্যাম্বুলেন্স",
            pluralTarget = "Ambulances",
            pluralBnPron = "অ্যাম্বুলেন্সেস",
            bnMeaning = "অ্যাম্বুলেন্স",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_956",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Fire brigade",
            singularBnPron = "ফায়ার ব্রিগেড",
            pluralTarget = "Fire brigades",
            pluralBnPron = "ফায়ার ব্রিগেড্স",
            bnMeaning = "দমকল বাহিনী / ফায়ার সার্ভিস",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_957",
            category = VocabCategory.EMERGENCY,
            singularTarget = "First aid",
            singularBnPron = "ফার্স্ট এইড",
            pluralTarget = "First aid",
            pluralBnPron = "ফার্স্ট এইড",
            bnMeaning = "প্রাথমিক চিকিৎসা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_958",
            category = VocabCategory.EMERGENCY,
            singularTarget = "First aid kit",
            singularBnPron = "ফার্স্ট এইড কিট",
            pluralTarget = "First aid kits",
            pluralBnPron = "ফার্স্ট এইড কিটস",
            bnMeaning = "প্রাথমিক চিকিৎসার বাক্স",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_959",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Bandage",
            singularBnPron = "ব্যান্ডেজ",
            pluralTarget = "Bandages",
            pluralBnPron = "ব্যান্ডেজেস",
            bnMeaning = "ব্যান্ডেজ / পট্টি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_960",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Medicine",
            singularBnPron = "মেডিসিন",
            pluralTarget = "Medicines",
            pluralBnPron = "মেডিসিনস",
            bnMeaning = "ঔষধ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_961",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Painkiller",
            singularBnPron = "পেইনকিলার",
            pluralTarget = "Painkillers",
            pluralBnPron = "পেইনকিলার্স",
            bnMeaning = "ব্যথানাশক",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_962",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Injection",
            singularBnPron = "ইনজেকশন",
            pluralTarget = "Injections",
            pluralBnPron = "ইনজেকশনস",
            bnMeaning = "ইনজেকশন / সুঁই",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_963",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Thermometer",
            singularBnPron = "থার্মোমিটার",
            pluralTarget = "Thermometers",
            pluralBnPron = "থার্মোমিটার্স",
            bnMeaning = "থার্মোমিটার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_964",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Patient",
            singularBnPron = "পেশেন্ট",
            pluralTarget = "Patients",
            pluralBnPron = "পেশেন্টস",
            bnMeaning = "রোগী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_965",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Disease",
            singularBnPron = "ডিজিজ",
            pluralTarget = "Diseases",
            pluralBnPron = "ডিজিজেস",
            bnMeaning = "রোগ / ব্যাধি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_966",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Pain",
            singularBnPron = "পেইন",
            pluralTarget = "Pains",
            pluralBnPron = "পেইনস",
            bnMeaning = "ব্যথা / বেদনা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_967",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Fever",
            singularBnPron = "ফিভার",
            pluralTarget = "Fevers",
            pluralBnPron = "ফিভার্স",
            bnMeaning = "জ্বর",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_968",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Cough",
            singularBnPron = "কফ",
            pluralTarget = "Coughs",
            pluralBnPron = "কফস",
            bnMeaning = "কাশি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_969",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Flu",
            singularBnPron = "ফ্লু",
            pluralTarget = "Flus",
            pluralBnPron = "ফ্লুস",
            bnMeaning = "সর্দি / ফ্লু",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_970",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Headache",
            singularBnPron = "হেডেক",
            pluralTarget = "Headaches",
            pluralBnPron = "হেডেকস",
            bnMeaning = "মাথাব্যথা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_971",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Stomach ache",
            singularBnPron = "স্টমাক এক",
            pluralTarget = "Stomach aches",
            pluralBnPron = "স্টমাক একস",
            bnMeaning = "পেটব্যথা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_972",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Wound",
            singularBnPron = "উন্ড",
            pluralTarget = "Wounds",
            pluralBnPron = "উন্ডস",
            bnMeaning = "ক্ষত / ঘা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_973",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Burn",
            singularBnPron = "বার্ন",
            pluralTarget = "Burns",
            pluralBnPron = "বার্নস",
            bnMeaning = "পোড়া / দগ্ধ হওয়া",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_974",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Bleeding",
            singularBnPron = "ব্লিডিং",
            pluralTarget = "Bleeding",
            pluralBnPron = "ব্লিডিং",
            bnMeaning = "রক্তপাত",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_975",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Fracture",
            singularBnPron = "ফ্র্যাকচার",
            pluralTarget = "Fractures",
            pluralBnPron = "ফ্র্যাকচার্স",
            bnMeaning = "হাড়ভাঙা / ফ্র্যাকচার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_976",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Allergy",
            singularBnPron = "অ্যালার্জি",
            pluralTarget = "Allergies",
            pluralBnPron = "অ্যালার্জিস",
            bnMeaning = "অ্যালার্জি",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_977",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Poison",
            singularBnPron = "পয়জন",
            pluralTarget = "Poisons",
            pluralBnPron = "পয়জনস",
            bnMeaning = "বিষ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_978",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Accident",
            singularBnPron = "অ্যাকসিডেন্ট",
            pluralTarget = "Accidents",
            pluralBnPron = "অ্যাকসিডেন্টস",
            bnMeaning = "দুর্ঘটনা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_979",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Fire outbreak",
            singularBnPron = "ফায়ার",
            pluralTarget = "Fires",
            pluralBnPron = "ফায়ার্স",
            bnMeaning = "অগ্নিকাণ্ড",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_980",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Flood",
            singularBnPron = "ফ্লাড",
            pluralTarget = "Floods",
            pluralBnPron = "ফ্লাডস",
            bnMeaning = "বন্যা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_981",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Earthquake",
            singularBnPron = "আর্থকোয়েক",
            pluralTarget = "Earthquakes",
            pluralBnPron = "আর্থকোয়েকস",
            bnMeaning = "ভূমিকম্প",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_982",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Cyclone",
            singularBnPron = "সাইক্লোন",
            pluralTarget = "Cyclones",
            pluralBnPron = "সাইক্লোনস",
            bnMeaning = "ঘূর্ণিঝড় / সাইক্লোন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_983",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Emergency exit",
            singularBnPron = "ইমার্জেন্সি এক্সিট",
            pluralTarget = "Emergency exits",
            pluralBnPron = "ইমার্জেন্সি এক্সিটস",
            bnMeaning = "জরুরি প্রস্থান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_984",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Fire extinguisher",
            singularBnPron = "ফায়ার এক্সটিংগুইশার",
            pluralTarget = "Fire extinguishers",
            pluralBnPron = "ফায়ার এক্সটিংগুইশার্স",
            bnMeaning = "অগ্নিনির্বাপক যন্ত্র",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_985",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Warning",
            singularBnPron = "ওয়ার্নিং",
            pluralTarget = "Warnings",
            pluralBnPron = "ওয়ার্নিংস",
            bnMeaning = "সতর্কবার্তা / ওয়ার্নিং",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_986",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Alarm",
            singularBnPron = "অ্যালার্ম",
            pluralTarget = "Alarms",
            pluralBnPron = "অ্যালার্মস",
            bnMeaning = "বিপদ সংকেত / অ্যালার্ম",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_987",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Siren",
            singularBnPron = "সাইরেন",
            pluralTarget = "Sirens",
            pluralBnPron = "সাইরেনস",
            bnMeaning = "সাইরেন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_988",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Security guard",
            singularBnPron = "সিকিউরিটি গার্ড",
            pluralTarget = "Security guards",
            pluralBnPron = "সিকিউরিটি গার্ডস",
            bnMeaning = "নিরাপত্তারক্ষী",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_989",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Safety",
            singularBnPron = "সেইফটি",
            pluralTarget = "Safety",
            pluralBnPron = "সেইফটি",
            bnMeaning = "নিরাপত্তা",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_990",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Life jacket",
            singularBnPron = "লাইফ জ্যাকেট",
            pluralTarget = "Life jackets",
            pluralBnPron = "লাইফ জ্যাকেটস",
            bnMeaning = "লাইফ জ্যাকেট",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_991",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Rescue team",
            singularBnPron = "রেসকিউ টিম",
            pluralTarget = "Rescue teams",
            pluralBnPron = "রেসকিউ টিমস",
            bnMeaning = "উদ্ধারকারী দল",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_992",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Shelter",
            singularBnPron = "শেল্টার",
            pluralTarget = "Shelters",
            pluralBnPron = "শেল্টার্স",
            bnMeaning = "আশ্রয়স্থল / শেল্টার",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_993",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Insurance",
            singularBnPron = "ইন্স্যুরেন্স",
            pluralTarget = "Insurances",
            pluralBnPron = "ইন্স্যুরেন্সেস",
            bnMeaning = "বীমা / ইন্স্যুরেন্স",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_994",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Emergency number",
            singularBnPron = "ইমার্জেন্সি নাম্বার",
            pluralTarget = "Emergency numbers",
            pluralBnPron = "ইমার্জেন্সি নাম্বার্স",
            bnMeaning = "জরুরি নম্বর / হটলাইন",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_995",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Lost / Missing",
            singularBnPron = "লস্ট",
            pluralTarget = "Lost",
            pluralBnPron = "লস্ট",
            bnMeaning = "হারিয়ে যাওয়া / নিখোঁজ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_996",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Corpse",
            singularBnPron = "কর্পস",
            pluralTarget = "Corpses",
            pluralBnPron = "কর্পসেস",
            bnMeaning = "মৃতদেহ / লাশ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_997",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Survivor",
            singularBnPron = "সারভাইভার",
            pluralTarget = "Survivors",
            pluralBnPron = "সারভাইভার্স",
            bnMeaning = "জীবিত / সারভাইভার",
            gender = GrammaticalGender.COMMON
        ),
        VocabItem(
            id = "en_vocab_998",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Debris / Ruins",
            singularBnPron = "ডেব্রিস",
            pluralTarget = "Debris",
            pluralBnPron = "ডেব্রিস",
            bnMeaning = "ধ্বংসাবশেষ / ধ্বংসস্তূপ",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_999",
            category = VocabCategory.EMERGENCY,
            singularTarget = "Evacuation",
            singularBnPron = "ইভাকুয়েশন",
            pluralTarget = "Evacuations",
            pluralBnPron = "ইভাকুয়েশনস",
            bnMeaning = "নিরাপদ প্রস্থান",
            gender = GrammaticalGender.NONE
        ),
        VocabItem(
            id = "en_vocab_1000",
            category = VocabCategory.EMERGENCY,
            singularTarget = "SOS / Distress call",
            singularBnPron = "এসওএস",
            pluralTarget = "Distress calls",
            pluralBnPron = "এসওএস",
            bnMeaning = "জরুরি সংকেত / এসওএস",
            gender = GrammaticalGender.NONE
        ),
    )

    val config = VocabLanguageConfig(
        langCode = "en",
        speechLang = SpeechLang.EN,
        titleBn = "ইংরেজি শব্দভাণ্ডার",
        subtitleBn = "১,০০০টি দৈনন্দিন প্রয়োজনীয় ইংরেজি শব্দ (একবচন ও বহুবচন সহ)",
        nativeTitle = "English Vocabulary Vault",
        accentColorHex = 0xFF1976D2,
        items = chunk1 + chunk2 + chunk3 + chunk4 + chunk5 + chunk6 + chunk7 + chunk8 + chunk9 + chunk10
    )
}
