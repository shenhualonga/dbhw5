package edu.neu.cs5200.hw5.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/site")
public class SiteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cs5200hw5");
	EntityManager em = null;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteId)
	{
		Site site = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		site = em.find(Site.class, siteId);
		em.getTransaction().commit();
		em.close();
		return site;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites()
	{
		List<Site> sites = new ArrayList<Site>();
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("select site from Site site");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return sites;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site)
	{
		List<Site> sites = new ArrayList<Site>();
		em = factory.createEntityManager();
		em.getTransaction().begin();

		site.setId(siteId);
		em.merge(site);
		
		Query query = em.createQuery("select site from Site site");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		return sites;
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int siteId) 
	{
		List<Site> sites = new ArrayList<Site>();

		Site site = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		site = em.find(Site.class, siteId);
		em.remove(site);
		
		Query query = em.createQuery("select site from Site site");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		
		return sites;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site)
	{
		List<Site> sites = new ArrayList<Site>();
		em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(site);
		Query query = em.createQuery("select site from Site site");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		return sites;
	}
	
	public static void main(String[] arg)
	{
		SiteDAO dao = new SiteDAO();
//		Site newSite = new Site(null, "newsite2", 12.2332, 234.2322);
		
//		List<Site> sites = dao.createSite(newSite);
		List<Site> sites = dao.findAllSites();
		for (Site site : sites)
		{
			System.out.println(site.getName());
		}
	}
}
