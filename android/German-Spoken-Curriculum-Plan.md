# Spoken German Curriculum Plan: Zero to Advanced (for Bangla Speakers)

This plan is for a comprehensive spoken German course (**জার্মান স্পোকেন কোর্স: শূন্য থেকে অ্যাডভান্সড**). The base language of instruction and explanation is Bangla. The plan covers the complete curriculum framework (levels, units, lesson design, assessment, and phonetic methodology) as well as the Android app integration (`com.gigabyte.bookstore.learning`). It does not alter the existing English, Japanese, Urdu, or Hindi courses (see section 9).

German follows the **CEFR** framework (**Pre-A1 Stage 0 → A1 → A2 → B1 → B2 → C1 → C2 + Specialist Tracks**), strictly aligned with **Goethe-Institut**, **telc**, and **ÖSD** spoken examination standards.

---

## 1. Principles

1. **Speaking first (Mündliche Kommunikation).** Every lesson ends with the learner speaking aloud. Reading Latin script supports speaking; grammar exists to serve oral communication, not academic memorization.
2. **Leverage what Bangla already gives:**
   - **SOV Subordinate Clause Match (Verb-am-Ende):** While main clauses in German follow the **V2 rule** (finite verb in position 2), subordinate clauses introduced by *weil, dass, wenn, ob, als* send the conjugated verb to the **end of the sentence**—which exactly mirrors Bangla sentence structure!
     - *Bangla:* "...কারণ আমি জার্মান ভাষা **শিখছি**।"
     - *German:* "...weil ich Deutsch **lerne**."
   - **Respect Tiers (Sie vs du / ihr):** German distinguishes polite formal address (*Sie* + plural verb) from informal personal address (*du* singular, *ihr* plural). This corresponds 1-to-1 to Bangla:
     - *Sie* = আপনি / আপনারা
     - *du* = তুমি / তুই
     - *ihr* = তোমরা / তোরা
   - **Case Roles in Bangla & German:** Bangla case markers map naturally to German cases:
     - Nominativ (কে / কারা - Subject)
     - Akkusativ (কাকে / কি - Direct Object, Bangla 'কে')
     - Dativ (কার জন্য / কাকে - Indirect Object / Location, Bangla 'কে / তে / -এ')
     - Genitiv (কার - Possession, Bangla '-র / -এর')
3. **Fix the hard points for Bangla speakers early:**
   - **The 3 Umlauts (`ä, ö, ü`) & `ß` (Eszett):**
     - `ä` = open 'অ্যা' (like 'apple' / Bangla 'ম্যাঁ').
     - `ö` = round lips for 'ও' while trying to pronounce 'এ' (no equivalent in Bangla; distinct from 'ও').
     - `ü` = round lips for 'উ' while trying to pronounce 'ই' (distinct from plain 'উ').
     - `ß` = sharp unvoiced 'স' (never voiced 'জ').
   - **Consonant Pair Traps:**
     - `w` is pronounced like English 'v' / Bangla 'ভ' (*Wasser* = ভাসার).
     - `v` is pronounced like 'f' / Bangla 'ফ' (*Vater* = ফাটার, *Vogel* = ফোগেল).
     - `z` is always pronounced 'ts' / Bangla 'ৎস' (*Zeit* = ৎস্সাইট, *Zimmer* = ৎসিমা).
     - `sp` and `st` at the start of a syllable become 'shp / sht' / Bangla 'শ্প / শ্ট' (*Sport* = শ্পোর্ট, *Stadt* = শ্টাট).
     - `ch` has two distinct sounds: **ach-Laut** (guttural 'খ়' after a, o, u: *Buch, Bach*) vs **ich-Laut** (soft hissing 'হ্ইয়' after e, i, ä, ö, ü: *ich, nicht, sprechen*).
     - `r` is a uvular throat sound or vocalic '-আ' at the end of syllables (*der* = দেআ, *Mutter* = মুটা).
   - **Three Genders (*der, die, das*):** Every German noun is masculine (*der*), feminine (*die*), or neuter (*das*). Because Bangla has zero grammatical gender, every noun must be learned with its article and color-coded.
   - **Separable Verbs (*Trennbare Verben*):** Prefixes split to the end of main clauses (*aufstehen* → *Ich stehe um 7 Uhr auf*).
   - **Spoken Past (Perfekt with *haben* vs *sein*):** Everyday spoken German uses *Perfekt* (*Ich habe gemacht*, *Ich bin gegangen*) rather than written *Präteritum*.
4. **Phonetic Bridge (`bn_pron`):** High-precision Bangla phonetic representations guide sound production in Stage 0 and A1, explicitly marking umlauts (`ö` = `[এ+ও]`, `ü` = `[ই+উ]`) and silent/vocalic endings.
5. **Real-Life Bangladeshi Learner Context:** Scenarios directly reflect the goals of Bangladeshi students and professionals:
   - German University Admissions (TU9, Blocked Account, APS, Uni-Assist).
   - *Ausbildung* (Vocational training in Nursing/Pflege, IT, Mechatronics, Hospitality).
   - *Chancenkarte* (Opportunity Card / Job Seeker Visa).
   - Daily life in Germany (*Anmeldung* at Bürgeramt, WG Zimmer hunting, Supermarket, Deutsche Bahn, Krankenkasse, Doctor).
6. **On-Device Audio & Native Review:** High-fidelity offline TTS (`de-DE`) with ladder repetition speeds (`0.8x → 1.15x bn → 0.9x → 1.0x → 1200ms pause`), backed by native German review before production release.

---

## 2. Level Framework

| Level | CEFR | Active Words | Core Grammar Points | Guided Hours | Units / Lessons | Speaking Exam Target |
|---|---|---|---|---|---|---|
| **Stage 0** | Pre-A1 | ~250 | ~10 | 25–35 | 10 units / 45 lessons | Clear pronunciation, alphabet, umlauts, numbers, survival basics |
| **A1** | A1 | ~850 | ~35 | 70–90 | 15 units / 60 lessons | **Goethe-Zertifikat A1: Start Deutsch 1** (Sprechen) |
| **A2** | A2 | ~1,600 | ~35 | 100–120 | 15 units / 60 lessons | **Goethe-Zertifikat A2** / telc A2 (Sprechen) |
| **B1** | B1 | ~2,700 | ~40 | 150–180 | 16 units / 70 lessons | **Goethe-Zertifikat B1** (Required for Ausbildung & Visa) |
| **B2** | B2 | ~4,200 | ~40 | 200–240 | 16 units / 70 lessons | **Goethe-Zertifikat B2** / telc B2 (Nursing, Jobs & University) |
| **C1** | C1 | ~6,500 | ~35 | 250–300 | 16 units / 70 lessons | **TestDaF / DSH / Goethe C1** (Direct University Study) |
| **Advanced** | C2 + Tracks | 8,500+ | — | per track | 7 tracks × 10–20 lessons | Professional mastery, interpreting & specialist domains |

