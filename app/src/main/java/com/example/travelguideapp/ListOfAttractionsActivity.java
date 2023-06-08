package com.example.travelguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class ListOfAttractionsActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;
    private Button tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_attractions);

        textView = findViewById(R.id.textView5);
        User user = getIntent().getParcelableExtra("user");
        textView.setText("Здравствуйте, " + user.getName() + "!");


        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Эйфелева башня", "Эйфелева башня — металлическая башня в центре Парижа, самая узнаваемая его архитектурная достопримечательность. Названа в честь главного конструктора Гюстава Эйфеля; сам Эйфель называл её просто «300-метровой башней» (tour de 300 mètres). Башня, впоследствии ставшая символом Парижа, была построена в 1889 году и первоначально задумывалась как временное сооружение, служившее входной аркой парижской Всемирной выставки 1889 года.", new Point(48.858247, 2.294494), 11.30, 0.125));
        attractions.add(new Attraction("Лувр", "Музей Лувра — один из крупнейших и самый популярный художественный музей мира. Музей расположен в центре Парижа, на правом берегу Сены, на улице Риволи, в 1-м округе столицы. В 2018 году число посетителей Лувра превысило 10 млн человек, что является рекордом. Здание музея — старинный королевский дворец (Palais du Louvre). Конная статуя Людовика XIV обозначает точку начала так называемой исторической оси Парижа.", "9:00 - 18:00", new Point(48.860640, 2.337618), 17.00, 0.25));
        attractions.add(new Attraction("Собор Парижской Богоматери", "Собор Парижской Богоматери — католический храм в центре Парижа, один из символов французской столицы. Кафедральный собор архиепархии Парижа. Расположен в восточной части острова Сите, в 4-м городском округе, на месте первой христианской церкви Парижа — базилики Святого Стефана, построенной, в свою очередь, на фундаменте галло-римского храма Юпитера. Готический собор возводился по инициативе парижского епископа Мориса де Сюлли в период 1163—1345 годов.", new Point(48.853041, 2.349679), 19.00, 0.05));
        attractions.add(new Attraction("Монмартр", "Монмартр — название 130-метрового холма на севере Парижа и древнеримского поселения. В 1860 году район стал частью города, дав название 18-му муниципальному округу. Холм Монмартр — высочайшая точка французской столицы. На его вершине находится базилика Сакре-Кёр, одна из самых популярных достопримечательностей города. На Монмартр можно взойти по знаменитым лестницам или подняться с помощью фуникулёра.", new Point(48.867213, 2.344082), 0.0, 0.125));
        attractions.add(new Attraction("Дворец Инвалидов", "Дворец инвалидов — архитектурный памятник, строительство которого было начато по приказу Людовика XIV от 24 февраля 1670 года как дом призрения заслуженных армейских ветеранов («инвалидов войны»). Это был один из первых инвалидных домов в Европе. Сегодня он по-прежнему принимает инвалидов, а также в нём располагаются несколько музеев и некрополь военных.", "10:00 - 18:00", new Point(48.857014, 2.312876), 15.00, 0.1));
        attractions.add(new Attraction("Марсово поле", "Марсово поле — общественный парк в 7-м округе Парижа, между Эйфелевой башней с северо-запада и Военной школой с юго-востока. Находится в западной части города, на левом берегу Сены.", new Point(48.856567, 2.297212), 0.0, 0.1));
        attractions.add(new Attraction("Триумфальная арка", "Триумфальная арка — монумент в 8-м округе Парижа на площади Шарля де Голля (Звезды), возведённый в 1806—1836 годах по проекту архитектора французского ампира Жана-Франсуа Шальгрена. Проект арки «в древнеримском стиле» был разработан по распоряжению Наполеона Бонапарта в ознаменование побед его «Великой армии». За основу была взята композиция однопролётной Триумфальной арки Тита на римском Форуме.", new Point(48.873799, 2.295117), 0.0, 0.02));
        attractions.add(new Attraction("Елисейские Поля", "Елисейские Поля, или Шанз-Элизе — центральная улица Парижа, одна из главных магистралей VIII округа французской столицы. Елисейские Поля простираются от площади Согласия (Конкорд) до Триумфальной арки. Длина — 1915 м, ширина — 71 м.", new Point(48.869388, 2.308625), 0.0, 0.125));
        attractions.add(new Attraction("Площадь Бастилии", "Площадь Бастилии  — площадь в Париже, обязанная своим названием крепости Бастилия, разрушенной во время Великой французской революции. Находится на границе 3, 4, 11 и 12-го округов. Является местом пересечения более чем десяти улиц и бульваров.", new Point(48.853183, 2.369199), 0.0, 0.1));
        attractions.add(new Attraction("Музей Орсе", "Орсе, или Орсэ, музей Орсе  — музей изобразительных искусств, находится в Париже на левом берегу Сены, одно из крупнейших в мире собраний европейской живописи и скульптуры периода 1850—1910 гг. Третий по популярности музей Парижа и десятый — в мире. Основу коллекции составляют работы импрессионистов и постимпрессионистов. Коллекция богата также произведениями декоративного искусства в стиле ар-нуво, фотографиями и предметами архитектуры.", "9:30 - 18:00", new Point(48.859981, 2.326516), 16.00, 0.2));

        listView = findViewById(R.id.listView);
        ArrayAdapter<Attraction> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, attractions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(ListOfAttractionsActivity.this, AttractionActivity.class);
                intent.putExtra("attraction", attractions.get(position));
                startActivity(intent);
            }
        });

        tour = findViewById(R.id.tourButton);

        tour.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfAttractionsActivity.this, TourActivity.class);
            intent.putParcelableArrayListExtra("attractions", attractions);
            startActivity(intent);
        });
    }
}
