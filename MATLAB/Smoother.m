Array = csvread('Salter.csv');
xVal = Array(:, 1);
yVal = Array(:, 2);
smoothData = smoothdata(yVal);

plot(xVal,smoothData)
xlabel('X Values','FontSize',15)
ylabel('Y Values','FontSize',15)
title('\it{Smooth Data}','FontSize',15)