### Speaking Goal per Level (Can-Do)

| Level | The learner can… |
|---|---|
| **Stage 0** | Pronounce the German alphabet, umlauts (`ä, ö, ü`), `ß`, `ch`, and `z` accurately. Introduce themselves, spell their name, count to 100, and use basic greetings with correct *Sie / du* etiquette. |
| **A1** | Ask and answer simple questions about personal details, home, family, shopping, food, and daily routines. Order in restaurants, buy train tickets, make simple appointments, and describe actions in the present and spoken past (*Perfekt*). |
| **A2** | Describe past events, work experiences, and future plans. Communicate in routine situations: doctor visits, apartment hunting (*WG-Zimmer*), city navigation, workplace tasks, and expressing wishes using modal verbs and reflexive verbs. |
| **B1** | Connect phrases to express opinions, explain reasons (*weil, deshalb*), narrate stories, handle unexpected travel/visa problems, participate in job interviews for *Ausbildung*, and deliver a 3-minute presentation on everyday topics. |
| **B2** | Communicate spontaneously and fluently with native speakers in professional and academic settings. Defend viewpoints, analyze pros and cons, participate in corporate meetings, handle clinical/technical discussions, and follow native broadcasts. |
| **C1** | Express ideas fluently, spontaneously, and flexibly without obvious searching for words. Use language flexibly for social, academic, and professional purposes. Formulate complex ideas with clear structure, connectors, and idiomatic style. |
| **C2 / Tracks** | Flawless command across specialized tracks: Healthcare/Pflege German, German Technical University & APS, Chancenkarte job interviews, engineering/IT, and consecutive interpreting (Bangla ↔ German). |

---

## 3. Curriculum Sequence

### Stage 0 — Zero Start (Pre-A1): Phonetics, Script, Umlauts & Spoken Foundations

**10 units, 45 lessons (25–35 guided hours).**

| Unit | Content | Lessons | Speaking Task at the End |
|---|---|---|---|
| **0.1** | Vowels (`A, E, I, O, U`), vowel length (short vs long), and the German Alphabet `A–M` | 4 | Pronounce 10 short/long pairs (`Bann/Bahn`, `Mitte/Miete`) |
| **0.2** | The German Alphabet `N–Z`, plus the **3 Umlauts (`Ä, Ö, Ü`)** and **`ß` (Eszett)** | 5 | Say 15 umlaut contrast pairs (`schon/schön`, `Mutter/Mütter`, `Druck/drücken`) |
| **0.3** | Diphthongs (`ei, ai, ie, au, äu, eu`) — Mastering `ei` (আই) vs `ie` (ঈ) | 5 | Read 20 words contrasting `ei` and `ie` without hesitation (`mein/Miete`, `Wein/Wien`) |
| **0.4** | Consonant Rules: `W` (v), `V` (f), `Z` (ts), `J` (y), and `S` (voiced 'z' vs unvoiced 's') | 5 | Read 25 words aloud (`Wasser, Vater, Zeit, Ja, Sonne, das`) |
| **0.5** | Consonant Clusters: `ch` (ach-Laut vs ich-Laut), `sp` (shp), `st` (sht), `sch` (sh), `tsch` (ch) | 5 | Say 20 cluster words (`Buch, ich, Sport, Stadt, Schule, Deutsch`) |
| **0.6** | The German `R` (throat fricative / vocalic '-er' ending) and silent letters / word stress | 4 | Say 15 words ending in `-er, -en, -el` with natural German cadence (`Mutter, fahren, Apfel`) |
| **0.7** | Numbers 0–20, the inversion rule for tens (`einundzwanzig` = 21: one-and-twenty), and numbers to 100 | 5 | Count 1 to 100 and say 5 phone numbers and prices aloud |
| **0.8** | Essential Greetings, Farewells, and Politeness (*Guten Tag, Auf Wiedersehen, Bitte, Danke*) | 4 | 1-minute greeting & politeness role-play |
| **0.9** | Pronouns & Respect Tiers: **`Sie` (আপনি) vs `du` (তুমি) vs `ihr` (তোমরা)** | 5 | Introduce yourself and ask someone's name in formal vs informal style |
| **0.10** | Fluency Drills, Tongue Twisters (*Zungenbrecher*), and Stage 0 Speaking Test | 3 | Stage 0 oral assessment (spelling name, numbers, survival role-play) |

#### How Every Phonetics Lesson Works (7-Step Sound Practice Loop)

1. **Hear** the target sound 3 times (slow `0.8x` → normal `1.0x`).
2. **See** the letter, mouth diagram tip in Bangla (e.g. *“ঠোঁট গোল করে ‘উ’-এর মতো করুন, কিন্তু আওয়াজ বের করুন ‘ই’-এর মতো = Ü”*).
3. **Say** the sound 3 times following the audio model.
4. **5 Practice Words** using familiar international/shared vocabulary (*Auto, Name, Haus, Musik, Kaffee*).
5. **Minimal-Pair Contrast** targeting typical Bangla slips (`W` vs `B`, `V` vs `F`, `ei` vs `ie`, `schon` vs `schön`).
6. **Speed Ladder** at `0.8x → 0.9x → 1.0x → 1.15x`.
7. **Oral Recall:** see the Bangla meaning and produce the German word aloud before the answer plays.

#### Key Pronunciation Rules for Bangla Speakers

