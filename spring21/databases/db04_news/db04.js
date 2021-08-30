/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 04 - dbo4.js (mongodb queries)
 * Student(s) Name(s):Tj Virbick, Rob Nelson, Letitia Fickling
 */


use articles


// TO DO 1: The total number of documents in the collection
    print("The total number of documents in the collection is: ") 
    db.articles.count()


// TO DO 2:  All articles from a given author (picked from your collection), sorted alphabetically.
    print("List all articles from a given author (picked from your collection), sorted alphabetically: ") 
        db.articles.find({author: "tbd"}).sort({"author": 1})


// TO DO 3: The total number of articles per article source (name), also alphabetically
    print("List the total number of articles per article source (name), also alphabetically: ") 
       
        db.articles.aggregate([
            {$group:{
                _id: '$source.name',
                total: {
                    $sum: 1
                }
                }
            },
            {$sort: {
                _id: 1
                }
            }
        ])

    

// TO DO 4: All articles having a specific word (picked from your collection) in their content.
    print("List all articles having a specific word (significant) in their content: ") 
        db.articles.find({content : {$regex: 'significant'}})
        //db.articles.find({content : {$regex: 'significant'}}, { author: 1, title: 1, description: 1, _id: 0 })

// TO DO 5: A different query created by you.
    print("My Query: less than 15 articles published since the begining of 2015 ordered by most recent excluding a bunch of useless fields") 
        db.articles.aggregate([
            {$match:{"publishedAt": {"$gte": ISODate("2015-01-01T00:00:00.000Z")}}},
            {$project: {"source.id": 0, "urlToImage": 0, "content": 0, _id:0}},
            {$sort: {publishedAt: -1}},
            {$limit: 15}
        ])

    