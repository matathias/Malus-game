function classMat = plot_lvl_data(class, maxLevel)

levels = 1:1:maxLevel;
XP = 100 * power(1.15, (levels/1.5)) - 50;

if strcmp(class, 'Commando')
    HP = 80 * power(1.75, (levels/5));
    EP = 30 * power(1.75, (levels/5));
    Dam = 5 * power(2, (levels/5)) + (levels*10) - 5;
elseif strcmp(class, 'Berserker')
    HP = 40 * power(1.75, (levels/5));
    EP = 20 * power(1.75, (levels/5));
    Dam = 10 * power(2, (levels/5)) + (levels*20) - 10;
elseif strcmp(class, 'Sentinel')
    HP = 160 * power(1.75, (levels/5));
    EP = 20 * power(1.75, (levels/5));
    Dam = 2.5 * power(2, (levels/5)) + (levels*5) - 2.5;
elseif strcmp(class, 'Ravager')
    HP = 50 * power(1.75, (levels/5));
    EP = 100 * power(1.75, (levels/5));
    Dam = 8 * power(2, (levels/5)) + (levels*17) - 8;
elseif strcmp(class, 'Reliever')
    HP = 130 * power(1.75, (levels/5));
    EP = 80 * power(1.75, (levels/5));
    Dam = 4 * power(2, (levels/5)) + (levels*6) - 4;
else
    HP = 60 * power(1.75, (levels/5));
    EP = 20 * power(1.75, (levels/5));
    Dam = 3 * power(2, (levels/5)) + (levels*6) - 3;
end
    
classMat = [levels; XP; HP; EP; Dam];

fileName = [class, '_', maxLevel, '.csv'];
dlmwrite(fileName, classMat);

plotTitle = [class, ' Level Curves'];

p = plot(levels, XP, 'k', levels, HP, 'g', levels, EP, 'b', levels, Dam, 'r');
title(plotTitle);
xlabel('Level');
ylabel('Function Value');
leg = legend('Experience', 'HP', 'EP', 'Damage');
set(leg, 'Location', 'NorthWest');