| Sound | German Example | Bangla Learner Tendency | Precise Correction |
|---|---|---|---|
| **`W`** | *Wasser, wo, wer* | Pronounced as 'ওয়' (English w) | Touch upper teeth to lower lip like English 'v' / Bangla 'ভ' (*ভাসার, ভো, ভেয়া*). |
| **`V`** | *Vater, viel, von* | Pronounced as 'ভ' (English v) | Most native German words pronounce `v` as English 'f' / Bangla 'ফ' (*ফাটার, ফিল, ফন*). |
| **`Z`** | *Zeit, zwei, Zimmer* | Pronounced as 'জ' or 'য' | Always pronounce as 'ts' / Bangla 'ৎস' (*ৎস্সাইট, ৎস্ভাই, ৎসিমা*). |
| **`S`** | *Sonne, Musik* vs *das, ist* | Inconsistent 'স' / 'শ' | At the beginning of a word or between vowels, `s` is voiced English 'z' / 'জ়' (*জ়ন্নে, মুজ়ীক*). At the end of a word or after consonants, it is sharp unvoiced 'স' (*দাস, ইস্ট*). |
| **`SP / ST`** | *Sport, sprechen, Stadt, stehen* | Said with pure 'স্প' and 'স্ট' | At the start of a word/syllable, pronounce as 'শ্প' and 'শ্ট' (*শ্পোর্ট, শ্প্ড়েশেন, শ্টাট, শ্টেইন*). |
| **`Ä`** | *Mädchen, spät, Äpfel* | Confused with 'এ' | Broad open 'অ্যা' (like English *cat* or Bangla 'ম্যাঁ'): *ম্যাদখেন, শ্প্যাত, অ্যাপফেল*. |
| **`Ö`** | *schön, hören, Köln* | Replaced by plain 'ও' or 'অ' | Shape lips into an 'O', but keep the tongue in position for 'E' (rounded lips saying 'এ'): *শোন* নয়, *শোঁ[এ]ন*. |
| **`Ü`** | *über, Tür, fünf, München* | Replaced by plain 'উ' | Shape lips into an tight 'U', but pronounce 'I' (rounded lips saying 'ই'): *মুয়েনখেন* নয়, *ম্যুন্‌শেন*. |
| **`EI` vs `IE`** | *mein, Wein* vs *Miete, Wien* | Confused with each other | `EI` = "আই" (*মাইন, ভাইন*); `IE` = long "ঈ" (*মীটে, ভীন*). Rule: *“Say the second letter!”* |
| **`-ER` End** | *Mutter, Vater, Wasser* | Pronounced with hard rolled 'র' | Final `-er` is vocalized into a relaxed central '-আ' (*মুটা, ফাটা, ভাস্সা*). |
| **`CH`** | *Buch* (ach-Laut) vs *ich* (ich-Laut) | Replaced with hard 'চ' or 'ক' | After *a, o, u* = guttural throat 'খ়' (*বুখ়*). After *e, i, ä, ö, ü* = soft hissing palate 'শ/হ্ইয়' (*ইশ/ইখ্*). |

---

### Level A1 — Beginner (Daily Life, Shopping & Foundations)

**15 units, 60 lessons (~750–900 items). Aligned with Goethe-Zertifikat A1 (Start Deutsch 1).**

| Unit | Topic | Core Grammar & Sentence Structure | Speaking Task (Can-Do) |
|---|---|---|---|
| **1.1** | First Meetings & Self-Introduction | Regular verb conjugation (`ich -e, du -st, er/sie -t, wir/Sie -en`) + *sein* (to be) | *Ich heiße Rahim. Ich komme aus Bangladesch und wohne in Berlin.* |
| **1.2** | Asking Questions (W-Fragen & Ja/Nein) | Question words (`Wer, Was, Wo, Woher, Wohin, Wie`) + Inversion for Yes/No questions | *Woher kommen Sie? Sprechen Sie Deutsch?* |
| **1.3** | Noun Genders & Definite Articles | Three genders: `der` (masculine, blue), `die` (feminine, red), `das` (neuter, green) | *Das ist der Tisch, die Lampe und das Buch.* |
| **1.4** | Indefinite Articles & Negation | `ein / eine / ein` and `kein / keine / kein` vs `nicht` | *Ich habe einen Bruder, aber keine Schwester. Das ist nicht teuer.* |
| **1.5** | Food, Grocery & In the Supermarket | Plurals (`-e, -er, -n, -en, -s`) + quantities & weights (`Kilo, Flasche, Gramm`) | *Ich brauche ein Kilo Äpfel und zwei Flaschen Wasser.* |
| **1.6** | Direct Object: **The Akkusativ Case** | Masculine change: `der → den`, `ein → einen`, `kein → keinen` (fem & neuter unchanged) | *Ich trinke den Kaffee. Er kauft einen Laptop.* |
| **1.7** | Numbers, Prices & Shopping | German prices (`zwei Euro fünfzig`) + Bargaining & Paying (`bar oder mit Karte?`) | *Was kostet das? Ich zahle mit Karte, bitte.* |
| **1.8** | Telling Time, Days & Schedule | Formal & informal time (`Viertel vor / nach, halb`), days, months + Preposition `um / am` | *Um wie viel Uhr beginnt der Deutschkurs? Um halb neun.* |
| **1.9** | Daily Routines: **Separable Verbs** | *Aufstehen, anrufen, einkaufen, fernsehen* (Prefix moves to end of clause!) | *Ich stehe jeden Tag um 7 Uhr auf und kaufe am Abend ein.* |
| **1.10** | Modal Verbs: **können, müssen, wollen** | Modal in position 2 + Infinitive at the very end of sentence! | *Ich kann ein bisschen Deutsch sprechen. Ich muss heute arbeiten.* |
| **1.11** | Ordering in a Café & Restaurant | Polite wishes with *möchte* (`Ich möchte bitte...`), paying the bill (*Zusammen oder getrennt?*) | *Herr Ober, ich möchte einen Kaffee und die Rechnung, bitte.* |
| **1.12** | Housing, Rooms & Furniture | Describing apartments, size, rent (`Kaltmiete, Warmmiete, Zimmer, Küche, Bad`) | *Meine Wohnung hat zwei Zimmer. Die Miete ist sehr günstig.* |
| **1.13** | Orientation & City Navigation | Directions (`geradeaus, nach links, nach rechts`) + transport (`mit dem Bus / der U-Bahn`) | *Entschuldigung, wie komme ich zum Bahnhof? Nehmen Sie die U-Bahn.* |
| **1.14** | The Spoken Past: **Das Perfekt** | *haben / sein* + *Partizip II* at the end (*Ich habe gelernt, Ich bin nach Dhaka gefahren*) | *Gestern habe ich gearbeitet und am Nachmittag habe ich Deutsch gelernt.* |
| **1.15** | A1 Review & Goethe A1 Speaking Prep | Complete A1 oral exam simulation (Part 1: Self-intro & spelling, Part 2: Asking & answering with cards, Part 3: Formulating requests) | **Goethe A1 Speaking Test Simulation** |

---

