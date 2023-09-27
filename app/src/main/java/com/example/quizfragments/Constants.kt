package com.example.quizfragments



object Constants{

    fun getQuestions(): ArrayList<Question>{


        val questionList = ArrayList<Question>()


        val question1 = Question(
            id = 1,
            question = "Who is the current reigning Formula 1 World Champion?",
            optionOne = "Lewis Hamilton",
            optionTwo = "Sebastian Vettel",
            optionThree = "Max Verstappen",
            correctAnswer = 1
        )
        questionList.add(question1)

        val question2 = Question(
            id = 2,
            question = "Which team is known for its distinctive red cars in Formula 1?",
            optionOne = "McLaren",
            optionTwo = "Red Bull Racing",
            optionThree = "Scuderia Ferrari",
            correctAnswer = 3
        )
        questionList.add(question2)

        val question3 = Question(
            id = 3,
            question = "What is the highest number of World Drivers' Championships won by a single driver?",
            optionOne = "5",
            optionTwo = "7",
            optionThree = "8",
            correctAnswer = 2
        )
        questionList.add(question3)

        val question4 = Question(
            id = 4,
            question = "Which race is often referred to as 'The Monaco Grand Prix'?",
            optionOne = "Circuit of the Americas",
            optionTwo = "Circuit de Spa-Francorchamps",
            optionThree = "Circuit de Monaco",
            correctAnswer = 3
        )
        questionList.add(question4)

        val question5 = Question(
            id = 5,
            question = "Which country is home to the Silverstone Circuit?",
            optionOne = "United States",
            optionTwo = "United Kingdom",
            optionThree = "Germany",
            correctAnswer = 2
        )
        questionList.add(question5)

        val question6 = Question(
            id = 6,
            question = "What is the term for a Formula 1 car's top speed during a race?",
            optionOne = "Lap speed",
            optionTwo = "Terminal velocity",
            optionThree = "Maximum power",
            correctAnswer = 2
        )
        questionList.add(question6)

        val question7 = Question(
            id = 7,
            question = "Which driver holds the record for the most pole positions in Formula 1?",
            optionOne = "Ayrton Senna",
            optionTwo = "Lewis Hamilton",
            optionThree = "Michael Schumacher",
            correctAnswer = 2
        )
        questionList.add(question7)

        val question8 = Question(
            id = 8,
            question = "Which team introduced the 'double diffuser' innovation in 2009?",
            optionOne = "Ferrari",
            optionTwo = "McLaren",
            optionThree = "Brawn GP",
            correctAnswer = 3
        )
        questionList.add(question8)

        val question9 = Question(
            id = 9,
            question = "What is DRS in Formula 1?",
            optionOne = "Driver Racing System",
            optionTwo = "Drag Reduction System",
            optionThree = "Downforce Recovery System",
            correctAnswer = 2
        )
        questionList.add(question9)

        val question10 = Question(
            id = 10,
            question = "How many laps are typically in a Formula 1 race?",
            optionOne = "30",
            optionTwo = "60",
            optionThree = "Varies by circuit",
            correctAnswer = 3
        )
        questionList.add(question10)

        val question11 = Question(
            id = 11,
            question = "What is the FIA in Formula 1?",
            optionOne = "Formula 1 International Association",
            optionTwo = "Fédération Internationale de l'Automobile",
            optionThree = "Formula 1 Inspection Agency",
            correctAnswer = 2
        )
        questionList.add(question11)

        val question12 = Question(
            id = 12,
            question = "Which driver famously came out of retirement to win the 1994 Formula 1 World Championship?",
            optionOne = "Alain Prost",
            optionTwo = "Nigel Mansell",
            optionThree = "Michael Schumacher",
            correctAnswer = 3
        )
        questionList.add(question12)

        val question13 = Question(
            id = 13,
            question = "Which race is known for its long straights and high-speed nature?",
            optionOne = "Canadian Grand Prix",
            optionTwo = "Italian Grand Prix",
            optionThree = "Australian Grand Prix",
            correctAnswer = 2
        )
        questionList.add(question13)

        val question14 = Question(
            id = 14,
            question = "What does 'DRS Zone' refer to during a Formula 1 race?",
            optionOne = "A section of the track where the Drag Reduction System can be used",
            optionTwo = "The pit lane",
            optionThree = "The safety car zone",
            correctAnswer = 1
        )
        questionList.add(question14)

        val question15 = Question(
            id = 15,
            question = "Which team is nicknamed 'The Silver Arrows'?",
            optionOne = "Red Bull Racing",
            optionTwo = "Mercedes-AMG Petronas Formula One Team",
            optionThree = "McLaren",
            correctAnswer = 2
        )
        questionList.add(question15)

        val question16 = Question(
            id = 16,
            question = "Who was the first American driver to win a Formula 1 race?",
            optionOne = "Mario Andretti",
            optionTwo = "Dan Gurney",
            optionThree = "Michael Andretti",
            correctAnswer = 1
        )
        questionList.add(question16)

        val question17 = Question(
            id = 17,
            question = "What is the purpose of the Safety Car in Formula 1?",
            optionOne = "To lead the race during wet conditions",
            optionTwo = "To provide medical assistance if needed",
            optionThree = "To slow down the field in case of danger on the track",
            correctAnswer = 3
        )
        questionList.add(question17)

        val question18 = Question(
            id = 18,
            question = "What is the term for a pit stop where all four tires are changed?",
            optionOne = "Quick stop",
            optionTwo = "Full service stop",
            optionThree = "Fast tire change",
            correctAnswer = 2
        )
        questionList.add(question18)

        val question19 = Question(
            id = 19,
            question = "Which Formula 1 race is known for its unpredictable weather conditions?",
            optionOne = "Japanese Grand Prix",
            optionTwo = "Brazilian Grand Prix",
            optionThree = "Russian Grand Prix",
            correctAnswer = 2
        )
        questionList.add(question19)

        val question20 = Question(
            id = 20,
            question = "Which legendary Brazilian driver won three Formula 1 World Championships during his career?",
            optionOne = "Ayrton Senna",
            optionTwo = "Nelson Piquet",
            optionThree = "Emerson Fittipaldi",
            correctAnswer = 1
        )
        questionList.add(question20)

        val question21 = Question(
            id = 21,
            question = "Which Formula 1 driver is known as 'The Iceman'?",
            optionOne = "Valtteri Bottas",
            optionTwo = "Nico Rosberg",
            optionThree = "Kimi Räikkönen",
            correctAnswer = 3
        )
        questionList.add(question21)

        val question22 = Question(
            id = 22,
            question = "Which circuit is famous for its 'Eau Rouge' corner?",
            optionOne = "Circuit of the Americas",
            optionTwo = "Circuit de Spa-Francorchamps",
            optionThree = "Monza Circuit",
            correctAnswer = 2
        )
        questionList.add(question22)

        val question23 = Question(
            id = 23,
            question = "Who is the youngest Formula 1 World Champion in history?",
            optionOne = "Sebastian Vettel",
            optionTwo = "Max Verstappen",
            optionThree = "Lewis Hamilton",
            correctAnswer = 1
        )
        questionList.add(question23)

        val question24 = Question(
            id = 24,
            question = "Which team's car is often referred to as the 'Pink Panther'?",
            optionOne = "Alpine F1 Team",
            optionTwo = "Aston Martin Cognizant Formula One Team",
            optionThree = "AlphaTauri",
            correctAnswer = 2
        )
        questionList.add(question24)

        val question25 = Question(
            id = 25,
            question = "In which year did Michael Schumacher make his Formula 1 debut?",
            optionOne = "1991",
            optionTwo = "1994",
            optionThree = "1997",
            correctAnswer = 1
        )
        questionList.add(question25)

        val question26 = Question(
            id = 26,
            question = "Which city hosts the Abu Dhabi Grand Prix?",
            optionOne = "Dubai",
            optionTwo = "Abu Dhabi",
            optionThree = "Doha",
            correctAnswer = 2
        )
        questionList.add(question26)

        val question27 = Question(
            id = 27,
            question = "What is the term for the area where Formula 1 cars are prepared before a race?",
            optionOne = "Pit stop",
            optionTwo = "Garage",
            optionThree = "Paddock",
            correctAnswer = 3
        )
        questionList.add(question27)

        val question28 = Question(
            id = 28,
            question = "Which team's cars feature the 'Bull' logo?",
            optionOne = "Red Bull Racing",
            optionTwo = "Scuderia Ferrari",
            optionThree = "Alpine F1 Team",
            correctAnswer = 1
        )
        questionList.add(question28)

        val question29 = Question(
            id = 29,
            question = "What is the name of the first race of the Formula 1 season?",
            optionOne = "Australian Grand Prix",
            optionTwo = "Monaco Grand Prix",
            optionThree = "British Grand Prix",
            correctAnswer = 1
        )
        questionList.add(question29)

        val question30 = Question(
            id = 30,
            question = "Who holds the record for the most consecutive World Drivers' Championships?",
            optionOne = "Lewis Hamilton",
            optionTwo = "Michael Schumacher",
            optionThree = "Sebastian Vettel",
            correctAnswer = 2
        )
        questionList.add(question30)




        return questionList
    }

}