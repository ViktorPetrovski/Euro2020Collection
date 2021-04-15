package com.euro.sticker.gallery.data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE `AlbumEntity` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `stickers_count` INTEGER NOT NULL, " +
                    "PRIMARY KEY(`id`))"
        )
        database.execSQL(
            "INSERT INTO `AlbumEntity` (`id`, `name`, `stickers_count`) VALUES\n" +
                    "('1', 'Blue Cover - Panini UEFA Euro 2020 Tournament Edition', '654'),\n" +
                    "('2', 'Orange Cover - Panini UEFA Euro 2020 Tournament Edition', '678'),\n" +
                    "('3', 'Pearl Edition - Panini UEFA Euro 2020', '678')"
        )
        database.execSQL("ALTER TABLE StickerEntity ADD album_id INTEGER NOT NULL DEFAULT(1)")
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "INSERT INTO `StickerEntity` (`uid`, `name`, `number`, `amount`, `category_id`, `album_id`) VALUES\n" +
                    "('679', 'UEFA Euro 2020 Logo', '1', '0', '1', '2'),\n" +
                    "('680', 'European Championship Trophy', '2', '0', '1', '2'),\n" +
                    "('681', 'European Championship Trophy', '3', '0', '1', '2'),\n" +
                    "('682', '’Skillzy', '4', '0', '1', '2'),\n" +
                    "('683', 'Sign for an Equal Game - Respect', '5', '0', '1', '2'),\n" +
                    "('684', 'Panini Logo - Carlo Parola', '6', '0', '1', '2'),\n" +
                    "('685', 'Group A. Italy', '7', '0', '2', '2'),\n" +
                    "('686', 'Group A. Switzerland', '8', '0', '2', '2'),\n" +
                    "('687', 'Group A. Turkey', '9', '0', '2', '2'),\n" +
                    "('688', 'Group A. Wales', '10', '0', '2', '2'),\n" +
                    "('689', 'Logo Italy', '11', '0', '3', '2'),\n" +
                    "('690', 'Gianluigi Donnarumma', '12', '0', '3', '2'),\n" +
                    "('691', 'Salvatore Sirigu', '13', '0', '3', '2'),\n" +
                    "('692', 'Francesco Acerbi', '14', '0', '3', '2'),\n" +
                    "('693', 'Alessandro Bastoni', '15', '0', '3', '2'),\n" +
                    "('694', 'Leonardo Bonucci', '16', '0', '3', '2'),\n" +
                    "('695', 'Giorgio Chiellini', '17', '0', '3', '2'),\n" +
                    "('696', 'Emerson', '18', '0', '3', '2'),\n" +
                    "('697', 'Alessandro Florenzi', '19', '0', '3', '2'),\n" +
                    "('698', 'Nicolo Barella', '20', '0', '3', '2'),\n" +
                    "('699', 'Jorginho', '21', '0', '3', '2'),\n" +
                    "('700', 'Manuel Locatelli', '22', '0', '3', '2'),\n" +
                    "('701', 'Lorenzo Pellegrini', '23', '0', '3', '2'),\n" +
                    "('702', 'Marco Verratti', '24', '0', '3', '2'),\n" +
                    "('703', 'Andrea Belotti', '25', '0', '3', '2'),\n" +
                    "('704', 'Domenico Berardi', '26', '0', '3', '2'),\n" +
                    "('705', 'Federico Bernardeschi', '27', '0', '3', '2'),\n" +
                    "('706', 'Federico Chiesa', '28', '0', '3', '2'),\n" +
                    "('707', 'Ciro Immobile', '29', '0', '3', '2'),\n" +
                    "('708', 'Lorenzo Insigne', '30', '0', '3', '2'),\n" +
                    "('709', 'Moise Kean', '31', '0', '3', '2'),\n" +
                    "('710', 'Gianluigi Donnarumma / Franceso Acerbi', '32', '0', '3', '2'),\n" +
                    "('711', 'Leonardo Bonucci / Emerson', '33', '0', '3', '2'),\n" +
                    "('712', 'Alessandro Florenzi / Nicolo Barella', '34', '0', '3', '2'),\n" +
                    "('713', 'Manuel Locatelli / Jorginho', '35', '0', '3', '2'),\n" +
                    "('714', 'Ciro Immobile / Lorenzo Insigne', '36', '0', '3', '2'),\n" +
                    "('715', 'Andrea Belotti / Federico Chiesa', '37', '0', '3', '2'),\n" +
                    "('716', 'Yann Sommer / Manuel Akanji', '38', '0', '4', '2'),\n" +
                    "('717', 'Nico Elvedi / Ricardo Rodríguez', '39', '0', '4', '2'),\n" +
                    "('718', 'Remo Freuler / Xherdan Shaqiri', '40', '0', '4', '2'),\n" +
                    "('719', 'Djibril Sow / Granit Xhaka', '41', '0', '4', '2'),\n" +
                    "('720', 'Steven Zuber / Breel Embolo', '42', '0', '4', '2'),\n" +
                    "('721', 'Admir Mehmedi / Haris Seferović', '43', '0', '4', '2'),\n" +
                    "('722', 'Logo Switzerland', '44', '0', '4', '2'),\n" +
                    "('723', 'Yann Sommer', '45', '0', '4', '2'),\n" +
                    "('724', 'Yvon Mvogo', '46', '0', '4', '2'),\n" +
                    "('725', 'Manuel Akanji', '47', '0', '4', '2'),\n" +
                    "('726', 'Nico Elvedi', '48', '0', '4', '2'),\n" +
                    "('727', 'Kevin Mbabu', '49', '0', '4', '2'),\n" +
                    "('728', 'Ricardo Rodríguez', '50', '0', '4', '2'),\n" +
                    "('729', 'Fabian Schär', '51', '0', '4', '2'),\n" +
                    "('730', 'Silvan Widmer', '52', '0', '4', '2'),\n" +
                    "('731', 'Edimilson Fernandes', '53', '0', '4', '2'),\n" +
                    "('732', 'Remo Freuler', '54', '0', '4', '2'),\n" +
                    "('733', 'Xherdan Shaqiri', '55', '0', '4', '2'),\n" +
                    "('734', 'Djibril Sow', '56', '0', '4', '2'),\n" +
                    "('735', 'Renato Steffen', '57', '0', '4', '2'),\n" +
                    "('736', 'Granit Xhaka', '58', '0', '4', '2'),\n" +
                    "('737', 'Denis Zakaria', '59', '0', '4', '2'),\n" +
                    "('738', 'Steven Zuber', '60', '0', '4', '2'),\n" +
                    "('739', 'Breel Embolo', '61', '0', '4', '2'),\n" +
                    "('740', 'Mario Gavranović', '62', '0', '4', '2'),\n" +
                    "('741', 'Admir Mehmedi', '63', '0', '4', '2'),\n" +
                    "('742', 'Haris Seferović', '64', '0', '4', '2'),\n" +
                    "('743', 'Logo Turkey', '65', '0', '5', '2'),\n" +
                    "('744', 'Mert Günok', '66', '0', '5', '2'),\n" +
                    "('745', 'Uğurcan Çakır', '67', '0', '5', '2'),\n" +
                    "('746', 'Kaan Ayhan', '68', '0', '5', '2'),\n" +
                    "('747', 'Zeki Çelik', '69', '0', '5', '2'),\n" +
                    "('748', 'Merih Demiral', '70', '0', '5', '2'),\n" +
                    "('749', 'Ozan Kabak', '71', '0', '5', '2'),\n" +
                    "('750', 'Umut Meraş', '72', '0', '5', '2'),\n" +
                    "('751', 'Nazim Sangaré', '73', '0', '5', '2'),\n" +
                    "('752', 'Çağlar Söyüncü', '74', '0', '5', '2'),\n" +
                    "('753', 'Hakan Çalhanoğlu', '75', '0', '5', '2'),\n" +
                    "('754', 'Irfan Can Kahveci', '76', '0', '5', '2'),\n" +
                    "('755', 'Mahmut Tekdemir', '77', '0', '5', '2'),\n" +
                    "('756', 'Ozan Tufan', '78', '0', '5', '2'),\n" +
                    "('757', 'Cengiz Ünder', '79', '0', '5', '2'),\n" +
                    "('758', 'Yusuf Yazici', '80', '0', '5', '2'),\n" +
                    "('759', 'Okay Yokuşlu', '81', '0', '5', '2'),\n" +
                    "('760', 'Kenan Karaman', '82', '0', '5', '2'),\n" +
                    "('761', 'Cenk Tosun', '83', '0', '5', '2'),\n" +
                    "('762', 'Enes Ünal', '84', '0', '5', '2'),\n" +
                    "('763', 'Burak Yilmaz', '85', '0', '5', '2'),\n" +
                    "('764', 'Mert Günok / Zeki Çelik', '86', '0', '5', '2'),\n" +
                    "('765', 'Merih Demiral / Ozan Kabak', '87', '0', '5', '2'),\n" +
                    "('766', 'Umut Meraş / Çağlar Söyüncü', '88', '0', '5', '2'),\n" +
                    "('767', 'Hakan Çalhanoğlu / Mahmut Tekdemir', '89', '0', '5', '2'),\n" +
                    "('768', 'Ozan Tufan / Cengiz Ünder', '90', '0', '5', '2'),\n" +
                    "('769', 'Kenan Karaman / Burak Yilmaz', '91', '0', '5', '2'),\n" +
                    "('770', 'Wayne Hennessey / Ben Davies', '92', '0', '6', '2'),\n" +
                    "('771', 'Chris Mepham / Connor Roberts', '93', '0', '6', '2'),\n" +
                    "('772', 'Joe Rodon / Ethan Ampadu', '94', '0', '6', '2'),\n" +
                    "('773', 'Daniel James / Joe Morrell', '95', '0', '6', '2'),\n" +
                    "('774', 'Aaron Ramsey / Harry Wilson', '96', '0', '6', '2'),\n" +
                    "('775', 'Gareth Bale / Kieffer Moore', '97', '0', '6', '2'),\n" +
                    "('776', 'Logo Wales', '98', '0', '6', '2'),\n" +
                    "('777', 'Wayne Hennessey', '99', '0', '6', '2'),\n" +
                    "('778', 'Danny Ward', '100', '0', '6', '2'),\n" +
                    "('779', 'Ben Davies', '101', '0', '6', '2'),\n" +
                    "('780', 'Chris Gunter', '102', '0', '6', '2'),\n" +
                    "('781', 'Tom Lockyer', '103', '0', '6', '2'),\n" +
                    "('782', 'Chris Mepham', '104', '0', '6', '2'),\n" +
                    "('783', 'Connor Roberts', '105', '0', '6', '2'),\n" +
                    "('784', 'Joe Rodon', '106', '0', '6', '2'),\n" +
                    "('785', 'Neco Williams', '107', '0', '6', '2'),\n" +
                    "('786', 'Joe Allen', '108', '0', '6', '2'),\n" +
                    "('787', 'Ethan Ampadu', '109', '0', '6', '2'),\n" +
                    "('788', 'David Brooks', '110', '0', '6', '2'),\n" +
                    "('789', 'Daniel James', '111', '0', '6', '2'),\n" +
                    "('790', 'Joe Morrell', '112', '0', '6', '2'),\n" +
                    "('791', 'Aaron Ramsey', '113', '0', '6', '2'),\n" +
                    "('792', 'Jonathan Williams', '114', '0', '6', '2'),\n" +
                    "('793', 'Harry Wilson', '115', '0', '6', '2'),\n" +
                    "('794', 'Gareth Bale', '116', '0', '6', '2'),\n" +
                    "('795', 'Rabbi Matondo', '117', '0', '6', '2'),\n" +
                    "('796', 'Kieffer Moore', '118', '0', '6', '2'),\n" +
                    "('797', 'Group B. Belgium', '119', '0', '7', '2'),\n" +
                    "('798', 'Group B. Denmark', '120', '0', '7', '2'),\n" +
                    "('799', 'Group B. Finland', '121', '0', '7', '2'),\n" +
                    "('800', 'Group B. Russia', '122', '0', '7', '2'),\n" +
                    "('801', 'Logo Belgium', '123', '0', '8', '2'),\n" +
                    "('802', 'Thibaut Courtois', '124', '0', '8', '2'),\n" +
                    "('803', 'Simon Mignolet', '125', '0', '8', '2'),\n" +
                    "('804', 'Toby Alderweireld', '126', '0', '8', '2'),\n" +
                    "('805', 'Dedryck Boyata', '127', '0', '8', '2'),\n" +
                    "('806', 'Timothy Castagne', '128', '0', '8', '2'),\n" +
                    "('807', 'Jason Denayer', '129', '0', '8', '2'),\n" +
                    "('808', 'Thomas Meunier', '130', '0', '8', '2'),\n" +
                    "('809', 'Jan Vertonghen', '131', '0', '8', '2'),\n" +
                    "('810', 'Kevin de Bruyne', '132', '0', '8', '2'),\n" +
                    "('811', 'Dennis Praet', '133', '0', '8', '2'),\n" +
                    "('812', 'Youri Tielemans', '134', '0', '8', '2'),\n" +
                    "('813', 'Hans Vanaken', '135', '0', '8', '2'),\n" +
                    "('814', 'Axel Witsel', '136', '0', '8', '2'),\n" +
                    "('815', 'Michy Batshuayi', '137', '0', '8', '2'),\n" +
                    "('816', 'Yannick Carrasco', '138', '0', '8', '2'),\n" +
                    "('817', 'Jérémy Doku', '139', '0', '8', '2'),\n" +
                    "('818', 'Eden Hazard', '140', '0', '8', '2'),\n" +
                    "('819', 'Thorgan Hazard', '141', '0', '8', '2'),\n" +
                    "('820', 'Romelu Lukaku', '142', '0', '8', '2'),\n" +
                    "('821', 'Dries Mertens', '143', '0', '8', '2'),\n" +
                    "('822', 'Thibaut Courtois / Toby Alderweireld', '144', '0', '8', '2'),\n" +
                    "('823', 'Jason Denayer / Thomas Meunier', '145', '0', '8', '2'),\n" +
                    "('824', 'Jan Vertonghen / Kevin de Bruyne', '146', '0', '8', '2'),\n" +
                    "('825', 'Youri Tielemans / Axel Witsel', '147', '0', '8', '2'),\n" +
                    "('826', 'Eden Hazard / Thorgan Hazard', '148', '0', '8', '2'),\n" +
                    "('827', 'Romelu Lukaku / Dries Mertens', '149', '0', '8', '2'),\n" +
                    "('828', 'Kasper Schmeichel / Andreas Christensen', '150', '0', '9', '2'),\n" +
                    "('829', 'Mathias Jørgensen / Simon Kjær', '151', '0', '9', '2'),\n" +
                    "('830', 'Joakim Mæhle / Thomas Delaney', '152', '0', '9', '2'),\n" +
                    "('831', 'Christian Eriksen / Pierre Emile Højbjerg', '153', '0', '9', '2'),\n" +
                    "('832', 'Daniel Wass / Martin Braithwaite', '154', '0', '9', '2'),\n" +
                    "('833', 'Kasper Dolberg / Yussuf Poulsen', '155', '0', '9', '2'),\n" +
                    "('834', 'Logo Danmark', '156', '0', '9', '2'),\n" +
                    "('835', 'Kasper Schmeichel', '157', '0', '9', '2'),\n" +
                    "('836', 'Frederik Rønnow', '158', '0', '9', '2'),\n" +
                    "('837', 'Hamza Mendyl', '159', '0', '9', '2'),\n" +
                    "('838', 'Andreas Christensen', '160', '0', '9', '2'),\n" +
                    "('839', 'Simon Kjær', '161', '0', '9', '2'),\n" +
                    "('840', 'Joakim Mæhle', '162', '0', '9', '2'),\n" +
                    "('841', 'Jens Stryger Larsen', '163', '0', '9', '2'),\n" +
                    "('842', 'Jannik Vestergaard', '164', '0', '9', '2'),\n" +
                    "('843', 'Lucas Andersen', '165', '0', '9', '2'),\n" +
                    "('844', 'Thomas Delaney', '166', '0', '9', '2'),\n" +
                    "('845', 'Christian Eriksen', '167', '0', '9', '2'),\n" +
                    "('846', 'Pierre Emile Højbjerg', '168', '0', '9', '2'),\n" +
                    "('847', 'Mathias Jensen', '169', '0', '9', '2'),\n" +
                    "('848', 'Daniel Wass', '170', '0', '9', '2'),\n" +
                    "('849', 'Martin Braithwaite', '171', '0', '9', '2'),\n" +
                    "('850', 'Kasper Dolberg', '172', '0', '9', '2'),\n" +
                    "('851', 'Yussuf Poulsen', '173', '0', '9', '2'),\n" +
                    "('852', 'Pione Sisto', '174', '0', '9', '2'),\n" +
                    "('853', 'Robert Skov', '175', '0', '9', '2'),\n" +
                    "('854', 'Jonas Wind', '176', '0', '9', '2'),\n" +
                    "('855', 'Logo Finland', '177', '0', '10', '2'),\n" +
                    "('856', 'Lukas Hradecky', '178', '0', '10', '2'),\n" +
                    "('857', 'Jesse Joronen', '179', '0', '10', '2'),\n" +
                    "('858', 'Nikolai Alho', '180', '0', '10', '2'),\n" +
                    "('859', 'Paulus Arajuuri', '181', '0', '10', '2'),\n" +
                    "('860', 'Daniel O''Shaughnessy', '182', '0', '10', '2'),\n" +
                    "('861', 'Jukka Raitala', '183', '0', '10', '2'),\n" +
                    "('862', 'Joona Toivio', '184', '0', '10', '2'),\n" +
                    "('863', 'Jere Uronen', '185', '0', '10', '2'),\n" +
                    "('864', 'Leo Väisänen', '186', '0', '10', '2'),\n" +
                    "('865', 'Glen Kamara', '187', '0', '10', '2'),\n" +
                    "('866', 'Joni Kauko', '188', '0', '10', '2'),\n" +
                    "('867', 'Robin Lod', '189', '0', '10', '2'),\n" +
                    "('868', 'Ilmari Niskanen', '190', '0', '10', '2'),\n" +
                    "('869', 'Rasmus Schüller', '191', '0', '10', '2'),\n" +
                    "('870', 'Pyry Soiri', '192', '0', '10', '2'),\n" +
                    "('871', 'Tim Sparv', '193', '0', '10', '2'),\n" +
                    "('872', 'Robert Taylor', '194', '0', '10', '2'),\n" +
                    "('873', 'Frederik Jensen', '195', '0', '10', '2'),\n" +
                    "('874', 'Joel Pohjanpalo', '196', '0', '10', '2'),\n" +
                    "('875', 'Teemu Pukki', '197', '0', '10', '2'),\n" +
                    "('876', 'Lukas Hradecky / Jukka Raitala', '198', '0', '10', '2'),\n" +
                    "('877', 'Paulus Arajuuri / Daniel O''Shaughnessy', '199', '0', '10', '2'),\n" +
                    "('878', 'Joona Toivio / Jere Uronen', '200', '0', '10', '2'),\n" +
                    "('879', 'Glen Kamara / Robin Lod', '201', '0', '10', '2'),\n" +
                    "('880', 'Robert Taylor / Tim Sparv', '202', '0', '10', '2'),\n" +
                    "('881', 'Joel Pohjanpalo / Teemu Pukki', '203', '0', '10', '2'),\n" +
                    "('882', 'Anton Shunin / Georgi Dzhikiya', '204', '0', '11', '2'),\n" +
                    "('883', 'Fedor Kudryashov / Andrei Semenov', '205', '0', '11', '2'),\n" +
                    "('884', 'Aleksei Ionov / Daler Kuzyaev', '206', '0', '11', '2'),\n" +
                    "('885', 'Aleksei Miranchuk / Anton Miranchuk', '207', '0', '11', '2'),\n" +
                    "('886', 'Magomed Ozdoev / Yuri Zhirkov', '208', '0', '11', '2'),\n" +
                    "('887', 'Roman Zobnin / Artem Dzyuba', '209', '0', '11', '2'),\n" +
                    "('888', 'Logo Russia', '210', '0', '11', '2'),\n" +
                    "('889', 'Anton Shunin', '211', '0', '11', '2'),\n" +
                    "('890', 'Guilherme', '212', '0', '11', '2'),\n" +
                    "('891', 'Georgi Dzhikiya', '213', '0', '11', '2'),\n" +
                    "('892', 'Vyacheslav Karavaev', '214', '0', '11', '2'),\n" +
                    "('893', 'Fedor Kudryashov', '215', '0', '11', '2'),\n" +
                    "('894', 'Mário Fernandes', '216', '0', '11', '2'),\n" +
                    "('895', 'Andrei Semenov', '217', '0', '11', '2'),\n" +
                    "('896', 'Zelimkhan Bakaev', '218', '0', '11', '2'),\n" +
                    "('897', 'Denis Cheryshev', '219', '0', '11', '2'),\n" +
                    "('898', 'Daniil Fomin', '220', '0', '11', '2'),\n" +
                    "('899', 'Yuri Gazinski', '221', '0', '11', '2');\n"
        )

        database.execSQL(
            "INSERT INTO \"StickerEntity\" (\"uid\", \"name\", \"number\", \"amount\", \"category_id\", \"album_id\") VALUES\n" +
                    "('900', 'Aleksei Ionov', '222', '0', '11', '2'),\n" +
                    "('901', 'Daler Kuzyaev', '223', '0', '11', '2'),\n" +
                    "('902', 'Aleksei Miranchuk', '224', '0', '11', '2'),\n" +
                    "('903', 'Anton Miranchuk', '225', '0', '11', '2'),\n" +
                    "('904', 'Andrei Mostovoy', '226', '0', '11', '2'),\n" +
                    "('905', 'Magomed Ozdoev', '227', '0', '11', '2'),\n" +
                    "('906', 'Yuri Zhirkov', '228', '0', '11', '2'),\n" +
                    "('907', 'Roman Zobnin', '229', '0', '11', '2'),\n" +
                    "('908', 'Artem Dzyuba', '230', '0', '11', '2'),\n" +
                    "('909', 'Group C. Austria', '231', '0', '12', '2'),\n" +
                    "('910', 'Group C. Netherlands', '232', '0', '12', '2'),\n" +
                    "('911', 'Group C. Macedonia', '233', '0', '12', '2'),\n" +
                    "('912', 'Group C. Ukraine', '234', '0', '12', '2'),\n" +
                    "('913', 'Logo Austria', '235', '0', '13', '2'),\n" +
                    "('914', 'Pavao Pervan', '236', '0', '13', '2'),\n" +
                    "('915', 'Alexander Schlager', '237', '0', '13', '2'),\n" +
                    "('916', 'David Alaba', '238', '0', '13', '2'),\n" +
                    "('917', 'Aleksandar Dragovic', '239', '0', '13', '2'),\n" +
                    "('918', 'Martin Hinteregger', '240', '0', '13', '2'),\n" +
                    "('919', 'Stefan Lainer', '241', '0', '13', '2'),\n" +
                    "('920', 'Stefan Posch', '242', '0', '13', '2'),\n" +
                    "('921', 'Christopher Trimmel', '243', '0', '13', '2'),\n" +
                    "('922', 'Andreas Ulmer', '244', '0', '13', '2'),\n" +
                    "('923', 'Julian Baumgartlinger', '245', '0', '13', '2'),\n" +
                    "('924', 'Christoph Baumgartner', '246', '0', '13', '2'),\n" +
                    "('925', 'Florian Grillitsch', '247', '0', '13', '2'),\n" +
                    "('926', 'Stefan Ilsanker', '248', '0', '13', '2'),\n" +
                    "('927', 'Reinhold Ranftl', '249', '0', '13', '2'),\n" +
                    "('928', 'Marcel Sabitzer', '250', '0', '13', '2'),\n" +
                    "('929', 'Xaver Schlager', '251', '0', '13', '2'),\n" +
                    "('930', 'Marko Arnautović', '252', '0', '13', '2'),\n" +
                    "('931', 'Adrian Grbic', '253', '0', '13', '2'),\n" +
                    "('932', 'Michael Gregoritsch', '254', '0', '13', '2'),\n" +
                    "('933', 'Karim Onisiwo', '255', '0', '13', '2'),\n" +
                    "('934', 'Pavao Pervan', '256', '0', '13', '2'),\n" +
                    "('935', 'Aleksandar Dragovic / Martin Hinteregger', '257', '0', '13', '2'),\n" +
                    "('936', 'Stefan Lainer / Julian Baumgartlinger', '258', '0', '13', '2'),\n" +
                    "('937', 'Christoph Baumgartner / Stefan Ilsanker', '259', '0', '13', '2'),\n" +
                    "('938', 'Marcel Sabitzer / Xaver Schlager', '260', '0', '13', '2'),\n" +
                    "('939', 'Marko Arnautović / Michael Gregoritsch', '261', '0', '13', '2'),\n" +
                    "('940', 'Jasper Cillessen / Daley Blind', '262', '0', '14', '2'),\n" +
                    "('941', 'Matthijs de Ligt / Stefan de Vrij', '263', '0', '14', '2'),\n" +
                    "('942', 'Hans Hateboer / Virgil van Dijk', '264', '0', '14', '2'),\n" +
                    "('943', 'Frenkie de Jong / Donny van de Beek', '265', '0', '14', '2'),\n" +
                    "('944', 'Georginio Wijnaldum / Steven Bergwijn', '266', '0', '14', '2'),\n" +
                    "('945', 'Luuk de Jong / Memphis Depay', '267', '0', '14', '2'),\n" +
                    "('946', 'Logo Netherlands', '268', '0', '14', '2'),\n" +
                    "('947', 'Jasper Cillessen', '269', '0', '14', '2'),\n" +
                    "('948', 'Tim Krul', '270', '0', '14', '2'),\n" +
                    "('949', 'Nathan Aké', '271', '0', '14', '2'),\n" +
                    "('950', 'Daley Blind', '272', '0', '14', '2'),\n" +
                    "('951', 'Matthijs de Ligt', '273', '0', '14', '2'),\n" +
                    "('952', 'Stefan de Vrij', '274', '0', '14', '2'),\n" +
                    "('953', 'Denzel Dumfries', '275', '0', '14', '2'),\n" +
                    "('954', 'Hans Hateboer', '276', '0', '14', '2'),\n" +
                    "('955', 'Virgil van Dijk', '277', '0', '14', '2'),\n" +
                    "('956', 'Joël Veltman', '278', '0', '14', '2'),\n" +
                    "('957', 'Steven Berghuis', '279', '0', '14', '2'),\n" +
                    "('958', 'Frenkie de Jong', '280', '0', '14', '2'),\n" +
                    "('959', 'Marten de Roon', '281', '0', '14', '2'),\n" +
                    "('960', 'Calvin Stengs', '282', '0', '14', '2'),\n" +
                    "('961', 'Donny van de Beek', '283', '0', '14', '2'),\n" +
                    "('962', 'Georginio Wijnaldum', '284', '0', '14', '2'),\n" +
                    "('963', 'Ryan Babel', '285', '0', '14', '2'),\n" +
                    "('964', 'Steven Bergwijn', '286', '0', '14', '2'),\n" +
                    "('965', 'Luuk de Jong', '287', '0', '14', '2'),\n" +
                    "('966', 'Memphis Depay', '288', '0', '14', '2'),\n" +
                    "('967', 'Logo Macedonia', '289', '0', '15', '2'),\n" +
                    "('968', 'Stole Dimitrievski', '290', '0', '15', '2'),\n" +
                    "('969', 'Damjan Shishkovski', '291', '0', '15', '2'),\n" +
                    "('970', 'Egzon Bejtulai', '292', '0', '15', '2'),\n" +
                    "('971', 'Visar Musliu', '293', '0', '15', '2'),\n" +
                    "('972', 'Kire Ristevski', '294', '0', '15', '2'),\n" +
                    "('973', 'Stefan Ristovski', '295', '0', '15', '2'),\n" +
                    "('974', 'Darko Velkovski', '296', '0', '15', '2'),\n" +
                    "('975', 'Gjoko Zajkov', '297', '0', '15', '2'),\n" +
                    "('976', 'Arijan Ademi', '298', '0', '15', '2'),\n" +
                    "('977', 'Ezgjan Alioski', '299', '0', '15', '2'),\n" +
                    "('978', 'Enis Bardhi', '300', '0', '15', '2'),\n" +
                    "('979', 'Eljif Elmas', '301', '0', '15', '2'),\n" +
                    "('980', 'Tihomir Kostadinov', '302', '0', '15', '2'),\n" +
                    "('981', 'Boban Nikolov', '303', '0', '15', '2'),\n" +
                    "('982', 'Stefan Spirovski', '304', '0', '15', '2'),\n" +
                    "('983', 'Ilija Nestorovski', '305', '0', '15', '2'),\n" +
                    "('984', 'Goran Pandev', '306', '0', '15', '2'),\n" +
                    "('985', 'Vlatko Stojanovski', '307', '0', '15', '2'),\n" +
                    "('986', 'Aleksandar Trajkovski', '308', '0', '15', '2'),\n" +
                    "('987', 'Ivan Trichkovski', '309', '0', '15', '2'),\n" +
                    "('988', 'Stole Dimitrievski / Visar Musliu', '310', '0', '15', '2'),\n" +
                    "('989', 'Stefan Ristovski / Darko Velkovski', '311', '0', '15', '2'),\n" +
                    "('990', 'Arijan Ademi / Ezgjan Alioski', '312', '0', '15', '2'),\n" +
                    "('991', 'Enis Bardhi / Eljif Elmas', '313', '0', '15', '2'),\n" +
                    "('992', 'Boban Nikolov / Stefan Spirovski', '314', '0', '15', '2'),\n" +
                    "('993', 'Ilija Nestorovski / Goran Pandev', '315', '0', '15', '2'),\n" +
                    "('994', 'Andriy Pyatov / Oleksandr Karavaev', '316', '0', '16', '2'),\n" +
                    "('995', 'Mykola Matviyenko / Eduard Sobol', '317', '0', '16', '2'),\n" +
                    "('996', 'Ilya Zabarnyi / Viktor Kovalenko', '318', '0', '16', '2'),\n" +
                    "('997', 'Ruslan Malinovskyi / Marlos', '319', '0', '16', '2'),\n" +
                    "('998', 'Viktor Tsygankov / Oleksandr Zinchenko', '320', '0', '16', '2'),\n" +
                    "('999', 'Roman Yaremchuk / Andriy Yarmolenko', '321', '0', '16', '2'),\n" +
                    "('1000', 'Logo Ukraine', '322', '0', '16', '2'),\n" +
                    "('1001', 'Andriy Pyatov', '323', '0', '16', '2'),\n" +
                    "('1002', 'Georgiy Bushchan', '324', '0', '16', '2'),\n" +
                    "('1003', 'Oleksandr Karavaev', '325', '0', '16', '2'),\n" +
                    "('1004', 'Serhiy Kryvtsov', '326', '0', '16', '2'),\n" +
                    "('1005', 'Mykola Matviyenko', '327', '0', '16', '2'),\n" +
                    "('1006', 'Bogdan Mykhaylichenko', '328', '0', '16', '2'),\n" +
                    "('1007', 'Eduard Sobol', '329', '0', '16', '2'),\n" +
                    "('1008', 'Ilya Zabarnyi', '330', '0', '16', '2'),\n" +
                    "('1009', 'Ihor Kharatin', '331', '0', '16', '2'),\n" +
                    "('1010', 'Viktor Kovalenko', '332', '0', '16', '2'),\n" +
                    "('1011', 'Ruslan Malinovskyi', '333', '0', '16', '2'),\n" +
                    "('1012', 'Yevgen Makarenko', '334', '0', '16', '2'),\n" +
                    "('1013', 'Marlos', '335', '0', '16', '2'),\n" +
                    "('1014', 'Taras Stepanenko', '336', '0', '16', '2'),\n" +
                    "('1015', 'Serhiy Sydorchuk', '337', '0', '16', '2'),\n" +
                    "('1016', 'Viktor Tsygankov', '338', '0', '16', '2'),\n" +
                    "('1017', 'Oleksandr Zinchenko', '339', '0', '16', '2'),\n" +
                    "('1018', 'Oleksandr Zubkov', '340', '0', '16', '2'),\n" +
                    "('1019', 'Roman Yaremchuk', '341', '0', '16', '2'),\n" +
                    "('1020', 'Andriy Yarmolenko', '342', '0', '16', '2'),\n" +
                    "('1021', 'Group D. Croatia', '343', '0', '17', '2'),\n" +
                    "('1022', 'Group D. Czech Republic', '344', '0', '17', '2'),\n" +
                    "('1023', 'Group D. England', '345', '0', '17', '2'),\n" +
                    "('1024', 'Group D. Scotland', '346', '0', '17', '2'),\n" +
                    "('1025', 'Logo Croatia', '347', '0', '18', '2'),\n" +
                    "('1026', 'Dominik Livaković', '348', '0', '18', '2'),\n" +
                    "('1027', 'Simon Sluga', '349', '0', '18', '2'),\n" +
                    "('1028', 'Borna Barišić', '350', '0', '18', '2'),\n" +
                    "('1029', 'Duje Ćaleta-Car', '351', '0', '18', '2'),\n" +
                    "('1030', 'Dejan Lovren', '352', '0', '18', '2'),\n" +
                    "('1031', 'Dario Melnjak', '353', '0', '18', '2'),\n" +
                    "('1032', 'Filip Uremović', '354', '0', '18', '2'),\n" +
                    "('1033', 'Domagoj Vida', '355', '0', '18', '2'),\n" +
                    "('1034', 'Šime Vrsaljko', '356', '0', '18', '2'),\n" +
                    "('1035', 'Milan Badelj', '357', '0', '18', '2'),\n" +
                    "('1036', 'Marcelo Brozović', '358', '0', '18', '2'),\n" +
                    "('1037', 'Mateo Kovačić', '359', '0', '18', '2'),\n" +
                    "('1038', 'Luka Modrić', '360', '0', '18', '2'),\n" +
                    "('1039', 'Mario Pašalić', '361', '0', '18', '2'),\n" +
                    "('1040', 'Nikola Vlašić', '362', '0', '18', '2'),\n" +
                    "('1041', 'Josip Brekalo', '363', '0', '18', '2'),\n" +
                    "('1042', 'Andrej Kramarić', '364', '0', '18', '2'),\n" +
                    "('1043', 'Ivan Perišić', '365', '0', '18', '2'),\n" +
                    "('1044', 'Bruno Petković', '366', '0', '18', '2'),\n" +
                    "('1045', 'Ante Rebić', '367', '0', '18', '2'),\n" +
                    "('1046', 'Dominik Livaković / Duje Ćaleta-Car', '368', '0', '18', '2'),\n" +
                    "('1047', 'Dejan Lovren / Domagoj Vida', '369', '0', '18', '2'),\n" +
                    "('1048', 'Marcelo Brozović / Mateo Kovačić', '370', '0', '18', '2'),\n" +
                    "('1049', 'Luka Modrić / Mario Pašalić', '371', '0', '18', '2'),\n" +
                    "('1050', 'Nikola Vlašić / Josip Brekalo', '372', '0', '18', '2'),\n" +
                    "('1051', 'Andrej Kramarić / Ivan Perišić', '373', '0', '18', '2'),\n" +
                    "('1052', 'Tomáš Vaclík / Jan Bořil', '374', '0', '19', '2'),\n" +
                    "('1053', 'Ondřej Čelůstka / Vladimír Coufal', '375', '0', '19', '2'),\n" +
                    "('1054', 'Pavel Kadeřábek / Vladimír Darida', '376', '0', '19', '2'),\n" +
                    "('1055', 'Bořek Dočkal / Jakub Jankto', '377', '0', '19', '2'),\n" +
                    "('1056', 'Alex Král / Lukáš Masopust', '378', '0', '19', '2'),\n" +
                    "('1057', 'Tomáš Souček / Matěj Vydra', '379', '0', '19', '2'),\n" +
                    "('1058', 'Logo Czech Republic', '380', '0', '19', '2'),\n" +
                    "('1059', 'Tomáš Vaclík', '381', '0', '19', '2'),\n" +
                    "('1060', 'Jiří Pavlenka', '382', '0', '19', '2'),\n" +
                    "('1061', 'Jan Bořil', '383', '0', '19', '2'),\n" +
                    "('1062', 'Jakub Brabec', '384', '0', '19', '2'),\n" +
                    "('1063', 'Ondřej Čelůstka', '385', '0', '19', '2'),\n" +
                    "('1064', 'Vladimír Coufal', '386', '0', '19', '2'),\n" +
                    "('1065', 'Pavel Kadeřábek', '387', '0', '19', '2'),\n" +
                    "('1066', 'Ondřej Kúdela', '388', '0', '19', '2'),\n" +
                    "('1067', 'Antonín Barák', '389', '0', '19', '2'),\n" +
                    "('1068', 'Vladimír Darida', '390', '0', '19', '2'),\n" +
                    "('1069', 'Bořek Dočkal', '391', '0', '19', '2'),\n" +
                    "('1070', 'Jakub Jankto', '392', '0', '19', '2'),\n" +
                    "('1071', 'Alex Král', '393', '0', '19', '2'),\n" +
                    "('1072', 'Lukáš Masopust', '394', '0', '19', '2'),\n" +
                    "('1073', 'Petr Ševčík', '395', '0', '19', '2'),\n" +
                    "('1074', 'Tomáš Souček', '396', '0', '19', '2'),\n" +
                    "('1075', 'Michael Krmenčík', '397', '0', '19', '2'),\n" +
                    "('1076', 'Zdeněk Ondrášek', '398', '0', '19', '2'),\n" +
                    "('1077', 'Patrik Schick', '399', '0', '19', '2'),\n" +
                    "('1078', 'Matěj Vydra', '400', '0', '19', '2'),\n" +
                    "('1079', 'Logo England', '401', '0', '20', '2'),\n" +
                    "('1080', 'Jordan Pickford', '402', '0', '20', '2'),\n" +
                    "('1081', 'Nick Pope', '403', '0', '20', '2'),\n" +
                    "('1082', 'Trent Alexander-Arnold', '404', '0', '20', '2'),\n" +
                    "('1083', 'Ben Chilwell', '405', '0', '20', '2'),\n" +
                    "('1084', 'Conor Coady', '406', '0', '20', '2'),\n" +
                    "('1085', 'Harry Maguire', '407', '0', '20', '2'),\n" +
                    "('1086', 'Tyrone Mings', '408', '0', '20', '2'),\n" +
                    "('1087', 'Kieran Trippier', '409', '0', '20', '2'),\n" +
                    "('1088', 'Kyle Walker', '410', '0', '20', '2'),\n" +
                    "('1089', 'Eric Dier', '411', '0', '20', '2'),\n" +
                    "('1090', 'Phil Foden', '412', '0', '20', '2'),\n" +
                    "('1091', 'Jack Grealish', '413', '0', '20', '2'),\n" +
                    "('1092', 'Jordan Henderson', '414', '0', '20', '2'),\n" +
                    "('1093', 'Mason Mount', '415', '0', '20', '2'),\n" +
                    "('1094', 'Declan Rice', '416', '0', '20', '2'),\n" +
                    "('1095', 'Dominic Calvert-Lewin', '417', '0', '20', '2'),\n" +
                    "('1096', 'Harry Kane', '418', '0', '20', '2'),\n" +
                    "('1097', 'Marcus Rashford', '419', '0', '20', '2'),\n" +
                    "('1098', 'Jadon Sancho', '420', '0', '20', '2'),\n" +
                    "('1099', 'Raheem Sterling', '421', '0', '20', '2'),\n" +
                    "('1100', 'Jordan Pickford / Trent Alexander-Arnold', '422', '0', '20', '2'),\n" +
                    "('1101', 'Harry Maguire / Kieran Trippier', '423', '0', '20', '2'),\n" +
                    "('1102', 'Kyle Walker / Eric Dier', '424', '0', '20', '2'),\n" +
                    "('1103', 'Mason Mount / Declan Rice', '425', '0', '20', '2'),\n" +
                    "('1104', 'Harry Kane / Marcus Rashford', '426', '0', '20', '2'),\n" +
                    "('1105', 'Jadon Sancho / Raheem Sterling', '427', '0', '20', '2'),\n" +
                    "('1106', 'David Marshall / Declan Gallagher', '428', '0', '21', '2'),\n" +
                    "('1107', 'Stephen O''Donnell / Andrew Robertson', '429', '0', '21', '2'),\n" +
                    "('1108', 'Kieran Tierney / Ryan Christie', '430', '0', '21', '2'),\n" +
                    "('1109', 'Ryan Jack / John McGinn', '431', '0', '21', '2'),\n" +
                    "('1110', 'Callum McGregor / Scott McTominay', '432', '0', '21', '2'),\n" +
                    "('1111', 'Lyndon Dykes / Ryan Fraser', '433', '0', '21', '2'),\n" +
                    "('1112', 'Logo Scotland', '434', '0', '21', '2'),\n" +
                    "('1113', 'David Marshall', '435', '0', '21', '2'),\n" +
                    "('1114', 'Craig Gordon', '436', '0', '21', '2'),\n" +
                    "('1115', 'Liam Cooper', '437', '0', '21', '2'),\n" +
                    "('1116', 'Declan Gallagher', '438', '0', '21', '2'),\n" +
                    "('1117', 'Scott McKenna', '439', '0', '21', '2'),\n" +
                    "('1118', 'Stephen O''Donnell', '440', '0', '21', '2'),\n" +
                    "('1119', 'Liam Palmer', '441', '0', '21', '2'),\n" +
                    "('1120', 'Andrew Robertson', '442', '0', '21', '2'),\n" +
                    "('1121', 'Kieran Tierney', '443', '0', '21', '2'),\n" +
                    "('1122', 'Stuart Armstrong', '444', '0', '21', '2'),\n" +
                    "('1123', 'Ryan Christie', '445', '0', '21', '2'),\n" +
                    "('1124', 'James Forrest', '446', '0', '21', '2'),\n" +
                    "('1125', 'Ryan Jack', '447', '0', '21', '2'),\n" +
                    "('1126', 'John McGinn', '448', '0', '21', '2'),\n" +
                    "('1127', 'Callum McGregor', '449', '0', '21', '2'),\n" +
                    "('1128', 'Kenny McLean', '450', '0', '21', '2'),\n" +
                    "('1129', 'Scott McTominay', '451', '0', '21', '2'),\n" +
                    "('1130', 'Lyndon Dykes', '452', '0', '21', '2'),\n" +
                    "('1131', 'Ryan Fraser', '453', '0', '21', '2'),\n" +
                    "('1132', 'Oliver McBurnie', '454', '0', '21', '2'),\n" +
                    "('1133', 'Group E. Poland', '455', '0', '22', '2'),\n" +
                    "('1134', 'Group E. Slovakia', '456', '0', '22', '2'),\n" +
                    "('1135', 'Group E. Spain', '457', '0', '22', '2'),\n" +
                    "('1136', 'Group E. Sweden', '458', '0', '22', '2'),\n" +
                    "('1137', 'Logo Poland', '459', '0', '23', '2'),\n" +
                    "('1138', 'Wojciech Szczęsny', '460', '0', '23', '2'),\n" +
                    "('1139', 'Łukasz Fabiański', '461', '0', '23', '2'),\n" +
                    "('1140', 'Jan Bednarek', '462', '0', '23', '2'),\n" +
                    "('1141', 'Bartosz Bereszyński', '463', '0', '23', '2'),\n" +
                    "('1142', 'Kamil Glik', '464', '0', '23', '2'),\n" +
                    "('1143', 'Tomasz Kędziora', '465', '0', '23', '2'),\n" +
                    "('1144', 'Arkadiusz Reca', '466', '0', '23', '2'),\n" +
                    "('1145', 'Maciej Rybus', '467', '0', '23', '2'),\n" +
                    "('1146', 'Sebastian Walukiewicz', '468', '0', '23', '2'),\n" +
                    "('1147', 'Jacek Góralski', '469', '0', '23', '2'),\n" +
                    "('1148', 'Kamil Grosicki', '470', '0', '23', '2'),\n" +
                    "('1149', 'Kamil Jóźwiak', '471', '0', '23', '2'),\n" +
                    "('1150', 'Mateusz Klich', '472', '0', '23', '2'),\n" +
                    "('1151', 'Grzegorz Krychowiak', '473', '0', '23', '2'),\n" +
                    "('1152', 'Karol Linetty', '474', '0', '23', '2'),\n" +
                    "('1153', 'Sebastian Szymański', '475', '0', '23', '2'),\n" +
                    "('1154', 'Piotr Zieliński', '476', '0', '23', '2'),\n" +
                    "('1155', 'Robert Lewandowski', '477', '0', '23', '2'),\n" +
                    "('1156', 'Arkadiusz Milik', '478', '0', '23', '2'),\n" +
                    "('1157', 'Krzysztof Piątek', '479', '0', '23', '2'),\n" +
                    "('1158', 'Wojciech Szczęsny / Jan Bednarek', '480', '0', '23', '2'),\n" +
                    "('1159', 'Kamil Glik / Tomasz Kędziora', '481', '0', '23', '2'),\n" +
                    "('1160', 'Kamil Grosicki / Kamil Jóźwiak', '482', '0', '23', '2'),\n" +
                    "('1161', 'Mateusz Klich / Grzegorz Krychowiak', '483', '0', '23', '2'),\n" +
                    "('1162', 'Piotr Zieliński / Robert Lewandowski', '484', '0', '23', '2'),\n" +
                    "('1163', 'Arkadiusz Milik / Krzysztof Piątek', '485', '0', '23', '2'),\n" +
                    "('1164', 'Marek Rodák / Peter Pekarík', '486', '0', '24', '2'),\n" +
                    "('1165', 'Ľubomír Šatka / Milan Škriniar', '487', '0', '24', '2'),\n" +
                    "('1166', 'Ondrej Duda / Marek Hamšík', '488', '0', '24', '2'),\n" +
                    "('1167', 'Patrik Hrošovský / Juraj Kucka', '489', '0', '24', '2'),\n" +
                    "('1168', 'Stanislav Lobotka / Róbert Mak', '490', '0', '24', '2'),\n" +
                    "('1169', 'Albert Rusnák / Róbert Boženík', '491', '0', '24', '2'),\n" +
                    "('1170', 'Logo Slovakia', '492', '0', '24', '2'),\n" +
                    "('1171', 'Marek Rodák', '493', '0', '24', '2'),\n" +
                    "('1172', 'Dominik Greif', '494', '0', '24', '2'),\n" +
                    "('1173', 'Dávid Hancko', '495', '0', '24', '2'),\n" +
                    "('1174', 'Róbert Mazáň', '496', '0', '24', '2'),\n" +
                    "('1175', 'Peter Pekarík', '497', '0', '24', '2'),\n" +
                    "('1176', 'Ľubomír Šatka', '498', '0', '24', '2'),\n" +
                    "('1177', 'Milan Škriniar', '499', '0', '24', '2'),\n" +
                    "('1178', 'Martin Valjent', '500', '0', '24', '2'),\n" +
                    "('1179', 'Denis Vavro', '501', '0', '24', '2'),\n" +
                    "('1180', 'Ondrej Duda', '502', '0', '24', '2'),\n" +
                    "('1181', 'Ján Greguš', '503', '0', '24', '2'),\n" +
                    "('1182', 'Marek Hamšík', '504', '0', '24', '2'),\n" +
                    "('1183', 'Lukáš Haraslín', '505', '0', '24', '2'),\n" +
                    "('1184', 'Patrik Hrošovský', '506', '0', '24', '2'),\n" +
                    "('1185', 'Juraj Kucka', '507', '0', '24', '2'),\n" +
                    "('1186', 'Stanislav Lobotka', '508', '0', '24', '2'),\n" +
                    "('1187', 'Róbert Mak', '509', '0', '24', '2'),\n" +
                    "('1188', 'Albert Rusnák', '510', '0', '24', '2'),\n" +
                    "('1189', 'Róbert Boženík', '511', '0', '24', '2'),\n" +
                    "('1190', 'Michal Ďuriš', '512', '0', '24', '2'),\n" +
                    "('1191', 'Logo Spain', '513', '0', '25', '2'),\n" +
                    "('1192', 'Unai Simón', '514', '0', '25', '2'),\n" +
                    "('1193', 'David de Gea', '515', '0', '25', '2'),\n" +
                    "('1194', 'Daniel Carvajal', '516', '0', '25', '2'),\n" +
                    "('1195', 'José Gayà', '517', '0', '25', '2'),\n" +
                    "('1196', 'Eric García', '518', '0', '25', '2'),\n" +
                    "('1197', 'Jesús Navas', '519', '0', '25', '2'),\n" +
                    "('1198', 'Pau Torres', '520', '0', '25', '2'),\n" +
                    "('1199', 'Sergio Ramos', '521', '0', '25', '2');"
        )

        database.execSQL(
            "INSERT INTO \"StickerEntity\" (\"uid\", \"name\", \"number\", \"amount\", \"category_id\", \"album_id\") VALUES\n" +
                    "('1200', 'Sergio Canales', '522', '0', '25', '2'),\n" +
                    "('1201', 'Dani Olmo', '523', '0', '25', '2'),\n" +
                    "('1202', 'Koke', '524', '0', '25', '2'),\n" +
                    "('1203', 'Rodri', '525', '0', '25', '2'),\n" +
                    "('1204', 'Fabián Ruiz', '526', '0', '25', '2'),\n" +
                    "('1205', 'Sergio Busquets', '527', '0', '25', '2'),\n" +
                    "('1206', 'Thiago', '528', '0', '25', '2'),\n" +
                    "('1207', 'Ansu Fati', '529', '0', '25', '2'),\n" +
                    "('1208', 'Álvaro Morata', '530', '0', '25', '2'),\n" +
                    "('1209', 'Gerard Moreno', '531', '0', '25', '2'),\n" +
                    "('1210', 'Mikel Oyarzabal', '532', '0', '25', '2'),\n" +
                    "('1211', 'Ferran Torres', '533', '0', '25', '2'),\n" +
                    "('1212', 'Unai Simón / Jesús Navas', '534', '0', '25', '2'),\n" +
                    "('1213', 'Pau Torres / Sergio Ramos', '535', '0', '25', '2'),\n" +
                    "('1214', 'Dani Olmo / Rodri', '536', '0', '25', '2'),\n" +
                    "('1215', 'Fabián Ruiz / Thiago', '537', '0', '25', '2'),\n" +
                    "('1216', 'Ansu Fati / Álvaro Morata', '538', '0', '25', '2'),\n" +
                    "('1217', 'Gerard Moreno / Ferran Torres', '539', '0', '25', '2'),\n" +
                    "('1218', 'Robin Olsen / Ludwig Augustinsson', '540', '0', '26', '2'),\n" +
                    "('1219', 'Mikael Lustig / Victor Nilsson Lindelöf', '541', '0', '26', '2'),\n" +
                    "('1220', 'Viktor Claesson / Albin Ekdal', '542', '0', '26', '2'),\n" +
                    "('1221', 'Emil Forsberg / Sebastian Larsson', '543', '0', '26', '2'),\n" +
                    "('1222', 'Kristoffer Olsson / Marcus Berg', '544', '0', '26', '2'),\n" +
                    "('1223', 'Alexander Isak / Dejan Kulusevski', '545', '0', '26', '2'),\n" +
                    "('1224', 'Logo Sweden', '546', '0', '26', '2'),\n" +
                    "('1225', 'Robin Olsen', '547', '0', '26', '2'),\n" +
                    "('1226', 'Ludwig Augustinsson', '548', '0', '26', '2'),\n" +
                    "('1227', 'Emil Krafth', '549', '0', '26', '2'),\n" +
                    "('1228', 'Marcus Danielson', '550', '0', '26', '2'),\n" +
                    "('1229', 'Andreas Granqvist', '551', '0', '26', '2'),\n" +
                    "('1230', 'Filip Helander', '552', '0', '26', '2'),\n" +
                    "('1231', 'Pontus Jansson', '553', '0', '26', '2'),\n" +
                    "('1232', 'Mikael Lustig', '554', '0', '26', '2'),\n" +
                    "('1233', 'Victor Nilsson Lindelöf', '555', '0', '26', '2'),\n" +
                    "('1234', 'Viktor Claesson', '556', '0', '26', '2'),\n" +
                    "('1235', 'Albin Ekdal', '557', '0', '26', '2'),\n" +
                    "('1236', 'Emil Forsberg', '558', '0', '26', '2'),\n" +
                    "('1237', 'Sebastian Larsson', '559', '0', '26', '2'),\n" +
                    "('1238', 'Kristoffer Olsson', '560', '0', '26', '2'),\n" +
                    "('1239', 'Mattias Svanberg', '561', '0', '26', '2'),\n" +
                    "('1240', 'Gustav Svensson', '562', '0', '26', '2'),\n" +
                    "('1241', 'Marcus Berg', '563', '0', '26', '2'),\n" +
                    "('1242', 'Alexander Isak', '564', '0', '26', '2'),\n" +
                    "('1243', 'Dejan Kulusevski', '565', '0', '26', '2'),\n" +
                    "('1244', 'Robin Quaison', '566', '0', '26', '2'),\n" +
                    "('1245', 'Group F. France', '567', '0', '27', '2'),\n" +
                    "('1246', 'Group F. Germany', '568', '0', '27', '2'),\n" +
                    "('1247', 'Group F. Hungary', '569', '0', '27', '2'),\n" +
                    "('1248', 'Group F. Portugal', '570', '0', '27', '2'),\n" +
                    "('1249', 'Logo France', '571', '0', '28', '2'),\n" +
                    "('1250', 'Hugo Lloris', '572', '0', '28', '2'),\n" +
                    "('1251', 'Steve Mandanda', '573', '0', '28', '2'),\n" +
                    "('1252', 'Lucas Digne', '574', '0', '28', '2'),\n" +
                    "('1253', 'Lucas Hernández', '575', '0', '28', '2'),\n" +
                    "('1254', 'Presnel Kimpembe', '576', '0', '28', '2'),\n" +
                    "('1255', 'Clément Lenglet', '577', '0', '28', '2'),\n" +
                    "('1256', 'Benjamin Pavard', '578', '0', '28', '2'),\n" +
                    "('1257', 'Dayot Upamecano', '579', '0', '28', '2'),\n" +
                    "('1258', 'Raphaël Varane', '580', '0', '28', '2'),\n" +
                    "('1259', 'Eduardo Camavinga', '581', '0', '28', '2'),\n" +
                    "('1260', 'N’Golo Kanté', '582', '0', '28', '2'),\n" +
                    "('1261', 'Steven Nzonzi', '583', '0', '28', '2'),\n" +
                    "('1262', 'Paul Pogba', '584', '0', '28', '2'),\n" +
                    "('1263', 'Adrien Rabiot', '585', '0', '28', '2'),\n" +
                    "('1264', 'Moussa Sissoko', '586', '0', '28', '2'),\n" +
                    "('1265', 'Kingsley Coman', '587', '0', '28', '2'),\n" +
                    "('1266', 'Olivier Giroud', '588', '0', '28', '2'),\n" +
                    "('1267', 'Antoine Griezmann', '589', '0', '28', '2'),\n" +
                    "('1268', 'Anthony Martial', '590', '0', '28', '2'),\n" +
                    "('1269', 'Kylian Mbappé', '591', '0', '28', '2'),\n" +
                    "('1270', 'Hugo Lloris / Lucas Hernández', '592', '0', '28', '2'),\n" +
                    "('1271', 'Clément Lenglet / Benjamin Pavard', '593', '0', '28', '2'),\n" +
                    "('1272', 'Raphaël Varane / N’Golo Kanté', '594', '0', '28', '2'),\n" +
                    "('1273', 'Paul Pogba / Moussa Sissoko', '595', '0', '28', '2'),\n" +
                    "('1274', 'Kingsley Coman / Olivier Giroud', '596', '0', '28', '2'),\n" +
                    "('1275', 'Antoine Griezmann / Kylian Mbappé', '597', '0', '28', '2'),\n" +
                    "('1276', 'Manuel Neuer / Matthias Ginter', '598', '0', '29', '2'),\n" +
                    "('1277', 'Antonio Rüdiger / Julian Brandt', '599', '0', '29', '2'),\n" +
                    "('1278', 'Emre Can / Julian Draxler', '600', '0', '29', '2'),\n" +
                    "('1279', 'İlkay Gündoğan / Kai Havertz', '601', '0', '29', '2'),\n" +
                    "('1280', 'Joshua Kimmich / Toni Kroos', '602', '0', '29', '2'),\n" +
                    "('1281', 'Serge Gnabry / Timo Werner', '603', '0', '29', '2'),\n" +
                    "('1282', 'Logo Germany', '604', '0', '29', '2'),\n" +
                    "('1283', 'Manuel Neuer', '605', '0', '29', '2'),\n" +
                    "('1284', 'Bernd Leno', '606', '0', '29', '2'),\n" +
                    "('1285', 'Matthias Ginter', '607', '0', '29', '2'),\n" +
                    "('1286', 'Thilo Kehrer', '608', '0', '29', '2'),\n" +
                    "('1287', 'Lukas Klostermann', '609', '0', '29', '2'),\n" +
                    "('1288', 'Robin Koch', '610', '0', '29', '2'),\n" +
                    "('1289', 'Antonio Rüdiger', '611', '0', '29', '2'),\n" +
                    "('1290', 'Jonathan Tah', '612', '0', '29', '2'),\n" +
                    "('1291', 'Julian Brandt', '613', '0', '29', '2'),\n" +
                    "('1292', 'Emre Can', '614', '0', '29', '2'),\n" +
                    "('1293', 'Julian Draxler', '615', '0', '29', '2'),\n" +
                    "('1294', 'Leon Goretzka', '616', '0', '29', '2'),\n" +
                    "('1295', 'İlkay Gündoğan', '617', '0', '29', '2'),\n" +
                    "('1296', 'Kai Havertz', '618', '0', '29', '2'),\n" +
                    "('1297', 'Joshua Kimmich', '619', '0', '29', '2'),\n" +
                    "('1298', 'Toni Kroos', '620', '0', '29', '2'),\n" +
                    "('1299', 'Serge Gnabry', '621', '0', '29', '2'),\n" +
                    "('1300', 'Leroy Sané', '622', '0', '29', '2'),\n" +
                    "('1301', 'Luca Waldschmidt', '623', '0', '29', '2'),\n" +
                    "('1302', 'Timo Werner', '624', '0', '29', '2'),\n" +
                    "('1303', 'Logo Hungary', '625', '0', '30', '2'),\n" +
                    "('1304', 'Péter Gulácsi', '626', '0', '30', '2'),\n" +
                    "('1305', 'Dénes Dibusz', '627', '0', '30', '2'),\n" +
                    "('1306', 'Barnabás Bese', '628', '0', '30', '2'),\n" +
                    "('1307', 'Endre Botka', '629', '0', '30', '2'),\n" +
                    "('1308', 'Attila Fiola', '630', '0', '30', '2'),\n" +
                    "('1309', 'Szilveszter Hangya', '631', '0', '30', '2'),\n" +
                    "('1310', 'Ádám Lang', '632', '0', '30', '2'),\n" +
                    "('1311', 'Willi Orban', '633', '0', '30', '2'),\n" +
                    "('1312', 'Attila Szalai', '634', '0', '30', '2'),\n" +
                    "('1313', 'Zsolt Kalmár', '635', '0', '30', '2'),\n" +
                    "('1314', 'Gergő Lovrencsics', '636', '0', '30', '2'),\n" +
                    "('1315', 'Ádám Nagy', '637', '0', '30', '2'),\n" +
                    "('1316', 'Loic Nego', '638', '0', '30', '2'),\n" +
                    "('1317', 'Dávid Sigér', '639', '0', '30', '2'),\n" +
                    "('1318', 'Dominik Szoboszlai', '640', '0', '30', '2'),\n" +
                    "('1319', 'Filip Holender', '641', '0', '30', '2'),\n" +
                    "('1320', 'Norbert Könyves', '642', '0', '30', '2'),\n" +
                    "('1321', 'Nemanja Nikolics', '643', '0', '30', '2'),\n" +
                    "('1322', 'Roland Sallai', '644', '0', '30', '2'),\n" +
                    "('1323', 'Ádám Szalai', '645', '0', '30', '2'),\n" +
                    "('1324', 'Péter Gulácsi / Endre Botka', '646', '0', '30', '2'),\n" +
                    "('1325', 'Attila Fiola / Ádám Lang', '647', '0', '30', '2'),\n" +
                    "('1326', 'Willi Orban / Attila Szalai', '648', '0', '30', '2'),\n" +
                    "('1327', 'Zsolt Kalmár / Ádám Nagy', '649', '0', '30', '2'),\n" +
                    "('1328', 'Dominik Szoboszlai / Filip Holender', '650', '0', '30', '2'),\n" +
                    "('1329', 'Roland Sallai / Ádám Szalai', '651', '0', '30', '2'),\n" +
                    "('1330', 'Rui Patrício / João Cancelo', '652', '0', '31', '2'),\n" +
                    "('1331', 'Pepe / Raphaël Guerreiro', '653', '0', '31', '2'),\n" +
                    "('1332', 'Rúben Dias / Bernardo Silva', '654', '0', '31', '2'),\n" +
                    "('1333', 'Bruno Fernandes / Danilo Pereira', '655', '0', '31', '2'),\n" +
                    "('1334', 'Rúben Neves / Diogo Jota', '656', '0', '31', '2'),\n" +
                    "('1335', 'Cristiano Ronaldo / João Félix', '657', '0', '31', '2'),\n" +
                    "('1336', 'Logo Portugal', '658', '0', '31', '2'),\n" +
                    "('1337', 'Rui Patrício', '659', '0', '31', '2'),\n" +
                    "('1338', 'Anthony Lopes', '660', '0', '31', '2'),\n" +
                    "('1339', 'João Cancelo', '661', '0', '31', '2'),\n" +
                    "('1340', 'José Fonte', '662', '0', '31', '2'),\n" +
                    "('1341', 'Mário Rui', '663', '0', '31', '2'),\n" +
                    "('1342', 'Nélson Semedo', '664', '0', '31', '2'),\n" +
                    "('1343', 'Pepe', '665', '0', '31', '2'),\n" +
                    "('1344', 'Raphaël Guerreiro', '666', '0', '31', '2'),\n" +
                    "('1345', 'Rúben Dias', '667', '0', '31', '2'),\n" +
                    "('1346', 'Bernardo Silva', '668', '0', '31', '2'),\n" +
                    "('1347', 'Bruno Fernandes', '669', '0', '31', '2'),\n" +
                    "('1348', 'Danilo Pereira', '670', '0', '31', '2'),\n" +
                    "('1349', 'João Moutinho', '671', '0', '31', '2'),\n" +
                    "('1350', 'Renato Sanches', '672', '0', '31', '2'),\n" +
                    "('1351', 'Rúben Neves', '673', '0', '31', '2'),\n" +
                    "('1352', 'William Carvalho', '674', '0', '31', '2'),\n" +
                    "('1353', 'Diogo Jota', '675', '0', '31', '2'),\n" +
                    "('1354', 'Cristiano Ronaldo', '676', '0', '31', '2'),\n" +
                    "('1355', 'João Félix', '677', '0', '31', '2'),\n" +
                    "('1356', 'Francisco Trincão', '678', '0', '31', '2'),\n" +
                    "('1357', 'UEFA Euro 2020 Logo', '1', '0', '1', '3'),\n" +
                    "('1358', 'European Championship Trophy', '2', '0', '1', '3'),\n" +
                    "('1359', 'European Championship Trophy', '3', '0', '1', '3'),\n" +
                    "('1360', '’Skillzy', '4', '0', '1', '3'),\n" +
                    "('1361', 'Sign for an Equal Game - Respect', '5', '0', '1', '3'),\n" +
                    "('1362', 'Panini Logo - Carlo Parola', '6', '0', '1', '3'),\n" +
                    "('1363', 'Group A. Italy', '7', '0', '2', '3'),\n" +
                    "('1364', 'Group A. Switzerland', '8', '0', '2', '3'),\n" +
                    "('1365', 'Group A. Turkey', '9', '0', '2', '3'),\n" +
                    "('1366', 'Group A. Wales', '10', '0', '2', '3'),\n" +
                    "('1367', 'Logo Italy', '11', '0', '3', '3'),\n" +
                    "('1368', 'Gianluigi Donnarumma', '12', '0', '3', '3'),\n" +
                    "('1369', 'Salvatore Sirigu', '13', '0', '3', '3'),\n" +
                    "('1370', 'Francesco Acerbi', '14', '0', '3', '3'),\n" +
                    "('1371', 'Alessandro Bastoni', '15', '0', '3', '3'),\n" +
                    "('1372', 'Leonardo Bonucci', '16', '0', '3', '3'),\n" +
                    "('1373', 'Giorgio Chiellini', '17', '0', '3', '3'),\n" +
                    "('1374', 'Emerson', '18', '0', '3', '3'),\n" +
                    "('1375', 'Alessandro Florenzi', '19', '0', '3', '3'),\n" +
                    "('1376', 'Nicolo Barella', '20', '0', '3', '3'),\n" +
                    "('1377', 'Jorginho', '21', '0', '3', '3'),\n" +
                    "('1378', 'Manuel Locatelli', '22', '0', '3', '3'),\n" +
                    "('1379', 'Lorenzo Pellegrini', '23', '0', '3', '3'),\n" +
                    "('1380', 'Marco Verratti', '24', '0', '3', '3'),\n" +
                    "('1381', 'Andrea Belotti', '25', '0', '3', '3'),\n" +
                    "('1382', 'Domenico Berardi', '26', '0', '3', '3'),\n" +
                    "('1383', 'Federico Bernardeschi', '27', '0', '3', '3'),\n" +
                    "('1384', 'Federico Chiesa', '28', '0', '3', '3'),\n" +
                    "('1385', 'Ciro Immobile', '29', '0', '3', '3'),\n" +
                    "('1386', 'Lorenzo Insigne', '30', '0', '3', '3'),\n" +
                    "('1387', 'Moise Kean', '31', '0', '3', '3'),\n" +
                    "('1388', 'Gianluigi Donnarumma / Franceso Acerbi', '32', '0', '3', '3'),\n" +
                    "('1389', 'Leonardo Bonucci / Emerson', '33', '0', '3', '3'),\n" +
                    "('1390', 'Alessandro Florenzi / Nicolo Barella', '34', '0', '3', '3'),\n" +
                    "('1391', 'Manuel Locatelli / Jorginho', '35', '0', '3', '3'),\n" +
                    "('1392', 'Ciro Immobile / Lorenzo Insigne', '36', '0', '3', '3'),\n" +
                    "('1393', 'Andrea Belotti / Federico Chiesa', '37', '0', '3', '3'),\n" +
                    "('1394', 'Yann Sommer / Manuel Akanji', '38', '0', '4', '3'),\n" +
                    "('1395', 'Nico Elvedi / Ricardo Rodríguez', '39', '0', '4', '3'),\n" +
                    "('1396', 'Remo Freuler / Xherdan Shaqiri', '40', '0', '4', '3'),\n" +
                    "('1397', 'Djibril Sow / Granit Xhaka', '41', '0', '4', '3'),\n" +
                    "('1398', 'Steven Zuber / Breel Embolo', '42', '0', '4', '3'),\n" +
                    "('1399', 'Admir Mehmedi / Haris Seferović', '43', '0', '4', '3'),\n" +
                    "('1400', 'Logo Switzerland', '44', '0', '4', '3'),\n" +
                    "('1401', 'Yann Sommer', '45', '0', '4', '3'),\n" +
                    "('1402', 'Yvon Mvogo', '46', '0', '4', '3'),\n" +
                    "('1403', 'Manuel Akanji', '47', '0', '4', '3'),\n" +
                    "('1404', 'Nico Elvedi', '48', '0', '4', '3'),\n" +
                    "('1405', 'Kevin Mbabu', '49', '0', '4', '3'),\n" +
                    "('1406', 'Ricardo Rodríguez', '50', '0', '4', '3'),\n" +
                    "('1407', 'Fabian Schär', '51', '0', '4', '3'),\n" +
                    "('1408', 'Silvan Widmer', '52', '0', '4', '3'),\n" +
                    "('1409', 'Edimilson Fernandes', '53', '0', '4', '3'),\n" +
                    "('1410', 'Remo Freuler', '54', '0', '4', '3'),\n" +
                    "('1411', 'Xherdan Shaqiri', '55', '0', '4', '3'),\n" +
                    "('1412', 'Djibril Sow', '56', '0', '4', '3'),\n" +
                    "('1413', 'Renato Steffen', '57', '0', '4', '3'),\n" +
                    "('1414', 'Granit Xhaka', '58', '0', '4', '3'),\n" +
                    "('1415', 'Denis Zakaria', '59', '0', '4', '3'),\n" +
                    "('1416', 'Steven Zuber', '60', '0', '4', '3'),\n" +
                    "('1417', 'Breel Embolo', '61', '0', '4', '3'),\n" +
                    "('1418', 'Mario Gavranović', '62', '0', '4', '3'),\n" +
                    "('1419', 'Admir Mehmedi', '63', '0', '4', '3'),\n" +
                    "('1420', 'Haris Seferović', '64', '0', '4', '3'),\n" +
                    "('1421', 'Logo Turkey', '65', '0', '5', '3'),\n" +
                    "('1422', 'Mert Günok', '66', '0', '5', '3'),\n" +
                    "('1423', 'Uğurcan Çakır', '67', '0', '5', '3'),\n" +
                    "('1424', 'Kaan Ayhan', '68', '0', '5', '3'),\n" +
                    "('1425', 'Zeki Çelik', '69', '0', '5', '3'),\n" +
                    "('1426', 'Merih Demiral', '70', '0', '5', '3'),\n" +
                    "('1427', 'Ozan Kabak', '71', '0', '5', '3'),\n" +
                    "('1428', 'Umut Meraş', '72', '0', '5', '3'),\n" +
                    "('1429', 'Nazim Sangaré', '73', '0', '5', '3'),\n" +
                    "('1430', 'Çağlar Söyüncü', '74', '0', '5', '3'),\n" +
                    "('1431', 'Hakan Çalhanoğlu', '75', '0', '5', '3'),\n" +
                    "('1432', 'Irfan Can Kahveci', '76', '0', '5', '3'),\n" +
                    "('1433', 'Mahmut Tekdemir', '77', '0', '5', '3'),\n" +
                    "('1434', 'Ozan Tufan', '78', '0', '5', '3'),\n" +
                    "('1435', 'Cengiz Ünder', '79', '0', '5', '3'),\n" +
                    "('1436', 'Yusuf Yazici', '80', '0', '5', '3'),\n" +
                    "('1437', 'Okay Yokuşlu', '81', '0', '5', '3'),\n" +
                    "('1438', 'Kenan Karaman', '82', '0', '5', '3'),\n" +
                    "('1439', 'Cenk Tosun', '83', '0', '5', '3'),\n" +
                    "('1440', 'Enes Ünal', '84', '0', '5', '3'),\n" +
                    "('1441', 'Burak Yilmaz', '85', '0', '5', '3'),\n" +
                    "('1442', 'Mert Günok / Zeki Çelik', '86', '0', '5', '3'),\n" +
                    "('1443', 'Merih Demiral / Ozan Kabak', '87', '0', '5', '3'),\n" +
                    "('1444', 'Umut Meraş / Çağlar Söyüncü', '88', '0', '5', '3'),\n" +
                    "('1445', 'Hakan Çalhanoğlu / Mahmut Tekdemir', '89', '0', '5', '3'),\n" +
                    "('1446', 'Ozan Tufan / Cengiz Ünder', '90', '0', '5', '3'),\n" +
                    "('1447', 'Kenan Karaman / Burak Yilmaz', '91', '0', '5', '3'),\n" +
                    "('1448', 'Wayne Hennessey / Ben Davies', '92', '0', '6', '3'),\n" +
                    "('1449', 'Chris Mepham / Connor Roberts', '93', '0', '6', '3'),\n" +
                    "('1450', 'Joe Rodon / Ethan Ampadu', '94', '0', '6', '3'),\n" +
                    "('1451', 'Daniel James / Joe Morrell', '95', '0', '6', '3'),\n" +
                    "('1452', 'Aaron Ramsey / Harry Wilson', '96', '0', '6', '3'),\n" +
                    "('1453', 'Gareth Bale / Kieffer Moore', '97', '0', '6', '3'),\n" +
                    "('1454', 'Logo Wales', '98', '0', '6', '3'),\n" +
                    "('1455', 'Wayne Hennessey', '99', '0', '6', '3'),\n" +
                    "('1456', 'Danny Ward', '100', '0', '6', '3'),\n" +
                    "('1457', 'Ben Davies', '101', '0', '6', '3'),\n" +
                    "('1458', 'Chris Gunter', '102', '0', '6', '3'),\n" +
                    "('1459', 'Tom Lockyer', '103', '0', '6', '3'),\n" +
                    "('1460', 'Chris Mepham', '104', '0', '6', '3'),\n" +
                    "('1461', 'Connor Roberts', '105', '0', '6', '3'),\n" +
                    "('1462', 'Joe Rodon', '106', '0', '6', '3'),\n" +
                    "('1463', 'Neco Williams', '107', '0', '6', '3'),\n" +
                    "('1464', 'Joe Allen', '108', '0', '6', '3'),\n" +
                    "('1465', 'Ethan Ampadu', '109', '0', '6', '3'),\n" +
                    "('1466', 'David Brooks', '110', '0', '6', '3'),\n" +
                    "('1467', 'Daniel James', '111', '0', '6', '3'),\n" +
                    "('1468', 'Joe Morrell', '112', '0', '6', '3'),\n" +
                    "('1469', 'Aaron Ramsey', '113', '0', '6', '3'),\n" +
                    "('1470', 'Jonathan Williams', '114', '0', '6', '3'),\n" +
                    "('1471', 'Harry Wilson', '115', '0', '6', '3'),\n" +
                    "('1472', 'Gareth Bale', '116', '0', '6', '3'),\n" +
                    "('1473', 'Rabbi Matondo', '117', '0', '6', '3'),\n" +
                    "('1474', 'Kieffer Moore', '118', '0', '6', '3'),\n" +
                    "('1475', 'Group B. Belgium', '119', '0', '7', '3'),\n" +
                    "('1476', 'Group B. Denmark', '120', '0', '7', '3'),\n" +
                    "('1477', 'Group B. Finland', '121', '0', '7', '3'),\n" +
                    "('1478', 'Group B. Russia', '122', '0', '7', '3'),\n" +
                    "('1479', 'Logo Belgium', '123', '0', '8', '3'),\n" +
                    "('1480', 'Thibaut Courtois', '124', '0', '8', '3'),\n" +
                    "('1481', 'Simon Mignolet', '125', '0', '8', '3'),\n" +
                    "('1482', 'Toby Alderweireld', '126', '0', '8', '3'),\n" +
                    "('1483', 'Dedryck Boyata', '127', '0', '8', '3'),\n" +
                    "('1484', 'Timothy Castagne', '128', '0', '8', '3'),\n" +
                    "('1485', 'Jason Denayer', '129', '0', '8', '3'),\n" +
                    "('1486', 'Thomas Meunier', '130', '0', '8', '3'),\n" +
                    "('1487', 'Jan Vertonghen', '131', '0', '8', '3'),\n" +
                    "('1488', 'Kevin de Bruyne', '132', '0', '8', '3'),\n" +
                    "('1489', 'Dennis Praet', '133', '0', '8', '3'),\n" +
                    "('1490', 'Youri Tielemans', '134', '0', '8', '3'),\n" +
                    "('1491', 'Hans Vanaken', '135', '0', '8', '3'),\n" +
                    "('1492', 'Axel Witsel', '136', '0', '8', '3'),\n" +
                    "('1493', 'Michy Batshuayi', '137', '0', '8', '3'),\n" +
                    "('1494', 'Yannick Carrasco', '138', '0', '8', '3'),\n" +
                    "('1495', 'Jérémy Doku', '139', '0', '8', '3'),\n" +
                    "('1496', 'Eden Hazard', '140', '0', '8', '3'),\n" +
                    "('1497', 'Thorgan Hazard', '141', '0', '8', '3'),\n" +
                    "('1498', 'Romelu Lukaku', '142', '0', '8', '3'),\n" +
                    "('1499', 'Dries Mertens', '143', '0', '8', '3');"
        )
        database.execSQL(
            "INSERT INTO \"StickerEntity\" (\"uid\", \"name\", \"number\", \"amount\", \"category_id\", \"album_id\") VALUES\n" +
                    "('1500', 'Thibaut Courtois / Toby Alderweireld', '144', '0', '8', '3'),\n" +
                    "('1501', 'Jason Denayer / Thomas Meunier', '145', '0', '8', '3'),\n" +
                    "('1502', 'Jan Vertonghen / Kevin de Bruyne', '146', '0', '8', '3'),\n" +
                    "('1503', 'Youri Tielemans / Axel Witsel', '147', '0', '8', '3'),\n" +
                    "('1504', 'Eden Hazard / Thorgan Hazard', '148', '0', '8', '3'),\n" +
                    "('1505', 'Romelu Lukaku / Dries Mertens', '149', '0', '8', '3'),\n" +
                    "('1506', 'Kasper Schmeichel / Andreas Christensen', '150', '0', '9', '3'),\n" +
                    "('1507', 'Mathias Jørgensen / Simon Kjær', '151', '0', '9', '3'),\n" +
                    "('1508', 'Joakim Mæhle / Thomas Delaney', '152', '0', '9', '3'),\n" +
                    "('1509', 'Christian Eriksen / Pierre Emile Højbjerg', '153', '0', '9', '3'),\n" +
                    "('1510', 'Daniel Wass / Martin Braithwaite', '154', '0', '9', '3'),\n" +
                    "('1511', 'Kasper Dolberg / Yussuf Poulsen', '155', '0', '9', '3'),\n" +
                    "('1512', 'Logo Danmark', '156', '0', '9', '3'),\n" +
                    "('1513', 'Kasper Schmeichel', '157', '0', '9', '3'),\n" +
                    "('1514', 'Frederik Rønnow', '158', '0', '9', '3'),\n" +
                    "('1515', 'Hamza Mendyl', '159', '0', '9', '3'),\n" +
                    "('1516', 'Andreas Christensen', '160', '0', '9', '3'),\n" +
                    "('1517', 'Simon Kjær', '161', '0', '9', '3'),\n" +
                    "('1518', 'Joakim Mæhle', '162', '0', '9', '3'),\n" +
                    "('1519', 'Jens Stryger Larsen', '163', '0', '9', '3'),\n" +
                    "('1520', 'Jannik Vestergaard', '164', '0', '9', '3'),\n" +
                    "('1521', 'Lucas Andersen', '165', '0', '9', '3'),\n" +
                    "('1522', 'Thomas Delaney', '166', '0', '9', '3'),\n" +
                    "('1523', 'Christian Eriksen', '167', '0', '9', '3'),\n" +
                    "('1524', 'Pierre Emile Højbjerg', '168', '0', '9', '3'),\n" +
                    "('1525', 'Mathias Jensen', '169', '0', '9', '3'),\n" +
                    "('1526', 'Daniel Wass', '170', '0', '9', '3'),\n" +
                    "('1527', 'Martin Braithwaite', '171', '0', '9', '3'),\n" +
                    "('1528', 'Kasper Dolberg', '172', '0', '9', '3'),\n" +
                    "('1529', 'Yussuf Poulsen', '173', '0', '9', '3'),\n" +
                    "('1530', 'Pione Sisto', '174', '0', '9', '3'),\n" +
                    "('1531', 'Robert Skov', '175', '0', '9', '3'),\n" +
                    "('1532', 'Jonas Wind', '176', '0', '9', '3'),\n" +
                    "('1533', 'Logo Finland', '177', '0', '10', '3'),\n" +
                    "('1534', 'Lukas Hradecky', '178', '0', '10', '3'),\n" +
                    "('1535', 'Jesse Joronen', '179', '0', '10', '3'),\n" +
                    "('1536', 'Nikolai Alho', '180', '0', '10', '3'),\n" +
                    "('1537', 'Paulus Arajuuri', '181', '0', '10', '3'),\n" +
                    "('1538', 'Daniel O''Shaughnessy', '182', '0', '10', '3'),\n" +
                    "('1539', 'Jukka Raitala', '183', '0', '10', '3'),\n" +
                    "('1540', 'Joona Toivio', '184', '0', '10', '3'),\n" +
                    "('1541', 'Jere Uronen', '185', '0', '10', '3'),\n" +
                    "('1542', 'Leo Väisänen', '186', '0', '10', '3'),\n" +
                    "('1543', 'Glen Kamara', '187', '0', '10', '3'),\n" +
                    "('1544', 'Joni Kauko', '188', '0', '10', '3'),\n" +
                    "('1545', 'Robin Lod', '189', '0', '10', '3'),\n" +
                    "('1546', 'Ilmari Niskanen', '190', '0', '10', '3'),\n" +
                    "('1547', 'Rasmus Schüller', '191', '0', '10', '3'),\n" +
                    "('1548', 'Pyry Soiri', '192', '0', '10', '3'),\n" +
                    "('1549', 'Tim Sparv', '193', '0', '10', '3'),\n" +
                    "('1550', 'Robert Taylor', '194', '0', '10', '3'),\n" +
                    "('1551', 'Frederik Jensen', '195', '0', '10', '3'),\n" +
                    "('1552', 'Joel Pohjanpalo', '196', '0', '10', '3'),\n" +
                    "('1553', 'Teemu Pukki', '197', '0', '10', '3'),\n" +
                    "('1554', 'Lukas Hradecky / Jukka Raitala', '198', '0', '10', '3'),\n" +
                    "('1555', 'Paulus Arajuuri / Daniel O''Shaughnessy', '199', '0', '10', '3'),\n" +
                    "('1556', 'Joona Toivio / Jere Uronen', '200', '0', '10', '3'),\n" +
                    "('1557', 'Glen Kamara / Robin Lod', '201', '0', '10', '3'),\n" +
                    "('1558', 'Robert Taylor / Tim Sparv', '202', '0', '10', '3'),\n" +
                    "('1559', 'Joel Pohjanpalo / Teemu Pukki', '203', '0', '10', '3'),\n" +
                    "('1560', 'Anton Shunin / Georgi Dzhikiya', '204', '0', '11', '3'),\n" +
                    "('1561', 'Fedor Kudryashov / Andrei Semenov', '205', '0', '11', '3'),\n" +
                    "('1562', 'Aleksei Ionov / Daler Kuzyaev', '206', '0', '11', '3'),\n" +
                    "('1563', 'Aleksei Miranchuk / Anton Miranchuk', '207', '0', '11', '3'),\n" +
                    "('1564', 'Magomed Ozdoev / Yuri Zhirkov', '208', '0', '11', '3'),\n" +
                    "('1565', 'Roman Zobnin / Artem Dzyuba', '209', '0', '11', '3'),\n" +
                    "('1566', 'Logo Russia', '210', '0', '11', '3'),\n" +
                    "('1567', 'Anton Shunin', '211', '0', '11', '3'),\n" +
                    "('1568', 'Guilherme', '212', '0', '11', '3'),\n" +
                    "('1569', 'Georgi Dzhikiya', '213', '0', '11', '3'),\n" +
                    "('1570', 'Vyacheslav Karavaev', '214', '0', '11', '3'),\n" +
                    "('1571', 'Fedor Kudryashov', '215', '0', '11', '3'),\n" +
                    "('1572', 'Mário Fernandes', '216', '0', '11', '3'),\n" +
                    "('1573', 'Andrei Semenov', '217', '0', '11', '3'),\n" +
                    "('1574', 'Zelimkhan Bakaev', '218', '0', '11', '3'),\n" +
                    "('1575', 'Denis Cheryshev', '219', '0', '11', '3'),\n" +
                    "('1576', 'Daniil Fomin', '220', '0', '11', '3'),\n" +
                    "('1577', 'Yuri Gazinski', '221', '0', '11', '3'),\n" +
                    "('1578', 'Aleksei Ionov', '222', '0', '11', '3'),\n" +
                    "('1579', 'Daler Kuzyaev', '223', '0', '11', '3'),\n" +
                    "('1580', 'Aleksei Miranchuk', '224', '0', '11', '3'),\n" +
                    "('1581', 'Anton Miranchuk', '225', '0', '11', '3'),\n" +
                    "('1582', 'Andrei Mostovoy', '226', '0', '11', '3'),\n" +
                    "('1583', 'Magomed Ozdoev', '227', '0', '11', '3'),\n" +
                    "('1584', 'Yuri Zhirkov', '228', '0', '11', '3'),\n" +
                    "('1585', 'Roman Zobnin', '229', '0', '11', '3'),\n" +
                    "('1586', 'Artem Dzyuba', '230', '0', '11', '3'),\n" +
                    "('1587', 'Group C. Austria', '231', '0', '12', '3'),\n" +
                    "('1588', 'Group C. Netherlands', '232', '0', '12', '3'),\n" +
                    "('1589', 'Group C. Macedonia', '233', '0', '12', '3'),\n" +
                    "('1590', 'Group C. Ukraine', '234', '0', '12', '3'),\n" +
                    "('1591', 'Logo Austria', '235', '0', '13', '3'),\n" +
                    "('1592', 'Pavao Pervan', '236', '0', '13', '3'),\n" +
                    "('1593', 'Alexander Schlager', '237', '0', '13', '3'),\n" +
                    "('1594', 'David Alaba', '238', '0', '13', '3'),\n" +
                    "('1595', 'Aleksandar Dragovic', '239', '0', '13', '3'),\n" +
                    "('1596', 'Martin Hinteregger', '240', '0', '13', '3'),\n" +
                    "('1597', 'Stefan Lainer', '241', '0', '13', '3'),\n" +
                    "('1598', 'Stefan Posch', '242', '0', '13', '3'),\n" +
                    "('1599', 'Christopher Trimmel', '243', '0', '13', '3'),\n" +
                    "('1600', 'Andreas Ulmer', '244', '0', '13', '3'),\n" +
                    "('1601', 'Julian Baumgartlinger', '245', '0', '13', '3'),\n" +
                    "('1602', 'Christoph Baumgartner', '246', '0', '13', '3'),\n" +
                    "('1603', 'Florian Grillitsch', '247', '0', '13', '3'),\n" +
                    "('1604', 'Stefan Ilsanker', '248', '0', '13', '3'),\n" +
                    "('1605', 'Reinhold Ranftl', '249', '0', '13', '3'),\n" +
                    "('1606', 'Marcel Sabitzer', '250', '0', '13', '3'),\n" +
                    "('1607', 'Xaver Schlager', '251', '0', '13', '3'),\n" +
                    "('1608', 'Marko Arnautović', '252', '0', '13', '3'),\n" +
                    "('1609', 'Adrian Grbic', '253', '0', '13', '3'),\n" +
                    "('1610', 'Michael Gregoritsch', '254', '0', '13', '3'),\n" +
                    "('1611', 'Karim Onisiwo', '255', '0', '13', '3'),\n" +
                    "('1612', 'Pavao Pervan', '256', '0', '13', '3'),\n" +
                    "('1613', 'Aleksandar Dragovic / Martin Hinteregger', '257', '0', '13', '3'),\n" +
                    "('1614', 'Stefan Lainer / Julian Baumgartlinger', '258', '0', '13', '3'),\n" +
                    "('1615', 'Christoph Baumgartner / Stefan Ilsanker', '259', '0', '13', '3'),\n" +
                    "('1616', 'Marcel Sabitzer / Xaver Schlager', '260', '0', '13', '3'),\n" +
                    "('1617', 'Marko Arnautović / Michael Gregoritsch', '261', '0', '13', '3'),\n" +
                    "('1618', 'Jasper Cillessen / Daley Blind', '262', '0', '14', '3'),\n" +
                    "('1619', 'Matthijs de Ligt / Stefan de Vrij', '263', '0', '14', '3'),\n" +
                    "('1620', 'Hans Hateboer / Virgil van Dijk', '264', '0', '14', '3'),\n" +
                    "('1621', 'Frenkie de Jong / Donny van de Beek', '265', '0', '14', '3'),\n" +
                    "('1622', 'Georginio Wijnaldum / Steven Bergwijn', '266', '0', '14', '3'),\n" +
                    "('1623', 'Luuk de Jong / Memphis Depay', '267', '0', '14', '3'),\n" +
                    "('1624', 'Logo Netherlands', '268', '0', '14', '3'),\n" +
                    "('1625', 'Jasper Cillessen', '269', '0', '14', '3'),\n" +
                    "('1626', 'Tim Krul', '270', '0', '14', '3'),\n" +
                    "('1627', 'Nathan Aké', '271', '0', '14', '3'),\n" +
                    "('1628', 'Daley Blind', '272', '0', '14', '3'),\n" +
                    "('1629', 'Matthijs de Ligt', '273', '0', '14', '3'),\n" +
                    "('1630', 'Stefan de Vrij', '274', '0', '14', '3'),\n" +
                    "('1631', 'Denzel Dumfries', '275', '0', '14', '3'),\n" +
                    "('1632', 'Hans Hateboer', '276', '0', '14', '3'),\n" +
                    "('1633', 'Virgil van Dijk', '277', '0', '14', '3'),\n" +
                    "('1634', 'Joël Veltman', '278', '0', '14', '3'),\n" +
                    "('1635', 'Steven Berghuis', '279', '0', '14', '3'),\n" +
                    "('1636', 'Frenkie de Jong', '280', '0', '14', '3'),\n" +
                    "('1637', 'Marten de Roon', '281', '0', '14', '3'),\n" +
                    "('1638', 'Calvin Stengs', '282', '0', '14', '3'),\n" +
                    "('1639', 'Donny van de Beek', '283', '0', '14', '3'),\n" +
                    "('1640', 'Georginio Wijnaldum', '284', '0', '14', '3'),\n" +
                    "('1641', 'Ryan Babel', '285', '0', '14', '3'),\n" +
                    "('1642', 'Steven Bergwijn', '286', '0', '14', '3'),\n" +
                    "('1643', 'Luuk de Jong', '287', '0', '14', '3'),\n" +
                    "('1644', 'Memphis Depay', '288', '0', '14', '3'),\n" +
                    "('1645', 'Logo Macedonia', '289', '0', '15', '3'),\n" +
                    "('1646', 'Stole Dimitrievski', '290', '0', '15', '3'),\n" +
                    "('1647', 'Damjan Shishkovski', '291', '0', '15', '3'),\n" +
                    "('1648', 'Egzon Bejtulai', '292', '0', '15', '3'),\n" +
                    "('1649', 'Visar Musliu', '293', '0', '15', '3'),\n" +
                    "('1650', 'Kire Ristevski', '294', '0', '15', '3'),\n" +
                    "('1651', 'Stefan Ristovski', '295', '0', '15', '3'),\n" +
                    "('1652', 'Darko Velkovski', '296', '0', '15', '3'),\n" +
                    "('1653', 'Gjoko Zajkov', '297', '0', '15', '3'),\n" +
                    "('1654', 'Arijan Ademi', '298', '0', '15', '3'),\n" +
                    "('1655', 'Ezgjan Alioski', '299', '0', '15', '3'),\n" +
                    "('1656', 'Enis Bardhi', '300', '0', '15', '3'),\n" +
                    "('1657', 'Eljif Elmas', '301', '0', '15', '3'),\n" +
                    "('1658', 'Tihomir Kostadinov', '302', '0', '15', '3'),\n" +
                    "('1659', 'Boban Nikolov', '303', '0', '15', '3'),\n" +
                    "('1660', 'Stefan Spirovski', '304', '0', '15', '3'),\n" +
                    "('1661', 'Ilija Nestorovski', '305', '0', '15', '3'),\n" +
                    "('1662', 'Goran Pandev', '306', '0', '15', '3'),\n" +
                    "('1663', 'Vlatko Stojanovski', '307', '0', '15', '3'),\n" +
                    "('1664', 'Aleksandar Trajkovski', '308', '0', '15', '3'),\n" +
                    "('1665', 'Ivan Trichkovski', '309', '0', '15', '3'),\n" +
                    "('1666', 'Stole Dimitrievski / Visar Musliu', '310', '0', '15', '3'),\n" +
                    "('1667', 'Stefan Ristovski / Darko Velkovski', '311', '0', '15', '3'),\n" +
                    "('1668', 'Arijan Ademi / Ezgjan Alioski', '312', '0', '15', '3'),\n" +
                    "('1669', 'Enis Bardhi / Eljif Elmas', '313', '0', '15', '3'),\n" +
                    "('1670', 'Boban Nikolov / Stefan Spirovski', '314', '0', '15', '3'),\n" +
                    "('1671', 'Ilija Nestorovski / Goran Pandev', '315', '0', '15', '3'),\n" +
                    "('1672', 'Andriy Pyatov / Oleksandr Karavaev', '316', '0', '16', '3'),\n" +
                    "('1673', 'Mykola Matviyenko / Eduard Sobol', '317', '0', '16', '3'),\n" +
                    "('1674', 'Ilya Zabarnyi / Viktor Kovalenko', '318', '0', '16', '3'),\n" +
                    "('1675', 'Ruslan Malinovskyi / Marlos', '319', '0', '16', '3'),\n" +
                    "('1676', 'Viktor Tsygankov / Oleksandr Zinchenko', '320', '0', '16', '3'),\n" +
                    "('1677', 'Roman Yaremchuk / Andriy Yarmolenko', '321', '0', '16', '3'),\n" +
                    "('1678', 'Logo Ukraine', '322', '0', '16', '3'),\n" +
                    "('1679', 'Andriy Pyatov', '323', '0', '16', '3'),\n" +
                    "('1680', 'Georgiy Bushchan', '324', '0', '16', '3'),\n" +
                    "('1681', 'Oleksandr Karavaev', '325', '0', '16', '3'),\n" +
                    "('1682', 'Serhiy Kryvtsov', '326', '0', '16', '3'),\n" +
                    "('1683', 'Mykola Matviyenko', '327', '0', '16', '3'),\n" +
                    "('1684', 'Bogdan Mykhaylichenko', '328', '0', '16', '3'),\n" +
                    "('1685', 'Eduard Sobol', '329', '0', '16', '3'),\n" +
                    "('1686', 'Ilya Zabarnyi', '330', '0', '16', '3'),\n" +
                    "('1687', 'Ihor Kharatin', '331', '0', '16', '3'),\n" +
                    "('1688', 'Viktor Kovalenko', '332', '0', '16', '3'),\n" +
                    "('1689', 'Ruslan Malinovskyi', '333', '0', '16', '3'),\n" +
                    "('1690', 'Yevgen Makarenko', '334', '0', '16', '3'),\n" +
                    "('1691', 'Marlos', '335', '0', '16', '3'),\n" +
                    "('1692', 'Taras Stepanenko', '336', '0', '16', '3'),\n" +
                    "('1693', 'Serhiy Sydorchuk', '337', '0', '16', '3'),\n" +
                    "('1694', 'Viktor Tsygankov', '338', '0', '16', '3'),\n" +
                    "('1695', 'Oleksandr Zinchenko', '339', '0', '16', '3'),\n" +
                    "('1696', 'Oleksandr Zubkov', '340', '0', '16', '3'),\n" +
                    "('1697', 'Roman Yaremchuk', '341', '0', '16', '3'),\n" +
                    "('1698', 'Andriy Yarmolenko', '342', '0', '16', '3'),\n" +
                    "('1699', 'Group D. Croatia', '343', '0', '17', '3'),\n" +
                    "('1700', 'Group D. Czech Republic', '344', '0', '17', '3'),\n" +
                    "('1701', 'Group D. England', '345', '0', '17', '3'),\n" +
                    "('1702', 'Group D. Scotland', '346', '0', '17', '3'),\n" +
                    "('1703', 'Logo Croatia', '347', '0', '18', '3'),\n" +
                    "('1704', 'Dominik Livaković', '348', '0', '18', '3'),\n" +
                    "('1705', 'Simon Sluga', '349', '0', '18', '3'),\n" +
                    "('1706', 'Borna Barišić', '350', '0', '18', '3'),\n" +
                    "('1707', 'Duje Ćaleta-Car', '351', '0', '18', '3'),\n" +
                    "('1708', 'Dejan Lovren', '352', '0', '18', '3'),\n" +
                    "('1709', 'Dario Melnjak', '353', '0', '18', '3'),\n" +
                    "('1710', 'Filip Uremović', '354', '0', '18', '3'),\n" +
                    "('1711', 'Domagoj Vida', '355', '0', '18', '3'),\n" +
                    "('1712', 'Šime Vrsaljko', '356', '0', '18', '3'),\n" +
                    "('1713', 'Milan Badelj', '357', '0', '18', '3'),\n" +
                    "('1714', 'Marcelo Brozović', '358', '0', '18', '3'),\n" +
                    "('1715', 'Mateo Kovačić', '359', '0', '18', '3'),\n" +
                    "('1716', 'Luka Modrić', '360', '0', '18', '3'),\n" +
                    "('1717', 'Mario Pašalić', '361', '0', '18', '3'),\n" +
                    "('1718', 'Nikola Vlašić', '362', '0', '18', '3'),\n" +
                    "('1719', 'Josip Brekalo', '363', '0', '18', '3'),\n" +
                    "('1720', 'Andrej Kramarić', '364', '0', '18', '3'),\n" +
                    "('1721', 'Ivan Perišić', '365', '0', '18', '3'),\n" +
                    "('1722', 'Bruno Petković', '366', '0', '18', '3'),\n" +
                    "('1723', 'Ante Rebić', '367', '0', '18', '3'),\n" +
                    "('1724', 'Dominik Livaković / Duje Ćaleta-Car', '368', '0', '18', '3'),\n" +
                    "('1725', 'Dejan Lovren / Domagoj Vida', '369', '0', '18', '3'),\n" +
                    "('1726', 'Marcelo Brozović / Mateo Kovačić', '370', '0', '18', '3'),\n" +
                    "('1727', 'Luka Modrić / Mario Pašalić', '371', '0', '18', '3'),\n" +
                    "('1728', 'Nikola Vlašić / Josip Brekalo', '372', '0', '18', '3'),\n" +
                    "('1729', 'Andrej Kramarić / Ivan Perišić', '373', '0', '18', '3'),\n" +
                    "('1730', 'Tomáš Vaclík / Jan Bořil', '374', '0', '19', '3'),\n" +
                    "('1731', 'Ondřej Čelůstka / Vladimír Coufal', '375', '0', '19', '3'),\n" +
                    "('1732', 'Pavel Kadeřábek / Vladimír Darida', '376', '0', '19', '3'),\n" +
                    "('1733', 'Bořek Dočkal / Jakub Jankto', '377', '0', '19', '3'),\n" +
                    "('1734', 'Alex Král / Lukáš Masopust', '378', '0', '19', '3'),\n" +
                    "('1735', 'Tomáš Souček / Matěj Vydra', '379', '0', '19', '3'),\n" +
                    "('1736', 'Logo Czech Republic', '380', '0', '19', '3'),\n" +
                    "('1737', 'Tomáš Vaclík', '381', '0', '19', '3'),\n" +
                    "('1738', 'Jiří Pavlenka', '382', '0', '19', '3'),\n" +
                    "('1739', 'Jan Bořil', '383', '0', '19', '3'),\n" +
                    "('1740', 'Jakub Brabec', '384', '0', '19', '3'),\n" +
                    "('1741', 'Ondřej Čelůstka', '385', '0', '19', '3'),\n" +
                    "('1742', 'Vladimír Coufal', '386', '0', '19', '3'),\n" +
                    "('1743', 'Pavel Kadeřábek', '387', '0', '19', '3'),\n" +
                    "('1744', 'Ondřej Kúdela', '388', '0', '19', '3'),\n" +
                    "('1745', 'Antonín Barák', '389', '0', '19', '3'),\n" +
                    "('1746', 'Vladimír Darida', '390', '0', '19', '3'),\n" +
                    "('1747', 'Bořek Dočkal', '391', '0', '19', '3'),\n" +
                    "('1748', 'Jakub Jankto', '392', '0', '19', '3'),\n" +
                    "('1749', 'Alex Král', '393', '0', '19', '3'),\n" +
                    "('1750', 'Lukáš Masopust', '394', '0', '19', '3'),\n" +
                    "('1751', 'Petr Ševčík', '395', '0', '19', '3'),\n" +
                    "('1752', 'Tomáš Souček', '396', '0', '19', '3'),\n" +
                    "('1753', 'Michael Krmenčík', '397', '0', '19', '3'),\n" +
                    "('1754', 'Zdeněk Ondrášek', '398', '0', '19', '3'),\n" +
                    "('1755', 'Patrik Schick', '399', '0', '19', '3'),\n" +
                    "('1756', 'Matěj Vydra', '400', '0', '19', '3'),\n" +
                    "('1757', 'Logo England', '401', '0', '20', '3'),\n" +
                    "('1758', 'Jordan Pickford', '402', '0', '20', '3'),\n" +
                    "('1759', 'Nick Pope', '403', '0', '20', '3'),\n" +
                    "('1760', 'Trent Alexander-Arnold', '404', '0', '20', '3'),\n" +
                    "('1761', 'Ben Chilwell', '405', '0', '20', '3'),\n" +
                    "('1762', 'Conor Coady', '406', '0', '20', '3'),\n" +
                    "('1763', 'Harry Maguire', '407', '0', '20', '3'),\n" +
                    "('1764', 'Tyrone Mings', '408', '0', '20', '3'),\n" +
                    "('1765', 'Kieran Trippier', '409', '0', '20', '3'),\n" +
                    "('1766', 'Kyle Walker', '410', '0', '20', '3'),\n" +
                    "('1767', 'Eric Dier', '411', '0', '20', '3'),\n" +
                    "('1768', 'Phil Foden', '412', '0', '20', '3'),\n" +
                    "('1769', 'Jack Grealish', '413', '0', '20', '3'),\n" +
                    "('1770', 'Jordan Henderson', '414', '0', '20', '3'),\n" +
                    "('1771', 'Mason Mount', '415', '0', '20', '3'),\n" +
                    "('1772', 'Declan Rice', '416', '0', '20', '3'),\n" +
                    "('1773', 'Dominic Calvert-Lewin', '417', '0', '20', '3'),\n" +
                    "('1774', 'Harry Kane', '418', '0', '20', '3'),\n" +
                    "('1775', 'Marcus Rashford', '419', '0', '20', '3'),\n" +
                    "('1776', 'Jadon Sancho', '420', '0', '20', '3'),\n" +
                    "('1777', 'Raheem Sterling', '421', '0', '20', '3'),\n" +
                    "('1778', 'Jordan Pickford / Trent Alexander-Arnold', '422', '0', '20', '3'),\n" +
                    "('1779', 'Harry Maguire / Kieran Trippier', '423', '0', '20', '3'),\n" +
                    "('1780', 'Kyle Walker / Eric Dier', '424', '0', '20', '3'),\n" +
                    "('1781', 'Mason Mount / Declan Rice', '425', '0', '20', '3'),\n" +
                    "('1782', 'Harry Kane / Marcus Rashford', '426', '0', '20', '3'),\n" +
                    "('1783', 'Jadon Sancho / Raheem Sterling', '427', '0', '20', '3'),\n" +
                    "('1784', 'David Marshall / Declan Gallagher', '428', '0', '21', '3'),\n" +
                    "('1785', 'Stephen O''Donnell / Andrew Robertson', '429', '0', '21', '3'),\n" +
                    "('1786', 'Kieran Tierney / Ryan Christie', '430', '0', '21', '3'),\n" +
                    "('1787', 'Ryan Jack / John McGinn', '431', '0', '21', '3'),\n" +
                    "('1788', 'Callum McGregor / Scott McTominay', '432', '0', '21', '3'),\n" +
                    "('1789', 'Lyndon Dykes / Ryan Fraser', '433', '0', '21', '3'),\n" +
                    "('1790', 'Logo Scotland', '434', '0', '21', '3'),\n" +
                    "('1791', 'David Marshall', '435', '0', '21', '3'),\n" +
                    "('1792', 'Craig Gordon', '436', '0', '21', '3'),\n" +
                    "('1793', 'Liam Cooper', '437', '0', '21', '3'),\n" +
                    "('1794', 'Declan Gallagher', '438', '0', '21', '3'),\n" +
                    "('1795', 'Scott McKenna', '439', '0', '21', '3'),\n" +
                    "('1796', 'Stephen O''Donnell', '440', '0', '21', '3'),\n" +
                    "('1797', 'Liam Palmer', '441', '0', '21', '3'),\n" +
                    "('1798', 'Andrew Robertson', '442', '0', '21', '3'),\n" +
                    "('1799', 'Kieran Tierney', '443', '0', '21', '3'),\n" +
                    "('1800', 'Stuart Armstrong', '444', '0', '21', '3'),\n" +
                    "('1801', 'Ryan Christie', '445', '0', '21', '3'),\n" +
                    "('1802', 'James Forrest', '446', '0', '21', '3'),\n" +
                    "('1803', 'Ryan Jack', '447', '0', '21', '3'),\n" +
                    "('1804', 'John McGinn', '448', '0', '21', '3'),\n" +
                    "('1805', 'Callum McGregor', '449', '0', '21', '3'),\n" +
                    "('1806', 'Kenny McLean', '450', '0', '21', '3'),\n" +
                    "('1807', 'Scott McTominay', '451', '0', '21', '3'),\n" +
                    "('1808', 'Lyndon Dykes', '452', '0', '21', '3'),\n" +
                    "('1809', 'Ryan Fraser', '453', '0', '21', '3'),\n" +
                    "('1810', 'Oliver McBurnie', '454', '0', '21', '3'),\n" +
                    "('1811', 'Group E. Poland', '455', '0', '22', '3'),\n" +
                    "('1812', 'Group E. Slovakia', '456', '0', '22', '3'),\n" +
                    "('1813', 'Group E. Spain', '457', '0', '22', '3'),\n" +
                    "('1814', 'Group E. Sweden', '458', '0', '22', '3'),\n" +
                    "('1815', 'Logo Poland', '459', '0', '23', '3'),\n" +
                    "('1816', 'Wojciech Szczęsny', '460', '0', '23', '3'),\n" +
                    "('1817', 'Łukasz Fabiański', '461', '0', '23', '3'),\n" +
                    "('1818', 'Jan Bednarek', '462', '0', '23', '3'),\n" +
                    "('1819', 'Bartosz Bereszyński', '463', '0', '23', '3'),\n" +
                    "('1820', 'Kamil Glik', '464', '0', '23', '3'),\n" +
                    "('1821', 'Tomasz Kędziora', '465', '0', '23', '3'),\n" +
                    "('1822', 'Arkadiusz Reca', '466', '0', '23', '3'),\n" +
                    "('1823', 'Maciej Rybus', '467', '0', '23', '3'),\n" +
                    "('1824', 'Sebastian Walukiewicz', '468', '0', '23', '3'),\n" +
                    "('1825', 'Jacek Góralski', '469', '0', '23', '3'),\n" +
                    "('1826', 'Kamil Grosicki', '470', '0', '23', '3'),\n" +
                    "('1827', 'Kamil Jóźwiak', '471', '0', '23', '3'),\n" +
                    "('1828', 'Mateusz Klich', '472', '0', '23', '3'),\n" +
                    "('1829', 'Grzegorz Krychowiak', '473', '0', '23', '3'),\n" +
                    "('1830', 'Karol Linetty', '474', '0', '23', '3'),\n" +
                    "('1831', 'Sebastian Szymański', '475', '0', '23', '3'),\n" +
                    "('1832', 'Piotr Zieliński', '476', '0', '23', '3'),\n" +
                    "('1833', 'Robert Lewandowski', '477', '0', '23', '3'),\n" +
                    "('1834', 'Arkadiusz Milik', '478', '0', '23', '3'),\n" +
                    "('1835', 'Krzysztof Piątek', '479', '0', '23', '3'),\n" +
                    "('1836', 'Wojciech Szczęsny / Jan Bednarek', '480', '0', '23', '3'),\n" +
                    "('1837', 'Kamil Glik / Tomasz Kędziora', '481', '0', '23', '3'),\n" +
                    "('1838', 'Kamil Grosicki / Kamil Jóźwiak', '482', '0', '23', '3'),\n" +
                    "('1839', 'Mateusz Klich / Grzegorz Krychowiak', '483', '0', '23', '3'),\n" +
                    "('1840', 'Piotr Zieliński / Robert Lewandowski', '484', '0', '23', '3'),\n" +
                    "('1841', 'Arkadiusz Milik / Krzysztof Piątek', '485', '0', '23', '3'),\n" +
                    "('1842', 'Marek Rodák / Peter Pekarík', '486', '0', '24', '3'),\n" +
                    "('1843', 'Ľubomír Šatka / Milan Škriniar', '487', '0', '24', '3'),\n" +
                    "('1844', 'Ondrej Duda / Marek Hamšík', '488', '0', '24', '3'),\n" +
                    "('1845', 'Patrik Hrošovský / Juraj Kucka', '489', '0', '24', '3'),\n" +
                    "('1846', 'Stanislav Lobotka / Róbert Mak', '490', '0', '24', '3'),\n" +
                    "('1847', 'Albert Rusnák / Róbert Boženík', '491', '0', '24', '3'),\n" +
                    "('1848', 'Logo Slovakia', '492', '0', '24', '3'),\n" +
                    "('1849', 'Marek Rodák', '493', '0', '24', '3'),\n" +
                    "('1850', 'Dominik Greif', '494', '0', '24', '3'),\n" +
                    "('1851', 'Dávid Hancko', '495', '0', '24', '3'),\n" +
                    "('1852', 'Róbert Mazáň', '496', '0', '24', '3'),\n" +
                    "('1853', 'Peter Pekarík', '497', '0', '24', '3'),\n" +
                    "('1854', 'Ľubomír Šatka', '498', '0', '24', '3'),\n" +
                    "('1855', 'Milan Škriniar', '499', '0', '24', '3'),\n" +
                    "('1856', 'Martin Valjent', '500', '0', '24', '3'),\n" +
                    "('1857', 'Denis Vavro', '501', '0', '24', '3'),\n" +
                    "('1858', 'Ondrej Duda', '502', '0', '24', '3'),\n" +
                    "('1859', 'Ján Greguš', '503', '0', '24', '3'),\n" +
                    "('1860', 'Marek Hamšík', '504', '0', '24', '3'),\n" +
                    "('1861', 'Lukáš Haraslín', '505', '0', '24', '3'),\n" +
                    "('1862', 'Patrik Hrošovský', '506', '0', '24', '3'),\n" +
                    "('1863', 'Juraj Kucka', '507', '0', '24', '3'),\n" +
                    "('1864', 'Stanislav Lobotka', '508', '0', '24', '3'),\n" +
                    "('1865', 'Róbert Mak', '509', '0', '24', '3'),\n" +
                    "('1866', 'Albert Rusnák', '510', '0', '24', '3'),\n" +
                    "('1867', 'Róbert Boženík', '511', '0', '24', '3'),\n" +
                    "('1868', 'Michal Ďuriš', '512', '0', '24', '3'),\n" +
                    "('1869', 'Logo Spain', '513', '0', '25', '3'),\n" +
                    "('1870', 'Unai Simón', '514', '0', '25', '3'),\n" +
                    "('1871', 'David de Gea', '515', '0', '25', '3'),\n" +
                    "('1872', 'Daniel Carvajal', '516', '0', '25', '3'),\n" +
                    "('1873', 'José Gayà', '517', '0', '25', '3'),\n" +
                    "('1874', 'Eric García', '518', '0', '25', '3'),\n" +
                    "('1875', 'Jesús Navas', '519', '0', '25', '3'),\n" +
                    "('1876', 'Pau Torres', '520', '0', '25', '3'),\n" +
                    "('1877', 'Sergio Ramos', '521', '0', '25', '3'),\n" +
                    "('1878', 'Sergio Canales', '522', '0', '25', '3'),\n" +
                    "('1879', 'Dani Olmo', '523', '0', '25', '3'),\n" +
                    "('1880', 'Koke', '524', '0', '25', '3'),\n" +
                    "('1881', 'Rodri', '525', '0', '25', '3'),\n" +
                    "('1882', 'Fabián Ruiz', '526', '0', '25', '3'),\n" +
                    "('1883', 'Sergio Busquets', '527', '0', '25', '3'),\n" +
                    "('1884', 'Thiago', '528', '0', '25', '3'),\n" +
                    "('1885', 'Ansu Fati', '529', '0', '25', '3'),\n" +
                    "('1886', 'Álvaro Morata', '530', '0', '25', '3'),\n" +
                    "('1887', 'Gerard Moreno', '531', '0', '25', '3'),\n" +
                    "('1888', 'Mikel Oyarzabal', '532', '0', '25', '3'),\n" +
                    "('1889', 'Ferran Torres', '533', '0', '25', '3'),\n" +
                    "('1890', 'Unai Simón / Jesús Navas', '534', '0', '25', '3'),\n" +
                    "('1891', 'Pau Torres / Sergio Ramos', '535', '0', '25', '3'),\n" +
                    "('1892', 'Dani Olmo / Rodri', '536', '0', '25', '3'),\n" +
                    "('1893', 'Fabián Ruiz / Thiago', '537', '0', '25', '3'),\n" +
                    "('1894', 'Ansu Fati / Álvaro Morata', '538', '0', '25', '3'),\n" +
                    "('1895', 'Gerard Moreno / Ferran Torres', '539', '0', '25', '3'),\n" +
                    "('1896', 'Robin Olsen / Ludwig Augustinsson', '540', '0', '26', '3'),\n" +
                    "('1897', 'Mikael Lustig / Victor Nilsson Lindelöf', '541', '0', '26', '3'),\n" +
                    "('1898', 'Viktor Claesson / Albin Ekdal', '542', '0', '26', '3'),\n" +
                    "('1899', 'Emil Forsberg / Sebastian Larsson', '543', '0', '26', '3'),\n" +
                    "('1900', 'Kristoffer Olsson / Marcus Berg', '544', '0', '26', '3'),\n" +
                    "('1901', 'Alexander Isak / Dejan Kulusevski', '545', '0', '26', '3'),\n" +
                    "('1902', 'Logo Sweden', '546', '0', '26', '3'),\n" +
                    "('1903', 'Robin Olsen', '547', '0', '26', '3'),\n" +
                    "('1904', 'Ludwig Augustinsson', '548', '0', '26', '3'),\n" +
                    "('1905', 'Emil Krafth', '549', '0', '26', '3'),\n" +
                    "('1906', 'Marcus Danielson', '550', '0', '26', '3'),\n" +
                    "('1907', 'Andreas Granqvist', '551', '0', '26', '3'),\n" +
                    "('1908', 'Filip Helander', '552', '0', '26', '3'),\n" +
                    "('1909', 'Pontus Jansson', '553', '0', '26', '3'),\n" +
                    "('1910', 'Mikael Lustig', '554', '0', '26', '3'),\n" +
                    "('1911', 'Victor Nilsson Lindelöf', '555', '0', '26', '3'),\n" +
                    "('1912', 'Viktor Claesson', '556', '0', '26', '3'),\n" +
                    "('1913', 'Albin Ekdal', '557', '0', '26', '3'),\n" +
                    "('1914', 'Emil Forsberg', '558', '0', '26', '3'),\n" +
                    "('1915', 'Sebastian Larsson', '559', '0', '26', '3'),\n" +
                    "('1916', 'Kristoffer Olsson', '560', '0', '26', '3'),\n" +
                    "('1917', 'Mattias Svanberg', '561', '0', '26', '3'),\n" +
                    "('1918', 'Gustav Svensson', '562', '0', '26', '3'),\n" +
                    "('1919', 'Marcus Berg', '563', '0', '26', '3'),\n" +
                    "('1920', 'Alexander Isak', '564', '0', '26', '3'),\n" +
                    "('1921', 'Dejan Kulusevski', '565', '0', '26', '3'),\n" +
                    "('1922', 'Robin Quaison', '566', '0', '26', '3'),\n" +
                    "('1923', 'Group F. France', '567', '0', '27', '3'),\n" +
                    "('1924', 'Group F. Germany', '568', '0', '27', '3'),\n" +
                    "('1925', 'Group F. Hungary', '569', '0', '27', '3'),\n" +
                    "('1926', 'Group F. Portugal', '570', '0', '27', '3'),\n" +
                    "('1927', 'Logo France', '571', '0', '28', '3'),\n" +
                    "('1928', 'Hugo Lloris', '572', '0', '28', '3'),\n" +
                    "('1929', 'Steve Mandanda', '573', '0', '28', '3'),\n" +
                    "('1930', 'Lucas Digne', '574', '0', '28', '3'),\n" +
                    "('1931', 'Lucas Hernández', '575', '0', '28', '3'),\n" +
                    "('1932', 'Presnel Kimpembe', '576', '0', '28', '3'),\n" +
                    "('1933', 'Clément Lenglet', '577', '0', '28', '3'),\n" +
                    "('1934', 'Benjamin Pavard', '578', '0', '28', '3'),\n" +
                    "('1935', 'Dayot Upamecano', '579', '0', '28', '3'),\n" +
                    "('1936', 'Raphaël Varane', '580', '0', '28', '3'),\n" +
                    "('1937', 'Eduardo Camavinga', '581', '0', '28', '3'),\n" +
                    "('1938', 'N’Golo Kanté', '582', '0', '28', '3'),\n" +
                    "('1939', 'Steven Nzonzi', '583', '0', '28', '3'),\n" +
                    "('1940', 'Paul Pogba', '584', '0', '28', '3'),\n" +
                    "('1941', 'Adrien Rabiot', '585', '0', '28', '3'),\n" +
                    "('1942', 'Moussa Sissoko', '586', '0', '28', '3'),\n" +
                    "('1943', 'Kingsley Coman', '587', '0', '28', '3'),\n" +
                    "('1944', 'Olivier Giroud', '588', '0', '28', '3'),\n" +
                    "('1945', 'Antoine Griezmann', '589', '0', '28', '3'),\n" +
                    "('1946', 'Anthony Martial', '590', '0', '28', '3'),\n" +
                    "('1947', 'Kylian Mbappé', '591', '0', '28', '3'),\n" +
                    "('1948', 'Hugo Lloris / Lucas Hernández', '592', '0', '28', '3'),\n" +
                    "('1949', 'Clément Lenglet / Benjamin Pavard', '593', '0', '28', '3'),\n" +
                    "('1950', 'Raphaël Varane / N’Golo Kanté', '594', '0', '28', '3'),\n" +
                    "('1951', 'Paul Pogba / Moussa Sissoko', '595', '0', '28', '3'),\n" +
                    "('1952', 'Kingsley Coman / Olivier Giroud', '596', '0', '28', '3'),\n" +
                    "('1953', 'Antoine Griezmann / Kylian Mbappé', '597', '0', '28', '3'),\n" +
                    "('1954', 'Manuel Neuer / Matthias Ginter', '598', '0', '29', '3'),\n" +
                    "('1955', 'Antonio Rüdiger / Julian Brandt', '599', '0', '29', '3'),\n" +
                    "('1956', 'Emre Can / Julian Draxler', '600', '0', '29', '3'),\n" +
                    "('1957', 'İlkay Gündoğan / Kai Havertz', '601', '0', '29', '3'),\n" +
                    "('1958', 'Joshua Kimmich / Toni Kroos', '602', '0', '29', '3'),\n" +
                    "('1959', 'Serge Gnabry / Timo Werner', '603', '0', '29', '3'),\n" +
                    "('1960', 'Logo Germany', '604', '0', '29', '3'),\n" +
                    "('1961', 'Manuel Neuer', '605', '0', '29', '3'),\n" +
                    "('1962', 'Bernd Leno', '606', '0', '29', '3'),\n" +
                    "('1963', 'Matthias Ginter', '607', '0', '29', '3'),\n" +
                    "('1964', 'Thilo Kehrer', '608', '0', '29', '3'),\n" +
                    "('1965', 'Lukas Klostermann', '609', '0', '29', '3'),\n" +
                    "('1966', 'Robin Koch', '610', '0', '29', '3'),\n" +
                    "('1967', 'Antonio Rüdiger', '611', '0', '29', '3'),\n" +
                    "('1968', 'Jonathan Tah', '612', '0', '29', '3'),\n" +
                    "('1969', 'Julian Brandt', '613', '0', '29', '3'),\n" +
                    "('1970', 'Emre Can', '614', '0', '29', '3'),\n" +
                    "('1971', 'Julian Draxler', '615', '0', '29', '3'),\n" +
                    "('1972', 'Leon Goretzka', '616', '0', '29', '3'),\n" +
                    "('1973', 'İlkay Gündoğan', '617', '0', '29', '3'),\n" +
                    "('1974', 'Kai Havertz', '618', '0', '29', '3'),\n" +
                    "('1975', 'Joshua Kimmich', '619', '0', '29', '3'),\n" +
                    "('1976', 'Toni Kroos', '620', '0', '29', '3'),\n" +
                    "('1977', 'Serge Gnabry', '621', '0', '29', '3'),\n" +
                    "('1978', 'Leroy Sané', '622', '0', '29', '3'),\n" +
                    "('1979', 'Luca Waldschmidt', '623', '0', '29', '3'),\n" +
                    "('1980', 'Timo Werner', '624', '0', '29', '3'),\n" +
                    "('1981', 'Logo Hungary', '625', '0', '30', '3'),\n" +
                    "('1982', 'Péter Gulácsi', '626', '0', '30', '3'),\n" +
                    "('1983', 'Dénes Dibusz', '627', '0', '30', '3'),\n" +
                    "('1984', 'Barnabás Bese', '628', '0', '30', '3'),\n" +
                    "('1985', 'Endre Botka', '629', '0', '30', '3'),\n" +
                    "('1986', 'Attila Fiola', '630', '0', '30', '3'),\n" +
                    "('1987', 'Szilveszter Hangya', '631', '0', '30', '3'),\n" +
                    "('1988', 'Ádám Lang', '632', '0', '30', '3'),\n" +
                    "('1989', 'Willi Orban', '633', '0', '30', '3'),\n" +
                    "('1990', 'Attila Szalai', '634', '0', '30', '3'),\n" +
                    "('1991', 'Zsolt Kalmár', '635', '0', '30', '3'),\n" +
                    "('1992', 'Gergő Lovrencsics', '636', '0', '30', '3'),\n" +
                    "('1993', 'Ádám Nagy', '637', '0', '30', '3'),\n" +
                    "('1994', 'Loic Nego', '638', '0', '30', '3'),\n" +
                    "('1995', 'Dávid Sigér', '639', '0', '30', '3'),\n" +
                    "('1996', 'Dominik Szoboszlai', '640', '0', '30', '3'),\n" +
                    "('1997', 'Filip Holender', '641', '0', '30', '3'),\n" +
                    "('1998', 'Norbert Könyves', '642', '0', '30', '3'),\n" +
                    "('1999', 'Nemanja Nikolics', '643', '0', '30', '3'),\n" +
                    "('2000', 'Roland Sallai', '644', '0', '30', '3'),\n" +
                    "('2001', 'Ádám Szalai', '645', '0', '30', '3'),\n" +
                    "('2002', 'Péter Gulácsi / Endre Botka', '646', '0', '30', '3'),\n" +
                    "('2003', 'Attila Fiola / Ádám Lang', '647', '0', '30', '3'),\n" +
                    "('2004', 'Willi Orban / Attila Szalai', '648', '0', '30', '3'),\n" +
                    "('2005', 'Zsolt Kalmár / Ádám Nagy', '649', '0', '30', '3'),\n" +
                    "('2006', 'Dominik Szoboszlai / Filip Holender', '650', '0', '30', '3'),\n" +
                    "('2007', 'Roland Sallai / Ádám Szalai', '651', '0', '30', '3'),\n" +
                    "('2008', 'Rui Patrício / João Cancelo', '652', '0', '31', '3'),\n" +
                    "('2009', 'Pepe / Raphaël Guerreiro', '653', '0', '31', '3'),\n" +
                    "('2010', 'Rúben Dias / Bernardo Silva', '654', '0', '31', '3'),\n" +
                    "('2011', 'Bruno Fernandes / Danilo Pereira', '655', '0', '31', '3');"
        )
    }
}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "INSERT INTO \"CategoryEntity\" (\"uid\", \"name\") VALUES\n" +
                    "('2', 'Group A Celebrations'),\n" +
                    "('7', 'Group B Celebrations'),\n" +
                    "('12', 'Group C Celebrations'),\n" +
                    "('17', 'Group D Celebrations'),\n" +
                    "('22', 'Group E Celebrations'),\n" +
                    "('27', 'Group F Celebrations');"
        )
    }
}