### Level A2 — Elementary (Travel, Healthcare, Living & Work Basics)

**15 units, 60 lessons. Aligned with Goethe-Zertifikat A2.**

| Unit | Topic | Core Grammar & Skills | Speaking Task (Can-Do) |
|---|---|---|---|
| **2.1** | Indirect Object: **The Dativ Case** | `dem` (m/n), `der` (f), `den ...-n` (pl) + pronouns `mir, dir, ihm, ihr, uns, Ihnen` | *Können Sie mir bitte helfen? Ich gebe dem Lehrer das Buch.* |
| **2.2** | Two-Way Prepositions (*Wechselpräpositionen*) | Movement/Direction = **Akkusativ** (*Wohin?*); Fixed Location = **Dativ** (*Wo?*) | *Ich lege das Buch auf den Tisch. Das Buch liegt auf dem Tisch.* |
| **2.3** | At the Doctor & Pharmacy (*Beim Arzt*) | Body parts, symptoms, illnesses + imperative requests | *Mein Kopf tut weh und ich habe Fieber. Nehmen Sie diese Tabletten.* |
| **2.4** | Modal Verbs: **dürfen, sollen, möchten** | Expressing permission, rules, doctor's advice, obligations | *Hier darf man nicht rauchen. Der Arzt sagt, ich soll viel Wasser trinken.* |
| **2.5** | Subordinate Clauses: **weil, dass, wenn** | Verb kicks to the very end of clause (*Verb-am-Ende*)! | *Ich lerne Deutsch, weil ich in Deutschland studieren möchte.* |
| **2.6** | Travel, Booking & Deutsche Bahn | Train tickets, platform (*Gleis*), delay (*Verspätung*), changing trains (*umsteigen*) | *Gleis vier, der Zug hat 10 Minuten Verspätung. Wann fährt der nächste Zug?* |
| **2.7** | Apartment Hunting & Living in a WG | Contacting landlords, flatshares (*Wohngemeinschaft*), viewing appointment (*Besichtigung*) | *Hallo, ich interessiere mich für das WG-Zimmer. Wann ist eine Besichtigung möglich?* |
| **2.8** | Reflexive Verbs (*Sich-Verben*) | *Sich freuen, sich interessieren, sich anziehen, sich fühlen* + reflexive pronouns | *Ich freue mich auf das Wochenende. Wie fühlen Sie sich heute?* |
| **2.9** | Adjective Endings (*Adjektivdeklination*) | Weak, strong, and mixed adjective endings in context | *Ich suche einen bequemen Stuhl und eine moderne Wohnung.* |
| **2.10** | Making Appointments & Invitations | Proposing dates, accepting, declining politely (*Verschieben, absagen, vereinbaren*) | *Passt es Ihnen am Dienstag um 14 Uhr? Ja, das passt mir gut.* |
| **2.11** | Describing the Past: **Präteritum** of Auxiliaries | Spoken use of *war* (was) and *hatte* (had) instead of Perfekt | *Letztes Jahr war ich in Bangladesch. Ich hatte keine Zeit.* |
| **2.12** | Comparatives & Superlatives | `-er als...`, `am ...-sten`, irregulars (*gut, besser, am besten; viel, mehr, am meisten*) | *Der Zug ist schneller als der Bus, aber das Flugzeug ist am teuersten.* |
| **2.13** | At the Bank, Post Office & Bürgeramt | Opening bank accounts (*Girokonto*), city registration (*Anmeldung*), parcels | *Guten Tag, ich möchte mich anmelden und ein Bankkonto eröffnen.* |
| **2.14** | Workplace Basics & Colleagues | Small talk at work, explaining daily duties, asking for leave (*Urlaub beantragen*) | *Ich mache heute die Präsentation. Chef, kann ich nächsten Montag frei nehmen?* |
| **2.15** | A2 Review & Goethe A2 Speaking Prep | Complete Goethe A2 speaking simulation (Part 1: Questions about life, Part 2: Talking about a topic, Part 3: Planning something together) | **Goethe A2 Speaking Test Simulation** |

---

### Level B1 — Intermediate (Autonomy, Opinions & Professional Ausbildung)

**16 units, 70 lessons. Aligned with Goethe/telc B1 (Crucial for German Student Visa & Ausbildung).**

| Unit | Topic | Core Grammar & Key Competencies | Speaking Task (Can-Do) |
|---|---|---|---|
| **3.1** | Giving Reasons & Contrasts | Connectors: *deshalb, trotzdem, obwohl* (Adverb vs Conjunction word order) | *Obwohl es regnet, gehe ich spazieren. Es regnet, trotzdem gehe ich.* |
| **3.2** | Expressing Opinions & Debating | *Meiner Meinung nach, Ich bin der Ansicht, dass..., Einerseits... andererseits* | *Meiner Meinung nach sollten mehr Menschen öffentliche Verkehrsmittel nutzen.* |
| **3.3** | Conditional & Polite Wishes: **Konjunktiv II** | *hätte, wäre, würde + Infinitiv* (Would like, polite requests, imaginary situations) | *Könnten Sie mir bitte sagen...? Wenn ich Zeit hätte, würde ich nach München reisen.* |
| **3.4** | Relative Clauses (*Relativsätze*) | Explaining who/what using relative pronouns in Nominativ, Akkusativ, Dativ | *Der Mann, der dort drüben steht, ist mein Deutschlehrer.* |
| **3.5** | Telephone Communication & Official Calls | Professional phone etiquette, leaving messages, asking to be transferred | *Guten Tag, mein Name ist Rahim. Könnten Sie mich bitte mit Herrn Müller verbinden?* |
| **3.6** | Time Connectors (*Temporalsätze*) | *Während, bevor, nachdem, seitdem, bis, solange* | *Nachdem ich meinen Abschluss gemacht habe, möchte ich eine Ausbildung machen.* |
| **3.7** | The Passive Voice (*Passiv Präsens & Perfekt*) | *werden + Partizip II* (Process passive for instructions, rules, and work duties) | *Hier wird Deutsch gesprochen. Der Patient wurde gestern operiert.* |
| **3.8** | Applying for *Ausbildung* / Job Interviews | Describing strengths, qualifications, motivation, and answering standard questions | *Ich interessiere mich für eine Ausbildung als Fachinformatiker / Pflegefachkraft.* |
| **3.9** | Handling Complaints & Problems | Defective products, delayed deliveries, landlord disputes, polite firmness | *Ich habe vor zwei Wochen bestellt, aber die Ware ist noch nicht angekommen.* |
| **3.10** | Indirect Questions & Inquiries | *Können Sie mir sagen, ob / wann / wie viel...?* | *Wissen Sie vielleicht, wann die nächste U-Bahn abfährt?* |
| **3.11** | Infinitives with **zu**: *um... zu, ohne... zu* | Purpose and manner infinitives (*Ich lerne Deutsch, um in Deutschland zu studieren*) | *Ich bin hier, um meine Sprachkenntnisse zu verbessern.* |
| **3.12** | Health, Insurance & Emergency Situations | *Krankenkasse*, emergency doctor (*Notarzt 112*), describing accidents and symptoms | *Es gab einen Unfall! Bitte schicken Sie sofort einen Krankenwagen.* |
| **3.13** | Two-Part Connectors (*Doppelkonnektoren*) | *nicht nur... sondern auch, sowohl... als auch, weder... noch, entweder... oder* | *Deutschland bietet nicht nur gute Universitäten, sondern auch tolle Berufschancen.* |
| **3.14** | German Culture, Habits & Punctuality | Punctuality (*Pünktlichkeit*), waste separation (*Mülltrennung*), quiet hours (*Ruhezeit*) | Explain cultural differences between Bangladesh and Germany |
| **3.15** | Structured Presentation Skills (B1 Exam) | Signposting, introduction, pros/cons, own opinion, personal experience | Deliver a 3-minute presentation on *"Sollten Handys in der Schule verboten werden?"* |
| **3.16** | B1 Review & Goethe/telc B1 Exam Prep | Complete B1 speaking exam simulation (Part 1: Joint planning, Part 2: Presentation, Part 3: Q&A on presentation) | **Goethe B1 Speaking Test Simulation** |

