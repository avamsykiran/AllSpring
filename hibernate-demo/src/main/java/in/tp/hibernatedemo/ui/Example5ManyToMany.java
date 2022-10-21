package in.tp.hibernatedemo.ui;

import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import in.tp.hibernatedemo.models.manytomany.Artist;
import in.tp.hibernatedemo.models.manytomany.Movie;

public class Example5ManyToMany {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.manytomany.Artist.class);
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.manytomany.Movie.class);

		StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
		srBuilder.applySettings(conf.getProperties());

		StandardServiceRegistry serviceRegistry = srBuilder.build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session session = sf.openSession();
		Transaction txn= session.beginTransaction();
		
		Artist a1 = new Artist(101,"Prabhu Deva",new TreeSet<Movie>());
		Artist a2 = new Artist(102,"Surya",new TreeSet<Movie>());
		Artist a3 = new Artist(101,"Tammanah",new TreeSet<Movie>());
		
		Movie m1 = new Movie(101,"Abhinatri" ,new TreeSet<Artist>() );
		Movie m2 = new Movie(101,"Veedokkadey" ,new TreeSet<Artist>() );
		
		m1.getArtists().add(a1);
		m1.getArtists().add(a3);
		
		m2.getArtists().add(a2);
		m2.getArtists().add(a3);
		
		a1.getMovies().add(m1);
		a2.getMovies().add(m2);
		a3.getMovies().add(m1);
		a3.getMovies().add(m2);
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		txn.commit();
		System.out.println("Emp Saved!");
		
		session.close();
	}

}
