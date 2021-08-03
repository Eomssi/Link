package com.example.link

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class SubInfo : AppCompatActivity() {

    //위젯 변수 선언
    lateinit var subname: TextView
    lateinit var textLink: TextView
    lateinit var textCategory: TextView
    lateinit var textIntro: TextView
    lateinit var textPayment: TextView
    lateinit var subLogo: CircleImageView
    lateinit var subImage1: ImageView
    lateinit var subImage2: ImageView

    lateinit var btnSubadd: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_info)



        //화면 위 버튼 연결
        btnSubadd = findViewById(R.id.btnSubadd)

        //화면 위젯 연결
        subLogo = findViewById(R.id.subLogo)
        subname = findViewById(R.id.subname)
        textLink = findViewById(R.id.textLink)
        textCategory = findViewById(R.id.textCategory)
        textIntro = findViewById(R.id.textIntro)
        textPayment = findViewById(R.id.textPayment)
        subImage1 = findViewById(R.id.subImage1)
        subImage2 = findViewById(R.id.subImage2)

        //구독 서비스 액티비티에서 전달 된 데이터 받음
        val intent = intent
        var str_name = intent.getStringExtra("intent_name").toString()  //str_name: 구독리스트에서 클릭한 브랜드 이름

        //서비스 추가 버튼 클릭 시 SubAdd 액티비티로 이동
        btnSubadd.setOnClickListener {
            var intent = Intent(this, SubAdd::class.java)
            intent.putExtra("intent_name",str_name)
            startActivity(intent)
        }

        //구독 서비스 액티비티에서 받은 데이터에 따른 이미지(로고, 상세 이미지) 및 텍스트 출력
        when{
            str_name == "네이버 플러스" -> {
                subLogo.setImageResource(R.drawable.naverplus_logo)
                subImage1.setImageResource(R.drawable.naverplus1)
                subImage2.setImageResource(R.drawable.naverplus2)
                subname.text = str_name
                textLink.text = "https://nid.naver.com/membership/join "
                textCategory.text = "쇼핑"
                textIntro.text = "쇼핑할 때마다 최대 5% 적립이 되는 네이버 플러스를 이용해 보세요. 매월 디지털 서비스 이용권을 제공하는 것은 물론이며, 가족, 친구를 무료로 초대해 멤버십 혜택을 공유할 수 있습니다. 이달의 쇼핑 항목에서는 추가로 3% 적립이 가능합니다."
                textPayment.text = "첫 달은 무료, 그 이후 월간 이용권 4,900원"
            }
            str_name == "넷플릭스" -> {
                subLogo.setImageResource(R.drawable.netflix_logo)
                subImage1.setImageResource(R.drawable.netflix1)
                subImage2.setImageResource(R.drawable.netflix2)
                subname.text = str_name
                textLink.text = "https://www.netflix.com/kr/"
                textCategory.text = "OTT"
                textIntro.text = "넷플릭스는 TV 프로그램, 영화, 애니메이션, 다큐멘터리 등 다양한 콘텐츠를 인터넷 연결이 가능한 수천 종의 디바이스에서 시청할 수 있는 스트리밍 서비스입니다.\n저렴한 월 요금으로 일체의 광고 없이 원하는 시간에 원하는 만큼 즐길 수 있습니다. 무궁무진한 콘텐츠가 준비되어 있으며 매주 새로운 TV 프로그램과 영화가 제공됩니다. "
                textPayment.text = "Basic: 9,500원/월\n" +
                        "Standard: 12,000원/월\n" +
                        "Premium: 14,500원/월"
            }
            str_name == "노션" -> {
                subLogo.setImageResource(R.drawable.notion_logo)
                subImage1.setImageResource(R.drawable.notion1)
                subImage2.setImageResource(R.drawable.notion2)
                subname.text = str_name
                textLink.text = "https://www.notion.so/ko-kr"
                textCategory.text = "프로그램"
                textIntro.text = "노션은 메모, 업무, 위키 및 데이터 베이스를 한 곳에서 처리 할 수 있는 도구 입니다. 이미지, 체크박스, 북마크 기능, 코드 입력창 등 20개 이상의 풍부한 블록타입을 지원하며, Mac, Windows 그리고 웹 브라우저 동기화를 통해 어디서든 노션에 접근할 수 있습니다."
                textPayment.text = "개인 프로 요금제: US\$4/연간, US\$5/년\n" +
                        "팀 요금제: US\$8/연간, US\$10/월\n"
            }
            str_name == "닌텐도 스위치 온라인" -> {
                subLogo.setImageResource(R.drawable.nintendoswitch_logo)
                subImage1.setImageResource(R.drawable.nintendoswitch1)
                subImage2.setImageResource(R.drawable.nintendoswitch2)
                subname.text = str_name
                textLink.text = "https://www.nintendo.co.kr/switch/onlineservice/pricing/"
                textCategory.text = "게임"
                textIntro.text = "닌텐도 스위치는 플레이 장면에 맞추어 형태를 바꾸는 게임기로, 언제 어디서나 마음가는대로 자유로운 스타일로 게임을 즐길 수 있습니다.\n「닌텐도 온라인 스토어」에서 이용권을 구입하여 Nintendo Switch 본체의 「닌텐도 e숍」에 등록용 번호를 입력하면 서비스 가입이 가능합니다. 또는 한국닌텐도 고객지원 홈페이지와 일부 오프라인 판매처에서 개인 플랜 12개월(365일간) 이용권을 구입할 수 있습니다. 이용권에 기재된 번호를 닌텐도 e숍에 입력하면 이용할 수 있습니다."
                textPayment.text = "개인플랜(1어카운트)\n" +
                        "1개월: 4,900원\n" +
                        "3개월: 9,900원\n" +
                        "12개월: 19,900원\n" +
                        "패밀리플랜(8어카운트)\n" +
                        "12개월: 37,900원"
            }
            str_name == "드롭박스" -> {
                subLogo.setImageResource(R.drawable.dropbox_logo)
                subImage1.setImageResource(R.drawable.dropbox1)
                subImage2.setImageResource(R.drawable.dropbox2)
                subname.text = str_name
                textLink.text = "https://www.dropbox.com/ko/"
                textCategory.text = "프로그램"
                textIntro.text = "드롭박스를 사용하면 파일을 클라우드에 업로드하거나 전송하고 누구와든 공유할 수 있습니다. 문서, 사진, 동영상 및 기타 파일을 클라우드 스토리지에 백업하고 동기화하며 어디에서나 모든 장치에 액세스 하세요. 또한 고급 공유 기능으로 파일을 크기에 관계없이 간편하게 공유하고 친구나 가족, 동료에게 전송하세요."
                textPayment.text = "Plus: US\$11.99/월\n" +
                        "Family: US\$19.99/월"
            }
            str_name == "로켓와우" -> {
                subLogo.setImageResource(R.drawable.rocketwow_logo)
                subImage1.setImageResource(R.drawable.rocketwow1)
                subImage2.setImageResource(R.drawable.rocketwow2)
                subname.text = str_name
                textLink.text = "https://www.coupang.com/ "
                textCategory.text = "쇼핑"
                textIntro.text = "쿠팡 로켓배송 상품에서 금액에 상관 없이 모두 무료배송이 됩니다. 로켓배송 상품 반품시 30일 이내에 무료 반품이 가능하며, 첫이용 30일 동안 쿠페이 머니로 결제하면 최대 5% 캐시가 적립됩니다. 이름에 걸맞게 낮에 주문을 하면 다음날 새벽 배송, 오전에 주문하면 당일 배송이 가능합니다."
                textPayment.text = "월 회비 2,900원"
            }
            str_name == "리디 셀렉트" -> {
                subLogo.setImageResource(R.drawable.ridi_logo)
                subImage1.setImageResource(R.drawable.ridi1)
                subImage2.setImageResource(R.drawable.ridi2)
                subname.text = str_name
                textLink.text = "https://select.ridibooks.com/home"
                textCategory.text = "독서&학습"
                textIntro.text = "전자책 서점 <리디북스>에서 제공하는 전자책 월정액 서비스입니다. 베스트셀러부터 프리미엄 아티클까지 모두 무제한으로 이용해보세요!"
                textPayment.text = "월 9,900원 (부가가치세 별도)"
            }
            str_name == "멜론" -> {
                subLogo.setImageResource(R.drawable.melon_logo)
                subImage1.setImageResource(R.drawable.melon1)
                subImage2.setImageResource(R.drawable.melon2)
                subname.text = str_name
                textLink.text = "https://www.melon.com/"
                textCategory.text = "음악"
                textIntro.text = "국내 최다 4,000만곡 보유, No.1 뮤직 플랫폼 멜론! 다양한 멜론 차트부터 나를 아는 똑똑한 음악 추천까지 제공됩니다. 개인의 청력 특성에 맞춘 스마트 EQ 설정 및 장르별 기본EQ를 제공합니다. 또한 카카오 로그인이 가능하며 기본 이모티콘을 지원합니다."
                textPayment.text = "스트리밍 플러스 정기결제: 10,900원/월\n" +
                        "스트리밍 플러스 티켓 30일: 11,400원\n" +
                        "Hi-Fi 스트리밍클럽 정기결제: 12,000원/월\n" +
                        "스트리밍클럽 정기결제: 7,900원/월\n" +
                        "스트리밍 티켓 30일: 8,900원\n" +
                        "모바일 스트리밍클럽 정기결제: 6.900원/월"
            }
            str_name == "밀리의 서재" -> {
                subLogo.setImageResource(R.drawable.millie_logo)
                subImage1.setImageResource(R.drawable.millie1)
                subImage2.setImageResource(R.drawable.millie2)
                subname.text = str_name
                textLink.text = "https://www.millie.co.kr/"
                textCategory.text = "독서&학습"
                textIntro.text = "매달 3,000권 이상을 업데이트 하는 전자책 월정액 서비스입니다. 전자책, 오디오북, 판타지 무협 로맨스까지 10만권을 무제한으로 이용할 수 있습니다."
                textPayment.text = "월 9,900원(부가가치세 별도)"
            }
            str_name == "바이브" -> {
                subLogo.setImageResource(R.drawable.vibe_logo)
                subImage1.setImageResource(R.drawable.vibe1)
                subImage2.setImageResource(R.drawable.vibe2)
                subname.text = str_name
                textLink.text = "https://vibe.naver.com"
                textCategory.text = "음악"
                textIntro.text = "네이버에서 출시한 음악 스트리밍 서비스입니다, 좋아하는 음악은 물론 좋아할 음악까지 들려주는 취향 저격 뮤직! 네이버플러스 멤버십 12개월, 네이버 NOW 다시보기, 노래방기능을 지원합니다."
                textPayment.text = "<무제한 듣기>\n" +
                        "1년 약정 멤버십: 6,900원/월\n" +
                        "월간 멤버십: 8,500원/월\n" +
                        "대학생 멤버십: 5,900원/월\n" +
                        "연간 멤버십(선결제): 82,800원/년"
            }
            str_name == "벅스" -> {
                subLogo.setImageResource(R.drawable.bugs_logo)
                subImage1.setImageResource(R.drawable.bugs1)
                subImage2.setImageResource(R.drawable.bugs2)
                subname.text = str_name
                textLink.text = "https://music.bugs.co.kr/"
                textCategory.text = "음악"
                textIntro.text = "음질에 놀라고 예쁨에 반하다! 국내 최대 4천만곡으로 최신 인기곡과 내 맘에 쏙 드는 음악추천! 벅스에서는 24/7 기능을 제공합니다. 24/7은 노동요가 필요할 때, 뭘 들을 지 고민될 때, 언제든지 좋은 곡을 자체적으로 골라 여러분께 들려줍니다."
                textPayment.text = "무제한 듣기 + 오프라인 재생: 10,900원/월\n" +
                        "무제한 듣기: 7,900원/월"
            }
            str_name == "스마일클럽" -> {
                subLogo.setImageResource(R.drawable.smileclub_logo)
                subImage1.setImageResource(R.drawable.smileclub1)
                subImage2.setImageResource(R.drawable.smileclub2)
                subname.text = str_name
                textLink.text = "https://corners.gmarket.co.kr/SmileClub?Jaehuid=200011048&cosemkid=go16169965266217695&gclid=CjwKCAjwuvmHBhAxEiwAWAYj%2DEexc8oUJMAL2yIPsm0WUWyQG3PVjpRB%5FiYCdbKEYM%5FCmktnXT9OGBoCNLgQAvD%5FBwE"
                textCategory.text = "쇼핑"
                textIntro.text = "G마켓, 옥션, G9 어디에서나 최고의 혜택을 받는쇼핑 멤버십입니다. 가입 즉시 37,000원의 스마일 캐시를 드리며 무료 배송, 할인 쿠폰 등을 제공하고 있습니다. 결제 시 1%의 스마일 페이가 적립됩니다. 스마일 카드를 쓸 때마다 자동으로 스탬프 적립이 되고 리워드까지 드립니다."
                textPayment.text = "연회비 3만원"
            }
            str_name == "스포티파이" -> {
                subLogo.setImageResource(R.drawable.spotify_logo)
                subImage1.setImageResource(R.drawable.spotify1)
                subImage2.setImageResource(R.drawable.spotify2)
                subname.text = str_name
                textLink.text = "https://www.spotify.com/kr-ko/premium"
                textCategory.text = "음악"
                textIntro.text = "다\u2060양\u2060한 해\u2060외 히\u2060트\u2060곡\u2060과 국\u2060내 인\u2060기 음\u2060악\u2060을 제공하는 음악 스트리밍 서비스입니다. 데일리 믹스로 즐기는 맞춤형 음악, 오프라인으로 즐기는 음악, 기분에 맞는 새로운 음악 재생 및 추천 서비스를 제공합니다."
                textPayment.text = "첫 달은 무료\n" +
                        "개인: 10,900원/월\n" +
                        "듀오: 16,350원/월"
            }
            str_name == "슬랙" -> {
                subLogo.setImageResource(R.drawable.slack_logo)
                subImage1.setImageResource(R.drawable.slack1)
                subImage2.setImageResource(R.drawable.slack2)
                subname.text = str_name
                textLink.text = "https://slack.com/intl/ko-kr/"
                textCategory.text = "프로그램"
                textIntro.text = "대기업이든 중소기업이든, 슬랙은 업무를 더 많이 수행할 수 있도록 팀 커뮤니케이션과 협업을 한곳으로 모아줍니다. 필요한 정보, 알맞은 사람, 대화 및 도구를 한 곳으로 모아서 해야 할 일 목록을 지워나가고 프로젝트를 진행시키세요. 슬랙은 어떤 기기에서든 사용할 수 있어 사무실에 있든 이동 중이든 팀과 작업을 찾고 액세스할 수 있습니다."
                textPayment.text = "Pro : US\$8 / 월\n" +
                        "Business : US\$15 / 월\n"
            }
            str_name == "시즌" -> {
                subLogo.setImageResource(R.drawable.seezn_logo)
                subImage1.setImageResource(R.drawable.seezn1)
                subImage2.setImageResource(R.drawable.seezn2)
                subname.text = str_name
                textLink.text = "https://www.seezntv.com/"
                textCategory.text = "OTT"
                textIntro.text = "즐거움을 다 본다! Seezn! 최신 영화, 인기 드라마, 예능, 프로야구까지 다양한 콘텐프를 즐겁게 즐기는 seezn! 시즌에서는 아티스트별 특화 페이지가 있습니다. 이곳에서는 작품활동부터 수상이력이 담긴 히스토리, 응원의 댓글 한 마디까지. 내 최애 아티스트의 모든 것을 한 눈에 확인할 수 있어요. 또한 마이시즌에서는 이달의 시청이력을 분석하는 ‘시즌 리포트’ 서비스를 제공합니다."
                textPayment.text = "시즌 Basic 월정액\n" +
                        "시즌 믹스 플러스[kt 모바일 고객 전용]: 12,000원 / 월\n" +
                        "시즌 믹스: 9,000원 / 월\n" +
                        "시즌 플레인 플러스[kt 모바일 고객 전용]: 8,000원 / 월\n" +
                        "시즌 플레인: 5,000원 / 월"
            }
            str_name == "쏘카" -> {
                subLogo.setImageResource(R.drawable.socar_logo)
                subImage1.setImageResource(R.drawable.socar1)
                subImage2.setImageResource(R.drawable.socar2)
                subname.text = str_name
                textLink.text = "https://www.socar.kr/ "
                textCategory.text = "라이프"
                textIntro.text = "24시간 언제나 원하는 곳에서 필요한 시간만큼 다양한 차종 중 하나를 선택하여 빌릴 수 있는 서비스입니다. 다양한 이벤트를 진행 중이며 홈페이지 내에서 제공해주는 할인 쿠폰으로 보다 저렴하게도 이용 가능합니다."
                textPayment.text = "대여요금은 차종, 지역/쏘카존, 요일/시간, 성수기/비성수기 등의 조건에 따른 탄력요금제로 운영되므로 예약 조건에 따라 달라질 수 있습니다. \n앱을 통해 확인해 주세요."
            }
            str_name == "아프리카 TV" -> {
                subLogo.setImageResource(R.drawable.afreecatv_logo)
                subImage1.setImageResource(R.drawable.afreecatv1)
                subImage2.setImageResource(R.drawable.afreecatv2)
                subname.text = str_name
                textLink.text = "https://afreecatv.com/"
                textCategory.text = "게임"
                textIntro.text = "더 이상 헤매지 마세요. 재미있는 방송/동영상은 아프리카 TV에 다 있습니다. 또한 생방송 중인 BJ와 채팅을 통해 실시간으로 소통할 수 있습니다. 지금 바로 최고화질 방송을 무료로 만나보세요."
                textPayment.text = "구독 자동결제 30일권: 3,300원/월"
            }
            str_name == "애플뮤직" -> {
                subLogo.setImageResource(R.drawable.applemusic_logo)
                subImage1.setImageResource(R.drawable.applemusic1)
                subImage2.setImageResource(R.drawable.applemusic2)
                subname.text = str_name
                textLink.text = "https://www.apple.com/kr/apple-music/"
                textCategory.text = "음악"
                textIntro.text = "Apple Music은 7천5백만 곡 이상을 들을 수 있는 스트리밍 서비스입니다. 오프라인에서 감상, 새로운 음악 맞춤 추천, 에디터들이 엄선한 플레이리스트, 독점 및 오리지널 콘텐츠를 제공합니다."
                textPayment.text = "개인: 8,900원/월\n" +
                        "가족: 13,500원/월"
            }
            str_name == "어도비 클라우드" -> {
                subLogo.setImageResource(R.drawable.adobecloud_logo)
                subImage1.setImageResource(R.drawable.adobecloud1)
                subImage2.setImageResource(R.drawable.adobecloud2)
                subname.text = str_name
                textLink.text = "https://www.adobe.com/kr/creativecloud.html?promoid=T6SQLS5G&mv=other"
                textCategory.text = "프로그램"
                textIntro.text = "Creative Cloud는 사진, 디자인, 영상, 웹, UX 작업에 필요한 20개 이상의 데스크탑 앱 및 모바일 앱과 다양한 서비스를 제공합니다. iPad에서 Photoshop을 사용하여 창의적인 아이디어를 자유롭게 표현하거나, Adobe Fresco를 사용하여 드로잉 및 페인팅하고 3D 및 AR용으로 디자인할 수 있습니다. 글로벌 크리에이티브 커뮤니티에 참여하여 더욱 멋진 작품을 만들어 보십시오."
                textPayment.text = "모든 앱: 62,000원/월\n" +
                        "다른 프로그램들은 홈페이지를 참고하세요."
            }
            str_name == "에버노트" -> {
                subLogo.setImageResource(R.drawable.evernote_logo)
                subImage1.setImageResource(R.drawable.evernote1)
                subImage2.setImageResource(R.drawable.evernote2)
                subname.text = str_name
                textLink.text = "https://evernote.com/intl/ko"
                textCategory.text = "프로그램"
                textIntro.text = "영감이 떠오를 때 아이디어를 포착하세요. 노트, 할 일, 일정을 함께 보관해 생활의 산만함을 줄이고, 사무실과 집에서, 그리고 이동 중에도 더 많은 일을 완수하세요."
                textPayment.text = "Personal: 6,000원/월\n" +
                        "Professional: 7,500원/월\n" +
                        "Teams: 15,000원/월"
            }
            str_name == "예스24 북클럽" -> {
                subLogo.setImageResource(R.drawable.yes24bookclub_logo)
                subImage1.setImageResource(R.drawable.yes24bookclub1)
                subImage2.setImageResource(R.drawable.yes24bookclub2)
                subname.text = str_name
                textLink.text = "http://bookclub.yes24.com/"
                textCategory.text = "독서&학습"
                textIntro.text = "예스24에서 선보인 전자책 월정액 서비스입니다. 매일 새로운 책을 업데이트! 1만권이 넘는 e-book을 무제한으로 접해보세요."
                textPayment.text = "스탠다드: 5,500원/월\n" +
                        "프리미엄: 7,700원/월\n" +
                        "북클럽 X FLO: 9,900원/월"
            }
            str_name == "왓챠" -> {
                subLogo.setImageResource(R.drawable.watcha_logo)
                subImage1.setImageResource(R.drawable.watcha1)
                subImage2.setImageResource(R.drawable.watcha2)
                subname.text = str_name
                textLink.text = "https://watcha.com"
                textCategory.text = "OTT"
                textIntro.text = "발견의 기쁨, 왓챠!\n" +
                        " 왓챠는 영화, 드라마, 예능, 다큐, 애니메이션까지 9만여 편의 작품을 무제한으로 감상할 수 있는 온라인 동영상 스트리밍 서비스입니다.\n"
                textPayment.text = "베이직: 7,900원/월\n" +
                        "프리미엄: 12,900원/월"
            }
            str_name == "웨이브" -> {
                subLogo.setImageResource(R.drawable.wavve_logo)
                subImage1.setImageResource(R.drawable.wavve1)
                subImage2.setImageResource(R.drawable.wavve2)
                subname.text = str_name
                textLink.text = "https://www.wavve.com"
                textCategory.text = "OTT"
                textIntro.text = "재미의 파도를 타다! wavve\n" +
                        ". KBS, MBC, SBS 등 100개 이상의 채널 해외드라마, 애니메이션 포함 방송 VOD 30만편, 영화 2만편(추가 결제 없는 월정액 영화 6천편)을 제공하는 동영상 스트리밍 서비스입니다.\n"
                textPayment.text = "Basic: 7,900원/월\n" +
                        "Standard: 10,900원/월\n" +
                        "Premium: 13,900원/월"
            }
            str_name == "윌라" -> {
                subLogo.setImageResource(R.drawable.welaaa_logo)
                subImage1.setImageResource(R.drawable.welaaa1)
                subImage2.setImageResource(R.drawable.welaaa2)
                subname.text = str_name
                textLink.text = "https://www.welaaa.com/"
                textCategory.text = "독서&학습"
                textIntro.text = "윌라 오디오북으로 귀깔나게 즐기다!\n" +
                        "최신 베스트셀러는 물론 분야별 전문 지식과 윌로 독점 콘텐츠 완독본을 전문 성우의 낭독으로 실감나게 즐겨보세요. "
                textPayment.text = "첫 달은 무료\n월 9,900원"
            }
            str_name == "유튜브 프리미엄" -> {
                subLogo.setImageResource(R.drawable.youtube_logo)
                subImage1.setImageResource(R.drawable.youtube1)
                subImage2.setImageResource(R.drawable.youtube2)
                subname.text = str_name
                textLink.text = "https://www.youtube.com/premium"
                textCategory.text = "OTT"
                textIntro.text = "유튜브 프리미엄을 결제하면 YouTube\u2060와 YouTube Music\u2060에\u2060서 광\u2060고 없\u2060는 감\u2060상, 오\u2060프\u2060라\u2060인 저\u2060장, 그\u2060리\u2060고 백\u2060그\u2060라\u2060운\u2060드 재\u2060생이 가능합니다. 화\u2060면\u2060을 끄\u2060거\u2060나 다\u2060른 앱\u2060을 사\u2060용\u2060하\u2060면\u2060서 광\u2060고 없\u2060이 동\u2060영\u2060상\u2060을 시\u2060청\u2060해 보\u2060세\u2060요."
                textPayment.text = "₩9,500/월 - 부가세 별도"
            }
            str_name == "지니뮤직" -> {
                subLogo.setImageResource(R.drawable.genie_logo)
                subImage1.setImageResource(R.drawable.genie1)
                subImage2.setImageResource(R.drawable.genie2)
                subname.text = str_name
                textLink.text = "www.genie.co.kr"
                textCategory.text = "음악"
                textIntro.text = "가격은 가볍게, 추천은 확실하게! 최저가로 즐기는 프리미어 사운드! KT에서 운영하는 음악 스트리밍 서비스입니다. 국내 최고 실시간 TOP 200 차트와 가장 다양한 이용권을 제공합니다."
                textPayment.text = "데이터 세이프 음악감상: 5,450원/월 (2개월간 50%)\n" +
                        "스마트 음악감상: 4,700원/월 (6개월간 36%)"
            }
            str_name == "트라이브" -> {
                subLogo.setImageResource(R.drawable.trive_logo)
                subImage1.setImageResource(R.drawable.trive1)
                subImage2.setImageResource(R.drawable.trive2)
                subname.text = str_name
                textLink.text = "https://thetrive.com/vehicles "
                textCategory.text = "라이프"
                textIntro.text = "중고차 구독 서비스로 매월 정해진 금액을 지불하고 일정 기간 자동차를 이용하는 서비스입니다. 보증금과 개인신용평가 없이 결제수단으로 신용카드만 있으면 이용 가능합니다. 계약은 1년 단위로 이뤄지지만 7개월 차부터는 중도해지 위약금 없이 해지/변경이 가능합니다. 현재 트라이브 구독서비스는 신청 코드를 발급 받으신분에 한해 구독 신청을 받고 있습니다."
                textPayment.text = "차종마다 가격 상이함."
            }
            str_name == "트위치" -> {
                subLogo.setImageResource(R.drawable.twitch_logo)
                subImage1.setImageResource(R.drawable.twitch1)
                subImage2.setImageResource(R.drawable.twitch2)
                subname.text = str_name
                textLink.text = "https://www.twitch.tv/"
                textCategory.text = "게임"
                textIntro.text = "여러분이 좋아하는 모든 콘텐츠가 준비되어 있습니다. 매일 전 세계의 모든 것을 플레이하고 방송하는 수백만의 고유한 스트리머가 있는 트위치에서는 원하는 것은 무엇이든 시청할 수 있습니다. 또한 스트리머의 생방송 채팅에서 실시간으로 대화할 수도 있습니다! 구독은 개별 채널 별로 이뤄집니다."
                textPayment.text = "채널 별 상이"
            }
            str_name == "티빙" -> {
                subLogo.setImageResource(R.drawable.tving_logo)
                subImage1.setImageResource(R.drawable.tving1)
                subImage2.setImageResource(R.drawable.tving2)
                subname.text = str_name
                textLink.text = "https://www.tving.com/main.do?retRef=Y&source=https://www.google.com/"
                textCategory.text = "OTT"
                textIntro.text = "티빙 오리지널부터 tvN, JTBC, Mnet, OCN 등 최신 인기 드라마와 예능, 독점 영화까지 지금 스트리밍하세요. 티빙은 스마트 TV, 컴퓨터, 스마트폰, 태블릿, 크롬캐스트와 같은 다양한 디바이스에서 시청 가능합니다. 또한 최대 4개 프로필로 가족, 친구와 함께 티빙을 즐길 수 있습니다."
                textPayment.text = "프리미엄: 13,900원/월\n" +
                        "스탠다드: 10,900원/월\n" +
                        "베이직: 7,900원/월"
            }
            str_name == "팟빵" -> {
                subLogo.setImageResource(R.drawable.podbbang_logo)
                subImage1.setImageResource(R.drawable.podbbang1)
                subImage2.setImageResource(R.drawable.podbbang2)
                subname.text = str_name
                textLink.text = "https://www.podbbang.com/magazines "
                textCategory.text = "라이프"
                textIntro.text = "국내 최대 팟캐스트, 오디오북, 강연, 오디오 콘텐츠인 팟빵에서 월간 오디오 매거진을 런칭했습니다. 다양한 에피소드를 들으며 많은 것을 배워가고 또 귀를 즐겁게 만들 수 있습니다. 혼자 걷고 있을 때나, 공부하고 있을 때나, 일하고 있을 때나 언제든 당신을 위한 BGM을 들려드립니다."
                textPayment.text = "월계약 9.900원, 연계약 105,000원"
            }
            str_name == "플레이스테이션 플러스" -> {
                subLogo.setImageResource(R.drawable.playstation_logo)
                subImage1.setImageResource(R.drawable.playstation1)
                subImage2.setImageResource(R.drawable.playstation2)
                subname.text = str_name
                textLink.text = "https://www.playstation.com/ko-kr/ps-plus/ "
                textCategory.text = "게임"
                textIntro.text = "회원이라면 매달 2개씩 확장되는 PS4 게임 컬렉션을 마음껏 즐길 수 있습니다. 블록버스터 히트작, 인디 젬 등을 비롯한 멀티플레이어 파티 게임으로 온라인 또는 집에서 가족 및 친구들과 함께 즐길 수 있는 컬렉션을 만들어 보세요. 모든 PlayStation Plus 구독자는 99,800원* 이상 금액의 가치를 지닌 3가지 게임을 지금 다운로드할 수 있습니다."
                textPayment.text = "12개월: 44,900원\n" +
                        "3개월: 18,800원\n" +
                        "1개월: 7,500원"
            }
            str_name == "플로" -> {
                subLogo.setImageResource(R.drawable.flo_logo)
                subImage1.setImageResource(R.drawable.flo1)
                subImage2.setImageResource(R.drawable.flo2)
                subname.text = str_name
                textLink.text = "http://www.music-flo.com"
                textCategory.text = "음악"
                textIntro.text = "다양한 음악 추천 서비스를 제공하는 음악 스트리밍 서비스입니다. 음악을 들을수록 나를 더 닮아가는 나만의 FLO(플로) 홈, 매일 열심히 음악을 듣고 나에게 맞는 홈을 만나보세요!"
                textPayment.text = "무제한 듣기 + 오프라인 재생: 10,900원/월\n" +
                        "무제한 듣기: 7,900원/월\n" +
                        "모바일 무제한 듣기: 6,900원/월"
            }

        }

    }


}