---

### Level B2 — Upper Intermediate (Workplace, University & Advanced Argumentation)

**16 units, 70 lessons. Aligned with Goethe/telc B2.**

| Unit | Topic | Focus | Speaking Task |
|---|---|---|---|
| **4.1** | Nuanced Opinions & Subtlety | *Es steht außer Frage, Ich bezweifle, dass..., Man darf nicht vergessen...* | Differentiate degrees of certainty and doubt |
| **4.2** | Corporate Meetings & Team Discussions | Chairing a meeting, interjecting politely (*Darf ich dazu etwas sagen?*), reaching consensus | Participate in a 10-minute team meeting simulation |
| **4.3** | Business Negotiations & Customer Handling | Pricing terms, discounts, delivery timelines, contract discussions | Negotiate business terms with a supplier |
| **4.4** | Healthcare & Clinical German (Pflege / Medizin) | Handover protocols (*Übergabe*), documenting patient care, empathy with patients | Deliver a nursing shift handover report |
| **4.5** | Nominal Style (*Nominalstil*) to Spoken Verbal Style | Decoding bureaucratic texts and expressing them naturally in spoken German | Translate administrative memos into clear spoken explanations |
| **4.6** | Advanced Konjunktiv II in Arguments | Past unfulfilled conditions (*Hätte ich gewusst, wäre ich gekommen*) | Analyze past business decisions and alternative scenarios |
| **4.7** | Advanced Passive & Alternatives | *lässt sich machen, ist zu erledigen, man kann...* | Discuss feasibility of technical projects |
| **4.8** | Formal Presentations (B2 Level) | Structured 5-minute academic presentation with data and visual aids | Present an analysis of renewable energy transitions |
| **4.9** | Academic & Scientific Discussion | Formulating hypotheses, arguing cause and effect (*infolge, basierend auf*) | Discuss a scientific or engineering topic |
| **4.10** | Resolving Workplace Conflicts | De-escalation strategies, diplomacy, giving constructive feedback | Role-play resolving a misunderstanding between colleagues |
| **4.11** | Media, News & Editorial Language | Following rapid news broadcasts (*Tagesschau*), discussing societal trends | Summarize and critique a current news debate |
| **4.12** | Fast Native Speech & Conversational Fillers | Shadowing rapid colloquial speech (*quasi, sozusagen, na ja, echt, überhaupt*) | Shadow a 1-minute native conversational excerpt |
| **4.13** | Job Interviews for High-Skill Roles (IT/Engineering) | Behavioral interview techniques (STAR method), technical project explanations | 15-minute professional job interview simulation |
| **4.14** | German Humor, Irony & Nuance | Understatement, dry humor (*Klammerbeutel*), situational irony | Retell an ironic everyday anecdote |
| **4.15** | Idiomatic Collocations (*Feste Nomen-Verb-Verbindungen*) | *zur Verfügung stehen, in Betracht ziehen, eine Entscheidung treffen* | Integrate 10 formal collocations into spontaneous speech |
| **4.16** | B2 Review & telc/Goethe B2 Exam Prep | Presentation, debate, and collaborative problem-solving | **Goethe / telc B2 Speaking Test Simulation** |

---

### Level C1 — Advanced (Academic Mastery, Rhetoric & High Fluency)

**16 units, 70 lessons. Aligned with TestDaF (Niveau 5) / DSH-3 / Goethe C1.**

