from flask import Flask,render_template,request, url_for, redirect
import pyrebase
name,selected_contacts,lastname,Address,jewellery=[],[],[],[],[]
jewellery_contacts, miniature_painting_contacts, carpets_contacts = [], [], []
metalworks_contacts, pottery_contacts, fabrics_contacts, leather_contacts = [], [], [], []
wooden_articles_contacts = []

name,selected_contacts,lastname,Address,jewellery=[],[],[],[],[]
config = {
    "apiKey": "AIzaSyDUqsnKTfCSJksSCIvr_nWWblUAOrUB9HI",
    "authDomain": "hackathon-udaipur.firebaseapp.com",
    "databaseURL": "https://hackathon-udaipur.firebaseio.com",
    "projectId": "hackathon-udaipur",
    "storageBucket": "hackathon-udaipur.appspot.com",
    "messagingSenderId": "910037888580"
}
firebase = pyrebase.initialize_app(config)
auth = firebase.auth()

# Log the user in
user = auth.sign_in_with_email_and_password('user1@gmail.com', 'user123')


db = firebase.database()

app=Flask(__name__)
@app.route('/')
def home():
    return render_template('MinistryLogin.html')

@app.route('/vendorform', methods=['POST'])
def quiz_answers():
    q1 = request.form['firstname']
    q2 = request.form['lastname']
    q3 = request.form['Shop Address']
    if request.method == "POST":
        q4 = request.form.getlist("Jewellery")
        q5 = request.form.getlist("Paintings")
        q6 = request.form.getlist("Carpets")
        q7 = request.form.getlist("MetalWorks")
        q8 = request.form.getlist("pottery_contacts")
        q9 = request.form.getlist("Fabric Works")
        q10 = request.form.getlist("Leather Wear")
        q11 = request.form.getlist("Wooden Articles")
    name.append(q1)
    lastname.append(q2)
    Address.append(q3)
    data ={"Name": q1, "lastname": q2,"Address": q3, "Jewellery": q4,"Miniature Paintings":q5,"Carpets" : q6,"MetalWorks" : q7,"Pottery" : q8,"Fabric Works" : q9,"Leather Wear" : q10,"Wooden Articles" : q11}
    results = db.child("users").push(data,user['idToken'])
    return render_template('thankyou.html', Jewellery = jewellery_contacts,
            painting = miniature_painting_contacts, carpet = carpets_contacts,
            metalworks = metalworks_contacts, pottery = pottery_contacts,
            fabric = fabrics_contacts, leather = leather_contacts,
            wooden_articles = wooden_articles_contacts)

@app.route('/admin')
def print_ans():
    return render_template('vendorsell.html',names=name,lastnames=lastname,N=len(name),a=Address,j=jewellery,c=len(jewellery))

if __name__ == '__main__':
    app.run(debug=True)
