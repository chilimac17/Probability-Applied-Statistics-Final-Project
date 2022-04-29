Array = csvread('Salter.csv');
xVal = Array(:, 1);
yVal = Array(:, 2);

plot(xVal,yVal)
xlabel('X Values','FontSize',15)
ylabel('Y Values','FontSize',15)
title('\it{Salted Data}','FontSize',15)