| Unit | Topic | Key Competencies | Speaking Task |
|---|---|---|---|
| **5.1** | High-Level Rhetoric & Persuasion | Triads, rhetorical questions, emphasis particles (*ja, doch, eben, halt, wohl*) | Deliver a 5-minute persuasive speech |
| **5.2** | Idioms & Colloquialisms (*Redewendungen*) | 40 ubiquitous German idioms (*ins Fettnäpfchen treten, Daumen drücken, ins Gras beißen*) | Use 5 idioms naturally in a spontaneous talk |
| **5.3** | Proverbs & Wisdom (*Sprichwörter*) | *Aller Anfang ist schwer, Wer rastet, der rostet, Übung macht den Meister* | Explain cultural philosophy behind 3 proverbs |
| **5.4** | Academic Seminar & Defense | Defending research findings against critical objections | Defend a thesis proposal in a university seminar simulation |
| **5.5** | Formal University Lectures & Note-Taking | Synthesizing spoken lecture notes into spontaneous oral summaries | Summarize a 10-minute complex academic lecture |
| **5.6** | High Register & Official Discourse (*Amtssprache*) | Official hearings, administrative appeals, precise legal phrasing | Present an administrative appeal orally |
| **5.7** | Literature & Expression | Expressive reading and interpretation of classic and modern German literature | Read and interpret an excerpt from Goethe, Kafka, or Hesse |
| **5.8** | Public Speaking & Keynote Hosting | Welcoming audiences, hosting conferences, delivering keynote introductions | Host a formal conference session |
| **5.9** | Advanced Debate & Counter-Arguments | Rebuttal strategies, pointing out logical fallacies diplomatically | Participate in a live Oxford-style formal debate |
| **5.10** | Dialectal & Regional Awareness | Recognizing Bavarian, Swabian, Saxon, and Low German speech habits | Identify dialect features without producing them |
| **5.11** | Spontaneous Monologue (10 min) | Sustained speech on abstract philosophical and ethical questions | Deliver a 10-minute unscripted monologue |
| **5.12** | 3-Way Register Switching | Informal WG chatter ↔ Office team meeting ↔ Academic board presentation | Retell one incident across all three registers |
| **5.13** | Media Interviews & Press Q&A | Handling rapid, critical press questions under time pressure | Press conference simulation |
| **5.14** | Error-Free Precision Under Speed | Self-correction, flawless article genders, prepositional verb government | Rapid-fire oral grammatical accuracy drill |
| **5.15** | Deep Intercultural Pragmatics | Reading between the lines in German corporate culture (*Direktheit*) | Explain communication nuance between German and Bengali styles |
| **5.16** | C1 Master Review & TestDaF/DSH Prep | Complete oral examination simulation covering TestDaF Mündlicher Ausdruck (7 Tasks) | **TestDaF / DSH-3 Oral Exam Simulation** |

---

### Advanced Tracks (C2 & Specialized Professional Domains)

Modular tracks built per student and career demand (10–20 lessons each):

| Track | Focus | Key Content |
|---|---|---|
| **T1 Healthcare, Nursing & Clinical German (*Pflege & Medizin*)** | Nursing *Ausbildung*, doctors' approbation exam (*Fachsprachprüfung FSP*) | Patient intake (*Anamnese*), doctor handover (*Übergabe*), medical devices, comforting elderly patients, pharmacology terms |
| **T2 German University, APS & Student Visa Interview** | Admissions to TU Munich, RWTH Aachen, TU Berlin, etc. | APS interview prep, Uni-Assist communication, blocked account verification, professor correspondence, lab presentations |
| **T3 *Chancenkarte* (Opportunity Card) & IT / Engineering Job Search** | Skilled immigration to Germany | Technical job interviews, salary negotiation, explaining software architectures, German CV (*Lebenslauf*) presentation |
| **T4 Engineering & Industry 4.0 (*Ingenieurwesen*)** | Mechanical, automotive, electrical & civil engineering | Factory floor German, safety briefings (*Arbeitsschutz*), technical documentation, blueprints (*Baupläne*), quality control |
| **T5 Hospitality & Culinary Ausbildung (*Gastronomie & Hotellerie*)** | Hotel management, culinary training | Reception desk check-in, guest complaints, culinary terms, event coordination, shift management |
| **T6 Consecutive Interpreting (Bangla ↔ German)** | Professional community & legal interpreting | Police/BAMF asylum hearings, hospital consultations, trade fairs, note-taking techniques, maintaining neutral register |
| **T7 Austrian & Swiss German Bridge (*Österreichisches Deutsch & Schweizerdeutsch*)** | Dialect and vocabulary bridge | Austrian vocabulary (*Erdapfel, Jänner, Matura*) and Swiss German spoken phonetics & vocabulary (*Grüezi, Velo, Spital*) |

---

## 4. Lesson Template (Consistent Across All Levels)

Every lesson (15–20 minutes, 8–14 items) follows the audio-ladder repetition engine and oral-reflex framework:

1. **Warm-Up (2 min):** Review 3 due items from the spaced-repetition queue.
2. **Listen & Shadow (3 min):** Listen to the lesson's target patterns via the speed ladder:
   - `0.85x` German (slow learner speed)
   - `1.15x` Bangla meaning
   - `0.95x` German
   - `1.05x` German (natural native speed)
   - `1.15x` German (rapid conversational speed, for A2+)
   - `1200ms` pause for learner echo / shadowing.
3. **New Items (5 min):**
   - **Stage 0:** `sound` / `letter` items → practice `word` items → minimal-pair contrast items.
   - **A1+:** 2–3 `word` items (nouns tagged with grammatical gender: `"gender": "m" / "f" / "n"`) → 2–4 `sentence` items with word-by-word `tokens`, article case markers, and grammatical glosses.
4. **6-Way Pattern Transformation Drill (4 min):** Drills one core sentence pattern across 6 forms:
   1. **Affirmative (+):** *Ich lerne heute Deutsch.*
   2. **Negative (-):** *Ich lerne heute nicht Deutsch.*
   3. **Yes/No Question (?):** *Lernst du heute Deutsch?*
   4. **WH-Question (W-Frage):** *Wann lernst du Deutsch?*
   5. **Respect Switch (*Sie* ↔ *du*):** *Lernen Sie heute Deutsch?*
   6. **Spoken Past / Subordinate Clause (*Perfekt* / *weil*):** *Ich habe heute Deutsch gelernt.* / *...weil ich heute Deutsch lerne.*
5. **Speak / Speech Check (3 min):** See the Bangla meaning prompt, speak the German sentence aloud into the microphone (`SpeechCheckCard` using `de-DE` on-device speech recognition or self-rating fallback), then hear the model audio answer.
6. **Role-Play Dialogue (from Unit 1.10, 3 min):** 4 `dialogue_line` items (`speaker: "A"` and `"B"`) practicing real-life scenarios.
7. **Lesson Quiz (2 min):** 8–10 auto-generated questions (`QuizGenerator`: audio → Bangla meaning, Bangla → German target, article gender choice `der/die/das`, case inflection choice). Scoring ≥ 70% marks the lesson `DONE`.

---

## 5. Grammar & Phonetic Contrast Points for Bangla Speakers

