package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class PalindromePairs {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String[].class);
            Set<List<Integer>> expected = new HashSet<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{1, 0}));
            expected.add(Utils.getList(new Integer[]{0, 1}));
            Test.assertEquals(expected, new HashSet<List<Integer>>((List<List<Integer>>)method.invoke(null, (Object) new String[]{"bat", "tab", "cat"})));

            expected.clear();
            expected.add(Utils.getList(new Integer[]{1, 0}));
            expected.add(Utils.getList(new Integer[]{0, 1}));
            expected.add(Utils.getList(new Integer[]{3, 2}));
            expected.add(Utils.getList(new Integer[]{2, 4}));
            Test.assertEquals(expected, new HashSet<List<Integer>>((List<List<Integer>>)method.invoke(null, (Object) new String[]{"abcd", "dcba", "lls", "s", "sssll"})));

            expected.clear();
            for (Integer[] list : getExpected()) {
                expected.add(Utils.getList(list));
            }
            Test.assertEquals(expected, new HashSet<List<Integer>>((List<List<Integer>>)method.invoke(null, (Object) new String[]{"abcd", "dcba", "lls", "s", "sssll"})));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static Integer[][] getExpected() {
        return new Integer[][] {
                {0, 1},
                {1, 0},
                {3, 2},
                {2, 4},
        };
    }


    private static String[] getWords() {
        return new String[]{"hijajcd",
                    "hjhgahbcegj",
                    "fjbjfecjgfjdbbgdadcb",
                    "did",
                    "cgjhfafgea",
                    "chdbicgcij",
                    "jiebc",
                    "aajaaed",
                    "afddjhg",
                    "hiabij",
                    "hfgidgegedeafc",
                    "ifedfcaahhbc",
                    "fci",
                    "jbadcfghehiecbgjcg",
                    "gihedfiabhdjicaea",
                    "ji",
                    "hgacdbeadahceag",
                    "hij",
                    "fhheadbjb",
                    "gieghcacfccfadijcdbg",
                    "dbeabaafia",
                    "je",
                    "ebieia",
                    "becjedbdadecfafi",
                    "acbchfigbiaafechfeii",
                    "fddfbb",
                    "jefdihii",
                    "cfcifihdfgcjadbeec",
                    "jbcfgdhifjgdgcccggfe",
                    "ibhj",
                    "iihihigj",
                    "jifbhdgffiaii",
                    "gdcgdabdhbdh",
                    "giaa",
                    "fgaidgcbgbagjjgcja",
                    "becgcgjbeegebb",
                    "jadgeej",
                    "h",
                    "fddgcbgahhh",
                    "gecajfjcheha",
                    "gaeejd",
                    "bc",
                    "fd",
                    "jh",
                    "jddecghbjaedgeadieej",
                    "ehi",
                    "cfijccggfeijfc",
                    "jbdaeaeigbedebaabdg",
                    "hjiijifigbhae",
                    "aeihbbfdgfhi",
                    "bibhjdgdejjfgd",
                    "b",
                    "dgfhcbgfifchhihg",
                    "faaefigafd",
                    "fijbabeifgjcefeffdgc",
                    "ahdaiejbhegaha",
                    "difcfcbcfg",
                    "abdffeifcb",
                    "ggeaej",
                    "hbcicchejbecidi",
                    "ijedjfcjahhajc",
                    "jfacgfijbdehg",
                    "dfbhhbdafcfhjffbcij",
                    "cddjdgefdjbhccgaeb",
                    "c",
                    "gajfibiaehichfhfh",
                    "cheegj",
                    "icjhhcigfeedg",
                    "dggf",
                    "ificjhaihgicbhagjjgc",
                    "ifbjbadgcccacjcaea",
                    "biaafggehahijagj",
                    "dghehgccj",
                    "ccigbcajbb",
                    "fgafdfhagi",
                    "jdifdcj",
                    "haagafjfa",
                    "cdjibbfgije",
                    "jgbgdcgaabeicfadedjg",
                    "iahehcjhjecbjdehd",
                    "acahgc",
                    "ejggbffeea",
                    "ebacgded",
                    "ci",
                    "igggjhfgcjfeagaed",
                    "jjifjgfefgjgafdc",
                    "ddiefahhfeifggj",
                    "jggjfacda",
                    "dig",
                    "bajbghfecjajdhfebi",
                    "bfjcbiceefafhbc",
                    "bi",
                    "cdaj",
                    "bfedf",
                    "affdcjd",
                    "ebjceefjji",
                    "cgedidfdaj",
                    "diagcdjgcidcaabdec",
                    "biajbeajggcaadb",
                    "gg",
                    "af",
                    "ddeibadahhhbcgbb",
                    "fbgjaedfgah",
                    "fhagi",
                    "dbggfjbhefcg",
                    "dfgdhjcecbhjffhhcc",
                    "gcg",
                    "ibejfeehbfhbcceagbf",
                    "beefhdiiaajbbid",
                    "fcbgeeaggcehjagfbec",
                    "cehgbhhdjdabjhgbdf",
                    "ibjchciabig",
                    "fjfhbdhbdchacfi",
                    "dgaiffdjjfhihheajda",
                    "afbdfijbaacechfeehai",
                    "bhccifjcigdge",
                    "ghdibjdih",
                    "fhjiaja",
                    "fadfaea",
                    "ghhdicafbdgbccahb",
                    "fhf",
                    "jhfg",
                    "jehedbbcidgahjhefj",
                    "jdigdea",
                    "acfiiaebjfeea",
                    "eibciijib",
                    "fghhghdhb",
                    "bf",
                    "jgdbcciehebec",
                    "cbef",
                    "ccdcegbejhcdhbjgd",
                    "dacefieigggddd",
                    "icjfbhabjjaehgic",
                    "dja",
                    "egidaegjegceied",
                    "eifggahef",
                    "d",
                    "gh",
                    "aabhihfhbjjgaaaaaaf",
                    "hhfjgcd",
                    "efcejjcgbhdicghbcbda",
                    "jeecggeaidcdfeae",
                    "i",
                    "ddibebgcibi",
                    "gcffcijafghehgffijbj",
                    "ieb",
                    "hhbfcdgeicihcbcgje",
                    "aegbdaeedadig",
                    "jjhfgeijciji",
                    "ecjijiahfcbcf",
                    "hibddjjgifbf",
                    "eccaajecechb",
                    "deaaj",
                    "ecgfaaigjce",
                    "jhhejciejdhh",
                    "cb",
                    "f",
                    "cjddcfdihddechegg",
                    "cgdfdbficba",
                    "jajh",
                    "hcfadbghjbicbachah",
                    "g",
                    "fhchedhbcigeci",
                    "ghbbcijcbgeccbebaa",
                    "chgdgjiac",
                    "adfgjbbhfbdbheebhgb",
                    "gbbebiaijhagcjfgjda",
                    "aadhgcfjhcjaa",
                    "fhdbhccfccajfheiaaj",
                    "ijgjfc",
                    "dcdcfaebjhgafh",
                    "egadegbjabjgjhdbhcfb",
                    "hhaeabfcfcjc",
                    "gfjcijhbbie",
                    "icgihfcgd",
                    "gfaihjbcb",
                    "hae",
                    "ciiaefdegffchagaccj",
                    "dbadejehhgjjfd",
                    "abfbfdaaebhgbadf",
                    "gfeijf",
                    "acidgfeccdaccc",
                    "chhicfj",
                    "aejjeejbjcebd",
                    "bcchhd",
                    "aajideccdfgfdee",
                    "fdd",
                    "idabig",
                    "bfgigiacibhibfc",
                    "ghjidfcjdbfagbgg",
                    "jdgefifgfg",
                    "figabdib",
                    "ieegjbjaaaheieccfifj",
                    "hhifigebihbec",
                    "abfdca",
                    "j",
                    "dfecghggj",
                    "fbdg",
                    "aghigddeagaj",
                    "hjghddg",
                    "biededhjegi",
                    "aed",
                    "jcgbbhiacef",
                    "hgbhaadhe",
                    "bjffahgjibfjijjcah",
                    "abjgacciihhigafe",
                    "bhighdhjgb",
                    "idjbedcbcghfhgdjgd",
                    "fdcge",
                    "jiefciajfacejcbhiijb",
                    "gghchaac",
                    "jdh",
                    "ccdabajaihbigbfbi",
                    "edcchgggdajibbafag",
                    "fiihgiebhhb",
                    "ggbhhfjfa",
                    "gechicejjgbebe",
                    "fdadccghiadhgeecfeb",
                    "fh",
                    "gbddbi",
                    "acjcafggc",
                    "chgbfjfdghjfgaje",
                    "fgdcfffcabdbih",
                    "ffggdfd",
                    "eeibfggddgbb",
                    "bcccgbihhhaa",
                    "ecegdgdaieicfffebd",
                    "heig",
                    "aeafdijcgffhaagajbc",
                    "cdfecjaabhajjcag",
                    "jgacggaabdidjgg",
                    "hfcdjddbchagfa",
                    "bgh",
                    "bbiefehhfc",
                    "dfhic",
                    "checjfabdceddfefa",
                    "bbiebgigjg",
                    "hdchejdjeecc",
                    "cieafdi",
                    "bjbebfjbb",
                    "jeeghjiaagdf",
                    "ibbjgh",
                    "jgfje",
                    "gddfb",
                    "iadhbabgjjci",
                    "faafifgeddfcaji",
                    "ijejbiidaefibga",
                    "gjhdgffcebfdbbhh",
                    "hfbccbbbhebgjihfbhad",
                    "jhjeffebgiaijecihcbh",
                    "bdacgdeeiajehjhd",
                    "cej",
                    "fbbhabbdhbeigag",
                    "dhb",
                    "cbgahbcjjcb",
                    "jfbgegddgbfij",
                    "bjhcaabhgcfcieai",
                    "dfbedgacb",
                    "bh",
                    "hbgjhchebdigfef",
                    "becbjjgbdgfg",
                    "jigbiecdcegcgdha",
                    "ddacfbgaibdag",
                    "afid",
                    "gijejaagbghjha",
                    "becaigcjdbeiba",
                    "gd",
                    "cbfffhbacc",
                    "jjbafcijeffacaej",
                    "ihihgcgjgefiehgdijb",
                    "afifbbhfbd",
                    "dhigif",
                    "chcfjjahbjjgjjheie",
                    "ggfaaeeca",
                    "afjiccee",
                    "dddeigfhbgjiiffgf",
                    "edbcfcbiibhcdbihahd",
                    "jfhf",
                    "cgeeefjhj",
                    "ehaaahjbf",
                    "dbdbfeabhhdfhedc",
                    "jagiegfhgeicd",
                    "cg",
                    "fjhbaj",
                    "djfejdacebedjjh",
                    "ejhdbjaagcih",
                    "hhifahefah",
                    "decabhgbhf",
                    "hjgfhdcfjghiehfbaccb",
                    "hc",
                    "cicefggjjhahhihh",
                    "ebghgcehfdbgjef",
                    "ihjfejiaidccj",
                    "feebgfadjjih",
                    "efdjbhbcdgfabia",
                    "ebjdhij",
                    "ccbjjbfgjifgibibhdi",
                    "ddhgfihdifiegfdcbg",
                    "jjhccchci",
                    "bjhffdchjgfdejbjcc",
                    "ghfhfadhadggbf",
                    "degiigae",
                    "ffefbjgfacjghchab",
                    "affcadjjedffagcija",
                    "hfaahajcijjigihjdbh",
                    "eccahdhacfaaechc",
                    "gaidhegbhdbg",
                    "gdacg",
                    "ajiafgjbi",
                    "dcecgfgjh",
                    "e",
                    "cj",
                    "iijjbfbciidi",
                    "hhabcihigiccc",
                    "hdje",
                    "ghgiagda",
                    "gcgii",
                    "jgccffabdd",
                    "eafd",
                    "jgajgdghgjihfj",
                    "hf",
                    "jfhhagebiaage",
                    "jcbgf",
                    "cehifbja",
                    "egidejh",
                    "jd",
                    "hhfgdcedjbafijia",
                    "jejiajdffhdg",
                    "ebdificebhah",
                    "djddifjeb",
                    "ibgfadfebjefjehed",
                    "fcbad",
                    "gfajh",
                    "eabhddjadabaadc",
                    "jfjdaibedicjfd",
                    "a",
                    "ahfiihcjceefjghjhi",
                    "hdbcfidadjaggacigg",
                    "bbfjhiegacbicihgbd",
                    "beddihjhhjhi",
                    "ahgideccga",
                    "eadhajdegaig",
                    "bccbgahhh",
                    "ihfieebjejfhfh",
                    "jddigigfhfegf",
                    "acdihgjab",
                    "hgcbfheehjafij",
                    "hagfebifdcah",
                    "ecfbiefefcgha",
                    "giifif",
                    "cfiadgbb",
                    "faiecgcbaidi",
                    "ffhcfc",
                    "dgcbabfchj",
                    "gchhhdhjjjjgfbeeaig",
                    "jiebceebjeeiadcjehia",
                    "ajbbhbighd",
                    "hgiidjeagfgeejb",
                    "gdehaffbfjc",
                    "dhfibjfdfedbe",
                    "hbeeedddgaaa",
                    "bj",
                    "fgdhidihjfbedbbhb",
                    "dcigfcd",
                    "jjgccccjfhjgagjbccbd",
                    "djggj",
                    "fdfbcaj",
                    "hhh",
                    "ebgddabghbje",
                    "ijaeaihjbjgeb",
                    "bcgf",
                    "geabfbf",
                    "ajdf",
                    "behefaeeb",
                    "icjecdbeejbg",
                    "dcfhcchjabbbe",
                    "ficggejecefjahagfc",
                    "cbjbaaig",
                    "cgghddihbibdahajjjj",
                    "febcdicdjhigigjf",
                    "jccfhaafj",
                    "hgagaghagejgdbhiaa",
                    "gdibfadcfjdchdcda",
                    "faice",
                    "jddahggg",
                    "ig",
                    "ajihabc",
                    "ifc",
                    "ddbdie",
                    "hgf",
                    "iicihahjicfbce",
                    "egfjiifaigfhafdcdi",
                    "gahbbfgebhajgajgf",
                    "gibegcbhhjhcgeg",
                    "gahahjjjid",
                    "beeghbgiaiffcbedhi",
                    "hb",
                    "dgfdhbajiej",
                    "ehjieabbfgjfabegijii",
                    "chdafjb",
                    "giejchjbifieeeigccah",
                    "dadgcgjddbc",
                    "cdiiea",
                    "icdjffie",
                    "iehihifddj",
                    "jfcgfbjghbgfd",
                    "edebbjiieahada",
                    "badbhciaf",
                    "icdffehcddgacgjcfji",
                    "fgiheieeeibdjhhjae",
                    "accebdijaedhhajaj",
                    "acdgcbaehgaiedfcddf",
                    "jiagjghcaihbf",
                    "ga",
                    "ggghd",
                    "gb",
                    "ehcjcd",
                    "aac",
                    "cdfghgfagbcjjc",
                    "cddadcdidegifbi",
                    "ddhhch",
                    "fe",
                    "eaageabiccfcdd",
                    "fbbbjfjffj",
                    "icjfacdcbdajecda",
                    "aegdcbbicebaffaifg",
                    "hedichggfajdbagh",
                    "fggjjg",
                    "bdbigbjbjadiabjbhch",
                    "cdddaajifjjjiigj",
                    "bhb",
                    "faa",
                    "bdfgebjf",
                    "hicgahicd",
                    "hcfghggjcibb",
                    "ieddefeccfeccajhcah",
                    "ghc",
                    "jdgcbjaeeijjgciae",
                    "bdeaif",
                    "ehfdc",
                    "jjjddhjd",
                    "jibaejfc",
                    "gddibbagdjbefaga",
                    "fhca",
                    "iaggggg",
                    "bgbhgei",
                    "gigfa",
                    "fbibghagehecbedidbf",
                    "igbfedebhcjbbcegaa",
                    "cdceiffdjech",
                    "fbdjdhhfgaija",
                    "jgjccccchjabdgejfcj",
                    "aca",
                    "jghb",
                    "ffeejefecheefdjh",
                    "aediabejhghedgdah",
                    "edfcbijbihjafedcc",
                    "jbeg",
                    "gfdeccbdgdgidabe",
                    "figbaajccj",
                    "dh",
                    "eeafbfcccbjidci",
                    "adfgdc",
                    "becaafdhg",
                    "cjfhajagc",
                    "fhfifchf",
                    "djdihjjdiibhaegfehc",
                    "cgecbjhdjh",
                    "acbfbccbiehjhjahjbic",
                    "hhgbjdcidhdhdcijfdg",
                    "jdcjaichdbiaefe",
                    "bbdgfafiehc",
                    "acdaajjfjcaeahcddage",
                    "edbbehfdiddc",
                    "ghabih",
                    "ba",
                    "dhjhdbieifabebajf",
                    "cccdhicdbdf",
                    "jfgdddh",
                    "chhjg",
                    "fgheacjabhiiihefbji",
                    "jhcfbgbbgfe",
                    "jgffhddba",
                    "jibffbeijfcif",
                    "dcghgfddfhj",
                    "gaggjcdcaaf",
                    "igjiaajgcjhbeeebdf",
                    "gejibddcbj",
                    "jcaaebfebjh",
                    "jeedhcejgbegide",
                    "jebfehdfdibg",
                    "hdefhaia",
                    "eb",
                    "fjchhceceijfi",
                    "egabjjcdbegfeabc",
                    "gbiagfgfg",
                    "gfajge",
                    "iii",
                    "dccjjeajd",
                    "aihegdchjef",
                    "gdaiegffaih",
                    "haacjdcfheheeejefg",
                    "bcde",
                    "agcbagagadfjfdghdbb",
                    "ejjiageabfh",
                    "gichcecbfd",
                    "iacajf",
                    "fdfeaajhccbhb",
                    "aecc",
                    "da",
                    "ecgcbdggffjg",
                    "biebjjhfidb",
                    "dadfcigjif",
                    "badafaheg",
                    "gddadiifadaa",
                    "echjgchihgadb",
                    "bhgaghbihef",
                    "cjihigiiibdc",
                    "bdheddceciaib",
                    "ggegccjahfbib",
                    "jfabidhcjefcfd",
                    "iiiadhfhaig",
                    "geedcbchc",
                    "bafhbicaeidjg",
                    "hfgiefdcgjjieejii",
                    "hgiiigfcididicgaijde",
                    "ihdbeahaehgd",
                    "difgjfagjfidcdbggce",
                    "ajdfddjbbdjjb",
                    "iccabdaahhgcdejf",
                    "gichhgejcgddcgbij",
                    "jjea",
                    "gcigbjhbaadjhi",
                    "jjeeefibachiddid",
                    "hjbehbeic",
                    "adibfgfdgfgghgbggaa",
                    "biggeedhffd",
                    "hffdaaeidhfjgj",
                    "ige",
                    "ichijijc",
                    "bhjh",
                    "bifeidf",
                    "hcgd",
                    "jfbdabjbcadjgahgjd",
                    "fhghdhfahibcbieiab",
                    "gcjijfbiigiegb",
                    "ibgabbhbijadhgib",
                    "djadidiihhdfhiabb",
                    "badefeccfjgca",
                    "edehccejiajcb",
                    "adjf",
                    "afcefdjajhjhddffbjb",
                    "biejjg",
                    "ffjfhieaebhbiag",
                    "gaegidbb",
                    "jaahhjfca",
                    "egg",
                    "jeeaaffch",
                    "bjaaafccjiii",
                    "gcghehg",
                    "egdibghgbhicdfdcicif",
                    "jidaafdbhggfea",
                    "daceegcdfbbbehejdgej",
                    "jdbjcaad",
                    "aihf",
                    "fhgahbafcd",
                    "bgcdcdejeiefdggfhha",
                    "ccafhij",
                    "hdahgjieaacabfa",
                    "hgjeajaacfce",
                    "jhejhibcbdacgjbjhbe",
                    "hajgigd",
                    "aaid",
                    "fbjhbd",
                    "eaddhgedigbffgbhcc",
                    "diiiabffdifheaaahe",
                    "cifigegjbibihd",
                    "ahhiffjfff",
                    "eebhji",
                    "cidjigijdaghhcjic"};
    }
}