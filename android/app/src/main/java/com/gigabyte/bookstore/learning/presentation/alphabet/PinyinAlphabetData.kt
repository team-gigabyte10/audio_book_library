package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object PinyinAlphabetData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "chinese",
        speechLang = SpeechLang.ZH,
        titleBn = "চাইনিজ পিনইন ও ৪টি সুর চার্ট (Pinyin & Tones)",
        subtitleBn = "২৩টি ইনিশিয়াল, গুরুত্বপূর্ণ ফাইনাল ও ৪টি টোন · ট্যাপ করলেই ম্যান্ডারিন অডিও",
        accentColorHex = 0xFFD32F2F,
        categories = listOf(
            AlphabetCategory("all", "সবগুলো", "৪২টি"),
            AlphabetCategory("tones", "৪টি সুর (Tones)", "৫টি"),
            AlphabetCategory("initials", "ব্যঞ্জন ধ্বনি (Initials)", "২৩টি"),
            AlphabetCategory("finals", "স্বর ধ্বনি (Finals)", "১৪টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "zh_tones",
                titleBn = "৪টি ম্যান্ডারিন সুর + নিউট্রাল টোন (সবচেয়ে জরুরি)",
                subtitleTarget = "mā (১ম) · má (২য়) · mǎ (৩য়) · mà (৪র্থ) · ma (হালকা)",
                categoryId = "tones",
                letters = listOf(
                    AlphabetLetter("zh_t1", "mā 妈", "1st Tone (ˉ)", "mā", "মা— (উঁচু সমতল)", "tones", "妈", "妈妈", "māma", "মা", "একটানা উঁচু ও সমতল সুরে টানুন (যেমন: মা—)।"),
                    AlphabetLetter("zh_t2", "má 麻", "2nd Tone (ˊ)", "má", "মা? (নিচ থেকে উপরে)", "tones", "麻", "麻烦", "máfan", "ঝামেলা", "বাংলায় অবাক হয়ে 'হুঁ?' বলার মতো নিচ থেকে উপরে উঠান।"),
                    AlphabetLetter("zh_t3", "mǎ 马", "3rd Tone (ˇ)", "mǎ", "মাআ (নিচে নেমে ওঠা)", "tones", "马", "你好", "nǐ hǎo", "হ্যালো", "কণ্ঠ নিচে নামিয়ে তারপর হালকা উপরে তুলুন।"),
                    AlphabetLetter("zh_t4", "mà 骂", "4th Tone (ˋ)", "mà", "মা! (জোরে নিচে নামা)", "tones", "骂", "谢谢", "xièxie", "ধন্যবাদ", "উপর থেকে হঠাৎ দৃঢ়ভাবে নিচে নামিয়ে উচ্চারণ করুন।"),
                    AlphabetLetter("zh_t5", "ma 吗", "Neutral (হালকা)", "ma", "মা (সংক্ষিপ্ত)", "tones", "吗", "好吗", "hǎo ma", "ভালো কি?", "খুব হালকা ও ছোট করে সুর ছাড়া উচ্চারণ।")
                )
            ),
            AlphabetRow(
                id = "zh_init_1",
                titleBn = "ইনিশিয়াল সারি ১: ঠোঁট ও জিহ্বার ডগা (b p m f d t n l)",
                subtitleTarget = "b · p · m · f · d · t · n · l",
                categoryId = "initials",
                letters = listOf(
                    AlphabetLetter("zh_b", "b", "b (প/ব)", "bo", "পো (বাতাসহীন)", "initials", "波", "爸爸", "bàba", "বাবা", "বাতাস ছাড়া নরম 'প'-এর মতো।"),
                    AlphabetLetter("zh_p", "p", "p (ফ)", "po", "ফো (ফুঁ সহ)", "initials", "坡", "朋友", "péngyou", "বন্ধু", "মুখ থেকে জোরালো বাতাস ছেড়ে 'ফ/প্‌হ' বলুন।"),
                    AlphabetLetter("zh_m", "m", "m (ম)", "mo", "মো", "initials", "摸", "妈妈", "māma", "মা"),
                    AlphabetLetter("zh_f", "f", "f (ফ)", "fo", "ফো", "initials", "佛", "饭", "fàn", "ভাত/খাবার"),
                    AlphabetLetter("zh_d", "d", "d (ত)", "de", "ত্য (বাতাসহীন)", "initials", "得", "大", "dà", "বড়", "বাতাস ছাড়া শক্ত 'ত'-এর মতো (দ নয়)।"),
                    AlphabetLetter("zh_t", "t", "t (থ)", "te", "থ্য (ফুঁ সহ)", "initials", "特", "他", "tā", "সে", "বাতাস ছেড়ে পরিষ্কার 'থ' ধ্বনি।"),
                    AlphabetLetter("zh_n", "n", "n (ন)", "ne", "ন্য", "initials", "呢", "你", "nǐ", "তুমি"),
                    AlphabetLetter("zh_l", "l", "l (ল)", "le", "ল্য", "initials", "了", "来", "lái", "আসা")
                )
            ),
            AlphabetRow(
                id = "zh_init_2",
                titleBn = "ইনিশিয়াল সারি ২: কণ্ঠনালী ও তালব্য (g k h j q x)",
                subtitleTarget = "g · k · h · j · q · x",
                categoryId = "initials",
                letters = listOf(
                    AlphabetLetter("zh_g", "g", "g (ক)", "ge", "ক্য (বাতাসহীন)", "initials", "哥", "哥哥", "gēge", "বড় ভাই", "বাতাস ছাড়া নরম 'ক'-এর মতো (গ নয়)।"),
                    AlphabetLetter("zh_k", "k", "k (খ)", "ke", "খ্য (ফুঁ সহ)", "initials", "可", "看", "kàn", "দেখা", "গলা থেকে বাতাস ছেড়ে 'খ'।"),
                    AlphabetLetter("zh_h", "h", "h (হ/খ)", "he", "হ্য/খ্য", "initials", "喝", "喝水", "hē shuǐ", "পানি খাওয়া", "হালকা গলায় ঘষে 'হ/খ' মাঝামাঝি।"),
                    AlphabetLetter("zh_j", "j", "j (চ/জ)", "ji", "চি (নরম)", "initials", "鸡", "今天", "jīntiān", "আজকে", "জিহ্বা সমতল রেখে নরম 'চি'।"),
                    AlphabetLetter("zh_q", "q", "q (ছ)", "qi", "ছি (তীক্ষ্ণ ফুঁ)", "initials", "七", "请问", "qǐngwèn", "দয়া করে বলুন", "দাঁতের পেছনে জিহ্বা রেখে বাতাসসহ তীক্ষ্ণ 'ছি'।"),
                    AlphabetLetter("zh_x", "x", "x (সি)", "xi", "সি (কোমল শিস)", "initials", "西", "谢谢", "xièxie", "ধন্যবাদ", "হাসিমুখে নরম 'স্+শ' একসাথে 'সি'।")
                )
            ),
            AlphabetRow(
                id = "zh_init_3",
                titleBn = "ইনিশিয়াল সারি ৩: জিহ্বা উল্টে ও দন্ত্য (zh ch sh r z c s y w)",
                subtitleTarget = "zh · ch · sh · r · z · c · s · y · w",
                categoryId = "initials",
                letters = listOf(
                    AlphabetLetter("zh_zh", "zh", "zh (চ/জ)", "zhi", "চ্যি (জিহ্বা উল্টে)", "initials", "知", "中国", "Zhōngguó", "চীন"),
                    AlphabetLetter("zh_ch", "ch", "ch (ছ)", "chi", "ছ্যি (ফুঁ সহ)", "initials", "吃", "吃饭", "chīfàn", "ভাত খাওয়া"),
                    AlphabetLetter("zh_sh", "sh", "sh (শ)", "shi", "শ্যি (মোটা)", "initials", "是", "老师", "lǎoshī", "শিক্ষক"),
                    AlphabetLetter("zh_r", "r", "r (র/ঝ)", "ri", "র্যি", "initials", "日", "人", "rén", "মানুষ"),
                    AlphabetLetter("zh_z", "z", "z (দ্জ)", "zi", "দ্জ্য", "initials", "字", "再见", "zàijiàn", "বিদায়"),
                    AlphabetLetter("zh_c", "c", "c (ৎস)", "ci", "ৎস্য", "initials", "次", "菜", "cài", "তরকারি"),
                    AlphabetLetter("zh_s", "s", "s (স)", "si", "স্য", "initials", "四", "三", "sān", "তিন"),
                    AlphabetLetter("zh_y", "y", "y (ইয়)", "yi", "ই", "initials", "一", "医院", "yīyuàn", "হাসপাতাল"),
                    AlphabetLetter("zh_w", "w", "w (ওয়)", "wu", "উ", "initials", "五", "我", "wǒ", "আমি")
                )
            ),
            AlphabetRow(
                id = "zh_finals",
                titleBn = "মূল স্বর ও যৌগিক ফাইনাল (Vowels & Finals)",
                subtitleTarget = "a · o · e · i · u · ü · ai · ei · ao · ou · an · en · ang · eng",
                categoryId = "finals",
                letters = listOf(
                    AlphabetLetter("zh_fa", "a", "a (আ)", "a", "আ", "finals", "啊", "八", "bā", "আট"),
                    AlphabetLetter("zh_fo", "o", "o (ও)", "o", "ও/উও", "finals", "喔", "我", "wǒ", "আমি"),
                    AlphabetLetter("zh_fe", "e", "e (এ/আ)", "e", "আ/অ্যা", "finals", "鹅", "喝", "hē", "পান করা"),
                    AlphabetLetter("zh_fi", "i", "i (ই)", "yi", "ই", "finals", "衣", "一", "yī", "এক"),
                    AlphabetLetter("zh_fu", "u", "u (উ)", "wu", "উ", "finals", "乌", "五", "wǔ", "পাঁচ"),
                    AlphabetLetter("zh_fv", "ü", "ü (ইউ)", "yu", "ইউ (ঠোঁট গোল)", "finals", "鱼", "女", "nǚ", "নারী", "ঠোঁট 'উ'-এর মতো গোল করে 'ই' উচ্চারণ করুন।"),
                    AlphabetLetter("zh_fai", "ai", "ai (আই)", "ai", "আই", "finals", "爱", "买", "mǎi", "কেনা"),
                    AlphabetLetter("zh_fei", "ei", "ei (এই)", "ei", "এই", "finals", "杯", "水杯", "shuǐbēi", "পানির গ্লাস"),
                    AlphabetLetter("zh_fao", "ao", "ao (আও)", "ao", "আও", "finals", "好", "很好", "hěn hǎo", "খুব ভালো"),
                    AlphabetLetter("zh_fou", "ou", "ou (ওউ)", "ou", "ওউ", "finals", "口", "走", "zǒu", "হাঁটা"),
                    AlphabetLetter("zh_fan", "an", "an (আন্)", "an", "আন্", "finals", "安", "看", "kàn", "দেখা"),
                    AlphabetLetter("zh_fen", "en", "en (এন্)", "en", "এন্", "finals", "门", "人", "rén", "মানুষ"),
                    AlphabetLetter("zh_fang", "ang", "ang (আং)", "ang", "আং", "finals", "忙", "帮忙", "bāngmáng", "সাহায্য"),
                    AlphabetLetter("zh_feng", "eng", "eng (এং)", "eng", "এং", "finals", "风", "朋友", "péngyou", "বন্ধু")
                )
            )
        )
    )
}
