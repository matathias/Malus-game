function [] = game_Data(lvl)

com = plot_lvl_data('Commando',lvl);
ber = plot_lvl_data('Berserker',lvl);
sen = plot_lvl_data('Sentinel',lvl);
rav = plot_lvl_data('Ravager',lvl);
rel = plot_lvl_data('Reliever',lvl);
ent = plot_lvl_data('Entreprenuer',lvl);

total = [com; ber; sen; rav; rel; ent];
dlmwrite('All_Classes.csv',total,'precision','%5.0f');