| Point | Why Bangla Speakers Struggle | How the Course Drills It |
|---|---|---|
| **Three Noun Genders (`der, die, das`)** | Bangla has no grammatical gender at all. Learners default to treating all nouns as genderless. | Every noun item is color-coded (**Blue** = *der*, **Red** = *die*, **Green** = *das*, **Orange** = Plural *die*). Flash-quizzes test article recall before the noun itself. |
| **The 4 Cases (`Nom, Akk, Dat, Gen`)** | In Bangla, case endings are suffixed (`-কে, -তে, -এর`), whereas in German, articles change dynamically before the noun (`der → den / dem / des`). | Contrast drills linking direct object (*Akkusativ*) and location/beneficiary (*Dativ*) with explicit color changes: *der Tisch → auf den Tisch (Akk) → auf dem Tisch (Dat)*. |
| **Verb Position 2 (V2 Rule)** | In Bangla (SOV), verbs are placed at the end. In German main clauses, the verb **must** be in position 2, even when an adverb starts the sentence (*Heute lerne ich Deutsch*, NOT *Heute ich lerne*). | "V2 Lock" drills: varying the starting element (time, place, object) while keeping the verb locked firmly in position 2. |
| **Separable Verb Prefixes (*Trennbare Verben*)** | In English/Bangla, verb components stay together. In German, the prefix detaches and flies to the absolute end of the clause. | Target drills highlighting the prefix movement: *Er steht jeden Morgen um sechs Uhr auf.* |
| **Spoken Past (*Perfekt* with *sein* vs *haben*)** | Learners confuse which verbs take *sein* (movement & state change: *gehen, fahren, aufstehen*) vs *haben* (stationary & transitive: *essen, machen, kaufen*). | "Movement Radar" drill categorizing verbs into *sein* (green/motion) and *haben* (blue/static). |

---

## 6. Assessment Framework

| Check | Frequency | Format | Pass Rule |
|---|---|---|---|
| **Lesson Quiz** | End of every lesson | 8–10 multiple-choice, audio-to-meaning & article selection questions | ≥ 70% marks lesson `DONE` |
| **Unit Speaking Task** | End of every unit | Oral prompt evaluated via `de-DE` speech recognition or self-rating | Qualitative feedback |
| **Level Speaking Exam** | End of Stage 0, A1, A2, B1, B2, C1 | 10 multi-part recorded prompts strictly modeled after official Goethe-Institut oral exams | ≥ 70% awards level certificate |
| **Article & Case Accuracy Check** | End of A1 & A2 | 25 rapid forced-choice items on `der/die/das` and `den/dem/des` | ≥ 80% accuracy |

---

## 7. Content Data Model & ESCB JSON Schema (`schema_version: 1`)

German course files follow the tested `schema_version: 1` ESCB format to guarantee instant compatibility with `ContentImporter.kt`, `EscbJsonParser.kt`, and `LessonPlayer.kt`.

### Authoring Unit Item Format (`tools/german/units/*.json`)

```json
{
  "type": "sentence",
  "target": "Ich lerne jeden Tag Deutsch, weil ich in Deutschland studieren möchte.",
  "bn": "আমি প্রতিদিন জার্মান ভাষা শিখছি, কারণ আমি জার্মানে পড়াশোনা করতে চাই।",
  "bn_pron": "ইশ ল্যার্নে ইয়েদেন টাগ ডয়চ, ভাইল ইশ ইন ডয়চলান্ড শ্টুডীরেন ম্যোক্শতে।",
  "gender": null,
  "tokens": [
    {"t": "Ich", "bn": "আমি"},
    {"t": "lerne", "bn": "শিখছি"},
    {"t": "jeden Tag", "bn": "প্রতিদিন"},
    {"t": "Deutsch", "bn": "জার্মান ভাষা"},
    {"t": "weil", "bn": "কারণ"},
    {"t": "ich", "bn": "আমি"},
    {"t": "in Deutschland", "bn": "জার্মানিতে"},
    {"t": "studieren", "bn": "উচ্চশিক্ষা নিতে"},
    {"t": "möchte", "bn": "চাই"}
  ]
}
```

### Compiled Asset Format (`app/src/main/assets/spoken_german_standard_a1.json`)

```json
{
  "schema_version": 1,
  "course": {
    "id": "de-standard-zero-a1",
    "target_lang": "de",
    "base_lang": "bn",
    "title_bn": "জার্মান স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
    "title_target": "Deutsch: Null bis A1",
    "source": "German-Spoken-Curriculum-Plan.md, roadmap phase 1 (Stage 0 + A1)",
    "note": "Draft content. A native German reviewer and a Bangla reviewer must check every item before release.",
    "welcome_text": "জার্মান স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি শব্দ ও বাক্য শুনুন এবং জোরে জোরে বলুন।"
  },
  "ladder_default": [
    { "play": "target", "speed": 0.85 },
    { "play": "bn", "speed": 1.15 },
    { "play": "target", "speed": 0.95 },
    { "play": "target", "speed": 1.05 },
    { "pause_ms": 1200 }
  ],
  "stats": {
    "lessons": 105,
    "items": 1200
  },
  "parts": [ ... ]
}
```

### Field Specifications & Validation Rules (`tools/german/build_german_course.py`)

| Field | Required | Validation Rule |
|---|---|---|
| `id` | Auto-generated | Formatted as `de-std-s0-01-l01-001` or `de-std-a1-05-l02-003`. |
| `type` | Yes | One of `sound`, `letter`, `word`, `phrase`, `sentence`, `dialogue_line`, `pattern`. |
| `target` | Yes | Standard German orthography (Latin alphabet + `ä, ö, ü, Ä, Ö, Ü, ß`), proper German capitalization of nouns, and punctuation (`. , ? ! -`). No ASCII digits (write *eins, zwei, drei*). No Bangla or brackets in `target`. |
| `bn` | Yes | Clear, natural Bengali translation. |
| `bn_pron` | Yes | Bengali phonetic pronunciation guide capturing umlauts and consonant rules. |
| `gender` | For noun `word` items | `"m"` (*der*), `"f"` (*die*), or `"n"` (*das*). |
| `tokens` | Yes (for sentences & words) | List of `{"t": "...", "bn": "..."}`. Concatenating all `t` fields without whitespace and punctuation must equal `target` character-for-character. |
| `speaker` | `dialogue_line` only | `"A"` or `"B"`. |

---

## 8. Content Production Pipeline

1. **Unit JSON Authoring:** Per-unit source JSON files in `android/tools/german/units/s0-01.json` … `a1-15.json` adhering to `android/tools/german/UNIT_FORMAT.md`.
2. **Automated Validation & Build (`android/tools/german/build_german_course.py`):**
   - Validates German Latin range + umlauts (`ä, ö, ü, ß`).
   - Rejects uncapitalized nouns or stray digits.
   - Enforces exact character-by-character token concatenation.
   - Validates noun genders (`m, f, n`).
   - Compiles `android/app/src/main/assets/spoken_german_standard_a1.json`.
