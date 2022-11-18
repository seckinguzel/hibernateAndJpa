package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;
//hibernate ile bir session factory oluşturuyorduk. JPA ilk başlarda bir veri erişim tekniği yani orm gibi çıkmışken sonradan java da bir standart haline geliyor yani hibernate ve spring bunu standart olarak implement ediyor. bunu implement etmesinin sebebi biz hızlı bir şekilde hangi iplementasyonu istiyorsak ona geçebiliyoruz yani istersek hibernate veya bir başkası. yani biz bu noktada hibernate de oluşturduğumuz session factory ve session nesnesi burada otomatik olarak injection ile oluşacak jpa'yı kullanarak. 
@Repository //biz yarın öbürgün hibernate yerine başka bir orm'e geçersek repository'im bu anotasyonu buradan silip repository'im öbürüdür dediğinde otomatik olarak ona geçmiş olacak.
public class HibernateCityDal implements ICityDal{
	
	private EntityManager entityManager; //burada session factory ve session nesnesini EntityManager ile yönetiyoruz. entityManager'ı tanımladıktan sonra constructor'ını oluşturuyoruz.
	
	@Autowired //entity manager'ımızı enjekte ettik. biz burada hibernate kullanıyoruz ve bu anotasyon bizim için otomatik olarak hibernate injection'ınını geliştircek.
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(city);
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		return city;
	}

}
