public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67 * Math.pow(10, -11);//declare a constant


    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    //constructor: take in a Planet object and initialize an identical Planet object
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double r_2 = dx * dx + dy * dy;
        double distance = Math.sqrt(r_2);
        return distance;
    }

    public double calcForceExertedBy(Planet p){
        //double G = 6.67 * Math.pow(10, -11);
        double distance = calcDistance(p);
        double force = (G * p.mass * this.mass) / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        double force = calcForceExertedBy(p);
        double forcex = force * dx / r;
        return forcex;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        double force = calcForceExertedBy(p);
        double forcex = force * dy / r;
        return forcex;
    }
    
    public double calcNetForceExertedByX(Planet[] planets){
        double force = 0.0;
        for(Planet p : planets){
            //enhanced for loop
            if(p == this){
                continue;
            }
            else{
                force += calcForceExertedByX(p);
            }
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double force = 0.0;
        for(Planet p : planets){
            //enhanced for loop
            if(this.equals(p)){
                continue;
            }
            else{
                force += calcForceExertedByY(p);
            }
        }
        return force;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += aX * dt;
        this.yyVel += aY * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw(){
        String filename = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filename);
    }
}