3. **Native German Review:** Verified by a Goethe-certified or native German instructor for idiomatic naturalness, correct article genders, and register appropriateness.
4. **Bangla Review:** Verified by a bilingual instructor for natural Bengali meanings and accurate phonetic guides.
5. **On-Device Audio Verification:** Test listening on Android with Google TTS `de-DE` offline voice at `0.85x` and `1.05x`.

---

## 9. Isolation & Android App Integration Architecture

The German course does not alter any existing English, Japanese, Urdu, or Hindi assets or logic. All changes are additive and scoped by the `de-` ID prefix and `de_` course key.

| Isolation Pillar | Architecture |
|---|---|
| **Separate Content** | All German assets live strictly in `spoken_german_*.json` (starting with `spoken_german_standard_a1.json`). |
| **Separate IDs** | Every German part, lesson, and item ID starts with `de-` (specifically `de-std-`). |
| **Separate Settings** | German-specific settings use prefix `learn_de_` in `AppPreferences.kt`. |
| **Separate Entry Point** | Dedicated home showcase card (`language = "german"`, bundle `german_course`) navigating to `Screen.Learn.createRoute("german")`. |

### Exact Android Code Touchpoints

1. **`LearningModels.kt` (`com.gigabyte.bookstore.learning.domain.model`)**:
   - Add `DE` to `enum class SpeechLang { EN, BN, JA, UR, HI, DE }`.
   - Update `targetLangForId(id: String)`:
     ```kotlin
     fun targetLangForId(id: String): SpeechLang = when {
         id.startsWith("de-") -> SpeechLang.DE
         id.startsWith("hi-") -> SpeechLang.HI
         id.startsWith("ur-") -> SpeechLang.UR
         id.startsWith("jp-") -> SpeechLang.JA
         else -> SpeechLang.EN
     }
     ```
   - Update `LadderStep.encode()` and `LadderStep.decode()` to support `"de"`.
2. **`TtsStepEngine.kt` (`com.gigabyte.bookstore.learning.domain.audio`)**:
   - Add `val GERMAN_LOCALES = listOf(Locale.GERMANY, Locale.GERMAN)`.
   - Resolve `SpeechLang.DE` during initialization and expose `val germanAvailable: StateFlow<Boolean?>`.
3. **`EscbJsonParser.kt` & `ContentImporter.kt` (`com.gigabyte.bookstore.learning.data.content`)**:
   - Map `targetLang == "de"` and `"de"` ladder step to `SpeechLang.DE`.
   - Add `"spoken_german_standard_a1.json"` to `ContentImporter.ASSET_NAMES`.
4. **`SpeechCheckCard.kt` & `SpeechMatch.kt` (`com.gigabyte.bookstore.learning.presentation.lesson` / `domain.speech`)**:
   - Add `DE_STANDARD_PREFIX = "de-std-"` mapped to recognizer locale `"de-DE"`.
   - In `SpeechMatch.normalize()`, normalize German umlauts (`ä→ae, ö→oe, ü→ue, ß→ss`) so speech recognition matching is tolerant of alternative transcription formats.
5. **`LessonScreen.kt` & `LessonViewModel.kt`**:
   - Add German voice status warning: *"এই ফোনে জার্মান ভয়েস নেই। ফোনের Text-to-speech সেটিংস থেকে German (Germany) ভয়েস ইনস্টল করুন।"*
6. **`LearnHomeScreen.kt`, `HomeScreen.kt`, & `PaymentScreen.kt`**:
   - Add `isGerman = language.equals("german", ignoreCase = true)` branch in `LearnHomeScreen.kt` and `LearnHomeViewModel.kt`.
   - Add the German Spoken Course showcase card on `HomeScreen.kt` (`bundleId = "german_course"`, price `৳100`) navigating to `learn?lang=german`.
   - Register `german_course` in `PaymentScreen.kt` and `PaymentApprovalScreen.kt`.

---

## 10. Phased Roadmap

| Phase | Milestone | Scope | Deliverables |
|---|---|---|---|
| **Phase 0** | **App Plumbing & Audio Engine** | Android codebase | `SpeechLang.DE`, `de-DE` TTS integration, `SpeechMatch` German normalization, unit tests (`GermanSupportTest.kt`) |
| **Phase 1** | **Stage 0 + Level A1 (Foundations & Start Deutsch 1)** | 25 units, 105 lessons, ~1,200 items | `s0-01`…`s0-10` + `a1-01`…`a1-15`, compiler `build_german_course.py`, asset `spoken_german_standard_a1.json` |
| **Phase 2** | **Level A2 (Elementary & Goethe A2)** | 15 units, 60 lessons | Dativ, Wechselpräpositionen, travel, healthcare, WG apartments |
| **Phase 3** | **Level B1 (Goethe/telc B1 Exam Prep)** | 16 units, 70 lessons | Subordinate clauses (*weil, obwohl, dass*), Ausbildung interviews, presentations |
| **Phase 4** | **Level B2 (Professional & Clinical B2)** | 16 units, 70 lessons | Meeting debates, nursing/medical German, advanced grammar |
| **Phase 5** | **Level C1 (TestDaF / DSH / University)** | 16 units, 70 lessons | Academic lectures, rhetoric, scientific discussion, TestDaF oral tasks |
| **Phase 6** | **Specialist Tracks (T1–T7)** | 7 tracks × 10–20 lessons | T1 (Pflege & Healthcare) and T2 (University & APS) released first |

---

## 11. Architectural Decisions

### 11.1 High-Precision Bengali Phonetic Guide (`bn_pron`)
**Decision:** Provide a Bengali phonetic pronunciation line for every item in Stage 0 and A1. Explicitly guide mouth positions for umlauts (`ö` = `[এ+ও]`, `ü` = `[ই+উ]`) and silent final `-er` vocalization (`-আ`).

### 11.2 Tolerance in Speech Recognition Matching (`de-DE`)
**Decision:** Enable on-device `de-DE` speech recognition as non-blocking feedback. In `SpeechMatch.kt`, normalize umlauts (`ä = ae`, `ö = oe`, `ü = ue`, `ß = ss`) so speech evaluation is robust and never penalizes the learner if Android's recognizer transcribes using digraphs.

### 11.3 Priority of Specialized Tracks
**Decision:** Prioritize **T1: Healthcare & Nursing (*Pflege & Medizin*)** and **T2: German University Admissions & APS Preparation**.
**Reason:** Thousands of Bangladeshi students and nurses are currently learning German specifically to pursue tuition-free higher education or state-recognized *Ausbildung* in Germany.

